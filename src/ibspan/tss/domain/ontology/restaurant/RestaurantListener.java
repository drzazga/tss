

package ibspan.tss.domain.ontology.restaurant;

/*
import com.hp.hpl.jena.datatypes.xsd.*;
import com.hp.hpl.jena.datatypes.xsd.impl.*;
import com.hp.hpl.jena.rdf.model.*;
import com.ibm.adtech.jastor.*;
import java.util.*;
import java.math.*;
*/


/**
 * Implementations of this listener may be registered with instances of ibspan.tss.domain.ontology.restaurant.Restaurant to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface RestaurantListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of indexPoint has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void indexPointAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.location.IndexPointCode newValue);

	/**
	 * Called when a value of indexPoint has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void indexPointRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.location.IndexPointCode oldValue);
		
	/**
	 * Called when locationPath has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void locationPathChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when city has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void cityChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of crossStreet has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void crossStreetAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, java.lang.String newValue);

	/**
	 * Called when a value of crossStreet has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */	
	public void crossStreetRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, java.lang.String oldValue);

	/**
	 * Called when a value of attractionCategory has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void attractionCategoryAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.location.AttractionCategoryCode newValue);

	/**
	 * Called when a value of attractionCategory has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void attractionCategoryRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.location.AttractionCategoryCode oldValue);
		
	/**
	 * Called when a value of locationCategory has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void locationCategoryAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.location.LocationCategoryCode newValue);

	/**
	 * Called when a value of locationCategory has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void locationCategoryRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.location.LocationCategoryCode oldValue);
		
	/**
	 * Called when streetAddress has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void streetAddressChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when country has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void countryChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when fax has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void faxChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when state has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void stateChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of phone has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void phoneAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, java.lang.String newValue);

	/**
	 * Called when a value of phone has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */	
	public void phoneRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, java.lang.String oldValue);

	/**
	 * Called when neighborhood has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void neighborhoodChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when zip has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void zipChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when clientele has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void clienteleChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of accessibility has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void accessibilityAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.AccessibilityCode newValue);

	/**
	 * Called when a value of accessibility has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void accessibilityRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.AccessibilityCode oldValue);
		
	/**
	 * Called when lunchPrice has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void lunchPriceChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when dinnerPrice has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void dinnerPriceChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of restaurantService has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void restaurantServiceAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo newValue);

	/**
	 * Called when a value of restaurantService has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void restaurantServiceRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo oldValue);
		
	/**
	 * Called when capacity has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void capacityChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when title has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void titleChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when deliveryURL has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void deliveryURLChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when recommendedDishes has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void recommendedDishesChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when URL has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void URLChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of cuisine has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void cuisineAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.CuisineCode newValue);

	/**
	 * Called when a value of cuisine has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void cuisineRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.CuisineCode oldValue);
		
	/**
	 * Called when smoking has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void smokingChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of feature has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void featureAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.FeatureCode newValue);

	/**
	 * Called when a value of feature has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void featureRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.FeatureCode oldValue);
		
	/**
	 * Called when restaurantCategory has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void restaurantCategoryChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when parsedHours has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void parsedHoursChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of alcohol has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void alcoholAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.AlcoholCode newValue);

	/**
	 * Called when a value of alcohol has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void alcoholRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.AlcoholCode oldValue);
		
	/**
	 * Called when a value of dress has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void dressAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.DressCode newValue);

	/**
	 * Called when a value of dress has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void dressRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.DressCode oldValue);
		
	/**
	 * Called when a value of hasDinerReview has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void hasDinerReviewAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.DinerReview newValue);

	/**
	 * Called when a value of hasDinerReview has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void hasDinerReviewRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.DinerReview oldValue);
		
	/**
	 * Called when menuURL has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void menuURLChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when accessibilityNotes has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void accessibilityNotesChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when largestParty has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void largestPartyChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of parking has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void parkingAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.ParkingCode newValue);

	/**
	 * Called when a value of parking has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void parkingRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.ParkingCode oldValue);
		
	/**
	 * Called when a value of reservations has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void reservationsAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.ReservationCode newValue);

	/**
	 * Called when a value of reservations has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void reservationsRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, ibspan.tss.domain.ontology.restaurant.ReservationCode oldValue);
		
	/**
	 * Called when breakfastPrice has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void breakfastPriceChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when reservationURL has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void reservationURLChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when hours has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 */
	public void hoursChanged(ibspan.tss.domain.ontology.restaurant.Restaurant source);

	/**
	 * Called when a value of accepts has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param newValue the object representing the new value
	 */	
	public void acceptsAdded(ibspan.tss.domain.ontology.restaurant.Restaurant source, com.ibm.adtech.jastor.Thing newValue);

	/**
	 * Called when a value of accepts has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.restaurant.Restaurant
	 * @param oldValue the object representing the removed value
	 */
	public void acceptsRemoved(ibspan.tss.domain.ontology.restaurant.Restaurant source, com.ibm.adtech.jastor.Thing oldValue);
		
}