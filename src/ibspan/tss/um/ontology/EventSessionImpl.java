

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
 * Implementation of {@link ibspan.tss.um.ontology.EventSession}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#EventSession)</p>
 * <br>
 */
public class EventSessionImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.EventSession {
	

	private static com.hp.hpl.jena.rdf.model.Property hasEventProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasEvent");
	private java.util.ArrayList hasEvent;
	private static com.hp.hpl.jena.rdf.model.Property startedAtProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#startedAt");
	private com.hp.hpl.jena.datatypes.xsd.XSDDateTime startedAt;
	private static com.hp.hpl.jena.rdf.model.Property hasSessionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasSessionID");
	private java.lang.String hasSessionID;
	private static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");
	private java.lang.Integer hasUserID;

	EventSessionImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static EventSessionImpl getEventSession(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,EventSession.TYPE))
			return null;
		return new EventSessionImpl(resource, model);
	}
	    
	static EventSessionImpl createEventSession(Resource resource, Model model) throws JastorException {
		EventSessionImpl impl = new EventSessionImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, EventSession.TYPE)))
			impl._model.add(impl._resource, RDF.type, EventSession.TYPE);
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
		it = _model.listStatements(_resource,hasEventProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,startedAtProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasSessionIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.EventSession.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasEvent = null;
		startedAt = null;
		hasSessionID = null;
		hasUserID = null;
	}


	private void initHasEvent() throws JastorException {
		this.hasEvent = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, hasEventProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#hasEvent properties in EventSession model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.um.ontology.Event hasEvent = ibspan.tss.um.ontology.UserModellingFactory.getEvent(resource,_model);
				this.hasEvent.add(hasEvent);
			}
		}
	}

	public java.util.Iterator getHasEvent() throws JastorException {
		if (hasEvent == null)
			initHasEvent();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(hasEvent,_resource,hasEventProperty,true);
	}

	public void addHasEvent(ibspan.tss.um.ontology.Event hasEvent) throws JastorException {
		if (this.hasEvent == null)
			initHasEvent();
		if (this.hasEvent.contains(hasEvent)) {
			this.hasEvent.remove(hasEvent);
			this.hasEvent.add(hasEvent);
			return;
		}
		this.hasEvent.add(hasEvent);
		_model.add(_model.createStatement(_resource,hasEventProperty,hasEvent.resource()));
	}
	
	public ibspan.tss.um.ontology.Event addHasEvent() throws JastorException {
		ibspan.tss.um.ontology.Event hasEvent = ibspan.tss.um.ontology.UserModellingFactory.createEvent(_model.createResource(),_model);
		if (this.hasEvent == null)
			initHasEvent();
		this.hasEvent.add(hasEvent);
		_model.add(_model.createStatement(_resource,hasEventProperty,hasEvent.resource()));
		return hasEvent;
	}
	
	public ibspan.tss.um.ontology.Event addHasEvent(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Event.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Event.TYPE);
		ibspan.tss.um.ontology.Event hasEvent = ibspan.tss.um.ontology.UserModellingFactory.getEvent(resource,_model);
		if (this.hasEvent == null)
			initHasEvent();
		if (this.hasEvent.contains(hasEvent))
			return hasEvent;
		this.hasEvent.add(hasEvent);
		_model.add(_model.createStatement(_resource,hasEventProperty,hasEvent.resource()));
		return hasEvent;
	}
	
	public void removeHasEvent(ibspan.tss.um.ontology.Event hasEvent) throws JastorException {
		if (this.hasEvent == null)
			initHasEvent();
		if (!this.hasEvent.contains(hasEvent))
			return;
		if (!_model.contains(_resource, hasEventProperty, hasEvent.resource()))
			return;
		this.hasEvent.remove(hasEvent);
		_model.removeAll(_resource, hasEventProperty, hasEvent.resource());
	}
		 
	public com.hp.hpl.jena.datatypes.xsd.XSDDateTime getStartedAt() throws JastorException {
		if (startedAt != null)
			return startedAt;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, startedAtProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": startedAt getProperty() in ibspan.tss.um.ontology.EventSession model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
		startedAt = (com.hp.hpl.jena.datatypes.xsd.XSDDateTime)obj;
		return startedAt;
	}
	
	public void setStartedAt(com.hp.hpl.jena.datatypes.xsd.XSDDateTime startedAt) throws JastorException {
		if (_model.contains(_resource,startedAtProperty)) {
			_model.removeAll(_resource,startedAtProperty,null);
		}
		this.startedAt = startedAt;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (startedAt != null) {
			_model.add(_model.createStatement(_resource,startedAtProperty, _model.createTypedLiteral(startedAt)));
		}	
	}

	public java.lang.String getHasSessionID() throws JastorException {
		if (hasSessionID != null)
			return hasSessionID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasSessionIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasSessionID getProperty() in ibspan.tss.um.ontology.EventSession model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasSessionID = (java.lang.String)obj;
		return hasSessionID;
	}
	
	public void setHasSessionID(java.lang.String hasSessionID) throws JastorException {
		if (_model.contains(_resource,hasSessionIDProperty)) {
			_model.removeAll(_resource,hasSessionIDProperty,null);
		}
		this.hasSessionID = hasSessionID;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasSessionID != null) {
			_model.add(_model.createStatement(_resource,hasSessionIDProperty, _model.createTypedLiteral(hasSessionID)));
		}	
	}

	public java.lang.Integer getHasUserID() throws JastorException {
		if (hasUserID != null)
			return hasUserID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserID getProperty() in ibspan.tss.um.ontology.EventSession model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasUserID = (java.lang.Integer)obj;
		return hasUserID;
	}
	
	public void setHasUserID(java.lang.Integer hasUserID) throws JastorException {
		if (_model.contains(_resource,hasUserIDProperty)) {
			_model.removeAll(_resource,hasUserIDProperty,null);
		}
		this.hasUserID = hasUserID;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasUserID != null) {
			_model.add(_model.createStatement(_resource,hasUserIDProperty, _model.createTypedLiteral(hasUserID)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof EventSessionListener))
			throw new IllegalArgumentException("ThingListener must be instance of EventSessionListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((EventSessionListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof EventSessionListener))
			throw new IllegalArgumentException("ThingListener must be instance of EventSessionListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasEventProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.Event _hasEvent = null;
					try {
						_hasEvent = ibspan.tss.um.ontology.UserModellingFactory.getEvent(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (hasEvent == null) {
						try {
							initHasEvent();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!hasEvent.contains(_hasEvent))
						hasEvent.add(_hasEvent);
					if (listeners != null) {
						java.util.ArrayList consumersForHasEvent;
						synchronized (listeners) {
							consumersForHasEvent = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasEvent.iterator();iter.hasNext();){
							EventSessionListener listener=(EventSessionListener)iter.next();
							listener.hasEventAdded(ibspan.tss.um.ontology.EventSessionImpl.this,_hasEvent);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(startedAtProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				startedAt = (com.hp.hpl.jena.datatypes.xsd.XSDDateTime)Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventSessionListener listener=(EventSessionListener)iter.next();
						listener.startedAtChanged(ibspan.tss.um.ontology.EventSessionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasSessionIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasSessionID = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventSessionListener listener=(EventSessionListener)iter.next();
						listener.hasSessionIDChanged(ibspan.tss.um.ontology.EventSessionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasUserIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasUserID = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventSessionListener listener=(EventSessionListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.EventSessionImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasEventProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.um.ontology.Event _hasEvent = null;
					if (hasEvent != null) {
						boolean found = false;
						for (int i=0;i<hasEvent.size();i++) {
							ibspan.tss.um.ontology.Event __item = (ibspan.tss.um.ontology.Event) hasEvent.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_hasEvent = __item;
								break;
							}
						}
						if (found)
							hasEvent.remove(_hasEvent);
						else {
							try {
								_hasEvent = ibspan.tss.um.ontology.UserModellingFactory.getEvent(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_hasEvent = ibspan.tss.um.ontology.UserModellingFactory.getEvent(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForHasEvent;
						synchronized (listeners) {
							consumersForHasEvent = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasEvent.iterator();iter.hasNext();){
							EventSessionListener listener=(EventSessionListener)iter.next();
							listener.hasEventRemoved(ibspan.tss.um.ontology.EventSessionImpl.this,_hasEvent);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(startedAtProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
				if (startedAt != null && startedAt.equals(obj))
					startedAt = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventSessionListener listener=(EventSessionListener)iter.next();
						listener.startedAtChanged(ibspan.tss.um.ontology.EventSessionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasSessionIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasSessionID != null && hasSessionID.equals(obj))
					hasSessionID = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventSessionListener listener=(EventSessionListener)iter.next();
						listener.hasSessionIDChanged(ibspan.tss.um.ontology.EventSessionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasUserIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasUserID != null && hasUserID.equals(obj))
					hasUserID = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventSessionListener listener=(EventSessionListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.EventSessionImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}