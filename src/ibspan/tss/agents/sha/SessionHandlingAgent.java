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
package ibspan.tss.agents.sha;

import ibspan.tss.agents.SystemAgent;
import ibspan.tss.agents.pa.PersonalAgent;
import ibspan.tss.agents.pma.ProfileManagingAgent;
import ibspan.tss.agents.pra.ProxyAgent;
import ibspan.tss.agents.sha.history.HistoryLogger;
import ibspan.tss.agents.sha.history.HistorySubscriptionManager;
import ibspan.tss.agents.sha.session.SessionsMap;
import ibspan.tss.agents.vta.ViewTransformingAgent;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.core.storage.ModelLoaderInitException;
import ibspan.tss.dao.DAOException;
import ibspan.tss.dao.HistoryDAO;
import ibspan.tss.dao.UsersDAO;
import ibspan.tss.layout.TemplatesRegister;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.FormLink;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.layout.ontology.datamodel.MenuLink;
import ibspan.tss.layout.vocabulary.TemplatesDBVocabulary;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceFinderException;
import ibspan.tss.messaging.ServiceWaiter;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.um.ontology.UserBehaviour;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.vocabulary.HistoryDBVocabulary;
import ibspan.tss.um.vocabulary.UserModellingVocabulary;
import ibspan.tss.um.vocabulary.UsersDBVocabulary;
import jade.content.lang.sl.SLCodec;
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
import jade.proto.SubscriptionResponder;
import jade.util.Logger;
import jade.util.leap.Iterator;

import java.util.Properties;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

/**
 * The centerpoint of the system mainly responsible for realizing user requests.
 * It provides the following functionality:
 * <ul>
 * <li>Plays role of controller in Model-View-Controller architecture: receives
 * user requests from <code>ProxyAgent</code>, realize them itself (or
 * delegates <code>PersonalAgent</code> to do it), requests
 * <code>ViewTransformingAgent</code> for transforming results into
 * browser-readable form and return the result to the <code>ProxyAgent</code>.
 * <li>Tracks session of interaction with the user: identify connection
 * incoming from the same machines and authorizes user access to these features
 * of the system, which need the user to be registrated and logged in.
 * <li>Logs requests of authorized user into <i>History</i> model and provides
 * these data to <code>ProfileManagingAgent</code> for learning purposes.
 * <li>Realizes the following user scenarios: registration (and creating user
 * account), logging in and logging out.
 * </ul>
 * 
 * <p>
 * This functionality requires the following agents to be registrated in
 * <i>DirectoryFacilator</i> before this agent starts working:
 * <ul>
 * <li><code>ViewTransformingAgent</code> -- for transforming prepared system
 * responses,
 * <li><code>ProfileManagingAgent</code> -- for initiliazing new user
 * profile.
 * </ul>
 * Additionally, when the user logs in, <code>SessionHandlingAgent</code>
 * creates her representant in the system -- <code>PersonalAgent</code>,
 * which will be responsible for realizing her requests until log out action.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ProfileManagingAgent
 * @see ViewTransformingAgent
 * @see ProxyAgent
 * @see PersonalAgent
 */
public final class SessionHandlingAgent extends SystemAgent {

	private static Logger logger = Logger.getMyLogger(SessionHandlingAgent.class.getName());
	
	// Description of the service this agent provides
	public final static String SERVICE_NAME = "Session Handling Service";
	public final static String SERVICE_TYPE = "session-handling-service";
	public final static String SERVICE_OWNERSHIP = "Travel Support System";
	
	private OntModel mHistoryDB;
	private OntModel mTemplatesDB;
	private OntModel mUsersDB;
	private OntModel mUM;
	private ServiceFinder viewTransformers;
	private ServiceFinder personalService;	
	private ServiceFinder profilingService;		
	private UsersDAO users;
	private HistoryDAO daoHistory;
	private TemplatesRegister templates;
	private SessionsMap sessions;
	private HistoryLogger historyLogger;
	
	private SubscriptionResponder historySubscriptionResponder;
	private HistorySubscriptionManager subManager;
	
	//*****************************************
	// Provides models for behaviours
	//*****************************************
	
	/**
	 * @return
	 */
	public HistoryDAO getHistoryDAO() 				{ return daoHistory; }
	/**
	 * @return
	 */
	public OntModel getTemplatesDBModel() 			{ return mTemplatesDB; }
	/**
	 * @return
	 */
	public OntModel getUMModel() 					{ return mUM; }
	
	//******************************************
	// Provides service finders for behaviours.
	//******************************************	
	
	/**
	 * Returns service finder gathering information about view transformers
	 * registered in DF.
	 * 
	 * @return service finder for view transformers
	 */
	public ServiceFinder getViewTransformers()		{ return viewTransformers; }
	/**
	 * Returns service finder gathering information about personal agents.
	 * Particular agent is identified by <i>userID</i> of the user it
	 * represents and can be accessed by use of {@link ServiceFinder#getOne(Object)} method.
	 * 
	 * @return service finder for personal agents
	 */
	public ServiceFinder getPersonalService()		{ return personalService; }
	/**
	 * Return service finder gathering information about profile managing
	 * services.
	 * 
	 * @return service finder for profiling service
	 */
	public ServiceFinder getProfilingService()		{ return profilingService; }	
	
	//*****************************************
	// Provides other necessary components for 
	// behaviours.
	//*****************************************		
	
	public UsersDAO getUsersDBInterface() 	{ return users; }
	/**
	 * Return register of templates, which behaviours uses to construct layout
	 * of screen returned to the user.
	 * 
	 * @return register of templates
	 */
	public TemplatesRegister getTemplates() 		{ return templates; }
	/**
	 * Returns map of sessions this agent is engades with the user.
	 * 
	 * @return sessions map
	 */
	public SessionsMap getSessions()				{ return sessions; }
	
	/**
	 * Constructs SessionHandlingAgent.
	 */
	public SessionHandlingAgent() {
		super();					
	
		//**************************************
		// Read necessary ontology models.
		//**************************************
		try {
			logger.info("Loading History from DB ...");
			mHistoryDB = ModelLoader.loadDBModel(HistoryDBVocabulary.NS);
			logger.info("Done.");
			
			logger.info("Loading Users from DB ...");
			mUsersDB = ModelLoader.loadDBModel(UsersDBVocabulary.NS);
			logger.info("Done.");
			
			logger.info("Loading Templates from file into memory ...");
			mTemplatesDB = ModelLoader.loadModel(TemplatesDBVocabulary.NS);
			logger.info("Done.");
			
			logger.info("Loading User Modelling ontology from file into memory ...");
			mUM = ModelLoader.loadModel(UserModellingVocabulary.NS);
			logger.info("Done.");
		} catch (ModelLoaderInitException e) {
			logger.log(Level.SEVERE,"Problem while initializing ModelLoader.", e);
			doDelete();			
		}
		
		// Prepare interface to model with playingUsers data
		try {
			users = new UsersDAO(mUsersDB);
			daoHistory = new HistoryDAO(mHistoryDB);
		} catch (DAOException e) {
			logger.log(Level.SEVERE,"Problem while initializing DAOs.", e);
			doDelete();		
		}
		
		templates = new TemplatesRegister();
		sessions = new SessionsMap();
		subManager = new HistorySubscriptionManager(this, daoHistory);	

		
	}
	
	@Override
	protected void activateProperties(Properties conf) {		
	}	

	@Override
	protected void setup() {		
		getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
		getContentManager().registerOntology(MessagingOntology.getInstance());
	
		try {
			//***********************************
			// Prepare necessary service finders
			//***********************************
			profilingService = new ServiceFinder(this, ProfileManagingAgent.getServiceDescription());			
			viewTransformers = new ServiceFinder(this, ViewTransformingAgent.getServiceDescription());
			personalService = new ServiceFinder(this, PersonalAgent.getServiceDescription())  {
				public final Object createKey(DFAgentDescription dfd) {
					for(Iterator j = dfd.getAllServices(); j.hasNext();) {
						ServiceDescription sd = (ServiceDescription) j.next();
						for(Iterator k = sd.getAllProperties(); k.hasNext(); ) {
							Property p = (Property) k.next();
							if (p.getName().equals(PersonalAgent.USER_ID_PARAM_KEY)) {
								return Integer.parseInt((String)p.getValue());
							}
						}
					}
					return null;
				}		
			};		
		} catch (ServiceFinderException e) {
			logger.log(Level.SEVERE,"Problem while creating service finders: ", e);
			doDelete();
			return;
		}
		
		//******************************************
		// Start sequential behaviour, which checks 
		// necessary environments conditions before
		// registration in DF
		//******************************************
		addBehaviour(new SequentialBehaviour(this) {
			public void onStart() {				
				// Add behaviour waiting for registration of services the agent
				// depends on.
				addSubBehaviour(new ParallelBehaviour(myAgent, ParallelBehaviour.WHEN_ALL) {
					
					public void onStart() {
						// Add behaviour which finish, when view transforming
						// services are found.
						addSubBehaviour(new ServiceWaiter(myAgent, viewTransformers));
					}
				});
				
				addSubBehaviour(new OneShotBehaviour(myAgent) {
					public void action() {
						MessageTemplate mt;
						
						//****************************************************
						// Initializing behaviors dealing with subscriptions.
						//****************************************************
						mt = MessageTemplate.and(MessageTemplate.and(MessageTemplate.and(
								MessageTemplate.MatchLanguage(FIPANames.ContentLanguage.FIPA_SL0),
								MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_SUBSCRIBE)),
								MessageTemplate.MatchOntology(MessagingOntology.ONTOLOGY_NAME)),
								MessageTemplate.or(MessageTemplate.MatchPerformative(ACLMessage.SUBSCRIBE), MessageTemplate.MatchPerformative(ACLMessage.CANCEL)));
						
						// Registers subscription responder with the given
						// subManager, which will be used to delegate all
						// registration and deregistration message from
						// subscribers to.
						historySubscriptionResponder = new SubscriptionResponder(myAgent, mt, subManager);
						subManager.setContentManager(getContentManager());
						myAgent.addBehaviour(historySubscriptionResponder);
						
						// Creates historyLogger which will only log events in
						// History model but also forward them to the givne
						// subManager, responsible for notifying subscribers
						// about them.
						historyLogger = new HistoryLogger(daoHistory, subManager);
						
						//*****************************************
						// Register loggable actions in 
						// historyLogger.
						//*****************************************
						try {
							Link link;
							UserBehaviour behaviour;
							
							link = DataModelFactory.getLink(MenuLink.DefineSearch, mTemplatesDB);
							behaviour = UserModellingFactory.getUserBehaviour(UserBehaviour.EntrySearchingBehaviour.getURI(), mUM);
							historyLogger.registerLoggableAction(link.getHasActionName(), behaviour);
							
							link = DataModelFactory.getLink(FormLink.Search, mTemplatesDB);
							behaviour = UserModellingFactory.getUserBehaviour(UserBehaviour.QueryForRestaurantBehaviour.getURI(), mUM);
							historyLogger.registerLoggableAction(link.getHasActionName(), behaviour);
							
							link = DataModelFactory.getLink(MenuLink.ShowDetails, mTemplatesDB);
							behaviour = UserModellingFactory.getUserBehaviour(UserBehaviour.ClickForRestaurantDetailsBehaviour.getURI(), mUM);
							historyLogger.registerLoggableAction(link.getHasActionName(), behaviour);
						} catch (JastorException e) {
							logger.log(Level.SEVERE, "Cannot register loggable actions", e);
							doDelete();
							return;
						}
						
						mt = MessageTemplate.and(MessageTemplate
								.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST), MessageTemplate
								.MatchOntology(MessagingOntology.ONTOLOGY_NAME));
						
						// Now the agent is ready to respond -- register
						// SHAResponder to respond to incoming requests and
						// forwards all infromation about them to the ginven the
						// given historyLogger.
						myAgent.addBehaviour(new SHAResponder(myAgent, mt, historyLogger));
						
						try {			
							// Register at DF.
							ServiceDescription sd = getServiceDescription();			
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

	/**
	 * Returns information about the service this agent provides.
	 * 
	 * @return service description
	 */
	public static ServiceDescription getServiceDescription() {
		ServiceDescription sd = new ServiceDescription();
		sd.setType(SERVICE_TYPE);
		sd.setName(SERVICE_NAME);
		sd.setOwnership(SERVICE_OWNERSHIP);
		return sd;
	}
}
