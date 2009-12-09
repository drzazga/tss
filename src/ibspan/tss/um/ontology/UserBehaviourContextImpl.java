

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
 * Implementation of {@link ibspan.tss.um.ontology.UserBehaviourContext}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviourContext)</p>
 * <br>
 */
public class UserBehaviourContextImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.UserBehaviourContext {
	

	private static com.hp.hpl.jena.rdf.model.Property hasParameterProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasParameter");
	private java.util.ArrayList hasParameter;

	UserBehaviourContextImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static UserBehaviourContextImpl getUserBehaviourContext(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,UserBehaviourContext.TYPE))
			return null;
		return new UserBehaviourContextImpl(resource, model);
	}
	    
	static UserBehaviourContextImpl createUserBehaviourContext(Resource resource, Model model) throws JastorException {
		UserBehaviourContextImpl impl = new UserBehaviourContextImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, UserBehaviourContext.TYPE)))
			impl._model.add(impl._resource, RDF.type, UserBehaviourContext.TYPE);
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
		it = _model.listStatements(_resource,hasParameterProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.UserBehaviourContext.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasParameter = null;
	}


	private void initHasParameter() throws JastorException {
		this.hasParameter = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, hasParameterProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#hasParameter properties in UserBehaviourContext model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.um.ontology.ContextParameter hasParameter = ibspan.tss.um.ontology.UserModellingFactory.getContextParameter(resource,_model);
				this.hasParameter.add(hasParameter);
			}
		}
	}

	public java.util.Iterator getHasParameter() throws JastorException {
		if (hasParameter == null)
			initHasParameter();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(hasParameter,_resource,hasParameterProperty,true);
	}

	public void addHasParameter(ibspan.tss.um.ontology.ContextParameter hasParameter) throws JastorException {
		if (this.hasParameter == null)
			initHasParameter();
		if (this.hasParameter.contains(hasParameter)) {
			this.hasParameter.remove(hasParameter);
			this.hasParameter.add(hasParameter);
			return;
		}
		this.hasParameter.add(hasParameter);
		_model.add(_model.createStatement(_resource,hasParameterProperty,hasParameter.resource()));
	}
	
	public ibspan.tss.um.ontology.ContextParameter addHasParameter() throws JastorException {
		ibspan.tss.um.ontology.ContextParameter hasParameter = ibspan.tss.um.ontology.UserModellingFactory.createContextParameter(_model.createResource(),_model);
		if (this.hasParameter == null)
			initHasParameter();
		this.hasParameter.add(hasParameter);
		_model.add(_model.createStatement(_resource,hasParameterProperty,hasParameter.resource()));
		return hasParameter;
	}
	
	public ibspan.tss.um.ontology.ContextParameter addHasParameter(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.ContextParameter.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.ContextParameter.TYPE);
		ibspan.tss.um.ontology.ContextParameter hasParameter = ibspan.tss.um.ontology.UserModellingFactory.getContextParameter(resource,_model);
		if (this.hasParameter == null)
			initHasParameter();
		if (this.hasParameter.contains(hasParameter))
			return hasParameter;
		this.hasParameter.add(hasParameter);
		_model.add(_model.createStatement(_resource,hasParameterProperty,hasParameter.resource()));
		return hasParameter;
	}
	
	public void removeHasParameter(ibspan.tss.um.ontology.ContextParameter hasParameter) throws JastorException {
		if (this.hasParameter == null)
			initHasParameter();
		if (!this.hasParameter.contains(hasParameter))
			return;
		if (!_model.contains(_resource, hasParameterProperty, hasParameter.resource()))
			return;
		this.hasParameter.remove(hasParameter);
		_model.removeAll(_resource, hasParameterProperty, hasParameter.resource());
	}
		  


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof UserBehaviourContextListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserBehaviourContextListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((UserBehaviourContextListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof UserBehaviourContextListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserBehaviourContextListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasParameterProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.ContextParameter _hasParameter = null;
					try {
						_hasParameter = ibspan.tss.um.ontology.UserModellingFactory.getContextParameter(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (hasParameter == null) {
						try {
							initHasParameter();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!hasParameter.contains(_hasParameter))
						hasParameter.add(_hasParameter);
					if (listeners != null) {
						java.util.ArrayList consumersForHasParameter;
						synchronized (listeners) {
							consumersForHasParameter = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasParameter.iterator();iter.hasNext();){
							UserBehaviourContextListener listener=(UserBehaviourContextListener)iter.next();
							listener.hasParameterAdded(ibspan.tss.um.ontology.UserBehaviourContextImpl.this,_hasParameter);
						}
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasParameterProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.ContextParameter _hasParameter = null;
					if (hasParameter != null) {
						boolean found = false;
						for (int i=0;i<hasParameter.size();i++) {
							ibspan.tss.um.ontology.ContextParameter __item = (ibspan.tss.um.ontology.ContextParameter) hasParameter.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_hasParameter = __item;
								break;
							}
						}
						if (found)
							hasParameter.remove(_hasParameter);
						else {
							try {
								_hasParameter = ibspan.tss.um.ontology.UserModellingFactory.getContextParameter(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_hasParameter = ibspan.tss.um.ontology.UserModellingFactory.getContextParameter(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForHasParameter;
						synchronized (listeners) {
							consumersForHasParameter = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasParameter.iterator();iter.hasNext();){
							UserBehaviourContextListener listener=(UserBehaviourContextListener)iter.next();
							listener.hasParameterRemoved(ibspan.tss.um.ontology.UserBehaviourContextImpl.this,_hasParameter);
						}
					}
				}
				return;
			}
		}

	//}
	


}