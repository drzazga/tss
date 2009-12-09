

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
 * Implementations of this listener may be registered with instances of ibspan.tss.layout.ontology.datamodel.Menu to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface MenuListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of hasLink has been added
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.Menu
	 * @param newValue the object representing the new value
	 */	
	public void hasLinkAdded(ibspan.tss.layout.ontology.datamodel.Menu source, ibspan.tss.layout.ontology.datamodel.Link newValue);

	/**
	 * Called when a value of hasLink has been removed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.Menu
	 * @param oldValue the object representing the removed value
	 */
	public void hasLinkRemoved(ibspan.tss.layout.ontology.datamodel.Menu source, ibspan.tss.layout.ontology.datamodel.Link oldValue);
		
}