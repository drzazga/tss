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
import ibspan.tss.agents.sha.session.Session;
import ibspan.tss.layout.TemplatesRegister;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.SHA_process_user_request;
import ibspan.tss.messaging.ontology.UserRequest;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;
import jade.util.Logger;

import com.hp.hpl.jena.ontology.OntModel;

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
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see DataModel
 * @see InternalSystemError
 * @see LayoutStructure
 * @see TemplatesRegister
 */
public abstract class ModelConstructor extends FSMBehaviour {
	// TODO Construct ModelConstructor in such a way it throws an error when
	// returned DataModel does not contain at least template. And this
	// ModelConstructor should be responsible for combining template
	// (LayoutStructure) and OWL data into single OWLData object.
	
	private static Logger logger = Logger.getMyLogger(ModelConstructor.class.getName());

	// The key in the DataStore where the Action concept extracted from current
	// request can be found.
	private Object actKey;
	// The key in the DataStore where the name of action resolved by action
	// dispatcher - for current request - can be found.
	private Object actionNameKey;
	// The key in the DataStore where the results of work of this constructor
	// will be put.
	private Object resultKey;
	
	
	// Register of templates used to build screen layouts.
	protected TemplatesRegister templates;
	// The agent is behaviour belongs to.
	protected SessionHandlingAgent myAgent;
		
	// The result state of this constructor.
	private int ret;
	
	/**
	 * Constructs ModelConstructor.
	 * 
	 * @param a
	 *            is the agent owning this behaviour.
	 * @param ds
	 *            is the DataStore for this constructor.
	 */
	public ModelConstructor(Agent a, DataStore ds) {
		super(a);
		myAgent = (SessionHandlingAgent) a;
		setDataStore(ds);
		
		templates = myAgent.getTemplates();

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

	public int onEnd() {
		return ret;
	}
	
	/**
	 * Puts the given model in the DataStore as the result of successful
	 * constructing.
	 * 
	 * @param model
	 *            is the result model of construction.
	 */
	protected void putModel(DataModel model) {
		getDataStore().put(resultKey, model);
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
	
	/**
	 * Returns the register of templates used to build screen layouts.
	 * 
	 * @return the register of templates.
	 */
	protected OntModel getTemplatesDB() {
		return myAgent.getTemplatesDBModel();
	}
	
	/**
	 * Returns the session to which currently service request belongs to.
	 * 
	 * @return current session.
	 */
	protected Session getCurrentSession() {
		String sessionID = getUserRequest().getUserContext().getSessionID();
		return myAgent.getSessions().getSession(sessionID);
	}
}
