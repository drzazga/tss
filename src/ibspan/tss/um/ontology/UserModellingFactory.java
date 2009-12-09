

package ibspan.tss.um.ontology;

import com.ibm.adtech.jastor.*;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Factory for instantiating objects for ontology classes in the UserModelling ontology.  The
 * get methods leave the model unchanged and return a Java view of the object in the model.  The create methods
 * may add certain baseline properties to the model such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : User Modelling ontology for Agent-based Travel Support System^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * Dublin Core Standard Properties <br>
 * 	creator : Maciej Gawinecki, e-mail: maciej.gawinecki@ibspan.waw.pl^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	title : User Modelling ontology for Agent-based Travel Support System^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	rights : (c) 2006 Maciej Gawinecki^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	identifier : http://www.ibspan.waw.pl/tss/UserModelling^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	date : 2006-08-22^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 *	@version TODO: Change name of Measure concept to MeasureType.^^http://www.w3.org/2001/XMLSchema#string, TODO: Make it more constistent with Messaging ontology (similar names)^^http://www.w3.org/2001/XMLSchema#string, TODO: Finish adding rdfs:comments to the ontology.^^http://www.w3.org/2001/XMLSchema#string, TODO: Make the difference between structures and properties, e.g. between UserBehaviour class and hasUserBehaviour concepts.^^http://www.w3.org/2001/XMLSchema#string
 */
public class UserModellingFactory extends com.ibm.adtech.jastor.ThingFactory { 



	/**
	 * Create a new instance of ExtendedUserBehaviour.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the ExtendedUserBehaviour
	 * @param model the Jena Model.
	 */
	public static ExtendedUserBehaviour createExtendedUserBehaviour(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.createExtendedUserBehaviour(resource,model);
	}
	
	/**
	 * Create a new instance of ExtendedUserBehaviour.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the ExtendedUserBehaviour
	 * @param model the Jena Model.
	 */
	public static ExtendedUserBehaviour createExtendedUserBehaviour(String uri, Model model) throws JastorException {
		ExtendedUserBehaviour obj = ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.createExtendedUserBehaviour(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of ExtendedUserBehaviour.  Leaves the model unchanged.
	 * @param uri The uri of the ExtendedUserBehaviour
	 * @param model the Jena Model.
	 */
	public static ExtendedUserBehaviour getExtendedUserBehaviour(String uri, Model model) throws JastorException {
		return getExtendedUserBehaviour(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of ExtendedUserBehaviour.  Leaves the model unchanged.
	 * @param resource The resource of the ExtendedUserBehaviour
	 * @param model the Jena Model.
	 */
	public static ExtendedUserBehaviour getExtendedUserBehaviour(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.ExtendedUserBehaviour.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ExtendedUserBehaviourImpl obj = (ibspan.tss.um.ontology.ExtendedUserBehaviourImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.getExtendedUserBehaviour(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of ExtendedUserBehaviour for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#ExtendedUserBehaviour
	 * @param model the Jena Model
	 * @return a List of ExtendedUserBehaviour
	 */
	public static java.util.List getAllExtendedUserBehaviour(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,ExtendedUserBehaviour.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getExtendedUserBehaviour(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of NominalSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the NominalSet
	 * @param model the Jena Model.
	 */
	public static NominalSet createNominalSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.NominalSetImpl.createNominalSet(resource,model);
	}
	
	/**
	 * Create a new instance of NominalSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the NominalSet
	 * @param model the Jena Model.
	 */
	public static NominalSet createNominalSet(String uri, Model model) throws JastorException {
		NominalSet obj = ibspan.tss.um.ontology.NominalSetImpl.createNominalSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of NominalSet.  Leaves the model unchanged.
	 * @param uri The uri of the NominalSet
	 * @param model the Jena Model.
	 */
	public static NominalSet getNominalSet(String uri, Model model) throws JastorException {
		return getNominalSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of NominalSet.  Leaves the model unchanged.
	 * @param resource The resource of the NominalSet
	 * @param model the Jena Model.
	 */
	public static NominalSet getNominalSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.NominalSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.NominalSetImpl obj = (ibspan.tss.um.ontology.NominalSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.NominalSetImpl.getNominalSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of NominalSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#NominalSet
	 * @param model the Jena Model
	 * @return a List of NominalSet
	 */
	public static java.util.List getAllNominalSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,NominalSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getNominalSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of IntervalDomain.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the IntervalDomain
	 * @param model the Jena Model.
	 */
	public static IntervalDomain createIntervalDomain(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.IntervalDomainImpl.createIntervalDomain(resource,model);
	}
	
	/**
	 * Create a new instance of IntervalDomain.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the IntervalDomain
	 * @param model the Jena Model.
	 */
	public static IntervalDomain createIntervalDomain(String uri, Model model) throws JastorException {
		IntervalDomain obj = ibspan.tss.um.ontology.IntervalDomainImpl.createIntervalDomain(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of IntervalDomain.  Leaves the model unchanged.
	 * @param uri The uri of the IntervalDomain
	 * @param model the Jena Model.
	 */
	public static IntervalDomain getIntervalDomain(String uri, Model model) throws JastorException {
		return getIntervalDomain(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of IntervalDomain.  Leaves the model unchanged.
	 * @param resource The resource of the IntervalDomain
	 * @param model the Jena Model.
	 */
	public static IntervalDomain getIntervalDomain(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.IntervalDomain.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.IntervalDomainImpl obj = (ibspan.tss.um.ontology.IntervalDomainImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.IntervalDomainImpl.getIntervalDomain(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an AgeDomain individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IntervalDomain.
	 */
	public static IntervalDomain getAgeDomain(Model model) throws JastorException {
		Resource resource = model.createResource(IntervalDomain.AgeDomain.getURI());
		IntervalDomainImpl obj = (IntervalDomainImpl)getIntervalDomain(resource, model);
		if (obj == null) {
			createIntervalDomain(resource, model);
			obj = (IntervalDomainImpl)getIntervalDomain(resource, model);
			obj.initAsAgeDomain();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of IntervalDomain for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#IntervalDomain
	 * @param model the Jena Model
	 * @return a List of IntervalDomain
	 */
	public static java.util.List getAllIntervalDomain(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,IntervalDomain.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getIntervalDomain(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of OpinionSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the OpinionSet
	 * @param model the Jena Model.
	 */
	public static OpinionSet createOpinionSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.OpinionSetImpl.createOpinionSet(resource,model);
	}
	
	/**
	 * Create a new instance of OpinionSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the OpinionSet
	 * @param model the Jena Model.
	 */
	public static OpinionSet createOpinionSet(String uri, Model model) throws JastorException {
		OpinionSet obj = ibspan.tss.um.ontology.OpinionSetImpl.createOpinionSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of OpinionSet.  Leaves the model unchanged.
	 * @param uri The uri of the OpinionSet
	 * @param model the Jena Model.
	 */
	public static OpinionSet getOpinionSet(String uri, Model model) throws JastorException {
		return getOpinionSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of OpinionSet.  Leaves the model unchanged.
	 * @param resource The resource of the OpinionSet
	 * @param model the Jena Model.
	 */
	public static OpinionSet getOpinionSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.OpinionSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.OpinionSetImpl obj = (ibspan.tss.um.ontology.OpinionSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.OpinionSetImpl.getOpinionSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of OpinionSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#OpinionSet
	 * @param model the Jena Model
	 * @return a List of OpinionSet
	 */
	public static java.util.List getAllOpinionSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,OpinionSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getOpinionSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Parameter
	 * @param model the Jena Model.
	 */
	public static Parameter createParameter(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ParameterImpl.createParameter(resource,model);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Parameter
	 * @param model the Jena Model.
	 */
	public static Parameter createParameter(String uri, Model model) throws JastorException {
		Parameter obj = ibspan.tss.um.ontology.ParameterImpl.createParameter(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Parameter.  Leaves the model unchanged.
	 * @param uri The uri of the Parameter
	 * @param model the Jena Model.
	 */
	public static Parameter getParameter(String uri, Model model) throws JastorException {
		return getParameter(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Parameter.  Leaves the model unchanged.
	 * @param resource The resource of the Parameter
	 * @param model the Jena Model.
	 */
	public static Parameter getParameter(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Parameter.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ParameterImpl obj = (ibspan.tss.um.ontology.ParameterImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ParameterImpl.getParameter(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Parameter for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Parameter
	 * @param model the Jena Model
	 * @return a List of Parameter
	 */
	public static java.util.List getAllParameter(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Parameter.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getParameter(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Age.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Age
	 * @param model the Jena Model.
	 */
	public static Age createAge(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.AgeImpl.createAge(resource,model);
	}
	
	/**
	 * Create a new instance of Age.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Age
	 * @param model the Jena Model.
	 */
	public static Age createAge(String uri, Model model) throws JastorException {
		Age obj = ibspan.tss.um.ontology.AgeImpl.createAge(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Age.  Leaves the model unchanged.
	 * @param uri The uri of the Age
	 * @param model the Jena Model.
	 */
	public static Age getAge(String uri, Model model) throws JastorException {
		return getAge(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Age.  Leaves the model unchanged.
	 * @param resource The resource of the Age
	 * @param model the Jena Model.
	 */
	public static Age getAge(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Age.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.AgeImpl obj = (ibspan.tss.um.ontology.AgeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.AgeImpl.getAge(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an AgeMin individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Age.
	 */
	public static Age getAgeMin(Model model) throws JastorException {
		Resource resource = model.createResource(Age.AgeMin.getURI());
		AgeImpl obj = (AgeImpl)getAge(resource, model);
		if (obj == null) {
			createAge(resource, model);
			obj = (AgeImpl)getAge(resource, model);
			obj.initAsAgeMin();			
		}
		return obj;
	}
	/** 
	 * Get an AgeMax individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Age.
	 */
	public static Age getAgeMax(Model model) throws JastorException {
		Resource resource = model.createResource(Age.AgeMax.getURI());
		AgeImpl obj = (AgeImpl)getAge(resource, model);
		if (obj == null) {
			createAge(resource, model);
			obj = (AgeImpl)getAge(resource, model);
			obj.initAsAgeMax();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Age for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Age
	 * @param model the Jena Model
	 * @return a List of Age
	 */
	public static java.util.List getAllAge(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Age.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getAge(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of UserBehaviourContext.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the UserBehaviourContext
	 * @param model the Jena Model.
	 */
	public static UserBehaviourContext createUserBehaviourContext(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.UserBehaviourContextImpl.createUserBehaviourContext(resource,model);
	}
	
	/**
	 * Create a new instance of UserBehaviourContext.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the UserBehaviourContext
	 * @param model the Jena Model.
	 */
	public static UserBehaviourContext createUserBehaviourContext(String uri, Model model) throws JastorException {
		UserBehaviourContext obj = ibspan.tss.um.ontology.UserBehaviourContextImpl.createUserBehaviourContext(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of UserBehaviourContext.  Leaves the model unchanged.
	 * @param uri The uri of the UserBehaviourContext
	 * @param model the Jena Model.
	 */
	public static UserBehaviourContext getUserBehaviourContext(String uri, Model model) throws JastorException {
		return getUserBehaviourContext(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of UserBehaviourContext.  Leaves the model unchanged.
	 * @param resource The resource of the UserBehaviourContext
	 * @param model the Jena Model.
	 */
	public static UserBehaviourContext getUserBehaviourContext(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.UserBehaviourContext.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.UserBehaviourContextImpl obj = (ibspan.tss.um.ontology.UserBehaviourContextImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.UserBehaviourContextImpl.getUserBehaviourContext(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of UserBehaviourContext for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviourContext
	 * @param model the Jena Model
	 * @return a List of UserBehaviourContext
	 */
	public static java.util.List getAllUserBehaviourContext(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,UserBehaviourContext.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getUserBehaviourContext(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Ordinal.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Ordinal
	 * @param model the Jena Model.
	 */
	public static Ordinal createOrdinal(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.OrdinalImpl.createOrdinal(resource,model);
	}
	
	/**
	 * Create a new instance of Ordinal.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Ordinal
	 * @param model the Jena Model.
	 */
	public static Ordinal createOrdinal(String uri, Model model) throws JastorException {
		Ordinal obj = ibspan.tss.um.ontology.OrdinalImpl.createOrdinal(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Ordinal.  Leaves the model unchanged.
	 * @param uri The uri of the Ordinal
	 * @param model the Jena Model.
	 */
	public static Ordinal getOrdinal(String uri, Model model) throws JastorException {
		return getOrdinal(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Ordinal.  Leaves the model unchanged.
	 * @param resource The resource of the Ordinal
	 * @param model the Jena Model.
	 */
	public static Ordinal getOrdinal(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Ordinal.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.OrdinalImpl obj = (ibspan.tss.um.ontology.OrdinalImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.OrdinalImpl.getOrdinal(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Ordinal for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Ordinal
	 * @param model the Jena Model
	 * @return a List of Ordinal
	 */
	public static java.util.List getAllOrdinal(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Ordinal.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getOrdinal(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Opinion.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Opinion
	 * @param model the Jena Model.
	 */
	public static Opinion createOpinion(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.OpinionImpl.createOpinion(resource,model);
	}
	
	/**
	 * Create a new instance of Opinion.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Opinion
	 * @param model the Jena Model.
	 */
	public static Opinion createOpinion(String uri, Model model) throws JastorException {
		Opinion obj = ibspan.tss.um.ontology.OpinionImpl.createOpinion(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Opinion.  Leaves the model unchanged.
	 * @param uri The uri of the Opinion
	 * @param model the Jena Model.
	 */
	public static Opinion getOpinion(String uri, Model model) throws JastorException {
		return getOpinion(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Opinion.  Leaves the model unchanged.
	 * @param resource The resource of the Opinion
	 * @param model the Jena Model.
	 */
	public static Opinion getOpinion(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Opinion.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.OpinionImpl obj = (ibspan.tss.um.ontology.OpinionImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.OpinionImpl.getOpinion(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Opinion for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Opinion
	 * @param model the Jena Model
	 * @return a List of Opinion
	 */
	public static java.util.List getAllOpinion(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Opinion.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getOpinion(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of MeasureSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the MeasureSet
	 * @param model the Jena Model.
	 */
	public static MeasureSet createMeasureSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.MeasureSetImpl.createMeasureSet(resource,model);
	}
	
	/**
	 * Create a new instance of MeasureSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the MeasureSet
	 * @param model the Jena Model.
	 */
	public static MeasureSet createMeasureSet(String uri, Model model) throws JastorException {
		MeasureSet obj = ibspan.tss.um.ontology.MeasureSetImpl.createMeasureSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of MeasureSet.  Leaves the model unchanged.
	 * @param uri The uri of the MeasureSet
	 * @param model the Jena Model.
	 */
	public static MeasureSet getMeasureSet(String uri, Model model) throws JastorException {
		return getMeasureSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of MeasureSet.  Leaves the model unchanged.
	 * @param resource The resource of the MeasureSet
	 * @param model the Jena Model.
	 */
	public static MeasureSet getMeasureSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.MeasureSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.MeasureSetImpl obj = (ibspan.tss.um.ontology.MeasureSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.MeasureSetImpl.getMeasureSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of MeasureSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#MeasureSet
	 * @param model the Jena Model
	 * @return a List of MeasureSet
	 */
	public static java.util.List getAllMeasureSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,MeasureSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getMeasureSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Classification.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Classification
	 * @param model the Jena Model.
	 */
	public static Classification createClassification(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ClassificationImpl.createClassification(resource,model);
	}
	
	/**
	 * Create a new instance of Classification.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Classification
	 * @param model the Jena Model.
	 */
	public static Classification createClassification(String uri, Model model) throws JastorException {
		Classification obj = ibspan.tss.um.ontology.ClassificationImpl.createClassification(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Classification.  Leaves the model unchanged.
	 * @param uri The uri of the Classification
	 * @param model the Jena Model.
	 */
	public static Classification getClassification(String uri, Model model) throws JastorException {
		return getClassification(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Classification.  Leaves the model unchanged.
	 * @param resource The resource of the Classification
	 * @param model the Jena Model.
	 */
	public static Classification getClassification(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Classification.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ClassificationImpl obj = (ibspan.tss.um.ontology.ClassificationImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ClassificationImpl.getClassification(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an NotClassified individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Classification.
	 */
	public static Classification getNotClassified(Model model) throws JastorException {
		Resource resource = model.createResource(Classification.NotClassified.getURI());
		ClassificationImpl obj = (ClassificationImpl)getClassification(resource, model);
		if (obj == null) {
			createClassification(resource, model);
			obj = (ClassificationImpl)getClassification(resource, model);
			obj.initAsNotClassified();			
		}
		return obj;
	}
	/** 
	 * Get an NotInteresting individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Classification.
	 */
	public static Classification getNotInteresting(Model model) throws JastorException {
		Resource resource = model.createResource(Classification.NotInteresting.getURI());
		ClassificationImpl obj = (ClassificationImpl)getClassification(resource, model);
		if (obj == null) {
			createClassification(resource, model);
			obj = (ClassificationImpl)getClassification(resource, model);
			obj.initAsNotInteresting();			
		}
		return obj;
	}
	/** 
	 * Get an Interesting individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Classification.
	 */
	public static Classification getInteresting(Model model) throws JastorException {
		Resource resource = model.createResource(Classification.Interesting.getURI());
		ClassificationImpl obj = (ClassificationImpl)getClassification(resource, model);
		if (obj == null) {
			createClassification(resource, model);
			obj = (ClassificationImpl)getClassification(resource, model);
			obj.initAsInteresting();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Classification for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Classification
	 * @param model the Jena Model
	 * @return a List of Classification
	 */
	public static java.util.List getAllClassification(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Classification.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getClassification(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of StereotypeProfileData.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the StereotypeProfileData
	 * @param model the Jena Model.
	 */
	public static StereotypeProfileData createStereotypeProfileData(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.StereotypeProfileDataImpl.createStereotypeProfileData(resource,model);
	}
	
	/**
	 * Create a new instance of StereotypeProfileData.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the StereotypeProfileData
	 * @param model the Jena Model.
	 */
	public static StereotypeProfileData createStereotypeProfileData(String uri, Model model) throws JastorException {
		StereotypeProfileData obj = ibspan.tss.um.ontology.StereotypeProfileDataImpl.createStereotypeProfileData(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of StereotypeProfileData.  Leaves the model unchanged.
	 * @param uri The uri of the StereotypeProfileData
	 * @param model the Jena Model.
	 */
	public static StereotypeProfileData getStereotypeProfileData(String uri, Model model) throws JastorException {
		return getStereotypeProfileData(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of StereotypeProfileData.  Leaves the model unchanged.
	 * @param resource The resource of the StereotypeProfileData
	 * @param model the Jena Model.
	 */
	public static StereotypeProfileData getStereotypeProfileData(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.StereotypeProfileData.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.StereotypeProfileDataImpl obj = (ibspan.tss.um.ontology.StereotypeProfileDataImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.StereotypeProfileDataImpl.getStereotypeProfileData(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of StereotypeProfileData for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfileData
	 * @param model the Jena Model
	 * @return a List of StereotypeProfileData
	 */
	public static java.util.List getAllStereotypeProfileData(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,StereotypeProfileData.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getStereotypeProfileData(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Nominal.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Nominal
	 * @param model the Jena Model.
	 */
	public static Nominal createNominal(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.NominalImpl.createNominal(resource,model);
	}
	
	/**
	 * Create a new instance of Nominal.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Nominal
	 * @param model the Jena Model.
	 */
	public static Nominal createNominal(String uri, Model model) throws JastorException {
		Nominal obj = ibspan.tss.um.ontology.NominalImpl.createNominal(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Nominal.  Leaves the model unchanged.
	 * @param uri The uri of the Nominal
	 * @param model the Jena Model.
	 */
	public static Nominal getNominal(String uri, Model model) throws JastorException {
		return getNominal(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Nominal.  Leaves the model unchanged.
	 * @param resource The resource of the Nominal
	 * @param model the Jena Model.
	 */
	public static Nominal getNominal(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Nominal.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.NominalImpl obj = (ibspan.tss.um.ontology.NominalImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.NominalImpl.getNominal(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Nominal for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Nominal
	 * @param model the Jena Model
	 * @return a List of Nominal
	 */
	public static java.util.List getAllNominal(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Nominal.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getNominal(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Interval.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Interval
	 * @param model the Jena Model.
	 */
	public static Interval createInterval(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.IntervalImpl.createInterval(resource,model);
	}
	
	/**
	 * Create a new instance of Interval.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Interval
	 * @param model the Jena Model.
	 */
	public static Interval createInterval(String uri, Model model) throws JastorException {
		Interval obj = ibspan.tss.um.ontology.IntervalImpl.createInterval(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Interval.  Leaves the model unchanged.
	 * @param uri The uri of the Interval
	 * @param model the Jena Model.
	 */
	public static Interval getInterval(String uri, Model model) throws JastorException {
		return getInterval(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Interval.  Leaves the model unchanged.
	 * @param resource The resource of the Interval
	 * @param model the Jena Model.
	 */
	public static Interval getInterval(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Interval.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.IntervalImpl obj = (ibspan.tss.um.ontology.IntervalImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.IntervalImpl.getInterval(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Interval for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Interval
	 * @param model the Jena Model
	 * @return a List of Interval
	 */
	public static java.util.List getAllInterval(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Interval.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getInterval(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of AgeSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the AgeSet
	 * @param model the Jena Model.
	 */
	public static AgeSet createAgeSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.AgeSetImpl.createAgeSet(resource,model);
	}
	
	/**
	 * Create a new instance of AgeSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the AgeSet
	 * @param model the Jena Model.
	 */
	public static AgeSet createAgeSet(String uri, Model model) throws JastorException {
		AgeSet obj = ibspan.tss.um.ontology.AgeSetImpl.createAgeSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of AgeSet.  Leaves the model unchanged.
	 * @param uri The uri of the AgeSet
	 * @param model the Jena Model.
	 */
	public static AgeSet getAgeSet(String uri, Model model) throws JastorException {
		return getAgeSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of AgeSet.  Leaves the model unchanged.
	 * @param resource The resource of the AgeSet
	 * @param model the Jena Model.
	 */
	public static AgeSet getAgeSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.AgeSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.AgeSetImpl obj = (ibspan.tss.um.ontology.AgeSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.AgeSetImpl.getAgeSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of AgeSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#AgeSet
	 * @param model the Jena Model
	 * @return a List of AgeSet
	 */
	public static java.util.List getAllAgeSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,AgeSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getAgeSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of ProfessionSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the ProfessionSet
	 * @param model the Jena Model.
	 */
	public static ProfessionSet createProfessionSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ProfessionSetImpl.createProfessionSet(resource,model);
	}
	
	/**
	 * Create a new instance of ProfessionSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the ProfessionSet
	 * @param model the Jena Model.
	 */
	public static ProfessionSet createProfessionSet(String uri, Model model) throws JastorException {
		ProfessionSet obj = ibspan.tss.um.ontology.ProfessionSetImpl.createProfessionSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of ProfessionSet.  Leaves the model unchanged.
	 * @param uri The uri of the ProfessionSet
	 * @param model the Jena Model.
	 */
	public static ProfessionSet getProfessionSet(String uri, Model model) throws JastorException {
		return getProfessionSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of ProfessionSet.  Leaves the model unchanged.
	 * @param resource The resource of the ProfessionSet
	 * @param model the Jena Model.
	 */
	public static ProfessionSet getProfessionSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.ProfessionSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ProfessionSetImpl obj = (ibspan.tss.um.ontology.ProfessionSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ProfessionSetImpl.getProfessionSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of ProfessionSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#ProfessionSet
	 * @param model the Jena Model
	 * @return a List of ProfessionSet
	 */
	public static java.util.List getAllProfessionSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,ProfessionSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getProfessionSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of IntervalSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the IntervalSet
	 * @param model the Jena Model.
	 */
	public static IntervalSet createIntervalSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.IntervalSetImpl.createIntervalSet(resource,model);
	}
	
	/**
	 * Create a new instance of IntervalSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the IntervalSet
	 * @param model the Jena Model.
	 */
	public static IntervalSet createIntervalSet(String uri, Model model) throws JastorException {
		IntervalSet obj = ibspan.tss.um.ontology.IntervalSetImpl.createIntervalSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of IntervalSet.  Leaves the model unchanged.
	 * @param uri The uri of the IntervalSet
	 * @param model the Jena Model.
	 */
	public static IntervalSet getIntervalSet(String uri, Model model) throws JastorException {
		return getIntervalSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of IntervalSet.  Leaves the model unchanged.
	 * @param resource The resource of the IntervalSet
	 * @param model the Jena Model.
	 */
	public static IntervalSet getIntervalSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.IntervalSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.IntervalSetImpl obj = (ibspan.tss.um.ontology.IntervalSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.IntervalSetImpl.getIntervalSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of IntervalSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#IntervalSet
	 * @param model the Jena Model
	 * @return a List of IntervalSet
	 */
	public static java.util.List getAllIntervalSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,IntervalSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getIntervalSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Profile.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Profile
	 * @param model the Jena Model.
	 */
	public static Profile createProfile(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ProfileImpl.createProfile(resource,model);
	}
	
	/**
	 * Create a new instance of Profile.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Profile
	 * @param model the Jena Model.
	 */
	public static Profile createProfile(String uri, Model model) throws JastorException {
		Profile obj = ibspan.tss.um.ontology.ProfileImpl.createProfile(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Profile.  Leaves the model unchanged.
	 * @param uri The uri of the Profile
	 * @param model the Jena Model.
	 */
	public static Profile getProfile(String uri, Model model) throws JastorException {
		return getProfile(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Profile.  Leaves the model unchanged.
	 * @param resource The resource of the Profile
	 * @param model the Jena Model.
	 */
	public static Profile getProfile(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Profile.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ProfileImpl obj = (ibspan.tss.um.ontology.ProfileImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ProfileImpl.getProfile(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Profile for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Profile
	 * @param model the Jena Model
	 * @return a List of Profile
	 */
	public static java.util.List getAllProfile(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Profile.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getProfile(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of UserProfile.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the UserProfile
	 * @param model the Jena Model.
	 */
	public static UserProfile createUserProfile(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.UserProfileImpl.createUserProfile(resource,model);
	}
	
	/**
	 * Create a new instance of UserProfile.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the UserProfile
	 * @param model the Jena Model.
	 */
	public static UserProfile createUserProfile(String uri, Model model) throws JastorException {
		UserProfile obj = ibspan.tss.um.ontology.UserProfileImpl.createUserProfile(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of UserProfile.  Leaves the model unchanged.
	 * @param uri The uri of the UserProfile
	 * @param model the Jena Model.
	 */
	public static UserProfile getUserProfile(String uri, Model model) throws JastorException {
		return getUserProfile(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of UserProfile.  Leaves the model unchanged.
	 * @param resource The resource of the UserProfile
	 * @param model the Jena Model.
	 */
	public static UserProfile getUserProfile(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.UserProfile.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.UserProfileImpl obj = (ibspan.tss.um.ontology.UserProfileImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.UserProfileImpl.getUserProfile(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of UserProfile for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#UserProfile
	 * @param model the Jena Model
	 * @return a List of UserProfile
	 */
	public static java.util.List getAllUserProfile(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,UserProfile.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getUserProfile(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of StereotypeProfile.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the StereotypeProfile
	 * @param model the Jena Model.
	 */
	public static StereotypeProfile createStereotypeProfile(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.StereotypeProfileImpl.createStereotypeProfile(resource,model);
	}
	
	/**
	 * Create a new instance of StereotypeProfile.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the StereotypeProfile
	 * @param model the Jena Model.
	 */
	public static StereotypeProfile createStereotypeProfile(String uri, Model model) throws JastorException {
		StereotypeProfile obj = ibspan.tss.um.ontology.StereotypeProfileImpl.createStereotypeProfile(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of StereotypeProfile.  Leaves the model unchanged.
	 * @param uri The uri of the StereotypeProfile
	 * @param model the Jena Model.
	 */
	public static StereotypeProfile getStereotypeProfile(String uri, Model model) throws JastorException {
		return getStereotypeProfile(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of StereotypeProfile.  Leaves the model unchanged.
	 * @param resource The resource of the StereotypeProfile
	 * @param model the Jena Model.
	 */
	public static StereotypeProfile getStereotypeProfile(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.StereotypeProfile.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.StereotypeProfileImpl obj = (ibspan.tss.um.ontology.StereotypeProfileImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.StereotypeProfileImpl.getStereotypeProfile(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of StereotypeProfile for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfile
	 * @param model the Jena Model
	 * @return a List of StereotypeProfile
	 */
	public static java.util.List getAllStereotypeProfile(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,StereotypeProfile.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getStereotypeProfile(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of ProfileData.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the ProfileData
	 * @param model the Jena Model.
	 */
	public static ProfileData createProfileData(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ProfileDataImpl.createProfileData(resource,model);
	}
	
	/**
	 * Create a new instance of ProfileData.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the ProfileData
	 * @param model the Jena Model.
	 */
	public static ProfileData createProfileData(String uri, Model model) throws JastorException {
		ProfileData obj = ibspan.tss.um.ontology.ProfileDataImpl.createProfileData(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of ProfileData.  Leaves the model unchanged.
	 * @param uri The uri of the ProfileData
	 * @param model the Jena Model.
	 */
	public static ProfileData getProfileData(String uri, Model model) throws JastorException {
		return getProfileData(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of ProfileData.  Leaves the model unchanged.
	 * @param resource The resource of the ProfileData
	 * @param model the Jena Model.
	 */
	public static ProfileData getProfileData(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.ProfileData.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ProfileDataImpl obj = (ibspan.tss.um.ontology.ProfileDataImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ProfileDataImpl.getProfileData(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of ProfileData for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#ProfileData
	 * @param model the Jena Model
	 * @return a List of ProfileData
	 */
	public static java.util.List getAllProfileData(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,ProfileData.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getProfileData(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of EventSession.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the EventSession
	 * @param model the Jena Model.
	 */
	public static EventSession createEventSession(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.EventSessionImpl.createEventSession(resource,model);
	}
	
	/**
	 * Create a new instance of EventSession.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the EventSession
	 * @param model the Jena Model.
	 */
	public static EventSession createEventSession(String uri, Model model) throws JastorException {
		EventSession obj = ibspan.tss.um.ontology.EventSessionImpl.createEventSession(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of EventSession.  Leaves the model unchanged.
	 * @param uri The uri of the EventSession
	 * @param model the Jena Model.
	 */
	public static EventSession getEventSession(String uri, Model model) throws JastorException {
		return getEventSession(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of EventSession.  Leaves the model unchanged.
	 * @param resource The resource of the EventSession
	 * @param model the Jena Model.
	 */
	public static EventSession getEventSession(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.EventSession.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.EventSessionImpl obj = (ibspan.tss.um.ontology.EventSessionImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.EventSessionImpl.getEventSession(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of EventSession for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#EventSession
	 * @param model the Jena Model
	 * @return a List of EventSession
	 */
	public static java.util.List getAllEventSession(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,EventSession.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getEventSession(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of WealthSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the WealthSet
	 * @param model the Jena Model.
	 */
	public static WealthSet createWealthSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.WealthSetImpl.createWealthSet(resource,model);
	}
	
	/**
	 * Create a new instance of WealthSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the WealthSet
	 * @param model the Jena Model.
	 */
	public static WealthSet createWealthSet(String uri, Model model) throws JastorException {
		WealthSet obj = ibspan.tss.um.ontology.WealthSetImpl.createWealthSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of WealthSet.  Leaves the model unchanged.
	 * @param uri The uri of the WealthSet
	 * @param model the Jena Model.
	 */
	public static WealthSet getWealthSet(String uri, Model model) throws JastorException {
		return getWealthSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of WealthSet.  Leaves the model unchanged.
	 * @param resource The resource of the WealthSet
	 * @param model the Jena Model.
	 */
	public static WealthSet getWealthSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.WealthSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.WealthSetImpl obj = (ibspan.tss.um.ontology.WealthSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.WealthSetImpl.getWealthSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of WealthSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#WealthSet
	 * @param model the Jena Model
	 * @return a List of WealthSet
	 */
	public static java.util.List getAllWealthSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,WealthSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getWealthSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of RatedResult.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the RatedResult
	 * @param model the Jena Model.
	 */
	public static RatedResult createRatedResult(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.RatedResultImpl.createRatedResult(resource,model);
	}
	
	/**
	 * Create a new instance of RatedResult.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the RatedResult
	 * @param model the Jena Model.
	 */
	public static RatedResult createRatedResult(String uri, Model model) throws JastorException {
		RatedResult obj = ibspan.tss.um.ontology.RatedResultImpl.createRatedResult(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of RatedResult.  Leaves the model unchanged.
	 * @param uri The uri of the RatedResult
	 * @param model the Jena Model.
	 */
	public static RatedResult getRatedResult(String uri, Model model) throws JastorException {
		return getRatedResult(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of RatedResult.  Leaves the model unchanged.
	 * @param resource The resource of the RatedResult
	 * @param model the Jena Model.
	 */
	public static RatedResult getRatedResult(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.RatedResult.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.RatedResultImpl obj = (ibspan.tss.um.ontology.RatedResultImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.RatedResultImpl.getRatedResult(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of RatedResult for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#RatedResult
	 * @param model the Jena Model
	 * @return a List of RatedResult
	 */
	public static java.util.List getAllRatedResult(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,RatedResult.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getRatedResult(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of ContextParameter.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the ContextParameter
	 * @param model the Jena Model.
	 */
	public static ContextParameter createContextParameter(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ContextParameterImpl.createContextParameter(resource,model);
	}
	
	/**
	 * Create a new instance of ContextParameter.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the ContextParameter
	 * @param model the Jena Model.
	 */
	public static ContextParameter createContextParameter(String uri, Model model) throws JastorException {
		ContextParameter obj = ibspan.tss.um.ontology.ContextParameterImpl.createContextParameter(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of ContextParameter.  Leaves the model unchanged.
	 * @param uri The uri of the ContextParameter
	 * @param model the Jena Model.
	 */
	public static ContextParameter getContextParameter(String uri, Model model) throws JastorException {
		return getContextParameter(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of ContextParameter.  Leaves the model unchanged.
	 * @param resource The resource of the ContextParameter
	 * @param model the Jena Model.
	 */
	public static ContextParameter getContextParameter(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.ContextParameter.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ContextParameterImpl obj = (ibspan.tss.um.ontology.ContextParameterImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ContextParameterImpl.getContextParameter(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an TargetURI individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ContextParameter.
	 */
	public static ContextParameter getTargetURI(Model model) throws JastorException {
		Resource resource = model.createResource(ContextParameter.TargetURI.getURI());
		ContextParameterImpl obj = (ContextParameterImpl)getContextParameter(resource, model);
		if (obj == null) {
			createContextParameter(resource, model);
			obj = (ContextParameterImpl)getContextParameter(resource, model);
			obj.initAsTargetURI();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of ContextParameter for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#ContextParameter
	 * @param model the Jena Model
	 * @return a List of ContextParameter
	 */
	public static java.util.List getAllContextParameter(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,ContextParameter.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getContextParameter(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Measure.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Measure
	 * @param model the Jena Model.
	 */
	public static Measure createMeasure(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.MeasureImpl.createMeasure(resource,model);
	}
	
	/**
	 * Create a new instance of Measure.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Measure
	 * @param model the Jena Model.
	 */
	public static Measure createMeasure(String uri, Model model) throws JastorException {
		Measure obj = ibspan.tss.um.ontology.MeasureImpl.createMeasure(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Measure.  Leaves the model unchanged.
	 * @param uri The uri of the Measure
	 * @param model the Jena Model.
	 */
	public static Measure getMeasure(String uri, Model model) throws JastorException {
		return getMeasure(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Measure.  Leaves the model unchanged.
	 * @param resource The resource of the Measure
	 * @param model the Jena Model.
	 */
	public static Measure getMeasure(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Measure.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.MeasureImpl obj = (ibspan.tss.um.ontology.MeasureImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.MeasureImpl.getMeasure(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Measure for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Measure
	 * @param model the Jena Model
	 * @return a List of Measure
	 */
	public static java.util.List getAllMeasure(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Measure.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getMeasure(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Dress.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Dress
	 * @param model the Jena Model.
	 */
	public static Dress createDress(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.DressImpl.createDress(resource,model);
	}
	
	/**
	 * Create a new instance of Dress.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Dress
	 * @param model the Jena Model.
	 */
	public static Dress createDress(String uri, Model model) throws JastorException {
		Dress obj = ibspan.tss.um.ontology.DressImpl.createDress(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Dress.  Leaves the model unchanged.
	 * @param uri The uri of the Dress
	 * @param model the Jena Model.
	 */
	public static Dress getDress(String uri, Model model) throws JastorException {
		return getDress(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Dress.  Leaves the model unchanged.
	 * @param resource The resource of the Dress
	 * @param model the Jena Model.
	 */
	public static Dress getDress(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Dress.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.DressImpl obj = (ibspan.tss.um.ontology.DressImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.DressImpl.getDress(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an NaturalDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Dress.
	 */
	public static Dress getNaturalDress(Model model) throws JastorException {
		Resource resource = model.createResource(Dress.NaturalDress.getURI());
		DressImpl obj = (DressImpl)getDress(resource, model);
		if (obj == null) {
			createDress(resource, model);
			obj = (DressImpl)getDress(resource, model);
			obj.initAsNaturalDress();			
		}
		return obj;
	}
	/** 
	 * Get an ElegantDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Dress.
	 */
	public static Dress getElegantDress(Model model) throws JastorException {
		Resource resource = model.createResource(Dress.ElegantDress.getURI());
		DressImpl obj = (DressImpl)getDress(resource, model);
		if (obj == null) {
			createDress(resource, model);
			obj = (DressImpl)getDress(resource, model);
			obj.initAsElegantDress();			
		}
		return obj;
	}
	/** 
	 * Get an SportyDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Dress.
	 */
	public static Dress getSportyDress(Model model) throws JastorException {
		Resource resource = model.createResource(Dress.SportyDress.getURI());
		DressImpl obj = (DressImpl)getDress(resource, model);
		if (obj == null) {
			createDress(resource, model);
			obj = (DressImpl)getDress(resource, model);
			obj.initAsSportyDress();			
		}
		return obj;
	}
	/** 
	 * Get an OtherDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Dress.
	 */
	public static Dress getOtherDress(Model model) throws JastorException {
		Resource resource = model.createResource(Dress.OtherDress.getURI());
		DressImpl obj = (DressImpl)getDress(resource, model);
		if (obj == null) {
			createDress(resource, model);
			obj = (DressImpl)getDress(resource, model);
			obj.initAsOtherDress();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Dress for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Dress
	 * @param model the Jena Model
	 * @return a List of Dress
	 */
	public static java.util.List getAllDress(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Dress.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getDress(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Event.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Event
	 * @param model the Jena Model.
	 */
	public static Event createEvent(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.EventImpl.createEvent(resource,model);
	}
	
	/**
	 * Create a new instance of Event.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Event
	 * @param model the Jena Model.
	 */
	public static Event createEvent(String uri, Model model) throws JastorException {
		Event obj = ibspan.tss.um.ontology.EventImpl.createEvent(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Event.  Leaves the model unchanged.
	 * @param uri The uri of the Event
	 * @param model the Jena Model.
	 */
	public static Event getEvent(String uri, Model model) throws JastorException {
		return getEvent(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Event.  Leaves the model unchanged.
	 * @param resource The resource of the Event
	 * @param model the Jena Model.
	 */
	public static Event getEvent(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Event.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.EventImpl obj = (ibspan.tss.um.ontology.EventImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.EventImpl.getEvent(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an LastEvent individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Event.
	 */
	public static Event getLastEvent(Model model) throws JastorException {
		Resource resource = model.createResource(Event.LastEvent.getURI());
		EventImpl obj = (EventImpl)getEvent(resource, model);
		if (obj == null) {
			createEvent(resource, model);
			obj = (EventImpl)getEvent(resource, model);
			obj.initAsLastEvent();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Event for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Event
	 * @param model the Jena Model
	 * @return a List of Event
	 */
	public static java.util.List getAllEvent(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Event.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getEvent(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the User
	 * @param model the Jena Model.
	 */
	public static User createUser(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.UserImpl.createUser(resource,model);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the User
	 * @param model the Jena Model.
	 */
	public static User createUser(String uri, Model model) throws JastorException {
		User obj = ibspan.tss.um.ontology.UserImpl.createUser(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of User.  Leaves the model unchanged.
	 * @param uri The uri of the User
	 * @param model the Jena Model.
	 */
	public static User getUser(String uri, Model model) throws JastorException {
		return getUser(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of User.  Leaves the model unchanged.
	 * @param resource The resource of the User
	 * @param model the Jena Model.
	 */
	public static User getUser(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.User.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.UserImpl obj = (ibspan.tss.um.ontology.UserImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.UserImpl.getUser(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an LastUser individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of User.
	 */
	public static User getLastUser(Model model) throws JastorException {
		Resource resource = model.createResource(User.LastUser.getURI());
		UserImpl obj = (UserImpl)getUser(resource, model);
		if (obj == null) {
			createUser(resource, model);
			obj = (UserImpl)getUser(resource, model);
			obj.initAsLastUser();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of User for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#User
	 * @param model the Jena Model
	 * @return a List of User
	 */
	public static java.util.List getAllUser(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,User.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getUser(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of UserBehaviour.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the UserBehaviour
	 * @param model the Jena Model.
	 */
	public static UserBehaviour createUserBehaviour(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.UserBehaviourImpl.createUserBehaviour(resource,model);
	}
	
	/**
	 * Create a new instance of UserBehaviour.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the UserBehaviour
	 * @param model the Jena Model.
	 */
	public static UserBehaviour createUserBehaviour(String uri, Model model) throws JastorException {
		UserBehaviour obj = ibspan.tss.um.ontology.UserBehaviourImpl.createUserBehaviour(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of UserBehaviour.  Leaves the model unchanged.
	 * @param uri The uri of the UserBehaviour
	 * @param model the Jena Model.
	 */
	public static UserBehaviour getUserBehaviour(String uri, Model model) throws JastorException {
		return getUserBehaviour(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of UserBehaviour.  Leaves the model unchanged.
	 * @param resource The resource of the UserBehaviour
	 * @param model the Jena Model.
	 */
	public static UserBehaviour getUserBehaviour(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.UserBehaviour.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.UserBehaviourImpl obj = (ibspan.tss.um.ontology.UserBehaviourImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.UserBehaviourImpl.getUserBehaviour(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an ExitSearchingBehaviour individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of UserBehaviour.
	 */
	public static UserBehaviour getExitSearchingBehaviour(Model model) throws JastorException {
		Resource resource = model.createResource(UserBehaviour.ExitSearchingBehaviour.getURI());
		UserBehaviourImpl obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
		if (obj == null) {
			createUserBehaviour(resource, model);
			obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
			obj.initAsExitSearchingBehaviour();			
		}
		return obj;
	}
	/** 
	 * Get an QueryForRestaurantBehaviour individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of UserBehaviour.
	 */
	public static UserBehaviour getQueryForRestaurantBehaviour(Model model) throws JastorException {
		Resource resource = model.createResource(UserBehaviour.QueryForRestaurantBehaviour.getURI());
		UserBehaviourImpl obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
		if (obj == null) {
			createUserBehaviour(resource, model);
			obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
			obj.initAsQueryForRestaurantBehaviour();			
		}
		return obj;
	}
	/** 
	 * Get an ClickForRestaurantDetailsBehaviour individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of UserBehaviour.
	 */
	public static UserBehaviour getClickForRestaurantDetailsBehaviour(Model model) throws JastorException {
		Resource resource = model.createResource(UserBehaviour.ClickForRestaurantDetailsBehaviour.getURI());
		UserBehaviourImpl obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
		if (obj == null) {
			createUserBehaviour(resource, model);
			obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
			obj.initAsClickForRestaurantDetailsBehaviour();			
		}
		return obj;
	}
	/** 
	 * Get an RateRestaurantPositiveBehaviour individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of UserBehaviour.
	 */
	public static UserBehaviour getRateRestaurantPositiveBehaviour(Model model) throws JastorException {
		Resource resource = model.createResource(UserBehaviour.RateRestaurantPositiveBehaviour.getURI());
		UserBehaviourImpl obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
		if (obj == null) {
			createUserBehaviour(resource, model);
			obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
			obj.initAsRateRestaurantPositiveBehaviour();			
		}
		return obj;
	}
	/** 
	 * Get an EntrySearchingBehaviour individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of UserBehaviour.
	 */
	public static UserBehaviour getEntrySearchingBehaviour(Model model) throws JastorException {
		Resource resource = model.createResource(UserBehaviour.EntrySearchingBehaviour.getURI());
		UserBehaviourImpl obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
		if (obj == null) {
			createUserBehaviour(resource, model);
			obj = (UserBehaviourImpl)getUserBehaviour(resource, model);
			obj.initAsEntrySearchingBehaviour();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of UserBehaviour for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviour
	 * @param model the Jena Model
	 * @return a List of UserBehaviour
	 */
	public static java.util.List getAllUserBehaviour(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,UserBehaviour.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getUserBehaviour(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of OrdinalSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the OrdinalSet
	 * @param model the Jena Model.
	 */
	public static OrdinalSet createOrdinalSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.OrdinalSetImpl.createOrdinalSet(resource,model);
	}
	
	/**
	 * Create a new instance of OrdinalSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the OrdinalSet
	 * @param model the Jena Model.
	 */
	public static OrdinalSet createOrdinalSet(String uri, Model model) throws JastorException {
		OrdinalSet obj = ibspan.tss.um.ontology.OrdinalSetImpl.createOrdinalSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of OrdinalSet.  Leaves the model unchanged.
	 * @param uri The uri of the OrdinalSet
	 * @param model the Jena Model.
	 */
	public static OrdinalSet getOrdinalSet(String uri, Model model) throws JastorException {
		return getOrdinalSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of OrdinalSet.  Leaves the model unchanged.
	 * @param resource The resource of the OrdinalSet
	 * @param model the Jena Model.
	 */
	public static OrdinalSet getOrdinalSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.OrdinalSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.OrdinalSetImpl obj = (ibspan.tss.um.ontology.OrdinalSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.OrdinalSetImpl.getOrdinalSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of OrdinalSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#OrdinalSet
	 * @param model the Jena Model
	 * @return a List of OrdinalSet
	 */
	public static java.util.List getAllOrdinalSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,OrdinalSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getOrdinalSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Wealth.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Wealth
	 * @param model the Jena Model.
	 */
	public static Wealth createWealth(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.WealthImpl.createWealth(resource,model);
	}
	
	/**
	 * Create a new instance of Wealth.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Wealth
	 * @param model the Jena Model.
	 */
	public static Wealth createWealth(String uri, Model model) throws JastorException {
		Wealth obj = ibspan.tss.um.ontology.WealthImpl.createWealth(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Wealth.  Leaves the model unchanged.
	 * @param uri The uri of the Wealth
	 * @param model the Jena Model.
	 */
	public static Wealth getWealth(String uri, Model model) throws JastorException {
		return getWealth(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Wealth.  Leaves the model unchanged.
	 * @param resource The resource of the Wealth
	 * @param model the Jena Model.
	 */
	public static Wealth getWealth(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Wealth.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.WealthImpl obj = (ibspan.tss.um.ontology.WealthImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.WealthImpl.getWealth(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an AverageRich individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Wealth.
	 */
	public static Wealth getAverageRich(Model model) throws JastorException {
		Resource resource = model.createResource(Wealth.AverageRich.getURI());
		WealthImpl obj = (WealthImpl)getWealth(resource, model);
		if (obj == null) {
			createWealth(resource, model);
			obj = (WealthImpl)getWealth(resource, model);
			obj.initAsAverageRich();			
		}
		return obj;
	}
	/** 
	 * Get an VeryRich individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Wealth.
	 */
	public static Wealth getVeryRich(Model model) throws JastorException {
		Resource resource = model.createResource(Wealth.VeryRich.getURI());
		WealthImpl obj = (WealthImpl)getWealth(resource, model);
		if (obj == null) {
			createWealth(resource, model);
			obj = (WealthImpl)getWealth(resource, model);
			obj.initAsVeryRich();			
		}
		return obj;
	}
	/** 
	 * Get an Rich individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Wealth.
	 */
	public static Wealth getRich(Model model) throws JastorException {
		Resource resource = model.createResource(Wealth.Rich.getURI());
		WealthImpl obj = (WealthImpl)getWealth(resource, model);
		if (obj == null) {
			createWealth(resource, model);
			obj = (WealthImpl)getWealth(resource, model);
			obj.initAsRich();			
		}
		return obj;
	}
	/** 
	 * Get an NotRich individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Wealth.
	 */
	public static Wealth getNotRich(Model model) throws JastorException {
		Resource resource = model.createResource(Wealth.NotRich.getURI());
		WealthImpl obj = (WealthImpl)getWealth(resource, model);
		if (obj == null) {
			createWealth(resource, model);
			obj = (WealthImpl)getWealth(resource, model);
			obj.initAsNotRich();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Wealth for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Wealth
	 * @param model the Jena Model
	 * @return a List of Wealth
	 */
	public static java.util.List getAllWealth(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Wealth.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getWealth(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of DressSet.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the DressSet
	 * @param model the Jena Model.
	 */
	public static DressSet createDressSet(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.DressSetImpl.createDressSet(resource,model);
	}
	
	/**
	 * Create a new instance of DressSet.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the DressSet
	 * @param model the Jena Model.
	 */
	public static DressSet createDressSet(String uri, Model model) throws JastorException {
		DressSet obj = ibspan.tss.um.ontology.DressSetImpl.createDressSet(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of DressSet.  Leaves the model unchanged.
	 * @param uri The uri of the DressSet
	 * @param model the Jena Model.
	 */
	public static DressSet getDressSet(String uri, Model model) throws JastorException {
		return getDressSet(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of DressSet.  Leaves the model unchanged.
	 * @param resource The resource of the DressSet
	 * @param model the Jena Model.
	 */
	public static DressSet getDressSet(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.DressSet.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.DressSetImpl obj = (ibspan.tss.um.ontology.DressSetImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.DressSetImpl.getDressSet(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of DressSet for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#DressSet
	 * @param model the Jena Model
	 * @return a List of DressSet
	 */
	public static java.util.List getAllDressSet(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,DressSet.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getDressSet(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of MeasureDomain.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the MeasureDomain
	 * @param model the Jena Model.
	 */
	public static MeasureDomain createMeasureDomain(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.MeasureDomainImpl.createMeasureDomain(resource,model);
	}
	
	/**
	 * Create a new instance of MeasureDomain.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the MeasureDomain
	 * @param model the Jena Model.
	 */
	public static MeasureDomain createMeasureDomain(String uri, Model model) throws JastorException {
		MeasureDomain obj = ibspan.tss.um.ontology.MeasureDomainImpl.createMeasureDomain(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of MeasureDomain.  Leaves the model unchanged.
	 * @param uri The uri of the MeasureDomain
	 * @param model the Jena Model.
	 */
	public static MeasureDomain getMeasureDomain(String uri, Model model) throws JastorException {
		return getMeasureDomain(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of MeasureDomain.  Leaves the model unchanged.
	 * @param resource The resource of the MeasureDomain
	 * @param model the Jena Model.
	 */
	public static MeasureDomain getMeasureDomain(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.MeasureDomain.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.MeasureDomainImpl obj = (ibspan.tss.um.ontology.MeasureDomainImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.MeasureDomainImpl.getMeasureDomain(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of MeasureDomain for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#MeasureDomain
	 * @param model the Jena Model
	 * @return a List of MeasureDomain
	 */
	public static java.util.List getAllMeasureDomain(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,MeasureDomain.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getMeasureDomain(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of UserProfileData.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the UserProfileData
	 * @param model the Jena Model.
	 */
	public static UserProfileData createUserProfileData(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.UserProfileDataImpl.createUserProfileData(resource,model);
	}
	
	/**
	 * Create a new instance of UserProfileData.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the UserProfileData
	 * @param model the Jena Model.
	 */
	public static UserProfileData createUserProfileData(String uri, Model model) throws JastorException {
		UserProfileData obj = ibspan.tss.um.ontology.UserProfileDataImpl.createUserProfileData(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of UserProfileData.  Leaves the model unchanged.
	 * @param uri The uri of the UserProfileData
	 * @param model the Jena Model.
	 */
	public static UserProfileData getUserProfileData(String uri, Model model) throws JastorException {
		return getUserProfileData(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of UserProfileData.  Leaves the model unchanged.
	 * @param resource The resource of the UserProfileData
	 * @param model the Jena Model.
	 */
	public static UserProfileData getUserProfileData(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.UserProfileData.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.UserProfileDataImpl obj = (ibspan.tss.um.ontology.UserProfileDataImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.UserProfileDataImpl.getUserProfileData(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of UserProfileData for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#UserProfileData
	 * @param model the Jena Model
	 * @return a List of UserProfileData
	 */
	public static java.util.List getAllUserProfileData(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,UserProfileData.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getUserProfileData(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of StatisticEntry.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the StatisticEntry
	 * @param model the Jena Model.
	 */
	public static StatisticEntry createStatisticEntry(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.StatisticEntryImpl.createStatisticEntry(resource,model);
	}
	
	/**
	 * Create a new instance of StatisticEntry.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the StatisticEntry
	 * @param model the Jena Model.
	 */
	public static StatisticEntry createStatisticEntry(String uri, Model model) throws JastorException {
		StatisticEntry obj = ibspan.tss.um.ontology.StatisticEntryImpl.createStatisticEntry(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of StatisticEntry.  Leaves the model unchanged.
	 * @param uri The uri of the StatisticEntry
	 * @param model the Jena Model.
	 */
	public static StatisticEntry getStatisticEntry(String uri, Model model) throws JastorException {
		return getStatisticEntry(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of StatisticEntry.  Leaves the model unchanged.
	 * @param resource The resource of the StatisticEntry
	 * @param model the Jena Model.
	 */
	public static StatisticEntry getStatisticEntry(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.StatisticEntry.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.StatisticEntryImpl obj = (ibspan.tss.um.ontology.StatisticEntryImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.StatisticEntryImpl.getStatisticEntry(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of StatisticEntry for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#StatisticEntry
	 * @param model the Jena Model
	 * @return a List of StatisticEntry
	 */
	public static java.util.List getAllStatisticEntry(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,StatisticEntry.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getStatisticEntry(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Profession.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Profession
	 * @param model the Jena Model.
	 */
	public static Profession createProfession(Resource resource, Model model) throws JastorException {
		return ibspan.tss.um.ontology.ProfessionImpl.createProfession(resource,model);
	}
	
	/**
	 * Create a new instance of Profession.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Profession
	 * @param model the Jena Model.
	 */
	public static Profession createProfession(String uri, Model model) throws JastorException {
		Profession obj = ibspan.tss.um.ontology.ProfessionImpl.createProfession(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Profession.  Leaves the model unchanged.
	 * @param uri The uri of the Profession
	 * @param model the Jena Model.
	 */
	public static Profession getProfession(String uri, Model model) throws JastorException {
		return getProfession(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Profession.  Leaves the model unchanged.
	 * @param resource The resource of the Profession
	 * @param model the Jena Model.
	 */
	public static Profession getProfession(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.um.ontology.Profession.class.hashCode()) + resource.toString();
		ibspan.tss.um.ontology.ProfessionImpl obj = (ibspan.tss.um.ontology.ProfessionImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.um.ontology.ProfessionImpl.getProfession(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an PensionerAnnuitant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getPensionerAnnuitant(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.PensionerAnnuitant.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsPensionerAnnuitant();			
		}
		return obj;
	}
	/** 
	 * Get an StudentPupil individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getStudentPupil(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.StudentPupil.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsStudentPupil();			
		}
		return obj;
	}
	/** 
	 * Get an Handworker individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getHandworker(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.Handworker.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsHandworker();			
		}
		return obj;
	}
	/** 
	 * Get an AdvertisingMarketingWorker individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getAdvertisingMarketingWorker(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.AdvertisingMarketingWorker.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsAdvertisingMarketingWorker();			
		}
		return obj;
	}
	/** 
	 * Get an UnemployedJobSeeker individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getUnemployedJobSeeker(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.UnemployedJobSeeker.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsUnemployedJobSeeker();			
		}
		return obj;
	}
	/** 
	 * Get an ManagerDirector individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getManagerDirector(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.ManagerDirector.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsManagerDirector();			
		}
		return obj;
	}
	/** 
	 * Get an OtherProfession individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getOtherProfession(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.OtherProfession.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsOtherProfession();			
		}
		return obj;
	}
	/** 
	 * Get an ScientistTeacher individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getScientistTeacher(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.ScientistTeacher.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsScientistTeacher();			
		}
		return obj;
	}
	/** 
	 * Get an ServicesTradeWorker individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getServicesTradeWorker(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.ServicesTradeWorker.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsServicesTradeWorker();			
		}
		return obj;
	}
	/** 
	 * Get an SpecialistFreeLancer individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Profession.
	 */
	public static Profession getSpecialistFreeLancer(Model model) throws JastorException {
		Resource resource = model.createResource(Profession.SpecialistFreeLancer.getURI());
		ProfessionImpl obj = (ProfessionImpl)getProfession(resource, model);
		if (obj == null) {
			createProfession(resource, model);
			obj = (ProfessionImpl)getProfession(resource, model);
			obj.initAsSpecialistFreeLancer();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Profession for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/UserModelling#Profession
	 * @param model the Jena Model
	 * @return a List of Profession
	 */
	public static java.util.List getAllProfession(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Profession.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getProfession(stmt.getSubject(),model));
		}
		return list;
	}
	
	
	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(com.hp.hpl.jena.rdf.model.Resource res, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Profession"))) {
			return getProfession(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Nominal"))) {
			return getNominal(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#StatisticEntry"))) {
			return getStatisticEntry(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#UserProfileData"))) {
			return getUserProfileData(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#DressSet"))) {
			return getDressSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Wealth"))) {
			return getWealth(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviour"))) {
			return getUserBehaviour(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#User"))) {
			return getUser(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Event"))) {
			return getEvent(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Dress"))) {
			return getDress(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Ordinal"))) {
			return getOrdinal(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#ContextParameter"))) {
			return getContextParameter(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#RatedResult"))) {
			return getRatedResult(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#WealthSet"))) {
			return getWealthSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#OrdinalSet"))) {
			return getOrdinalSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#EventSession"))) {
			return getEventSession(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfile"))) {
			return getStereotypeProfile(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#UserProfile"))) {
			return getUserProfile(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Profile"))) {
			return getProfile(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#ProfessionSet"))) {
			return getProfessionSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#NominalSet"))) {
			return getNominalSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#AgeSet"))) {
			return getAgeSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#IntervalSet"))) {
			return getIntervalSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#MeasureSet"))) {
			return getMeasureSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfileData"))) {
			return getStereotypeProfileData(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#ProfileData"))) {
			return getProfileData(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Classification"))) {
			return getClassification(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Opinion"))) {
			return getOpinion(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviourContext"))) {
			return getUserBehaviourContext(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Age"))) {
			return getAge(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Interval"))) {
			return getInterval(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Measure"))) {
			return getMeasure(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#Parameter"))) {
			return getParameter(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#OpinionSet"))) {
			return getOpinionSet(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#IntervalDomain"))) {
			return getIntervalDomain(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#MeasureDomain"))) {
			return getMeasureDomain(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/UserModelling#ExtendedUserBehaviour"))) {
			return getExtendedUserBehaviour(res,model);
		}
		return new ThingImpl(res,model);
	}
	
	/**
	 * Returns an instance of an interface for the given Resource URI.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(String uri, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		return getThing(model.getResource(uri),model);
	}

	/**
	 * Return a list of compatible interfaces for the given type.  Searches through all ontology classes
	 * in the UserModelling ontology.  The list is sorted according to the topological sort
	 * of the class hierarchy
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List listCompatibleInterfaces (com.hp.hpl.jena.rdf.model.Resource type) {
		java.util.List types = new java.util.ArrayList();
		if (type.equals(ibspan.tss.um.ontology.Profession.TYPE)) {
			types.add(ibspan.tss.um.ontology.Profession.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Nominal.TYPE)) {
			types.add(ibspan.tss.um.ontology.Nominal.class);
		}
		if (type.equals(ibspan.tss.um.ontology.StatisticEntry.TYPE)) {
			types.add(ibspan.tss.um.ontology.StatisticEntry.class);
		}
		if (type.equals(ibspan.tss.um.ontology.UserProfileData.TYPE)) {
			types.add(ibspan.tss.um.ontology.UserProfileData.class);
		}
		if (type.equals(ibspan.tss.um.ontology.DressSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.DressSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Wealth.TYPE)) {
			types.add(ibspan.tss.um.ontology.Wealth.class);
		}
		if (type.equals(ibspan.tss.um.ontology.UserBehaviour.TYPE)) {
			types.add(ibspan.tss.um.ontology.UserBehaviour.class);
		}
		if (type.equals(ibspan.tss.um.ontology.User.TYPE)) {
			types.add(ibspan.tss.um.ontology.User.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Event.TYPE)) {
			types.add(ibspan.tss.um.ontology.Event.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Dress.TYPE)) {
			types.add(ibspan.tss.um.ontology.Dress.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Ordinal.TYPE)) {
			types.add(ibspan.tss.um.ontology.Ordinal.class);
		}
		if (type.equals(ibspan.tss.um.ontology.ContextParameter.TYPE)) {
			types.add(ibspan.tss.um.ontology.ContextParameter.class);
		}
		if (type.equals(ibspan.tss.um.ontology.RatedResult.TYPE)) {
			types.add(ibspan.tss.um.ontology.RatedResult.class);
		}
		if (type.equals(ibspan.tss.um.ontology.WealthSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.WealthSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.OrdinalSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.OrdinalSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.EventSession.TYPE)) {
			types.add(ibspan.tss.um.ontology.EventSession.class);
		}
		if (type.equals(ibspan.tss.um.ontology.StereotypeProfile.TYPE)) {
			types.add(ibspan.tss.um.ontology.StereotypeProfile.class);
		}
		if (type.equals(ibspan.tss.um.ontology.UserProfile.TYPE)) {
			types.add(ibspan.tss.um.ontology.UserProfile.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Profile.TYPE)) {
			types.add(ibspan.tss.um.ontology.Profile.class);
		}
		if (type.equals(ibspan.tss.um.ontology.ProfessionSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.ProfessionSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.NominalSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.NominalSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.AgeSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.AgeSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.IntervalSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.IntervalSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.MeasureSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.MeasureSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.StereotypeProfileData.TYPE)) {
			types.add(ibspan.tss.um.ontology.StereotypeProfileData.class);
		}
		if (type.equals(ibspan.tss.um.ontology.ProfileData.TYPE)) {
			types.add(ibspan.tss.um.ontology.ProfileData.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Classification.TYPE)) {
			types.add(ibspan.tss.um.ontology.Classification.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Opinion.TYPE)) {
			types.add(ibspan.tss.um.ontology.Opinion.class);
		}
		if (type.equals(ibspan.tss.um.ontology.UserBehaviourContext.TYPE)) {
			types.add(ibspan.tss.um.ontology.UserBehaviourContext.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Age.TYPE)) {
			types.add(ibspan.tss.um.ontology.Age.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Interval.TYPE)) {
			types.add(ibspan.tss.um.ontology.Interval.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Measure.TYPE)) {
			types.add(ibspan.tss.um.ontology.Measure.class);
		}
		if (type.equals(ibspan.tss.um.ontology.Parameter.TYPE)) {
			types.add(ibspan.tss.um.ontology.Parameter.class);
		}
		if (type.equals(ibspan.tss.um.ontology.OpinionSet.TYPE)) {
			types.add(ibspan.tss.um.ontology.OpinionSet.class);
		}
		if (type.equals(ibspan.tss.um.ontology.IntervalDomain.TYPE)) {
			types.add(ibspan.tss.um.ontology.IntervalDomain.class);
		}
		if (type.equals(ibspan.tss.um.ontology.MeasureDomain.TYPE)) {
			types.add(ibspan.tss.um.ontology.MeasureDomain.class);
		}
		if (type.equals(ibspan.tss.um.ontology.ExtendedUserBehaviour.TYPE)) {
			types.add(ibspan.tss.um.ontology.ExtendedUserBehaviour.class);
		}
		return types;
	}
}