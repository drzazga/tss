

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#RestaurantCategoryCode)</p>
 * <br>
 */
public class RestaurantCategoryCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode {
	


	RestaurantCategoryCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static RestaurantCategoryCodeImpl getRestaurantCategoryCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,RestaurantCategoryCode.TYPE))
			return null;
		return new RestaurantCategoryCodeImpl(resource, model);
	}
	    
	static RestaurantCategoryCodeImpl createRestaurantCategoryCode(Resource resource, Model model) throws JastorException {
		RestaurantCategoryCodeImpl impl = new RestaurantCategoryCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, RestaurantCategoryCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, RestaurantCategoryCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsUpscaleRestaurant() throws JastorException {
	}

	void initAsAllPurposeRestaurant() throws JastorException {
	}

	void initAsTakeOutRestaurant() throws JastorException {
	}

	void initAsCasualRestaurant() throws JastorException {
	}

	void initAsBeverageRestaurant() throws JastorException {
	}

	void initAsCafeteriaRestaurant() throws JastorException {
	}

	void initAsFineDiningRestaurant() throws JastorException {
	}

	void initAsKioskRestaurant() throws JastorException {
	}

	void initAsFamilyRestaurant() throws JastorException {
	}

	void initAsCafeRestaurant() throws JastorException {
	}

	void initAsFastFoodRestaurant() throws JastorException {
	}

	void initAsBuffetRestaurant() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof RestaurantCategoryCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of RestaurantCategoryCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((RestaurantCategoryCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof RestaurantCategoryCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of RestaurantCategoryCodeListener"); 
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