

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for IntervalSet ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#IntervalSet)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Continues finite set with values of Interval measure type.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface IntervalSet extends ibspan.tss.um.ontology.MeasureSet, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#IntervalSet");
	

	/**
	 * The Jena Property for hasRightBound 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasRightBound)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Right bound of a set.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasRightBoundProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasRightBound");


	/**
	 * The Jena Property for hasLeftBound 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasLeftBound)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Left bound of a set.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasLeftBoundProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasLeftBound");






	/**
	 * Gets the 'hasRightBound' property value
	 * @return		{@link ibspan.tss.um.ontology.Interval}
	 * @see			#hasRightBoundProperty
	 */
	public ibspan.tss.um.ontology.Interval getHasRightBound() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasRightBound' property value
	 * @param		{@link ibspan.tss.um.ontology.Interval}
	 * @see			#hasRightBoundProperty
	 */
	public void setHasRightBound(ibspan.tss.um.ontology.Interval hasRightBound) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasRightBound' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Interval}, the created value
	 * @see			#hasRightBoundProperty
	 */	
	public ibspan.tss.um.ontology.Interval setHasRightBound() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasRightBound' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Interval} with the factory.
	 * and calling setHasRightBound(ibspan.tss.um.ontology.Interval hasRightBound)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Interval.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Interval}, the newly created value
	 * @see			#hasRightBoundProperty
	 */
	public ibspan.tss.um.ontology.Interval setHasRightBound(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'hasLeftBound' property value
	 * @return		{@link ibspan.tss.um.ontology.Interval}
	 * @see			#hasLeftBoundProperty
	 */
	public ibspan.tss.um.ontology.Interval getHasLeftBound() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasLeftBound' property value
	 * @param		{@link ibspan.tss.um.ontology.Interval}
	 * @see			#hasLeftBoundProperty
	 */
	public void setHasLeftBound(ibspan.tss.um.ontology.Interval hasLeftBound) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasLeftBound' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Interval}, the created value
	 * @see			#hasLeftBoundProperty
	 */	
	public ibspan.tss.um.ontology.Interval setHasLeftBound() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasLeftBound' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Interval} with the factory.
	 * and calling setHasLeftBound(ibspan.tss.um.ontology.Interval hasLeftBound)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Interval.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Interval}, the newly created value
	 * @see			#hasLeftBoundProperty
	 */
	public ibspan.tss.um.ontology.Interval setHasLeftBound(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}