

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for AlcoholCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#AlcoholCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface AlcoholCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#AlcoholCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#WineBeer
	 */
	public static com.hp.hpl.jena.rdf.model.Resource WineBeer = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#WineBeer");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#NoAlcoholServed
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NoAlcoholServed = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#NoAlcoholServed");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#UnknownAlkohol
	 */
	public static com.hp.hpl.jena.rdf.model.Resource UnknownAlkohol = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#UnknownAlkohol");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#FullBar
	 */
	public static com.hp.hpl.jena.rdf.model.Resource FullBar = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#FullBar");





}