

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for RatedResource ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#RatedResource)</p>
 * <br>
 * <br>
 * <br>
 */
public interface RatedResource extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#RatedResource");
	

	/**
	 * The Jena Property for hasRate 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasRate)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasRateProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasRate");


	/**
	 * The Jena Property for ofResource 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ofResource)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property ofResourceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofResource");






	/**
	 * Gets the 'hasRate' property value
	 * @return		{@link java.lang.Double}
	 * @see			#hasRateProperty
	 */
	public java.lang.Double getHasRate() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasRate' property value
	 * @param		{@link java.lang.Double}
	 * @see			#hasRateProperty
	 */
	public void setHasRate(java.lang.Double hasRate) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'ofResource' property value
	 * @return		{@link java.lang.String}
	 * @see			#ofResourceProperty
	 */
	public java.lang.String getOfResource() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'ofResource' property value
	 * @param		{@link java.lang.String}
	 * @see			#ofResourceProperty
	 */
	public void setOfResource(java.lang.String ofResource) throws com.ibm.adtech.jastor.JastorException;

}