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
package ibspan.tss.agents.sha.mvc;

import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.UserRequest;
import ibspan.tss.messaging.ontology.VTA_construct_view;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.Vector;
import java.util.logging.Level;

/**
 * This class utilizes facility of ViewTransformingAgent (VTA) in order to
 * construct view from the model.
 * 
 * @author Maciej Gawinecki <maciej.gawinecki@ibspan.waw.pl>
 * 
 * @see ibspan.tss.agents.vta.ViewTransformingAgent
 */
public class SimpleViewConstructor extends ViewConstructor {
	
	private static Logger logger = Logger.getMyLogger(SimpleViewConstructor.class.getName());
	
	// Service finder gathering information about view transformers registered
	// in DF.
	private ServiceFinder viewTransformers;
	
	/**
	 * Constructs SimpleViewConstructor.
	 * 
	 * @param a
	 *            is the agent owning this behaviour.
	 * @param ds
	 *            is the DataStore for this constructor.
	 */
	public SimpleViewConstructor(Agent a, DataStore ds) {
		super(a, ds);

		viewTransformers = myAgent.getViewTransformers();
	}

	@Override
	protected Vector prepareRequests(ACLMessage request) {
		Vector requests = null;
		try {
			AID vta = viewTransformers.getOne();
			if (vta != null) {
				// There is necessary service.
				// Prepare request to VTA with the model constructed by the
				// ModelConstructor.
				request = new ACLMessage(ACLMessage.REQUEST);
				request.addReceiver(vta);
				request.setOntology(MessagingOntology.getInstance().getName());
				request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
				request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
				
				VTA_construct_view action = new VTA_construct_view();

				action.setModel(getModel());
	
				UserRequest userRequest = getUserRequest();
				action.setUserContext(userRequest.getUserContext());

				String actionName = getActionName();
				action.setActionName(actionName);

				Action act = new Action();
				act.setActor(vta);
				act.setAction(action);

				myAgent.getContentManager().fillContent(request, act);

				requests = new Vector();
				requests.addElement(request);
				
				return requests;
			} else {
				throw new ServiceNotFoundException("No view transforming service.");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Cannot prepare request to view transforming service: ", e);
			putError(new InternalSystemError());
		} 
		return requests;
	}

	@Override
	protected void handleInform(ACLMessage inform) {
		try {
			// Prepare INFORM response for Controller.
			ContentManager manager = myAgent.getContentManager();
			Result r = (Result) manager.extractContent(inform);
			DataView view = (DataView) r.getValue();
			putView(view);
			
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Cannot read INFORM message with DataView: ", e);
			putError(new InternalSystemError());
		} 		
	}	

	protected void handleFailure(ACLMessage failure) {
		putError(new InternalSystemError());		
	}
	
	
	
}
