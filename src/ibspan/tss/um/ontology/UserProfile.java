

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for UserProfile ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserProfile)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Profile of a user.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface UserProfile extends ibspan.tss.um.ontology.Profile, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#UserProfile");
	

	/**
	 * The Jena Property for hasUserProfileData 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasUserProfileData)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasUserProfileDataProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserProfileData");


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
	 * Gets the 'hasUserProfileData' property value
	 * @return		{@link ibspan.tss.um.ontology.UserProfileData}
	 * @see			#hasUserProfileDataProperty
	 */
	public ibspan.tss.um.ontology.UserProfileData getHasUserProfileData() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasUserProfileData' property value
	 * @param		{@link ibspan.tss.um.ontology.UserProfileData}
	 * @see			#hasUserProfileDataProperty
	 */
	public void setHasUserProfileData(ibspan.tss.um.ontology.UserProfileData hasUserProfileData) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasUserProfileData' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.UserProfileData}, the created value
	 * @see			#hasUserProfileDataProperty
	 */	
	public ibspan.tss.um.ontology.UserProfileData setHasUserProfileData() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasUserProfileData' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.UserProfileData} with the factory.
	 * and calling setHasUserProfileData(ibspan.tss.um.ontology.UserProfileData hasUserProfileData)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#UserProfileData.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.UserProfileData}, the newly created value
	 * @see			#hasUserProfileDataProperty
	 */
	public ibspan.tss.um.ontology.UserProfileData setHasUserProfileData(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
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