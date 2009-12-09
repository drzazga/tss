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
package ibspan.tss.agents.sha.handlers;

import ibspan.tss.agents.pa.PersonalAgent;
import ibspan.tss.agents.sha.mvc.ModelConstructor;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.semantic.Util;
import ibspan.tss.dao.UsersDAO;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.InternalLink;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.layout.ontology.datamodel.MenuLink;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.PA_process_user_request;
import ibspan.tss.messaging.ontology.UserContext;
import ibspan.tss.messaging.ontology.UserRequest;
import jade.content.ContentManager;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;

/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class CheckLogin1MC extends ModelConstructor {
	// TODO Change the name of this class and reposponding name of the action in
	// ontology to CheckLoginMC and CheckLogin (no digit '1').

	private static Logger logger = Logger.getMyLogger(CheckLogin1MC.class.getName());
	
	// FSM states
	private static final String CHECK_DATA = "check-data";
	private static final String USE_PERSONAL_AGENT ="use-personal-agent";
	private static final String FINISH = "finish";

	private static final int CHECKING_SUCCESS = 1;
	private UsersDAO users;

	
	// user id and user name shared among sub-behaviours
	private int userID;
	private String userName;
	
	public CheckLogin1MC(Agent a, DataStore ds) {
		super(a, ds); 
		users = myAgent.getUsersDBInterface();
		
		// If have static controller which does not use any dynamicly
		// created data
		Behaviour b;
		
		b = new OneShotBehaviour(myAgent) {

			private int ret = 0;


			public void action() {
				DataModel model = new DataModel();
				String actionName = getActionName();

				UserRequest request = getUserRequest();

				// Construct template and choose action name
				LayoutStructure template = null;
				try {

					Map<String, String> params = Util.getMap(request
							.getActionParams());

					// setup user id, so other behaviour could use it
					String login = params.get(ViewParams.LOGIN_KEY);
					String password = params.get(ViewParams.PASSWORD_KEY);
					
					if (users.isLoginPasswordMatching(login, password)) {	
						userID = users.getUserID(login);
						userName = users.getUserName(userID);
						ret = CHECKING_SUCCESS;
						// results will be prepared in the USE_PERSONAL_AGENT
						// state
					} else {
						Link link = DataModelFactory.getLink(MenuLink.Login1,
								getTemplatesDB());
						model.setConstructorActionName(link.getHasActionName());
						template = templates.getCopy(link.getHasActionName());
						template.setHasErrorMessage("No such user or password and user not matching !");
						template.setHasText("Correct your data.");

						Memory mem = new Memory(template);
						model.setOwlModel(mem.buildOWLData());

						// Leave results of building model in datastore
						putModel(model);
					}
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare model. ", e);
					putError(new InternalSystemError());
				}
			}
			
			public int onEnd() {
				return ret;
			}
		};
		registerFirstState(b, CHECK_DATA);

		b = new AchieveREInitiator(myAgent, null, getDataStore()) {

			@Override
			protected Vector prepareRequests(ACLMessage request) {
				AgentController paController = null;
				try {
					

					paController = createPersonalAgent(userID, userName);
					AID pa = new AID( paController.getName(), true );
						
					request = new ACLMessage(ACLMessage.REQUEST);
					request.addReceiver(pa);
					request.setOntology(MessagingOntology.getInstance().getName());
					request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
					request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

					PA_process_user_request action = new PA_process_user_request();
					
					Link link = DataModelFactory.getLink(InternalLink.LoginSuccess, getTemplatesDB());   
					action.setActionName(link.getHasActionName());
					
					Action act = new Action();						
					act.setAction(action);
					act.setActor(pa);

					myAgent.getContentManager().fillContent(request, act);

					Vector requests = new Vector();
					requests.addElement(request);

					return requests;
				} catch (Exception e) {
					logger.log(Level.SEVERE,"Cannot prepare request to Personal Agent: ", e);
					putError(new InternalSystemError());
					killAgent(paController);
					return null;
				} 
				
			}

			protected void handleInform(ACLMessage inform) {
				try {
					
					ContentManager manager = myAgent.getContentManager();
					Result r = (Result) manager.extractContent(inform);
					DataModel model = (DataModel) r.getValue();
					putModel(model);
					
					// Add user id to the user context so next requests will be
					// signed by user id
					UserContext context = getUserRequest().getUserContext();
					context.setUserID(userID);
					
					// Log user
					getCurrentSession().loginUser(userID);
					
					
				} catch (Exception e) {
					logger.log(Level.SEVERE,"Cannot read INFORM message with DataModel: ", e);
					putError(new InternalSystemError());
				}					
			}	
			

			protected void handleFailure(ACLMessage failure) {			
				logger.log(Level.INFO, "Responder failed to realize request.");
				putError(new InternalSystemError());	
			}

		};
		registerState(b, USE_PERSONAL_AGENT);

		b = new OneShotBehaviour(myAgent) {
			public void action() {
				// Do nothing
			}
		};
		registerLastState(b, FINISH);

		registerDefaultTransition(CHECK_DATA, FINISH);
		registerTransition(CHECK_DATA, USE_PERSONAL_AGENT, CHECKING_SUCCESS);
		registerDefaultTransition(USE_PERSONAL_AGENT, FINISH);

	}

    private AgentController createPersonalAgent(int userID, String userName) throws StaleProxyException {
            Object[] args = { userID, userName };
            AgentContainer container = myAgent.getContainerController();
            AgentController c = container.createNewAgent( PersonalAgent.NAME_PREFIX + userID, PersonalAgent.class.getName(), args );
            c.start();
            return c;
    }
    
	private void killAgent(AgentController c) {
		try {
			c.kill();
		} catch (StaleProxyException e) {
			logger.log(Level.SEVERE, "Cannot kill already created Personal Agent. ", e);
        	putError(new InternalSystemError());
		}				
	}

}
