

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.IntervalDomain to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface IntervalDomainListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when ofMeasure has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.IntervalDomain
	 */
	public void ofMeasureChanged(ibspan.tss.um.ontology.IntervalDomain source);

	/**
	 * Called when hasRightBound has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.IntervalDomain
	 */
	public void hasRightBoundChanged(ibspan.tss.um.ontology.IntervalDomain source);

	/**
	 * Called when hasLeftBound has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.IntervalDomain
	 */
	public void hasLeftBoundChanged(ibspan.tss.um.ontology.IntervalDomain source);

}