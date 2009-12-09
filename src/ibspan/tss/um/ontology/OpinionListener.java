

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.Opinion to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface OpinionListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when atIndividualProbability has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Opinion
	 */
	public void atIndividualProbabilityChanged(ibspan.tss.um.ontology.Opinion source);

	/**
	 * Called when atInferredProbability has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Opinion
	 */
	public void atInferredProbabilityChanged(ibspan.tss.um.ontology.Opinion source);

	/**
	 * Called when atNormalizedProbability has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Opinion
	 */
	public void atNormalizedProbabilityChanged(ibspan.tss.um.ontology.Opinion source);

	/**
	 * Called when hasClassification has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Opinion
	 */
	public void hasClassificationChanged(ibspan.tss.um.ontology.Opinion source);

	/**
	 * Called when isAbout has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.Opinion
	 */
	public void isAboutChanged(ibspan.tss.um.ontology.Opinion source);

}