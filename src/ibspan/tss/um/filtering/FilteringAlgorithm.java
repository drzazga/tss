/*****************************************************************
 Agent-based Travel Support System
 Copyright (C) 2006 Maciej Gawinecki & Pawel Kaczmarek 

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor,  Boston, MA  
 02110-1301, USA.
 *****************************************************************/
package ibspan.tss.um.filtering;

import ibspan.tss.core.semantic.AnonymousResourceException;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.semantic.Util;
import ibspan.tss.dao.ProfileDAO;
import ibspan.tss.um.ontology.Classification;
import ibspan.tss.um.ontology.Opinion;
import ibspan.tss.um.ontology.RatedResult;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.statistics.StatisticCalculator;
import ibspan.tss.um.stereotyping.StereotypingAlgorithm;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.ibm.adtech.jastor.JastorException;

/**
 * The class realize personalization of restaraunts list using filtering
 * algorithm. The algorithm exploite the user myProfile in the following order:
 * <ol>
 * <li>For whole set of results rate each restaurant identified by root node R
 * accordingly to the definition of temperature of potential interest (see [1]
 * for details).
 * <ol>
 * <li>(a) Calculate statistics (number of occurence) for reflection of each
 * resource in R-subgraph.
 * <li>Compute temperature for each R-subgraph.
 * </ol>
 * <li>Compute level L for rated restaurants.
 * <li>Throw away restaurants with temperature below the level L.
 * <li>Sort restaurants descendingly according to the assigned temperatures
 * (results will be sorted by view transforming service)
 * </ol>
 * 
 * The algorithm is described in detail in [1], it corrects solutions presented
 * in [2] and is inspired by works [3,4].
 * 
 * <ol>
 * <li>"Exploitation of User Profile in Travel Support System -- Ontology-based
 * Filtering Algorithm", Technical Report, Maciej Gawinecki, August 10, 2006
 * (attached)
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/Gawinecki_MS_2005.pdf">"Modelling
 * User on the Basis of Interactions with a WWW Based System"</a>, Maciej
 * Gawinecki, Adam Mickiewicz University, Poznan. 2005.
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/PIPS_2005_MMP.pdf">"Ontology-based
 * Stereotyping in a Travel Support System."</a> Maciej Gawinecki, Mateusz
 * Kruszyk, and Marcin Paprzycki. In Proceedings of the XXI Fall Meeting of
 * Polish Information Processing Society. 2005.
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/IDEA_2006.pdf">"Utilizing
 * Semantic Web and Software Agents in a Travel Support System"</a>. In
 * "Semantic Web Technologies and eBusiness: Virtual Organization and Business
 * Process Automation." Maria Ganzha, Maciej Gawinecki, Marcin Paprzycki, Rafal
 * Gasiorowski, Szymon Pisarek, and Wawrzyniec Hyska. Editted by A. F. Salam and
 * Jason Stevens. Idea Publishing Group. 2006.
 * </ol>
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class FilteringAlgorithm {

	private static Logger logger = Logger.getMyLogger(StereotypingAlgorithm.class.getName());

	// User profile which will be used as a base for filtering.
	private UserProfile myProfile;
	// Model with domain ontology.
	private OntModel mDomain;
	// DAO objects to operate on profile.
	private ProfileDAO daoProfile;

	/**
	 * Predefined constant configures influence of normalized probability on
	 * temperature of single opinion.
	 */
	public static final double ALPHA = 0.4;

	/**
	 * Predefined constant configures influence of UserContext onto temperature
	 * of single opinion.
	 */
	public static final double BETA = 3;
	
	/**
	 * Constructs FilteringAlgorithm.
	 * 
	 * @param myProfile
	 *            user profile which will be used a base for filtering
	 * @param mDomain
	 *            ontology of domain, to which references results which are to
	 *            be filtered, i.e. ont
	 * @throws UserModellingDomainAccessException 
	 * @throws JastorException
	 */
	public FilteringAlgorithm(UserProfile profile, OntModel mDomain) {
		this.myProfile = profile;
		this.mDomain = mDomain;
		daoProfile = new ProfileDAO(profile.model());
	}

	/**
	 * Filters given results according to the user myProfile and the given context
	 * of user behaviour. In fact, it removes from results Memory those who are
	 * rated too low.
	 * 
	 * @param results
	 *            results to be filtered
	 * @param context
	 *            context of user behaviour
	 * @return the memory without not interesting results
	 */
	public Memory filter(Memory results, ibspan.tss.messaging.ontology.Map context) throws AnonymousResourceException {
		try {
			List<RatedResult> resultsList = UserModellingFactory
					.getAllRatedResult(results.getModel());
			
			
			rate(resultsList, context);
			//results.getModel().write(System.out,"N3");
			
			// Compute temperature level of accepting restaurant in results.
			double level;
			{
				double[] population = new double[resultsList.size()];
				int i = 0;
				for (Iterator<RatedResult> it = resultsList.iterator(); it
						.hasNext();) {
					population[i++] = it.next().getHasTemperature();
				}
				level = StatisticCalculator.expectedValue(population);
			}

			// Throw away restaraurants with level below the level.
			logger.info("Level of acceptance = " + level);
			{
				for (Iterator<RatedResult> it = resultsList.iterator(); it
						.hasNext();) {
					RatedResult rr = it.next();
					if (rr.getHasTemperature() < level)
						results.removeThing(rr);
				}
			}
		} catch (JastorException e) {
			throw new RuntimeException("Problem with accessing results or myProfile.", e);
		} 

		return results;
	}

	/**
	 * Rates given results according to the user myProfile and the context.
	 * 
	 * @param resultsList
	 *            results to be rated
	 * @param context
	 *            context of current user behaviour
	 * @return rated results
	 */
	private List<RatedResult> rate(List<RatedResult> resultsList,
			ibspan.tss.messaging.ontology.Map context) {

		List<RatedResult> ratedList = new ArrayList<RatedResult>();
		try {
			for (Iterator<RatedResult> it = resultsList.iterator(); it.hasNext();) {
				RatedResult result = it.next();
				double temp = getTempOfResource(result.getOfObject().resource(), context);
				result.setHasTemperature(temp);
				logger.fine("Restaurant " + result.getOfObject().resource().getURI() + " rated at: " + temp);
			}
			return ratedList;
		} catch (JastorException e) {
			throw new RuntimeException("Problem with accessing temperature of RatedResult.", e);
			
		}
	}

	/**
	 * Calculates statistic map for <i>root</i>-subgraph.
	 * 
	 * @param root
	 *            root of the subgraph
	 * @return statistics map bounds URI of reflected resource with number of
	 *         occurencies of it not reflected form.
	 */
	private Map<String, Integer> getStatistics(Resource root) {
		Map<String, Integer> stats = new HashMap<String, Integer>();
		List<Resource> visitedRoots = new ArrayList<Resource>();
		calcStatistics(root, stats, visitedRoots);
		return stats;
	}

	// The class for comparing RatedResults
	private class ResultComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			try {
				RatedResult r1 = (RatedResult) o1;
				RatedResult r2 = (RatedResult) o2;
				double temp1 = r1.getHasTemperature();
				double temp2 = r2.getHasTemperature();
				return temp1 < temp2 ? -1 : temp1 > temp2 ? 1 : 0;
			} catch (JastorException e) {
				throw new RuntimeException("Problem with accessing <hasTemperature> property of <RateResult>: ", e);
			}

		}

	}

	/**
	 * Updates statistics for particular resource.
	 * 
	 * @param r
	 *            URI of the resource
	 * @param stats
	 *            statistics which will be updated
	 */
	private void updateStatisticsForResource(final String r, Map<String, Integer> stats) {
		Integer many = stats.get(r);
		if (many != null)
			stats.put(r, ++many);
		else
			stats.put(r, 1);
	}

	/**
	 * Calculates statistics for <i>root</i>-subgraph. The method works
	 * recursively for each subgraph or <i>root</i>-graph.
	 * 
	 * @param root
	 *            root of subgraph
	 * @param stats
	 *            statistics to be be updated
	 * @param visitedRoots
	 *            roots of subgraphs which were already visited in recursive
	 *            process
	 */
	private void calcStatistics(final Resource root, Map<String, Integer> stats,
			List<Resource> visitedRoots) {
		Resource reflected;

		visitedRoots.add(root);

		OntModel model = (OntModel) root.getModel();

		reflected = Util.getReflection(root, model, mDomain);
		if (reflected != null) {

			updateStatisticsForResource(reflected.getURI(), stats);

			// find next roots
			StmtIterator si = root.listProperties();
			while (si.hasNext()) {
				Statement s = si.nextStatement();

				// concive subject
				reflected = Util.getReflection(s.getSubject(), model, mDomain);
				if (reflected != null)
					updateStatisticsForResource(reflected.getURI(), stats);

				// .. predicate
				reflected = Util.getReflection(s.getPredicate(), model, mDomain);
				if (reflected != null)
					updateStatisticsForResource(reflected.getURI(), stats);

				// ... object
				RDFNode nextRoot = s.getObject();

				// object of property cannot be Literal to move further in
				// searching
				if (nextRoot instanceof Resource
						&& !visitedRoots.contains(nextRoot))
					calcStatistics((Resource) nextRoot, stats, visitedRoots);
			}
		}
	}

	/**
	 * Returns potential interest "temperature" of single resource on the base
	 * of (1) occurence of this resource in the user context and (2) user
	 * opinion about this resource.
	 * 
	 * @param r
	 *            resource for which temperature is measured
	 * @param context
	 *            context of current user behaviour
	 * @return temperature of resource
	 */
	private double getTempOfResource(Resource r, ibspan.tss.messaging.ontology.Map context) {

			Map<String, Integer> stats = getStatistics(r);

			Map mappedContext = Util.getMap(context);
		try {
			double temp = 0;
			for (Iterator<String> it = stats.keySet().iterator(); it.hasNext();) {
				String conceptURI = it.next();
				Integer many = stats.get(conceptURI);
				Opinion op = daoProfile.getUserOpinionAbout(myProfile.getHasUserID(), conceptURI);
				boolean isInContext = mappedContext.keySet().contains(conceptURI)
						|| mappedContext.values().contains(conceptURI);
				double contextBoost = isInContext ? BETA : 1;
				temp += contextBoost * many * getTempFromOpinion(op);
			}
			return temp;
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access opinion of user myProfile.",e);
		}
	}

	/**
	 * Returns potential interest "temperature" from the given opinion about
	 * resource.
	 * 
	 * @param op
	 *            opinion
	 * @return temperature calculated from the opinion
	 */
	private double getTempFromOpinion(Opinion op) {
		double temp = 0.0;
		try {
			if (op == null || op.getHasClassification() == null || op.getHasClassification().resource().equals(Classification.NotInteresting))
			// There is no opinion about particular concept or this concept is
			// not significantly interesting to the user.
				temp = 0.0;
			else if (op.getHasClassification().resource().equals(Classification.Interesting))
			// The concept is significanlty interesting to the user.
				temp = 1.0;
			else
				// FIXME: this should be changed into inferred probability but the
				// learning phase for this probabiliy is not done yet.
				temp = ALPHA * op.getAtNormalizedProbability();
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access classification of opinion.",e);
		}		
		return temp;

	}
}
