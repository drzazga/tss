

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for LayoutStructure ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#LayoutStructure)</p>
 * <br>
 * <br>
 * <br>
 */
public interface LayoutStructure extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#LayoutStructure");
	

	/**
	 * The Jena Property for hasErrorMessage 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasErrorMessage)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasErrorMessageProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasErrorMessage");


	/**
	 * The Jena Property for hasTitle 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasTitle)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasTitleProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasTitle");


	/**
	 * The Jena Property for hasText 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasText)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasTextProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasText");


	/**
	 * The Jena Property for hasMenu 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasMenu)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasMenuProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasMenu");



	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Register2Structure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Register2Structure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Register2Structure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#DetailsStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DetailsStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#DetailsStructure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Login1Structure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Login1Structure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Login1Structure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#DefineSearchStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DefineSearchStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#DefineSearchStructure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#LoginSuccessStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LoginSuccessStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#LoginSuccessStructure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#RegisterSuccessStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource RegisterSuccessStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#RegisterSuccessStructure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#WelcomeStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource WelcomeStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#WelcomeStructure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#LogoutStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LogoutStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#LogoutStructure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#Register1Structure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Register1Structure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#Register1Structure");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#ResultsStructure
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ResultsStructure = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#ResultsStructure");





	/**
	 * Gets the 'hasErrorMessage' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasErrorMessageProperty
	 */
	public java.lang.String getHasErrorMessage() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasErrorMessage' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasErrorMessageProperty
	 */
	public void setHasErrorMessage(java.lang.String hasErrorMessage) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasTitle' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasTitleProperty
	 */
	public java.lang.String getHasTitle() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasTitle' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasTitleProperty
	 */
	public void setHasTitle(java.lang.String hasTitle) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasText' property value
	 * @return		{@link java.lang.String}
	 * @see			#hasTextProperty
	 */
	public java.lang.String getHasText() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasText' property value
	 * @param		{@link java.lang.String}
	 * @see			#hasTextProperty
	 */
	public void setHasText(java.lang.String hasText) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasMenu' property value
	 * @return		{@link ibspan.tss.layout.ontology.datamodel.Menu}
	 * @see			#hasMenuProperty
	 */
	public ibspan.tss.layout.ontology.datamodel.Menu getHasMenu() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasMenu' property value
	 * @param		{@link ibspan.tss.layout.ontology.datamodel.Menu}
	 * @see			#hasMenuProperty
	 */
	public void setHasMenu(ibspan.tss.layout.ontology.datamodel.Menu hasMenu) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasMenu' property value to an anonymous node
	 * @return		{@link ibspan.tss.layout.ontology.datamodel.Menu}, the created value
	 * @see			#hasMenuProperty
	 */	
	public ibspan.tss.layout.ontology.datamodel.Menu setHasMenu() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasMenu' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.layout.ontology.datamodel.Menu} with the factory.
	 * and calling setHasMenu(ibspan.tss.layout.ontology.datamodel.Menu hasMenu)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/DataModel#Menu.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.layout.ontology.datamodel.Menu}, the newly created value
	 * @see			#hasMenuProperty
	 */
	public ibspan.tss.layout.ontology.datamodel.Menu setHasMenu(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}