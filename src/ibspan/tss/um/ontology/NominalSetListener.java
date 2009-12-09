

package ibspan.tss.um.ontology;

/*
import com.hp.hpl.jena.datatypes.xsd.*;
import com.hp.hpl.jena.datatypes.xsd.impl.*;
import com.hp.hpl.jena.rdf.model.*;
import com.ibm.adtech.jastor.*;
import java.util.*;
import java.math.*;
*/


/**
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.NominalSet to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface NominalSetListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of contains has been added
	 * @param source the affected instance of ibspan.tss.um.ontology.NominalSet
	 * @param newValue the object representing the new value
	 */	
	public void containsAdded(ibspan.tss.um.ontology.NominalSet source, ibspan.tss.um.ontology.Measure newValue);

	/**
	 * Called when a value of contains has been removed
	 * @param source the affected instance of ibspan.tss.um.ontology.NominalSet
	 * @param oldValue the object representing the removed value
	 */
	public void containsRemoved(ibspan.tss.um.ontology.NominalSet source, ibspan.tss.um.ontology.Measure oldValue);
		
	/**
	 * Called when a value of contains has been added
	 * @param source the affected instance of ibspan.tss.um.ontology.NominalSet
	 * @param newValue the object representing the new value
	 */	
	public void containsAdded(ibspan.tss.um.ontology.NominalSet source, ibspan.tss.um.ontology.Nominal newValue);

	/**
	 * Called when a value of contains has been removed
	 * @param source the affected instance of ibspan.tss.um.ontology.NominalSet
	 * @param oldValue the object representing the removed value
	 */
	public void containsRemoved(ibspan.tss.um.ontology.NominalSet source, ibspan.tss.um.ontology.Nominal oldValue);
		
}