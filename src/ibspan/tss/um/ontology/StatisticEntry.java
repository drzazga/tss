

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for StatisticEntry ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StatisticEntry)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes number of events related to the given user(s), who performed given behaviour(s) against given concept(s). If any of mentioned parameters is not pointed out, then this statistics reference events with all possible values of this parameter.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface StatisticEntry extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#StatisticEntry");
	

	/**
	 * The Jena Property for hasConceptURI 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasConceptURI)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasConceptURIProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasConceptURI");


	/**
	 * The Jena Property for hasCount 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasCount)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Number of events following given key parameters.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasCountProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasCount");


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
	 * The Jena Property for hasUserBehaviour 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasUserBehaviour)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Points the type of an action the user performed agains the system.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasUserBehaviourProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserBehaviour");






	/**
	 * Gets the 'hasConceptURI' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasConceptURIProperty
	 */
	public java.lang.String getHasConceptURI() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasConceptURI' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasConceptURIProperty
	 */
	public void setHasConceptURI(java.lang.String hasConceptURI) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasCount' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasCountProperty
	 */
	public java.lang.Integer getHasCount() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasCount' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasCountProperty
	 */
	public void setHasCount(java.lang.Integer hasCount) throws com.ibm.adtech.jastor.JastorException;

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

	/**
	 * Gets the 'hasUserBehaviour' property value
	 * @return		{@link ibspan.tss.um.ontology.UserBehaviour}
	 * @see			#hasUserBehaviourProperty
	 */
	public ibspan.tss.um.ontology.UserBehaviour getHasUserBehaviour() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasUserBehaviour' property value
	 * @param		{@link ibspan.tss.um.ontology.UserBehaviour}
	 * @see			#hasUserBehaviourProperty
	 */
	public void setHasUserBehaviour(ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasUserBehaviour' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.UserBehaviour}, the created value
	 * @see			#hasUserBehaviourProperty
	 */	
	public ibspan.tss.um.ontology.UserBehaviour setHasUserBehaviour() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasUserBehaviour' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.UserBehaviour} with the factory.
	 * and calling setHasUserBehaviour(ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviour.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.UserBehaviour}, the newly created value
	 * @see			#hasUserBehaviourProperty
	 */
	public ibspan.tss.um.ontology.UserBehaviour setHasUserBehaviour(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}