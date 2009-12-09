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
package ibspan.tss.agents.rsa.handlers;

import ibspan.tss.agents.rsa.RestaurantServiceAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.domain.ontology.restaurant.Restaurant;
import ibspan.tss.domain.ontology.restaurant.RestaurantFactory;
import ibspan.tss.messaging.RequestHandler;
import ibspan.tss.messaging.ontology.RSA_get_restaurants_details;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.Iterator;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

/**
 *
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see RestaurantServiceAgent
 */
public class GetRestaurantsDetailsHandler extends RequestHandler {

	private static Logger logger = Logger.getMyLogger(GetRestaurantsDetailsHandler.class.getName());
	
	private OntModel mRestaurantDB;
	
	protected RestaurantServiceAgent myAgent;
	
	/**
	 * Constructs FindRestaurantHandler.
	 * @param a
	 *            owner agent
	 * @param ds data store 
	 * @param actKey
	 *            key for accessing action of user request from local Data Store
	 * @param requestKey
	 *            key for accessing user request ACL message from local Data
	 *            Store
	 * @param notificationKey
	 *            key, pointing the place in local Data Store, where result of
	 *            the Behaviour should put at
	 */
	public GetRestaurantsDetailsHandler(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);
		myAgent = (RestaurantServiceAgent) a;
		
		mRestaurantDB = myAgent.getRestaurantsDB();
	}

	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {
		ACLMessage response = null;	
		try {
				RSA_get_restaurants_details action = (RSA_get_restaurants_details) act.getAction();
				response = request.createReply();
				
				Memory memResults = doGet(action);
				
				Result r = new Result(act, memResults.buildOWLData());
	
				myAgent.getContentManager().fillContent(response, r);
				response.setPerformative(ACLMessage.INFORM);
				

			} catch (Exception e) {
				logger.log(Level.WARNING, "Cannot realize request", e);
				throw new FailureException(e.getMessage());
			}
		return response;		
	}
	
	private Memory doGet(RSA_get_restaurants_details action) {
		Memory memResults = new Memory();
		try {
			for(Iterator it = action.getAllAboutRestaurant(); it.hasNext(); ) {
				String restaurantURI = (String) it.next();
				Restaurant res = RestaurantFactory.getRestaurant(restaurantURI, mRestaurantDB);
				memResults.add(res);
			}
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
		return memResults;
	}
}
