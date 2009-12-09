

package ibspan.tss.layout.ontology.datamodel;

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
 * Implementation of {@link ibspan.tss.layout.ontology.datamodel.MenuLink}
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#MenuLink)</p>
 * <br>
 */
public class MenuLinkImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.layout.ontology.datamodel.MenuLink {
	

	private static com.hp.hpl.jena.rdf.model.Property hasLabelProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasLabel");
	private java.lang.String hasLabel;
	private static com.hp.hpl.jena.rdf.model.Property hasActionNameProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasActionName");
	private java.lang.String hasActionName;

	MenuLinkImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static MenuLinkImpl getMenuLink(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,MenuLink.TYPE))
			return null;
		return new MenuLinkImpl(resource, model);
	}
	    
	static MenuLinkImpl createMenuLink(Resource resource, Model model) throws JastorException {
		MenuLinkImpl impl = new MenuLinkImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, MenuLink.TYPE)))
			impl._model.add(impl._resource, RDF.type, MenuLink.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsShowBackedUpResults() throws JastorException {
		_model.add(_resource, MenuLink.hasLabelProperty, _model.createTypedLiteral("Back to results", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("show-backed-up-results", "http://www.w3.org/2001/XMLSchema#string"));			
	}

	void initAsLogin1() throws JastorException {
		_model.add(_resource, MenuLink.hasLabelProperty, _model.createTypedLiteral("Login", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("login-1", "http://www.w3.org/2001/XMLSchema#string"));			
	}

	void initAsDefineSearch() throws JastorException {
		_model.add(_resource, MenuLink.hasLabelProperty, _model.createTypedLiteral("Find your restaurant!", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("define-search", "http://www.w3.org/2001/XMLSchema#string"));			
	}

	void initAsWelcome() throws JastorException {
		_model.add(_resource, MenuLink.hasLabelProperty, _model.createTypedLiteral("Go home", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("welcome", "http://www.w3.org/2001/XMLSchema#string"));			
	}

	void initAsLogout() throws JastorException {
		_model.add(_resource, MenuLink.hasLabelProperty, _model.createTypedLiteral("Logout", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("logout", "http://www.w3.org/2001/XMLSchema#string"));			
	}

	void initAsShowDetails() throws JastorException {
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("show-details", "http://www.w3.org/2001/XMLSchema#string"));			
	}

	void initAsRegister1() throws JastorException {
		_model.add(_resource, MenuLink.hasLabelProperty, _model.createTypedLiteral("Register", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, MenuLink.hasActionNameProperty, _model.createTypedLiteral("register-1", "http://www.w3.org/2001/XMLSchema#string"));			
	}
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE));     
		if (!_model.contains(_resource, RDF.type, ibspan.tss.layout.ontology.datamodel.Link.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.layout.ontology.datamodel.Link.TYPE));     
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.layout.ontology.datamodel.DataModelFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,hasLabelProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasActionNameProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.MenuLink.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.Link.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasLabel = null;
		hasActionName = null;
	}

	public java.lang.String getHasLabel() throws JastorException {
		if (hasLabel != null)
			return hasLabel;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasLabelProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasLabel getProperty() in ibspan.tss.layout.ontology.datamodel.MenuLink model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasLabel = (java.lang.String)obj;
		return hasLabel;
	}
	
	public void setHasLabel(java.lang.String hasLabel) throws JastorException {
		if (_model.contains(_resource,hasLabelProperty)) {
			_model.removeAll(_resource,hasLabelProperty,null);
		}
		this.hasLabel = hasLabel;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasLabel != null) {
			_model.add(_model.createStatement(_resource,hasLabelProperty, _model.createTypedLiteral(hasLabel)));
		}	
	}

	public java.lang.String getHasActionName() throws JastorException {
		if (hasActionName != null)
			return hasActionName;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasActionNameProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasActionName getProperty() in ibspan.tss.layout.ontology.datamodel.MenuLink model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasActionName = (java.lang.String)obj;
		return hasActionName;
	}
	
	public void setHasActionName(java.lang.String hasActionName) throws JastorException {
		if (_model.contains(_resource,hasActionNameProperty)) {
			_model.removeAll(_resource,hasActionNameProperty,null);
		}
		this.hasActionName = hasActionName;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasActionName != null) {
			_model.add(_model.createStatement(_resource,hasActionNameProperty, _model.createTypedLiteral(hasActionName)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof MenuLinkListener))
			throw new IllegalArgumentException("ThingListener must be instance of MenuLinkListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((MenuLinkListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof MenuLinkListener))
			throw new IllegalArgumentException("ThingListener must be instance of MenuLinkListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasLabelProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasLabel = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						MenuLinkListener listener=(MenuLinkListener)iter.next();
						listener.hasLabelChanged(ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasActionNameProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasActionName = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						MenuLinkListener listener=(MenuLinkListener)iter.next();
						listener.hasActionNameChanged(ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasLabelProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasLabel != null && hasLabel.equals(obj))
					hasLabel = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						MenuLinkListener listener=(MenuLinkListener)iter.next();
						listener.hasLabelChanged(ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasActionNameProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasActionName != null && hasActionName.equals(obj))
					hasActionName = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						MenuLinkListener listener=(MenuLinkListener)iter.next();
						listener.hasActionNameChanged(ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}