

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.ReservationCode}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#ReservationCode)</p>
 * <br>
 */
public class ReservationCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.ReservationCode {
	


	ReservationCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static ReservationCodeImpl getReservationCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,ReservationCode.TYPE))
			return null;
		return new ReservationCodeImpl(resource, model);
	}
	    
	static ReservationCodeImpl createReservationCode(Resource resource, Model model) throws JastorException {
		ReservationCodeImpl impl = new ReservationCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, ReservationCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, ReservationCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsRequiredReservations() throws JastorException {
	}

	void initAsLargeGroupsOnlyReservations() throws JastorException {
	}

	void initAsRecommendedReservations() throws JastorException {
	}

	void initAsAcceptedReservations() throws JastorException {
	}

	void initAsUnknownReseravations() throws JastorException {
	}

	void initAsNotAcceptedReservations() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.ReservationCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof ReservationCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of ReservationCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((ReservationCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof ReservationCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of ReservationCodeListener"); 
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