

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for WealthSet ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#WealthSet)</p>
 * <br>
 * <br>
 * <br>
 */
public interface WealthSet extends ibspan.tss.um.ontology.OrdinalSet, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#WealthSet");
	





}