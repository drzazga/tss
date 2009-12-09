

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Interval ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Interval)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Interval measure has values that belong to the linear scale and thus we can compute the distance measure directly^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Interval extends ibspan.tss.um.ontology.Measure, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Interval");
	

	/**
	 * The Jena Property for mapsLinearValue 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#mapsLinearValue)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Maps abstract value to a real number.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property mapsLinearValueProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#mapsLinearValue");






	/**
	 * Gets the 'mapsLinearValue' property value
	 * @return		{@link java.lang.Double}
	 * @see			#mapsLinearValueProperty
	 */
	public java.lang.Double getMapsLinearValue() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'mapsLinearValue' property value
	 * @param		{@link java.lang.Double}
	 * @see			#mapsLinearValueProperty
	 */
	public void setMapsLinearValue(java.lang.Double mapsLinearValue) throws com.ibm.adtech.jastor.JastorException;

}