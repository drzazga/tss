

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.RatedResult to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface RatedResultListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasTemperature has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.RatedResult
	 */
	public void hasTemperatureChanged(ibspan.tss.um.ontology.RatedResult source);

	/**
	 * Called when ofObject has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.RatedResult
	 */
	public void ofObjectChanged(ibspan.tss.um.ontology.RatedResult source);

}