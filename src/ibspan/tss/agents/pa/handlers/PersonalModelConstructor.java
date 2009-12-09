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

import ibspan.tss.agents.pa.PersonalAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.layout.TemplatesRegister;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.PA_process_user_request;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;
import jade.util.leap.Serializable;

import java.util.logging.Level;

/**
 * This behaviour constructs model of data in Model-View-Controller
 * architecture.
 * 
 * This class should not be used directly, but extended. As a result of it
 * action it should, eventually, put constructed <code>DataModel</code> object
 * with use of {@link #putModel(DataModel)} method or infrom about
 * <code>InternalSystemError</code> by calling
 * {@link #putError(InternalSystemError)} method. Returned
 * <code>DataModel</code> should contain at least contain
 * <code>LayoutStructure</code> object, fetched from
 * <code>TemplatesRegister</code> object, provided by the Agent this behaviour
 * belongs to.
 * 
 * <p>
 * This implementation provides methods for backing up results of their action
 * and restoring them: {@link #backUpResult(Memory)} and
 * {@link #getBackedUpResult()}.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * 
 * 
 * @see DataModel
 * @see InternalSystemError
 * @see LayoutStructure
 * @see TemplatesRegister
 */
public abstract class PersonalModelConstructor extends FSMBehaviour {
	
	private static Logger logger = Logger.getMyLogger(PersonalModelConstructor.class.getName());

	// Key under which back-up results are stored DataStore.
	private final static String BACKED_UP_RESULTS_KEY = "backed-up-results";	
	
	// Key for accessing user request ACL message from local Data Store.
	private Object requestKey;
	// The key in the DataStore where the Action concept extracted from current
	// request can be found.
	private Object actKey;
	// The key in the DataStore where the name of action resolved by action
	// dispatcher - for current request - can be found.
	private Object actionNameKey;
	// The key in the DataStore where the results of work of this constructor
	// will be put.
	private Object resultNotificationKey;
	
	// Register of templates used to build screen layouts.
	protected TemplatesRegister templates;
	// The agent this behaviour belongs to.
	protected PersonalAgent myAgent;
	
	/**
	 * Constructs <code>PersonalModelConstructor</code> object.
	 * 
	 * @param a
	 *            is the agent this behaviour belongs to.
	 * @param ds
	 *            is data store
	 * @param requestKey
	 *            key for accessing user request ACL message from local
	 *            DataStore
	 * @param actKey
	 *            key for accessing action of user request from local DataStore
	 * @param actionNameKey
	 *            key for accessing action name of user request from local
	 *            DataStore
	 * @param resultNotificationKey
	 *            key in local Data Store, where result of
	 *            PersonalModelConstructor behaviour should be put at
	 */
	public PersonalModelConstructor(Agent a, DataStore ds, Object requestKey, Object actKey, Object actionNameKey, Object resultNotificationKey) {
		super(a);	
		setDataStore(ds);
		myAgent = (PersonalAgent) a;
		
		this.requestKey = requestKey;
		this.actKey = actKey;
		this.actionNameKey = actionNameKey;
		this.resultNotificationKey = resultNotificationKey;
		
		templates = myAgent.getTemplates();
	}
	
	// Prepare ACL message with Result predicate containing given 'returned'
	// object
	private void putResponse(Serializable returned) {
		try {
			Result result = new Result();
			result.setAction(getAct());

			ACLMessage response = getRequest().createReply();

			if (returned instanceof DataModel) {
				// everything OK
				result.setValue(returned);
				response.setPerformative(ACLMessage.INFORM);
			} else if (returned instanceof InternalSystemError) {
				// some error occured
				result.setValue(returned);
				response.setPerformative(ACLMessage.FAILURE);
			} else {
				logger.severe("Unknown type of result");
				response.setPerformative(ACLMessage.FAILURE);
				result.setValue(new InternalSystemError());
			}

			myAgent.getContentManager().fillContent(response, result);

			getDataStore().put(resultNotificationKey, response);

		} catch (UngroundedException e) {
			logger.log(Level.SEVERE,"Cannot form response:", e);
		} catch (CodecException e) {
			logger.log(Level.SEVERE,"Cannot form response:", e);
		} catch (OntologyException e) {
			logger.log(Level.SEVERE,"Cannot form response:", e);
		}
	}

	/**
	 * Puts the given model in the DataStore as the result of successful
	 * constructing.
	 * 
	 * @param model
	 *            is the result model of construction.
	 */
	protected void putModel(DataModel model) {
		putResponse(model);
	}
	
	/**
	 * Puts the given error in the DataStore in case of constructing failure.
	 * 
	 * @param error
	 *            is the error encounter during constructing process.
	 */
	protected void putError(InternalSystemError error) {
		putResponse(error);
	}

	/**
	 * Returns Action concept extracted from the current request.
	 * 
	 * @return Action concept.
	 */
	protected Action getAct() {
		return (Action) getDataStore().get(actKey);
	}
	
	/**
	 * Returns action concept extracted from current request.
	 * 
	 * @return action.
	 */
	protected PA_process_user_request getAction() {
		Action act = getAct();;
		return (PA_process_user_request) act.getAction()  ;
	}
	
	protected ACLMessage getRequest() {		 
		return (ACLMessage) getDataStore().get(requestKey);
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
	
	/**
	 * Puts the given result in local DataStore.
	 * 
	 * @param result
	 *            to be backed-up.
	 */
	protected void backUpResult(Memory result) {
		getDataStore().put(BACKED_UP_RESULTS_KEY, result);
	}
	
	/**
	 * Returns previously backed-up result.
	 * 
	 * @return back-up result or <code>null</code> if backed-up result was
	 *         <code>null</code> or no result has been backed up, yet.
	 */
	protected Memory getBackedUpResult() {
		return (Memory) getDataStore().get(BACKED_UP_RESULTS_KEY);
	}
	
}
