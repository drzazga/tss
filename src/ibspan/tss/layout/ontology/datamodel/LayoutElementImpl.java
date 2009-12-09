

package ibspan.tss.layout.ontology.datamodel;

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
 * Implementation of {@link ibspan.tss.layout.ontology.datamodel.LayoutElement}
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#LayoutElement)</p>
 * <br>
 */
public class LayoutElementImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.layout.ontology.datamodel.LayoutElement {
	


	LayoutElementImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static LayoutElementImpl getLayoutElement(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,LayoutElement.TYPE))
			return null;
		return new LayoutElementImpl(resource, model);
	}
	    
	static LayoutElementImpl createLayoutElement(Resource resource, Model model) throws JastorException {
		LayoutElementImpl impl = new LayoutElementImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, LayoutElement.TYPE)))
			impl._model.add(impl._resource, RDF.type, LayoutElement.TYPE);
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
    	ibspan.tss.layout.ontology.datamodel.DataModelFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof LayoutElementListener))
			throw new IllegalArgumentException("ThingListener must be instance of LayoutElementListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((LayoutElementListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof LayoutElementListener))
			throw new IllegalArgumentException("ThingListener must be instance of LayoutElementListener"); 
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