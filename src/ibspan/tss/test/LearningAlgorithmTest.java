package ibspan.tss.test;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.core.storage.ModelLoaderInitException;
import ibspan.tss.dao.HistoryDAO;
import ibspan.tss.domain.ontology.restaurant.Restaurant;
import ibspan.tss.domain.ontology.restaurant.RestaurantFactory;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.domain.vocabulary.RestaurantsDBVocabulary;
import ibspan.tss.um.learning.EventsPreprocessor;
import ibspan.tss.um.learning.ExtendedEvent;
import ibspan.tss.um.learning.LearningAlgorithm;
import ibspan.tss.um.learning.LearningTask;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.UserBehaviour;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.vocabulary.HistoryDBVocabulary;
import ibspan.tss.um.vocabulary.ProfilesDBVocabulary;
import ibspan.tss.um.vocabulary.StatisticsDBVocabulary;
import ibspan.tss.um.vocabulary.UserModellingVocabulary;
import jade.util.Logger;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

public class LearningAlgorithmTest {
	
	private static Logger logger = Logger.getMyLogger(LearningAlgorithm.class.getName());
	private static boolean runSimilation = true;
	
	
	public LearningAlgorithmTest() {
		OntModel mDomain;

		OntModel mUM;
		OntModel mHistoryDB;
		OntModel mRestaurantsDB;
		OntModel mProfilesDB;
		OntModel mStatisticsDB;
		try {
			mDomain = ModelLoader.loadModel(RestaurantVocabulary.NS);
			mRestaurantsDB = ModelLoader.loadDBModel(RestaurantsDBVocabulary.NS);
			mHistoryDB = ModelLoader.loadDBModel(HistoryDBVocabulary.NS);
			mStatisticsDB = ModelLoader.loadDBModel(StatisticsDBVocabulary.NS);
			mProfilesDB = ModelLoader.loadDBModel(ProfilesDBVocabulary.NS);			
			mUM = ModelLoader.loadModel(UserModellingVocabulary.NS);
		} catch (ModelLoaderInitException e) { 
			e.printStackTrace();
			return;
		}

		// This test works on real data, so perform it inside of transaction
		// and the abort transaction to rollback all changes.
		try {
			//mProfilesDB.begin();	
			//mStatisticsDB.begin();
			//mHistoryDB.begin();
			
			if(runSimilation) {				
				SessionSimulator simulator;
				try {
					simulator = new SessionSimulator(mHistoryDB, mDomain, mRestaurantsDB);
				} catch (JastorException e) {
					e.printStackTrace();
					return;
				}
				
				simulator.setMaxDetails(5);
				simulator.setMaxQuerySize(8);
				simulator.setMaxSearches(4);
				
				logger.info("simulation started...");
				
				for(int i = 1; i <= 2; i++)
					for (int userID = 100 ; userID <= 102; userID++) 
						simulator.simulateSession(userID);
				
				logger.info("simulation finished !");
			}

			logger.info("Preprocessing started...");
			
			EventsPreprocessor preprocessor = new EventsPreprocessor(mDomain);
			
			HistoryDAO daoHistory = new HistoryDAO(mHistoryDB);
			
			// TODO: This in fact should be: all events after some date
			Date date = new Date();
			date.setMonth(5);
			List<Event> events = daoHistory.getEvents(date);
			Event e = UserModellingFactory.getEvent(HistoryDBVocabulary.NS + Event.LastEvent.getLocalName(), mHistoryDB);
			events.remove(e);
			e = UserModellingFactory.getEvent(Event.LastEvent.getURI(), mHistoryDB);
			events.remove(e);
						
			Set<String>clickedConcepts = preprocessor.getClickedConcepts(events);
			
			logger.info("Number of events to process " + events.size());
			
			// Obtains information about clicked concepts
			// Usually this performed by asking RSA
				
			Memory memResults = new Memory();

			for(Iterator it = clickedConcepts.iterator(); it.hasNext(); ) {
				String uri = (String) it.next();
				Restaurant res = RestaurantFactory.getRestaurant(uri, mRestaurantsDB);
				memResults.add(res);
			}
			OntModel mClickedIndividuals = memResults.getModel();
			
			preprocessor.setClickedIndividualsModel(mClickedIndividuals);	
			
			// Extend context of the events on the base of clicked individuals data
			List<ExtendedEvent> extEvents = preprocessor.extendContext(events);
			
			// Find out concepts mentioned in events and users playing as actor of these events
			Set<String> objectedConcepts = preprocessor.getObjectedConcepts(extEvents);
			Set<Integer> users = preprocessor.getPlayingUsers(events);		
			
			logger.info("Preprocessing finished !");
			
			// Prepare learning task
			LearningTask task = new LearningTask();
			task.setEvents(extEvents);
			task.setObjectedConcepts(objectedConcepts);
			task.setClickedIndividuals(mClickedIndividuals);
			task.setPlayingUsers(users);

			// Initialize and configure algorithm.
			LearningAlgorithm alg = new LearningAlgorithm(mProfilesDB, mStatisticsDB, mUM, mDomain);		
			
			logger.info("Learning started !");
			
			// Start learning
			alg.learn(task);
			
			logger.info("Learning finished !");
			

			
			
		} catch(Exception e) {
			e.printStackTrace();			
		} finally {
			//mProfilesDB.abort();
			//mStatisticsDB.abort();
			//mHistoryDB.abort();
		}
		
	}


	public static void main(String[] args) {
		new LearningAlgorithmTest();
	}
}
