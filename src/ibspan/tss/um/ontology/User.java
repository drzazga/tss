

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for User ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#User)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Account of a single register user.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface User extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#User");
	

	/**
	 * The Jena Property for hasPassword 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasPassword)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasPasswordProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasPassword");


	/**
	 * The Jena Property for hasLogin 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasLogin)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasLoginProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasLogin");


	/**
	 * The Jena Property for hasName 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasName)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasName");


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
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#LastUser
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LastUser = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#LastUser");





	/**
	 * Gets the 'hasPassword' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasPasswordProperty
	 */
	public java.lang.String getHasPassword() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasPassword' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasPasswordProperty
	 */
	public void setHasPassword(java.lang.String hasPassword) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasLogin' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasLoginProperty
	 */
	public java.lang.String getHasLogin() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasLogin' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasLoginProperty
	 */
	public void setHasLogin(java.lang.String hasLogin) throws com.ibm.adtech.jastor.JastorException;

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