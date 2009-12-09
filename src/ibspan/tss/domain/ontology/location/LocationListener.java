

package ibspan.tss.domain.ontology.location;

/*
import com.hp.hpl.jena.datatypes.xsd.*;
import com.hp.hpl.jena.datatypes.xsd.impl.*;
import com.hp.hpl.jena.rdf.model.*;
import com.ibm.adtech.jastor.*;
import java.util.*;
import java.math.*;
*/


/**
 * Implementations of this listener may be registered with instances of ibspan.tss.domain.ontology.location.Location to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface LocationListener extends com.ibm.adtech.jastor.ThingListener {


	/**
	 * Called when a value of indexPoint has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param newValue the object representing the new value
	 */	
	public void indexPointAdded(ibspan.tss.domain.ontology.location.Location source, ibspan.tss.domain.ontology.location.IndexPointCode newValue);

	/**
	 * Called when a value of indexPoint has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param oldValue the object representing the removed value
	 */
	public void indexPointRemoved(ibspan.tss.domain.ontology.location.Location source, ibspan.tss.domain.ontology.location.IndexPointCode oldValue);
		
	/**
	 * Called when locationPath has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void locationPathChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when city has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void cityChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when a value of crossStreet has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param newValue the object representing the new value
	 */	
	public void crossStreetAdded(ibspan.tss.domain.ontology.location.Location source, java.lang.String newValue);

	/**
	 * Called when a value of crossStreet has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param oldValue the object representing the removed value
	 */	
	public void crossStreetRemoved(ibspan.tss.domain.ontology.location.Location source, java.lang.String oldValue);

	/**
	 * Called when a value of attractionCategory has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param newValue the object representing the new value
	 */	
	public void attractionCategoryAdded(ibspan.tss.domain.ontology.location.Location source, ibspan.tss.domain.ontology.location.AttractionCategoryCode newValue);

	/**
	 * Called when a value of attractionCategory has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param oldValue the object representing the removed value
	 */
	public void attractionCategoryRemoved(ibspan.tss.domain.ontology.location.Location source, ibspan.tss.domain.ontology.location.AttractionCategoryCode oldValue);
		
	/**
	 * Called when a value of locationCategory has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param newValue the object representing the new value
	 */	
	public void locationCategoryAdded(ibspan.tss.domain.ontology.location.Location source, ibspan.tss.domain.ontology.location.LocationCategoryCode newValue);

	/**
	 * Called when a value of locationCategory has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param oldValue the object representing the removed value
	 */
	public void locationCategoryRemoved(ibspan.tss.domain.ontology.location.Location source, ibspan.tss.domain.ontology.location.LocationCategoryCode oldValue);
		
	/**
	 * Called when streetAddress has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void streetAddressChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when country has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void countryChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when fax has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void faxChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when state has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void stateChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when a value of phone has been added
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param newValue the object representing the new value
	 */	
	public void phoneAdded(ibspan.tss.domain.ontology.location.Location source, java.lang.String newValue);

	/**
	 * Called when a value of phone has been removed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 * @param oldValue the object representing the removed value
	 */	
	public void phoneRemoved(ibspan.tss.domain.ontology.location.Location source, java.lang.String oldValue);

	/**
	 * Called when neighborhood has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void neighborhoodChanged(ibspan.tss.domain.ontology.location.Location source);

	/**
	 * Called when zip has changed
	 * @param source the affected instance of ibspan.tss.domain.ontology.location.Location
	 */
	public void zipChanged(ibspan.tss.domain.ontology.location.Location source);

}