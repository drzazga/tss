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
package ibspan.tss.agents.sha.history;

import ibspan.tss.dao.HistoryDAO;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.messaging.ontology.MapEntry;
import ibspan.tss.messaging.ontology.UserContext;
import ibspan.tss.messaging.ontology.UserRequest;
import ibspan.tss.um.ontology.ContextParameter;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.EventSession;
import ibspan.tss.um.ontology.ExtendedUserBehaviour;
import ibspan.tss.um.ontology.UserBehaviour;
import ibspan.tss.um.ontology.UserBehaviourContext;
import jade.util.Logger;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.ibm.adtech.jastor.JastorException;

/**
 * Logs user requests, which occurs during session, in persistent store by using
 * given DAO for <i>History</i> model. Additionally, <code>NewEventHandler</code>
 * object, passed as argument in costructor, is informed about each new user
 * request.
 * 
 * <p>
 * <b><i>Remember.</i></b> Term of session used here is not exactly the same
 * as the one used in context of action dispatching. Here a session means
 * interaction with authorized (logged in user), in which each act of the user
 * is logged in persistent store.
 * 
 * <p>
 * <code>HistoryLogger</code> must be initialized by calling <code>registerLoggableAction()</code>
 * method before use.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ibspan.tss.agents.sha.session.ActionDispatcherWithSessionTracking
 * @see ibspan.tss.agents.sha.history.NewEventHandler
 */
public class HistoryLogger {
	// TODO: Unify or make more clear definition and usage of Session (and
	// EvenSession) with ActionDispatcherWithSessionTrackingt

	private static Logger logger = Logger.getMyLogger(HistoryLogger.class.getName());
	
	// Data Access Object to mHistoryDB model
	private HistoryDAO daoHistory;

	// Translates action names from user request into specific user behaviour.
	// Only actions which are to be logged, are mentioned here.
	private Map<String, UserBehaviour> loggableActions = new HashMap<String, UserBehaviour>();
	
	// Maps known sessionID to EventSessions;
	// TODO: remove "dead" sessions, e.g. when sessionID stays the same, but userID changed
	private Map<SessionKey,EventSession> sessions = new HashMap<SessionKey,EventSession>();

	// Component handling with every new event
	private NewEventHandler handler;

	/**
	 * Constructs <code>HistoryLogger</code>.
	 * 
	 * @param daoHistory
	 *            is DAO interface for History model with logged events.
	 * @param handler
	 *            is handler which additionally will be informed about each new
	 *            event; if <code>null</code>, then no such handling will be
	 *            performed.
	 */
	public HistoryLogger(HistoryDAO daoHistory, NewEventHandler handler) {
		this.daoHistory = daoHistory;
		this.handler = handler;
	}

	/**
	 * Registers actions which will be logged in <i>History</i> model.
	 * 
	 * @param actionName
	 *            is a name of an action resolved by
	 *            <code>ActionDispatcherWithSessionTracking</code>.
	 * @param behaviour
	 *            is the name of behaviour (usually from user modelling
	 *            ontology) under which user action will be remembered.
	 * 
	 * @see ibspan.tss.agents.sha.session.ActionDispatcherWithSessionTracking
	 */
	public void registerLoggableAction(String actionName, UserBehaviour behaviour) {
		loggableActions.put(actionName, behaviour);
	}

	/**
	 * Logs given <code>request</code> in persistent store. More precisely
	 * translates <code>request</code> into <code>Event</code> object, put
	 * it into persitent store <code>NewEventHandler</code> object about this
	 * event.
	 * 
	 * @param request
	 *            is a user request to be logged in.
	 */
	public void logUserRequest(UserRequest request) {
		// This also good example of translating data represented
		// FIPA-SL0-compatible Messaging Ontology into OWL-compatible User
		// Modelling Ontology
		
		try {
			UserBehaviour behaviour = loggableActions.get(request.getActionName());
			
			if (behaviour != null) {
				// This is loggable action, so let's log it!				
				Event e = daoHistory.addEvent();
				UserContext context = request.getUserContext();
				ExtendedUserBehaviour extBehaviour = e.setHasExtendedUserBehaviour();
				extBehaviour.setHasUserBehaviour(behaviour);
				EventSession session = getEventSession(context.getSessionID(), context.getUserID());
				session.addHasEvent(e);
				
				// Translate request.ActionParams => UserBehaviourContext.
				UserBehaviourContext c = extBehaviour.setHasContext();
				for (Iterator it = request.getActionParams().getAllHasEntry(); it.hasNext();) {
					MapEntry entry = (MapEntry) it.next();

					if (! ViewParams.NONE_SELECTED.equals(entry.getValue()) && ! "".equals(entry.getValue())) {
						// This parameter (e.g. in HTML form) has been set for a
						// certain value by the user
						ContextParameter p = c.addHasParameter();
						p.setHasValue(entry.getValue());
						p.setHasName(entry.getKey());
					}
				}

				// Add information from request.UserContext into event
				e.setHasSessionID(context.getSessionID());
				e.setHasUserID(context.getUserID());
				// The event happened just now
				e.setWhen(new XSDDateTime(Calendar.getInstance()));		
				
				if (handler != null)
					// Inform handler about new event. Must handle with this
					// event as quick as possible, since other events could be
					// waiting to be handled
					handler.handleNewEvent(e);
			}

		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
	}

	// Returns the session with give sessionID. If there is no such session
	// started then it is created for the given userID
	private EventSession getEventSession(String sessionID, int userID) {
		SessionKey key = new SessionKey(sessionID, userID);
		EventSession session = sessions.get(key);

		if (session == null) {
			session = daoHistory.addSession(sessionID, userID);				
			sessions.put(key, session);
		}

		return session;
	}
	
	// Internal class 
	// We assume that the same user can have a few different sessions from a single machine
	private class SessionKey {
		
		private String sessionID;
		private int userID;
			
		public SessionKey(String sessionID, int userID) {
			this.sessionID = sessionID;
			this.userID = userID;
		}

		@Override
		public int hashCode() {
			return sessionID.hashCode() * userID;
		}

		public boolean equals(Object o) {
			SessionKey key = (SessionKey) o;
			return o instanceof SessionKey && sessionID.equals(key.sessionID) && (userID == key.userID);
		}
	}
}
