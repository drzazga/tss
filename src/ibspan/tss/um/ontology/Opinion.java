

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Opinion ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Opinion)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Defines opinion of a person.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Opinion extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Opinion");
	

	/**
	 * The Jena Property for atIndividualProbability 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#atIndividualProbability)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Individual probability of interest in a given concept.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property atIndividualProbabilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#atIndividualProbability");


	/**
	 * The Jena Property for atInferredProbability 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#atInferredProbability)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Inferred probability of interest in a given concept, concluded form dependencies between concepts in domain ontology.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property atInferredProbabilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#atInferredProbability");


	/**
	 * The Jena Property for atNormalizedProbability 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#atNormalizedProbability)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Normalized probabilty of interest in a given concept in relation to interest of population in this concept.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property atNormalizedProbabilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#atNormalizedProbability");


	/**
	 * The Jena Property for hasClassification 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasClassification)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Describes, who this opinion has been classified by the learning algorithm.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasClassificationProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasClassification");


	/**
	 * The Jena Property for isAbout 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#isAbout)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Concepts being the object of this opinion.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property isAboutProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#isAbout");






	/**
	 * Gets the 'atIndividualProbability' property value
	 * @return		{@link java.lang.Double}
	 * @see			#atIndividualProbabilityProperty
	 */
	public java.lang.Double getAtIndividualProbability() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'atIndividualProbability' property value
	 * @param		{@link java.lang.Double}
	 * @see			#atIndividualProbabilityProperty
	 */
	public void setAtIndividualProbability(java.lang.Double atIndividualProbability) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'atInferredProbability' property value
	 * @return		{@link java.lang.Double}
	 * @see			#atInferredProbabilityProperty
	 */
	public java.lang.Double getAtInferredProbability() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'atInferredProbability' property value
	 * @param		{@link java.lang.Double}
	 * @see			#atInferredProbabilityProperty
	 */
	public void setAtInferredProbability(java.lang.Double atInferredProbability) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'atNormalizedProbability' property value
	 * @return		{@link java.lang.Double}
	 * @see			#atNormalizedProbabilityProperty
	 */
	public java.lang.Double getAtNormalizedProbability() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'atNormalizedProbability' property value
	 * @param		{@link java.lang.Double}
	 * @see			#atNormalizedProbabilityProperty
	 */
	public void setAtNormalizedProbability(java.lang.Double atNormalizedProbability) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Gets the 'hasClassification' property value
	 * @return		{@link ibspan.tss.um.ontology.Classification}
	 * @see			#hasClassificationProperty
	 */
	public ibspan.tss.um.ontology.Classification getHasClassification() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasClassification' property value
	 * @param		{@link ibspan.tss.um.ontology.Classification}
	 * @see			#hasClassificationProperty
	 */
	public void setHasClassification(ibspan.tss.um.ontology.Classification hasClassification) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasClassification' property value to an anonymous node
	 * @return		{@link ibspan.tss.um.ontology.Classification}, the created value
	 * @see			#hasClassificationProperty
	 */	
	public ibspan.tss.um.ontology.Classification setHasClassification() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Sets the 'hasClassification' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link ibspan.tss.um.ontology.Classification} with the factory.
	 * and calling setHasClassification(ibspan.tss.um.ontology.Classification hasClassification)
	 * The resource argument have rdf:type http://www.ibspan.waw.pl/tss/UserModelling#Classification.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Resource} must not be be null.
	 * @return		{@link ibspan.tss.um.ontology.Classification}, the newly created value
	 * @see			#hasClassificationProperty
	 */
	public ibspan.tss.um.ontology.Classification setHasClassification(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Gets the 'isAbout' property value
	 * @return		{@link java.lang.String}
	 * @see			#isAboutProperty
	 */
	public java.lang.String getIsAbout() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'isAbout' property value
	 * @param		{@link java.lang.String}
	 * @see			#isAboutProperty
	 */
	public void setIsAbout(java.lang.String isAbout) throws com.ibm.adtech.jastor.JastorException;

}