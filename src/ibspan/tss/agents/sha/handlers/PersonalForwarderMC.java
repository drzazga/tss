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
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.PA_process_user_request;
import jade.content.ContentManager;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

import java.util.Vector;
import java.util.logging.Level;

/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class PersonalForwarderMC extends ModelConstructor {

	private static Logger logger = Logger.getMyLogger(PersonalForwarderMC.class.getName());

	// FSM states
	private static final String FORWARD_INITIATOR = "forward-initiator";

	private ServiceFinder personalService;
	
	public PersonalForwarderMC(Agent a, DataStore ds) {
		super(a, ds);

		personalService = myAgent.getPersonalService();
		
		// If have static controller which does not use any dynamicly
		// created data

		Behaviour b = new AchieveREInitiator(myAgent, null, getDataStore()) {
			Vector requests = null;
			
			@Override
			protected Vector prepareRequests(ACLMessage request) {
				try {
					int userID = getUserRequest().getUserContext().getUserID();

					AID pa = personalService.getOne(userID); 

					if (pa != null) {
						request = new ACLMessage(ACLMessage.REQUEST);
						request.addReceiver(pa);
						request.setOntology(MessagingOntology.ONTOLOGY_NAME);
						request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
						request
								.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

						PA_process_user_request action = new PA_process_user_request();
						action.setActionName(getUserRequest().getActionName());
						action.setActionParams(getUserRequest()
								.getActionParams());

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
					putError(new InternalSystemError());
				} 
				
				return requests;
				
			}

			@Override
			protected void handleInform(ACLMessage inform) {
				try {

					ContentManager manager = myAgent.getContentManager();
					Result r = (Result) manager.extractContent(inform);
					DataModel model = (DataModel) r.getValue();
					putModel(model);

				} catch (Exception e) {
					logger.log(Level.SEVERE,"Cannot read INFORM message with DataModel: ", e);
					putError(new InternalSystemError());
				} 
			}

			@Override
			protected void handleFailure(ACLMessage failure) {
				logger.log(Level.INFO, "Responder failed to realize request.");
				putError(new InternalSystemError());
			}
		};
		registerFirstState(b, FORWARD_INITIATOR);
		registerLastState(b, FORWARD_INITIATOR);

	}

}
