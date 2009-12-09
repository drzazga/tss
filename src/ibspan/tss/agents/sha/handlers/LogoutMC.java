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

import ibspan.tss.agents.sha.mvc.ModelConstructor;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.PA_process_user_request;
import jade.content.ContentManager;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

import java.util.Vector;
import java.util.logging.Level;

/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class LogoutMC extends ModelConstructor {

	private static Logger logger = Logger.getMyLogger(LogoutMC.class.getName());
	
	// FSM states
	private static final String LOGOUT = "logout";
	private static final String REQUEST_PA = "request-pa";

	private ServiceFinder personalService;
	
	public LogoutMC(Agent a, DataStore ds) {
		super(a, ds); 

		personalService = myAgent.getPersonalService();
	
		registerDefaultTransition(REQUEST_PA, LOGOUT);
		
		Behaviour b;
		b = new OneShotBehaviour(myAgent) {
			public void action() {
				
				// Launch this requesting behaviour concurrently to other states of this FSM Behaviour
				myAgent.addBehaviour(new AchieveREInitiator(myAgent, null, getDataStore()) {
					@Override
					protected Vector prepareRequests(ACLMessage request) {
						Vector requests = null;
						try {
							int userID = getUserRequest().getUserContext().getUserID();

							AID pa = personalService.getOne(userID); 

							if (pa != null) {
								request = new ACLMessage(ACLMessage.REQUEST);
								request.addReceiver(pa);
								request.setOntology(MessagingOntology.ONTOLOGY_NAME);
								request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
								request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

								PA_process_user_request action = new PA_process_user_request();
								action.setActionName(getUserRequest().getActionName());
								action.setActionParams(getUserRequest().getActionParams());

								Action act = new Action();
								act.setAction(action);
								act.setActor(pa);

								myAgent.getContentManager().fillContent(request, act);

								requests = new Vector();
								requests.addElement(request);

			
							} else {
								throw new ServiceNotFoundException("Personal service not found in DF.");
							}
						} catch (Exception e) {
							logger.log(Level.SEVERE, "Cannot prepare request to Personal Agent: ", e);
						}	
						return requests;
					}

					@Override
					protected void handleInform(ACLMessage inform) {
						try {
							ContentManager manager = myAgent.getContentManager();
							Done d = (Done) manager.extractContent(inform);

							logger.info("Personal Agent has successfully logged out");
						} catch (Exception e) {
							logger.log(Level.SEVERE,"Cannot read INFORM message with Done: ", e);
							putError(new InternalSystemError());
						} 
					}

					@Override
					protected void handleFailure(ACLMessage failure) {
						logger.log(Level.INFO, "Responder failed to realize request.");
						putError(new InternalSystemError());
					}
				});
			}
		};
		registerFirstState(b, REQUEST_PA);
		
		b = new OneShotBehaviour(myAgent) {
			public void action() {
				try {
					// Update session info
					getCurrentSession().logoutUser();
					
					// Prepare model
					DataModel model = new DataModel();
					String actionName = getActionName();
					model.setConstructorActionName(actionName);
					
					// Build template describing screen into data model
					LayoutStructure template = templates.getCopy(actionName);
						
					Memory mem = new Memory(template);
					model.setOwlModel(mem.buildOWLData());
					
					// Leave results of building model in datastore
					putModel(model);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare model. ", e);
					putError(new InternalSystemError());
				} 
			}
		};
		registerLastState(b, LOGOUT);


	}
	

}
