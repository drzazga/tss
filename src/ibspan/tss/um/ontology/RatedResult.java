

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for RatedResult ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#RatedResult)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes potential imperatute of interest (rate) for the givenr object.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface RatedResult extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#RatedResult");
	

	/**
	 * The Jena Property for hasTemperature 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasTemperature)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasTemperatureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasTemperature");


	/**
	 * The Jena Property for ofObject 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ofObject)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property ofObjectProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofObject");






	/**
	 * Gets the 'hasTemperature' property value
	 * @return		{@link java.lang.Double}
	 * @see			#hasTemperatureProperty
	 */
	public java.lang.Double getHasTemperature() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasTemperature' property value
	 * @param		{@link java.lang.Double}
	 * @see			#hasTemperatureProperty
	 */
	public void setHasTemperature(java.lang.Double hasTemperature) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'ofObject' property value
	 * @return		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#ofObjectProperty
	 */
	public com.ibm.adtech.jastor.Thing getOfObject() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'ofObject' property value
	 * @param		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#ofObjectProperty
	 */
	public void setOfObject(com.ibm.adtech.jastor.Thing ofObject) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'ofObject' property value to an anonymous node
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the created value
	 * @see			#ofObjectProperty
	 */	
	public com.ibm.adtech.jastor.Thing setOfObject() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'ofObject' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link com.ibm.adtech.jastor.Thing} with the factory.
	 * and calling setOfObject(com.ibm.adtech.jastor.Thing ofObject)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the newly created value
	 * @see			#ofObjectProperty
	 */
	public com.ibm.adtech.jastor.Thing setOfObject(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}