

package ibspan.tss.layout.ontology.datamodel;

/*
import com.hp.hpl.jena.datatypes.xsd.*;
import com.hp.hpl.jena.datatypes.xsd.impl.*;
import com.hp.hpl.jena.rdf.model.*;
import com.ibm.adtech.jastor.*;
import java.util.*;
import java.math.*;
*/


/**
 * Implementations of this listener may be registered with instances of ibspan.tss.layout.ontology.datamodel.UserContext to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface UserContextListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasSessionID has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.UserContext
	 */
	public void hasSessionIDChanged(ibspan.tss.layout.ontology.datamodel.UserContext source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.UserContext
	 */
	public void hasUserIDChanged(ibspan.tss.layout.ontology.datamodel.UserContext source);

	/**
	 * Called when hasInterfaceHost has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.UserContext
	 */
	public void hasInterfaceHostChanged(ibspan.tss.layout.ontology.datamodel.UserContext source);

	/**
	 * Called when hasMediaType has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.UserContext
	 */
	public void hasMediaTypeChanged(ibspan.tss.layout.ontology.datamodel.UserContext source);

	/**
	 * Called when hasInterfacePort has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.UserContext
	 */
	public void hasInterfacePortChanged(ibspan.tss.layout.ontology.datamodel.UserContext source);

}