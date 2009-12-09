

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
 * Implementation of {@link ibspan.tss.um.ontology.NominalSet}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#NominalSet)</p>
 * <br>
 */
public class NominalSetImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.NominalSet {
	

	private static com.hp.hpl.jena.rdf.model.Property containsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#contains");
	private java.util.ArrayList contains;
	private java.util.ArrayList contains_asNominal;

	NominalSetImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static NominalSetImpl getNominalSet(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,NominalSet.TYPE))
			return null;
		return new NominalSetImpl(resource, model);
	}
	    
	static NominalSetImpl createNominalSet(Resource resource, Model model) throws JastorException {
		NominalSetImpl impl = new NominalSetImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, NominalSet.TYPE)))
			impl._model.add(impl._resource, RDF.type, NominalSet.TYPE);
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.NominalSet.TYPE);
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
		contains_asNominal = null;
	}


	private void initContains() throws JastorException {
		this.contains = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, containsProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#contains properties in NominalSet model not a Resource", stmt.getObject());
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
		
	private void initContains_asNominal() throws JastorException {
		this.contains_asNominal = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, containsProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#contains properties in NominalSet model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Nominal.TYPE)) {
				ibspan.tss.um.ontology.Nominal contains = ibspan.tss.um.ontology.UserModellingFactory.getNominal(resource,_model);
				this.contains_asNominal.add(contains);
			}
		}
	}

	public java.util.Iterator getContains_asNominal() throws JastorException {
		if (contains_asNominal == null)
			initContains_asNominal();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(contains_asNominal,_resource,containsProperty,true);
	}

	public void addContains(ibspan.tss.um.ontology.Nominal contains) throws JastorException {
		if (this.contains_asNominal == null)
			initContains_asNominal();
		if (this.contains_asNominal.contains(contains)) {
			this.contains_asNominal.remove(contains);
			this.contains_asNominal.add(contains);
			return;
		}
		this.contains_asNominal.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
	}
	
	public ibspan.tss.um.ontology.Nominal addContains_asNominal() throws JastorException {
		ibspan.tss.um.ontology.Nominal contains = ibspan.tss.um.ontology.UserModellingFactory.createNominal(_model.createResource(),_model);
		if (this.contains_asNominal == null)
			initContains_asNominal();
		this.contains_asNominal.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
		return contains;
	}
	
	public ibspan.tss.um.ontology.Nominal addContains_asNominal(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Nominal.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Nominal.TYPE);
		ibspan.tss.um.ontology.Nominal contains = ibspan.tss.um.ontology.UserModellingFactory.getNominal(resource,_model);
		if (this.contains_asNominal == null)
			initContains_asNominal();
		if (this.contains_asNominal.contains(contains))
			return contains;
		this.contains_asNominal.add(contains);
		_model.add(_model.createStatement(_resource,containsProperty,contains.resource()));
		return contains;
	}
	
	public void removeContains(ibspan.tss.um.ontology.Nominal contains) throws JastorException {
		if (this.contains_asNominal == null)
			initContains_asNominal();
		if (!this.contains_asNominal.contains(contains))
			return;
		if (!_model.contains(_resource, containsProperty, contains.resource()))
			return;
		this.contains_asNominal.remove(contains);
		_model.removeAll(_resource, containsProperty, contains.resource());
	}
		  


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof NominalSetListener))
			throw new IllegalArgumentException("ThingListener must be instance of NominalSetListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((NominalSetListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof NominalSetListener))
			throw new IllegalArgumentException("ThingListener must be instance of NominalSetListener"); 
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
							NominalSetListener listener=(NominalSetListener)iter.next();
							listener.containsAdded(ibspan.tss.um.ontology.NominalSetImpl.this,_contains);
						}
					}
				}
				if (_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Nominal.TYPE)) {
					ibspan.tss.um.ontology.Nominal _contains_asNominal = null;
					try {
						_contains_asNominal = ibspan.tss.um.ontology.UserModellingFactory.getNominal(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (contains_asNominal == null) {
						try {
							initContains_asNominal();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!contains_asNominal.contains(_contains_asNominal))
						contains_asNominal.add(_contains_asNominal);
					if (listeners != null) {
						java.util.ArrayList consumersForContains_asNominal;
						synchronized (listeners) {
							consumersForContains_asNominal = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContains_asNominal.iterator();iter.hasNext();){
							NominalSetListener listener=(NominalSetListener)iter.next();
							listener.containsAdded(ibspan.tss.um.ontology.NominalSetImpl.this,_contains_asNominal);
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
							NominalSetListener listener=(NominalSetListener)iter.next();
							listener.containsRemoved(ibspan.tss.um.ontology.NominalSetImpl.this,_contains);
						}
					}
				}
				if (_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Nominal.TYPE)) {
					ibspan.tss.um.ontology.Nominal _contains_asNominal = null;
					if (contains_asNominal != null) {
						boolean found = false;
						for (int i=0;i<contains_asNominal.size();i++) {
							ibspan.tss.um.ontology.Nominal __item = (ibspan.tss.um.ontology.Nominal) contains_asNominal.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_contains_asNominal = __item;
								break;
							}
						}
						if (found)
							contains_asNominal.remove(_contains_asNominal);
						else {
							try {
								_contains_asNominal = ibspan.tss.um.ontology.UserModellingFactory.getNominal(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_contains_asNominal = ibspan.tss.um.ontology.UserModellingFactory.getNominal(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForContains_asNominal;
						synchronized (listeners) {
							consumersForContains_asNominal = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContains_asNominal.iterator();iter.hasNext();){
							NominalSetListener listener=(NominalSetListener)iter.next();
							listener.containsRemoved(ibspan.tss.um.ontology.NominalSetImpl.this,_contains_asNominal);
						}
					}
				}
				return;
			}
		}

	//}
	


}