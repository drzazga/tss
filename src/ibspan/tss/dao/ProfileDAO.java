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

import ibspan.tss.um.UnknownUserProfileException;
import ibspan.tss.um.ontology.Opinion;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.vocabulary.UserModellingVocabulary;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.core.ElementGroup;
import com.hp.hpl.jena.query.core.ElementTriplePattern;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Selector;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.JastorException;
import com.ibm.adtech.jastor.Thing;

/**
 * Data Access Object providing nice interface to model with user profiles.
 * descriptions. It can be used to as work-around to access some OWL data, not
 * accessible via Jastor-generated Java beans.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class ProfileDAO {
	
	// Model with user profiles
	private Model mProfilesDB = null;
	
	private static final String PROFILE_VAR_NAME = "profile";
	private static final String OPINION_SET_VAR_NAME = "opset";

	/**
	 * Constructs <code>ProfileDAO</code> object providing interface to the
	 * given model with user profiles. This construct can be used, when there is
	 * not direct access to ontology model with profile, but only to its <i>base</i>
	 * part, e.g. when we operate on <code>Thing</code> or
	 * <code>Resource</code> object.
	 * 
	 * @param mbaseProfilesDB
	 *            is a model with user profiles.
	 *            
	 * @see Thing
	 * @see Resource
	 */
	public ProfileDAO(Model mbaseProfilesDB) {
		this.mProfilesDB = mbaseProfilesDB;
	}

	/**
	 * Constructs <code>ProfileDAO</code> object providing interface to the
	 * given model with user profiles.
	 * 
	 * @param mProfilesDB
	 *            is a model with user profiles.
	 */
	public ProfileDAO(OntModel mProfilesDB) {
		this.mProfilesDB = mProfilesDB; 
	}
	
	/**
	 * Returns profile for the user with given ID.
	 * 
	 * @param userID
	 *            is id of a user.
	 * @return user profile.
	 * @throws UnknownUserProfileException
	 *             when profile for the given user cannot be found.
	 */
	public UserProfile getUserProfile(final int userID) throws UnknownUserProfileException {
		// TODO Sometimes we return null if object cannot be found, sometime exception is thrown is such a situation. Unify it!
		Selector sel = new SimpleSelector(null, RDF.type, UserProfile.TYPE) {
			public boolean selects(Statement st) {
				//	Since mProfilesDB is database backed model, which has limitation of the
				// current database backend that the semantic mapping between plain and
				// typed (xml:int) literals doesn't work. Therefore we need to check
				// against a typed literal.		
				
				Literal l1 = st.getSubject().getProperty(UserProfile.hasUserIDProperty).getLiteral();
				Literal l2 = mProfilesDB.createTypedLiteral(userID,XSDDatatype.XSDint);
				return l1.equals(l2);
			}
		};
		
		StmtIterator it = mProfilesDB.listStatements(sel);
		if (it.hasNext()) { 	
			Resource r = it.nextStatement().getSubject();
			UserProfile profile = null;
			try {
				profile = UserModellingFactory.getUserProfile(r, mProfilesDB);
			} catch (JastorException e) {
				throw new RuntimeException(e);
			}
			return profile; 
		} else
			throw new UnknownUserProfileException("Cannot found user profile with the given userID="+userID+".");
		
	}
	
	/**
	 * Returns opinion about the given opinion stated by the given user.
	 * 
	 * @param userID
	 *            is ID of a user.
	 * @param concept
	 *            is concept objected by the opinion.
	 * @return returns opinion if exists; otherwise -- returns <code>null</code>.
	 */
	public Opinion getUserOpinionAbout(Integer userID, String concept) {
		
		String varOpinionName = "opinion";
		
		Query query = buildUserOpinionAboutQuery(varOpinionName, userID, concept);
		QueryExecution qexec = QueryExecutionFactory.create(query, mProfilesDB);
		try {
			ResultSet results = qexec.execSelect();
			if (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				return UserModellingFactory.createOpinion(soln.getResource(varOpinionName), mProfilesDB);
			} else
				// there is no such opinion
				return null;
		} catch (JastorException e) {
			throw new RuntimeException(e);
		} finally {
			qexec.close();
		} 
	}
	
	// Constructs SPARAQL query to find opinion of the user with given ID about given concept
	private Query buildUserOpinionAboutQuery(String varOpinionName, Integer userID, String concept) {
		// Let's build this query programatically
		Query query = QueryFactory.make();

		query.setQueryType(Query.QueryTypeSelect);

		// Build pattern
		ElementGroup elg = new ElementGroup();

		Node varOpinion = Node.createVariable(varOpinionName);

		// ?op rdf:type um:Opinion
		Triple t = new Triple(varOpinion, RDF.type.asNode(),
				UserModellingVocabulary.Opinion.asNode());
		ElementTriplePattern tp = new ElementTriplePattern(t);
		elg.addElement(tp);
		
		// ?op um:isAbout "concept"
		// TODO: Jena DB-based model seems to change datatype of this property
		// from xsd:anyURI into xsd:string... Don't know why
		t = new Triple(varOpinion, UserModellingVocabulary.isAbout.asNode(),
				Node.createLiteral(concept,"",XSDDatatype.XSDstring));
		tp = new ElementTriplePattern(t);
		elg.addElement(tp);
			
		Node varProfile = Node.createVariable(PROFILE_VAR_NAME);
		
		// ?profile rdf:type um:UserProfile
		t = new Triple(varProfile, RDF.type.asNode(),
				UserModellingVocabulary.UserProfile.asNode());
		tp = new ElementTriplePattern(t);
		elg.addElement(tp);
		
		// ?profile um:hasUserID "userID"
		t = new Triple(varProfile, UserModellingVocabulary.hasUserID.asNode(),
				Node.createLiteral(""+userID,"",XSDDatatype.XSDint));
		tp = new ElementTriplePattern(t);
		elg.addElement(tp);
		
		Node varOpinionSet = Node.createVariable(OPINION_SET_VAR_NAME);
		
		// ?opset rdf:type um:OpinionSet
			t = new Triple(varOpinionSet, RDF.type.asNode(),
					UserModellingVocabulary.OpinionSet.asNode());
			tp = new ElementTriplePattern(t);
			elg.addElement(tp);
		
		// ?profile um:hasOpinions ?opset
		t = new Triple(varProfile, UserModellingVocabulary.hasOpinions.asNode(),
				varOpinionSet);
		tp = new ElementTriplePattern(t);
		elg.addElement(tp);
		
		// ?opset um:containsOpinion ?op. 		
		t = new Triple(varOpinionSet, UserModellingVocabulary.containsOpinion.asNode(),
				varOpinion);
		tp = new ElementTriplePattern(t);
		elg.addElement(tp);
		
		// Attach the group to query.
		query.setQueryElement(elg);

		// Choose what we want
		query.addResultVar(varOpinion);

		// Print query with line numbers
		// Prefix mapping just helps serialization
		query.getPrefixMapping().setNsPrefix("rdf", RDF.getURI());
		query.getPrefixMapping()
				.setNsPrefix("um", UserModellingVocabulary.NS);
			
		// For test purposes...
		//query.serialize(new IndentedWriter(System.out, true));
		// System.out.println();

		return query;
	}
	

	// Constructs SPARQL query to find user with the given ID
	private Query buildGetUserProfileByIDQuery(String varProfileName, int userID) {
		// Let's build this query programatically
		Query query = QueryFactory.make();

		query.setQueryType(Query.QueryTypeSelect);

		// Build pattern
		ElementGroup elg = new ElementGroup();

		Node varProfile = Node.createVariable(varProfileName);

		Triple t1 = new Triple(varProfile, RDF.type.asNode(),
				UserModellingVocabulary.Profile.asNode());
		ElementTriplePattern tp1 = new ElementTriplePattern(t1);
		elg.addElement(tp1);

		t1 = new Triple(varProfile, UserProfile.hasUserIDProperty.asNode(),
					Node.createLiteral(""+userID, "", XSDDatatype.XSDint));
		tp1 = new ElementTriplePattern(t1);
			elg.addElement(tp1);
		
		// Attach the group to query.
		query.setQueryElement(elg);

		// Choose what we want
		query.addResultVar(varProfileName);

		// Prefix mapping just helps serialization
		query.getPrefixMapping().setNsPrefix("rdf", RDF.getURI());
		query.getPrefixMapping()
				.setNsPrefix("um", UserModellingVocabulary.NS);
		query.getPrefixMapping().setNsPrefix("xsd", XSDDatatype.XSD);
		
		// For test purposes...
		//query.serialize(new IndentedWriter(System.out, true));
		//System.out.println();

		return query;
	}
	
	/**
	 * Returns profile for the user with given ID.
	 * 
	 * @param userID
	 *            is ID of a user
	 * @return user profile or <code>null</code>, when there is no profile
	 *         for the given user ID.
	 */
	public UserProfile getUserProfileByID(Integer userID) {
		UserProfile profile = null;

		Query query = buildGetUserProfileByIDQuery(PROFILE_VAR_NAME, userID);
		QueryExecution qexec = QueryExecutionFactory.create(query, mProfilesDB);
		try {
			ResultSet results = qexec.execSelect();
			if (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				profile = UserModellingFactory.getUserProfile(soln.getResource(PROFILE_VAR_NAME), mProfilesDB);
			} 

		} catch (JastorException e) {
			throw new RuntimeException("Problem with access to user profile", e);
		} finally {
			qexec.close();
		}
		
		return profile;

		
	}

	
}
