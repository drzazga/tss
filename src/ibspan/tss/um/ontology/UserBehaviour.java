

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for UserBehaviour ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviour)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Represents the type of an action the user performed agains the system.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface UserBehaviour extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviour");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#ExitSearchingBehaviour
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ExitSearchingBehaviour = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ExitSearchingBehaviour");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#QueryForRestaurantBehaviour
	 */
	public static com.hp.hpl.jena.rdf.model.Resource QueryForRestaurantBehaviour = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#QueryForRestaurantBehaviour");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#ClickForRestaurantDetailsBehaviour
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ClickForRestaurantDetailsBehaviour = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ClickForRestaurantDetailsBehaviour");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#RateRestaurantPositiveBehaviour
	 */
	public static com.hp.hpl.jena.rdf.model.Resource RateRestaurantPositiveBehaviour = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#RateRestaurantPositiveBehaviour");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#EntrySearchingBehaviour
	 */
	public static com.hp.hpl.jena.rdf.model.Resource EntrySearchingBehaviour = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#EntrySearchingBehaviour");





}