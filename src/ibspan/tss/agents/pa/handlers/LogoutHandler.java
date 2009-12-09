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

import ibspan.tss.messaging.RequestHandler;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.logging.Level;

/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class LogoutHandler extends RequestHandler {

	private static Logger logger = Logger.getMyLogger(LogoutHandler.class.getName());
	
	public LogoutHandler(Agent a, DataStore ds, Object requestKey,Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);
	}

	public void setup() {
	}
	
	

	@Override
	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {
			// TODO: check whether it breaks current behaviour
			// or wait till the end of it
			myAgent.doDelete();
			
			ACLMessage response = request.createReply();
			Done d = new Done(act);

			try {
				myAgent.getContentManager().fillContent(response, d);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Cannot realize request", e);
				throw new FailureException(e.getMessage());
			} 
			response.setPerformative(ACLMessage.INFORM);

			return response;

		
	}
	
}
