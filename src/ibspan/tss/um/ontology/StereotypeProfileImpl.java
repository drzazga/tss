

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
 * Implementation of {@link ibspan.tss.um.ontology.StereotypeProfile}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfile)</p>
 * <br>
 */
public class StereotypeProfileImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.StereotypeProfile {
	

	private static com.hp.hpl.jena.rdf.model.Property hasOpinionsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasOpinions");
	private ibspan.tss.um.ontology.OpinionSet hasOpinions;
	private static com.hp.hpl.jena.rdf.model.Property hasStereotypeDataProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasStereotypeData");
	private ibspan.tss.um.ontology.StereotypeProfileData hasStereotypeData;
	private static com.hp.hpl.jena.rdf.model.Property hasStereotypeIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasStereotypeID");
	private java.lang.Integer hasStereotypeID;

	StereotypeProfileImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static StereotypeProfileImpl getStereotypeProfile(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,StereotypeProfile.TYPE))
			return null;
		return new StereotypeProfileImpl(resource, model);
	}
	    
	static StereotypeProfileImpl createStereotypeProfile(Resource resource, Model model) throws JastorException {
		StereotypeProfileImpl impl = new StereotypeProfileImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, StereotypeProfile.TYPE)))
			impl._model.add(impl._resource, RDF.type, StereotypeProfile.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Profile.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Profile.TYPE));     
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
		it = _model.listStatements(_resource,hasOpinionsProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasStereotypeDataProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasStereotypeIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.StereotypeProfile.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Profile.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasOpinions = null;
		hasStereotypeData = null;
		hasStereotypeID = null;
	}


	public ibspan.tss.um.ontology.OpinionSet getHasOpinions() throws JastorException {
		if (hasOpinions != null)
			return hasOpinions;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasOpinionsProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasOpinions getProperty() in ibspan.tss.um.ontology.StereotypeProfile model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasOpinions = ibspan.tss.um.ontology.UserModellingFactory.getOpinionSet(resource,_model);
		return hasOpinions;
	}

	public void setHasOpinions(ibspan.tss.um.ontology.OpinionSet hasOpinions) throws JastorException {
		if (_model.contains(_resource,hasOpinionsProperty)) {
			_model.removeAll(_resource,hasOpinionsProperty,null);
		}
		this.hasOpinions = hasOpinions;
		if (hasOpinions != null) {
			_model.add(_model.createStatement(_resource,hasOpinionsProperty, hasOpinions.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.OpinionSet setHasOpinions() throws JastorException {
		if (_model.contains(_resource,hasOpinionsProperty)) {
			_model.removeAll(_resource,hasOpinionsProperty,null);
		}
		ibspan.tss.um.ontology.OpinionSet hasOpinions = ibspan.tss.um.ontology.UserModellingFactory.createOpinionSet(_model.createResource(),_model);
		this.hasOpinions = hasOpinions;
		_model.add(_model.createStatement(_resource,hasOpinionsProperty, hasOpinions.resource()));
		return hasOpinions;
	}
	
	public ibspan.tss.um.ontology.OpinionSet setHasOpinions(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.OpinionSet.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.OpinionSet.TYPE);
		if (_model.contains(_resource,hasOpinionsProperty)) {
			_model.removeAll(_resource,hasOpinionsProperty,null);
		}
		ibspan.tss.um.ontology.OpinionSet hasOpinions = ibspan.tss.um.ontology.UserModellingFactory.getOpinionSet(resource,_model);
		this.hasOpinions = hasOpinions;
		_model.add(_model.createStatement(_resource,hasOpinionsProperty, hasOpinions.resource()));
		return hasOpinions;
	}
	

	public ibspan.tss.um.ontology.StereotypeProfileData getHasStereotypeData() throws JastorException {
		if (hasStereotypeData != null)
			return hasStereotypeData;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasStereotypeDataProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasStereotypeData getProperty() in ibspan.tss.um.ontology.StereotypeProfile model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasStereotypeData = ibspan.tss.um.ontology.UserModellingFactory.getStereotypeProfileData(resource,_model);
		return hasStereotypeData;
	}

	public void setHasStereotypeData(ibspan.tss.um.ontology.StereotypeProfileData hasStereotypeData) throws JastorException {
		if (_model.contains(_resource,hasStereotypeDataProperty)) {
			_model.removeAll(_resource,hasStereotypeDataProperty,null);
		}
		this.hasStereotypeData = hasStereotypeData;
		if (hasStereotypeData != null) {
			_model.add(_model.createStatement(_resource,hasStereotypeDataProperty, hasStereotypeData.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.StereotypeProfileData setHasStereotypeData() throws JastorException {
		if (_model.contains(_resource,hasStereotypeDataProperty)) {
			_model.removeAll(_resource,hasStereotypeDataProperty,null);
		}
		ibspan.tss.um.ontology.StereotypeProfileData hasStereotypeData = ibspan.tss.um.ontology.UserModellingFactory.createStereotypeProfileData(_model.createResource(),_model);
		this.hasStereotypeData = hasStereotypeData;
		_model.add(_model.createStatement(_resource,hasStereotypeDataProperty, hasStereotypeData.resource()));
		return hasStereotypeData;
	}
	
	public ibspan.tss.um.ontology.StereotypeProfileData setHasStereotypeData(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.StereotypeProfileData.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.StereotypeProfileData.TYPE);
		if (_model.contains(_resource,hasStereotypeDataProperty)) {
			_model.removeAll(_resource,hasStereotypeDataProperty,null);
		}
		ibspan.tss.um.ontology.StereotypeProfileData hasStereotypeData = ibspan.tss.um.ontology.UserModellingFactory.getStereotypeProfileData(resource,_model);
		this.hasStereotypeData = hasStereotypeData;
		_model.add(_model.createStatement(_resource,hasStereotypeDataProperty, hasStereotypeData.resource()));
		return hasStereotypeData;
	}
	
	public java.lang.Integer getHasStereotypeID() throws JastorException {
		if (hasStereotypeID != null)
			return hasStereotypeID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasStereotypeIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasStereotypeID getProperty() in ibspan.tss.um.ontology.StereotypeProfile model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasStereotypeID = (java.lang.Integer)obj;
		return hasStereotypeID;
	}
	
	public void setHasStereotypeID(java.lang.Integer hasStereotypeID) throws JastorException {
		if (_model.contains(_resource,hasStereotypeIDProperty)) {
			_model.removeAll(_resource,hasStereotypeIDProperty,null);
		}
		this.hasStereotypeID = hasStereotypeID;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasStereotypeID != null) {
			_model.add(_model.createStatement(_resource,hasStereotypeIDProperty, _model.createTypedLiteral(hasStereotypeID)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof StereotypeProfileListener))
			throw new IllegalArgumentException("ThingListener must be instance of StereotypeProfileListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((StereotypeProfileListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof StereotypeProfileListener))
			throw new IllegalArgumentException("ThingListener must be instance of StereotypeProfileListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasOpinionsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasOpinions = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasOpinions = ibspan.tss.um.ontology.UserModellingFactory.getOpinionSet(resource,_model);
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
						StereotypeProfileListener listener=(StereotypeProfileListener)iter.next();
						listener.hasOpinionsChanged(ibspan.tss.um.ontology.StereotypeProfileImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasStereotypeDataProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasStereotypeData = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasStereotypeData = ibspan.tss.um.ontology.UserModellingFactory.getStereotypeProfileData(resource,_model);
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
						StereotypeProfileListener listener=(StereotypeProfileListener)iter.next();
						listener.hasStereotypeDataChanged(ibspan.tss.um.ontology.StereotypeProfileImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasStereotypeIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasStereotypeID = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileListener listener=(StereotypeProfileListener)iter.next();
						listener.hasStereotypeIDChanged(ibspan.tss.um.ontology.StereotypeProfileImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasOpinionsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasOpinions != null && hasOpinions.resource().equals(resource))
						hasOpinions = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileListener listener=(StereotypeProfileListener)iter.next();
						listener.hasOpinionsChanged(ibspan.tss.um.ontology.StereotypeProfileImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasStereotypeDataProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasStereotypeData != null && hasStereotypeData.resource().equals(resource))
						hasStereotypeData = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileListener listener=(StereotypeProfileListener)iter.next();
						listener.hasStereotypeDataChanged(ibspan.tss.um.ontology.StereotypeProfileImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasStereotypeIDProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasStereotypeID != null && hasStereotypeID.equals(obj))
					hasStereotypeID = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileListener listener=(StereotypeProfileListener)iter.next();
						listener.hasStereotypeIDChanged(ibspan.tss.um.ontology.StereotypeProfileImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}