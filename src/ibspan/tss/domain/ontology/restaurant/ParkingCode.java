

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for ParkingCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#ParkingCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface ParkingCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#ParkingCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#OwnParkingLot
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OwnParkingLot = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#OwnParkingLot");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#StreetParking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource StreetParking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#StreetParking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#PublicTransitAccessible
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PublicTransitAccessible = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#PublicTransitAccessible");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#NoLocalParking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NoLocalParking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#NoLocalParking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#ValetParking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ValetParking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#ValetParking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#PayParking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PayParking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#PayParking");





}