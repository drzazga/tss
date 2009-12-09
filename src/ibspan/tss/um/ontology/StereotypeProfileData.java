

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for StereotypeProfileData ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfileData)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Data of stereotype "extends" data of profile in the same way, as MeasureSet concept "extends" Measure concept.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface StereotypeProfileData extends ibspan.tss.um.ontology.ProfileData, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfileData");
	

	/**
	 * The Jena Property for hasWealthSet 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasWealthSet)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasWealthSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasWealthSet");


	/**
	 * The Jena Property for hasDressSet 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasDressSet)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasDressSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasDressSet");


	/**
	 * The Jena Property for hasProfessionSet 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasProfessionSet)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasProfessionSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasProfessionSet");


	/**
	 * The Jena Property for hasAgeSet 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasAgeSet)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasAgeSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasAgeSet");






	/**
	 * Gets the 'hasWealthSet' property value
	 * @return		{@link ibspan.tss.um.ontology.WealthSet}
	 * @see			#hasWealthSetProperty
	 */
	public ibspan.tss.um.ontology.WealthSet getHasWealthSet() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasWealthSet' property value
	 * @param		{@link ibspan.tss.um.ontology.WealthSet}
	 * @see			#hasWealthSetProperty
	 */
	public void setHasWealthSet(ibspan.tss.um.ontology.WealthSet hasWealthSet) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasWealthSet' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.WealthSet}, the created value
	 * @see			#hasWealthSetProperty
	 */	
	public ibspan.tss.um.ontology.WealthSet setHasWealthSet() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasWealthSet' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.WealthSet} with the factory.
	 * and calling setHasWealthSet(ibspan.tss.um.ontology.WealthSet hasWealthSet)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#WealthSet.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.WealthSet}, the newly created value
	 * @see			#hasWealthSetProperty
	 */
	public ibspan.tss.um.ontology.WealthSet setHasWealthSet(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasDressSet' property value
	 * @return		{@link ibspan.tss.um.ontology.DressSet}
	 * @see			#hasDressSetProperty
	 */
	public ibspan.tss.um.ontology.DressSet getHasDressSet() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasDressSet' property value
	 * @param		{@link ibspan.tss.um.ontology.DressSet}
	 * @see			#hasDressSetProperty
	 */
	public void setHasDressSet(ibspan.tss.um.ontology.DressSet hasDressSet) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasDressSet' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.DressSet}, the created value
	 * @see			#hasDressSetProperty
	 */	
	public ibspan.tss.um.ontology.DressSet setHasDressSet() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasDressSet' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.DressSet} with the factory.
	 * and calling setHasDressSet(ibspan.tss.um.ontology.DressSet hasDressSet)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#DressSet.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.DressSet}, the newly created value
	 * @see			#hasDressSetProperty
	 */
	public ibspan.tss.um.ontology.DressSet setHasDressSet(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasProfessionSet' property value
	 * @return		{@link ibspan.tss.um.ontology.ProfessionSet}
	 * @see			#hasProfessionSetProperty
	 */
	public ibspan.tss.um.ontology.ProfessionSet getHasProfessionSet() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasProfessionSet' property value
	 * @param		{@link ibspan.tss.um.ontology.ProfessionSet}
	 * @see			#hasProfessionSetProperty
	 */
	public void setHasProfessionSet(ibspan.tss.um.ontology.ProfessionSet hasProfessionSet) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasProfessionSet' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.ProfessionSet}, the created value
	 * @see			#hasProfessionSetProperty
	 */	
	public ibspan.tss.um.ontology.ProfessionSet setHasProfessionSet() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasProfessionSet' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.ProfessionSet} with the factory.
	 * and calling setHasProfessionSet(ibspan.tss.um.ontology.ProfessionSet hasProfessionSet)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#ProfessionSet.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.ProfessionSet}, the newly created value
	 * @see			#hasProfessionSetProperty
	 */
	public ibspan.tss.um.ontology.ProfessionSet setHasProfessionSet(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasAgeSet' property value
	 * @return		{@link ibspan.tss.um.ontology.AgeSet}
	 * @see			#hasAgeSetProperty
	 */
	public ibspan.tss.um.ontology.AgeSet getHasAgeSet() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasAgeSet' property value
	 * @param		{@link ibspan.tss.um.ontology.AgeSet}
	 * @see			#hasAgeSetProperty
	 */
	public void setHasAgeSet(ibspan.tss.um.ontology.AgeSet hasAgeSet) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasAgeSet' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.AgeSet}, the created value
	 * @see			#hasAgeSetProperty
	 */	
	public ibspan.tss.um.ontology.AgeSet setHasAgeSet() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasAgeSet' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.AgeSet} with the factory.
	 * and calling setHasAgeSet(ibspan.tss.um.ontology.AgeSet hasAgeSet)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#AgeSet.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.AgeSet}, the newly created value
	 * @see			#hasAgeSetProperty
	 */
	public ibspan.tss.um.ontology.AgeSet setHasAgeSet(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}