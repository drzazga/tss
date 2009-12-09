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
package ibspan.tss.agents.sha.session;

import ibspan.tss.agents.sha.SessionHandlingAgent;
import ibspan.tss.agents.sha.history.HistoryLogger;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.layout.ontology.datamodel.MenuLink;
import ibspan.tss.messaging.SafeHandlerSelector;
import ibspan.tss.messaging.ontology.SHA_process_user_request;
import ibspan.tss.messaging.ontology.UserContext;
import ibspan.tss.um.ontology.UserBehaviour;
import jade.content.Concept;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

/**
 * This class resolves the handler behaviour responsible for handling with
 * incoming request and tracks the session with user. More precisely, it has the
 * following multiply functionality:
 * <ul>
 * <li>distincts between internal system request and user request (forwarded by
 * {@link ibspan.tss.agents.pra.ProxyAgent}),
 * <li>for internal system request returns key in the same manner as
 * {@link ibspan.tss.messaging.ActionDispatcher} does,
 * <li>for user request returns the key reflecting the name of action the user
 * is wishing to be executed by the system; more precisely, it is the name of
 * <code>actionName</code> parameter in incoming request. For example, the the
 * following content of a requuest:
 * 
 * <pre>
 *              (action (agent-identifier :name sha-1)
 *                (SHA-process-user-request
 *                		:actionName &quot;find-restaurant&quot;
 *                		....
 *                )
 *              )
 * </pre>
 * 
 * results in returning the following key: <code>find-restaurant</code> which,
 * of course, must be bounded with the Behaviour realizing the user request.
 * <Li> checks, whether mapped Behaviour requires authorization from the user;
 * if the user is not logged in, it is prompted with the login screen (more
 * precisely the class returns the Behaviour realizing this <i>prompting</i>
 * process; the developer is obligated to register all behaviours and points
 * which require authorization;
 * <li>for future processing logs each user request (of logged-in user) into
 * History model, using {@link HistoryLogger};
 * <li>opens session for the user; the user is identified by her
 * <code>peerID</code> parameters, which usually stands for IP of her
 * computer; each session is represented by
 * {@link ibspan.tss.agents.sha.session.Session} object, assiociated with
 * {@link ibspan.tss.agents.sha.session.Session.SessionData} object, so
 * multi-stepped scenarios could operate on data gathered during the session;
 * map of sessions is provided for other behaviours by
 * {@link SessionHandlingAgent};
 * </ul>
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ibspan.tss.messaging.ActionDispatcher
 * @see Action
 */
public class ActionDispatcherWithSessionTracking extends SafeHandlerSelector {
	
	private static Logger logger = Logger.getMyLogger(ActionDispatcherWithSessionTracking.class.getName());
	
	// List of keys pointing these behaviours, which can be used to handle with
	// the current request only when the user is logged in. 
	private List<Object> forAuthorization = new ArrayList<Object>();
	
	// History logger, this action dispatcher use to log action of user logged in.
	private HistoryLogger historyLogger;
	
	// The key in the DataStore to access name of action prepared by this
	// action dispatcher.
	private Object actionNameKey;
	// The key in the DataStore to access {@link Action} from current request,
	// extracted by this action dispatcher.
	private Object actKey;
	
	// Variables to store names of particular actions.
	private String welcomeActionName;
	private String loginActionName;
	
	// The agent this behaviour belongs to.
	private SessionHandlingAgent myAgent;
	
	/**
	 * Constructs action dispatcher.
	 * 
	 * @param a
	 *            is a reference to the Agent object.
	 * @param ds
	 *            is DataStore which will be used locally.
	 * @param historyLogger
	 *            is logger which logs request of the user in a database
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
	public ActionDispatcherWithSessionTracking(Agent a, DataStore ds, HistoryLogger historyLogger, Object accessKey, Object actionNameKey, Object actKey) {
		super(a, ds, accessKey);
		myAgent = (SessionHandlingAgent) a;
		
		this.actionNameKey = actionNameKey;
		this.actKey = actKey;		
		this.historyLogger = historyLogger;
		
		OntModel mTemplatesDB = myAgent.getTemplatesDBModel();
		OntModel mUM = myAgent.getUMModel();
		
		Link link;
		UserBehaviour behaviour;
		
		// Initialize common used links.
		try {
			link = DataModelFactory.getLink(MenuLink.Login1, mTemplatesDB);
			loginActionName = link.getHasActionName();
			
			link = DataModelFactory.getLink(MenuLink.Welcome, mTemplatesDB);
			welcomeActionName = link.getHasActionName();
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}			
	}
	
	@Override
	protected final Object getSelectionKey_internal(Object o) {
		
        ACLMessage acl = (ACLMessage) o;
    	String actionName = null;
    	
    	Action act = null;
    	try {
    		act = (Action) myAgent.getContentManager().extractContent( acl );
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
        
        // Store extracted action in datastore, so other 
        // behaviours could retrieve it.
        getDataStore().put(actKey, act);
        
        Concept action = act.getAction();            
        if (action instanceof SHA_process_user_request) {
        	// This is session with a user.
        	SHA_process_user_request request = (SHA_process_user_request) action;    
        	UserContext context = request.getUserRequest().getUserContext();
        	String sessionID = context.getSessionID();
        	Session s = myAgent.getSessions().getSession(sessionID);
			if (s == null) {
				// This is new session.
				logger.fine("New session with the user started .");
				s = myAgent.getSessions().createSession(context.getPeerID());
				// Set session context in user context so other behaviour could access data
				// bounded with this session
				context.setSessionID(s.getSessionID());
			}
			
			// Usually, when the user comes to the system, she does not gives
			// action name.
			actionName = request.getUserRequest().getActionName();
			if (ViewParams.EMPTY_ACTION_NAME.equals(actionName))
            	actionName = welcomeActionName;
			
			if (s.isLoggedIn()) {
				// Log this event.
				historyLogger.logUserRequest(request.getUserRequest());
			} else {
				if (forAuthorization.contains(actionName)) {
					// This request needs authorization and the user is
					// not logged in, so force the system to use logging action.					
					actionName = loginActionName;
				}
			}        		
        } else {
        	// this is system request
        	// so behave as simple ActionDispatcher
        	actionName = action.getClass().getName();            
        }
    
        logger.fine("SHA will realize action: <"+actionName+"> .");
        getDataStore().put(actionNameKey, actionName);
        
        return actionName;
	}

	/**
	 * Register the bounding between an handler and a key.
	 * 
	 * @param requiresAuthorization
	 *            <code>true</code> if the passed Behaviour realizes user request, which requires
	 *            authorization
	 * @param key
	 *            this is the key that must be later returned by the method
	 *            <code>getSelectionKey</code> when the passed Behaviour must
	 *            be selected
	 * @param h
	 *            the control handler for this key
	 */
	public void registerHandler(boolean requiresAuthorization, Object key, Behaviour h) {
		registerHandler(key, h);
		if (requiresAuthorization)
			forAuthorization.add(key);
	}

}
