

package ibspan.tss.domain.ontology.money;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for FuzzyPriceCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.money.MoneyFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Money#FuzzyPriceCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface FuzzyPriceCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#FuzzyPriceCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Expensive
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Expensive = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Expensive");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#VeryExpensive
	 */
	public static com.hp.hpl.jena.rdf.model.Resource VeryExpensive = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#VeryExpensive");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Moderate
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Moderate = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Moderate");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#VeryCheap
	 */
	public static com.hp.hpl.jena.rdf.model.Resource VeryCheap = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#VeryCheap");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Inexpensive
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Inexpensive = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Inexpensive");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Price
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Price = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Price");





}