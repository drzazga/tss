

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Classification ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Classification)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Classification of an opinion.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Classification extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Classification");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#NotClassified
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NotClassified = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#NotClassified");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#NotInteresting
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NotInteresting = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#NotInteresting");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#Interesting
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Interesting = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Interesting");





}