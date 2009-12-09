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
package ibspan.tss.um.learning;

import ibspan.tss.dao.ProfileDAO;
import ibspan.tss.um.ontology.Classification;
import ibspan.tss.um.ontology.Opinion;
import ibspan.tss.um.ontology.UserBehaviour;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.statistics.StatisticCalculator;
import jade.util.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

/**
 * This class is an implenetation of algorithm for learning user profiles,
 * presented in [1]. Generally it estimates probability of user interest in
 * particular concepts of domain ontology, on the base of frequency of actions
 * (events) targetted against these concepts in user history. This probability
 * is normalized in relation of probablity of user population interest in these
 * concepts. Second phase of learing references to interferencing probability on
 * the base of domain ontology depenedencies between resource, but has not been
 * fully investigated and implemented, yet.
 * 
 * <p>
 * Process of learning can be seen as series of learning tasks, where each if
 * them is simple act of processing a pack of new events. Each pack of events
 * needs preprocesing by use of <code>EventsPreprocessor</code> object and
 * results are to be put into <code>LearningTask</code> object. In fact,
 * process of learning can be started by invoking <code>learn()</code> method
 * with <code>LearningTask<code> passed as an argument. 
 * 
 * <p>
 * Implementation of learning uses <i>Statistics</i> data persisted in database and
 * updated on the base of pack of new events passed inside of 
 * <code>LearningTask</code>. Access to this data is possible by 
 * <code>StatisticsBuffer</code> object.
 *  
 * <ol>
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/Gawinecki_MS_2005.pdf">"Modelling
 * User on the Basis of Interactions with a WWW Based System"</a>, Maciej
 * Gawinecki, Adam Mickiewicz University, Poznan. 2005.
 * </ol>
 * 
 * @author <a href="maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 *
 * @see LearningTask
 * @see EventsPreprocessor
 * @see StatisticsBuffer
 *
 */
public class LearningAlgorithm {
	// TODO: representing user mProfilesTmpDB ontologically (especially during
	// learning) seems inefficient, only domain should be represented in such a
	// way but, but remember we also need to transfer mProfilesTmpDB inside of
	// ACL Messages.
	
	private static Logger logger = Logger.getMyLogger(LearningAlgorithm.class.getName());
	
	/**
	 * Importance weight of query behaviour.
	 * 
	 * @see UserBehaviour#QueryForRestaurantBehaviour
	 */
	public final static int QUERY_BEHAVIOUR_WEIGHT = 20;
	/**
	 * Importance weight of rate behaviour.
	 * 
	 * @see UserBehaviour#RateRestaurantPositiveBehaviour
	 */
	public final static int RATE_BEHAVIOUR_WEIGHT = 30;
	/**
	 * Importance weight of query behaviour.
	 * 
	 * @see UserBehaviour#ClickForRestaurantDetailsBehaviour
	 */
	public final static int CLIK_BEHAVIOUR_WEIGHT = 10;
	

	/**
	 * Confidency coefficient: alpha for Z statistic.
	 */
	public final static double DEFAULT_SIGNIFICANCE_LEVEL = 0.05;

	/**
	 * Parameter of sigmoid function, adapted from the paper: Kobsa, Alfred,
	 * Koychev, Ivan i Schwab, Ingo. 2000. Learning about Users from
	 * Observation. Pages 102-106 from: Adaptive User Interfaces: Papers from
	 * the 2000 AAAI Spring Symposium. Stanford, CA, USA: AAAI Press.
	 */
	public final static double DEFAULT_SIGMOID_PARAM_A = -0.4;

	// Model for user modelling ontology.
	private OntModel mUM;
	// Model for domain (restaurant) ontology
	private OntModel mDomain;
	// Data Access Object providing set of methods for profiles model.
	private ProfileDAO daoProfile;	

	// Temporary storage for storing and pre-processing statistics. 
	private StatisticsBuffer statistics;

	// Contains data necessary for a single call of learn() method.
	private LearningTask task;
	
	//--------------------------------------------------------------
	// Data neccessary to be initialized after constructing of an 
	// algorithm.
	//--------------------------------------------------------------
	
	// Describes weights of behaviour resulting. Different behaviours proves
	// playingUsers interest in particular concept in a different degree.
	private Map<UserBehaviour, Integer> behavioursWeights = new HashMap<UserBehaviour, Integer>();	
	// Root class, from which starts inteferring learning phase.
	private OntClass learnRoot;


	// BUFFERED weighted number of occurences of events in which all users are
	// interested in particular concepts
	private Map<String,Double> kConcepts = new HashMap<String,Double>();
	// BUFFERED weighted number of occurences of all events of particular users
	private Map<Integer,Double> NUsers = new HashMap<Integer,Double>();
	// BUFFERED weighted number of occurences of all gathered events of all users
	private Double NN = 0.0;
	
	/**
	 * Constructs the algorithm.
	 * 
	 * @param mProfilesDB
	 *            is model with profiles containing from which profiles will be
	 *            read and where results will be written
	 * @param mStatisticsDB
	 *            is persistent model where statistics data are store
	 * @param mUM
	 *            is model with user modelling ontology
	 * @param mDomain
	 *            is model with domain ontology
	 */
	public LearningAlgorithm(OntModel mProfilesDB, OntModel mStatisticsDB, OntModel mUM, OntModel mDomain)  {
		// Initialize algorithm.
		this.mUM = mUM;
		this.mDomain = mDomain;
		
		daoProfile = new ProfileDAO(mProfilesDB);
		statistics = new StatisticsBuffer(mStatisticsDB);

		// Set default weights for user behaviours
		UserBehaviour b;
		try {
			b = UserModellingFactory.getUserBehaviour(UserBehaviour.QueryForRestaurantBehaviour, mUM);
			behavioursWeights.put(b, QUERY_BEHAVIOUR_WEIGHT);
			b = UserModellingFactory.getUserBehaviour(UserBehaviour.RateRestaurantPositiveBehaviour, mUM);
			behavioursWeights.put(b, RATE_BEHAVIOUR_WEIGHT);
			b = UserModellingFactory.getUserBehaviour(UserBehaviour.ClickForRestaurantDetailsBehaviour, mUM);
			behavioursWeights.put(b, CLIK_BEHAVIOUR_WEIGHT);
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Starts learning based updating opinions in user profiles about every
	 * objected concept for every playing user mentioned in the given
	 * <code>LearningTask</code>.
	 * 
	 * @param task
	 *            is learning task to be realized.
	 */
	public void learn(LearningTask task) {
		this.task = task;

		long startLearning = System.currentTimeMillis();
		long startStats = System.currentTimeMillis();
		statistics.updateStatistics(task.getEvents());
		long durationStats = System.currentTimeMillis() - startStats;
		logger.fine("Updating statistics with " + task.getEvents().size() + "events took " +  durationStats + " milliseconds.");
		
		// Clear buffered values
		this.NN = 0.0;
		kConcepts.clear();
		NUsers.clear();
		
		learn1();
		learn2();
				
		long durationLearning = System.currentTimeMillis() - startLearning;
		logger.fine("Learning process of " + task.getEvents().size() + " events took " +  durationLearning + " milliseconds.");
	}

	//--------------------------------------------------------------
	// Methods for initializing algorithm.
	//--------------------------------------------------------------

	
	/**
	 * @param learnRoot
	 */
	public void setLearnRoot(OntClass learnRoot) {
		this.learnRoot = learnRoot;
	}
	
	//--------------------------------------------------------------
	// Internal algorithm functions.
	//--------------------------------------------------------------
	
	/**
	 * First phase of learning based calculating normalized probability and
	 * classification for opinions about every objected concept for every
	 * playing user in the given <code>LearningTask</code>.
	 */
	private void learn1() {
		logger.fine("Starting hard learning phase 1...");
		UserProfile profile;
		int userID;
		String concept;
		Opinion opinion;
		
		// Learn only profiles of those users who were actors in new events.
		try {
			long startLearning1 = System.currentTimeMillis();
			
			// TODO: This method computes opinions only for users acting in
			// considered events, but since classification is calcalated on the
			// base of rate between they behaviour and behaviour of whole
			// population of users, therefore they profile stay out-of-date
			// until events with them as actor will be brought to learning.
			for (Iterator<Integer> uit = task.getPlayingUsers().iterator(); uit.hasNext();) {
				userID = uit.next();
				logger.fine("Computing profile for user: " + userID);
				profile = daoProfile.getUserProfileByID(userID);
				long startProfile = System.currentTimeMillis();
				for (Iterator<String> cit = task.getObjectedConcepts().iterator(); cit.hasNext();) {
					concept = cit.next();
					logger.fine("Learning of concept " + concept + " ...");
					// does user has any opinion about that concept ?
					
					opinion = daoProfile.getUserOpinionAbout(userID, concept);
					// If no -- add new opinion
					if (opinion == null)						
						opinion = profile.getHasOpinions().addContainsOpinion();
		
					// Anyway, update this opinion
					updateOpinionAbout(opinion, concept, userID);
				}
				long durationProfiling = System.currentTimeMillis() - startProfile;
				logger.fine("Profile for " + task.getObjectedConcepts().size() + " concepts computed in " + durationProfiling + " milliseconds.");
			}
			long durationLearning1 = System.currentTimeMillis() - startLearning1;
			logger.fine("Learning of " + task.getPlayingUsers().size() + " users computed in " + durationLearning1 + " milliseconds.");
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
		logger.fine("Done.");
	}
	

	/**
	 * Calculation of inferred probability on the base of domain ontology
	 * dependencies. *
	 */
	private void learn2() {
		// TODO: domain inferring learning phase must be investigated once more.
		logger.fine("Starting hard learning phase 1...");
		logger.warning("Inferring learning phase is not imlemented yet");
		logger.fine("Done.");
	}

	/**
	 * Updates the opinion (normalized probablity and classification) about the
	 * given concept of the given user. Calculations are based on univariance
	 * significancy analisis.
	 * 
	 * @param opinion
	 *            is opinion to be updated.
	 * @param conceptURI
	 *            is URI reference of concept.
	 * @param uid
	 *            is user ID for which this opinion is stated.
	 * @return updated opinion
	 */
	private Opinion updateOpinionAbout(Opinion opinion, String conceptURI, Integer uid) throws JastorException {
		long startOpinioning = System.currentTimeMillis();
		
		opinion.setIsAbout(conceptURI);
		logger.fine("Updating opinion of user: " + uid + " about concept:" + conceptURI);

		//--------------------------------------------
		// Weighted number of occurences of events...
		//--------------------------------------------
		// in which the user with the given uid is interested in the given concept
		double k_uid_concept;  
		// in which all users are interested in the given concept
		double k_concept;
		// ...all gathered events of all users
		double N; 
		// ...all events of the user with given uid
		double N_uid;
		
		//----------------------------------------
		// Prepare weighted numbers of occurences
		//----------------------------------------
		
		// This is computed only once for new pack -- do not buffer
		k_uid_concept = 0;
		for (Iterator<UserBehaviour> it = behavioursWeights.keySet().iterator(); it.hasNext();) {
			UserBehaviour behaviour = it.next();
			k_uid_concept += behavioursWeights.get(behaviour)
					* statistics.getStatistic(uid, behaviour,conceptURI);
		}

		if (kConcepts.get(conceptURI) != null)
			k_concept = kConcepts.get(conceptURI);
		else {
			k_concept = 0;
			for (Iterator<UserBehaviour> it = behavioursWeights.keySet().iterator(); it.hasNext();) {
				UserBehaviour behaviour = it.next();
				k_concept += behavioursWeights.get(behaviour)
						* statistics.getStatistic(null, behaviour,conceptURI);	
			}
			kConcepts.put(conceptURI,k_concept);
		}

		if (NUsers.get(uid) != null)
			N_uid = NUsers.get(uid);
		else {
			N_uid = 0;
			for (Iterator<UserBehaviour> it = behavioursWeights.keySet().iterator(); it.hasNext();) {
				UserBehaviour behaviour = it.next();
				N_uid += behavioursWeights.get(behaviour)
						* statistics.getStatistic(uid, behaviour, null);
			}
			NUsers.put(uid, N_uid);
		}

		if (this.NN != 0.0)
			N = this.NN;
		else {
			N = 0;
			for (Iterator<UserBehaviour> it = behavioursWeights.keySet().iterator(); it.hasNext();) {
				UserBehaviour behaviour = it.next();
				N += behavioursWeights.get(behaviour)
						* statistics.getStatistic(null, behaviour, null);
			}
			this.NN = N;			
		}

		if (logger.isLoggable(Level.INFO)) {
			String s = "Pre-Results: ";
			s += "\n N = " + N;
			s += "\n k_uid_concept = " + k_uid_concept;
			s += "\n k_concept = " + k_concept;
			s += "\n N_uid = " + N_uid;
			logger.info(s);
		}

		if (N_uid == 0)
			// If user has no events in this history, this case will not occur.
			logger.warning("Trying to calculate number of events for for user " + uid + " with no events !");
		if (N == 0)
			// This is usually not possible case, as we make calculations only
			// when there are some events (N>0).
			logger.warning("Trying to calculate number of events for no events !");
		else {
			double p, pi, pn, mean, stdDev;
			double cu, cl;
			double z;

			// Normalize probability.
			p = k_concept / N;
			mean = StatisticCalculator.binomialMean(p, N_uid);
			stdDev = StatisticCalculator.binomialStdDev(p, N_uid);
			// TODO: is it possible that stdDev is equal to 0 ?
			pn = StatisticCalculator.sigmoid((k_uid_concept - mean) / stdDev, DEFAULT_SIGMOID_PARAM_A);

			// Calculate individual probability -- just for debugging purpose.
			pi = k_uid_concept / N_uid;

			// Compute confidency interval.
			// TODO: computing z can be done once per change 'significance_level' 
			z = StatisticCalculator.normalQuantile(DEFAULT_SIGNIFICANCE_LEVEL / 2);
			cu = mean - z * stdDev;
			cl = mean + z * stdDev;

			// Classify opinion.
			if (k_uid_concept > cu)
				opinion.setHasClassification(UserModellingFactory.getClassification(Classification.Interesting,mUM));
			else if (k_uid_concept < cl)
				opinion.setHasClassification(UserModellingFactory.getClassification(Classification.NotInteresting,mUM));
			else
				opinion.setHasClassification(UserModellingFactory.getClassification(Classification.NotClassified,mUM));

			if (logger.isLoggable(Level.INFO)) {
				String s = "Results: ";
				s += "\n classification = " + opinion.getHasClassification().resource().getLocalName();
				s += "\n p = " + p;
				s += "\n mean = " + mean;
				s += "\n stdDev = " + stdDev;
				s += "\n pn = " + pn;
				s += "\n pi = " + pi;
				s += "\n z = " + z;
				s += "\n cu = " + cu;
				s += "\n cl = " + cl;
				logger.fine(s);
			}

			// Set probabilitiess.
			opinion.setAtIndividualProbability(pi);
			opinion.setAtNormalizedProbability(pn);
		}

		long durationOpinioning = System.currentTimeMillis() - startOpinioning; 
		logger.fine("Opinion computed in " + durationOpinioning + " milliseconds.");
		
		return opinion;
	}
}
