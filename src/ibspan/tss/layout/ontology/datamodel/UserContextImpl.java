

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
 * Implementation of {@link ibspan.tss.layout.ontology.datamodel.UserContext}
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#UserContext)</p>
 * <br>
 */
public class UserContextImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.layout.ontology.datamodel.UserContext {
	

	private static com.hp.hpl.jena.rdf.model.Property hasSessionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasSessionID");
	private java.lang.String hasSessionID;
	private static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasUserID");
	private java.lang.Integer hasUserID;
	private static com.hp.hpl.jena.rdf.model.Property hasInterfaceHostProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasInterfaceHost");
	private java.lang.String hasInterfaceHost;
	private static com.hp.hpl.jena.rdf.model.Property hasMediaTypeProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasMediaType");
	private java.lang.String hasMediaType;
	private static com.hp.hpl.jena.rdf.model.Property hasInterfacePortProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasInterfacePort");
	private java.lang.Integer hasInterfacePort;

	UserContextImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static UserContextImpl getUserContext(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,UserContext.TYPE))
			return null;
		return new UserContextImpl(resource, model);
	}
	    
	static UserContextImpl createUserContext(Resource resource, Model model) throws JastorException {
		UserContextImpl impl = new UserContextImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, UserContext.TYPE)))
			impl._model.add(impl._resource, RDF.type, UserContext.TYPE);
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
		it = _model.listStatements(_resource,hasSessionIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasInterfaceHostProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasMediaTypeProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasInterfacePortProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.UserContext.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasSessionID = null;
		hasUserID = null;
		hasInterfaceHost = null;
		hasMediaType = null;
		hasInterfacePort = null;
	}

	public java.lang.String getHasSessionID() throws JastorException {
		if (hasSessionID != null)
			return hasSessionID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasSessionIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasSessionID getProperty() in ibspan.tss.layout.ontology.datamodel.UserContext model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserID getProperty() in ibspan.tss.layout.ontology.datamodel.UserContext model not Literal", stmt.getObject());
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

	public java.lang.String getHasInterfaceHost() throws JastorException {
		if (hasInterfaceHost != null)
			return hasInterfaceHost;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasInterfaceHostProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasInterfaceHost getProperty() in ibspan.tss.layout.ontology.datamodel.UserContext model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasInterfaceHost = (java.lang.String)obj;
		return hasInterfaceHost;
	}
	
	public void setHasInterfaceHost(java.lang.String hasInterfaceHost) throws JastorException {
		if (_model.contains(_resource,hasInterfaceHostProperty)) {
			_model.removeAll(_resource,hasInterfaceHostProperty,null);
		}
		this.hasInterfaceHost = hasInterfaceHost;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasInterfaceHost != null) {
			_model.add(_model.createStatement(_resource,hasInterfaceHostProperty, _model.createTypedLiteral(hasInterfaceHost)));
		}	
	}

	public java.lang.String getHasMediaType() throws JastorException {
		if (hasMediaType != null)
			return hasMediaType;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasMediaTypeProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasMediaType getProperty() in ibspan.tss.layout.ontology.datamodel.UserContext model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasMediaType = (java.lang.String)obj;
		return hasMediaType;
	}
	
	public void setHasMediaType(java.lang.String hasMediaType) throws JastorException {
		if (_model.contains(_resource,hasMediaTypeProperty)) {
			_model.removeAll(_resource,hasMediaTypeProperty,null);
		}
		this.hasMediaType = hasMediaType;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasMediaType != null) {
			_model.add(_model.createStatement(_resource,hasMediaTypeProperty, _model.createTypedLiteral(hasMediaType)));
		}	
	}

	public java.lang.Integer getHasInterfacePort() throws JastorException {
		if (hasInterfacePort != null)
			return hasInterfacePort;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasInterfacePortProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasInterfacePort getProperty() in ibspan.tss.layout.ontology.datamodel.UserContext model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasInterfacePort = (java.lang.Integer)obj;
		return hasInterfacePort;
	}
	
	public void setHasInterfacePort(java.lang.Integer hasInterfacePort) throws JastorException {
		if (_model.contains(_resource,hasInterfacePortProperty)) {
			_model.removeAll(_resource,hasInterfacePortProperty,null);
		}
		this.hasInterfacePort = hasInterfacePort;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasInterfacePort != null) {
			_model.add(_model.createStatement(_resource,hasInterfacePortProperty, _model.createTypedLiteral(hasInterfacePort)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof UserContextListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserContextListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((UserContextListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof UserContextListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserContextListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

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
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasSessionIDChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
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
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasInterfaceHostProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasInterfaceHost = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasInterfaceHostChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasMediaTypeProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasMediaType = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasMediaTypeChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasInterfacePortProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasInterfacePort = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasInterfacePortChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
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
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasSessionIDChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
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
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasInterfaceHostProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasInterfaceHost != null && hasInterfaceHost.equals(obj))
					hasInterfaceHost = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasInterfaceHostChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasMediaTypeProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasMediaType != null && hasMediaType.equals(obj))
					hasMediaType = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasMediaTypeChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasInterfacePortProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasInterfacePort != null && hasInterfacePort.equals(obj))
					hasInterfacePort = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserContextListener listener=(UserContextListener)iter.next();
						listener.hasInterfacePortChanged(ibspan.tss.layout.ontology.datamodel.UserContextImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}