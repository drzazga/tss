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
package ibspan.tss.agents.pma;

import ibspan.tss.agents.SystemAgent;
import ibspan.tss.agents.pma.learning.ContinuousLearning;
import ibspan.tss.agents.pma.learning.HistorySubscriber;
import ibspan.tss.agents.pma.learning.SynchronizedStore;
import ibspan.tss.agents.rsa.RestaurantServiceAgent;
import ibspan.tss.agents.sha.SessionHandlingAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.core.storage.ModelLoaderInitException;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceFinderException;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ServiceWaiter;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.OWLData;
import ibspan.tss.messaging.ontology.RSA_get_domain_ontology;
import ibspan.tss.um.vocabulary.ProfilesDBVocabulary;
import ibspan.tss.um.vocabulary.StatisticsDBVocabulary;
import ibspan.tss.um.vocabulary.StereotypesDBVocabulary;
import ibspan.tss.um.vocabulary.TmpProfilesVocabulary;
import ibspan.tss.um.vocabulary.UserModellingVocabulary;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.shared.Lock;

/**
 * The agent responsible for creating and learning user profiles and providing them to other agents. It requires agent of the following services
 * registered in <i>Directory Facilator</i>:
 * <ul>
 * <li><code>RestaurantServiceAgent</code> -- to obtain domain ontology and detailed information about restaurants during learning process
 * <li><code>SessionHandlingAgent</code> -- at which the agent subscribes for new events being a base for learning process.
 * <ul>
 * The latter requirement is optional. The agent will provide all functionality, but not learning. This is done, because two agents (
 * <code>SessionHandlingAgent</code> and <code>ProfileManagingAgent</code> cannot wait for registration of each of them, since this could lead to
 * circular deadlock.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see RestaurantServiceAgent
 * @see SessionHandlingAgent
 */
public final class ProfileManagingAgent extends SystemAgent {

    private static Logger logger = Logger.getMyLogger(ProfileManagingAgent.class.getName());

    public final static String SERVICE_NAME = "Profile Managing Service";
    public final static String SERVICE_TYPE = "profile-managing-service";
    public final static String SERVICE_OWNERSHIP = "Travel Support System";

    // Keys for configuration properties file.
    public static final String NUMBER_OF_EVENTS_IN_PACK_KEY = "EventsPackSize";

    // Number of events which will be provided by SHA in a single pack with
    // events, when PMA subscribe for it.
    public static int conf_NUMBER_OF_EVENTS_IN_PACK;

    private OntModel mDomain;
    private OntModel mUM;
    private OntModel mProfilesDB;
    private OntModel mTmpProfilesDB;
    private OntModel mStatisticsDB;
    private OntModel mStereotypesDB;
    private ServiceFinder restaurantService;
    private ServiceFinder sessionHandlers;

    public OntModel getProfilesDBModel() {
        return mProfilesDB;
    }

    public OntModel getTmpProfilesDBModel() {
        return mTmpProfilesDB;
    }

    public OntModel getDomainModel() {
        return mDomain;
    }

    public OntModel getStereotypesDBModel() {
        return mStereotypesDB;
    }

    public OntModel getStatisticsDBModel() {
        return mStatisticsDB;
    }

    public OntModel getUMModel() {
        return mUM;
    }

    public ServiceFinder getSessionHandlers() {
        return sessionHandlers;
    }

    public ServiceFinder getRestaurantService() {
        return restaurantService;
    }

    // Factory for continuoes learning behaviour in a seperate thread.
    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();

    public ProfileManagingAgent() {
        super();

        try {
            logger.info("Loading user modelling ontology ... ");
            mUM = ModelLoader.loadModel(UserModellingVocabulary.NS);
            logger.info("Done.");

            logger.info("Loading user profiles from DB ...");
            mProfilesDB = ModelLoader.loadDBModel(ProfilesDBVocabulary.NS);
            logger.info("Done.");

            logger.info("Loading temporal store for profiles from DB ...");
            mTmpProfilesDB = ModelLoader.loadDBModel(TmpProfilesVocabulary.NS);
            logger.info("Done.");

            try {
                if (mTmpProfilesDB.isEmpty()) {
                    mProfilesDB.enterCriticalSection(Lock.READ);
                    try {
                        logger.info("Coping all profiles to temporal store...");
                        mTmpProfilesDB.add(mProfilesDB);
                        logger.info("Done.");
                    } catch (Exception e) {
                        mProfilesDB.abort();
                        logger.log(Level.SEVERE, "Problem occured.", e);
                        return;
                    } finally {
                        mProfilesDB.leaveCriticalSection();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            logger.info("Loading stereotypes from DB ...");
            mStereotypesDB = ModelLoader.loadDBModel(StereotypesDBVocabulary.NS);
            logger.info("Done.");

            logger.info("Loading statistics from DB ...");
            mStatisticsDB = ModelLoader.loadDBModel(StatisticsDBVocabulary.NS);
            logger.info("Done.");
        } catch (ModelLoaderInitException e) {
            logger.log(Level.SEVERE, "Problem while initializing ModelLoader.", e);
            doDelete();
        }
    }

    protected void activateProperties(Properties conf) {
        conf_NUMBER_OF_EVENTS_IN_PACK = Integer.parseInt(conf.getProperty(NUMBER_OF_EVENTS_IN_PACK_KEY));
    }

    protected void setup() {
        super.setup();

        getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
        getContentManager().registerOntology(MessagingOntology.getInstance());

        // Provide restaurant and profile services for behaviours
        try {
            restaurantService = new ServiceFinder(this, RestaurantServiceAgent.getServiceDescription());
            sessionHandlers = new ServiceFinder(this, SessionHandlingAgent.getServiceDescription());
        } catch (ServiceFinderException e) {
            logger.log(Level.SEVERE, "Problem while creating service finder: ", e);
            doDelete();
            return;
        }

        addBehaviour(new SequentialBehaviour(this) {

            public void onStart() {
                // Add behaviour waiting for registration of services the agent depends on
                // This is realized by parallel behaviours, which stops always, when they
                // find their service and receive request data from them
                addSubBehaviour(new ParallelBehaviour(myAgent, ParallelBehaviour.WHEN_ALL) {

                    public void onStart() {
                        // 1-st parallel behaviour: obtaining domain ontology
                        addSubBehaviour(new SequentialBehaviour(myAgent) {

                            public void onStart() {
                                // Wait for RSA registration
                                addSubBehaviour(new ServiceWaiter(myAgent, restaurantService));

                                // Request RSA for domain ontology
                                addSubBehaviour(new AchieveREInitiator(myAgent, null) {

                                    @Override
                                    protected Vector prepareRequests(ACLMessage request) {
                                        try {
                                            AID rsa = restaurantService.getOne();

                                            if (rsa != null) {
                                                request = new ACLMessage(ACLMessage.REQUEST);
                                                request.addReceiver(rsa);
                                                request.setOntology(MessagingOntology.getInstance().getName());
                                                request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
                                                request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

                                                RSA_get_domain_ontology action = new RSA_get_domain_ontology();

                                                Action act = new Action();
                                                act.setAction(action);
                                                act.setActor(rsa);

                                                myAgent.getContentManager().fillContent(request, act);

                                                Vector requests = new Vector();
                                                requests.addElement(request);

                                                return requests;
                                            } else {
                                                throw new ServiceNotFoundException("Restaurant service not found in DF.");
                                            }
                                        } catch (CodecException e) {
                                            logger.log(Level.SEVERE, "Cannot prepare request to Restaurant service: ", e);
                                            doDelete();
                                            return null;
                                        } catch (OntologyException e) {
                                            logger.log(Level.SEVERE, "Cannot prepare request to Restaurant service: ", e);
                                            doDelete();
                                            return null;
                                        } catch (ServiceNotFoundException e) {
                                            logger.log(Level.SEVERE, "No service. ", e);
                                            doDelete();
                                            return null;
                                        }
                                    }

                                    @Override
                                    protected void handleInform(ACLMessage inform) {
                                        try {
                                            ContentManager manager = myAgent.getContentManager();
                                            Result r = (Result) manager.extractContent(inform);
                                            OWLData owldata = (OWLData) r.getValue();
                                            Memory mem = new Memory(owldata);
                                            mDomain = mem.getModel();
                                        } catch (Exception e) {
                                            logger.log(Level.SEVERE, "Cannot read INFORM message with OWLData: ", e);
                                            myAgent.doDelete();
                                        }
                                    }

                                    @Override
                                    protected void handleFailure(ACLMessage failure) {
                                        logger.log(Level.INFO, "Responder failed to realize request.");
                                        myAgent.doDelete();
                                    }

                                });
                            }
                        });

                    }
                });

                addSubBehaviour(new OneShotBehaviour(myAgent) {

                    public void action() {
                        MessageTemplate mt = MessageTemplate.and(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
                                MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST)), MessageTemplate
                                .MatchOntology(MessagingOntology.ONTOLOGY_NAME));

                        // Now agent is ready to respond, start responder as 'root'
                        // behaviour since it works cyclicly
                        myAgent.addBehaviour(new PMAResponder(myAgent, mt));

                        try {
                            // Register at DF
                            ServiceDescription sd = getServiceDescription();
                            DFAgentDescription dfd = new DFAgentDescription();
                            dfd.setName(getAID());
                            dfd.addServices(sd);
                            DFService.register(myAgent, dfd);
                        } catch (FIPAException e) {
                            logger.log(Level.SEVERE, "Cannot register agent at DF: ", e);
                            myAgent.doDelete();
                        }
                    }
                });

                // Wait for SHA registering.
                addSubBehaviour(new ServiceWaiter(myAgent, sessionHandlers));

                // Prepare learning background: subscriber which obtain events
                // and learning behaviour, which process them
                addSubBehaviour(new SequentialBehaviour(myAgent) {

                    public void onStart() {
                        // Prepare store to exchange events data between behaviours
                        SynchronizedStore store = new SynchronizedStore(myAgent);

                        // Add learning behaviour in a seperate thread.
                        // addBehaviour(new ContinuousLearning(myAgent,store));
                        addBehaviour(tbf.wrap(new ContinuousLearning(myAgent, store)));

                        addBehaviour(new HistorySubscriber(myAgent, store));

                    }
                });

            }
        });
    }

    public static ServiceDescription getServiceDescription() {
        ServiceDescription sd = new ServiceDescription();
        sd.setType(SERVICE_TYPE);
        sd.setName(SERVICE_NAME);
        sd.setOwnership(SERVICE_OWNERSHIP);
        return sd;
    }
}
