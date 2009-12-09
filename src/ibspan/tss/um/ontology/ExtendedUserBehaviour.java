

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for ExtendedUserBehaviour ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ExtendedUserBehaviour)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes user behaviour together with its context.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface ExtendedUserBehaviour extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ExtendedUserBehaviour");
	

	/**
	 * The Jena Property for hasContext 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasContext)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Points the context of this user behaviou. References to the 'actionParams' concept from Messaging ontology.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasContextProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasContext");


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
	 * Gets the 'hasContext' property value
	 * @return		{@link ibspan.tss.um.ontology.UserBehaviourContext}
	 * @see			#hasContextProperty
	 */
	public ibspan.tss.um.ontology.UserBehaviourContext getHasContext() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasContext' property value
	 * @param		{@link ibspan.tss.um.ontology.UserBehaviourContext}
	 * @see			#hasContextProperty
	 */
	public void setHasContext(ibspan.tss.um.ontology.UserBehaviourContext hasContext) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasContext' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.UserBehaviourContext}, the created value
	 * @see			#hasContextProperty
	 */	
	public ibspan.tss.um.ontology.UserBehaviourContext setHasContext() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasContext' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.UserBehaviourContext} with the factory.
	 * and calling setHasContext(ibspan.tss.um.ontology.UserBehaviourContext hasContext)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviourContext.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.UserBehaviourContext}, the newly created value
	 * @see			#hasContextProperty
	 */
	public ibspan.tss.um.ontology.UserBehaviourContext setHasContext(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
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