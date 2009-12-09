

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.DinerReview}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#DinerReview)</p>
 * <br>
 */
public class DinerReviewImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.DinerReview {
	


	DinerReviewImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static DinerReviewImpl getDinerReview(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,DinerReview.TYPE))
			return null;
		return new DinerReviewImpl(resource, model);
	}
	    
	static DinerReviewImpl createDinerReview(Resource resource, Model model) throws JastorException {
		DinerReviewImpl impl = new DinerReviewImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, DinerReview.TYPE)))
			impl._model.add(impl._resource, RDF.type, DinerReview.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.DinerReview.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof DinerReviewListener))
			throw new IllegalArgumentException("ThingListener must be instance of DinerReviewListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((DinerReviewListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof DinerReviewListener))
			throw new IllegalArgumentException("ThingListener must be instance of DinerReviewListener"); 
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