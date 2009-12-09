

package ibspan.tss.domain.ontology.location;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for IndexPointCode ontology class<br>
 * Use the ibspan.tss.domain.ontology.location.LocationFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#IndexPointCode)</p>
 * <br>
 * <br>
 * <br>
 */
public interface IndexPointCode extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#IndexPointCode");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#HighwayExitIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource HighwayExitIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#HighwayExitIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#CityIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CityIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#CityIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#SubwayStationIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource SubwayStationIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#SubwayStationIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#HighwayIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource HighwayIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#HighwayIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#AirportIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AirportIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#AirportIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#IntersectionIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource IntersectionIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#IntersectionIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#CrossStreetIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CrossStreetIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#CrossStreetIndexPoint");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Location#RailStationIndexPoint
	 */
	public static com.hp.hpl.jena.rdf.model.Resource RailStationIndexPoint = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Location#RailStationIndexPoint");





}