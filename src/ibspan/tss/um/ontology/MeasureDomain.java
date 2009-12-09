

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for MeasureDomain ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#MeasureDomain)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Describes domain (set of possible values) for a given measure type.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface MeasureDomain extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#MeasureDomain");
	

	/**
	 * The Jena Property for ofMeasure 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ofMeasure)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Type of an measure (e.g. ordinal), pointed by URI reference to this type.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property ofMeasureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofMeasure");






	/**
	 * Gets the 'ofMeasure' property value
	 * @return		{@link java.lang.String}
	 * @see			#ofMeasureProperty
	 */
	public java.lang.String getOfMeasure() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'ofMeasure' property value
	 * @param		{@link java.lang.String}
	 * @see			#ofMeasureProperty
	 */
	public void setOfMeasure(java.lang.String ofMeasure) throws com.ibm.adtech.jastor.JastorException;

}