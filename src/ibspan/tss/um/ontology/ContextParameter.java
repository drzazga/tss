

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for ContextParameter ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ContextParameter)</p>
 * <br>
 * <br>
 * <br>
 */
public interface ContextParameter extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ContextParameter");
	

	/**
	 * The Jena Property for hasValue 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasValue)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasValueProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasValue");


	/**
	 * The Jena Property for hasName 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasName)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasName");



	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#TargetURI
	 */
	public static com.hp.hpl.jena.rdf.model.Resource TargetURI = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#TargetURI");





	/**
	 * Gets the 'hasValue' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasValueProperty
	 */
	public java.lang.String getHasValue() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasValue' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasValueProperty
	 */
	public void setHasValue(java.lang.String hasValue) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasName' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasNameProperty
	 */
	public java.lang.String getHasName() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasName' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasNameProperty
	 */
	public void setHasName(java.lang.String hasName) throws com.ibm.adtech.jastor.JastorException;

}