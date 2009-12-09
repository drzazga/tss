

package ibspan.tss.layout.ontology.templates;

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
 * Implementation of {@link ibspan.tss.layout.ontology.templates.DummyClass}
 * Use the ibspan.tss.layout.ontology.templates.TemplatesFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/db/Templates#DummyClass)</p>
 * <br>
 */
public class DummyClassImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.layout.ontology.templates.DummyClass {
	


	DummyClassImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static DummyClassImpl getDummyClass(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,DummyClass.TYPE))
			return null;
		return new DummyClassImpl(resource, model);
	}
	    
	static DummyClassImpl createDummyClass(Resource resource, Model model) throws JastorException {
		DummyClassImpl impl = new DummyClassImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, DummyClass.TYPE)))
			impl._model.add(impl._resource, RDF.type, DummyClass.TYPE);
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
    	ibspan.tss.layout.ontology.templates.TemplatesFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.templates.DummyClass.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof DummyClassListener))
			throw new IllegalArgumentException("ThingListener must be instance of DummyClassListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((DummyClassListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof DummyClassListener))
			throw new IllegalArgumentException("ThingListener must be instance of DummyClassListener"); 
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