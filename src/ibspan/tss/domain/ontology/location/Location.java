

package ibspan.tss.domain.ontology.location;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Location ontology class<br>
 * Use the ibspan.tss.domain.ontology.location.LocationFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#Location)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Location extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#Location");
	

	/**
	 * The Jena Property for indexPoint 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#indexPoint)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property indexPointProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#indexPoint");


	/**
	 * The Jena Property for locationPath 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#locationPath)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property locationPathProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#locationPath");


	/**
	 * The Jena Property for city 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#city)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property cityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#city");


	/**
	 * The Jena Property for crossStreet 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#crossStreet)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property crossStreetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#crossStreet");


	/**
	 * The Jena Property for attractionCategory 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#attractionCategory)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property attractionCategoryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#attractionCategory");


	/**
	 * The Jena Property for locationCategory 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#locationCategory)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property locationCategoryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#locationCategory");


	/**
	 * The Jena Property for streetAddress 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#streetAddress)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property streetAddressProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#streetAddress");


	/**
	 * The Jena Property for country 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#country)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property countryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#country");


	/**
	 * The Jena Property for fax 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#fax)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property faxProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#fax");


	/**
	 * The Jena Property for state 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#state)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property stateProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#state");


	/**
	 * The Jena Property for phone 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#phone)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property phoneProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#phone");


	/**
	 * The Jena Property for neighborhood 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#neighborhood)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property neighborhoodProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#neighborhood");


	/**
	 * The Jena Property for zip 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#zip)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property zipProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#zip");






	/**
	 * Get an Iterator the 'indexPoint' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.location.IndexPointCode}
	 * @see			#indexPointProperty
	 */
	public java.util.Iterator getIndexPoint() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'indexPoint' property
	 * @param		The {@link ibspan.tss.domain.ontology.location.IndexPointCode} to add
	 * @see			#indexPointProperty
	 */
	public void addIndexPoint(ibspan.tss.domain.ontology.location.IndexPointCode indexPoint) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'indexPoint' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.location.IndexPointCode} created
	 * @see			#indexPointProperty
	 */
	public ibspan.tss.domain.ontology.location.IndexPointCode addIndexPoint() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'indexPoint' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.location.IndexPointCode} with the factory
	 * and calling addIndexPoint(ibspan.tss.domain.ontology.location.IndexPointCode indexPoint)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Location#IndexPointCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#indexPointProperty
	 */
	public ibspan.tss.domain.ontology.location.IndexPointCode addIndexPoint(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'indexPoint' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.location.IndexPointCode} to remove
	 * @see			#indexPointProperty
	 */
	public void removeIndexPoint(ibspan.tss.domain.ontology.location.IndexPointCode indexPoint) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'locationPath' property value
	 * @return		{@link java.lang.String}
	 * @see			#locationPathProperty
	 */
	public java.lang.String getLocationPath() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'locationPath' property value
	 * @param		{@link java.lang.String}
	 * @see			#locationPathProperty
	 */
	public void setLocationPath(java.lang.String locationPath) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'city' property value
	 * @return		{@link java.lang.String}
	 * @see			#cityProperty
	 */
	public java.lang.String getCity() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'city' property value
	 * @param		{@link java.lang.String}
	 * @see			#cityProperty
	 */
	public void setCity(java.lang.String city) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Iterates through the 'crossStreet' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link java.lang.String}
	 * @see			#crossStreetProperty
	 */
	public java.util.Iterator getCrossStreet() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'crossStreet' property value
	 * @param		{@link java.lang.String}, the value to add
	 * @see			#crossStreetProperty
	 */
	public void addCrossStreet(java.lang.String crossStreet) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'crossStreet' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link java.lang.String}, the value to remove
	 * @see			#crossStreetProperty
	 */
	public void removeCrossStreet(java.lang.String crossStreet) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'attractionCategory' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.location.AttractionCategoryCode}
	 * @see			#attractionCategoryProperty
	 */
	public java.util.Iterator getAttractionCategory() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'attractionCategory' property
	 * @param		The {@link ibspan.tss.domain.ontology.location.AttractionCategoryCode} to add
	 * @see			#attractionCategoryProperty
	 */
	public void addAttractionCategory(ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'attractionCategory' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.location.AttractionCategoryCode} created
	 * @see			#attractionCategoryProperty
	 */
	public ibspan.tss.domain.ontology.location.AttractionCategoryCode addAttractionCategory() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'attractionCategory' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.location.AttractionCategoryCode} with the factory
	 * and calling addAttractionCategory(ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Location#AttractionCategoryCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#attractionCategoryProperty
	 */
	public ibspan.tss.domain.ontology.location.AttractionCategoryCode addAttractionCategory(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'attractionCategory' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.location.AttractionCategoryCode} to remove
	 * @see			#attractionCategoryProperty
	 */
	public void removeAttractionCategory(ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'locationCategory' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.location.LocationCategoryCode}
	 * @see			#locationCategoryProperty
	 */
	public java.util.Iterator getLocationCategory() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'locationCategory' property
	 * @param		The {@link ibspan.tss.domain.ontology.location.LocationCategoryCode} to add
	 * @see			#locationCategoryProperty
	 */
	public void addLocationCategory(ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'locationCategory' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.location.LocationCategoryCode} created
	 * @see			#locationCategoryProperty
	 */
	public ibspan.tss.domain.ontology.location.LocationCategoryCode addLocationCategory() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'locationCategory' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.location.LocationCategoryCode} with the factory
	 * and calling addLocationCategory(ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Location#LocationCategoryCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#locationCategoryProperty
	 */
	public ibspan.tss.domain.ontology.location.LocationCategoryCode addLocationCategory(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'locationCategory' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.location.LocationCategoryCode} to remove
	 * @see			#locationCategoryProperty
	 */
	public void removeLocationCategory(ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'streetAddress' property value
	 * @return		{@link java.lang.String}
	 * @see			#streetAddressProperty
	 */
	public java.lang.String getStreetAddress() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'streetAddress' property value
	 * @param		{@link java.lang.String}
	 * @see			#streetAddressProperty
	 */
	public void setStreetAddress(java.lang.String streetAddress) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'country' property value
	 * @return		{@link java.lang.String}
	 * @see			#countryProperty
	 */
	public java.lang.String getCountry() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'country' property value
	 * @param		{@link java.lang.String}
	 * @see			#countryProperty
	 */
	public void setCountry(java.lang.String country) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'fax' property value
	 * @return		{@link java.lang.String}
	 * @see			#faxProperty
	 */
	public java.lang.String getFax() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'fax' property value
	 * @param		{@link java.lang.String}
	 * @see			#faxProperty
	 */
	public void setFax(java.lang.String fax) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'state' property value
	 * @return		{@link java.lang.String}
	 * @see			#stateProperty
	 */
	public java.lang.String getState() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'state' property value
	 * @param		{@link java.lang.String}
	 * @see			#stateProperty
	 */
	public void setState(java.lang.String state) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Iterates through the 'phone' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link java.lang.String}
	 * @see			#phoneProperty
	 */
	public java.util.Iterator getPhone() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'phone' property value
	 * @param		{@link java.lang.String}, the value to add
	 * @see			#phoneProperty
	 */
	public void addPhone(java.lang.String phone) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'phone' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link java.lang.String}, the value to remove
	 * @see			#phoneProperty
	 */
	public void removePhone(java.lang.String phone) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'neighborhood' property value
	 * @return		{@link java.lang.String}
	 * @see			#neighborhoodProperty
	 */
	public java.lang.String getNeighborhood() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'neighborhood' property value
	 * @param		{@link java.lang.String}
	 * @see			#neighborhoodProperty
	 */
	public void setNeighborhood(java.lang.String neighborhood) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'zip' property value
	 * @return		{@link java.lang.String}
	 * @see			#zipProperty
	 */
	public java.lang.String getZip() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'zip' property value
	 * @param		{@link java.lang.String}
	 * @see			#zipProperty
	 */
	public void setZip(java.lang.String zip) throws com.ibm.adtech.jastor.JastorException;

}