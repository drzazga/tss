

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
 * Implementation of {@link ibspan.tss.um.ontology.RatedResult}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#RatedResult)</p>
 * <br>
 */
public class RatedResultImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.RatedResult {
	

	private static com.hp.hpl.jena.rdf.model.Property hasTemperatureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasTemperature");
	private java.lang.Double hasTemperature;
	private static com.hp.hpl.jena.rdf.model.Property ofObjectProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofObject");
	private com.ibm.adtech.jastor.Thing ofObject;

	RatedResultImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static RatedResultImpl getRatedResult(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,RatedResult.TYPE))
			return null;
		return new RatedResultImpl(resource, model);
	}
	    
	static RatedResultImpl createRatedResult(Resource resource, Model model) throws JastorException {
		RatedResultImpl impl = new RatedResultImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, RatedResult.TYPE)))
			impl._model.add(impl._resource, RDF.type, RatedResult.TYPE);
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
		it = _model.listStatements(_resource,hasTemperatureProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,ofObjectProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.RatedResult.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasTemperature = null;
		ofObject = null;
	}

	public java.lang.Double getHasTemperature() throws JastorException {
		if (hasTemperature != null)
			return hasTemperature;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasTemperatureProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasTemperature getProperty() in ibspan.tss.um.ontology.RatedResult model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
		hasTemperature = (java.lang.Double)obj;
		return hasTemperature;
	}
	
	public void setHasTemperature(java.lang.Double hasTemperature) throws JastorException {
		if (_model.contains(_resource,hasTemperatureProperty)) {
			_model.removeAll(_resource,hasTemperatureProperty,null);
		}
		this.hasTemperature = hasTemperature;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasTemperature != null) {
			_model.add(_model.createStatement(_resource,hasTemperatureProperty, _model.createTypedLiteral(hasTemperature)));
		}	
	}


	public com.ibm.adtech.jastor.Thing getOfObject() throws JastorException {
		if (ofObject != null)
			return ofObject;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, ofObjectProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": ofObject getProperty() in ibspan.tss.um.ontology.RatedResult model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		ofObject = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		return ofObject;
	}

	public void setOfObject(com.ibm.adtech.jastor.Thing ofObject) throws JastorException {
		if (_model.contains(_resource,ofObjectProperty)) {
			_model.removeAll(_resource,ofObjectProperty,null);
		}
		this.ofObject = ofObject;
		if (ofObject != null) {
			_model.add(_model.createStatement(_resource,ofObjectProperty, ofObject.resource()));
		}			
	}
		
	public com.ibm.adtech.jastor.Thing setOfObject() throws JastorException {
		if (_model.contains(_resource,ofObjectProperty)) {
			_model.removeAll(_resource,ofObjectProperty,null);
		}
		com.ibm.adtech.jastor.Thing ofObject = com.ibm.adtech.jastor.ThingFactory.createThing(_model.createResource(),_model);
		this.ofObject = ofObject;
		_model.add(_model.createStatement(_resource,ofObjectProperty, ofObject.resource()));
		return ofObject;
	}
	
	public com.ibm.adtech.jastor.Thing setOfObject(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (_model.contains(_resource,ofObjectProperty)) {
			_model.removeAll(_resource,ofObjectProperty,null);
		}
		com.ibm.adtech.jastor.Thing ofObject = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		this.ofObject = ofObject;
		_model.add(_model.createStatement(_resource,ofObjectProperty, ofObject.resource()));
		return ofObject;
	}
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof RatedResultListener))
			throw new IllegalArgumentException("ThingListener must be instance of RatedResultListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((RatedResultListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof RatedResultListener))
			throw new IllegalArgumentException("ThingListener must be instance of RatedResultListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasTemperatureProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasTemperature = (java.lang.Double)Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResultListener listener=(RatedResultListener)iter.next();
						listener.hasTemperatureChanged(ibspan.tss.um.ontology.RatedResultImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(ofObjectProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				ofObject = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						ofObject = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
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
						RatedResultListener listener=(RatedResultListener)iter.next();
						listener.ofObjectChanged(ibspan.tss.um.ontology.RatedResultImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasTemperatureProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (hasTemperature != null && hasTemperature.equals(obj))
					hasTemperature = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResultListener listener=(RatedResultListener)iter.next();
						listener.hasTemperatureChanged(ibspan.tss.um.ontology.RatedResultImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(ofObjectProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (ofObject != null && ofObject.resource().equals(resource))
						ofObject = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResultListener listener=(RatedResultListener)iter.next();
						listener.ofObjectChanged(ibspan.tss.um.ontology.RatedResultImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}