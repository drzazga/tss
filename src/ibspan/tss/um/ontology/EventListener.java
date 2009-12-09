

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.Event to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface EventListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasExtendedUserBehaviour has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Event
	 */
	public void hasExtendedUserBehaviourChanged(ibspan.tss.um.ontology.Event source);

	/**
	 * Called when when has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Event
	 */
	public void whenChanged(ibspan.tss.um.ontology.Event source);

	/**
	 * Called when hasEventID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Event
	 */
	public void hasEventIDChanged(ibspan.tss.um.ontology.Event source);

	/**
	 * Called when hasSessionID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Event
	 */
	public void hasSessionIDChanged(ibspan.tss.um.ontology.Event source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Event
	 */
	public void hasUserIDChanged(ibspan.tss.um.ontology.Event source);

}