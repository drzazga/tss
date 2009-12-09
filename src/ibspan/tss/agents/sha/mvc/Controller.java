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

import ibspan.tss.messaging.RequestHandler;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.InternalSystemError;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.logging.Level;

/**
 * This behaviour plays the role of controller in Model-View-Controller
 * architecture.
 * 
 * Invokes {@link ModelConstructor} which constructs
 * {@link ibspan.tss.messaging.ontology.DataModel} object according to the user
 * request and then calles {@link ViewConstructor}, which transforms this model
 * into {@link ibspan.tss.messaging.ontology.ViewModel} object. If any of this
 * action failed, then message with {@link InternalSystemError} concept will be put as
 * result notification; otherwise the constructed <code>DataView</code> is put
 * as a result.
 * 
 * The developer is provided with methods for registering both:
 * <code>ModelConstructor</code> and <code>ViewConstructor</code>.
 * Registration provides also both constructors with keys to access the
 * following data in local DataStore: <code>action</code> and
 * <code>actionName</code> (extracted from request by
 * {@link ibspan.tss.agents.sha.session.ActionDispatcherWithSessionTracking})
 * and the key ({@link CONSTRUCTED_RESULT_KEY}) for exchanging model and view
 * among constructors and controller, too.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</A>
 */
public class Controller extends FSMBehaviour {

	private static Logger logger = Logger.getMyLogger(Controller.class.getName());
	
	// Keys to access data in DataStore ?
	public final String CONSTRUCTED_RESULT_KEY = "___result" + hashCode();
	
	// FSM States
	private static final String INIT = "init";
	private static final String CONSTRUCTING_MODEL = "constructing-model";
	private static final String CONSTRUCTING_VIEW = "constructing-view";
	private static final String ERROR_HANDLING = "error-handling";
	private static final String PREPARING_NOTIFICATION = "preparing-notification";
	
	// States exit values
	public final static int SUCCESS_OF_CONSTRUCT = 1;
	public final static int FAILURE_OF_CONSTRUCT = 0;
	
	private Object actKey;
	private Object actionNameKey;
	
	/**
	 * Constructs Controller.
	 * 
	 * @param a
	 *            is the agent this behaviour belongs to.
	 * @param ds
	 *            data store
	 * @param actKey
	 *            key for accessing action of user request from local DataStore
	 * @param actionNameKey
	 *            key for accessing action name of user request from local
	 *            DataStore
	 * @param requestKey
	 *            key for accessing user request ACL message from local
	 *            DataStore
	 * @param notificationKey
	 *            key in local Data Store, where result of Controller behaviour
	 *            should be put at
	 */
	public Controller(Agent a, DataStore ds, Object requestKey, Object notificationKey,Object actKey, Object actionNameKey) {
		super(a);
		
		setDataStore(ds);
		
		this.actKey = actKey;
		this.actionNameKey = actionNameKey;
		this.actKey = actKey;
		
		Behaviour b = null;
		
		registerDefaultTransition(INIT, CONSTRUCTING_MODEL);
		registerTransition(CONSTRUCTING_MODEL, CONSTRUCTING_VIEW, SUCCESS_OF_CONSTRUCT);
		registerDefaultTransition(CONSTRUCTING_MODEL, ERROR_HANDLING);
		registerTransition(CONSTRUCTING_VIEW, PREPARING_NOTIFICATION, SUCCESS_OF_CONSTRUCT);
		registerDefaultTransition(CONSTRUCTING_VIEW, ERROR_HANDLING);
		registerDefaultTransition(ERROR_HANDLING, PREPARING_NOTIFICATION);
		
		b = new OneShotBehaviour() {
			public void action() {
				// Clear results from last request
				getDataStore().remove(CONSTRUCTED_RESULT_KEY);
			}
		};
		registerFirstState(b, INIT);
		
		b = new OneShotBehaviour() {
			public void action() {
				// Check whether behaviour generated internal system error
				Object result = getDataStore().get(CONSTRUCTED_RESULT_KEY);
				if (result == null)
					//
					getDataStore().put(CONSTRUCTED_RESULT_KEY, new InternalSystemError());
			}
		};
		registerState(b, ERROR_HANDLING);
		
		b = new RequestHandler(a, ds, requestKey, actKey, notificationKey)  {
			
			protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {
	
					
					Result result = new Result();
					result.setAction(act);

					ACLMessage response = request.createReply();
					Object returned = getDataStore().get(CONSTRUCTED_RESULT_KEY);
					if (returned instanceof DataView) {
						// everything OK
						result.setValue(returned);
						response.setPerformative(ACLMessage.INFORM);
					} else if (returned instanceof InternalSystemError) {
						// some error occured in ModelContructor or ViewContructor
						result.setValue(returned);
						response.setPerformative(ACLMessage.FAILURE);
					} else {
						logger.severe("Unknown type of result");
						response.setPerformative(ACLMessage.FAILURE);
						result.setValue(new InternalSystemError());
						}
						
					try {
						myAgent.getContentManager().fillContent(response, result);						
					} catch (Exception e) {
						logger.log(Level.SEVERE, "Cannot form response", e);
						throw new FailureException(e.getMessage());
					}
					
					return response;

			}
		};
		registerLastState(b, PREPARING_NOTIFICATION);
	}
	
	/**
	 * Registers the given Model Constructor in this Controller.
	 * 
	 * It also provided the constructor with access keys to exchange data via
	 * local DataStore.
	 * 
	 * @param mc
	 *            model constructor
	 */
	public void registerModelConstructor(ModelConstructor mc) {
		registerState(mc, CONSTRUCTING_MODEL);
		mc.setDataStore(getDataStore());
		mc.setAccessKeys(actKey, actionNameKey, CONSTRUCTED_RESULT_KEY);
	}

	/**
	 * Registers the given View Constructor in this Controller.
	 * 
	 * It also provided the constructor with access keys to exchange data via
	 * local DataStore.
	 * 
	 * @param vc
	 *            view constructor
	 */
	public void registerViewConstructor(ViewConstructor vc) {
		registerState(vc, CONSTRUCTING_VIEW);
		vc.setDataStore(getDataStore());
		vc.setAccessKeys(actKey, actionNameKey, CONSTRUCTED_RESULT_KEY);
	}
	
	
}
