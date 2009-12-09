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
package ibspan.tss.agents.pma.learning;

import ibspan.tss.agents.pma.ProfileManagingAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.OWLData;
import ibspan.tss.messaging.ontology.RSA_get_restaurants_details;
import ibspan.tss.um.UnknownIndividualsException;
import ibspan.tss.um.learning.EventsPreprocessor;
import ibspan.tss.um.learning.ExtendedEvent;
import ibspan.tss.um.learning.LearningAlgorithm;
import ibspan.tss.um.learning.LearningTask;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.UserModellingFactory;
import jade.content.ContentManager;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

/**
 * This behaviour runs cyclicly realizing process of learning of user profiles.
 * It works in cycles containing the following steps:
 * <ol>
 * <li><b>Preparing <code>LearningTask</code> object</b>.
 * <ol>
 * <li><b>Collecting subscribed packs of events</b>. This step is repeated until new
 * packs (one or more) of events appear in <code>SynchronizedStore</code>
 * object, passsed as an argument in constructor.
 * <li><b>Preprocessing new events by <code>EventsPreprocessor</code> object</b>.
 * All new events are preprocessed to find which users played in them and which
 * concepts were objected in them. <code>RestaurantServiceAgent</code> is
 * requested to provide detailed information about clicked or rated concepts
 * (i.e. descriptions of restaurants). All prepared information are used to
 * construct new <code>LearningTask</code> object. The implementation of this
 * substep has been partially parallelized.
 * </ol>
 * <li><b>Learning user profiles with use of <code>LearningAlgorithm</code>
 * instance</b>. In this step prepared <code>LearningTask</code> object is used as
 * a base for learning process. No temporary copy of profiles model is created
 * for the time of work of this step. Learning process works on profiles in
 * transaction mode, which gives warranty that all changes made to a model
 * within a transaction, will either be made, or none of them will be made.
 * Additionally other behaviours see <i>status quo</i> of profiles before
 * starting a transaction and there is no problem with reading them.
 * </ol>
 * 
 * <p>
 * This behaviour should be launched in a seperate thread to avoid blocking of
 * whole agent.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see SynchronizedStore
 * @see HistorySubscriber
 * @see LearningTask
 * @see LearningAlgorithm
 * @see EventsPreprocessor
 */ 
public class ContinuousLearning extends FSMBehaviour {
	// TODO Lack of RSA service or its refeuse/failure should not result in RuntimeException but should be handled in FSM Behaviour by error handling substate
	// TODO Add handling with system shutdown
	// TODO Consider better parallelization of actions during collecting or
	// preprocessing, e.g. collecting-data and preprocessing could works on new
	// events, while learning hard phase works on alreade preprocessed events,
	// concurrently.
	// TODO What happens when during learning in transaction new profile is
	// created by stereotyping algorithm ?
	

	private static Logger logger = Logger.getMyLogger(ContinuousLearning.class.getName());

	// FSM States
	private static final String COLLECT_DATA = "collect-data";
	private static final String PREPROCESS_DATA = "preprocess-data";
	private static final String LEARN_HARD = "learn-hard";

	// Results of collect-data state.
	private static final int HAVE_ENOUGH_DATA = 1;
	private static final int WANT_MORE_DATA = 2;

	private LearningAlgorithm alg;

	// 
	private ServiceFinder restaurantService;

	// DB-based Model with profiles.
	private OntModel mProfilesDB;

	// DB-based model with statistics for events which have been processed.
	private OntModel mStatisticsDB;

	// The agent this behaviour belongs too.
	private ProfileManagingAgent myAgent;

	// Preprocessed events to prepare learning task
	private EventsPreprocessor preprocessor;

	// List containing continuoesly collected events to be processed.
	private List<Event> events = new ArrayList<Event>();

	// List of events after extending context.
	private List<ExtendedEvent> extEvents;

	// List of URIs of individuals objected in new events.
	private Set<String> objectedConcepts;
	
	// List of IDs of users who played in collected events
	private Set<Integer> playingUsers;

	// List of URIs of individuals clicked by users.
	private Set<String> clickedConcepts;

	// DB-based temporary model with description of individuals objects in new
	// events.
	private OntModel mClickedIndividuals;



	/**
	 * Constructs <code>ContinuousLearning</code> behaviour.
	 * 
	 * @param a
	 *            is the agent this behaviour belongs to.
	 * @param store
	 *            is a store where new packs of events can be found.
	 */
	public ContinuousLearning(Agent a, final SynchronizedStore store) {
		
		super(a);
		myAgent = (ProfileManagingAgent) a;

		mProfilesDB = myAgent.getProfilesDBModel();
		//mProfilesTmpDB = myAgent.getTmpProfilesDBModel();
		OntModel mUM = myAgent.getUMModel();
		mStatisticsDB = myAgent.getStatisticsDBModel();
		OntModel mDomain = myAgent.getDomainModel();

		// Initialize and configure algorithm.
		alg = new LearningAlgorithm(mProfilesDB, mStatisticsDB, mUM, mDomain);

		
		
		// TODO Change when inffering learing phase will be implemented
		alg.setLearnRoot(null);

		restaurantService = myAgent.getRestaurantService();

		// Prepare event preprocessor
		preprocessor = new EventsPreprocessor(mDomain);

		String[] toBeReset = new String[] {COLLECT_DATA, PREPROCESS_DATA, LEARN_HARD}; 
		
		registerTransition(COLLECT_DATA, COLLECT_DATA, WANT_MORE_DATA);
		registerTransition(COLLECT_DATA, PREPROCESS_DATA, HAVE_ENOUGH_DATA);
		registerDefaultTransition(PREPROCESS_DATA, LEARN_HARD);
		registerDefaultTransition(LEARN_HARD, COLLECT_DATA, toBeReset);

		Behaviour b;

		// ----------------------------------------------
		// Register 'Collecting data' behaviour.
		// Collects subscribed packs of events from SHA
		// ----------------------------------------------
		b = new OneShotBehaviour(myAgent) {

			private int ret;

			@Override
			public void action() {
				OWLData owldata = (OWLData) store.pull();
				if (owldata != null) {
					Memory mem = new Memory(owldata);
					try {
						events.addAll(UserModellingFactory.getAllEvent(mem.getModel()));
					} catch (JastorException e) {
						throw new RuntimeException(e);
					}
					ret = WANT_MORE_DATA;
				} else {
					if (!events.isEmpty()) {
						ret = HAVE_ENOUGH_DATA;
					} else {
						ret = WANT_MORE_DATA;
						block();
					}
				}
			}

			public int onEnd() {
				return ret;
			}
		};
		registerFirstState(b, COLLECT_DATA);

		ParallelBehaviour pb = new ParallelBehaviour(myAgent,ParallelBehaviour.WHEN_ALL);
		
		
		// ----------------------------------------------------------
		// Register 'Getting restaurants' behaviour.
		// Obtains from RSA those restaurants, which were mentioned
		// in newly received events.
		// ----------------------------------------------------------
		pb.addSubBehaviour(new AchieveREInitiator(myAgent, null) {		
			
			
			protected Vector prepareRequests(ACLMessage request) {
				logger.info("Przygotowywanie pytania do RSA");
				Vector requests = null;

				try {
					clickedConcepts = preprocessor
							.getClickedConcepts(events);

					AID rsa = restaurantService.getOne();

					if (rsa != null) {
						request = new ACLMessage(ACLMessage.REQUEST);
						request.addReceiver(rsa);
						request.setOntology(MessagingOntology.ONTOLOGY_NAME);
						request
								.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
						request
								.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

						RSA_get_restaurants_details action = new RSA_get_restaurants_details();
						for (Iterator<String> it = clickedConcepts.iterator(); it.hasNext();) {
							String conceptURI = it.next();
							action.addAboutRestaurant(conceptURI);
						}

						Action act = new Action(rsa, action);
						myAgent.getContentManager().fillContent(
								request, act);

						requests = new Vector();
						logger.info(request.toString());
						requests.addElement(request);
					} else {
						throw new ServiceNotFoundException(
								"Restaurant service not found in DF.");
					}
				} catch (Exception e) {
					throw new RuntimeException(
							"Cannot prepare request to Restaurant service: ",
							e);
				}
				return requests;
			}

			protected void handleInform(ACLMessage inform) {					
				ContentManager manager = myAgent.getContentManager();
				Result r;
				try {
					r = (Result) manager.extractContent(inform);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				OWLData owldata = (OWLData) r.getValue();
				Memory mem = new Memory(owldata);

				mClickedIndividuals = mem.getModel();
			}
			
			
			@Override
			protected void handleFailure(ACLMessage failure) {
				logger.log(Level.INFO,
						"Responder failed to realize request.");

				throw new RuntimeException();
				
				
			}
		});
		pb.addSubBehaviour(new OneShotBehaviour(myAgent) {
			public void action() {
				playingUsers = preprocessor.getPlayingUsers(events);
			}
		});
		registerState(pb, PREPROCESS_DATA);

		// ----------------------------------------------------------
		// Register LEARN_HARD behaviour as working in seperate thread,
		// since it performs blocking operations
		// ----------------------------------------------------------
		b = new OneShotBehaviour(myAgent) {

			@Override
			public void action() {
				// Inform event preprocessor about individuals, which are, in fact,
				// model with description of clicked individuals
				preprocessor.setClickedIndividualsModel(mClickedIndividuals);

				try {
					extEvents = preprocessor.extendContext(events);
				} catch (UnknownIndividualsException e) {
					throw new RuntimeException(e);
				}

				// Get concepts there were mentioned in this pack of events
				objectedConcepts = preprocessor.getObjectedConcepts(extEvents);
				
				
				
				
				// Prepare learning task
				LearningTask task = new LearningTask();
				task.setEvents(extEvents);
				task.setObjectedConcepts(objectedConcepts);
				task.setClickedIndividuals(mClickedIndividuals);
				task.setPlayingUsers(playingUsers);

				logger.info("Learning in transaction...");
				try {
					mStatisticsDB.begin();
					mProfilesDB.begin();
					alg.learn(task);
					
					// Remove events, so we do not use them again for learning ;)
				logger.info("czyscze");
					
					
					mStatisticsDB.commit();
					mProfilesDB.commit();
					logger.info("Done.");
				} catch (Exception e) {
					mStatisticsDB.abort();
					mProfilesDB.abort();
					logger.log(Level.SEVERE, "Problem occured.", e);

				}
				
				events.clear();
			}
			
		};
		registerState(b, LEARN_HARD);
	}

}
