

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for EventSession ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#EventSession)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Gathers a set of Events in single session with authorized (logged in) user.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface EventSession extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#EventSession");
	

	/**
	 * The Jena Property for hasEvent 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasEvent)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Points the event belonging to this session.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasEventProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasEvent");


	/**
	 * The Jena Property for startedAt 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#startedAt)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Describes when the session started.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property startedAtProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#startedAt");


	/**
	 * The Jena Property for hasSessionID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasSessionID)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Unique ID of the Session.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasSessionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasSessionID");


	/**
	 * The Jena Property for hasUserID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasUserID)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Unique ID of a user^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");






	/**
	 * Get an Iterator the 'hasEvent' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.um.ontology.Event}
	 * @see			#hasEventProperty
	 */
	public java.util.Iterator getHasEvent() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'hasEvent' property
	 * @param		The {@link ibspan.tss.um.ontology.Event} to add
	 * @see			#hasEventProperty
	 */
	public void addHasEvent(ibspan.tss.um.ontology.Event hasEvent) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'hasEvent' property
	 * @return		The anoymous {@link ibspan.tss.um.ontology.Event} created
	 * @see			#hasEventProperty
	 */
	public ibspan.tss.um.ontology.Event addHasEvent() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'hasEvent' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Event} with the factory
	 * and calling addHasEvent(ibspan.tss.um.ontology.Event hasEvent)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Event.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#hasEventProperty
	 */
	public ibspan.tss.um.ontology.Event addHasEvent(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'hasEvent' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.um.ontology.Event} to remove
	 * @see			#hasEventProperty
	 */
	public void removeHasEvent(ibspan.tss.um.ontology.Event hasEvent) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'startedAt' property value
	 * @return		{@link com.hp.hpl.jena.datatypes.xsd.XSDDateTime}
	 * @see			#startedAtProperty
	 */
	public com.hp.hpl.jena.datatypes.xsd.XSDDateTime getStartedAt() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'startedAt' property value
	 * @param		{@link com.hp.hpl.jena.datatypes.xsd.XSDDateTime}
	 * @see			#startedAtProperty
	 */
	public void setStartedAt(com.hp.hpl.jena.datatypes.xsd.XSDDateTime startedAt) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasSessionID' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasSessionIDProperty
	 */
	public java.lang.String getHasSessionID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasSessionID' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasSessionIDProperty
	 */
	public void setHasSessionID(java.lang.String hasSessionID) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasUserID' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasUserIDProperty
	 */
	public java.lang.Integer getHasUserID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasUserID' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasUserIDProperty
	 */
	public void setHasUserID(java.lang.Integer hasUserID) throws com.ibm.adtech.jastor.JastorException;

}