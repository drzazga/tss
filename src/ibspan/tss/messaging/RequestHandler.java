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
package ibspan.tss.messaging;

import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

/**
 * This is simple behaviour class for responding to the requests with defined
 * {@link Action} object. The behaviours: (1) prepares the response by invoking
 * <code>prepareResponse()</code> method (which should be implemented by the
 * developer) and (2) put it in local datastore.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ibspan.tss.messaging.ActionDispatcher
 */
public abstract class RequestHandler extends OneShotBehaviour {
	
	private static Logger logger = Logger.getMyLogger(RequestHandler.class.getName());

	// Key pointing the place in local datastore, where incoming request can be
	// found.
	private Object requestKey;
	// Key in the DataStore where the Action concept extracted by the action
	// dispatcher from current request can be found.
	private Object actKey;
	// Key to retrieve from the DataStore of the behaviour the ACLMessage object
	// sent as a result notification to the initiator.
	private Object resultNotificationKey;
	
	/**
	 * Constructs <code>RequestHandler</code>.
	 * 
	 * @param a
	 *            is the agent owning this behaviour.
	 * @param ds
	 *            is the Datastore for this RequestHandler.
	 * @param requestKey
	 *            is key pointing the place in local datastore, where incoming
	 *            request can be found.
	 * @param actKey
	 *            is key in the DataStore where the Action concept extracted by the
	 *            action dispatcher from current request can be found.
	 * @param resultNotificationKey
	 *            is key to retrieve from the DataStore of the behaviour the
	 *            ACLMessage object sent as a result notification to the
	 *            initiator.
	 */
	public RequestHandler(Agent a, DataStore ds, Object requestKey, Object actKey, Object resultNotificationKey) {
		super(a);
		
		this.requestKey = requestKey;
		this.actKey = actKey;
		this.resultNotificationKey = resultNotificationKey;
		
		setDataStore(ds);
	}

	// Returns current ACL message with request.
	private ACLMessage getRequest() {
		return (ACLMessage) getDataStore().get(requestKey);
	}
	
	// Returns Action concept extracted by the action dispatcher from current request
	private Action getAct() {
		return (Action) getDataStore().get(actKey);
	}
	
	/**
	 * Two-stepped behaviour: (1) invokes and
	 * {@link #prepareResponse(ACLMessage,Action} method (2) puts returned
	 * response in local datastore.
	 */
	public final void action() {
		ACLMessage request = getRequest();
		try {
			ACLMessage result = prepareResponse(request, getAct());
			setResultNotication(result);
		} catch (NotUnderstoodException nue) {
			setResultNotication(nue.getACLMessage());
		} catch (FailureException fe) {
			setResultNotication(fe.getACLMessage());
		}
	}
		
	/**
	 * Returns response to the request. Programmers should implenets this method
	 * in order process given request.
	 * 
	 * @param request
	 *            is message.
	 * @param act
	 *            is <code>Action</code> concept extracted previously from
	 *            <code>request</code> object.
	 * @return response; <code>null</code> means failure.
	 * @throws NotReadableRequestException
	 *             when it is not possible to parse request message.
	 * @throws NotFormableResponseException
	 *             when it is not possible to form response message.
	 */
	protected abstract ACLMessage prepareResponse(ACLMessage request, Action act) throws NotUnderstoodException, FailureException;
	
	private void setResultNotication(ACLMessage result) {
		getDataStore().put( resultNotificationKey, result );
	}
}
