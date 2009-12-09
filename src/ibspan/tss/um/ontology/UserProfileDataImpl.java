

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
 * Implementation of {@link ibspan.tss.um.ontology.UserProfileData}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserProfileData)</p>
 * <br>
 */
public class UserProfileDataImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.UserProfileData {
	

	private static com.hp.hpl.jena.rdf.model.Property hasWealthProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasWealth");
	private ibspan.tss.um.ontology.Wealth hasWealth;
	private static com.hp.hpl.jena.rdf.model.Property wasBornProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#wasBorn");
	private com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType wasBorn;
	private static com.hp.hpl.jena.rdf.model.Property hasDressProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasDress");
	private ibspan.tss.um.ontology.Dress hasDress;
	private static com.hp.hpl.jena.rdf.model.Property hasProfessionProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasProfession");
	private ibspan.tss.um.ontology.Profession hasProfession;
	private static com.hp.hpl.jena.rdf.model.Property hasAgeProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasAge");
	private ibspan.tss.um.ontology.Age hasAge;

	UserProfileDataImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static UserProfileDataImpl getUserProfileData(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,UserProfileData.TYPE))
			return null;
		return new UserProfileDataImpl(resource, model);
	}
	    
	static UserProfileDataImpl createUserProfileData(Resource resource, Model model) throws JastorException {
		UserProfileDataImpl impl = new UserProfileDataImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, UserProfileData.TYPE)))
			impl._model.add(impl._resource, RDF.type, UserProfileData.TYPE);
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
		it = _model.listStatements(_resource,hasWealthProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,wasBornProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasDressProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasProfessionProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasAgeProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.UserProfileData.TYPE);
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
		hasWealth = null;
		wasBorn = null;
		hasDress = null;
		hasProfession = null;
		hasAge = null;
	}


	public ibspan.tss.um.ontology.Wealth getHasWealth() throws JastorException {
		if (hasWealth != null)
			return hasWealth;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasWealthProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasWealth getProperty() in ibspan.tss.um.ontology.UserProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasWealth = ibspan.tss.um.ontology.UserModellingFactory.getWealth(resource,_model);
		return hasWealth;
	}

	public void setHasWealth(ibspan.tss.um.ontology.Wealth hasWealth) throws JastorException {
		if (_model.contains(_resource,hasWealthProperty)) {
			_model.removeAll(_resource,hasWealthProperty,null);
		}
		this.hasWealth = hasWealth;
		if (hasWealth != null) {
			_model.add(_model.createStatement(_resource,hasWealthProperty, hasWealth.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Wealth setHasWealth() throws JastorException {
		if (_model.contains(_resource,hasWealthProperty)) {
			_model.removeAll(_resource,hasWealthProperty,null);
		}
		ibspan.tss.um.ontology.Wealth hasWealth = ibspan.tss.um.ontology.UserModellingFactory.createWealth(_model.createResource(),_model);
		this.hasWealth = hasWealth;
		_model.add(_model.createStatement(_resource,hasWealthProperty, hasWealth.resource()));
		return hasWealth;
	}
	
	public ibspan.tss.um.ontology.Wealth setHasWealth(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Wealth.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Wealth.TYPE);
		if (_model.contains(_resource,hasWealthProperty)) {
			_model.removeAll(_resource,hasWealthProperty,null);
		}
		ibspan.tss.um.ontology.Wealth hasWealth = ibspan.tss.um.ontology.UserModellingFactory.getWealth(resource,_model);
		this.hasWealth = hasWealth;
		_model.add(_model.createStatement(_resource,hasWealthProperty, hasWealth.resource()));
		return hasWealth;
	}
	
	public com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType getWasBorn() throws JastorException {
		if (wasBorn != null)
			return wasBorn;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, wasBornProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": wasBorn getProperty() in ibspan.tss.um.ontology.UserProfileData model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType");
		wasBorn = (com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType)obj;
		return wasBorn;
	}
	
	public void setWasBorn(com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType wasBorn) throws JastorException {
		if (_model.contains(_resource,wasBornProperty)) {
			_model.removeAll(_resource,wasBornProperty,null);
		}
		this.wasBorn = wasBorn;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (wasBorn != null) {
			_model.add(_model.createStatement(_resource,wasBornProperty, _model.createTypedLiteral(wasBorn)));
		}	
	}


	public ibspan.tss.um.ontology.Dress getHasDress() throws JastorException {
		if (hasDress != null)
			return hasDress;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasDressProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasDress getProperty() in ibspan.tss.um.ontology.UserProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasDress = ibspan.tss.um.ontology.UserModellingFactory.getDress(resource,_model);
		return hasDress;
	}

	public void setHasDress(ibspan.tss.um.ontology.Dress hasDress) throws JastorException {
		if (_model.contains(_resource,hasDressProperty)) {
			_model.removeAll(_resource,hasDressProperty,null);
		}
		this.hasDress = hasDress;
		if (hasDress != null) {
			_model.add(_model.createStatement(_resource,hasDressProperty, hasDress.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Dress setHasDress() throws JastorException {
		if (_model.contains(_resource,hasDressProperty)) {
			_model.removeAll(_resource,hasDressProperty,null);
		}
		ibspan.tss.um.ontology.Dress hasDress = ibspan.tss.um.ontology.UserModellingFactory.createDress(_model.createResource(),_model);
		this.hasDress = hasDress;
		_model.add(_model.createStatement(_resource,hasDressProperty, hasDress.resource()));
		return hasDress;
	}
	
	public ibspan.tss.um.ontology.Dress setHasDress(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Dress.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Dress.TYPE);
		if (_model.contains(_resource,hasDressProperty)) {
			_model.removeAll(_resource,hasDressProperty,null);
		}
		ibspan.tss.um.ontology.Dress hasDress = ibspan.tss.um.ontology.UserModellingFactory.getDress(resource,_model);
		this.hasDress = hasDress;
		_model.add(_model.createStatement(_resource,hasDressProperty, hasDress.resource()));
		return hasDress;
	}
	

	public ibspan.tss.um.ontology.Profession getHasProfession() throws JastorException {
		if (hasProfession != null)
			return hasProfession;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasProfessionProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasProfession getProperty() in ibspan.tss.um.ontology.UserProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasProfession = ibspan.tss.um.ontology.UserModellingFactory.getProfession(resource,_model);
		return hasProfession;
	}

	public void setHasProfession(ibspan.tss.um.ontology.Profession hasProfession) throws JastorException {
		if (_model.contains(_resource,hasProfessionProperty)) {
			_model.removeAll(_resource,hasProfessionProperty,null);
		}
		this.hasProfession = hasProfession;
		if (hasProfession != null) {
			_model.add(_model.createStatement(_resource,hasProfessionProperty, hasProfession.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Profession setHasProfession() throws JastorException {
		if (_model.contains(_resource,hasProfessionProperty)) {
			_model.removeAll(_resource,hasProfessionProperty,null);
		}
		ibspan.tss.um.ontology.Profession hasProfession = ibspan.tss.um.ontology.UserModellingFactory.createProfession(_model.createResource(),_model);
		this.hasProfession = hasProfession;
		_model.add(_model.createStatement(_resource,hasProfessionProperty, hasProfession.resource()));
		return hasProfession;
	}
	
	public ibspan.tss.um.ontology.Profession setHasProfession(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Profession.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Profession.TYPE);
		if (_model.contains(_resource,hasProfessionProperty)) {
			_model.removeAll(_resource,hasProfessionProperty,null);
		}
		ibspan.tss.um.ontology.Profession hasProfession = ibspan.tss.um.ontology.UserModellingFactory.getProfession(resource,_model);
		this.hasProfession = hasProfession;
		_model.add(_model.createStatement(_resource,hasProfessionProperty, hasProfession.resource()));
		return hasProfession;
	}
	

	public ibspan.tss.um.ontology.Age getHasAge() throws JastorException {
		if (hasAge != null)
			return hasAge;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasAgeProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasAge getProperty() in ibspan.tss.um.ontology.UserProfileData model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasAge = ibspan.tss.um.ontology.UserModellingFactory.getAge(resource,_model);
		return hasAge;
	}

	public void setHasAge(ibspan.tss.um.ontology.Age hasAge) throws JastorException {
		if (_model.contains(_resource,hasAgeProperty)) {
			_model.removeAll(_resource,hasAgeProperty,null);
		}
		this.hasAge = hasAge;
		if (hasAge != null) {
			_model.add(_model.createStatement(_resource,hasAgeProperty, hasAge.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Age setHasAge() throws JastorException {
		if (_model.contains(_resource,hasAgeProperty)) {
			_model.removeAll(_resource,hasAgeProperty,null);
		}
		ibspan.tss.um.ontology.Age hasAge = ibspan.tss.um.ontology.UserModellingFactory.createAge(_model.createResource(),_model);
		this.hasAge = hasAge;
		_model.add(_model.createStatement(_resource,hasAgeProperty, hasAge.resource()));
		return hasAge;
	}
	
	public ibspan.tss.um.ontology.Age setHasAge(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Age.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Age.TYPE);
		if (_model.contains(_resource,hasAgeProperty)) {
			_model.removeAll(_resource,hasAgeProperty,null);
		}
		ibspan.tss.um.ontology.Age hasAge = ibspan.tss.um.ontology.UserModellingFactory.getAge(resource,_model);
		this.hasAge = hasAge;
		_model.add(_model.createStatement(_resource,hasAgeProperty, hasAge.resource()));
		return hasAge;
	}
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof UserProfileDataListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserProfileDataListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((UserProfileDataListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof UserProfileDataListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserProfileDataListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasWealthProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasWealth = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasWealth = ibspan.tss.um.ontology.UserModellingFactory.getWealth(resource,_model);
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
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasWealthChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(wasBornProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				wasBorn = (com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType)Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.wasBornChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasDressProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasDress = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasDress = ibspan.tss.um.ontology.UserModellingFactory.getDress(resource,_model);
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
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasDressChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasProfessionProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasProfession = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasProfession = ibspan.tss.um.ontology.UserModellingFactory.getProfession(resource,_model);
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
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasProfessionChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasAgeProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasAge = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasAge = ibspan.tss.um.ontology.UserModellingFactory.getAge(resource,_model);
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
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasAgeChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasWealthProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasWealth != null && hasWealth.resource().equals(resource))
						hasWealth = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasWealthChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(wasBornProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType");
				if (wasBorn != null && wasBorn.equals(obj))
					wasBorn = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.wasBornChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasDressProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasDress != null && hasDress.resource().equals(resource))
						hasDress = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasDressChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasProfessionProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasProfession != null && hasProfession.resource().equals(resource))
						hasProfession = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasProfessionChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasAgeProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasAge != null && hasAge.resource().equals(resource))
						hasAge = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						UserProfileDataListener listener=(UserProfileDataListener)iter.next();
						listener.hasAgeChanged(ibspan.tss.um.ontology.UserProfileDataImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}