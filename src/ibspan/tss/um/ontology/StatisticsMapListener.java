

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.StatisticsMap to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface StatisticsMapListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of hasStatisticsEntry has been added
	 * @param source the affected instance of ibspan.tss.um.ontology.StatisticsMap
	 * @param newValue the object representing the new value
	 */	
	public void hasStatisticsEntryAdded(ibspan.tss.um.ontology.StatisticsMap source, com.ibm.adtech.jastor.Thing newValue);

	/**
	 * Called when a value of hasStatisticsEntry has been removed
	 * @param source the affected instance of ibspan.tss.um.ontology.StatisticsMap
	 * @param oldValue the object representing the removed value
	 */
	public void hasStatisticsEntryRemoved(ibspan.tss.um.ontology.StatisticsMap source, com.ibm.adtech.jastor.Thing oldValue);
		
}