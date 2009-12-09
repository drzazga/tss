

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for InternalLink ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#InternalLink)</p>
 * <br>
 * <br>
 * <br>
 */
public interface InternalLink extends ibspan.tss.layout.ontology.datamodel.Link, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#InternalLink");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#LoginSuccess
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LoginSuccess = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#LoginSuccess");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Register2
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Register2 = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Register2");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#ShowFreshResults
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ShowFreshResults = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#ShowFreshResults");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#RegisterSuccess
	 */
	public static com.hp.hpl.jena.rdf.model.Resource RegisterSuccess = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#RegisterSuccess");





}