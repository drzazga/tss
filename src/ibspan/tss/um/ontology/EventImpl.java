

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
 * Implementation of {@link ibspan.tss.um.ontology.Event}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Event)</p>
 * <br>
 */
public class EventImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.Event {
	

	private static com.hp.hpl.jena.rdf.model.Property hasExtendedUserBehaviourProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasExtendedUserBehaviour");
	private ibspan.tss.um.ontology.ExtendedUserBehaviour hasExtendedUserBehaviour;
	private static com.hp.hpl.jena.rdf.model.Property whenProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#when");
	private com.hp.hpl.jena.datatypes.xsd.XSDDateTime when;
	private static com.hp.hpl.jena.rdf.model.Property hasEventIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasEventID");
	private java.lang.Integer hasEventID;
	private static com.hp.hpl.jena.rdf.model.Property hasSessionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasSessionID");
	private java.lang.String hasSessionID;
	private static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");
	private java.lang.Integer hasUserID;

	EventImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static EventImpl getEvent(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Event.TYPE))
			return null;
		return new EventImpl(resource, model);
	}
	    
	static EventImpl createEvent(Resource resource, Model model) throws JastorException {
		EventImpl impl = new EventImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Event.TYPE)))
			impl._model.add(impl._resource, RDF.type, Event.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsLastEvent() throws JastorException {
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
		it = _model.listStatements(_resource,hasExtendedUserBehaviourProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,whenProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasEventIDProperty,(RDFNode)null);
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Event.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasExtendedUserBehaviour = null;
		when = null;
		hasEventID = null;
		hasSessionID = null;
		hasUserID = null;
	}


	public ibspan.tss.um.ontology.ExtendedUserBehaviour getHasExtendedUserBehaviour() throws JastorException {
		if (hasExtendedUserBehaviour != null)
			return hasExtendedUserBehaviour;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasExtendedUserBehaviourProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasExtendedUserBehaviour getProperty() in ibspan.tss.um.ontology.Event model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasExtendedUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.getExtendedUserBehaviour(resource,_model);
		return hasExtendedUserBehaviour;
	}

	public void setHasExtendedUserBehaviour(ibspan.tss.um.ontology.ExtendedUserBehaviour hasExtendedUserBehaviour) throws JastorException {
		if (_model.contains(_resource,hasExtendedUserBehaviourProperty)) {
			_model.removeAll(_resource,hasExtendedUserBehaviourProperty,null);
		}
		this.hasExtendedUserBehaviour = hasExtendedUserBehaviour;
		if (hasExtendedUserBehaviour != null) {
			_model.add(_model.createStatement(_resource,hasExtendedUserBehaviourProperty, hasExtendedUserBehaviour.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.ExtendedUserBehaviour setHasExtendedUserBehaviour() throws JastorException {
		if (_model.contains(_resource,hasExtendedUserBehaviourProperty)) {
			_model.removeAll(_resource,hasExtendedUserBehaviourProperty,null);
		}
		ibspan.tss.um.ontology.ExtendedUserBehaviour hasExtendedUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.createExtendedUserBehaviour(_model.createResource(),_model);
		this.hasExtendedUserBehaviour = hasExtendedUserBehaviour;
		_model.add(_model.createStatement(_resource,hasExtendedUserBehaviourProperty, hasExtendedUserBehaviour.resource()));
		return hasExtendedUserBehaviour;
	}
	
	public ibspan.tss.um.ontology.ExtendedUserBehaviour setHasExtendedUserBehaviour(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.ExtendedUserBehaviour.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.ExtendedUserBehaviour.TYPE);
		if (_model.contains(_resource,hasExtendedUserBehaviourProperty)) {
			_model.removeAll(_resource,hasExtendedUserBehaviourProperty,null);
		}
		ibspan.tss.um.ontology.ExtendedUserBehaviour hasExtendedUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.getExtendedUserBehaviour(resource,_model);
		this.hasExtendedUserBehaviour = hasExtendedUserBehaviour;
		_model.add(_model.createStatement(_resource,hasExtendedUserBehaviourProperty, hasExtendedUserBehaviour.resource()));
		return hasExtendedUserBehaviour;
	}
	
	public com.hp.hpl.jena.datatypes.xsd.XSDDateTime getWhen() throws JastorException {
		if (when != null)
			return when;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, whenProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": when getProperty() in ibspan.tss.um.ontology.Event model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
		when = (com.hp.hpl.jena.datatypes.xsd.XSDDateTime)obj;
		return when;
	}
	
	public void setWhen(com.hp.hpl.jena.datatypes.xsd.XSDDateTime when) throws JastorException {
		if (_model.contains(_resource,whenProperty)) {
			_model.removeAll(_resource,whenProperty,null);
		}
		this.when = when;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (when != null) {
			_model.add(_model.createStatement(_resource,whenProperty, _model.createTypedLiteral(when)));
		}	
	}

	public java.lang.Integer getHasEventID() throws JastorException {
		if (hasEventID != null)
			return hasEventID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasEventIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasEventID getProperty() in ibspan.tss.um.ontology.Event model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasEventID = (java.lang.Integer)obj;
		return hasEventID;
	}
	
	public void setHasEventID(java.lang.Integer hasEventID) throws JastorException {
		if (_model.contains(_resource,hasEventIDProperty)) {
			_model.removeAll(_resource,hasEventIDProperty,null);
		}
		this.hasEventID = hasEventID;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasEventID != null) {
			_model.add(_model.createStatement(_resource,hasEventIDProperty, _model.createTypedLiteral(hasEventID)));
		}	
	}

	public java.lang.String getHasSessionID() throws JastorException {
		if (hasSessionID != null)
			return hasSessionID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasSessionIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasSessionID getProperty() in ibspan.tss.um.ontology.Event model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserID getProperty() in ibspan.tss.um.ontology.Event model not Literal", stmt.getObject());
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
		if (!(listener instanceof EventListener))
			throw new IllegalArgumentException("ThingListener must be instance of EventListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((EventListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof EventListener))
			throw new IllegalArgumentException("ThingListener must be instance of EventListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasExtendedUserBehaviourProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasExtendedUserBehaviour = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasExtendedUserBehaviour = ibspan.tss.um.ontology.UserModellingFactory.getExtendedUserBehaviour(resource,_model);
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
						EventListener listener=(EventListener)iter.next();
						listener.hasExtendedUserBehaviourChanged(ibspan.tss.um.ontology.EventImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(whenProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				when = (com.hp.hpl.jena.datatypes.xsd.XSDDateTime)Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventListener listener=(EventListener)iter.next();
						listener.whenChanged(ibspan.tss.um.ontology.EventImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasEventIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasEventID = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventListener listener=(EventListener)iter.next();
						listener.hasEventIDChanged(ibspan.tss.um.ontology.EventImpl.this);
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
						EventListener listener=(EventListener)iter.next();
						listener.hasSessionIDChanged(ibspan.tss.um.ontology.EventImpl.this);
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
						EventListener listener=(EventListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.EventImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasExtendedUserBehaviourProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasExtendedUserBehaviour != null && hasExtendedUserBehaviour.resource().equals(resource))
						hasExtendedUserBehaviour = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventListener listener=(EventListener)iter.next();
						listener.hasExtendedUserBehaviourChanged(ibspan.tss.um.ontology.EventImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(whenProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.XSDDateTime");
				if (when != null && when.equals(obj))
					when = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventListener listener=(EventListener)iter.next();
						listener.whenChanged(ibspan.tss.um.ontology.EventImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasEventIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasEventID != null && hasEventID.equals(obj))
					hasEventID = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						EventListener listener=(EventListener)iter.next();
						listener.hasEventIDChanged(ibspan.tss.um.ontology.EventImpl.this);
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
						EventListener listener=(EventListener)iter.next();
						listener.hasSessionIDChanged(ibspan.tss.um.ontology.EventImpl.this);
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
						EventListener listener=(EventListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.EventImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}