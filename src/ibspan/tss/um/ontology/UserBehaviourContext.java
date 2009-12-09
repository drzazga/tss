

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for UserBehaviourContext ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviourContext)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Represents the context of perfomed user behaviour, such as chosen constrainst in search query or URI address of clicked object.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface UserBehaviourContext extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviourContext");
	

	/**
	 * The Jena Property for hasParameter 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasParameter)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasParameterProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasParameter");






	/**
	 * Get an Iterator the 'hasParameter' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.um.ontology.ContextParameter}
	 * @see			#hasParameterProperty
	 */
	public java.util.Iterator getHasParameter() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'hasParameter' property
	 * @param		The {@link ibspan.tss.um.ontology.ContextParameter} to add
	 * @see			#hasParameterProperty
	 */
	public void addHasParameter(ibspan.tss.um.ontology.ContextParameter hasParameter) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'hasParameter' property
	 * @return		The anoymous {@link ibspan.tss.um.ontology.ContextParameter} created
	 * @see			#hasParameterProperty
	 */
	public ibspan.tss.um.ontology.ContextParameter addHasParameter() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'hasParameter' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.ContextParameter} with the factory
	 * and calling addHasParameter(ibspan.tss.um.ontology.ContextParameter hasParameter)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#ContextParameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#hasParameterProperty
	 */
	public ibspan.tss.um.ontology.ContextParameter addHasParameter(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'hasParameter' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.um.ontology.ContextParameter} to remove
	 * @see			#hasParameterProperty
	 */
	public void removeHasParameter(ibspan.tss.um.ontology.ContextParameter hasParameter) throws com.ibm.adtech.jastor.JastorException;
		
}