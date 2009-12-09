

package ibspan.tss.domain.ontology.location;

import com.ibm.adtech.jastor.*;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Factory for instantiating objects for ontology classes in the Location ontology.  The
 * get methods leave the model unchanged and return a Java view of the object in the model.  The create methods
 * may add certain baseline properties to the model such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Domain ontology of general Location concept for Travel Support System.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * Dublin Core Standard Properties <br>
 * 	creator : Michal Szymczak^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	title : Domain ontology of general Location concept for Travel Support System.^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	rights : (c) 2006 Michal Szymczak^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	identifier : http://www.ibspan.waw.pl/tss/Location^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	date : 2006-08-22^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	contributor : Maciej Gawinecki, e-mail: maciej.gawinecki@ibspan.waw.pl^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 *	@version TODO: ^^http://www.w3.org/2001/XMLSchema#string
 */
public class LocationFactory extends com.ibm.adtech.jastor.ThingFactory { 



	/**
	 * Create a new instance of Location.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Location
	 * @param model the Jena Model.
	 */
	public static Location createLocation(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.location.LocationImpl.createLocation(resource,model);
	}
	
	/**
	 * Create a new instance of Location.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Location
	 * @param model the Jena Model.
	 */
	public static Location createLocation(String uri, Model model) throws JastorException {
		Location obj = ibspan.tss.domain.ontology.location.LocationImpl.createLocation(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Location.  Leaves the model unchanged.
	 * @param uri The uri of the Location
	 * @param model the Jena Model.
	 */
	public static Location getLocation(String uri, Model model) throws JastorException {
		return getLocation(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Location.  Leaves the model unchanged.
	 * @param resource The resource of the Location
	 * @param model the Jena Model.
	 */
	public static Location getLocation(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.location.Location.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.location.LocationImpl obj = (ibspan.tss.domain.ontology.location.LocationImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.location.LocationImpl.getLocation(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Location for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Location#Location
	 * @param model the Jena Model
	 * @return a List of Location
	 */
	public static java.util.List getAllLocation(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Location.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getLocation(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of IndexPointCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the IndexPointCode
	 * @param model the Jena Model.
	 */
	public static IndexPointCode createIndexPointCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.location.IndexPointCodeImpl.createIndexPointCode(resource,model);
	}
	
	/**
	 * Create a new instance of IndexPointCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the IndexPointCode
	 * @param model the Jena Model.
	 */
	public static IndexPointCode createIndexPointCode(String uri, Model model) throws JastorException {
		IndexPointCode obj = ibspan.tss.domain.ontology.location.IndexPointCodeImpl.createIndexPointCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of IndexPointCode.  Leaves the model unchanged.
	 * @param uri The uri of the IndexPointCode
	 * @param model the Jena Model.
	 */
	public static IndexPointCode getIndexPointCode(String uri, Model model) throws JastorException {
		return getIndexPointCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of IndexPointCode.  Leaves the model unchanged.
	 * @param resource The resource of the IndexPointCode
	 * @param model the Jena Model.
	 */
	public static IndexPointCode getIndexPointCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.location.IndexPointCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.location.IndexPointCodeImpl obj = (ibspan.tss.domain.ontology.location.IndexPointCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.location.IndexPointCodeImpl.getIndexPointCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an HighwayExitIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getHighwayExitIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.HighwayExitIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsHighwayExitIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an CityIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getCityIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.CityIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsCityIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an SubwayStationIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getSubwayStationIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.SubwayStationIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsSubwayStationIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an HighwayIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getHighwayIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.HighwayIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsHighwayIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an AirportIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getAirportIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.AirportIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsAirportIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an IntersectionIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getIntersectionIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.IntersectionIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsIntersectionIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an CrossStreetIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getCrossStreetIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.CrossStreetIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsCrossStreetIndexPoint();			
		}
		return obj;
	}
	/** 
	 * Get an RailStationIndexPoint individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of IndexPointCode.
	 */
	public static IndexPointCode getRailStationIndexPoint(Model model) throws JastorException {
		Resource resource = model.createResource(IndexPointCode.RailStationIndexPoint.getURI());
		IndexPointCodeImpl obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
		if (obj == null) {
			createIndexPointCode(resource, model);
			obj = (IndexPointCodeImpl)getIndexPointCode(resource, model);
			obj.initAsRailStationIndexPoint();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of IndexPointCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Location#IndexPointCode
	 * @param model the Jena Model
	 * @return a List of IndexPointCode
	 */
	public static java.util.List getAllIndexPointCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,IndexPointCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getIndexPointCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of AttractionCategoryCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the AttractionCategoryCode
	 * @param model the Jena Model.
	 */
	public static AttractionCategoryCode createAttractionCategoryCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.location.AttractionCategoryCodeImpl.createAttractionCategoryCode(resource,model);
	}
	
	/**
	 * Create a new instance of AttractionCategoryCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the AttractionCategoryCode
	 * @param model the Jena Model.
	 */
	public static AttractionCategoryCode createAttractionCategoryCode(String uri, Model model) throws JastorException {
		AttractionCategoryCode obj = ibspan.tss.domain.ontology.location.AttractionCategoryCodeImpl.createAttractionCategoryCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of AttractionCategoryCode.  Leaves the model unchanged.
	 * @param uri The uri of the AttractionCategoryCode
	 * @param model the Jena Model.
	 */
	public static AttractionCategoryCode getAttractionCategoryCode(String uri, Model model) throws JastorException {
		return getAttractionCategoryCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of AttractionCategoryCode.  Leaves the model unchanged.
	 * @param resource The resource of the AttractionCategoryCode
	 * @param model the Jena Model.
	 */
	public static AttractionCategoryCode getAttractionCategoryCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.location.AttractionCategoryCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.location.AttractionCategoryCodeImpl obj = (ibspan.tss.domain.ontology.location.AttractionCategoryCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.location.AttractionCategoryCodeImpl.getAttractionCategoryCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an StadiumAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getStadiumAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.StadiumAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsStadiumAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an StoreAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getStoreAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.StoreAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsStoreAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an SubwayStationAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getSubwayStationAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.SubwayStationAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsSubwayStationAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CityDowntownAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCityDowntownAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CityDowntownAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCityDowntownAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an TheaterAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getTheaterAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.TheaterAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsTheaterAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an PierAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getPierAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.PierAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsPierAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an BusStationAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getBusStationAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.BusStationAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsBusStationAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an RaceTrackAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getRaceTrackAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.RaceTrackAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsRaceTrackAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CityCenterAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCityCenterAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CityCenterAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCityCenterAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an MarinaAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getMarinaAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.MarinaAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsMarinaAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CityEventAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCityEventAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CityEventAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCityEventAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an TrainStationAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getTrainStationAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.TrainStationAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsTrainStationAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an NightlifeAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getNightlifeAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.NightlifeAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsNightlifeAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an WaterParkAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getWaterParkAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.WaterParkAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsWaterParkAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an FactoryAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getFactoryAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.FactoryAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsFactoryAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an BusinessLocationAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getBusinessLocationAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.BusinessLocationAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsBusinessLocationAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an MonumentAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getMonumentAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.MonumentAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsMonumentAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an EntertainmentDistrictAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getEntertainmentDistrictAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.EntertainmentDistrictAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsEntertainmentDistrictAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ZooAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getZooAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ZooAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsZooAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an SkiAreaAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getSkiAreaAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.SkiAreaAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsSkiAreaAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an WineryAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getWineryAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.WineryAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsWineryAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CemeteryAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCemeteryAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CemeteryAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCemeteryAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an TrolleyStationAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getTrolleyStationAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.TrolleyStationAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsTrolleyStationAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CasinoAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCasinoAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CasinoAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCasinoAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CanalAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCanalAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CanalAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCanalAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an SportsAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getSportsAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.SportsAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsSportsAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an RiverAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getRiverAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.RiverAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsRiverAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an SchoolAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getSchoolAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.SchoolAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsSchoolAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an GalleryAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getGalleryAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.GalleryAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsGalleryAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an OceanAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getOceanAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.OceanAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsOceanAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ParkAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getParkAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ParkAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsParkAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an MarketAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getMarketAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.MarketAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsMarketAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an UniversityAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getUniversityAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.UniversityAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsUniversityAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CollegeAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCollegeAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CollegeAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCollegeAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ConferenceCenterAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getConferenceCenterAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ConferenceCenterAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsConferenceCenterAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an AquariumAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getAquariumAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.AquariumAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsAquariumAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an AmusementParkAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getAmusementParkAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.AmusementParkAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsAmusementParkAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an RestaurantAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getRestaurantAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.RestaurantAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsRestaurantAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an MuseumAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getMuseumAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.MuseumAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsMuseumAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ResortAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getResortAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ResortAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsResortAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an MountainAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getMountainAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.MountainAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsMountainAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an LocalCompanyAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getLocalCompanyAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.LocalCompanyAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsLocalCompanyAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an WaterfrontAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getWaterfrontAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.WaterfrontAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsWaterfrontAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an HospitalAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getHospitalAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.HospitalAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsHospitalAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an LandmarkAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getLandmarkAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.LandmarkAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsLandmarkAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ChurchAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getChurchAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ChurchAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsChurchAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an TournamentAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getTournamentAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.TournamentAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsTournamentAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an FestivalAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getFestivalAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.FestivalAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsFestivalAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an OrchardAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getOrchardAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.OrchardAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsOrchardAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an RecreationCenterAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getRecreationCenterAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.RecreationCenterAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsRecreationCenterAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ShoppingMallAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getShoppingMallAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ShoppingMallAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsShoppingMallAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an BoatDockAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getBoatDockAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.BoatDockAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsBoatDockAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an PalaceAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getPalaceAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.PalaceAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsPalaceAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an HistoricBuildingAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getHistoricBuildingAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.HistoricBuildingAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsHistoricBuildingAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ConventionCenterAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getConventionCenterAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ConventionCenterAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsConventionCenterAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an BeachAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getBeachAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.BeachAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsBeachAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ShoppingAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getShoppingAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ShoppingAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsShoppingAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an ConcertHallAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getConcertHallAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.ConcertHallAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsConcertHallAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an TourAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getTourAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.TourAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsTourAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an BridgeAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getBridgeAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.BridgeAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsBridgeAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an LibraryAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getLibraryAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.LibraryAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsLibraryAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an FairgroundAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getFairgroundAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.FairgroundAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsFairgroundAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an LakeAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getLakeAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.LakeAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsLakeAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an OtherAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getOtherAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.OtherAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsOtherAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an CarRentalLocationAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getCarRentalLocationAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.CarRentalLocationAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsCarRentalLocationAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an FarmAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getFarmAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.FarmAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsFarmAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an AuditoriumAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getAuditoriumAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.AuditoriumAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsAuditoriumAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an AirportAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getAirportAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.AirportAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsAirportAttraction();			
		}
		return obj;
	}
	/** 
	 * Get an StudioAttraction individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AttractionCategoryCode.
	 */
	public static AttractionCategoryCode getStudioAttraction(Model model) throws JastorException {
		Resource resource = model.createResource(AttractionCategoryCode.StudioAttraction.getURI());
		AttractionCategoryCodeImpl obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
		if (obj == null) {
			createAttractionCategoryCode(resource, model);
			obj = (AttractionCategoryCodeImpl)getAttractionCategoryCode(resource, model);
			obj.initAsStudioAttraction();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of AttractionCategoryCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Location#AttractionCategoryCode
	 * @param model the Jena Model
	 * @return a List of AttractionCategoryCode
	 */
	public static java.util.List getAllAttractionCategoryCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,AttractionCategoryCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getAttractionCategoryCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of LocationCategoryCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the LocationCategoryCode
	 * @param model the Jena Model.
	 */
	public static LocationCategoryCode createLocationCategoryCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.location.LocationCategoryCodeImpl.createLocationCategoryCode(resource,model);
	}
	
	/**
	 * Create a new instance of LocationCategoryCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the LocationCategoryCode
	 * @param model the Jena Model.
	 */
	public static LocationCategoryCode createLocationCategoryCode(String uri, Model model) throws JastorException {
		LocationCategoryCode obj = ibspan.tss.domain.ontology.location.LocationCategoryCodeImpl.createLocationCategoryCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of LocationCategoryCode.  Leaves the model unchanged.
	 * @param uri The uri of the LocationCategoryCode
	 * @param model the Jena Model.
	 */
	public static LocationCategoryCode getLocationCategoryCode(String uri, Model model) throws JastorException {
		return getLocationCategoryCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of LocationCategoryCode.  Leaves the model unchanged.
	 * @param resource The resource of the LocationCategoryCode
	 * @param model the Jena Model.
	 */
	public static LocationCategoryCode getLocationCategoryCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.location.LocationCategoryCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.location.LocationCategoryCodeImpl obj = (ibspan.tss.domain.ontology.location.LocationCategoryCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.location.LocationCategoryCodeImpl.getLocationCategoryCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an BeachLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getBeachLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.BeachLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsBeachLocation();			
		}
		return obj;
	}
	/** 
	 * Get an WestLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getWestLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.WestLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsWestLocation();			
		}
		return obj;
	}
	/** 
	 * Get an RuralLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getRuralLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.RuralLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsRuralLocation();			
		}
		return obj;
	}
	/** 
	 * Get an LakeLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getLakeLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.LakeLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsLakeLocation();			
		}
		return obj;
	}
	/** 
	 * Get an DowntownLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getDowntownLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.DowntownLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsDowntownLocation();			
		}
		return obj;
	}
	/** 
	 * Get an GulfLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getGulfLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.GulfLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsGulfLocation();			
		}
		return obj;
	}
	/** 
	 * Get an SuburbanLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getSuburbanLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.SuburbanLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsSuburbanLocation();			
		}
		return obj;
	}
	/** 
	 * Get an ExpresswayLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getExpresswayLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.ExpresswayLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsExpresswayLocation();			
		}
		return obj;
	}
	/** 
	 * Get an NorthLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getNorthLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.NorthLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsNorthLocation();			
		}
		return obj;
	}
	/** 
	 * Get an ResortLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getResortLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.ResortLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsResortLocation();			
		}
		return obj;
	}
	/** 
	 * Get an BeachfrontLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getBeachfrontLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.BeachfrontLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsBeachfrontLocation();			
		}
		return obj;
	}
	/** 
	 * Get an CityLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getCityLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.CityLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsCityLocation();			
		}
		return obj;
	}
	/** 
	 * Get an EastLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getEastLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.EastLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsEastLocation();			
		}
		return obj;
	}
	/** 
	 * Get an OceanfrontLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getOceanfrontLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.OceanfrontLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsOceanfrontLocation();			
		}
		return obj;
	}
	/** 
	 * Get an MountainLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getMountainLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.MountainLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsMountainLocation();			
		}
		return obj;
	}
	/** 
	 * Get an SouthLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getSouthLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.SouthLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsSouthLocation();			
		}
		return obj;
	}
	/** 
	 * Get an AirportLocation individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LocationCategoryCode.
	 */
	public static LocationCategoryCode getAirportLocation(Model model) throws JastorException {
		Resource resource = model.createResource(LocationCategoryCode.AirportLocation.getURI());
		LocationCategoryCodeImpl obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
		if (obj == null) {
			createLocationCategoryCode(resource, model);
			obj = (LocationCategoryCodeImpl)getLocationCategoryCode(resource, model);
			obj.initAsAirportLocation();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of LocationCategoryCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Location#LocationCategoryCode
	 * @param model the Jena Model
	 * @return a List of LocationCategoryCode
	 */
	public static java.util.List getAllLocationCategoryCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,LocationCategoryCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getLocationCategoryCode(stmt.getSubject(),model));
		}
		return list;
	}
	
	
	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(com.hp.hpl.jena.rdf.model.Resource res, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Location#LocationCategoryCode"))) {
			return getLocationCategoryCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Location#AttractionCategoryCode"))) {
			return getAttractionCategoryCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Location#IndexPointCode"))) {
			return getIndexPointCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Location#Location"))) {
			return getLocation(res,model);
		}
		return new ThingImpl(res,model);
	}
	
	/**
	 * Returns an instance of an interface for the given Resource URI.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(String uri, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		return getThing(model.getResource(uri),model);
	}

	/**
	 * Return a list of compatible interfaces for the given type.  Searches through all ontology classes
	 * in the Location ontology.  The list is sorted according to the topological sort
	 * of the class hierarchy
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List listCompatibleInterfaces (com.hp.hpl.jena.rdf.model.Resource type) {
		java.util.List types = new java.util.ArrayList();
		if (type.equals(ibspan.tss.domain.ontology.location.LocationCategoryCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.location.LocationCategoryCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.location.AttractionCategoryCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.location.AttractionCategoryCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.location.IndexPointCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.location.IndexPointCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.location.Location.TYPE)) {
			types.add(ibspan.tss.domain.ontology.location.Location.class);
		}
		return types;
	}
}