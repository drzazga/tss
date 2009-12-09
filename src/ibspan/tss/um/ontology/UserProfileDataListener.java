

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.UserProfileData to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface UserProfileDataListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasWealth has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfileData
	 */
	public void hasWealthChanged(ibspan.tss.um.ontology.UserProfileData source);

	/**
	 * Called when wasBorn has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfileData
	 */
	public void wasBornChanged(ibspan.tss.um.ontology.UserProfileData source);

	/**
	 * Called when hasDress has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfileData
	 */
	public void hasDressChanged(ibspan.tss.um.ontology.UserProfileData source);

	/**
	 * Called when hasProfession has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfileData
	 */
	public void hasProfessionChanged(ibspan.tss.um.ontology.UserProfileData source);

	/**
	 * Called when hasAge has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfileData
	 */
	public void hasAgeChanged(ibspan.tss.um.ontology.UserProfileData source);

}