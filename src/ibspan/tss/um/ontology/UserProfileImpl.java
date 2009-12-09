

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
 * Implementation of {@link ibspan.tss.um.ontology.UserProfile}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserProfile)</p>
 * <br>
 */
public class UserProfileImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.UserProfile {
	

	private static com.hp.hpl.jena.rdf.model.Property hasOpinionsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasOpinions");
	private ibspan.tss.um.ontology.OpinionSet hasOpinions;
	private static com.hp.hpl.jena.rdf.model.Property hasUserProfileDataProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserProfileData");
	private ibspan.tss.um.ontology.UserProfileData hasUserProfileData;
	private static com.hp.hpl.jena.rdf.model.Property hasUserIDProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasUserID");
	private java.lang.Integer hasUserID;

	UserProfileImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static UserProfileImpl getUserProfile(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,UserProfile.TYPE))
			return null;
		return new UserProfileImpl(resource, model);
	}
	    
	static UserProfileImpl createUserProfile(Resource resource, Model model) throws JastorException {
		UserProfileImpl impl = new UserProfileImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, UserProfile.TYPE)))
			impl._model.add(impl._resource, RDF.type, UserProfile.TYPE);
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
		it = _model.listStatements(_resource,hasUserProfileDataProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasUserIDProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.UserProfile.TYPE);
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
		hasUserProfileData = null;
		hasUserID = null;
	}


	public ibspan.tss.um.ontology.OpinionSet getHasOpinions() throws JastorException {
		if (hasOpinions != null)
			return hasOpinions;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasOpinionsProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasOpinions getProperty() in ibspan.tss.um.ontology.UserProfile model not Resource", stmt.getObject());
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
	

	public ibspan.tss.um.ontology.UserProfileData getHasUserProfileData() throws JastorException {
		if (hasUserProfileData != null)
			return hasUserProfileData;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserProfileDataProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserProfileData getProperty() in ibspan.tss.um.ontology.UserProfile model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasUserProfileData = ibspan.tss.um.ontology.UserModellingFactory.getUserProfileData(resource,_model);
		return hasUserProfileData;
	}

	public void setHasUserProfileData(ibspan.tss.um.ontology.UserProfileData hasUserProfileData) throws JastorException {
		if (_model.contains(_resource,hasUserProfileDataProperty)) {
			_model.removeAll(_resource,hasUserProfileDataProperty,null);
		}
		this.hasUserProfileData = hasUserProfileData;
		if (hasUserProfileData != null) {
			_model.add(_model.createStatement(_resource,hasUserProfileDataProperty, hasUserProfileData.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.UserProfileData setHasUserProfileData() throws JastorException {
		if (_model.contains(_resource,hasUserProfileDataProperty)) {
			_model.removeAll(_resource,hasUserProfileDataProperty,null);
		}
		ibspan.tss.um.ontology.UserProfileData hasUserProfileData = ibspan.tss.um.ontology.UserModellingFactory.createUserProfileData(_model.createResource(),_model);
		this.hasUserProfileData = hasUserProfileData;
		_model.add(_model.createStatement(_resource,hasUserProfileDataProperty, hasUserProfileData.resource()));
		return hasUserProfileData;
	}
	
	public ibspan.tss.um.ontology.UserProfileData setHasUserProfileData(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.UserProfileData.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.UserProfileData.TYPE);
		if (_model.contains(_resource,hasUserProfileDataProperty)) {
			_model.removeAll(_resource,hasUserProfileDataProperty,null);
		}
		ibspan.tss.um.ontology.UserProfileData hasUserProfileData = ibspan.tss.um.ontology.UserModellingFactory.getUserProfileData(resource,_model);
		this.hasUserProfileData = hasUserProfileData;
		_model.add(_model.createStatement(_resource,hasUserProfileDataProperty, hasUserProfileData.resource()));
		return hasUserProfileData;
	}
	
	public java.lang.Integer getHasUserID() throws JastorException {
		if (hasUserID != null)
			return hasUserID;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasUserIDProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasUserID getProperty() in ibspan.tss.um.ontology.UserProfile model not Literal", stmt.getObject());
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
		if (!(listener instanceof UserProfileListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserProfileListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((UserProfileListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof UserProfileListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserProfileListener"); 
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
						UserProfileListener listener=(UserProfileListener)iter.next();
						listener.hasOpinionsChanged(ibspan.tss.um.ontology.UserProfileImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasUserProfileDataProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasUserProfileData = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasUserProfileData = ibspan.tss.um.ontology.UserModellingFactory.getUserProfileData(resource,_model);
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
						UserProfileListener listener=(UserProfileListener)iter.next();
						listener.hasUserProfileDataChanged(ibspan.tss.um.ontology.UserProfileImpl.this);
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
						UserProfileListener listener=(UserProfileListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.UserProfileImpl.this);
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
						UserProfileListener listener=(UserProfileListener)iter.next();
						listener.hasOpinionsChanged(ibspan.tss.um.ontology.UserProfileImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasUserProfileDataProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasUserProfileData != null && hasUserProfileData.resource().equals(resource))
						hasUserProfileData = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileListener listener=(UserProfileListener)iter.next();
						listener.hasUserProfileDataChanged(ibspan.tss.um.ontology.UserProfileImpl.this);
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
						UserProfileListener listener=(UserProfileListener)iter.next();
						listener.hasUserIDChanged(ibspan.tss.um.ontology.UserProfileImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}