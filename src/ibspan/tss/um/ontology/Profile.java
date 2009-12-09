

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Profile ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Profile)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Profile of a user or stereotype.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Profile extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Profile");
	

	/**
	 * The Jena Property for hasOpinions 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasOpinions)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasOpinionsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasOpinions");






	/**
	 * Gets the 'hasOpinions' property value
	 * @return		{@link ibspan.tss.um.ontology.OpinionSet}
	 * @see			#hasOpinionsProperty
	 */
	public ibspan.tss.um.ontology.OpinionSet getHasOpinions() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasOpinions' property value
	 * @param		{@link ibspan.tss.um.ontology.OpinionSet}
	 * @see			#hasOpinionsProperty
	 */
	public void setHasOpinions(ibspan.tss.um.ontology.OpinionSet hasOpinions) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasOpinions' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.OpinionSet}, the created value
	 * @see			#hasOpinionsProperty
	 */	
	public ibspan.tss.um.ontology.OpinionSet setHasOpinions() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasOpinions' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.OpinionSet} with the factory.
	 * and calling setHasOpinions(ibspan.tss.um.ontology.OpinionSet hasOpinions)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#OpinionSet.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.OpinionSet}, the newly created value
	 * @see			#hasOpinionsProperty
	 */
	public ibspan.tss.um.ontology.OpinionSet setHasOpinions(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
}