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
package ibspan.tss.dao;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.domain.vocabulary.LocationVocabulary;
import ibspan.tss.domain.vocabulary.MoneyVocabulary;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.messaging.ontology.Map;
import ibspan.tss.messaging.ontology.MapEntry;
import ibspan.tss.um.ontology.RatedResult;
import ibspan.tss.um.ontology.UserModellingFactory;

import java.util.Iterator;

import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.datatypes.TypeMapper;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
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
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.JastorException;

/**
 * Data Access Object providing nice interface to model with restaurants
 * descriptions. This implementation contains methods for building SPARQL query
 * describing preferred restuarant on the base of user preferencies described in
 * search form.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class RestaurantDAO {

	// Model with domain ontology.
	private OntModel mDomain;
	// Model with restaurants descriptions.
	private OntModel mRestaurantsDB;
	
	private final static String restaurantVarName = "rest";

	/**
	 * Builds query reflecting given predicates describing preferred
	 * restaurant object.
	 * 
	 * @param varRestaurantName
	 *            name of variable which will be used to retrieve result
	 *            restaurant object in solutions
	 * @param predicates
	 *            defines constraints' map with list of properties and
	 *            expected values of each one; property should be defined as
	 *            resource URI, whereas values as resource URI or simple
	 *            literal.
	 * @return SPARQL query
	 */
	private Query buildQuery(String varRestaurantName, Map predicates) {
		// Let's build this query programatically
		Query query = QueryFactory.make();

		query.setQueryType(Query.QueryTypeSelect);

		// Build pattern
		ElementGroup elg = new ElementGroup();

		Node varRestaurant = Node.createVariable(varRestaurantName);

		Triple t1 = new Triple(varRestaurant, RDF.type.asNode(),
				RestaurantVocabulary.Restaurant.asNode());
		ElementTriplePattern tp1 = new ElementTriplePattern(t1);
		elg.addElement(tp1);

		// Attach triples describing properties of the restaurant
		for (Iterator<MapEntry> it = predicates.getAllHasEntry(); it
				.hasNext();) {

			MapEntry entry = it.next();
			if (! ViewParams.NONE_SELECTED.equals(entry.getValue()) && !"".equals(entry.getValue())) {

				OntProperty property = mDomain.getOntProperty(entry.getKey());
				Node object;
				if (property.isDatatypeProperty()) {
					String rangeURI = property.getRange().getURI();
					RDFDatatype type = TypeMapper.getInstance().getTypeByName(rangeURI);
					object = Node.createLiteral(entry.getValue(),"",type);
				}
				else if (property.canAs(ObjectProperty.class))
					object = Node.createURI(entry.getValue());
				else
					throw new UnsupportedOperationException(
							"unrecognized type of property");

				Triple t2 = new Triple(varRestaurant, property.asNode(), object);
				elg.addElement(new ElementTriplePattern(t2));
			}
		}

		// Attach the group to query.
		query.setQueryElement(elg);

		// Choose what we want
		query.addResultVar(varRestaurant);

		// Prefix mapping just helps serialization
		query.getPrefixMapping().setNsPrefix("rdf", RDF.getURI());
		query.getPrefixMapping()
				.setNsPrefix("res", RestaurantVocabulary.NS);
		query.getPrefixMapping().setNsPrefix("money", MoneyVocabulary.NS);
		query.getPrefixMapping().setNsPrefix("location",
				LocationVocabulary.NS);
		
		// For test purposes...
		//query.serialize(new IndentedWriter(System.out, true));
		//System.out.println();

		return query;
	}

	/**
	 * Execute query and put results into <code>Memory</code> object.
	 * 
	 * @param action
	 *            describing this request
	 * @return Memory with results stored as OntModel
	 */
	public Memory doQuery(Map properties, int maxResults) {

		Query query = buildQuery(restaurantVarName, properties);
		QueryExecution qexec = QueryExecutionFactory.create(query, mRestaurantsDB);

		Memory memResults = null;
		try {
			ResultSet results = qexec.execSelect();

			// For test purposes
			// ResultSetFormatter.out(System.out, results, query);

			memResults = new Memory();
			int i = 0;
			while (results.hasNext() && (maxResults == 0 || i++ < maxResults)) {

				// logger.info("Retrieving solutions !");

				QuerySolution soln = results.nextSolution();
				Resource restaurant = soln.getResource(restaurantVarName);

				// create resource of restaurant in memory
				restaurant = memResults.add(restaurant);
				OntModel m = memResults.getModel();
				RatedResult result = UserModellingFactory.createRatedResult(m.createResource(), m);
				
				
				result.setOfObject(restaurant);
				//memResults.registerRoot(result);
			}
			
		} catch (JastorException e) {
			throw new RuntimeException(e);
		} finally {
			qexec.close();
		}
		
		return memResults;
	}

	/**
	 * Constructs <code>RestaurantDAO</code> object providing access to the
	 * given model with restaurants.
	 * 
	 * @param mDomain
	 *            is model with domain ontology
	 * @param mRestaurantsDB
	 *            is a model with restaurants.
	 */
	public RestaurantDAO(OntModel mDomain, OntModel mRestaurantsDB) {
		this.mDomain = mDomain;
		this.mRestaurantsDB = mRestaurantsDB;
	}
}

