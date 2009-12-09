

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
 * Implementations of this listener may be registered with instances of ibspan.tss.um.ontology.UserProfile to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface UserProfileListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when hasOpinions has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfile
	 */
	public void hasOpinionsChanged(ibspan.tss.um.ontology.UserProfile source);

	/**
	 * Called when hasUserProfileData has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfile
	 */
	public void hasUserProfileDataChanged(ibspan.tss.um.ontology.UserProfile source);

	/**
	 * Called when hasUserID has changed
	 * @param source the affected instance of ibspan.tss.um.ontology.UserProfile
	 */
	public void hasUserIDChanged(ibspan.tss.um.ontology.UserProfile source);

}