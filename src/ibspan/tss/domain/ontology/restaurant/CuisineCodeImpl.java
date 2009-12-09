

package ibspan.tss.domain.ontology.restaurant;

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.CuisineCode}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#CuisineCode)</p>
 * <br>
 */
public class CuisineCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.CuisineCode {
	


	CuisineCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static CuisineCodeImpl getCuisineCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,CuisineCode.TYPE))
			return null;
		return new CuisineCodeImpl(resource, model);
	}
	    
	static CuisineCodeImpl createCuisineCode(Resource resource, Model model) throws JastorException {
		CuisineCodeImpl impl = new CuisineCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, CuisineCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, CuisineCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsSwissCuisine() throws JastorException {
	}

	void initAsSoulFoodCuisine() throws JastorException {
	}

	void initAsJapaneseCuisine() throws JastorException {
	}

	void initAsSouthernCuisine() throws JastorException {
	}

	void initAsCUICuisine() throws JastorException {
	}

	void initAsArgentineanCuisine() throws JastorException {
	}

	void initAsChileanCuisine() throws JastorException {
	}

	void initAsBrasserieCuisine() throws JastorException {
	}

	void initAsRussianUkrainianCuisine() throws JastorException {
	}

	void initAsThaiCuisine() throws JastorException {
	}

	void initAsSpanishCuisine() throws JastorException {
	}

	void initAsSouthAmericanCuisine() throws JastorException {
	}

	void initAsMediterraneanCuisine() throws JastorException {
	}

	void initAsScandinavianCuisine() throws JastorException {
	}

	void initAsDimSumCuisine() throws JastorException {
	}

	void initAsEclecticCuisine() throws JastorException {
	}

	void initAsIrishCuisine() throws JastorException {
	}

	void initAsCanadianCuisine() throws JastorException {
	}

	void initAsHotDogsCuisine() throws JastorException {
	}

	void initAsSushiCuisine() throws JastorException {
	}

	void initAsTexNexCuisine() throws JastorException {
	}

	void initAsKosherCuisine() throws JastorException {
	}

	void initAsArmenianCuisine() throws JastorException {
	}

	void initAsSandwichesCuisine() throws JastorException {
	}

	void initAsPeruvianCuisine() throws JastorException {
	}

	void initAsBagelsCuisine() throws JastorException {
	}

	void initAsCambodianCuisine() throws JastorException {
	}

	void initAsSardinianCuisine() throws JastorException {
	}

	void initAsIndianCuisine() throws JastorException {
	}

	void initAsFusionCuisine() throws JastorException {
	}

	void initAsCaliforniaCuisine() throws JastorException {
	}

	void initAsScottishCuisine() throws JastorException {
	}

	void initAsCatalanCuisine() throws JastorException {
	}

	void initAsCreoleCuisine() throws JastorException {
	}

	void initAsCafeteriaCuisine() throws JastorException {
	}

	void initAsLatinAmericanCuisine() throws JastorException {
	}

	void initAsCafeCoffeeShopCuisine() throws JastorException {
	}

	void initAsSaharanCuisine() throws JastorException {
	}

	void initAsBurgersCuisine() throws JastorException {
	}

	void initAsContemporaryCuisine() throws JastorException {
	}

	void initAsMoroccanCuisine() throws JastorException {
	}

	void initAsFastFoodCuisine() throws JastorException {
	}

	void initAsSwedishCuisine() throws JastorException {
	}

	void initAsTeaHouseCuisine() throws JastorException {
	}

	void initAsHungarianCuisine() throws JastorException {
	}

	void initAsBarPubBreweryCuisine() throws JastorException {
	}

	void initAsBritishCuisine() throws JastorException {
	}

	void initAsGameCuisine() throws JastorException {
	}

	void initAsCambodgianCuisine() throws JastorException {
	}

	void initAsAsianCuisine() throws JastorException {
	}

	void initAsNorthAmericanCuisine() throws JastorException {
	}

	void initAsAmericanCuisine() throws JastorException {
	}

	void initAsVegetarianCuisine() throws JastorException {
	}

	void initAsDoughnutsCuisine() throws JastorException {
	}

	void initAsHawaiianCuisine() throws JastorException {
	}

	void initAsBurmeseCuisine() throws JastorException {
	}

	void initAsFilipinoCuisine() throws JastorException {
	}

	void initAsBreakfastBrunchCuisine() throws JastorException {
	}

	void initAsItalianCuisine() throws JastorException {
	}

	void initAsIcecreamParlourCuis() throws JastorException {
	}

	void initAsOrganicHealthyCuisine() throws JastorException {
	}

	void initAsCajunCreoleCuisine() throws JastorException {
	}

	void initAsBrazilianCuisine() throws JastorException {
	}

	void initAsBasqueCuisine() throws JastorException {
	}

	void initAsVietnameseCuisine() throws JastorException {
	}

	void initAsGermanCuisine() throws JastorException {
	}

	void initAsModernEuropeanCuisine() throws JastorException {
	}

	void initAsRegionalCuisine() throws JastorException {
	}

	void initAsDessertIceCreamCuisine() throws JastorException {
	}

	void initAsPortugueseCuisine() throws JastorException {
	}

	void initAsIndigenousCuisine() throws JastorException {
	}

	void initAsChineseCuisine() throws JastorException {
	}

	void initAsDutchBelgianCuisine() throws JastorException {
	}

	void initAsSoupCuisine() throws JastorException {
	}

	void initAsDanishCuisine() throws JastorException {
	}

	void initAsKoreanCuisine() throws JastorException {
	}

	void initAsPizzaCuisine() throws JastorException {
	}

	void initAsMongolianCuisine() throws JastorException {
	}

	void initAsEthiopianCuisine() throws JastorException {
	}

	void initAsCaribbeanCuisine() throws JastorException {
	}

	void initAsContinentalEuropeanCusine() throws JastorException {
	}

	void initAsSeafoodCuisine() throws JastorException {
	}

	void initAsBarbecueCuisine() throws JastorException {
	}

	void initAsAustrianCuisine() throws JastorException {
	}

	void initAsMalaysianCuisine() throws JastorException {
	}

	void initAsIndianPakistaniCuis() throws JastorException {
	}

	void initAsSteakHousesCuisine() throws JastorException {
	}

	void initAsNepaleseCuisine() throws JastorException {
	}

	void initAsEnglishCuisine() throws JastorException {
	}

	void initAsPolynesianCuisine() throws JastorException {
	}

	void initAsTurkishCuisine() throws JastorException {
	}

	void initAsJamaicanCuisine() throws JastorException {
	}

	void initAsBakeryCuisine() throws JastorException {
	}

	void initAsMiddleEasternCuisine() throws JastorException {
	}

	void initAsOtherCuisine() throws JastorException {
	}

	void initAsBiologicalCuisine() throws JastorException {
	}

	void initAsMexicanCuisine() throws JastorException {
	}

	void initAsEasternEuropeanCuisine() throws JastorException {
	}

	void initAsRussianCuisine() throws JastorException {
	}

	void initAsFamilyCuisine() throws JastorException {
	}

	void initAsPolishCuisine() throws JastorException {
	}

	void initAsCubanCuisine() throws JastorException {
	}

	void initAsCentralEuropeanCuisine() throws JastorException {
	}

	void initAsTunisianCuisine() throws JastorException {
	}

	void initAsInternationalCuisin() throws JastorException {
	}

	void initAsTapasCuisine() throws JastorException {
	}

	void initAsHamburgerCuisine() throws JastorException {
	}

	void initAsIsraeliCuisine() throws JastorException {
	}

	void initAsSeychellesCuisine() throws JastorException {
	}

	void initAsPacificRimCuisine() throws JastorException {
	}

	void initAsFineDiningCuisine() throws JastorException {
	}

	void initAsGreekCuisine() throws JastorException {
	}

	void initAsReunionCuisine() throws JastorException {
	}

	void initAsAfghanCuisine() throws JastorException {
	}

	void initAsBelgianCuisine() throws JastorException {
	}

	void initAsSteaksCuisine() throws JastorException {
	}

	void initAsDinerCuisine() throws JastorException {
	}

	void initAsNorthAfricanCuisine() throws JastorException {
	}

	void initAsJuiceCuisine() throws JastorException {
	}

	void initAsAfricanCuisine() throws JastorException {
	}

	void initAsPanPacificCuisine() throws JastorException {
	}

	void initAsSouthwesternCuisine() throws JastorException {
	}

	void initAsEuropeanCuisine() throws JastorException {
	}

	void initAsRomanianCuisine() throws JastorException {
	}

	void initAsTrendyCuisine() throws JastorException {
	}

	void initAsPacificNorthwestCuisine() throws JastorException {
	}

	void initAsJewishCuisine() throws JastorException {
	}

	void initAsFinnishCuisine() throws JastorException {
	}

	void initAsDeliSandwichesCuisine() throws JastorException {
	}

	void initAsIndonesianCuisine() throws JastorException {
	}

	void initAsSoutheastAsianCuisine() throws JastorException {
	}

	void initAsAustralianCuisine() throws JastorException {
	}

	void initAsLebaneseCuisine() throws JastorException {
	}

	void initAsPersianCuisine() throws JastorException {
	}

	void initAsFishAndChipsCuisine() throws JastorException {
	}

	void initAsChopeHouseCuisine() throws JastorException {
	}

	void initAsTibetanCuisine() throws JastorException {
	}

	void initAsSudaneseCuisine() throws JastorException {
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.domain.ontology.restaurant.RestaurantFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.CuisineCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof CuisineCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of CuisineCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((CuisineCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof CuisineCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of CuisineCodeListener"); 
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