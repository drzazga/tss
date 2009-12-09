

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
 * Implementation of {@link ibspan.tss.um.ontology.IntervalDomain}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#IntervalDomain)</p>
 * <br>
 */
public class IntervalDomainImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.IntervalDomain {
	

	private static com.hp.hpl.jena.rdf.model.Property ofMeasureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofMeasure");
	private java.lang.String ofMeasure;
	private static com.hp.hpl.jena.rdf.model.Property hasRightBoundProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasRightBound");
	private ibspan.tss.um.ontology.Interval hasRightBound;
	private static com.hp.hpl.jena.rdf.model.Property hasLeftBoundProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasLeftBound");
	private ibspan.tss.um.ontology.Interval hasLeftBound;

	IntervalDomainImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static IntervalDomainImpl getIntervalDomain(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,IntervalDomain.TYPE))
			return null;
		return new IntervalDomainImpl(resource, model);
	}
	    
	static IntervalDomainImpl createIntervalDomain(Resource resource, Model model) throws JastorException {
		IntervalDomainImpl impl = new IntervalDomainImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, IntervalDomain.TYPE)))
			impl._model.add(impl._resource, RDF.type, IntervalDomain.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsAgeDomain() throws JastorException {
		_model.add(_resource, IntervalDomain.ofMeasureProperty, _model.createTypedLiteral("http://www.ibspan.waw.pl/tss/UserModelling#Age", "http://www.w3.org/2001/XMLSchema#anyURI"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Age.AgeMax, RDF.type, Age.TYPE))) {
			UserModellingFactory.getAgeMax(_model);
		}			
		_model.add(_resource, IntervalDomain.hasRightBoundProperty, Age.AgeMax);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Age.AgeMin, RDF.type, Age.TYPE))) {
			UserModellingFactory.getAgeMin(_model);
		}			
		_model.add(_resource, IntervalDomain.hasLeftBoundProperty, Age.AgeMin);
	}
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.MeasureDomain.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.MeasureDomain.TYPE));     
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
		it = _model.listStatements(_resource,ofMeasureProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasRightBoundProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasLeftBoundProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.IntervalDomain.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.MeasureDomain.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		ofMeasure = null;
		hasRightBound = null;
		hasLeftBound = null;
	}

	public java.lang.String getOfMeasure() throws JastorException {
		if (ofMeasure != null)
			return ofMeasure;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, ofMeasureProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": ofMeasure getProperty() in ibspan.tss.um.ontology.IntervalDomain model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		ofMeasure = (java.lang.String)obj;
		return ofMeasure;
	}
	
	public void setOfMeasure(java.lang.String ofMeasure) throws JastorException {
		if (_model.contains(_resource,ofMeasureProperty)) {
			_model.removeAll(_resource,ofMeasureProperty,null);
		}
		this.ofMeasure = ofMeasure;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (ofMeasure != null) {
			_model.add(_model.createStatement(_resource,ofMeasureProperty, _model.createTypedLiteral(ofMeasure)));
		}	
	}


	public ibspan.tss.um.ontology.Interval getHasRightBound() throws JastorException {
		if (hasRightBound != null)
			return hasRightBound;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasRightBoundProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasRightBound getProperty() in ibspan.tss.um.ontology.IntervalDomain model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasRightBound = ibspan.tss.um.ontology.UserModellingFactory.getInterval(resource,_model);
		return hasRightBound;
	}

	public void setHasRightBound(ibspan.tss.um.ontology.Interval hasRightBound) throws JastorException {
		if (_model.contains(_resource,hasRightBoundProperty)) {
			_model.removeAll(_resource,hasRightBoundProperty,null);
		}
		this.hasRightBound = hasRightBound;
		if (hasRightBound != null) {
			_model.add(_model.createStatement(_resource,hasRightBoundProperty, hasRightBound.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Interval setHasRightBound() throws JastorException {
		if (_model.contains(_resource,hasRightBoundProperty)) {
			_model.removeAll(_resource,hasRightBoundProperty,null);
		}
		ibspan.tss.um.ontology.Interval hasRightBound = ibspan.tss.um.ontology.UserModellingFactory.createInterval(_model.createResource(),_model);
		this.hasRightBound = hasRightBound;
		_model.add(_model.createStatement(_resource,hasRightBoundProperty, hasRightBound.resource()));
		return hasRightBound;
	}
	
	public ibspan.tss.um.ontology.Interval setHasRightBound(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Interval.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Interval.TYPE);
		if (_model.contains(_resource,hasRightBoundProperty)) {
			_model.removeAll(_resource,hasRightBoundProperty,null);
		}
		ibspan.tss.um.ontology.Interval hasRightBound = ibspan.tss.um.ontology.UserModellingFactory.getInterval(resource,_model);
		this.hasRightBound = hasRightBound;
		_model.add(_model.createStatement(_resource,hasRightBoundProperty, hasRightBound.resource()));
		return hasRightBound;
	}
	

	public ibspan.tss.um.ontology.Interval getHasLeftBound() throws JastorException {
		if (hasLeftBound != null)
			return hasLeftBound;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasLeftBoundProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasLeftBound getProperty() in ibspan.tss.um.ontology.IntervalDomain model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasLeftBound = ibspan.tss.um.ontology.UserModellingFactory.getInterval(resource,_model);
		return hasLeftBound;
	}

	public void setHasLeftBound(ibspan.tss.um.ontology.Interval hasLeftBound) throws JastorException {
		if (_model.contains(_resource,hasLeftBoundProperty)) {
			_model.removeAll(_resource,hasLeftBoundProperty,null);
		}
		this.hasLeftBound = hasLeftBound;
		if (hasLeftBound != null) {
			_model.add(_model.createStatement(_resource,hasLeftBoundProperty, hasLeftBound.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Interval setHasLeftBound() throws JastorException {
		if (_model.contains(_resource,hasLeftBoundProperty)) {
			_model.removeAll(_resource,hasLeftBoundProperty,null);
		}
		ibspan.tss.um.ontology.Interval hasLeftBound = ibspan.tss.um.ontology.UserModellingFactory.createInterval(_model.createResource(),_model);
		this.hasLeftBound = hasLeftBound;
		_model.add(_model.createStatement(_resource,hasLeftBoundProperty, hasLeftBound.resource()));
		return hasLeftBound;
	}
	
	public ibspan.tss.um.ontology.Interval setHasLeftBound(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Interval.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Interval.TYPE);
		if (_model.contains(_resource,hasLeftBoundProperty)) {
			_model.removeAll(_resource,hasLeftBoundProperty,null);
		}
		ibspan.tss.um.ontology.Interval hasLeftBound = ibspan.tss.um.ontology.UserModellingFactory.getInterval(resource,_model);
		this.hasLeftBound = hasLeftBound;
		_model.add(_model.createStatement(_resource,hasLeftBoundProperty, hasLeftBound.resource()));
		return hasLeftBound;
	}
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof IntervalDomainListener))
			throw new IllegalArgumentException("ThingListener must be instance of IntervalDomainListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((IntervalDomainListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof IntervalDomainListener))
			throw new IllegalArgumentException("ThingListener must be instance of IntervalDomainListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(ofMeasureProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				ofMeasure = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						IntervalDomainListener listener=(IntervalDomainListener)iter.next();
						listener.ofMeasureChanged(ibspan.tss.um.ontology.IntervalDomainImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasRightBoundProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasRightBound = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasRightBound = ibspan.tss.um.ontology.UserModellingFactory.getInterval(resource,_model);
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
						IntervalDomainListener listener=(IntervalDomainListener)iter.next();
						listener.hasRightBoundChanged(ibspan.tss.um.ontology.IntervalDomainImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasLeftBoundProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasLeftBound = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasLeftBound = ibspan.tss.um.ontology.UserModellingFactory.getInterval(resource,_model);
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
						IntervalDomainListener listener=(IntervalDomainListener)iter.next();
						listener.hasLeftBoundChanged(ibspan.tss.um.ontology.IntervalDomainImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(ofMeasureProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (ofMeasure != null && ofMeasure.equals(obj))
					ofMeasure = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						IntervalDomainListener listener=(IntervalDomainListener)iter.next();
						listener.ofMeasureChanged(ibspan.tss.um.ontology.IntervalDomainImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasRightBoundProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasRightBound != null && hasRightBound.resource().equals(resource))
						hasRightBound = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						IntervalDomainListener listener=(IntervalDomainListener)iter.next();
						listener.hasRightBoundChanged(ibspan.tss.um.ontology.IntervalDomainImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasLeftBoundProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasLeftBound != null && hasLeftBound.resource().equals(resource))
						hasLeftBound = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						IntervalDomainListener listener=(IntervalDomainListener)iter.next();
						listener.hasLeftBoundChanged(ibspan.tss.um.ontology.IntervalDomainImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}