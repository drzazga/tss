

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Link ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#Link)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Link extends ibspan.tss.layout.ontology.datamodel.LayoutElement, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#Link");
	

	/**
	 * The Jena Property for hasLabel 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasLabel)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasLabelProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasLabel");


	/**
	 * The Jena Property for hasActionName 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasActionName)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasActionNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasActionName");






	/**
	 * Gets the 'hasLabel' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasLabelProperty
	 */
	public java.lang.String getHasLabel() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasLabel' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasLabelProperty
	 */
	public void setHasLabel(java.lang.String hasLabel) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasActionName' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasActionNameProperty
	 */
	public java.lang.String getHasActionName() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasActionName' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasActionNameProperty
	 */
	public void setHasActionName(java.lang.String hasActionName) throws com.ibm.adtech.jastor.JastorException;

}