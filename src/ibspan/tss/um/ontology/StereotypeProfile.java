

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for StereotypeProfile ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfile)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Profile of a stereotype.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface StereotypeProfile extends ibspan.tss.um.ontology.Profile, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfile");
	

	/**
	 * The Jena Property for hasStereotypeData 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasStereotypeData)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasStereotypeDataProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasStereotypeData");


	/**
	 * The Jena Property for hasStereotypeID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasStereotypeID)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasStereotypeIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasStereotypeID");






	/**
	 * Gets the 'hasStereotypeData' property value
	 * @return		{@link ibspan.tss.um.ontology.StereotypeProfileData}
	 * @see			#hasStereotypeDataProperty
	 */
	public ibspan.tss.um.ontology.StereotypeProfileData getHasStereotypeData() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasStereotypeData' property value
	 * @param		{@link ibspan.tss.um.ontology.StereotypeProfileData}
	 * @see			#hasStereotypeDataProperty
	 */
	public void setHasStereotypeData(ibspan.tss.um.ontology.StereotypeProfileData hasStereotypeData) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasStereotypeData' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.StereotypeProfileData}, the created value
	 * @see			#hasStereotypeDataProperty
	 */	
	public ibspan.tss.um.ontology.StereotypeProfileData setHasStereotypeData() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasStereotypeData' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.StereotypeProfileData} with the factory.
	 * and calling setHasStereotypeData(ibspan.tss.um.ontology.StereotypeProfileData hasStereotypeData)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfileData.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.StereotypeProfileData}, the newly created value
	 * @see			#hasStereotypeDataProperty
	 */
	public ibspan.tss.um.ontology.StereotypeProfileData setHasStereotypeData(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasStereotypeID' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasStereotypeIDProperty
	 */
	public java.lang.Integer getHasStereotypeID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasStereotypeID' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasStereotypeIDProperty
	 */
	public void setHasStereotypeID(java.lang.Integer hasStereotypeID) throws com.ibm.adtech.jastor.JastorException;

}