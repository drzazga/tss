

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for UserProfileData ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserProfileData)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes demographic data of single user.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface UserProfileData extends ibspan.tss.um.ontology.ProfileData, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#UserProfileData");
	

	/**
	 * The Jena Property for hasWealth 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasWealth)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasWealthProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasWealth");


	/**
	 * The Jena Property for wasBorn 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#wasBorn)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property wasBornProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#wasBorn");


	/**
	 * The Jena Property for hasDress 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasDress)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasDressProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasDress");


	/**
	 * The Jena Property for hasProfession 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasProfession)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasProfessionProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasProfession");


	/**
	 * The Jena Property for hasAge 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasAge)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasAgeProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasAge");






	/**
	 * Gets the 'hasWealth' property value
	 * @return		{@link ibspan.tss.um.ontology.Wealth}
	 * @see			#hasWealthProperty
	 */
	public ibspan.tss.um.ontology.Wealth getHasWealth() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasWealth' property value
	 * @param		{@link ibspan.tss.um.ontology.Wealth}
	 * @see			#hasWealthProperty
	 */
	public void setHasWealth(ibspan.tss.um.ontology.Wealth hasWealth) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasWealth' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Wealth}, the created value
	 * @see			#hasWealthProperty
	 */	
	public ibspan.tss.um.ontology.Wealth setHasWealth() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasWealth' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Wealth} with the factory.
	 * and calling setHasWealth(ibspan.tss.um.ontology.Wealth hasWealth)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Wealth.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Wealth}, the newly created value
	 * @see			#hasWealthProperty
	 */
	public ibspan.tss.um.ontology.Wealth setHasWealth(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'wasBorn' property value
	 * @return		{@link com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType}
	 * @see			#wasBornProperty
	 */
	public com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType getWasBorn() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'wasBorn' property value
	 * @param		{@link com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType}
	 * @see			#wasBornProperty
	 */
	public void setWasBorn(com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType wasBorn) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasDress' property value
	 * @return		{@link ibspan.tss.um.ontology.Dress}
	 * @see			#hasDressProperty
	 */
	public ibspan.tss.um.ontology.Dress getHasDress() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasDress' property value
	 * @param		{@link ibspan.tss.um.ontology.Dress}
	 * @see			#hasDressProperty
	 */
	public void setHasDress(ibspan.tss.um.ontology.Dress hasDress) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasDress' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Dress}, the created value
	 * @see			#hasDressProperty
	 */	
	public ibspan.tss.um.ontology.Dress setHasDress() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasDress' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Dress} with the factory.
	 * and calling setHasDress(ibspan.tss.um.ontology.Dress hasDress)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Dress.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Dress}, the newly created value
	 * @see			#hasDressProperty
	 */
	public ibspan.tss.um.ontology.Dress setHasDress(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasProfession' property value
	 * @return		{@link ibspan.tss.um.ontology.Profession}
	 * @see			#hasProfessionProperty
	 */
	public ibspan.tss.um.ontology.Profession getHasProfession() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasProfession' property value
	 * @param		{@link ibspan.tss.um.ontology.Profession}
	 * @see			#hasProfessionProperty
	 */
	public void setHasProfession(ibspan.tss.um.ontology.Profession hasProfession) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasProfession' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Profession}, the created value
	 * @see			#hasProfessionProperty
	 */	
	public ibspan.tss.um.ontology.Profession setHasProfession() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasProfession' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Profession} with the factory.
	 * and calling setHasProfession(ibspan.tss.um.ontology.Profession hasProfession)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Profession.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Profession}, the newly created value
	 * @see			#hasProfessionProperty
	 */
	public ibspan.tss.um.ontology.Profession setHasProfession(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasAge' property value
	 * @return		{@link ibspan.tss.um.ontology.Age}
	 * @see			#hasAgeProperty
	 */
	public ibspan.tss.um.ontology.Age getHasAge() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasAge' property value
	 * @param		{@link ibspan.tss.um.ontology.Age}
	 * @see			#hasAgeProperty
	 */
	public void setHasAge(ibspan.tss.um.ontology.Age hasAge) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasAge' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Age}, the created value
	 * @see			#hasAgeProperty
	 */	
	public ibspan.tss.um.ontology.Age setHasAge() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasAge' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Age} with the factory.
	 * and calling setHasAge(ibspan.tss.um.ontology.Age hasAge)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Age.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Age}, the newly created value
	 * @see			#hasAgeProperty
	 */
	public ibspan.tss.um.ontology.Age setHasAge(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}