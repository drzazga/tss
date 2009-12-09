

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
 * Implementation of {@link ibspan.tss.um.ontology.Opinion}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Opinion)</p>
 * <br>
 */
public class OpinionImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.Opinion {
	

	private static com.hp.hpl.jena.rdf.model.Property atIndividualProbabilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#atIndividualProbability");
	private java.lang.Double atIndividualProbability;
	private static com.hp.hpl.jena.rdf.model.Property atInferredProbabilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#atInferredProbability");
	private java.lang.Double atInferredProbability;
	private static com.hp.hpl.jena.rdf.model.Property atNormalizedProbabilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#atNormalizedProbability");
	private java.lang.Double atNormalizedProbability;
	private static com.hp.hpl.jena.rdf.model.Property hasClassificationProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasClassification");
	private ibspan.tss.um.ontology.Classification hasClassification;
	private static com.hp.hpl.jena.rdf.model.Property isAboutProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#isAbout");
	private java.lang.String isAbout;

	OpinionImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static OpinionImpl getOpinion(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Opinion.TYPE))
			return null;
		return new OpinionImpl(resource, model);
	}
	    
	static OpinionImpl createOpinion(Resource resource, Model model) throws JastorException {
		OpinionImpl impl = new OpinionImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Opinion.TYPE)))
			impl._model.add(impl._resource, RDF.type, Opinion.TYPE);
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
		it = _model.listStatements(_resource,atIndividualProbabilityProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,atInferredProbabilityProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,atNormalizedProbabilityProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasClassificationProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,isAboutProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Opinion.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		atIndividualProbability = null;
		atInferredProbability = null;
		atNormalizedProbability = null;
		hasClassification = null;
		isAbout = null;
	}

	public java.lang.Double getAtIndividualProbability() throws JastorException {
		if (atIndividualProbability != null)
			return atIndividualProbability;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, atIndividualProbabilityProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": atIndividualProbability getProperty() in ibspan.tss.um.ontology.Opinion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
		atIndividualProbability = (java.lang.Double)obj;
		return atIndividualProbability;
	}
	
	public void setAtIndividualProbability(java.lang.Double atIndividualProbability) throws JastorException {
		if (_model.contains(_resource,atIndividualProbabilityProperty)) {
			_model.removeAll(_resource,atIndividualProbabilityProperty,null);
		}
		this.atIndividualProbability = atIndividualProbability;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (atIndividualProbability != null) {
			_model.add(_model.createStatement(_resource,atIndividualProbabilityProperty, _model.createTypedLiteral(atIndividualProbability)));
		}	
	}

	public java.lang.Double getAtInferredProbability() throws JastorException {
		if (atInferredProbability != null)
			return atInferredProbability;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, atInferredProbabilityProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": atInferredProbability getProperty() in ibspan.tss.um.ontology.Opinion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
		atInferredProbability = (java.lang.Double)obj;
		return atInferredProbability;
	}
	
	public void setAtInferredProbability(java.lang.Double atInferredProbability) throws JastorException {
		if (_model.contains(_resource,atInferredProbabilityProperty)) {
			_model.removeAll(_resource,atInferredProbabilityProperty,null);
		}
		this.atInferredProbability = atInferredProbability;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (atInferredProbability != null) {
			_model.add(_model.createStatement(_resource,atInferredProbabilityProperty, _model.createTypedLiteral(atInferredProbability)));
		}	
	}

	public java.lang.Double getAtNormalizedProbability() throws JastorException {
		if (atNormalizedProbability != null)
			return atNormalizedProbability;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, atNormalizedProbabilityProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": atNormalizedProbability getProperty() in ibspan.tss.um.ontology.Opinion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
		atNormalizedProbability = (java.lang.Double)obj;
		return atNormalizedProbability;
	}
	
	public void setAtNormalizedProbability(java.lang.Double atNormalizedProbability) throws JastorException {
		if (_model.contains(_resource,atNormalizedProbabilityProperty)) {
			_model.removeAll(_resource,atNormalizedProbabilityProperty,null);
		}
		this.atNormalizedProbability = atNormalizedProbability;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (atNormalizedProbability != null) {
			_model.add(_model.createStatement(_resource,atNormalizedProbabilityProperty, _model.createTypedLiteral(atNormalizedProbability)));
		}	
	}


	public ibspan.tss.um.ontology.Classification getHasClassification() throws JastorException {
		if (hasClassification != null)
			return hasClassification;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasClassificationProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasClassification getProperty() in ibspan.tss.um.ontology.Opinion model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasClassification = ibspan.tss.um.ontology.UserModellingFactory.getClassification(resource,_model);
		return hasClassification;
	}

	public void setHasClassification(ibspan.tss.um.ontology.Classification hasClassification) throws JastorException {
		if (_model.contains(_resource,hasClassificationProperty)) {
			_model.removeAll(_resource,hasClassificationProperty,null);
		}
		this.hasClassification = hasClassification;
		if (hasClassification != null) {
			_model.add(_model.createStatement(_resource,hasClassificationProperty, hasClassification.resource()));
		}			
	}
		
	public ibspan.tss.um.ontology.Classification setHasClassification() throws JastorException {
		if (_model.contains(_resource,hasClassificationProperty)) {
			_model.removeAll(_resource,hasClassificationProperty,null);
		}
		ibspan.tss.um.ontology.Classification hasClassification = ibspan.tss.um.ontology.UserModellingFactory.createClassification(_model.createResource(),_model);
		this.hasClassification = hasClassification;
		_model.add(_model.createStatement(_resource,hasClassificationProperty, hasClassification.resource()));
		return hasClassification;
	}
	
	public ibspan.tss.um.ontology.Classification setHasClassification(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.um.ontology.Classification.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.um.ontology.Classification.TYPE);
		if (_model.contains(_resource,hasClassificationProperty)) {
			_model.removeAll(_resource,hasClassificationProperty,null);
		}
		ibspan.tss.um.ontology.Classification hasClassification = ibspan.tss.um.ontology.UserModellingFactory.getClassification(resource,_model);
		this.hasClassification = hasClassification;
		_model.add(_model.createStatement(_resource,hasClassificationProperty, hasClassification.resource()));
		return hasClassification;
	}
	
	public java.lang.String getIsAbout() throws JastorException {
		if (isAbout != null)
			return isAbout;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, isAboutProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": isAbout getProperty() in ibspan.tss.um.ontology.Opinion model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		isAbout = (java.lang.String)obj;
		return isAbout;
	}
	
	public void setIsAbout(java.lang.String isAbout) throws JastorException {
		if (_model.contains(_resource,isAboutProperty)) {
			_model.removeAll(_resource,isAboutProperty,null);
		}
		this.isAbout = isAbout;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (isAbout != null) {
			_model.add(_model.createStatement(_resource,isAboutProperty, _model.createTypedLiteral(isAbout)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof OpinionListener))
			throw new IllegalArgumentException("ThingListener must be instance of OpinionListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((OpinionListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof OpinionListener))
			throw new IllegalArgumentException("ThingListener must be instance of OpinionListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(atIndividualProbabilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				atIndividualProbability = (java.lang.Double)Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.atIndividualProbabilityChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(atInferredProbabilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				atInferredProbability = (java.lang.Double)Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.atInferredProbabilityChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(atNormalizedProbabilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				atNormalizedProbability = (java.lang.Double)Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.atNormalizedProbabilityChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasClassificationProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasClassification = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasClassification = ibspan.tss.um.ontology.UserModellingFactory.getClassification(resource,_model);
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
						OpinionListener listener=(OpinionListener)iter.next();
						listener.hasClassificationChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(isAboutProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				isAbout = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.isAboutChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(atIndividualProbabilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (atIndividualProbability != null && atIndividualProbability.equals(obj))
					atIndividualProbability = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.atIndividualProbabilityChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(atInferredProbabilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (atInferredProbability != null && atInferredProbability.equals(obj))
					atInferredProbability = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.atInferredProbabilityChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(atNormalizedProbabilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Double");
				if (atNormalizedProbability != null && atNormalizedProbability.equals(obj))
					atNormalizedProbability = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.atNormalizedProbabilityChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasClassificationProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasClassification != null && hasClassification.resource().equals(resource))
						hasClassification = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.hasClassificationChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(isAboutProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (isAbout != null && isAbout.equals(obj))
					isAbout = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						OpinionListener listener=(OpinionListener)iter.next();
						listener.isAboutChanged(ibspan.tss.um.ontology.OpinionImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}