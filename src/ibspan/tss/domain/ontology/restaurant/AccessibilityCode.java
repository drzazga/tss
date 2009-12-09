

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for AccessibilityCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#AccessibilityCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface AccessibilityCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#AccessibilityCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#PartiallyAccessible
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PartiallyAccessible = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#PartiallyAccessible");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#CompletelyAccesible
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CompletelyAccesible = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#CompletelyAccesible");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#UnknownAccessible
	 */
	public static com.hp.hpl.jena.rdf.model.Resource UnknownAccessible = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#UnknownAccessible");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#NotAccessible
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NotAccessible = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#NotAccessible");





}