

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.StatisticEntry to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface StatisticEntryListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasConceptURI has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StatisticEntry
	 */
	public void hasConceptURIChanged(ibspan.tss.um.ontology.StatisticEntry source);

	/**
	 * Called when hasCount has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StatisticEntry
	 */
	public void hasCountChanged(ibspan.tss.um.ontology.StatisticEntry source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StatisticEntry
	 */
	public void hasUserIDChanged(ibspan.tss.um.ontology.StatisticEntry source);

	/**
	 * Called when hasUserBehaviour has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StatisticEntry
	 */
	public void hasUserBehaviourChanged(ibspan.tss.um.ontology.StatisticEntry source);

}