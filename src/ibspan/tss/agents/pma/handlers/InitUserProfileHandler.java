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
import ibspan.tss.messaging.RequestHandler;
import ibspan.tss.messaging.ontology.PMA_init_user_profile;
import ibspan.tss.um.ontology.Dress;
import ibspan.tss.um.ontology.Profession;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.ontology.UserProfileData;
import ibspan.tss.um.ontology.Wealth;
import ibspan.tss.um.stereotyping.StereotypingAlgorithm;
import ibspan.tss.um.vocabulary.ProfilesDBVocabulary;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.Lock;

/**
 *
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class InitUserProfileHandler extends RequestHandler {

	private static Logger logger = Logger.getMyLogger(InitUserProfileHandler.class.getName());
	
	private ProfileManagingAgent myAgent;
	private StereotypingAlgorithm alg;
	private OntModel mProfilesDB;
	private OntModel mUM;
	
	public InitUserProfileHandler(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);
		myAgent = (ProfileManagingAgent) a;
	
		// Initialize stereotyping algorithm
		mProfilesDB = myAgent.getProfilesDBModel();
		mUM= myAgent.getUMModel();
		OntModel mStereotypesDB = myAgent.getStereotypesDBModel();
		alg = new StereotypingAlgorithm(mUM, mStereotypesDB, mProfilesDB, null);
	}

	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {


		ACLMessage response = null;
		try {
			PMA_init_user_profile action = (PMA_init_user_profile) act.getAction();			
			doInit(action);
		
			// Prepare INFORM response
			Done d = new Done(act);
			response = request.createReply();
			response.setPerformative(ACLMessage.INFORM);
			myAgent.getContentManager().fillContent(response, d);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Cannot realize request.", e);
			throw new FailureException(e.getMessage());
		}
		
		return response;
	}
	
	private void doInit(PMA_init_user_profile action) {
		UserProfile profile = null;
		mProfilesDB.enterCriticalSection(Lock.WRITE);
		try {
			mProfilesDB.begin();			
			
			int userID = action.getUserID();
			
			// Profile cannot be anonymous resource it is access then by URI
			Resource r = mProfilesDB.createResource(ProfilesDBVocabulary.NS + userID);
			profile = UserModellingFactory.createUserProfile(r, mProfilesDB);
			profile.setHasUserID(userID);
			
			UserProfileData updata = profile.setHasUserProfileData();
			double age = action.getAge();
			updata.setHasAge().setMapsLinearValue(age);
			Wealth wealth = UserModellingFactory.getWealth(action.getWealth(), mUM);
			updata.setHasWealth(wealth);
			Dress dress = UserModellingFactory.getDress(action.getDress(), mUM);
			updata.setHasDress(dress);
			Profession profession = UserModellingFactory.getProfession(action.getProfession(), mUM);
			updata.setHasProfession(profession);
		
			alg.initializeUserProfile(profile);

			mProfilesDB.commit();
		} catch (Exception e) {
			mProfilesDB.abort();
			throw new RuntimeException("Problem when initiliazing user profile data.", e);
		} finally {
			mProfilesDB.leaveCriticalSection();
		}
		
		
		
	}
}
