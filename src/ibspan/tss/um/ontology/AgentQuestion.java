

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for AgentQuestion ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#AgentQuestion)</p>
 * <br>
 * <br>
 * <br>
 */
public interface AgentQuestion extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#AgentQuestion");
	

	/**
	 * The Jena Property for hasLongMessage 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasLongMessage)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasLongMessageProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasLongMessage");


	/**
	 * The Jena Property for hasQuestionID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasQuestionID)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasQuestionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasQuestionID");


	/**
	 * The Jena Property for hasShortMessage 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasShortMessage)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasShortMessageProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasShortMessage");


	/**
	 * The Jena Property for hasScenarioActionName 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasScenarioActionName)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasScenarioActionNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasScenarioActionName");


	/**
	 * The Jena Property for hasUserID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasUserID)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");






	/**
	 * Gets the 'hasLongMessage' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasLongMessageProperty
	 */
	public java.lang.String getHasLongMessage() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasLongMessage' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasLongMessageProperty
	 */
	public void setHasLongMessage(java.lang.String hasLongMessage) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasQuestionID' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasQuestionIDProperty
	 */
	public java.lang.Integer getHasQuestionID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasQuestionID' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasQuestionIDProperty
	 */
	public void setHasQuestionID(java.lang.Integer hasQuestionID) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasShortMessage' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasShortMessageProperty
	 */
	public java.lang.String getHasShortMessage() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasShortMessage' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasShortMessageProperty
	 */
	public void setHasShortMessage(java.lang.String hasShortMessage) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasScenarioActionName' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasScenarioActionNameProperty
	 */
	public java.lang.String getHasScenarioActionName() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasScenarioActionName' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasScenarioActionNameProperty
	 */
	public void setHasScenarioActionName(java.lang.String hasScenarioActionName) throws com.ibm.adtech.jastor.JastorException;

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