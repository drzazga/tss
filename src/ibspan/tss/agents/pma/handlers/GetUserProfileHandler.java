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
package ibspan.tss.agents.pma.handlers;

import ibspan.tss.agents.pma.ProfileManagingAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.dao.ProfileDAO;
import ibspan.tss.messaging.RequestHandler;
import ibspan.tss.messaging.ontology.PMA_get_user_profile;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.stereotyping.StereotypingAlgorithm;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;

/**
 *
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class GetUserProfileHandler extends RequestHandler {

	private static Logger logger = Logger.getMyLogger(GetUserProfileHandler.class.getName());
	
	private ProfileManagingAgent myAgent;
	private StereotypingAlgorithm alg;
	private OntModel mProfilesDB;
	private ProfileDAO daoProfile; 
	
	public GetUserProfileHandler(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);
		myAgent = (ProfileManagingAgent) a;
		
		// Initialize stereotyping algorithm
		mProfilesDB = myAgent.getProfilesDBModel();
		daoProfile = new ProfileDAO(mProfilesDB);
	}

	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {
			try {
				PMA_get_user_profile action = (PMA_get_user_profile) act.getAction();
				UserProfile profile = daoProfile.getUserProfile(action.getUserID());
				
				if (profile != null) {				
					Memory mem = new Memory(profile, true);
				
					// Prepare INFORM response
					Result r = new Result(act, mem.buildOWLData());
					
					ACLMessage response = request.createReply();
					response.setPerformative(ACLMessage.INFORM);
			
					myAgent.getContentManager().fillContent(response, r);
					
					return response;
				} else
					throw new FailureException("No profile with the given userID");
			} catch(Exception e) {
				logger.log(Level.SEVERE, "Cannot realize request.", e);
				throw new FailureException(e.getMessage());
			}

		
	}
	
	
}
