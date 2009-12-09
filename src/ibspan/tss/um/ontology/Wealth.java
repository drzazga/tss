

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Wealth ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Wealth)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Express wealth of a person.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Wealth extends ibspan.tss.um.ontology.Ordinal, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Wealth");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#AverageRich
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AverageRich = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#AverageRich");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#VeryRich
	 */
	public static com.hp.hpl.jena.rdf.model.Resource VeryRich = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#VeryRich");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#Rich
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Rich = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Rich");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#NotRich
	 */
	public static com.hp.hpl.jena.rdf.model.Resource NotRich = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#NotRich");





}