

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.FeatureCode}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#FeatureCode)</p>
 * <br>
 */
public class FeatureCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.FeatureCode {
	


	FeatureCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static FeatureCodeImpl getFeatureCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,FeatureCode.TYPE))
			return null;
		return new FeatureCodeImpl(resource, model);
	}
	    
	static FeatureCodeImpl createFeatureCode(Resource resource, Model model) throws JastorException {
		FeatureCodeImpl impl = new FeatureCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, FeatureCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, FeatureCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsTakeout() throws JastorException {
	}

	void initAsFineDining() throws JastorException {
	}

	void initAsBreakfastBuffet() throws JastorException {
	}

	void initAsFixedPriceMealsAtLunc() throws JastorException {
	}

	void initAsPrivateParties() throws JastorException {
	}

	void initAsSundayBrunch() throws JastorException {
	}

	void initAsKids() throws JastorException {
	}

	void initAsLargePrintMenu() throws JastorException {
	}

	void initAsPrivateRoomAvailable() throws JastorException {
	}

	void initAsKiosk() throws JastorException {
	}

	void initAsDinnerBuffet() throws JastorException {
	}

	void initAsFastFood() throws JastorException {
	}

	void initAsLargeGroupsOk() throws JastorException {
	}

	void initAsVegetarianMenu() throws JastorException {
	}

	void initAsNiceView() throws JastorException {
	}

	void initAsBrewery() throws JastorException {
	}

	void initAsHalal() throws JastorException {
	}

	void initAsUpscale() throws JastorException {
	}

	void initAsFixedPriceMealsAtDinn() throws JastorException {
	}

	void initAsBeingYourOwnWine() throws JastorException {
	}

	void initAsOutdoor() throws JastorException {
	}

	void initAsExtensiveWineList() throws JastorException {
	}

	void initAsPhoneAheadSeating() throws JastorException {
	}

	void initAsCafeteria() throws JastorException {
	}

	void initAsWineTasting() throws JastorException {
	}

	void initAsBeverage() throws JastorException {
	}

	void initAsVeganDishes() throws JastorException {
	}

	void initAsFireplace() throws JastorException {
	}

	void initAsWineList() throws JastorException {
	}

	void initAsCertifiedKosher() throws JastorException {
	}

	void initAsSaladBar() throws JastorException {
	}

	void initAsAdultEntertainment() throws JastorException {
	}

	void initAsDriveThrough() throws JastorException {
	}

	void initAsSenorMenu() throws JastorException {
	}

	void initAsBeingYourOwnBeer() throws JastorException {
	}

	void initAsBrailleMenu() throws JastorException {
	}

	void initAsMinorsNotAllowed() throws JastorException {
	}

	void initAsEntertainment() throws JastorException {
	}

	void initAsAllPurpose() throws JastorException {
	}

	void initAsCasual() throws JastorException {
	}

	void initAsOffsiteCatering() throws JastorException {
	}

	void initAsVegetarianDishes() throws JastorException {
	}

	void initAsWinery() throws JastorException {
	}

	void initAsInternetAccess() throws JastorException {
	}

	void initAsEnglishLanguageMenu() throws JastorException {
	}

	void initAsCafe() throws JastorException {
	}

	void initAsBuffet() throws JastorException {
	}

	void initAsLunchBuffet() throws JastorException {
	}

	void initAsFamily() throws JastorException {
	}

	void initAsKidFriendly() throws JastorException {
	}

	void initAsVeganMenu() throws JastorException {
	}

	void initAsDelivery() throws JastorException {
	}

	void initAsConservatory() throws JastorException {
	}

	void initAsTastingMenu() throws JastorException {
	}

	void initAsBeerTasting() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.FeatureCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof FeatureCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of FeatureCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((FeatureCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof FeatureCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of FeatureCodeListener"); 
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