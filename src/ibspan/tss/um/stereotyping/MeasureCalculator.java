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
package ibspan.tss.um.stereotyping;

import ibspan.tss.um.ontology.Interval;
import ibspan.tss.um.ontology.IntervalDomain;
import ibspan.tss.um.ontology.IntervalSet;
import ibspan.tss.um.ontology.Measure;
import ibspan.tss.um.ontology.MeasureDomain;
import ibspan.tss.um.ontology.MeasureSet;
import ibspan.tss.um.ontology.Nominal;
import ibspan.tss.um.ontology.NominalSet;
import ibspan.tss.um.ontology.Ordinal;
import ibspan.tss.um.ontology.OrdinalSet;
import ibspan.tss.um.ontology.UserModellingFactory;
import jade.util.Logger;

import java.util.HashMap;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.JastorException;
import com.ibm.adtech.jastor.Thing;

/**
 * This class provides methods for calculating between distance between
 * compatible pairs of indivdual measure (interval, ordinal and nominal type)
 * and set measure (set of intervals, set of ordinals, set of nominals). More
 * details and equations can be found in [1,2,3].
 * 
 * <ol>
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/PIPS_2005_MMP.pdf">"Ontology-based
 * Stereotyping in a Travel Support System."</a> Maciej Gawinecki, Mateusz
 * Kruszyk, and Marcin Paprzycki. In Proceedings of the XXI Fall Meeting of
 * Polish Information Processing Society. 2005.
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/Gawinecki_MS_2005.pdf">"Modelling
 * User on the Basis of Interactions with a WWW Based System"</a>, Maciej
 * Gawinecki, Adam Mickiewicz University, Poznan. 2005.
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/IDEA_2006.pdf">"Utilizing
 * Semantic Web and Software Agents in a Travel Support System"</a>. In
 * "Semantic Web Technologies and eBusiness: Virtual Organization and Business
 * Process Automation." Maria Ganzha, Maciej Gawinecki, Marcin Paprzycki, Rafa?
 * Gasiorowski, Szymon Pisarek, and Wawrzyniec Hyska. Editted by A. F. Salam and
 * Jason Stevens. Idea Publishing Group. 2006.
 * </ol>
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class MeasureCalculator {

	private static Logger logger = Logger.getMyLogger(MeasureCalculator.class.getName());
	
	// Containts size of domain (number of possible values) for the measure of
	// given URI reference.
	private HashMap<String, Integer> domainSizeCache = new HashMap<String, Integer>();

	// Model with user modelling ontology.
	private OntModel mUM = null;

	/**
	 * Constructs MeasureCalculator.
	 * 
	 * @param mUM
	 *            model of User Modelling ontology
	 */
	public MeasureCalculator(OntModel mUM) {
		this.mUM = mUM;
	}

	/**
	 * Returns a distance between a given measure individual and a given measure
	 * set.
	 * 
	 * @param m
	 *            Measure
	 * @param mset
	 *            MeasureSet
	 * @return the distance
	 * @throws UnknownMeasureTypeException 
	 * @throws MeasureDataAccessException 
	 * @throws JastorException
	 */
	public double getDistance(Measure m, MeasureSet mset) throws UnknownMeasureTypeException {

		if ((mset instanceof IntervalSet) && (m instanceof Interval))
			return getIntervalDistance((IntervalSet) mset, (Interval) m);
		if ((mset instanceof NominalSet) && (m instanceof Nominal))
			return getNominalDistance((NominalSet) mset, (Nominal) m);
		if ((mset instanceof OrdinalSet) && (m instanceof Ordinal))
			return getOrdinalDistance((OrdinalSet) mset, (Ordinal) m);
		else
			throw new UnknownMeasureTypeException("Types of measure not matching");

	}

	/**
	 * Returns a distance between a given ordinal individual and a given ordinal
	 * set. It is assumed the given set is not empty.
	 * 
	 * @param oset
	 *            set of ordinals
	 * @param o
	 *            ordinal individual
	 * @return the distance
	 */
	public double getOrdinalDistance(OrdinalSet oset, Ordinal o)  {
		// TODO: Why we assume -- not empty set ??
		double dist = 0;
		try {
			if (contains(oset.getContains_asOrdinal(), o))
				return 0;

			// Compute minimal distances min { |rank(o)-rank(oes)| || oes belongs to
			// oset }
			double min = 0;
			for (Iterator it = oset.getContains_asOrdinal(); it.hasNext();) {
				Ordinal oes = (Ordinal) it.next();

				min = Math.min(min, Math.abs(o.getHasRank().intValue()
						- o.getHasRank().intValue()));
			}

			dist = min / (getDomainSize(o) - 1.0);
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access ordinal data. ", e);
		}
		return dist;
	}

	/**
	 * Returns a distance between the given nominal individual and a given
	 * nominal set. It is assumed the given set is not empty.
	 * 
	 * @param nset
	 *            set of nominals
	 * @param n
	 *            nominal individual
	 * @return the distance
	 * @throws ResourceAccessException 
	 */
	public double getNominalDistance(NominalSet nset, Nominal n) {
		double dist = 0;
		try {
			dist = contains(nset.getContains_asNominal(), n) ? 0 : 1;
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access nominal data. ", e);
		}
		return dist;

	}

	/**
	 * Returns a distance between the given interval individual and a given
	 * interval set. It is assumed the given set is not empty.
	 * 
	 * @param nset
	 *            set of intervals
	 * @param n
	 *            interval individual
	 * @return the distance
	 * @throws ResourceAccessException 
	 */
	public double getIntervalDistance(IntervalSet iset, Interval i) {
		double dist = 0;
		try {
			// TODO: This is some workaround, since Jastor meet some problem with access to data in imported ontology
			double left = iset.resource().getProperty(IntervalSet.hasLeftBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
			double right = iset.resource().getProperty(IntervalSet.hasRightBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();

			double iv = i.getMapsLinearValue();
			if (left <= iv && iv <= right)
				dist = 0;
			IntervalDomain idomain = (IntervalDomain) getIntervalDomain(i);
			double min = idomain.resource().getProperty(IntervalSet.hasLeftBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
			double max = idomain.resource().getProperty(IntervalSet.hasRightBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
			dist = Math.abs(0.5 * (left + right) - iv) / (max - min);
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access interval data. ", e);
		}
		return dist;
	}

	/**
	 * Checks whether the list of the given iterator contains given Thing objet
	 * 
	 * @param it
	 *            iterator of the list
	 * @param t
	 *            Thing
	 * @return <code>true</code>, if the list contains the given Thing object
	 *         (even if Thing is <code>null</code>)
	 */
	private boolean contains(Iterator<Thing> it, Thing t) {
		if (t == null) {
			while (it.hasNext()) {
				if (it.next() == null)
					return true;
			}
		} else {
			while (it.hasNext()) {
				if (t.equals(it.next()))
					return true;
			}
		}
		return false;
	}

	/**
	 * Caches size of domain for the given type of RDF resource
	 * 
	 * @param rdfType
	 *            type of resource
	 * @param size
	 *            size of the domain of the given RDF resource
	 */
	private void cacheDomainSize(String rdfType, int size) {
		String code = getCodeForRDFType(rdfType);
		domainSizeCache.put(code, size);
	}

	/**
	 * Returns the size of the domain of the given RDF resource
	 * 
	 * @param rdfType
	 *            type of resource
	 * @return size of the domain
	 */
	private int getCachedDomainSize(String rdfType) {
		String code = getCodeForRDFType(rdfType);
		return domainSizeCache.get(code);
	}

	private String getCodeForRDFType(String rdfType) {
		return mUM.hashCode() + rdfType;
	}

	/**
	 * Returns size of domain for a given measure, i.e. number of possible values, 
	 * 
	 * @param m
	 *            measure
	 * @return size of the domain
	 */
	public int getDomainSize(Measure m) {
		// More precisely, returns number of individuals of given measure
		// existing in model with user modelling.
		String rdfType = ibspan.tss.core.semantic.Util.getClosestRDFType(m);
		Integer sizeI = (Integer) getCachedDomainSize(rdfType);
		if (sizeI == null) {
			int size = 0;
			for (Iterator it = mUM.listStatements(null, RDF.type, rdfType); it
					.hasNext(); it.next())
				size++;
			cacheDomainSize(rdfType, sizeI);
			return size;
		} else
			return sizeI.intValue();
	}

	/**
	 * Returns true if given set is empty.
	 * 
	 * @param mset
	 *            given set
	 * @return
	 * @throws UnknownMeasureTypeException
	 */
	public boolean isSetEmpty(MeasureSet mset) throws UnknownMeasureTypeException {
		boolean isEmpty = false;
		try {
			// TODO: This is some workaround, since Jastor meet some problem with access to data in imported ontology
			if (mset instanceof IntervalSet) {
				IntervalSet iset = (IntervalSet) mset;
				double left = iset.resource().getProperty(IntervalSet.hasLeftBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
				double right = iset.resource().getProperty(IntervalSet.hasRightBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
				isEmpty = left >= right;
			} else if (mset instanceof NominalSet) {
				NominalSet nset = (NominalSet) mset;
				isEmpty = !(nset.getContains_asNominal().hasNext());
			} else if (mset instanceof OrdinalSet) {
				OrdinalSet oset = (OrdinalSet) mset;
				isEmpty = !(oset.getContains_asOrdinal().hasNext());
			} else
				throw new UnknownMeasureTypeException("");
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access description of data.", e);
		}
		return isEmpty;
	}

	/**
	 * Returns domain describing given measure.
	 * 
	 * @param m
	 *            measure
	 * @param model
	 *            model where the MeasureDomain is described
	 * @return the domain or null if there is no such domain in a given model
	 */
	public IntervalDomain getIntervalDomain(Interval i) {
		return getIntervalDomain(ibspan.tss.core.semantic.Util.getClosestRDFType(i));
	}

	/**
	 * Returns domain describing given measure.
	 * 
	 * @param m
	 *            measure
	 * @param model
	 *            model where the MeasureDomain is described
	 * @return the domain or null if there is no such domain in a given model
	 */
	public IntervalDomain getIntervalDomain(String intervalRDFType) {
		IntervalDomain domain = null;
		try {
			// finds domain which describes given measure
			StmtIterator it = mUM.listStatements(null,
					MeasureDomain.ofMeasureProperty, intervalRDFType);
			if (it.hasNext()) {
				domain = UserModellingFactory.getIntervalDomain(it
						.nextStatement().getSubject(), mUM);
			}
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access data about interval from domain. ", e);
		}
		return domain;
	}
}
