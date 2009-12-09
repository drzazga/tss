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

import ibspan.tss.agents.sha.SessionHandlingAgent;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.SHA_process_user_request;
import ibspan.tss.messaging.ontology.UserRequest;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

/**
 * This behaviour provides a set of methods for constructing view of data in
 * Model-View-Controller architecture by utilizing another agent providing view
 * transforming service.
 * 
 * This class should not be used directly, but extended by implementing
 * {@link #prepareRequests(ACLMessage)}, {@link #handleInform(ACLMessage)},
 * {@link #handleFailure(ACLMessage)} methods, which eventually leaves results
 * of their action, either <code>DataView</code> or
 * <code>InternalSystemError</code object> by calling either {@link #putView(DataView)} or
 * {@link #putError(InternalSystemError), accordingly.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see DataView
 * @see InternalSystemError
 */
public abstract class ViewConstructor extends AchieveREInitiator {
	
	private static Logger logger = Logger.getMyLogger(ViewConstructor.class.getName());

	// The key in the DataStore where the Action concept extracted from current
	// request can be found.
	private Object actKey;
	// The key in the DataStore where the name of action resolved by action
	// dispatcher - for current request - can be found.
	private Object actionNameKey;
	// The key in the DataStore where the results of work of this constructor
	// will be put.
	private Object resultKey;
	
	// The agent this behaviours belongs to.
	protected SessionHandlingAgent myAgent;
		
	// The result state of this constructor.
	private int ret;
	
	/**
	 * Constructs ViewConstructor.
	 * 
	 * @param a
	 *            is the agent owning this behaviour.
	 * @param ds
	 *            is the DataStore for this constructor.
	 */
	public ViewConstructor(Agent a, DataStore ds) {
		super(a, null, ds);
		myAgent = (SessionHandlingAgent) a;

		ret = Controller.FAILURE_OF_CONSTRUCT;
	}

	/**
	 * Sets the keys necessary for the work of this behaviour.
	 * 
	 * @param actKey
	 *            is the key in the DataStore where the {@link Action} concept
	 *            extracted from current request can be found.
	 * @param actionNameKey
	 *            is tThe key in the DataStore where the name of action resolved
	 *            by action dispatcher - for current request - can be found.
	 * @param resultKey
	 *            is the key in the DataStore where the results of work of this
	 *            constructor will be put.
	 */
	public void setAccessKeys(Object actKey, Object actionNameKey, Object resultKey) {
		this.actKey = actKey;
		this.actionNameKey = actionNameKey;
		this.resultKey = resultKey;
	}
	
	@Override
	public int onEnd() {
		return ret;
	}

	/**
	 * Returns the model constructed by the <code>ModelConstructor</code>.
	 * 
	 * @return constructred model.
	 * 
	 * @see ModelConstructor
	 */
	protected DataModel getModel() {
		return (DataModel) getDataStore().get(resultKey);
	}
	
	/**
	 * Puts the given view in the DataStore as the result of successful
	 * constructing.
	 * 
	 * @param view
	 *            is the result view of construction.
	 */
	protected void putView(DataView view) {
		getDataStore().put(resultKey, view);
		ret = Controller.SUCCESS_OF_CONSTRUCT;
	}
	
	/**
	 * Puts the given error in the DataStore in case of constructing failure.
	 * 
	 * @param error
	 *            is the error encounter during constructing process.
	 */
	protected void putError(InternalSystemError error) {
		getDataStore().put(resultKey, error);
	}
	
	/**
	 * Returns action concept extracted from current request.
	 * 
	 * @return action.
	 */
	protected SHA_process_user_request getAction() {
		Action act = (Action) getDataStore().get(actKey);
		return (SHA_process_user_request) act.getAction()  ;
	}
	
	/**
	 * Returns concept of current user request.
	 * 
	 * @return user request.
	 */
	protected UserRequest getUserRequest() {
		SHA_process_user_request action = getAction(); 
		return (UserRequest) action.getUserRequest();
	}
	
	/**
	 * Returns the name of action resolved by action dispatcher for current
	 * request.
	 * 
	 * @return name of the action.
	 */
	protected String getActionName() {
		return (String) getDataStore().get(actionNameKey);
	}

}
