

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
 * Implementation of {@link ibspan.tss.um.ontology.StereotypeProfileData}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StereotypeProfileData)</p>
 * <br>
 */
public class StereotypeProfileDataImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.StereotypeProfileData {
	

	private static com.hp.hpl.jena.rdf.model.Property hasWealthSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasWealthSet");
	private ibspan.tss.um.ontology.WealthSet hasWealthSet;
	private static com.hp.hpl.jena.rdf.model.Property hasDressSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasDressSet");
	private ibspan.tss.um.ontology.DressSet hasDressSet;
	private static com.hp.hpl.jena.rdf.model.Property hasProfessionSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasProfessionSet");
	private ibspan.tss.um.ontology.ProfessionSet hasProfessionSet;
	private static com.hp.hpl.jena.rdf.model.Property hasAgeSetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasAgeSet");
	private ibspan.tss.um.ontology.AgeSet hasAgeSet;

	StereotypeProfileDataImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static StereotypeProfileDataImpl getStereotypeProfileData(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,StereotypeProfileData.TYPE))
			return null;
		return new StereotypeProfileDataImpl(resource, model);
	}
	    
	static StereotypeProfileDataImpl createStereotypeProfileData(Resource resource, Model model) throws JastorException {
		StereotypeProfileDataImpl impl = new StereotypeProfileDataImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, StereotypeProfileData.TYPE)))
			impl._model.add(impl._resource, RDF.type, StereotypeProfileData.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.ProfileData.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.ProfileData.TYPE));     
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
		it = _model.listStatements(_resource,hasWealthSetProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasDressSetProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasProfessionSetProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasAgeSetProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.StereotypeProfileData.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.ProfileData.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasWealthSet = null;
		hasDressSet = null;
		hasProfessionSet = null;
		hasAgeSet = null;
	}


	public ibspan.tss.um.ontology.WealthSet getHasWealthSet() throws JastorException {
		if (hasWealthSet != null)
			return hasWealthSet;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasWealthSetProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasWealthSet getProperty() in ibspan.tss.um.ontology.StereotypeProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasWealthSet = ibspan.tss.um.ontology.UserModellingFactory.getWealthSet(resource,_model);
		return hasWealthSet;
	}

	public void setHasWealthSet(ibspan.tss.um.ontology.WealthSet hasWealthSet) throws JastorException {
		if (_model.contains(_resource,hasWealthSetProperty)) {
			_model.removeAll(_resource,hasWealthSetProperty,null);
		}
		this.hasWealthSet = hasWealthSet;
		if (hasWealthSet != null) {
			_model.add(_model.createStatement(_resource,hasWealthSetProperty, hasWealthSet.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.WealthSet setHasWealthSet() throws JastorException {
		if (_model.contains(_resource,hasWealthSetProperty)) {
			_model.removeAll(_resource,hasWealthSetProperty,null);
		}
		ibspan.tss.um.ontology.WealthSet hasWealthSet = ibspan.tss.um.ontology.UserModellingFactory.createWealthSet(_model.createResource(),_model);
		this.hasWealthSet = hasWealthSet;
		_model.add(_model.createStatement(_resource,hasWealthSetProperty, hasWealthSet.resource()));
		return hasWealthSet;
	}
	
	public ibspan.tss.um.ontology.WealthSet setHasWealthSet(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.WealthSet.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.WealthSet.TYPE);
		if (_model.contains(_resource,hasWealthSetProperty)) {
			_model.removeAll(_resource,hasWealthSetProperty,null);
		}
		ibspan.tss.um.ontology.WealthSet hasWealthSet = ibspan.tss.um.ontology.UserModellingFactory.getWealthSet(resource,_model);
		this.hasWealthSet = hasWealthSet;
		_model.add(_model.createStatement(_resource,hasWealthSetProperty, hasWealthSet.resource()));
		return hasWealthSet;
	}
	

	public ibspan.tss.um.ontology.DressSet getHasDressSet() throws JastorException {
		if (hasDressSet != null)
			return hasDressSet;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasDressSetProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasDressSet getProperty() in ibspan.tss.um.ontology.StereotypeProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasDressSet = ibspan.tss.um.ontology.UserModellingFactory.getDressSet(resource,_model);
		return hasDressSet;
	}

	public void setHasDressSet(ibspan.tss.um.ontology.DressSet hasDressSet) throws JastorException {
		if (_model.contains(_resource,hasDressSetProperty)) {
			_model.removeAll(_resource,hasDressSetProperty,null);
		}
		this.hasDressSet = hasDressSet;
		if (hasDressSet != null) {
			_model.add(_model.createStatement(_resource,hasDressSetProperty, hasDressSet.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.DressSet setHasDressSet() throws JastorException {
		if (_model.contains(_resource,hasDressSetProperty)) {
			_model.removeAll(_resource,hasDressSetProperty,null);
		}
		ibspan.tss.um.ontology.DressSet hasDressSet = ibspan.tss.um.ontology.UserModellingFactory.createDressSet(_model.createResource(),_model);
		this.hasDressSet = hasDressSet;
		_model.add(_model.createStatement(_resource,hasDressSetProperty, hasDressSet.resource()));
		return hasDressSet;
	}
	
	public ibspan.tss.um.ontology.DressSet setHasDressSet(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.DressSet.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.DressSet.TYPE);
		if (_model.contains(_resource,hasDressSetProperty)) {
			_model.removeAll(_resource,hasDressSetProperty,null);
		}
		ibspan.tss.um.ontology.DressSet hasDressSet = ibspan.tss.um.ontology.UserModellingFactory.getDressSet(resource,_model);
		this.hasDressSet = hasDressSet;
		_model.add(_model.createStatement(_resource,hasDressSetProperty, hasDressSet.resource()));
		return hasDressSet;
	}
	

	public ibspan.tss.um.ontology.ProfessionSet getHasProfessionSet() throws JastorException {
		if (hasProfessionSet != null)
			return hasProfessionSet;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasProfessionSetProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasProfessionSet getProperty() in ibspan.tss.um.ontology.StereotypeProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasProfessionSet = ibspan.tss.um.ontology.UserModellingFactory.getProfessionSet(resource,_model);
		return hasProfessionSet;
	}

	public void setHasProfessionSet(ibspan.tss.um.ontology.ProfessionSet hasProfessionSet) throws JastorException {
		if (_model.contains(_resource,hasProfessionSetProperty)) {
			_model.removeAll(_resource,hasProfessionSetProperty,null);
		}
		this.hasProfessionSet = hasProfessionSet;
		if (hasProfessionSet != null) {
			_model.add(_model.createStatement(_resource,hasProfessionSetProperty, hasProfessionSet.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.ProfessionSet setHasProfessionSet() throws JastorException {
		if (_model.contains(_resource,hasProfessionSetProperty)) {
			_model.removeAll(_resource,hasProfessionSetProperty,null);
		}
		ibspan.tss.um.ontology.ProfessionSet hasProfessionSet = ibspan.tss.um.ontology.UserModellingFactory.createProfessionSet(_model.createResource(),_model);
		this.hasProfessionSet = hasProfessionSet;
		_model.add(_model.createStatement(_resource,hasProfessionSetProperty, hasProfessionSet.resource()));
		return hasProfessionSet;
	}
	
	public ibspan.tss.um.ontology.ProfessionSet setHasProfessionSet(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.ProfessionSet.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.ProfessionSet.TYPE);
		if (_model.contains(_resource,hasProfessionSetProperty)) {
			_model.removeAll(_resource,hasProfessionSetProperty,null);
		}
		ibspan.tss.um.ontology.ProfessionSet hasProfessionSet = ibspan.tss.um.ontology.UserModellingFactory.getProfessionSet(resource,_model);
		this.hasProfessionSet = hasProfessionSet;
		_model.add(_model.createStatement(_resource,hasProfessionSetProperty, hasProfessionSet.resource()));
		return hasProfessionSet;
	}
	

	public ibspan.tss.um.ontology.AgeSet getHasAgeSet() throws JastorException {
		if (hasAgeSet != null)
			return hasAgeSet;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasAgeSetProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasAgeSet getProperty() in ibspan.tss.um.ontology.StereotypeProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasAgeSet = ibspan.tss.um.ontology.UserModellingFactory.getAgeSet(resource,_model);
		return hasAgeSet;
	}

	public void setHasAgeSet(ibspan.tss.um.ontology.AgeSet hasAgeSet) throws JastorException {
		if (_model.contains(_resource,hasAgeSetProperty)) {
			_model.removeAll(_resource,hasAgeSetProperty,null);
		}
		this.hasAgeSet = hasAgeSet;
		if (hasAgeSet != null) {
			_model.add(_model.createStatement(_resource,hasAgeSetProperty, hasAgeSet.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.AgeSet setHasAgeSet() throws JastorException {
		if (_model.contains(_resource,hasAgeSetProperty)) {
			_model.removeAll(_resource,hasAgeSetProperty,null);
		}
		ibspan.tss.um.ontology.AgeSet hasAgeSet = ibspan.tss.um.ontology.UserModellingFactory.createAgeSet(_model.createResource(),_model);
		this.hasAgeSet = hasAgeSet;
		_model.add(_model.createStatement(_resource,hasAgeSetProperty, hasAgeSet.resource()));
		return hasAgeSet;
	}
	
	public ibspan.tss.um.ontology.AgeSet setHasAgeSet(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.AgeSet.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.AgeSet.TYPE);
		if (_model.contains(_resource,hasAgeSetProperty)) {
			_model.removeAll(_resource,hasAgeSetProperty,null);
		}
		ibspan.tss.um.ontology.AgeSet hasAgeSet = ibspan.tss.um.ontology.UserModellingFactory.getAgeSet(resource,_model);
		this.hasAgeSet = hasAgeSet;
		_model.add(_model.createStatement(_resource,hasAgeSetProperty, hasAgeSet.resource()));
		return hasAgeSet;
	}
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof StereotypeProfileDataListener))
			throw new IllegalArgumentException("ThingListener must be instance of StereotypeProfileDataListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((StereotypeProfileDataListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof StereotypeProfileDataListener))
			throw new IllegalArgumentException("ThingListener must be instance of StereotypeProfileDataListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasWealthSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasWealthSet = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasWealthSet = ibspan.tss.um.ontology.UserModellingFactory.getWealthSet(resource,_model);
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
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasWealthSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasDressSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasDressSet = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasDressSet = ibspan.tss.um.ontology.UserModellingFactory.getDressSet(resource,_model);
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
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasDressSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasProfessionSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasProfessionSet = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasProfessionSet = ibspan.tss.um.ontology.UserModellingFactory.getProfessionSet(resource,_model);
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
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasProfessionSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasAgeSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasAgeSet = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasAgeSet = ibspan.tss.um.ontology.UserModellingFactory.getAgeSet(resource,_model);
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
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasAgeSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasWealthSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasWealthSet != null && hasWealthSet.resource().equals(resource))
						hasWealthSet = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasWealthSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasDressSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasDressSet != null && hasDressSet.resource().equals(resource))
						hasDressSet = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasDressSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasProfessionSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasProfessionSet != null && hasProfessionSet.resource().equals(resource))
						hasProfessionSet = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasProfessionSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasAgeSetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasAgeSet != null && hasAgeSet.resource().equals(resource))
						hasAgeSet = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						StereotypeProfileDataListener listener=(StereotypeProfileDataListener)iter.next();
						listener.hasAgeSetChanged(ibspan.tss.um.ontology.StereotypeProfileDataImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}