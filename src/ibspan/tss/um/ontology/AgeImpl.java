

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
 * Implementation of {@link ibspan.tss.um.ontology.Age}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Age)</p>
 * <br>
 */
public class AgeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.Age {
	

	private static com.hp.hpl.jena.rdf.model.Property mapsLinearValueProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#mapsLinearValue");
	private java.lang.Double mapsLinearValue;

	AgeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static AgeImpl getAge(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Age.TYPE))
			return null;
		return new AgeImpl(resource, model);
	}
	    
	static AgeImpl createAge(Resource resource, Model model) throws JastorException {
		AgeImpl impl = new AgeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Age.TYPE)))
			impl._model.add(impl._resource, RDF.type, Age.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsAgeMin() throws JastorException {
		_model.add(_resource, Age.mapsLinearValueProperty, _model.createTypedLiteral("1", "http://www.w3.org/2001/XMLSchema#double"));			
	}

	void initAsAgeMax() throws JastorException {
		_model.add(_resource, Age.mapsLinearValueProperty, _model.createTypedLiteral("120", "http://www.w3.org/2001/XMLSchema#double"));			
	}
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Measure.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Measure.TYPE));     
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Interval.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Interval.TYPE));     
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
		it = _model.listStatements(_resource,mapsLinearValueProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Age.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Measure.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Interval.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		mapsLinearValue = null;
	}

	public java.lang.Double getMapsLinearValue() throws JastorException {
		if (mapsLinearValue != null)
			return mapsLinearValue;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, mapsLinearValueProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": mapsLinearValue getProperty() in ibspan.tss.um.ontology.Age model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
		mapsLinearValue = (java.lang.Double)obj;
		return mapsLinearValue;
	}
	
	public void setMapsLinearValue(java.lang.Double mapsLinearValue) throws JastorException {
		if (_model.contains(_resource,mapsLinearValueProperty)) {
			_model.removeAll(_resource,mapsLinearValueProperty,null);
		}
		this.mapsLinearValue = mapsLinearValue;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (mapsLinearValue != null) {
			_model.add(_model.createStatement(_resource,mapsLinearValueProperty, _model.createTypedLiteral(mapsLinearValue)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof AgeListener))
			throw new IllegalArgumentException("ThingListener must be instance of AgeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((AgeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof AgeListener))
			throw new IllegalArgumentException("ThingListener must be instance of AgeListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(mapsLinearValueProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				mapsLinearValue = (java.lang.Double)Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgeListener listener=(AgeListener)iter.next();
						listener.mapsLinearValueChanged(ibspan.tss.um.ontology.AgeImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(mapsLinearValueProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (mapsLinearValue != null && mapsLinearValue.equals(obj))
					mapsLinearValue = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						AgeListener listener=(AgeListener)iter.next();
						listener.mapsLinearValueChanged(ibspan.tss.um.ontology.AgeImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}