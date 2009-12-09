

package ibspan.tss.domain.ontology.restaurant;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for DressCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#DressCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface DressCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#DressCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#FormalDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource FormalDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#FormalDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#DressyCasualDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DressyCasualDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#DressyCasualDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#CasualDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CasualDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#CasualDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#FormalRequiredDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource FormalRequiredDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#FormalRequiredDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Restaurant#UnknownDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource UnknownDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Restaurant#UnknownDress");





}