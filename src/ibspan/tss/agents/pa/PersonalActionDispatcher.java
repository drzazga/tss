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
package ibspan.tss.agents.pa;

import ibspan.tss.messaging.SafeHandlerSelector;
import ibspan.tss.messaging.ontology.PA_process_user_request;
import jade.content.Concept;
import jade.content.ContentManager;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

/**
 * Dispatches request to registered behaviour handlers. More precisely, For user
 * request returns the key reflecting the name of action the user is wishing to
 * be executed by the system; more precisely, it is the name of
 * <code>actionName</code> parameter in incoming request. For example, the the
 * following content of a requuest:
 * 
 * <pre>
 *             (action (agent-identifier :name pa-1)
 *               (PA-process-user-request
 *               		:actionName &quot;find-restaurant&quot;
 *               		....
 *               )
 *             )
 * </pre>
 * 
 * results in returning the following key: <code>find-restaurant</code> which,
 * of course, must be bounded with the Behaviour realizing the user request.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ibspan.tss.messaging.ActionDispatcher
 * @see ibspan.tss.agents.sha.session.ActionDispatcherWithSessionTracking
 * @see ibspan.tss.agents.pa.PAResponder
 */
public class PersonalActionDispatcher extends SafeHandlerSelector {
	
	private static Logger logger = Logger.getMyLogger(PersonalActionDispatcher.class.getName());
	
	//	The key in the DataStore to access name of action prepared by this
	// action dispatcher.
	private Object actionNameKey;
	// The key in the DataStore to access {@link Action} from current request,
	// extracted by this action dispatcher.
	private Object actKey;
	
	/**
	 * Constructs action dispatcher.
	 * 
	 * @param a
	 *            is a reference to the Agent object.
	 * @param ds
	 *            is DataStore which will be used locally.
	 * @param accessKey
	 *            is the key to get the proper object from the DataStore, this
	 *            is the object that will be later passed as argument to the
	 *            method <code>getSelectionKey</code>.
	 * @param actionNameKey
	 *            is the key to get the name of action resolved by this action
	 *            dispatcher.
	 * @param actKey
	 *            is the key in the DataStore to access {@link Action} from
	 *            current request, extracted by this action dispatcher.
	 * 
	 * @see #getSelectionKey(Object)
	 */
	public PersonalActionDispatcher(Agent a, DataStore ds, Object accessKey, Object actionNameKey, Object actKey) {
		super(a, ds, accessKey);
		this.actionNameKey = actionNameKey;
		this.actKey = actKey;
	}

	@Override
	protected final Object getSelectionKey_internal(Object o) {
		
        ACLMessage acl = (ACLMessage) o;
        ContentManager manager = this.myAgent.getContentManager();
    	String actionName = null;

        Action act = null;
		try {
			act = (Action) manager.extractContent( acl );
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
        Concept action = act.getAction(); 
        getDataStore().put(actKey, act);
        
        if (action instanceof PA_process_user_request) {
        	// this is user request forwarded
        	logger.info("Request from user received .");
        	PA_process_user_request request = (PA_process_user_request) action;
        	
			actionName = request.getActionName();
        		
        } else {
        	// this is system request
        	// so behave as simple ActionDispatcher
        	actionName = action.getClass().getName();            
        }
        getDataStore().put(actionNameKey, actionName);
        
        return actionName;
	}
}
