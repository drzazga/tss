

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
 * Implementations of this listener may be registered with instances of ibspan.tss.layout.ontology.datamodel.LayoutStructure to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface LayoutStructureListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasErrorMessage has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.LayoutStructure
	 */
	public void hasErrorMessageChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructure source);

	/**
	 * Called when hasTitle has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.LayoutStructure
	 */
	public void hasTitleChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructure source);

	/**
	 * Called when hasText has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.LayoutStructure
	 */
	public void hasTextChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructure source);

	/**
	 * Called when hasMenu has changed
	 * @param source the affected instance of ibspan.tss.layout.ontology.datamodel.LayoutStructure
	 */
	public void hasMenuChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructure source);

}