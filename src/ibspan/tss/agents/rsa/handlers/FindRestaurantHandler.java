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
import ibspan.tss.core.semantic.AnonymousResourceException;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.dao.RestaurantDAO;
import ibspan.tss.domain.vocabulary.LocationVocabulary;
import ibspan.tss.domain.vocabulary.MoneyVocabulary;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.messaging.RequestHandler;
import ibspan.tss.messaging.ontology.Map;
import ibspan.tss.messaging.ontology.MapEntry;
import ibspan.tss.messaging.ontology.RSA_find_restaurant;
import ibspan.tss.um.ontology.RatedResult;
import ibspan.tss.um.ontology.UserModellingFactory;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.Iterator;
import java.util.logging.Level;

import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.datatypes.TypeMapper;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.core.ElementGroup;
import com.hp.hpl.jena.query.core.ElementTriplePattern;
import com.hp.hpl.jena.query.util.IndentedWriter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.XSD;
import com.ibm.adtech.jastor.JastorException;

/**
 * This behaviour prepare response with list of restaurants fulfilling
 * constraints given in the user request.
 * 
 * More precisely, these constrains are given as the map of predicates
 * (properties mapped into possible values -- one-to-one relation) passed as
 * UserContext. Property should be defined as resource URI, whereas values as
 * resource URI or simple literal.
 * 
 * <p>
 * The behaviour should be provided with two {@link OntModel}s: model
 * describing ontology of Restaurant domain and model containing database with
 * restaurants to retrieve. 
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see RestaurantServiceAgent
 */
public class FindRestaurantHandler extends RequestHandler {

	private static Logger logger = Logger.getMyLogger(FindRestaurantHandler.class.getName());
	
	public final static int DEFAULT_MAX_RESULTS = 100;
	
	private RestaurantDAO daoRestaurants;
	private OntModel mDomain;
	private OntModel mRestaurantsDB;
	
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
	public FindRestaurantHandler(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);
		myAgent = (RestaurantServiceAgent) a;
		
		mDomain = myAgent.getDomainModel();
		mRestaurantsDB = myAgent.getRestaurantsDB();
		daoRestaurants = new RestaurantDAO(mDomain, mRestaurantsDB);
	}

	protected final ACLMessage prepareResponse(ACLMessage request, Action act) throws FailureException {
			try {
				RSA_find_restaurant action = (RSA_find_restaurant) act.getAction();
				ACLMessage response = request.createReply();
				
				Memory memResults = daoRestaurants.doQuery(action.getHasQuery(), DEFAULT_MAX_RESULTS);
				
				Result r = new Result(act, memResults.buildOWLData());
	
				myAgent.getContentManager().fillContent(response, r);
					response.setPerformative(ACLMessage.INFORM);
				
				return response;
			} catch (Exception e) {
				logger.log(Level.WARNING, "Cannot realize request", e);
				throw new FailureException(e.getMessage());
			}
		

	}
	


}
