

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
 * Implementation of {@link ibspan.tss.um.ontology.ExtendedUserBehaviour}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ExtendedUserBehaviour)</p>
 * <br>
 */
public class ExtendedUserBehaviourImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.ExtendedUserBehaviour {
	

	private static com.hp.hpl.jena.rdf.model.Property hasContextProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasContext");
	private ibspan.tss.um.ontology.UserBehaviourContext hasContext;
	private static com.hp.hpl.jena.rdf.model.Property hasUserBehaviourProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserBehaviour");
	private ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour;

	ExtendedUserBehaviourImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static ExtendedUserBehaviourImpl getExtendedUserBehaviour(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,ExtendedUserBehaviour.TYPE))
			return null;
		return new ExtendedUserBehaviourImpl(resource, model);
	}
	    
	static ExtendedUserBehaviourImpl createExtendedUserBehaviour(Resource resource, Model model) throws JastorException {
		ExtendedUserBehaviourImpl impl = new ExtendedUserBehaviourImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, ExtendedUserBehaviour.TYPE)))
			impl._model.add(impl._resource, RDF.type, ExtendedUserBehaviour.TYPE);
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
		it = _model.listStatements(_resource,hasContextProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserBehaviourProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.ExtendedUserBehaviour.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasContext = null;
		hasUserBehaviour = null;
	}


	public ibspan.tss.um.ontology.UserBehaviourContext getHasContext() throws JastorException {
		if (hasContext != null)
			return hasContext;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasContextProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasContext getProperty() in ibspan.tss.um.ontology.ExtendedUserBehaviour model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasContext = ibspan.tss.um.ontology.UserModellingFactory.getUserBehaviourContext(resource,_model);
		return hasContext;
	}

	public void setHasContext(ibspan.tss.um.ontology.UserBehaviourContext hasContext) throws JastorException {
		if (_model.contains(_resource,hasContextProperty)) {
			_model.removeAll(_resource,hasContextProperty,null);
		}
		this.hasContext = hasContext;
		if (hasContext != null) {
			_model.add(_model.createStatement(_resource,hasContextProperty, hasContext.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.UserBehaviourContext setHasContext() throws JastorException {
		if (_model.contains(_resource,hasContextProperty)) {
			_model.removeAll(_resource,hasContextProperty,null);
		}
		ibspan.tss.um.ontology.UserBehaviourContext hasContext = ibspan.tss.um.ontology.UserModellingFactory.createUserBehaviourContext(_model.createResource(),_model);
		this.hasContext = hasContext;
		_model.add(_model.createStatement(_resource,hasContextProperty, hasContext.resource()));
		return hasContext;
	}
	
	public ibspan.tss.um.ontology.UserBehaviourContext setHasContext(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.UserBehaviourContext.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.UserBehaviourContext.TYPE);
		if (_model.contains(_resource,hasContextProperty)) {
			_model.removeAll(_resource,hasContextProperty,null);
		}
		ibspan.tss.um.ontology.UserBehaviourContext hasContext = ibspan.tss.um.ontology.UserModellingFactory.getUserBehaviourContext(resource,_model);
		this.hasContext = hasContext;
		_model.add(_model.createStatement(_resource,hasContextProperty, hasContext.resource()));
		return hasContext;
	}
	

	public ibspan.tss.um.ontology.UserBehaviour getHasUserBehaviour() throws JastorException {
		if (hasUserBehaviour != null)
			return hasUserBehaviour;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserBehaviourProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserBehaviour getProperty() in ibspan.tss.um.ontology.ExtendedUserBehaviour model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.getUserBehaviour(resource,_model);
		return hasUserBehaviour;
	}

	public void setHasUserBehaviour(ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour) throws JastorException {
		if (_model.contains(_resource,hasUserBehaviourProperty)) {
			_model.removeAll(_resource,hasUserBehaviourProperty,null);
		}
		this.hasUserBehaviour = hasUserBehaviour;
		if (hasUserBehaviour != null) {
			_model.add(_model.createStatement(_resource,hasUserBehaviourProperty, hasUserBehaviour.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.UserBehaviour setHasUserBehaviour() throws JastorException {
		if (_model.contains(_resource,hasUserBehaviourProperty)) {
			_model.removeAll(_resource,hasUserBehaviourProperty,null);
		}
		ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.createUserBehaviour(_model.createResource(),_model);
		this.hasUserBehaviour = hasUserBehaviour;
		_model.add(_model.createStatement(_resource,hasUserBehaviourProperty, hasUserBehaviour.resource()));
		return hasUserBehaviour;
	}
	
	public ibspan.tss.um.ontology.UserBehaviour setHasUserBehaviour(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.UserBehaviour.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.UserBehaviour.TYPE);
		if (_model.contains(_resource,hasUserBehaviourProperty)) {
			_model.removeAll(_resource,hasUserBehaviourProperty,null);
		}
		ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.getUserBehaviour(resource,_model);
		this.hasUserBehaviour = hasUserBehaviour;
		_model.add(_model.createStatement(_resource,hasUserBehaviourProperty, hasUserBehaviour.resource()));
		return hasUserBehaviour;
	}
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof ExtendedUserBehaviourListener))
			throw new IllegalArgumentException("ThingListener must be instance of ExtendedUserBehaviourListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((ExtendedUserBehaviourListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof ExtendedUserBehaviourListener))
			throw new IllegalArgumentException("ThingListener must be instance of ExtendedUserBehaviourListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasContextProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasContext = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasContext = ibspan.tss.um.ontology.UserModellingFactory.getUserBehaviourContext(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
				}
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ExtendedUserBehaviourListener listener=(ExtendedUserBehaviourListener)iter.next();
						listener.hasContextChanged(ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasUserBehaviourProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasUserBehaviour = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.getUserBehaviour(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
				}
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ExtendedUserBehaviourListener listener=(ExtendedUserBehaviourListener)iter.next();
						listener.hasUserBehaviourChanged(ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasContextProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasContext != null && hasContext.resource().equals(resource))
						hasContext = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ExtendedUserBehaviourListener listener=(ExtendedUserBehaviourListener)iter.next();
						listener.hasContextChanged(ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasUserBehaviourProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasUserBehaviour != null && hasUserBehaviour.resource().equals(resource))
						hasUserBehaviour = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ExtendedUserBehaviourListener listener=(ExtendedUserBehaviourListener)iter.next();
						listener.hasUserBehaviourChanged(ibspan.tss.um.ontology.ExtendedUserBehaviourImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}