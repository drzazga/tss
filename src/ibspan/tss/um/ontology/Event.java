

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Event ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Event)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes the way user action is remembered and stored in history database.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Event extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Event");
	

	/**
	 * The Jena Property for hasExtendedUserBehaviour 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasExtendedUserBehaviour)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasExtendedUserBehaviourProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasExtendedUserBehaviour");


	/**
	 * The Jena Property for when 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#when)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Describes when the event happened.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property whenProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#when");


	/**
	 * The Jena Property for hasEventID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasEventID)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Unique ID of the Event.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasEventIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasEventID");


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
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#LastEvent
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LastEvent = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#LastEvent");





	/**
	 * Gets the 'hasExtendedUserBehaviour' property value
	 * @return		{@link ibspan.tss.um.ontology.ExtendedUserBehaviour}
	 * @see			#hasExtendedUserBehaviourProperty
	 */
	public ibspan.tss.um.ontology.ExtendedUserBehaviour getHasExtendedUserBehaviour() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasExtendedUserBehaviour' property value
	 * @param		{@link ibspan.tss.um.ontology.ExtendedUserBehaviour}
	 * @see			#hasExtendedUserBehaviourProperty
	 */
	public void setHasExtendedUserBehaviour(ibspan.tss.um.ontology.ExtendedUserBehaviour hasExtendedUserBehaviour) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasExtendedUserBehaviour' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.ExtendedUserBehaviour}, the created value
	 * @see			#hasExtendedUserBehaviourProperty
	 */	
	public ibspan.tss.um.ontology.ExtendedUserBehaviour setHasExtendedUserBehaviour() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasExtendedUserBehaviour' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.ExtendedUserBehaviour} with the factory.
	 * and calling setHasExtendedUserBehaviour(ibspan.tss.um.ontology.ExtendedUserBehaviour hasExtendedUserBehaviour)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#ExtendedUserBehaviour.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.ExtendedUserBehaviour}, the newly created value
	 * @see			#hasExtendedUserBehaviourProperty
	 */
	public ibspan.tss.um.ontology.ExtendedUserBehaviour setHasExtendedUserBehaviour(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'when' property value
	 * @return		{@link com.hp.hpl.jena.datatypes.xsd.XSDDateTime}
	 * @see			#whenProperty
	 */
	public com.hp.hpl.jena.datatypes.xsd.XSDDateTime getWhen() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'when' property value
	 * @param		{@link com.hp.hpl.jena.datatypes.xsd.XSDDateTime}
	 * @see			#whenProperty
	 */
	public void setWhen(com.hp.hpl.jena.datatypes.xsd.XSDDateTime when) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasEventID' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasEventIDProperty
	 */
	public java.lang.Integer getHasEventID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasEventID' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasEventIDProperty
	 */
	public void setHasEventID(java.lang.Integer hasEventID) throws com.ibm.adtech.jastor.JastorException;

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