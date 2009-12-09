

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Restaurant ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#Restaurant)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Restaurant extends ibspan.tss.domain.ontology.location.Location, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#Restaurant");
	

	/**
	 * The Jena Property for clientele 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#clientele)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property clienteleProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#clientele");


	/**
	 * The Jena Property for accessibility 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#accessibility)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property accessibilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#accessibility");


	/**
	 * The Jena Property for lunchPrice 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#lunchPrice)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property lunchPriceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#lunchPrice");


	/**
	 * The Jena Property for dinnerPrice 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#dinnerPrice)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property dinnerPriceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#dinnerPrice");


	/**
	 * The Jena Property for restaurantService 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#restaurantService)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property restaurantServiceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#restaurantService");


	/**
	 * The Jena Property for capacity 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#capacity)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property capacityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#capacity");


	/**
	 * The Jena Property for title 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#title)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property titleProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#title");


	/**
	 * The Jena Property for deliveryURL 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#deliveryURL)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property deliveryURLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#deliveryURL");


	/**
	 * The Jena Property for recommendedDishes 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#recommendedDishes)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property recommendedDishesProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#recommendedDishes");


	/**
	 * The Jena Property for URL 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#URL)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property URLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#URL");


	/**
	 * The Jena Property for cuisine 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#cuisine)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property cuisineProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#cuisine");


	/**
	 * The Jena Property for smoking 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#smoking)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property smokingProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#smoking");


	/**
	 * The Jena Property for feature 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#feature)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property featureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#feature");


	/**
	 * The Jena Property for restaurantCategory 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#restaurantCategory)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property restaurantCategoryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#restaurantCategory");


	/**
	 * The Jena Property for parsedHours 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#parsedHours)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property parsedHoursProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#parsedHours");


	/**
	 * The Jena Property for alcohol 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#alcohol)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property alcoholProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#alcohol");


	/**
	 * The Jena Property for dress 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#dress)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property dressProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#dress");


	/**
	 * The Jena Property for hasDinerReview 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#hasDinerReview)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasDinerReviewProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#hasDinerReview");


	/**
	 * The Jena Property for menuURL 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#menuURL)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property menuURLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#menuURL");


	/**
	 * The Jena Property for accessibilityNotes 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#accessibilityNotes)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property accessibilityNotesProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#accessibilityNotes");


	/**
	 * The Jena Property for largestParty 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#largestParty)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property largestPartyProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#largestParty");


	/**
	 * The Jena Property for parking 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#parking)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property parkingProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#parking");


	/**
	 * The Jena Property for reservations 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#reservations)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property reservationsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#reservations");


	/**
	 * The Jena Property for breakfastPrice 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#breakfastPrice)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property breakfastPriceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#breakfastPrice");


	/**
	 * The Jena Property for reservationURL 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#reservationURL)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property reservationURLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#reservationURL");


	/**
	 * The Jena Property for hours 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#hours)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hoursProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#hours");


	/**
	 * The Jena Property for accepts 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#accepts)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property acceptsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#accepts");






	/**
	 * Gets the 'clientele' property value
	 * @return		{@link java.lang.String}
	 * @see			#clienteleProperty
	 */
	public java.lang.String getClientele() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'clientele' property value
	 * @param		{@link java.lang.String}
	 * @see			#clienteleProperty
	 */
	public void setClientele(java.lang.String clientele) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'accessibility' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.AccessibilityCode}
	 * @see			#accessibilityProperty
	 */
	public java.util.Iterator getAccessibility() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'accessibility' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.AccessibilityCode} to add
	 * @see			#accessibilityProperty
	 */
	public void addAccessibility(ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'accessibility' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.AccessibilityCode} created
	 * @see			#accessibilityProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.AccessibilityCode addAccessibility() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'accessibility' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.AccessibilityCode} with the factory
	 * and calling addAccessibility(ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#AccessibilityCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#accessibilityProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.AccessibilityCode addAccessibility(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'accessibility' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.AccessibilityCode} to remove
	 * @see			#accessibilityProperty
	 */
	public void removeAccessibility(ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'lunchPrice' property value
	 * @return		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#lunchPriceProperty
	 */
	public com.ibm.adtech.jastor.Thing getLunchPrice() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'lunchPrice' property value
	 * @param		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#lunchPriceProperty
	 */
	public void setLunchPrice(com.ibm.adtech.jastor.Thing lunchPrice) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'lunchPrice' property value to an anonymous node
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the created value
	 * @see			#lunchPriceProperty
	 */	
	public com.ibm.adtech.jastor.Thing setLunchPrice() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'lunchPrice' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link com.ibm.adtech.jastor.Thing} with the factory.
	 * and calling setLunchPrice(com.ibm.adtech.jastor.Thing lunchPrice)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the newly created value
	 * @see			#lunchPriceProperty
	 */
	public com.ibm.adtech.jastor.Thing setLunchPrice(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'dinnerPrice' property value
	 * @return		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#dinnerPriceProperty
	 */
	public com.ibm.adtech.jastor.Thing getDinnerPrice() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'dinnerPrice' property value
	 * @param		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#dinnerPriceProperty
	 */
	public void setDinnerPrice(com.ibm.adtech.jastor.Thing dinnerPrice) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'dinnerPrice' property value to an anonymous node
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the created value
	 * @see			#dinnerPriceProperty
	 */	
	public com.ibm.adtech.jastor.Thing setDinnerPrice() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'dinnerPrice' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link com.ibm.adtech.jastor.Thing} with the factory.
	 * and calling setDinnerPrice(com.ibm.adtech.jastor.Thing dinnerPrice)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the newly created value
	 * @see			#dinnerPriceProperty
	 */
	public com.ibm.adtech.jastor.Thing setDinnerPrice(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Get an Iterator the 'restaurantService' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo}
	 * @see			#restaurantServiceProperty
	 */
	public java.util.Iterator getRestaurantService() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'restaurantService' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo} to add
	 * @see			#restaurantServiceProperty
	 */
	public void addRestaurantService(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'restaurantService' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo} created
	 * @see			#restaurantServiceProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo addRestaurantService() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'restaurantService' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo} with the factory
	 * and calling addRestaurantService(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#RestaurantServiceInfo.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#restaurantServiceProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo addRestaurantService(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'restaurantService' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo} to remove
	 * @see			#restaurantServiceProperty
	 */
	public void removeRestaurantService(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'capacity' property value
	 * @return		{@link com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType}
	 * @see			#capacityProperty
	 */
	public com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType getCapacity() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'capacity' property value
	 * @param		{@link com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType}
	 * @see			#capacityProperty
	 */
	public void setCapacity(com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType capacity) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'title' property value
	 * @return		{@link java.lang.String}
	 * @see			#titleProperty
	 */
	public java.lang.String getTitle() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'title' property value
	 * @param		{@link java.lang.String}
	 * @see			#titleProperty
	 */
	public void setTitle(java.lang.String title) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'deliveryURL' property value
	 * @return		{@link java.lang.String}
	 * @see			#deliveryURLProperty
	 */
	public java.lang.String getDeliveryURL() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'deliveryURL' property value
	 * @param		{@link java.lang.String}
	 * @see			#deliveryURLProperty
	 */
	public void setDeliveryURL(java.lang.String deliveryURL) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'recommendedDishes' property value
	 * @return		{@link java.lang.String}
	 * @see			#recommendedDishesProperty
	 */
	public java.lang.String getRecommendedDishes() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'recommendedDishes' property value
	 * @param		{@link java.lang.String}
	 * @see			#recommendedDishesProperty
	 */
	public void setRecommendedDishes(java.lang.String recommendedDishes) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'URL' property value
	 * @return		{@link java.lang.String}
	 * @see			#URLProperty
	 */
	public java.lang.String getURL() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'URL' property value
	 * @param		{@link java.lang.String}
	 * @see			#URLProperty
	 */
	public void setURL(java.lang.String URL) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'cuisine' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.CuisineCode}
	 * @see			#cuisineProperty
	 */
	public java.util.Iterator getCuisine() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'cuisine' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.CuisineCode} to add
	 * @see			#cuisineProperty
	 */
	public void addCuisine(ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'cuisine' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.CuisineCode} created
	 * @see			#cuisineProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.CuisineCode addCuisine() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'cuisine' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.CuisineCode} with the factory
	 * and calling addCuisine(ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#CuisineCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#cuisineProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.CuisineCode addCuisine(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'cuisine' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.CuisineCode} to remove
	 * @see			#cuisineProperty
	 */
	public void removeCuisine(ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'smoking' property value
	 * @return		{@link ibspan.tss.domain.ontology.restaurant.SmokingCode}
	 * @see			#smokingProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.SmokingCode getSmoking() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'smoking' property value
	 * @param		{@link ibspan.tss.domain.ontology.restaurant.SmokingCode}
	 * @see			#smokingProperty
	 */
	public void setSmoking(ibspan.tss.domain.ontology.restaurant.SmokingCode smoking) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'smoking' property value to an anonymous node
	 * @return		{@link ibspan.tss.domain.ontology.restaurant.SmokingCode}, the created value
	 * @see			#smokingProperty
	 */	
	public ibspan.tss.domain.ontology.restaurant.SmokingCode setSmoking() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'smoking' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.SmokingCode} with the factory.
	 * and calling setSmoking(ibspan.tss.domain.ontology.restaurant.SmokingCode smoking)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#SmokingCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.domain.ontology.restaurant.SmokingCode}, the newly created value
	 * @see			#smokingProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.SmokingCode setSmoking(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Get an Iterator the 'feature' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.FeatureCode}
	 * @see			#featureProperty
	 */
	public java.util.Iterator getFeature() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'feature' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.FeatureCode} to add
	 * @see			#featureProperty
	 */
	public void addFeature(ibspan.tss.domain.ontology.restaurant.FeatureCode feature) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'feature' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.FeatureCode} created
	 * @see			#featureProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.FeatureCode addFeature() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'feature' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.FeatureCode} with the factory
	 * and calling addFeature(ibspan.tss.domain.ontology.restaurant.FeatureCode feature)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#FeatureCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#featureProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.FeatureCode addFeature(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'feature' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.FeatureCode} to remove
	 * @see			#featureProperty
	 */
	public void removeFeature(ibspan.tss.domain.ontology.restaurant.FeatureCode feature) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'restaurantCategory' property value
	 * @return		{@link ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode}
	 * @see			#restaurantCategoryProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode getRestaurantCategory() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'restaurantCategory' property value
	 * @param		{@link ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode}
	 * @see			#restaurantCategoryProperty
	 */
	public void setRestaurantCategory(ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode restaurantCategory) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'restaurantCategory' property value to an anonymous node
	 * @return		{@link ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode}, the created value
	 * @see			#restaurantCategoryProperty
	 */	
	public ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode setRestaurantCategory() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'restaurantCategory' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode} with the factory.
	 * and calling setRestaurantCategory(ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode restaurantCategory)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#RestaurantCategoryCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode}, the newly created value
	 * @see			#restaurantCategoryProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode setRestaurantCategory(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'parsedHours' property value
	 * @return		{@link java.lang.String}
	 * @see			#parsedHoursProperty
	 */
	public java.lang.String getParsedHours() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'parsedHours' property value
	 * @param		{@link java.lang.String}
	 * @see			#parsedHoursProperty
	 */
	public void setParsedHours(java.lang.String parsedHours) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'alcohol' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.AlcoholCode}
	 * @see			#alcoholProperty
	 */
	public java.util.Iterator getAlcohol() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'alcohol' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.AlcoholCode} to add
	 * @see			#alcoholProperty
	 */
	public void addAlcohol(ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'alcohol' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.AlcoholCode} created
	 * @see			#alcoholProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.AlcoholCode addAlcohol() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'alcohol' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.AlcoholCode} with the factory
	 * and calling addAlcohol(ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#AlcoholCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#alcoholProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.AlcoholCode addAlcohol(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'alcohol' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.AlcoholCode} to remove
	 * @see			#alcoholProperty
	 */
	public void removeAlcohol(ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'dress' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.DressCode}
	 * @see			#dressProperty
	 */
	public java.util.Iterator getDress() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'dress' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.DressCode} to add
	 * @see			#dressProperty
	 */
	public void addDress(ibspan.tss.domain.ontology.restaurant.DressCode dress) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'dress' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.DressCode} created
	 * @see			#dressProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.DressCode addDress() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'dress' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.DressCode} with the factory
	 * and calling addDress(ibspan.tss.domain.ontology.restaurant.DressCode dress)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#DressCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#dressProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.DressCode addDress(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'dress' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.DressCode} to remove
	 * @see			#dressProperty
	 */
	public void removeDress(ibspan.tss.domain.ontology.restaurant.DressCode dress) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'hasDinerReview' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.DinerReview}
	 * @see			#hasDinerReviewProperty
	 */
	public java.util.Iterator getHasDinerReview() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'hasDinerReview' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.DinerReview} to add
	 * @see			#hasDinerReviewProperty
	 */
	public void addHasDinerReview(ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'hasDinerReview' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.DinerReview} created
	 * @see			#hasDinerReviewProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.DinerReview addHasDinerReview() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'hasDinerReview' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.DinerReview} with the factory
	 * and calling addHasDinerReview(ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#DinerReview.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#hasDinerReviewProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.DinerReview addHasDinerReview(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'hasDinerReview' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.DinerReview} to remove
	 * @see			#hasDinerReviewProperty
	 */
	public void removeHasDinerReview(ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'menuURL' property value
	 * @return		{@link java.lang.String}
	 * @see			#menuURLProperty
	 */
	public java.lang.String getMenuURL() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'menuURL' property value
	 * @param		{@link java.lang.String}
	 * @see			#menuURLProperty
	 */
	public void setMenuURL(java.lang.String menuURL) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'accessibilityNotes' property value
	 * @return		{@link java.lang.String}
	 * @see			#accessibilityNotesProperty
	 */
	public java.lang.String getAccessibilityNotes() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'accessibilityNotes' property value
	 * @param		{@link java.lang.String}
	 * @see			#accessibilityNotesProperty
	 */
	public void setAccessibilityNotes(java.lang.String accessibilityNotes) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'largestParty' property value
	 * @return		{@link com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType}
	 * @see			#largestPartyProperty
	 */
	public com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType getLargestParty() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'largestParty' property value
	 * @param		{@link com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType}
	 * @see			#largestPartyProperty
	 */
	public void setLargestParty(com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType largestParty) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'parking' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.ParkingCode}
	 * @see			#parkingProperty
	 */
	public java.util.Iterator getParking() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'parking' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.ParkingCode} to add
	 * @see			#parkingProperty
	 */
	public void addParking(ibspan.tss.domain.ontology.restaurant.ParkingCode parking) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'parking' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.ParkingCode} created
	 * @see			#parkingProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.ParkingCode addParking() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'parking' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.ParkingCode} with the factory
	 * and calling addParking(ibspan.tss.domain.ontology.restaurant.ParkingCode parking)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#ParkingCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#parkingProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.ParkingCode addParking(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'parking' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.ParkingCode} to remove
	 * @see			#parkingProperty
	 */
	public void removeParking(ibspan.tss.domain.ontology.restaurant.ParkingCode parking) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'reservations' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.domain.ontology.restaurant.ReservationCode}
	 * @see			#reservationsProperty
	 */
	public java.util.Iterator getReservations() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'reservations' property
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.ReservationCode} to add
	 * @see			#reservationsProperty
	 */
	public void addReservations(ibspan.tss.domain.ontology.restaurant.ReservationCode reservations) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'reservations' property
	 * @return		The anoymous {@link ibspan.tss.domain.ontology.restaurant.ReservationCode} created
	 * @see			#reservationsProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.ReservationCode addReservations() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'reservations' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.domain.ontology.restaurant.ReservationCode} with the factory
	 * and calling addReservations(ibspan.tss.domain.ontology.restaurant.ReservationCode reservations)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/Restaurant#ReservationCode.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#reservationsProperty
	 */
	public ibspan.tss.domain.ontology.restaurant.ReservationCode addReservations(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'reservations' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.domain.ontology.restaurant.ReservationCode} to remove
	 * @see			#reservationsProperty
	 */
	public void removeReservations(ibspan.tss.domain.ontology.restaurant.ReservationCode reservations) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'breakfastPrice' property value
	 * @return		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#breakfastPriceProperty
	 */
	public com.ibm.adtech.jastor.Thing getBreakfastPrice() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'breakfastPrice' property value
	 * @param		{@link com.ibm.adtech.jastor.Thing}
	 * @see			#breakfastPriceProperty
	 */
	public void setBreakfastPrice(com.ibm.adtech.jastor.Thing breakfastPrice) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'breakfastPrice' property value to an anonymous node
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the created value
	 * @see			#breakfastPriceProperty
	 */	
	public com.ibm.adtech.jastor.Thing setBreakfastPrice() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'breakfastPrice' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link com.ibm.adtech.jastor.Thing} with the factory.
	 * and calling setBreakfastPrice(com.ibm.adtech.jastor.Thing breakfastPrice)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link com.ibm.adtech.jastor.Thing}, the newly created value
	 * @see			#breakfastPriceProperty
	 */
	public com.ibm.adtech.jastor.Thing setBreakfastPrice(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'reservationURL' property value
	 * @return		{@link java.lang.String}
	 * @see			#reservationURLProperty
	 */
	public java.lang.String getReservationURL() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'reservationURL' property value
	 * @param		{@link java.lang.String}
	 * @see			#reservationURLProperty
	 */
	public void setReservationURL(java.lang.String reservationURL) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hours' property value
	 * @return		{@link java.lang.String}
	 * @see			#hoursProperty
	 */
	public java.lang.String getHours() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hours' property value
	 * @param		{@link java.lang.String}
	 * @see			#hoursProperty
	 */
	public void setHours(java.lang.String hours) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'accepts' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.ibm.adtech.jastor.Thing}
	 * @see			#acceptsProperty
	 */
	public java.util.Iterator getAccepts() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'accepts' property
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to add
	 * @see			#acceptsProperty
	 */
	public void addAccepts(com.ibm.adtech.jastor.Thing accepts) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'accepts' property
	 * @return		The anoymous {@link com.ibm.adtech.jastor.Thing} created
	 * @see			#acceptsProperty
	 */
	public com.ibm.adtech.jastor.Thing addAccepts() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'accepts' property.  This
	 * method is equivalent constructing a new instance of {@link com.ibm.adtech.jastor.Thing} with the factory
	 * and calling addAccepts(com.ibm.adtech.jastor.Thing accepts)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#acceptsProperty
	 */
	public com.ibm.adtech.jastor.Thing addAccepts(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'accepts' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to remove
	 * @see			#acceptsProperty
	 */
	public void removeAccepts(com.ibm.adtech.jastor.Thing accepts) throws com.ibm.adtech.jastor.JastorException;
		
}