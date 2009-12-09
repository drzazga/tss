

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for NominalSet ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#NominalSet)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Set containing values of Nominal type measure.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface NominalSet extends ibspan.tss.um.ontology.MeasureSet, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#NominalSet");
	

	/**
	 * The Jena Property for contains 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#contains)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property containsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#contains");






	/**
	 * Get an Iterator the 'contains' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.um.ontology.Measure}
	 * @see			#containsProperty
	 */
	public java.util.Iterator getContains() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'contains' property
	 * @param		The {@link ibspan.tss.um.ontology.Measure} to add
	 * @see			#containsProperty
	 */
	public void addContains(ibspan.tss.um.ontology.Measure contains) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'contains' property
	 * @return		The anoymous {@link ibspan.tss.um.ontology.Measure} created
	 * @see			#containsProperty
	 */
	public ibspan.tss.um.ontology.Measure addContains() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'contains' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Measure} with the factory
	 * and calling addContains(ibspan.tss.um.ontology.Measure contains)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Measure.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#containsProperty
	 */
	public ibspan.tss.um.ontology.Measure addContains(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'contains' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.um.ontology.Measure} to remove
	 * @see			#containsProperty
	 */
	public void removeContains(ibspan.tss.um.ontology.Measure contains) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'contains' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link ibspan.tss.um.ontology.Nominal}
	 * @see			#containsProperty
	 */
	public java.util.Iterator getContains_asNominal() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'contains' property
	 * @param		The {@link ibspan.tss.um.ontology.Nominal} to add
	 * @see			#containsProperty
	 */
	public void addContains(ibspan.tss.um.ontology.Nominal contains) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'contains' property
	 * @return		The anoymous {@link ibspan.tss.um.ontology.Nominal} created
	 * @see			#containsProperty
	 */
	public ibspan.tss.um.ontology.Nominal addContains_asNominal() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'contains' property.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Nominal} with the factory
	 * and calling addContains(ibspan.tss.um.ontology.Nominal contains)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Nominal.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#containsProperty
	 */
	public ibspan.tss.um.ontology.Nominal addContains_asNominal(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'contains' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link ibspan.tss.um.ontology.Nominal} to remove
	 * @see			#containsProperty
	 */
	public void removeContains(ibspan.tss.um.ontology.Nominal contains) throws com.ibm.adtech.jastor.JastorException;
		
}