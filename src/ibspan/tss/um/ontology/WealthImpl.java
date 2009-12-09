

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
 * Implementation of {@link ibspan.tss.um.ontology.Wealth}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Wealth)</p>
 * <br>
 */
public class WealthImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.Wealth {
	

	private static com.hp.hpl.jena.rdf.model.Property hasRankProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasRank");
	private java.lang.Integer hasRank;

	WealthImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static WealthImpl getWealth(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Wealth.TYPE))
			return null;
		return new WealthImpl(resource, model);
	}
	    
	static WealthImpl createWealth(Resource resource, Model model) throws JastorException {
		WealthImpl impl = new WealthImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Wealth.TYPE)))
			impl._model.add(impl._resource, RDF.type, Wealth.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsAverageRich() throws JastorException {
		_model.add(_resource, Wealth.hasRankProperty, _model.createTypedLiteral("2", "http://www.w3.org/2001/XMLSchema#int"));			
	}

	void initAsVeryRich() throws JastorException {
		_model.add(_resource, Wealth.hasRankProperty, _model.createTypedLiteral("4", "http://www.w3.org/2001/XMLSchema#int"));			
	}

	void initAsRich() throws JastorException {
		_model.add(_resource, Wealth.hasRankProperty, _model.createTypedLiteral("3", "http://www.w3.org/2001/XMLSchema#int"));			
	}

	void initAsNotRich() throws JastorException {
		_model.add(_resource, Wealth.hasRankProperty, _model.createTypedLiteral("1", "http://www.w3.org/2001/XMLSchema#int"));			
	}
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Measure.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Measure.TYPE));     
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Ordinal.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Ordinal.TYPE));     
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
		it = _model.listStatements(_resource,hasRankProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Wealth.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Measure.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Ordinal.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasRank = null;
	}

	public java.lang.Integer getHasRank() throws JastorException {
		if (hasRank != null)
			return hasRank;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasRankProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasRank getProperty() in ibspan.tss.um.ontology.Wealth model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
		hasRank = (java.lang.Integer)obj;
		return hasRank;
	}
	
	public void setHasRank(java.lang.Integer hasRank) throws JastorException {
		if (_model.contains(_resource,hasRankProperty)) {
			_model.removeAll(_resource,hasRankProperty,null);
		}
		this.hasRank = hasRank;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasRank != null) {
			_model.add(_model.createStatement(_resource,hasRankProperty, _model.createTypedLiteral(hasRank)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof WealthListener))
			throw new IllegalArgumentException("ThingListener must be instance of WealthListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((WealthListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof WealthListener))
			throw new IllegalArgumentException("ThingListener must be instance of WealthListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasRankProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasRank = (java.lang.Integer)Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						WealthListener listener=(WealthListener)iter.next();
						listener.hasRankChanged(ibspan.tss.um.ontology.WealthImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasRankProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.Integer");
				if (hasRank != null && hasRank.equals(obj))
					hasRank = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						WealthListener listener=(WealthListener)iter.next();
						listener.hasRankChanged(ibspan.tss.um.ontology.WealthImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}