

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
 * Implementation of {@link ibspan.tss.um.ontology.StatisticEntry}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StatisticEntry)</p>
 * <br>
 */
public class StatisticEntryImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.StatisticEntry {
	

	private static com.hp.hpl.jena.rdf.model.Property hasConceptURIProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasConceptURI");
	private java.lang.String hasConceptURI;
	private static com.hp.hpl.jena.rdf.model.Property hasCountProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasCount");
	private java.lang.Integer hasCount;
	private static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");
	private java.lang.Integer hasUserID;
	private static com.hp.hpl.jena.rdf.model.Property hasUserBehaviourProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserBehaviour");
	private ibspan.tss.um.ontology.UserBehaviour hasUserBehaviour;

	StatisticEntryImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static StatisticEntryImpl getStatisticEntry(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,StatisticEntry.TYPE))
			return null;
		return new StatisticEntryImpl(resource, model);
	}
	    
	static StatisticEntryImpl createStatisticEntry(Resource resource, Model model) throws JastorException {
		StatisticEntryImpl impl = new StatisticEntryImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, StatisticEntry.TYPE)))
			impl._model.add(impl._resource, RDF.type, StatisticEntry.TYPE);
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
		it = _model.listStatements(_resource,hasConceptURIProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasCountProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserBehaviourProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.StatisticEntry.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasConceptURI = null;
		hasCount = null;
		hasUserID = null;
		hasUserBehaviour = null;
	}

	public java.lang.String getHasConceptURI() throws JastorException {
		if (hasConceptURI != null)
			return hasConceptURI;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasConceptURIProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasConceptURI getProperty() in ibspan.tss.um.ontology.StatisticEntry model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasConceptURI = (java.lang.String)obj;
		return hasConceptURI;
	}
	
	public void setHasConceptURI(java.lang.String hasConceptURI) throws JastorException {
		if (_model.contains(_resource,hasConceptURIProperty)) {
			_model.removeAll(_resource,hasConceptURIProperty,null);
		}
		this.hasConceptURI = hasConceptURI;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasConceptURI != null) {
			_model.add(_model.createStatement(_resource,hasConceptURIProperty, _model.createTypedLiteral(hasConceptURI)));
		}	
	}

	public java.lang.Integer getHasCount() throws JastorException {
		if (hasCount != null)
			return hasCount;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasCountProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasCount getProperty() in ibspan.tss.um.ontology.StatisticEntry model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasCount = (java.lang.Integer)obj;
		return hasCount;
	}
	
	public void setHasCount(java.lang.Integer hasCount) throws JastorException {
		if (_model.contains(_resource,hasCountProperty)) {
			_model.removeAll(_resource,hasCountProperty,null);
		}
		this.hasCount = hasCount;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasCount != null) {
			_model.add(_model.createStatement(_resource,hasCountProperty, _model.createTypedLiteral(hasCount)));
		}	
	}

	public java.lang.Integer getHasUserID() throws JastorException {
		if (hasUserID != null)
			return hasUserID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserID getProperty() in ibspan.tss.um.ontology.StatisticEntry model not Literal", stmt.getObject());
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


	public ibspan.tss.um.ontology.UserBehaviour getHasUserBehaviour() throws JastorException {
		if (hasUserBehaviour != null)
			return hasUserBehaviour;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserBehaviourProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserBehaviour getProperty() in ibspan.tss.um.ontology.StatisticEntry model not Resource", stmt.getObject());
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
		if (!(listener instanceof StatisticEntryListener))
			throw new IllegalArgumentException("ThingListener must be instance of StatisticEntryListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((StatisticEntryListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof StatisticEntryListener))
			throw new IllegalArgumentException("ThingListener must be instance of StatisticEntryListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasConceptURIProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasConceptURI = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasConceptURIChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasCountProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasCount = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasCountChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
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
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
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
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasUserBehaviourChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasConceptURIProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasConceptURI != null && hasConceptURI.equals(obj))
					hasConceptURI = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasConceptURIChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasCountProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasCount != null && hasCount.equals(obj))
					hasCount = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasCountChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
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
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
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
						StatisticEntryListener listener=(StatisticEntryListener)iter.next();
						listener.hasUserBehaviourChanged(ibspan.tss.um.ontology.StatisticEntryImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}