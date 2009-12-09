

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for StatisticsMap ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StatisticsMap)</p>
 * <br>
 * <br>
 * <br>
 */
public interface StatisticsMap extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#StatisticsMap");
	

	/**
	 * The Jena Property for hasStatisticsEntry 
	 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#hasStatisticsEntry)</p>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property hasStatisticsEntryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasStatisticsEntry");






	/**
	 * Get an Iterator the 'hasStatisticsEntry' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.ibm.adtech.jastor.Thing}
	 * @see			#hasStatisticsEntryProperty
	 */
	public java.util.Iterator getHasStatisticsEntry() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'hasStatisticsEntry' property
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to add
	 * @see			#hasStatisticsEntryProperty
	 */
	public void addHasStatisticsEntry(com.ibm.adtech.jastor.Thing hasStatisticsEntry) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'hasStatisticsEntry' property
	 * @return		The anoymous {@link com.ibm.adtech.jastor.Thing} created
	 * @see			#hasStatisticsEntryProperty
	 */
	public com.ibm.adtech.jastor.Thing addHasStatisticsEntry() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds a value for the 'hasStatisticsEntry' property.  This
	 * method is equivalent constructing a new instance of {@link com.ibm.adtech.jastor.Thing} with the factory
	 * and calling addHasStatisticsEntry(com.ibm.adtech.jastor.Thing hasStatisticsEntry)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#hasStatisticsEntryProperty
	 */
	public com.ibm.adtech.jastor.Thing addHasStatisticsEntry(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'hasStatisticsEntry' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to remove
	 * @see			#hasStatisticsEntryProperty
	 */
	public void removeHasStatisticsEntry(com.ibm.adtech.jastor.Thing hasStatisticsEntry) throws com.ibm.adtech.jastor.JastorException;
		
}