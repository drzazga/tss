

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.AgentQuestion to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface AgentQuestionListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasLongMessage has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.AgentQuestion
	 */
	public void hasLongMessageChanged(ibspan.tss.um.ontology.AgentQuestion source);

	/**
	 * Called when hasQuestionID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.AgentQuestion
	 */
	public void hasQuestionIDChanged(ibspan.tss.um.ontology.AgentQuestion source);

	/**
	 * Called when hasShortMessage has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.AgentQuestion
	 */
	public void hasShortMessageChanged(ibspan.tss.um.ontology.AgentQuestion source);

	/**
	 * Called when hasScenarioActionName has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.AgentQuestion
	 */
	public void hasScenarioActionNameChanged(ibspan.tss.um.ontology.AgentQuestion source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.AgentQuestion
	 */
	public void hasUserIDChanged(ibspan.tss.um.ontology.AgentQuestion source);

}