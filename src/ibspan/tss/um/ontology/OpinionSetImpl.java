

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
 * Implementation of {@link ibspan.tss.um.ontology.OpinionSet}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#OpinionSet)</p>
 * <br>
 */
public class OpinionSetImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.OpinionSet {
	

	private static com.hp.hpl.jena.rdf.model.Property containsOpinionProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#containsOpinion");
	private java.util.ArrayList containsOpinion;
	private static com.hp.hpl.jena.rdf.model.Property wasChangedProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#wasChanged");
	private com.hp.hpl.jena.datatypes.xsd.XSDDateTime wasChanged;

	OpinionSetImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static OpinionSetImpl getOpinionSet(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,OpinionSet.TYPE))
			return null;
		return new OpinionSetImpl(resource, model);
	}
	    
	static OpinionSetImpl createOpinionSet(Resource resource, Model model) throws JastorException {
		OpinionSetImpl impl = new OpinionSetImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, OpinionSet.TYPE)))
			impl._model.add(impl._resource, RDF.type, OpinionSet.TYPE);
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
    	ibspan.tss.um.ontology.UserModellingFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,containsOpinionProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,wasChangedProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.OpinionSet.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		containsOpinion = null;
		wasChanged = null;
	}


	private void initContainsOpinion() throws JastorException {
		this.containsOpinion = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, containsOpinionProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#containsOpinion properties in OpinionSet model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.um.ontology.Opinion containsOpinion = ibspan.tss.um.ontology.UserModellingFactory.getOpinion(resource,_model);
				this.containsOpinion.add(containsOpinion);
			}
		}
	}

	public java.util.Iterator getContainsOpinion() throws JastorException {
		if (containsOpinion == null)
			initContainsOpinion();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(containsOpinion,_resource,containsOpinionProperty,true);
	}

	public void addContainsOpinion(ibspan.tss.um.ontology.Opinion containsOpinion) throws JastorException {
		if (this.containsOpinion == null)
			initContainsOpinion();
		if (this.containsOpinion.contains(containsOpinion)) {
			this.containsOpinion.remove(containsOpinion);
			this.containsOpinion.add(containsOpinion);
			return;
		}
		this.containsOpinion.add(containsOpinion);
		_model.add(_model.createStatement(_resource,containsOpinionProperty,containsOpinion.resource()));
	}
	
	public ibspan.tss.um.ontology.Opinion addContainsOpinion() throws JastorException {
		ibspan.tss.um.ontology.Opinion containsOpinion = ibspan.tss.um.ontology.UserModellingFactory.createOpinion(_model.createResource(),_model);
		if (this.containsOpinion == null)
			initContainsOpinion();
		this.containsOpinion.add(containsOpinion);
		_model.add(_model.createStatement(_resource,containsOpinionProperty,containsOpinion.resource()));
		return containsOpinion;
	}
	
	public ibspan.tss.um.ontology.Opinion addContainsOpinion(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Opinion.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Opinion.TYPE);
		ibspan.tss.um.ontology.Opinion containsOpinion = ibspan.tss.um.ontology.UserModellingFactory.getOpinion(resource,_model);
		if (this.containsOpinion == null)
			initContainsOpinion();
		if (this.containsOpinion.contains(containsOpinion))
			return containsOpinion;
		this.containsOpinion.add(containsOpinion);
		_model.add(_model.createStatement(_resource,containsOpinionProperty,containsOpinion.resource()));
		return containsOpinion;
	}
	
	public void removeContainsOpinion(ibspan.tss.um.ontology.Opinion containsOpinion) throws JastorException {
		if (this.containsOpinion == null)
			initContainsOpinion();
		if (!this.containsOpinion.contains(containsOpinion))
			return;
		if (!_model.contains(_resource, containsOpinionProperty, containsOpinion.resource()))
			return;
		this.containsOpinion.remove(containsOpinion);
		_model.removeAll(_resource, containsOpinionProperty, containsOpinion.resource());
	}
		 
	public com.hp.hpl.jena.datatypes.xsd.XSDDateTime getWasChanged() throws JastorException {
		if (wasChanged != null)
			return wasChanged;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, wasChangedProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": wasChanged getProperty() in ibspan.tss.um.ontology.OpinionSet model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
		wasChanged = (com.hp.hpl.jena.datatypes.xsd.XSDDateTime)obj;
		return wasChanged;
	}
	
	public void setWasChanged(com.hp.hpl.jena.datatypes.xsd.XSDDateTime wasChanged) throws JastorException {
		if (_model.contains(_resource,wasChangedProperty)) {
			_model.removeAll(_resource,wasChangedProperty,null);
		}
		this.wasChanged = wasChanged;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (wasChanged != null) {
			_model.add(_model.createStatement(_resource,wasChangedProperty, _model.createTypedLiteral(wasChanged)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof OpinionSetListener))
			throw new IllegalArgumentException("ThingListener must be instance of OpinionSetListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((OpinionSetListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof OpinionSetListener))
			throw new IllegalArgumentException("ThingListener must be instance of OpinionSetListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(containsOpinionProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.Opinion _containsOpinion = null;
					try {
						_containsOpinion = ibspan.tss.um.ontology.UserModellingFactory.getOpinion(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (containsOpinion == null) {
						try {
							initContainsOpinion();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!containsOpinion.contains(_containsOpinion))
						containsOpinion.add(_containsOpinion);
					if (listeners != null) {
						java.util.ArrayList consumersForContainsOpinion;
						synchronized (listeners) {
							consumersForContainsOpinion = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContainsOpinion.iterator();iter.hasNext();){
							OpinionSetListener listener=(OpinionSetListener)iter.next();
							listener.containsOpinionAdded(ibspan.tss.um.ontology.OpinionSetImpl.this,_containsOpinion);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(wasChangedProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				wasChanged = (com.hp.hpl.jena.datatypes.xsd.XSDDateTime)Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionSetListener listener=(OpinionSetListener)iter.next();
						listener.wasChangedChanged(ibspan.tss.um.ontology.OpinionSetImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(containsOpinionProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.Opinion _containsOpinion = null;
					if (containsOpinion != null) {
						boolean found = false;
						for (int i=0;i<containsOpinion.size();i++) {
							ibspan.tss.um.ontology.Opinion __item = (ibspan.tss.um.ontology.Opinion) containsOpinion.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_containsOpinion = __item;
								break;
							}
						}
						if (found)
							containsOpinion.remove(_containsOpinion);
						else {
							try {
								_containsOpinion = ibspan.tss.um.ontology.UserModellingFactory.getOpinion(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_containsOpinion = ibspan.tss.um.ontology.UserModellingFactory.getOpinion(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForContainsOpinion;
						synchronized (listeners) {
							consumersForContainsOpinion = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForContainsOpinion.iterator();iter.hasNext();){
							OpinionSetListener listener=(OpinionSetListener)iter.next();
							listener.containsOpinionRemoved(ibspan.tss.um.ontology.OpinionSetImpl.this,_containsOpinion);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(wasChangedProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
				if (wasChanged != null && wasChanged.equals(obj))
					wasChanged = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionSetListener listener=(OpinionSetListener)iter.next();
						listener.wasChangedChanged(ibspan.tss.um.ontology.OpinionSetImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}