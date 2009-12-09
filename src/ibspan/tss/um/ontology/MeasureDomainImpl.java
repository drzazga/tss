

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
 * Implementation of {@link ibspan.tss.um.ontology.MeasureDomain}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#MeasureDomain)</p>
 * <br>
 */
public class MeasureDomainImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.MeasureDomain {
	

	private static com.hp.hpl.jena.rdf.model.Property ofMeasureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#ofMeasure");
	private java.lang.String ofMeasure;

	MeasureDomainImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static MeasureDomainImpl getMeasureDomain(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,MeasureDomain.TYPE))
			return null;
		return new MeasureDomainImpl(resource, model);
	}
	    
	static MeasureDomainImpl createMeasureDomain(Resource resource, Model model) throws JastorException {
		MeasureDomainImpl impl = new MeasureDomainImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, MeasureDomain.TYPE)))
			impl._model.add(impl._resource, RDF.type, MeasureDomain.TYPE);
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
		it = _model.listStatements(_resource,ofMeasureProperty,(RDFNode)null);
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
	}

	public java.lang.String getOfMeasure() throws JastorException {
		if (ofMeasure != null)
			return ofMeasure;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, ofMeasureProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": ofMeasure getProperty() in ibspan.tss.um.ontology.MeasureDomain model not Literal", stmt.getObject());
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
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof MeasureDomainListener))
			throw new IllegalArgumentException("ThingListener must be instance of MeasureDomainListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((MeasureDomainListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof MeasureDomainListener))
			throw new IllegalArgumentException("ThingListener must be instance of MeasureDomainListener"); 
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
						MeasureDomainListener listener=(MeasureDomainListener)iter.next();
						listener.ofMeasureChanged(ibspan.tss.um.ontology.MeasureDomainImpl.this);
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
						MeasureDomainListener listener=(MeasureDomainListener)iter.next();
						listener.ofMeasureChanged(ibspan.tss.um.ontology.MeasureDomainImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}