

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for FormLink ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#FormLink)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : ^^http://www.w3.org/2001/XMLSchema#string, Link used describing action names of web forms. They do not need label defined.@en <br>
 * <br>
 * <br>
 */
public interface FormLink extends ibspan.tss.layout.ontology.datamodel.Link, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#FormLink");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#CheckRegister1
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CheckRegister1 = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#CheckRegister1");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#CheckLogin1
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CheckLogin1 = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#CheckLogin1");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#CheckRegister2
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CheckRegister2 = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#CheckRegister2");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Search
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Search = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Search");





}