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
package ibspan.tss.agents.rsa.handlers;

import ibspan.tss.agents.rsa.RestaurantServiceAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.messaging.RequestHandler;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import com.hp.hpl.jena.ontology.OntModel;

public class GetDomainOntologyHandler extends RequestHandler {

	private static Logger logger = Logger.getMyLogger(GetDomainOntologyHandler.class.getName());
	
	private OntModel mDomain;
	private RestaurantServiceAgent myAgent;
	
	public GetDomainOntologyHandler(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);
		
		myAgent = (RestaurantServiceAgent) a;
		
		mDomain = myAgent.getDomainModel();
	}

	@Override
	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {
		Memory memResults = new Memory(mDomain);
		ACLMessage response = request.createReply();

		// OWLData contains domain model together with inferred statements
		// and statements imported from other documents
		Result r = new Result(act, memResults.buildOWLData());

		try {
			myAgent.getContentManager().fillContent(response, r);
		} catch (Exception e) {
			throw new FailureException(e.getMessage());
		}

		response.setPerformative(ACLMessage.INFORM);

		return response;

		
	}
	
}
