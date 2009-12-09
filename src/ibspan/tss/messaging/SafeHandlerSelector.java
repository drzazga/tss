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

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.proto.states.HandlerSelector;
import jade.util.Logger;

import java.util.logging.Level;

/**
 * Extends functionality of <code>HandlerSelector</code> by providing
 * {@link #registerErrorHandler(Behaviour)} method for registering behaviour,
 * which handles with situation in which no behaviour for the given request is
 * registered or an error occured during dispatching.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public abstract class SafeHandlerSelector extends HandlerSelector {

	private static Logger logger = Logger.getMyLogger(SafeHandlerSelector.class.getName());
	
	// Key to the behaviour handling with situations in which action dispatcher
	// cannot process request.
	private static final String ERROR_HANDLER_KEY = "___error-handler";
	
    /**
	 * Constructor for this SafeHandlerSelector.
	 * 
	 * @param a
	 *            is a reference to the Agent object
	 * @param s
	 *            is the DataStore where the object can be retrieved from
	 * @param accessKey
	 *            is the key to get the proper object from the DataStore, this
	 *            is the object that will be later passed as argument to the
	 *            method <code>getSelectionKey</code>
	 * @see #getSelectionKey(Object)
	 */
	public SafeHandlerSelector(Agent a, DataStore s, Object accessKey) {
		super(a, s, accessKey);
	}

    /**
	 * Returns the key to which the handler was bound. Invokes
	 * <code>getSelectionKey_internal</code> method.
	 * 
	 * @param selectionVar
	 *            is the object retrieved from the datastore at the
	 *            <code>accessKey</code> passed in the constructor
	 * @return the key to which the handler was bound; if key was not found or
	 *         error occured (signalled as catched exception) then key for error
	 *         handler is returned.
	 * 
	 * @see #registerErrorHandler(Behaviour)
	 * @see #getSelectionKey_internal(Object)
	 */
	protected final Object getSelectionKey(Object o) {
		Object key = null;
		try {
			key = getSelectionKey_internal(o);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Severe error occuring. Handling error: ", e);
		}	
		
		if (key == null) {
			key = ERROR_HANDLER_KEY;
			logger.log(Level.WARNING, "Cannot find handler for this action. Handling error: ");
		}
		
		return key;
	}
	
	/**
	 * Subclasses must provide a concrete implementation for this method. It
	 * must return the key to which the handler was bound.
	 * 
	 * @param selectionVar
	 *            the object retrieved from the datastore at the
	 *            <code>accessKey</code> passed in the constructor
	 * @return the key to which the handler was bound
	 * @throws 
	 */
	protected abstract Object getSelectionKey_internal(Object o) throws Exception;
	
	/**
	 * Register behaviour which will handle with situations in which action
	 * dispatcher cannot process request or the this no handler for the request.
	 * 
	 * @param h
	 *            error handler
	 */
	public void registerErrorHandler(Behaviour h) {
		registerHandler(ERROR_HANDLER_KEY, h);
	}
}
