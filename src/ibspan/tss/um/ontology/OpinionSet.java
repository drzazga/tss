

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for OpinionSet ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#OpinionSet)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Set of person opinions.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface OpinionSet extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#OpinionSet");
	

	/**
	 * The Jena Property for containsOpinion 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#containsOpinion)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property containsOpinionProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#containsOpinion");


	/**
	 * The Jena Property for wasChanged 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#wasChanged)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : date of last change of the opinions set^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property wasChangedProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#wasChanged");






	/**
	 * Get an Iterator the 'containsOpinion' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.um.ontology.Opinion}
	 * @see			#containsOpinionProperty
	 */
	public java.util.Iterator getContainsOpinion() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'containsOpinion' property
	 * @param		The {@link ibspan.tss.um.ontology.Opinion} to add
	 * @see			#containsOpinionProperty
	 */
	public void addContainsOpinion(ibspan.tss.um.ontology.Opinion containsOpinion) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'containsOpinion' property
	 * @return		The anoymous {@link ibspan.tss.um.ontology.Opinion} created
	 * @see			#containsOpinionProperty
	 */
	public ibspan.tss.um.ontology.Opinion addContainsOpinion() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'containsOpinion' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Opinion} with the factory
	 * and calling addContainsOpinion(ibspan.tss.um.ontology.Opinion containsOpinion)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Opinion.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#containsOpinionProperty
	 */
	public ibspan.tss.um.ontology.Opinion addContainsOpinion(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'containsOpinion' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.um.ontology.Opinion} to remove
	 * @see			#containsOpinionProperty
	 */
	public void removeContainsOpinion(ibspan.tss.um.ontology.Opinion containsOpinion) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Gets the 'wasChanged' property value
	 * @return		{@link com.hp.hpl.jena.datatypes.xsd.XSDDateTime}
	 * @see			#wasChangedProperty
	 */
	public com.hp.hpl.jena.datatypes.xsd.XSDDateTime getWasChanged() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'wasChanged' property value
	 * @param		{@link com.hp.hpl.jena.datatypes.xsd.XSDDateTime}
	 * @see			#wasChangedProperty
	 */
	public void setWasChanged(com.hp.hpl.jena.datatypes.xsd.XSDDateTime wasChanged) throws com.ibm.adtech.jastor.JastorException;

}