

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
 * Implementation of {@link ibspan.tss.domain.ontology.location.IndexPointCode}
 * Use the ibspan.tss.domain.ontology.location.LocationFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#IndexPointCode)</p>
 * <br>
 */
public class IndexPointCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.location.IndexPointCode {
	


	IndexPointCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static IndexPointCodeImpl getIndexPointCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,IndexPointCode.TYPE))
			return null;
		return new IndexPointCodeImpl(resource, model);
	}
	    
	static IndexPointCodeImpl createIndexPointCode(Resource resource, Model model) throws JastorException {
		IndexPointCodeImpl impl = new IndexPointCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, IndexPointCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, IndexPointCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsHighwayExitIndexPoint() throws JastorException {
	}

	void initAsCityIndexPoint() throws JastorException {
	}

	void initAsSubwayStationIndexPoint() throws JastorException {
	}

	void initAsHighwayIndexPoint() throws JastorException {
	}

	void initAsAirportIndexPoint() throws JastorException {
	}

	void initAsIntersectionIndexPoint() throws JastorException {
	}

	void initAsCrossStreetIndexPoint() throws JastorException {
	}

	void initAsRailStationIndexPoint() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.location.IndexPointCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof IndexPointCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of IndexPointCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((IndexPointCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof IndexPointCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of IndexPointCodeListener"); 
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