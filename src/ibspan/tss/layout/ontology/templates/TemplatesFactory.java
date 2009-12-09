

package ibspan.tss.layout.ontology.templates;

import com.ibm.adtech.jastor.*;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Factory for instantiating objects for ontology classes in the Templates ontology.  The
 * get methods leave the model unchanged and return a Java view of the object in the model.  The create methods
 * may add certain baseline properties to the model such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.ibspan.waw.pl/tss/db/Templates)</p>
 * <br>
 * <br>
 * Dublin Core Standard Properties <br>
 * 	creator : ^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 */
public class TemplatesFactory extends com.ibm.adtech.jastor.ThingFactory { 



	/**
	 * Create a new instance of DummyClass.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the DummyClass
	 * @param model the Jena Model.
	 */
	public static DummyClass createDummyClass(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.templates.DummyClassImpl.createDummyClass(resource,model);
	}
	
	/**
	 * Create a new instance of DummyClass.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the DummyClass
	 * @param model the Jena Model.
	 */
	public static DummyClass createDummyClass(String uri, Model model) throws JastorException {
		DummyClass obj = ibspan.tss.layout.ontology.templates.DummyClassImpl.createDummyClass(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of DummyClass.  Leaves the model unchanged.
	 * @param uri The uri of the DummyClass
	 * @param model the Jena Model.
	 */
	public static DummyClass getDummyClass(String uri, Model model) throws JastorException {
		return getDummyClass(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of DummyClass.  Leaves the model unchanged.
	 * @param resource The resource of the DummyClass
	 * @param model the Jena Model.
	 */
	public static DummyClass getDummyClass(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.templates.DummyClass.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.templates.DummyClassImpl obj = (ibspan.tss.layout.ontology.templates.DummyClassImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.templates.DummyClassImpl.getDummyClass(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of DummyClass for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/db/Templates#DummyClass
	 * @param model the Jena Model
	 * @return a List of DummyClass
	 */
	public static java.util.List getAllDummyClass(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,DummyClass.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getDummyClass(stmt.getSubject(),model));
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
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/db/Templates#DummyClass"))) {
			return getDummyClass(res,model);
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
	 * in the Templates ontology.  The list is sorted according to the topological sort
	 * of the class hierarchy
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List listCompatibleInterfaces (com.hp.hpl.jena.rdf.model.Resource type) {
		java.util.List types = new java.util.ArrayList();
		if (type.equals(ibspan.tss.layout.ontology.templates.DummyClass.TYPE)) {
			types.add(ibspan.tss.layout.ontology.templates.DummyClass.class);
		}
		return types;
	}
}