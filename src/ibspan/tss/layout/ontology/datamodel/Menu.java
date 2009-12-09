

package ibspan.tss.layout.ontology.datamodel;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Menu ontology class<br>
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#Menu)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Menu extends ibspan.tss.layout.ontology.datamodel.LayoutElement, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/DataModel#Menu");
	

	/**
	 * The Jena Property for hasLink 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#hasLink)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasLinkProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasLink");



	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#DefineSearchMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DefineSearchMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#DefineSearchMenu");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#ResultsMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ResultsMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#ResultsMenu");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#WelcomeMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource WelcomeMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#WelcomeMenu");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#LoginSuccessMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LoginSuccessMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#LoginSuccessMenu");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#CommonMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CommonMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#CommonMenu");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#LoginMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LoginMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#LoginMenu");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/db/Templates#DetailsMenu
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DetailsMenu = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/db/Templates#DetailsMenu");





	/**
	 * Get an Iterator the 'hasLink' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.layout.ontology.datamodel.Link}
	 * @see			#hasLinkProperty
	 */
	public java.util.Iterator getHasLink() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'hasLink' property
	 * @param		The {@link ibspan.tss.layout.ontology.datamodel.Link} to add
	 * @see			#hasLinkProperty
	 */
	public void addHasLink(ibspan.tss.layout.ontology.datamodel.Link hasLink) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'hasLink' property
	 * @return		The anoymous {@link ibspan.tss.layout.ontology.datamodel.Link} created
	 * @see			#hasLinkProperty
	 */
	public ibspan.tss.layout.ontology.datamodel.Link addHasLink() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'hasLink' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.layout.ontology.datamodel.Link} with the factory
	 * and calling addHasLink(ibspan.tss.layout.ontology.datamodel.Link hasLink)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/DataModel#Link.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#hasLinkProperty
	 */
	public ibspan.tss.layout.ontology.datamodel.Link addHasLink(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'hasLink' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.layout.ontology.datamodel.Link} to remove
	 * @see			#hasLinkProperty
	 */
	public void removeHasLink(ibspan.tss.layout.ontology.datamodel.Link hasLink) throws com.ibm.adtech.jastor.JastorException;
		
}