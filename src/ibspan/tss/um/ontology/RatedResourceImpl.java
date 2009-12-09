

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
 * Implementation of {@link ibspan.tss.um.ontology.RatedResource}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#RatedResource)</p>
 * <br>
 */
public class RatedResourceImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.RatedResource {
	

	private static com.hp.hpl.jena.rdf.model.Property hasRateProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasRate");
	private java.lang.Double hasRate;
	private static com.hp.hpl.jena.rdf.model.Property ofResourceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofResource");
	private java.lang.String ofResource;

	RatedResourceImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static RatedResourceImpl getRatedResource(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,RatedResource.TYPE))
			return null;
		return new RatedResourceImpl(resource, model);
	}
	    
	static RatedResourceImpl createRatedResource(Resource resource, Model model) throws JastorException {
		RatedResourceImpl impl = new RatedResourceImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, RatedResource.TYPE)))
			impl._model.add(impl._resource, RDF.type, RatedResource.TYPE);
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
		it = _model.listStatements(_resource,hasRateProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,ofResourceProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.RatedResource.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasRate = null;
		ofResource = null;
	}

	public java.lang.Double getHasRate() throws JastorException {
		if (hasRate != null)
			return hasRate;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasRateProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasRate getProperty() in ibspan.tss.um.ontology.RatedResource model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
		hasRate = (java.lang.Double)obj;
		return hasRate;
	}
	
	public void setHasRate(java.lang.Double hasRate) throws JastorException {
		if (_model.contains(_resource,hasRateProperty)) {
			_model.removeAll(_resource,hasRateProperty,null);
		}
		this.hasRate = hasRate;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasRate != null) {
			_model.add(_model.createStatement(_resource,hasRateProperty, _model.createTypedLiteral(hasRate)));
		}	
	}

	public java.lang.String getOfResource() throws JastorException {
		if (ofResource != null)
			return ofResource;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, ofResourceProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": ofResource getProperty() in ibspan.tss.um.ontology.RatedResource model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		ofResource = (java.lang.String)obj;
		return ofResource;
	}
	
	public void setOfResource(java.lang.String ofResource) throws JastorException {
		if (_model.contains(_resource,ofResourceProperty)) {
			_model.removeAll(_resource,ofResourceProperty,null);
		}
		this.ofResource = ofResource;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (ofResource != null) {
			_model.add(_model.createStatement(_resource,ofResourceProperty, _model.createTypedLiteral(ofResource)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof RatedResourceListener))
			throw new IllegalArgumentException("ThingListener must be instance of RatedResourceListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((RatedResourceListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof RatedResourceListener))
			throw new IllegalArgumentException("ThingListener must be instance of RatedResourceListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasRateProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasRate = (java.lang.Double)Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResourceListener listener=(RatedResourceListener)iter.next();
						listener.hasRateChanged(ibspan.tss.um.ontology.RatedResourceImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(ofResourceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				ofResource = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResourceListener listener=(RatedResourceListener)iter.next();
						listener.ofResourceChanged(ibspan.tss.um.ontology.RatedResourceImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasRateProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (hasRate != null && hasRate.equals(obj))
					hasRate = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResourceListener listener=(RatedResourceListener)iter.next();
						listener.hasRateChanged(ibspan.tss.um.ontology.RatedResourceImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(ofResourceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (ofResource != null && ofResource.equals(obj))
					ofResource = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RatedResourceListener listener=(RatedResourceListener)iter.next();
						listener.ofResourceChanged(ibspan.tss.um.ontology.RatedResourceImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}