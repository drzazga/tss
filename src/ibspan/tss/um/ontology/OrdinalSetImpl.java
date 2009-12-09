

package ibspan.tss.um.ontology;

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
 * Implementation of {@link ibspan.tss.um.ontology.OrdinalSet}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#OrdinalSet)</p>
 * <br>
 */
public class OrdinalSetImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.OrdinalSet {
	

	private static com.hp.hpl.jena.rdf.model.Property containsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#contains");
	private java.util.ArrayList contains;
	private java.util.ArrayList contains_asOrdinal;

	OrdinalSetImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static OrdinalSetImpl getOrdinalSet(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,OrdinalSet.TYPE))
			return null;
		return new OrdinalSetImpl(resource, model);
	}
	    
	static OrdinalSetImpl createOrdinalSet(Resource resource, Model model) throws JastorException {
		OrdinalSetImpl impl = new OrdinalSetImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, OrdinalSet.TYPE)))
			impl._model.add(impl._resource, RDF.type, OrdinalSet.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.MeasureSet.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.MeasureSet.TYPE));     
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.um.ontology.UserModellingFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,containsProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.OrdinalSet.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.MeasureSet.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		contains = null;
		contains_asOrdinal = null;
	}


	private void initContains() throws JastorException {
		this.contains = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, containsProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#contains properties in OrdinalSet model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.um.ontology.Measure contains = ibspan.tss.um.ontology.UserModellingFactory.getMeasure(resource,_model);
				this.contains.add(contains);
			}
		}
	}

	public java.util.Iterator getContains() throws JastorException {
		if (contains == null)
			initContains();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(contains,_resource,containsProperty,true);
	}

	public void addContains(ibspan.tss.um.ontology.Measure contains) throws JastorException {
		if (this.contains == null)
			initContains();
		if (this.contains.contains(contains)) {
			this.contains.remove(contains);
			this.contains.add(contains);
			return;
		}
		this.contains.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
	}
	
	public ibspan.tss.um.ontology.Measure addContains() throws JastorException {
		ibspan.tss.um.ontology.Measure contains = ibspan.tss.um.ontology.UserModellingFactory.createMeasure(_model.createResource(),_model);
		if (this.contains == null)
			initContains();
		this.contains.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
		return contains;
	}
	
	public ibspan.tss.um.ontology.Measure addContains(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Measure.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Measure.TYPE);
		ibspan.tss.um.ontology.Measure contains = ibspan.tss.um.ontology.UserModellingFactory.getMeasure(resource,_model);
		if (this.contains == null)
			initContains();
		if (this.contains.contains(contains))
			return contains;
		this.contains.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
		return contains;
	}
	
	public void removeContains(ibspan.tss.um.ontology.Measure contains) throws JastorException {
		if (this.contains == null)
			initContains();
		if (!this.contains.contains(contains))
			return;
		if (!_model.contains(_resource, containsProperty, contains.resource()))
			return;
		this.contains.remove(contains);
		_model.removeAll(_resource, containsProperty, contains.resource());
	}
		
	private void initContains_asOrdinal() throws JastorException {
		this.contains_asOrdinal = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, containsProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#contains properties in OrdinalSet model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Ordinal.TYPE)) {
				ibspan.tss.um.ontology.Ordinal contains = ibspan.tss.um.ontology.UserModellingFactory.getOrdinal(resource,_model);
				this.contains_asOrdinal.add(contains);
			}
		}
	}

	public java.util.Iterator getContains_asOrdinal() throws JastorException {
		if (contains_asOrdinal == null)
			initContains_asOrdinal();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(contains_asOrdinal,_resource,containsProperty,true);
	}

	public void addContains(ibspan.tss.um.ontology.Ordinal contains) throws JastorException {
		if (this.contains_asOrdinal == null)
			initContains_asOrdinal();
		if (this.contains_asOrdinal.contains(contains)) {
			this.contains_asOrdinal.remove(contains);
			this.contains_asOrdinal.add(contains);
			return;
		}
		this.contains_asOrdinal.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
	}
	
	public ibspan.tss.um.ontology.Ordinal addContains_asOrdinal() throws JastorException {
		ibspan.tss.um.ontology.Ordinal contains = ibspan.tss.um.ontology.UserModellingFactory.createOrdinal(_model.createResource(),_model);
		if (this.contains_asOrdinal == null)
			initContains_asOrdinal();
		this.contains_asOrdinal.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
		return contains;
	}
	
	public ibspan.tss.um.ontology.Ordinal addContains_asOrdinal(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Ordinal.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Ordinal.TYPE);
		ibspan.tss.um.ontology.Ordinal contains = ibspan.tss.um.ontology.UserModellingFactory.getOrdinal(resource,_model);
		if (this.contains_asOrdinal == null)
			initContains_asOrdinal();
		if (this.contains_asOrdinal.contains(contains))
			return contains;
		this.contains_asOrdinal.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
		return contains;
	}
	
	public void removeContains(ibspan.tss.um.ontology.Ordinal contains) throws JastorException {
		if (this.contains_asOrdinal == null)
			initContains_asOrdinal();
		if (!this.contains_asOrdinal.contains(contains))
			return;
		if (!_model.contains(_resource, containsProperty, contains.resource()))
			return;
		this.contains_asOrdinal.remove(contains);
		_model.removeAll(_resource, containsProperty, contains.resource());
	}
		  


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof OrdinalSetListener))
			throw new IllegalArgumentException("ThingListener must be instance of OrdinalSetListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((OrdinalSetListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof OrdinalSetListener))
			throw new IllegalArgumentException("ThingListener must be instance of OrdinalSetListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(containsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.Measure _contains = null;
					try {
						_contains = ibspan.tss.um.ontology.UserModellingFactory.getMeasure(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (contains == null) {
						try {
							initContains();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!contains.contains(_contains))
						contains.add(_contains);
					if (listeners != null) {
						java.util.ArrayList consumersForContains;
						synchronized (listeners) {
							consumersForContains = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContains.iterator();iter.hasNext();){
							OrdinalSetListener listener=(OrdinalSetListener)iter.next();
							listener.containsAdded(ibspan.tss.um.ontology.OrdinalSetImpl.this,_contains);
						}
					}
				}
				if (_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Ordinal.TYPE)) {
					ibspan.tss.um.ontology.Ordinal _contains_asOrdinal = null;
					try {
						_contains_asOrdinal = ibspan.tss.um.ontology.UserModellingFactory.getOrdinal(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (contains_asOrdinal == null) {
						try {
							initContains_asOrdinal();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!contains_asOrdinal.contains(_contains_asOrdinal))
						contains_asOrdinal.add(_contains_asOrdinal);
					if (listeners != null) {
						java.util.ArrayList consumersForContains_asOrdinal;
						synchronized (listeners) {
							consumersForContains_asOrdinal = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContains_asOrdinal.iterator();iter.hasNext();){
							OrdinalSetListener listener=(OrdinalSetListener)iter.next();
							listener.containsAdded(ibspan.tss.um.ontology.OrdinalSetImpl.this,_contains_asOrdinal);
						}
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(containsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.Measure _contains = null;
					if (contains != null) {
						boolean found = false;
						for (int i=0;i<contains.size();i++) {
							ibspan.tss.um.ontology.Measure __item = (ibspan.tss.um.ontology.Measure) contains.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_contains = __item;
								break;
							}
						}
						if (found)
							contains.remove(_contains);
						else {
							try {
								_contains = ibspan.tss.um.ontology.UserModellingFactory.getMeasure(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_contains = ibspan.tss.um.ontology.UserModellingFactory.getMeasure(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForContains;
						synchronized (listeners) {
							consumersForContains = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContains.iterator();iter.hasNext();){
							OrdinalSetListener listener=(OrdinalSetListener)iter.next();
							listener.containsRemoved(ibspan.tss.um.ontology.OrdinalSetImpl.this,_contains);
						}
					}
				}
				if (_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Ordinal.TYPE)) {
					ibspan.tss.um.ontology.Ordinal _contains_asOrdinal = null;
					if (contains_asOrdinal != null) {
						boolean found = false;
						for (int i=0;i<contains_asOrdinal.size();i++) {
							ibspan.tss.um.ontology.Ordinal __item = (ibspan.tss.um.ontology.Ordinal) contains_asOrdinal.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_contains_asOrdinal = __item;
								break;
							}
						}
						if (found)
							contains_asOrdinal.remove(_contains_asOrdinal);
						else {
							try {
								_contains_asOrdinal = ibspan.tss.um.ontology.UserModellingFactory.getOrdinal(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_contains_asOrdinal = ibspan.tss.um.ontology.UserModellingFactory.getOrdinal(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForContains_asOrdinal;
						synchronized (listeners) {
							consumersForContains_asOrdinal = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContains_asOrdinal.iterator();iter.hasNext();){
							OrdinalSetListener listener=(OrdinalSetListener)iter.next();
							listener.containsRemoved(ibspan.tss.um.ontology.OrdinalSetImpl.this,_contains_asOrdinal);
						}
					}
				}
				return;
			}
		}

	//}
	


}