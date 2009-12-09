

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for ReservationCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#ReservationCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface ReservationCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#ReservationCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#RequiredReservations
	 */
	public static com.hp.hpl.jena.rdf.model.Resource RequiredReservations = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#RequiredReservations");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#LargeGroupsOnlyReservations
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LargeGroupsOnlyReservations = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#LargeGroupsOnlyReservations");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#RecommendedReservations
	 */
	public static com.hp.hpl.jena.rdf.model.Resource RecommendedReservations = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#RecommendedReservations");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#AcceptedReservations
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AcceptedReservations = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#AcceptedReservations");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#UnknownReseravations
	 */
	public static com.hp.hpl.jena.rdf.model.Resource UnknownReseravations = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#UnknownReseravations");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#NotAcceptedReservations
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NotAcceptedReservations = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#NotAcceptedReservations");





}