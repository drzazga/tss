

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Age ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Age)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes age of a person.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Age extends ibspan.tss.um.ontology.Interval, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Age");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#AgeMin
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AgeMin = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#AgeMin");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#AgeMax
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AgeMax = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#AgeMax");





}