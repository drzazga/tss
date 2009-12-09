

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
 * Implementation of {@link ibspan.tss.um.ontology.ContextParameter}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#ContextParameter)</p>
 * <br>
 */
public class ContextParameterImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.ContextParameter {
	

	private static com.hp.hpl.jena.rdf.model.Property hasValueProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasValue");
	private java.lang.String hasValue;
	private static com.hp.hpl.jena.rdf.model.Property hasNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasName");
	private java.lang.String hasName;

	ContextParameterImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static ContextParameterImpl getContextParameter(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,ContextParameter.TYPE))
			return null;
		return new ContextParameterImpl(resource, model);
	}
	    
	static ContextParameterImpl createContextParameter(Resource resource, Model model) throws JastorException {
		ContextParameterImpl impl = new ContextParameterImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, ContextParameter.TYPE)))
			impl._model.add(impl._resource, RDF.type, ContextParameter.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsTargetURI() throws JastorException {
		_model.add(_resource, ContextParameter.hasNameProperty, _model.createTypedLiteral("targetURI", "http://www.w3.org/2001/XMLSchema#string"));			
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
		it = _model.listStatements(_resource,hasValueProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasNameProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.ContextParameter.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasValue = null;
		hasName = null;
	}

	public java.lang.String getHasValue() throws JastorException {
		if (hasValue != null)
			return hasValue;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasValueProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasValue getProperty() in ibspan.tss.um.ontology.ContextParameter model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasValue = (java.lang.String)obj;
		return hasValue;
	}
	
	public void setHasValue(java.lang.String hasValue) throws JastorException {
		if (_model.contains(_resource,hasValueProperty)) {
			_model.removeAll(_resource,hasValueProperty,null);
		}
		this.hasValue = hasValue;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasValue != null) {
			_model.add(_model.createStatement(_resource,hasValueProperty, _model.createTypedLiteral(hasValue)));
		}	
	}

	public java.lang.String getHasName() throws JastorException {
		if (hasName != null)
			return hasName;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasNameProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasName getProperty() in ibspan.tss.um.ontology.ContextParameter model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasName = (java.lang.String)obj;
		return hasName;
	}
	
	public void setHasName(java.lang.String hasName) throws JastorException {
		if (_model.contains(_resource,hasNameProperty)) {
			_model.removeAll(_resource,hasNameProperty,null);
		}
		this.hasName = hasName;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasName != null) {
			_model.add(_model.createStatement(_resource,hasNameProperty, _model.createTypedLiteral(hasName)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof ContextParameterListener))
			throw new IllegalArgumentException("ThingListener must be instance of ContextParameterListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((ContextParameterListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof ContextParameterListener))
			throw new IllegalArgumentException("ThingListener must be instance of ContextParameterListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasValueProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasValue = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ContextParameterListener listener=(ContextParameterListener)iter.next();
						listener.hasValueChanged(ibspan.tss.um.ontology.ContextParameterImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasNameProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasName = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ContextParameterListener listener=(ContextParameterListener)iter.next();
						listener.hasNameChanged(ibspan.tss.um.ontology.ContextParameterImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasValueProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasValue != null && hasValue.equals(obj))
					hasValue = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ContextParameterListener listener=(ContextParameterListener)iter.next();
						listener.hasValueChanged(ibspan.tss.um.ontology.ContextParameterImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasNameProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasName != null && hasName.equals(obj))
					hasName = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						ContextParameterListener listener=(ContextParameterListener)iter.next();
						listener.hasNameChanged(ibspan.tss.um.ontology.ContextParameterImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}