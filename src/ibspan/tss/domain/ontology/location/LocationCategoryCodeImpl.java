

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
 * Implementation of {@link ibspan.tss.domain.ontology.location.LocationCategoryCode}
 * Use the ibspan.tss.domain.ontology.location.LocationFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#LocationCategoryCode)</p>
 * <br>
 */
public class LocationCategoryCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.location.LocationCategoryCode {
	


	LocationCategoryCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static LocationCategoryCodeImpl getLocationCategoryCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,LocationCategoryCode.TYPE))
			return null;
		return new LocationCategoryCodeImpl(resource, model);
	}
	    
	static LocationCategoryCodeImpl createLocationCategoryCode(Resource resource, Model model) throws JastorException {
		LocationCategoryCodeImpl impl = new LocationCategoryCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, LocationCategoryCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, LocationCategoryCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsBeachLocation() throws JastorException {
	}

	void initAsWestLocation() throws JastorException {
	}

	void initAsRuralLocation() throws JastorException {
	}

	void initAsLakeLocation() throws JastorException {
	}

	void initAsDowntownLocation() throws JastorException {
	}

	void initAsGulfLocation() throws JastorException {
	}

	void initAsSuburbanLocation() throws JastorException {
	}

	void initAsExpresswayLocation() throws JastorException {
	}

	void initAsNorthLocation() throws JastorException {
	}

	void initAsResortLocation() throws JastorException {
	}

	void initAsBeachfrontLocation() throws JastorException {
	}

	void initAsCityLocation() throws JastorException {
	}

	void initAsEastLocation() throws JastorException {
	}

	void initAsOceanfrontLocation() throws JastorException {
	}

	void initAsMountainLocation() throws JastorException {
	}

	void initAsSouthLocation() throws JastorException {
	}

	void initAsAirportLocation() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.location.LocationCategoryCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof LocationCategoryCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of LocationCategoryCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((LocationCategoryCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof LocationCategoryCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of LocationCategoryCodeListener"); 
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