

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Ordinal ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Ordinal)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Ordinal measure "extends" nominal type by possibility of ordering values according to their rank.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Ordinal extends ibspan.tss.um.ontology.Measure, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Ordinal");
	

	/**
	 * The Jena Property for hasRank 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasRank)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Rank assigned to Ordinal type variable.^^http://www.w3.org/2001/XMLSchema#string <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasRankProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasRank");






	/**
	 * Gets the 'hasRank' property value
	 * @return		{@link java.lang.Integer}
	 * @see			#hasRankProperty
	 */
	public java.lang.Integer getHasRank() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Sets the 'hasRank' property value
	 * @param		{@link java.lang.Integer}
	 * @see			#hasRankProperty
	 */
	public void setHasRank(java.lang.Integer hasRank) throws com.ibm.adtech.jastor.JastorException;

}