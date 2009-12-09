

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.UserBehaviourContext to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface UserBehaviourContextListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of hasParameter has been added
	 * @param source the affected instance of ibspan.tss.um.ontology.UserBehaviourContext
	 * @param newValue the object representing the new value
	 */	
	public void hasParameterAdded(ibspan.tss.um.ontology.UserBehaviourContext source, ibspan.tss.um.ontology.ContextParameter newValue);

	/**
	 * Called when a value of hasParameter has been removed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserBehaviourContext
	 * @param oldValue the object representing the removed value
	 */
	public void hasParameterRemoved(ibspan.tss.um.ontology.UserBehaviourContext source, ibspan.tss.um.ontology.ContextParameter oldValue);
		
}