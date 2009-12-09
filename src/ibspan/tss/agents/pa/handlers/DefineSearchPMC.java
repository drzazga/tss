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
package ibspan.tss.agents.pa.handlers;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.OWLData;
import ibspan.tss.messaging.ontology.RSA_get_domain_ontology;
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
public class DefineSearchPMC extends PersonalModelConstructor {

	private static Logger logger = Logger.getMyLogger(DefineSearchPMC.class.getName());

	// FSM states
	private static final String GET_DOMAIN_INITIATOR = "get-domain-initiator";

	private ServiceFinder restaurantService;
	
	
	
	public DefineSearchPMC(Agent a, DataStore ds, Object requestKey, Object actKey, Object actionNameKey, Object resultNotificationKey) {
		super(a, ds, requestKey, actKey, actionNameKey, resultNotificationKey);

		restaurantService = myAgent.getRestaurantService();
		
		// If have static controller which does not use any dynamicly
		// created data

		Behaviour b = new AchieveREInitiator(myAgent, null, getDataStore()) {

			@Override
			protected Vector prepareRequests(ACLMessage request) {
				Vector requests = null;
				
				try {
					AID rsa = restaurantService.getOne(); 

					if (rsa != null) {
						request = new ACLMessage(ACLMessage.REQUEST);
						request.addReceiver(rsa);
						request.setOntology(MessagingOntology.getInstance().getName());
						request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
						request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

						RSA_get_domain_ontology action = new RSA_get_domain_ontology();

						Action act = new Action(rsa, action);

						myAgent.getContentManager().fillContent(request, act);

						requests = new Vector();
						requests.addElement(request);

						
					} else {
						throw new ServiceNotFoundException("Restaurant service not found in DF.");
					}
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare request to Restaurant service: ", e);
					putError(new InternalSystemError());
				} 
				return requests;
				
			}

			@Override
			protected void handleInform(ACLMessage inform) {			
				try {
					ContentManager manager = myAgent.getContentManager();
					Result r = (Result) manager.extractContent(inform);
					OWLData owldata = (OWLData) r.getValue();
					
					String actionName = getActionName();

					// Build template describing screen into data model
					LayoutStructure template = templates.getCopy(actionName);
					Memory mem = new Memory();
					mem.add(template);
					mem.add(owldata);

					DataModel model = new DataModel();
					model.setConstructorActionName(actionName);
					model.setOwlModel(mem.buildOWLData());
					
					// Leave results of building model in datastore
					putModel(model);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare model. ", e);
					putError(new InternalSystemError());
				} 
			}

			@Override
			protected void handleFailure(ACLMessage failure) {
				logger.log(Level.INFO, "Responder failed to realize request.");
				putError(new InternalSystemError());
			}
		};
		registerFirstState(b, GET_DOMAIN_INITIATOR);
		registerLastState(b, GET_DOMAIN_INITIATOR);

	}

}
