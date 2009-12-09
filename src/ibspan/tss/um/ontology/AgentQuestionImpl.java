

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
 * Implementation of {@link ibspan.tss.um.ontology.AgentQuestion}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#AgentQuestion)</p>
 * <br>
 */
public class AgentQuestionImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.AgentQuestion {
	

	private static com.hp.hpl.jena.rdf.model.Property hasLongMessageProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasLongMessage");
	private java.lang.String hasLongMessage;
	private static com.hp.hpl.jena.rdf.model.Property hasQuestionIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasQuestionID");
	private java.lang.Integer hasQuestionID;
	private static com.hp.hpl.jena.rdf.model.Property hasShortMessageProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasShortMessage");
	private java.lang.String hasShortMessage;
	private static com.hp.hpl.jena.rdf.model.Property hasScenarioActionNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasScenarioActionName");
	private java.lang.String hasScenarioActionName;
	private static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");
	private java.lang.Integer hasUserID;

	AgentQuestionImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static AgentQuestionImpl getAgentQuestion(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,AgentQuestion.TYPE))
			return null;
		return new AgentQuestionImpl(resource, model);
	}
	    
	static AgentQuestionImpl createAgentQuestion(Resource resource, Model model) throws JastorException {
		AgentQuestionImpl impl = new AgentQuestionImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, AgentQuestion.TYPE)))
			impl._model.add(impl._resource, RDF.type, AgentQuestion.TYPE);
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
		it = _model.listStatements(_resource,hasLongMessageProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasQuestionIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasShortMessageProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasScenarioActionNameProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.AgentQuestion.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasLongMessage = null;
		hasQuestionID = null;
		hasShortMessage = null;
		hasScenarioActionName = null;
		hasUserID = null;
	}

	public java.lang.String getHasLongMessage() throws JastorException {
		if (hasLongMessage != null)
			return hasLongMessage;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasLongMessageProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasLongMessage getProperty() in ibspan.tss.um.ontology.AgentQuestion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasLongMessage = (java.lang.String)obj;
		return hasLongMessage;
	}
	
	public void setHasLongMessage(java.lang.String hasLongMessage) throws JastorException {
		if (_model.contains(_resource,hasLongMessageProperty)) {
			_model.removeAll(_resource,hasLongMessageProperty,null);
		}
		this.hasLongMessage = hasLongMessage;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasLongMessage != null) {
			_model.add(_model.createStatement(_resource,hasLongMessageProperty, _model.createTypedLiteral(hasLongMessage)));
		}	
	}

	public java.lang.Integer getHasQuestionID() throws JastorException {
		if (hasQuestionID != null)
			return hasQuestionID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasQuestionIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasQuestionID getProperty() in ibspan.tss.um.ontology.AgentQuestion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasQuestionID = (java.lang.Integer)obj;
		return hasQuestionID;
	}
	
	public void setHasQuestionID(java.lang.Integer hasQuestionID) throws JastorException {
		if (_model.contains(_resource,hasQuestionIDProperty)) {
			_model.removeAll(_resource,hasQuestionIDProperty,null);
		}
		this.hasQuestionID = hasQuestionID;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasQuestionID != null) {
			_model.add(_model.createStatement(_resource,hasQuestionIDProperty, _model.createTypedLiteral(hasQuestionID)));
		}	
	}

	public java.lang.String getHasShortMessage() throws JastorException {
		if (hasShortMessage != null)
			return hasShortMessage;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasShortMessageProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasShortMessage getProperty() in ibspan.tss.um.ontology.AgentQuestion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasShortMessage = (java.lang.String)obj;
		return hasShortMessage;
	}
	
	public void setHasShortMessage(java.lang.String hasShortMessage) throws JastorException {
		if (_model.contains(_resource,hasShortMessageProperty)) {
			_model.removeAll(_resource,hasShortMessageProperty,null);
		}
		this.hasShortMessage = hasShortMessage;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasShortMessage != null) {
			_model.add(_model.createStatement(_resource,hasShortMessageProperty, _model.createTypedLiteral(hasShortMessage)));
		}	
	}

	public java.lang.String getHasScenarioActionName() throws JastorException {
		if (hasScenarioActionName != null)
			return hasScenarioActionName;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasScenarioActionNameProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasScenarioActionName getProperty() in ibspan.tss.um.ontology.AgentQuestion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasScenarioActionName = (java.lang.String)obj;
		return hasScenarioActionName;
	}
	
	public void setHasScenarioActionName(java.lang.String hasScenarioActionName) throws JastorException {
		if (_model.contains(_resource,hasScenarioActionNameProperty)) {
			_model.removeAll(_resource,hasScenarioActionNameProperty,null);
		}
		this.hasScenarioActionName = hasScenarioActionName;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasScenarioActionName != null) {
			_model.add(_model.createStatement(_resource,hasScenarioActionNameProperty, _model.createTypedLiteral(hasScenarioActionName)));
		}	
	}

	public java.lang.Integer getHasUserID() throws JastorException {
		if (hasUserID != null)
			return hasUserID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserID getProperty() in ibspan.tss.um.ontology.AgentQuestion model not Literal", stmt.getObject());
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
		if (!(listener instanceof AgentQuestionListener))
			throw new IllegalArgumentException("ThingListener must be instance of AgentQuestionListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((AgentQuestionListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof AgentQuestionListener))
			throw new IllegalArgumentException("ThingListener must be instance of AgentQuestionListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasLongMessageProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasLongMessage = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasLongMessageChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasQuestionIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasQuestionID = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasQuestionIDChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasShortMessageProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasShortMessage = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasShortMessageChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasScenarioActionNameProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasScenarioActionName = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasScenarioActionNameChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
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
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasLongMessageProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasLongMessage != null && hasLongMessage.equals(obj))
					hasLongMessage = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasLongMessageChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasQuestionIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasQuestionID != null && hasQuestionID.equals(obj))
					hasQuestionID = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasQuestionIDChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasShortMessageProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasShortMessage != null && hasShortMessage.equals(obj))
					hasShortMessage = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasShortMessageChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasScenarioActionNameProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasScenarioActionName != null && hasScenarioActionName.equals(obj))
					hasScenarioActionName = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasScenarioActionNameChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
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
						AgentQuestionListener listener=(AgentQuestionListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.AgentQuestionImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}