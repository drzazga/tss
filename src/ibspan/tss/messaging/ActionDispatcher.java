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

import jade.content.Concept;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.logging.Level;

/**
 * Incoming request usually contains <code>Action</code> object to be served.
 * This class extends extends <code>HandlerSelector</code> in such a way the
 * key for selecting a handler represent the name of <code>action</code>
 * class.
 * 
 * For example, the incoming request with the following content:
 * 
 * <pre>
 *     (action (agent-identifier :name sha-1)
 *       (VTA-transform-view
 *       ........
 *       )
 *     )
 * </pre>
 * 
 * results in returning the following key:
 * <code>ibspan.tss.messaging.ontology.VTA_transform_view</code> class name
 * reflecting <code>VTA-transform-view</code> ontological concept.
 * 
 * <p>
 * Additionally it provides {@link #registerErrorHandler(Behaviour)} method for
 * registering behaviour, which handles with situation in which no behaviour for
 * the given request is registered or an error occured during dispatching.
 * 
 * @see jade.content.onto.basic.Action
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class ActionDispatcher extends SafeHandlerSelector {

	private static Logger logger = Logger.getMyLogger(ActionDispatcher.class.getName());
	
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
	 * @param actKey
	 *            is the key in the DataStore to access {@link Action} from
	 *            current request, extracted by this action dispatcher.
	 * 
	 * @see #getSelectionKey(Object)
	 */
	public ActionDispatcher(Agent a, DataStore s, Object accessKey, Object actKey) {
		super(a, s, accessKey);
		this.actKey = actKey;
	}

	
	@Override
	protected final Object getSelectionKey_internal(Object o) {
		ACLMessage acl = (ACLMessage) o;
		Action act = null;
		try {
			act = (Action) myAgent.getContentManager().extractContent(acl);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Cannot parse request.", e);
			throw new RuntimeException(e);
		}
		getDataStore().put(actKey, act);
		
		Concept action = act.getAction();
		String actionName = action.getClass().getName();
		return actionName;
	}
}
