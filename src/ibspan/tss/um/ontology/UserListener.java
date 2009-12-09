

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.User to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface UserListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasPassword has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.User
	 */
	public void hasPasswordChanged(ibspan.tss.um.ontology.User source);

	/**
	 * Called when hasLogin has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.User
	 */
	public void hasLoginChanged(ibspan.tss.um.ontology.User source);

	/**
	 * Called when hasName has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.User
	 */
	public void hasNameChanged(ibspan.tss.um.ontology.User source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.User
	 */
	public void hasUserIDChanged(ibspan.tss.um.ontology.User source);

}