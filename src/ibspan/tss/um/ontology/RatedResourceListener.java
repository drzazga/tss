

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.RatedResource to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface RatedResourceListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasRate has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.RatedResource
	 */
	public void hasRateChanged(ibspan.tss.um.ontology.RatedResource source);

	/**
	 * Called when ofResource has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.RatedResource
	 */
	public void ofResourceChanged(ibspan.tss.um.ontology.RatedResource source);

}