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
package ibspan.tss.agents.pa;

import ibspan.tss.agents.IncorrectPropertiesException;
import ibspan.tss.agents.SystemAgent;
import ibspan.tss.agents.pma.ProfileManagingAgent;
import ibspan.tss.agents.rsa.RestaurantServiceAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.layout.TemplatesRegister;
import ibspan.tss.layout.vocabulary.TemplatesDBVocabulary;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceFinderException;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ServiceWaiter;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.OWLData;
import ibspan.tss.messaging.ontology.PMA_get_user_profile;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import jade.content.ContentManager;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.Property;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * This is class of an agent which works in the system on behalf of its user. It
 * realizes requests of authorized users, forwarded to it by
 * <code>SessionHandlingAgent</code>. The agent requires the following
 * services accesible in the system to start:
 * <ul>
 * <li>service of <code>RestaurantServiceAgent</code> for searching
 * restaurants according to the user preferences
 * <li>service of <code>ProfileManagingAgent</code> to obtain its user
 * profile -- necessary for filtering searching results.
 * </ul>
 * <p>
 * This agent is created on call by <code>SessionHanadlingAgent</code> and
 * requires two arguments defined, when created: <i>ID</i> and <i>name</i> of
 * its user.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ibspan.tss.agent.sha.SessionHandlingAgent
 * @see RestaurantServiceAgent
 * @see ProfileManagingAgent
 */
public final class PersonalAgent extends SystemAgent {
	// TODO: Personal Agent does not response to SHA about problem, when cannot
	// obtain profile from PMA. This blocks work of whole system.

	private static Logger logger = Logger.getMyLogger(PersonalAgent.class.getName());
	
	// Information used DFServiceDescription for the service this agent provides
	public final static String SERVICE_NAME = "Personal Service";
	public final static String SERVICE_TYPE = "personal-service";
	public final static String SERVICE_OWNERSHIP = "Travel Support System";
	public static final String USER_ID_PARAM_KEY = "user-id";

	// Prefix for agent name 
	public static final String NAME_PREFIX = "pa-";
	
	// Name of the user this agent works on behalf of.
	private String myUserName;
	// ID of the user this agent works on behalf of.
	private int myUserID;
	// Profile of the user this agent works on behalf of.
	private UserProfile myUserProfile;
	
	
	private ServiceFinder restaurantService;
	private ServiceFinder profileService;
	private TemplatesRegister templates;


	private OntModel mTemplatesDB;
	private OntModel mDomain;
	public OntModel getTemplatesDBModel() 			{ return mTemplatesDB; }
	public TemplatesRegister getTemplates() 		{ return templates; }
	public ServiceFinder getRestaurantService()		{ return restaurantService; }
	public ServiceFinder getProfileService()		{ return profileService; }
	public UserProfile getMyUserProfile()			{ return myUserProfile; }
	public int getMyUserID()						{ return myUserID; }
	public OntModel getDomainModel()				{ return mDomain; }
	
	public PersonalAgent() {
		super();	
		
		logger.info("Loading Templates from file into memory ...");
		mTemplatesDB = ModelLoader.loadModel(TemplatesDBVocabulary.NS);
		logger.info("Done.");	
		
		logger.info("Loading Domain from file into memory ...");
		mDomain = ModelLoader.loadModel(RestaurantVocabulary.NS);
		logger.info("Done.");
		
		templates = new TemplatesRegister();
	}
	
	public void setup() {
		Object[] args = getArguments();

			try {
				try {
					if (args != null && args.length == 2) {
						myUserID = (Integer) args[0];
						myUserName = (String) args[1];
						logger.info("Personal Agent for user with ID " + myUserID + " created.");				
					} else {
						throw new IncorrectPropertiesException("Unknown user ID");
					}
				} catch (NumberFormatException e) {
					throw new IncorrectPropertiesException("Cannot create Personal Agent, User ID is not a number: ", e);
				} catch (ClassCastException e) {
					throw new IncorrectPropertiesException("Cannot create Personal Agent, User ID is not a number: ", e);
				}
			} catch (IncorrectPropertiesException e) {
				logger.log(Level.SEVERE,"Cannot create Personal Agent: ", e);
				doDelete();
				return;
			}

		getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
		getContentManager().registerOntology(MessagingOntology.getInstance());

		// Provide restaurant and profile services for behaviours
		try {
			restaurantService = new ServiceFinder(this, RestaurantServiceAgent.getServiceDescription());
			profileService = new ServiceFinder(this, ProfileManagingAgent.getServiceDescription());
		} catch (ServiceFinderException e) {
			logger.log(Level.SEVERE,"Problem while creating service finder: ", e);
			doDelete();
			return;
		}	
		
		addBehaviour(new SequentialBehaviour(this) {
			public void onStart() {				
				// Add behaviour waiting for registration of services the agent depends on
				addSubBehaviour(new ParallelBehaviour(myAgent, ParallelBehaviour.WHEN_ALL) {
								
					public void onStart() {
						// 1st parallel  behaviour: is there any RSA ?
						addSubBehaviour(new ServiceWaiter(myAgent, restaurantService));
						
						// 2nd parallel behaviour: obtaining user profile
						addSubBehaviour(new SequentialBehaviour(myAgent) {
							public void onStart() {
								addSubBehaviour(new ServiceWaiter(myAgent, profileService));
								
							
								// Add behaviour gathering data from remote services
								addSubBehaviour(new AchieveREInitiator(myAgent, null) {
						
									@Override
									protected Vector prepareRequests(ACLMessage request) {
										Vector requests = null;
										try {
											AID pma = profileService.getOne(); 

											if (pma != null) {
												PMA_get_user_profile action = new PMA_get_user_profile();
												action.setUserID(myUserID);
												Action act = new Action(pma, action);

												request = new ACLMessage(ACLMessage.REQUEST);
												request.addReceiver(pma);
												request.setOntology(MessagingOntology.getInstance().getName());
												request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
												request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
												myAgent.getContentManager().fillContent(request, act);

												requests = new Vector();
												requests.addElement(request);
											} else {
												throw new ServiceNotFoundException("Profiling service not found in DF.");
											}
										} catch (Exception e) {
											logger.log(Level.SEVERE, "Cannot prepare request to Restaurant service: ", e);
											doDelete();
										} 				
										return requests;
									}

									@Override
									protected void handleInform(ACLMessage inform) {			
										try {
											ContentManager manager = myAgent.getContentManager();
											Result r = (Result) manager.extractContent(inform);
											OWLData owldata = (OWLData) r.getValue();
											Memory mem = new Memory(owldata);
											String rootURI = (String) owldata.getWithRootURI().get(0);
											myUserProfile = UserModellingFactory.getUserProfile(rootURI, mem.getModel());
										} catch (Exception e) {
											logger.log(Level.SEVERE,"Cannot read INFORM message with OWLData or access user profile: ", e);
											doDelete();
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
						MessageTemplate mt = MessageTemplate.and(MessageTemplate
								.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST), MessageTemplate
								.MatchOntology(MessagingOntology.ONTOLOGY_NAME));
						
						// Now agent is ready to respond, start responder as 'root'
						// behaviour since it works cyclicly
						myAgent.addBehaviour(new PAResponder(myAgent, mt));	
						
						// Register at DF
						try {
							ServiceDescription sd = getServiceDescription();
							sd.addProperties(new Property(PersonalAgent.USER_ID_PARAM_KEY, myUserID));
							DFAgentDescription dfd = new DFAgentDescription();
							dfd.setName(getAID());
							dfd.addServices(sd);
							DFService.register(myAgent, dfd);
						} catch (FIPAException e) {
							logger.log(Level.SEVERE,"Cannot register agent at DF: ", e);
							myAgent.doDelete();
						}
					}
				});
			}
		});
	}

	@Override
	protected void activateProperties(Properties conf) {
	}
	
	public static ServiceDescription getServiceDescription() {
		ServiceDescription sd = new ServiceDescription();
		sd.setType(SERVICE_TYPE);
		sd.setName(SERVICE_NAME);
		sd.setOwnership(SERVICE_OWNERSHIP);
		return sd;
	}
	@Override
	protected void takeDown() {
		logger.info("Agent " + getName() + "goes down. Bye!");
	}

	

}
