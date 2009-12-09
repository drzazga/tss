

package ibspan.tss.domain.ontology.location;

/*
import com.hp.hpl.jena.datatypes.xsd.*;
import com.hp.hpl.jena.datatypes.xsd.impl.*;
*/
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.rdf.listeners.StatementListener;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.*;
import com.ibm.adtech.jastor.util.*;


/**
 * Implementation of {@link ibspan.tss.domain.ontology.location.AttractionCategoryCode}
 * Use the ibspan.tss.domain.ontology.location.LocationFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#AttractionCategoryCode)</p>
 * <br>
 */
public class AttractionCategoryCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.location.AttractionCategoryCode {
	


	AttractionCategoryCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static AttractionCategoryCodeImpl getAttractionCategoryCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,AttractionCategoryCode.TYPE))
			return null;
		return new AttractionCategoryCodeImpl(resource, model);
	}
	    
	static AttractionCategoryCodeImpl createAttractionCategoryCode(Resource resource, Model model) throws JastorException {
		AttractionCategoryCodeImpl impl = new AttractionCategoryCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, AttractionCategoryCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, AttractionCategoryCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsStadiumAttraction() throws JastorException {
	}

	void initAsStoreAttraction() throws JastorException {
	}

	void initAsSubwayStationAttraction() throws JastorException {
	}

	void initAsCityDowntownAttraction() throws JastorException {
	}

	void initAsTheaterAttraction() throws JastorException {
	}

	void initAsPierAttraction() throws JastorException {
	}

	void initAsBusStationAttraction() throws JastorException {
	}

	void initAsRaceTrackAttraction() throws JastorException {
	}

	void initAsCityCenterAttraction() throws JastorException {
	}

	void initAsMarinaAttraction() throws JastorException {
	}

	void initAsCityEventAttraction() throws JastorException {
	}

	void initAsTrainStationAttraction() throws JastorException {
	}

	void initAsNightlifeAttraction() throws JastorException {
	}

	void initAsWaterParkAttraction() throws JastorException {
	}

	void initAsFactoryAttraction() throws JastorException {
	}

	void initAsBusinessLocationAttraction() throws JastorException {
	}

	void initAsMonumentAttraction() throws JastorException {
	}

	void initAsEntertainmentDistrictAttraction() throws JastorException {
	}

	void initAsZooAttraction() throws JastorException {
	}

	void initAsSkiAreaAttraction() throws JastorException {
	}

	void initAsWineryAttraction() throws JastorException {
	}

	void initAsCemeteryAttraction() throws JastorException {
	}

	void initAsTrolleyStationAttraction() throws JastorException {
	}

	void initAsCasinoAttraction() throws JastorException {
	}

	void initAsCanalAttraction() throws JastorException {
	}

	void initAsSportsAttraction() throws JastorException {
	}

	void initAsRiverAttraction() throws JastorException {
	}

	void initAsSchoolAttraction() throws JastorException {
	}

	void initAsGalleryAttraction() throws JastorException {
	}

	void initAsOceanAttraction() throws JastorException {
	}

	void initAsParkAttraction() throws JastorException {
	}

	void initAsMarketAttraction() throws JastorException {
	}

	void initAsUniversityAttraction() throws JastorException {
	}

	void initAsCollegeAttraction() throws JastorException {
	}

	void initAsConferenceCenterAttraction() throws JastorException {
	}

	void initAsAquariumAttraction() throws JastorException {
	}

	void initAsAmusementParkAttraction() throws JastorException {
	}

	void initAsRestaurantAttraction() throws JastorException {
	}

	void initAsMuseumAttraction() throws JastorException {
	}

	void initAsResortAttraction() throws JastorException {
	}

	void initAsMountainAttraction() throws JastorException {
	}

	void initAsLocalCompanyAttraction() throws JastorException {
	}

	void initAsWaterfrontAttraction() throws JastorException {
	}

	void initAsHospitalAttraction() throws JastorException {
	}

	void initAsLandmarkAttraction() throws JastorException {
	}

	void initAsChurchAttraction() throws JastorException {
	}

	void initAsTournamentAttraction() throws JastorException {
	}

	void initAsFestivalAttraction() throws JastorException {
	}

	void initAsOrchardAttraction() throws JastorException {
	}

	void initAsRecreationCenterAttraction() throws JastorException {
	}

	void initAsShoppingMallAttraction() throws JastorException {
	}

	void initAsBoatDockAttraction() throws JastorException {
	}

	void initAsPalaceAttraction() throws JastorException {
	}

	void initAsHistoricBuildingAttraction() throws JastorException {
	}

	void initAsConventionCenterAttraction() throws JastorException {
	}

	void initAsBeachAttraction() throws JastorException {
	}

	void initAsShoppingAttraction() throws JastorException {
	}

	void initAsConcertHallAttraction() throws JastorException {
	}

	void initAsTourAttraction() throws JastorException {
	}

	void initAsBridgeAttraction() throws JastorException {
	}

	void initAsLibraryAttraction() throws JastorException {
	}

	void initAsFairgroundAttraction() throws JastorException {
	}

	void initAsLakeAttraction() throws JastorException {
	}

	void initAsOtherAttraction() throws JastorException {
	}

	void initAsCarRentalLocationAttraction() throws JastorException {
	}

	void initAsFarmAttraction() throws JastorException {
	}

	void initAsAuditoriumAttraction() throws JastorException {
	}

	void initAsAirportAttraction() throws JastorException {
	}

	void initAsStudioAttraction() throws JastorException {
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.domain.ontology.location.LocationFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.location.AttractionCategoryCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof AttractionCategoryCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of AttractionCategoryCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((AttractionCategoryCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof AttractionCategoryCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of AttractionCategoryCodeListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
		}

	//}
	


}