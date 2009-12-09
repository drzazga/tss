

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
 * Implementation of {@link ibspan.tss.um.ontology.Profile}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Profile)</p>
 * <br>
 */
public class ProfileImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.Profile {
	

	private static com.hp.hpl.jena.rdf.model.Property hasOpinionsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasOpinions");
	private ibspan.tss.um.ontology.OpinionSet hasOpinions;

	ProfileImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static ProfileImpl getProfile(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Profile.TYPE))
			return null;
		return new ProfileImpl(resource, model);
	}
	    
	static ProfileImpl createProfile(Resource resource, Model model) throws JastorException {
		ProfileImpl impl = new ProfileImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Profile.TYPE)))
			impl._model.add(impl._resource, RDF.type, Profile.TYPE);
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
		it = _model.listStatements(_resource,hasOpinionsProperty,(RDFNode)null);
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
	}


	public ibspan.tss.um.ontology.OpinionSet getHasOpinions() throws JastorException {
		if (hasOpinions != null)
			return hasOpinions;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasOpinionsProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasOpinions getProperty() in ibspan.tss.um.ontology.Profile model not Resource", stmt.getObject());
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
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof ProfileListener))
			throw new IllegalArgumentException("ThingListener must be instance of ProfileListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((ProfileListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof ProfileListener))
			throw new IllegalArgumentException("ThingListener must be instance of ProfileListener"); 
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
						ProfileListener listener=(ProfileListener)iter.next();
						listener.hasOpinionsChanged(ibspan.tss.um.ontology.ProfileImpl.this);
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
						ProfileListener listener=(ProfileListener)iter.next();
						listener.hasOpinionsChanged(ibspan.tss.um.ontology.ProfileImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}