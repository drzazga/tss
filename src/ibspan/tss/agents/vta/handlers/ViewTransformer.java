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
package ibspan.tss.agents.vta.handlers;

import ibspan.tss.agents.vta.ViewTransformingAgent;
import ibspan.tss.agents.vta.ViewTransformingException;
import ibspan.tss.messaging.RequestHandler;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.UserContext;
import ibspan.tss.messaging.ontology.VTA_construct_view;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.logging.Level;

/**
 * This behaviour is responsible for transforming <code>DataModel</code>
 * object given in request message into responding <code>DataView</code>
 * object and prepare reply containing this result. This is done by invoking
 * <code>transform()</code> method.
 * 
 * <p>The behaviour is expected to preserve given <code>UserContext</code> during
 * system-user interaction, usually in such a way each hyperlink a user can go
 * along and each form a user can post were accompanied by information about
 * this context.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see DataModel
 * @see DataView
 * @see UserContext
 */
public abstract class ViewTransformer extends RequestHandler {
	
	private static Logger logger = Logger.getMyLogger(ViewTransformer.class.getName());
	
	// The agent this behaviour belongs to.
	protected ViewTransformingAgent myAgent;
  
	/**
	 * Constructs <code>ViewTransformer</code> object.
	 * 
	 * @param a
	 *            is the agent owning this behaviour.
	 * @param ds
	 *            is the DataStore for this constructor.
	 * @param requestKey
	 * @param actKey
	 *            is the key in the DataStore where the {@link Action} concept
	 *            extracted from current request can be found.
	 * @param resultNotificationKey
	 *            is the key in the DataStore where the result message is to be
	 *            put at.
	 */
	public ViewTransformer(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object resultNotificationKey) {
		super(a, ds, requestKey, actKey, resultNotificationKey);
		myAgent = (ViewTransformingAgent) a;
	}
	
	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException, NotUnderstoodException {
		DataModel model = null;
		UserContext context = null;
		try {
			VTA_construct_view action = (VTA_construct_view) act.getAction();
			model = (DataModel) action.getModel();
			context = (UserContext) action.getUserContext();
		} catch(Exception e) {
			logger.log(Level.SEVERE,"Cannot parse request.", e);
			throw new NotUnderstoodException(e.getMessage());
		}
		
		ACLMessage response = null;
		try {
			DataView view = transform(model, context);
			response = request.createReply();
			response.setPerformative(ACLMessage.INFORM);
			Result r = new Result(act, view);
			myAgent.getContentManager().fillContent(response, r);
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Cannot realize request.", e);
			throw new FailureException(e.getMessage());
		}
		
		return response;
	}
	
	/**
	 * Transforms pure data into browser-readable form.
	 * 
	 * @param model
	 *            are pure data be formatted
	 * @param context
	 *            is context of user request, such type of media, session-id
	 *            etc.
	 * @return browser-readable form of data
	 * @throws ViewTransformingException
	 *             when transforming process failed for some reason.
	 */
	protected abstract DataView transform(DataModel model, UserContext context) throws ViewTransformingException;


}
