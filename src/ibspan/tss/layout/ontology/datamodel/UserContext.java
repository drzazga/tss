

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for UserContext ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#UserContext)</p>
 * <br>
 * <br>
 * <br>
 */
public interface UserContext extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#UserContext");
	

	/**
	 * The Jena Property for hasSessionID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasSessionID)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasSessionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasSessionID");


	/**
	 * The Jena Property for hasUserID 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasUserID)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasUserID");


	/**
	 * The Jena Property for hasInterfaceHost 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasInterfaceHost)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasInterfaceHostProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasInterfaceHost");


	/**
	 * The Jena Property for hasMediaType 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasMediaType)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasMediaTypeProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasMediaType");


	/**
	 * The Jena Property for hasInterfacePort 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasInterfacePort)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasInterfacePortProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasInterfacePort");






	/**
	 * Gets the 'hasSessionID' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasSessionIDProperty
	 */
	public java.lang.String getHasSessionID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasSessionID' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasSessionIDProperty
	 */
	public void setHasSessionID(java.lang.String hasSessionID) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasUserID' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasUserIDProperty
	 */
	public java.lang.Integer getHasUserID() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasUserID' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasUserIDProperty
	 */
	public void setHasUserID(java.lang.Integer hasUserID) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasInterfaceHost' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasInterfaceHostProperty
	 */
	public java.lang.String getHasInterfaceHost() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasInterfaceHost' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasInterfaceHostProperty
	 */
	public void setHasInterfaceHost(java.lang.String hasInterfaceHost) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasMediaType' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasMediaTypeProperty
	 */
	public java.lang.String getHasMediaType() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasMediaType' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasMediaTypeProperty
	 */
	public void setHasMediaType(java.lang.String hasMediaType) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasInterfacePort' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasInterfacePortProperty
	 */
	public java.lang.Integer getHasInterfacePort() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasInterfacePort' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasInterfacePortProperty
	 */
	public void setHasInterfacePort(java.lang.Integer hasInterfacePort) throws com.ibm.adtech.jastor.JastorException;

}