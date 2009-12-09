

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.OpinionSet to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface OpinionSetListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of containsOpinion has been added
	 * @param source the affected instance of ibspan.tss.um.ontology.OpinionSet
	 * @param newValue the object representing the new value
	 */	
	public void containsOpinionAdded(ibspan.tss.um.ontology.OpinionSet source, ibspan.tss.um.ontology.Opinion newValue);

	/**
	 * Called when a value of containsOpinion has been removed
	 * @param source the affected instance of ibspan.tss.um.ontology.OpinionSet
	 * @param oldValue the object representing the removed value
	 */
	public void containsOpinionRemoved(ibspan.tss.um.ontology.OpinionSet source, ibspan.tss.um.ontology.Opinion oldValue);
		
	/**
	 * Called when wasChanged has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.OpinionSet
	 */
	public void wasChangedChanged(ibspan.tss.um.ontology.OpinionSet source);

}