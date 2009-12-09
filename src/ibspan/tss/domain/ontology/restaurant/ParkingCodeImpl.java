

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.ParkingCode}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#ParkingCode)</p>
 * <br>
 */
public class ParkingCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.ParkingCode {
	


	ParkingCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static ParkingCodeImpl getParkingCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,ParkingCode.TYPE))
			return null;
		return new ParkingCodeImpl(resource, model);
	}
	    
	static ParkingCodeImpl createParkingCode(Resource resource, Model model) throws JastorException {
		ParkingCodeImpl impl = new ParkingCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, ParkingCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, ParkingCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsOwnParkingLot() throws JastorException {
	}

	void initAsStreetParking() throws JastorException {
	}

	void initAsPublicTransitAccessible() throws JastorException {
	}

	void initAsNoLocalParking() throws JastorException {
	}

	void initAsValetParking() throws JastorException {
	}

	void initAsPayParking() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.ParkingCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof ParkingCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of ParkingCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((ParkingCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof ParkingCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of ParkingCodeListener"); 
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