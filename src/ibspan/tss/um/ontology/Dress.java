

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Dress ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Dress)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Express wearing style of a person.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Dress extends ibspan.tss.um.ontology.Ordinal, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Dress");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#NaturalDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NaturalDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#NaturalDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#ElegantDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ElegantDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ElegantDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#SportyDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource SportyDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#SportyDress");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#OtherDress
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OtherDress = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#OtherDress");





}