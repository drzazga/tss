

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.ContextParameter to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface ContextParameterListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasValue has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.ContextParameter
	 */
	public void hasValueChanged(ibspan.tss.um.ontology.ContextParameter source);

	/**
	 * Called when hasName has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.ContextParameter
	 */
	public void hasNameChanged(ibspan.tss.um.ontology.ContextParameter source);

}