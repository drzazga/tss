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
package ibspan.tss.agents.vta;

import ibspan.tss.agents.vta.handlers.MyTransformer;
import ibspan.tss.agents.vta.handlers.ViewTransformer;
import ibspan.tss.messaging.ActionDispatcher;
import ibspan.tss.messaging.ontology.VTA_construct_view;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import jade.proto.states.HandlerSelector;

/**
 * This is of Responder for <code>ViewTransformingAgent</code>. It works in
 * an iterative manner.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ViewTransformingAgent
 */
public class VTAResponder extends AchieveREResponder {

	public final String ACTION_KEY = "__action" + hashCode();
	
	public VTAResponder(Agent a, MessageTemplate mt) {
		super(a, mt);

		HandlerSelector selector = new ActionDispatcher(myAgent,getDataStore(), REQUEST_KEY, ACTION_KEY);

		ViewTransformer vt = new MyTransformer(myAgent, getDataStore(),
				REQUEST_KEY, ACTION_KEY, RESULT_NOTIFICATION_KEY);
		selector.registerHandler(VTA_construct_view.class.getName(), vt);

		registerPrepareResultNotification( selector );
	}
	
    protected ACLMessage prepareResponse(ACLMessage request) throws NotUnderstoodException, RefuseException {
    	// Don't say AGREE or REFUSE exlipictly; no response means AGREE
        return null;
    }
    

}
