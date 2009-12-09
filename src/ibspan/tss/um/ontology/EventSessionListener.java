

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.EventSession to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface EventSessionListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of hasEvent has been added
	 * @param source the affected instance of ibspan.tss.um.ontology.EventSession
	 * @param newValue the object representing the new value
	 */	
	public void hasEventAdded(ibspan.tss.um.ontology.EventSession source, ibspan.tss.um.ontology.Event newValue);

	/**
	 * Called when a value of hasEvent has been removed
	 * @param source the affected instance of ibspan.tss.um.ontology.EventSession
	 * @param oldValue the object representing the removed value
	 */
	public void hasEventRemoved(ibspan.tss.um.ontology.EventSession source, ibspan.tss.um.ontology.Event oldValue);
		
	/**
	 * Called when startedAt has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.EventSession
	 */
	public void startedAtChanged(ibspan.tss.um.ontology.EventSession source);

	/**
	 * Called when hasSessionID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.EventSession
	 */
	public void hasSessionIDChanged(ibspan.tss.um.ontology.EventSession source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.EventSession
	 */
	public void hasUserIDChanged(ibspan.tss.um.ontology.EventSession source);

}