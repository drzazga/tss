

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for MenuLink ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#MenuLink)</p>
 * <br>
 * <br>
 * <br>
 */
public interface MenuLink extends ibspan.tss.layout.ontology.datamodel.Link, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#MenuLink");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#ShowBackedUpResults
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ShowBackedUpResults = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#ShowBackedUpResults");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Login1
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Login1 = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Login1");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#DefineSearch
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DefineSearch = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#DefineSearch");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Welcome
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Welcome = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Welcome");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Logout
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Logout = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Logout");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#ShowDetails
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ShowDetails = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#ShowDetails");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Register1
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Register1 = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Register1");





}