

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
 * Implementations of this listener may be registered with instances of ibspan.tss.layout.ontology.datamodel.MenuLink to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface MenuLinkListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasLabel has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.MenuLink
	 */
	public void hasLabelChanged(ibspan.tss.layout.ontology.datamodel.MenuLink source);

	/**
	 * Called when hasActionName has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.MenuLink
	 */
	public void hasActionNameChanged(ibspan.tss.layout.ontology.datamodel.MenuLink source);

}