

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for SmokingCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#SmokingCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface SmokingCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#SmokingCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#NotPermittedSmoking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NotPermittedSmoking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#NotPermittedSmoking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#SectionSmoking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource SectionSmoking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#SectionSmoking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#OnlyAtBarSmoking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OnlyAtBarSmoking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#OnlyAtBarSmoking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#UnknownSmoking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource UnknownSmoking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#UnknownSmoking");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#PermittedSmoking
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PermittedSmoking = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#PermittedSmoking");





}