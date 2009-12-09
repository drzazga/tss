

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.StereotypeProfileData to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface StereotypeProfileDataListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasWealthSet has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StereotypeProfileData
	 */
	public void hasWealthSetChanged(ibspan.tss.um.ontology.StereotypeProfileData source);

	/**
	 * Called when hasDressSet has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StereotypeProfileData
	 */
	public void hasDressSetChanged(ibspan.tss.um.ontology.StereotypeProfileData source);

	/**
	 * Called when hasProfessionSet has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StereotypeProfileData
	 */
	public void hasProfessionSetChanged(ibspan.tss.um.ontology.StereotypeProfileData source);

	/**
	 * Called when hasAgeSet has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.StereotypeProfileData
	 */
	public void hasAgeSetChanged(ibspan.tss.um.ontology.StereotypeProfileData source);

}