

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
 * Implementation of {@link ibspan.tss.layout.ontology.datamodel.LayoutStructure}
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#LayoutStructure)</p>
 * <br>
 */
public class LayoutStructureImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.layout.ontology.datamodel.LayoutStructure {
	

	private static com.hp.hpl.jena.rdf.model.Property hasErrorMessageProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasErrorMessage");
	private java.lang.String hasErrorMessage;
	private static com.hp.hpl.jena.rdf.model.Property hasTitleProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasTitle");
	private java.lang.String hasTitle;
	private static com.hp.hpl.jena.rdf.model.Property hasTextProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasText");
	private java.lang.String hasText;
	private static com.hp.hpl.jena.rdf.model.Property hasMenuProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasMenu");
	private ibspan.tss.layout.ontology.datamodel.Menu hasMenu;

	LayoutStructureImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static LayoutStructureImpl getLayoutStructure(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,LayoutStructure.TYPE))
			return null;
		return new LayoutStructureImpl(resource, model);
	}
	    
	static LayoutStructureImpl createLayoutStructure(Resource resource, Model model) throws JastorException {
		LayoutStructureImpl impl = new LayoutStructureImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, LayoutStructure.TYPE)))
			impl._model.add(impl._resource, RDF.type, LayoutStructure.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsRegister2Structure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Registration (II)", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Please give me the date you will use during logging in to the system", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.CommonMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getCommonMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.CommonMenu);
	}

	void initAsDetailsStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Details of restaurant", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Is it the one that you wanted ?", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.DetailsMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getDetailsMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.DetailsMenu);
	}

	void initAsLogin1Structure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Login", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Enter your login data", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.LoginMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getLoginMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.LoginMenu);
	}

	void initAsDefineSearchStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Search constraints", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Define properties important for your restaurant.", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.DefineSearchMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getDefineSearchMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.DefineSearchMenu);
	}

	void initAsLoginSuccessStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Login successful", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("What would you like to do now ?", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.LoginSuccessMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getLoginSuccessMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.LoginSuccessMenu);
	}

	void initAsRegisterSuccessStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Registration Successful", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Thank you for registration. Now you can log into the system.", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.CommonMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getCommonMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.CommonMenu);
	}

	void initAsWelcomeStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Welcome !", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Where do you want to go today ?", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.WelcomeMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getWelcomeMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.WelcomeMenu);
	}

	void initAsLogoutStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Logout successful", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Thank you for visiting us.", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.WelcomeMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getWelcomeMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.WelcomeMenu);
	}

	void initAsRegister1Structure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Registration (I)", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("Give us some personal data.", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.CommonMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getCommonMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.CommonMenu);
	}

	void initAsResultsStructure() throws JastorException {
		_model.add(_resource, LayoutStructure.hasTitleProperty, _model.createTypedLiteral("Recommended restaurants", "http://www.w3.org/2001/XMLSchema#string"));			
		_model.add(_resource, LayoutStructure.hasTextProperty, _model.createTypedLiteral("I recommend you the following restaurants:", "http://www.w3.org/2001/XMLSchema#string"));			
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(Menu.ResultsMenu, RDF.type, Menu.TYPE))) {
			DataModelFactory.getResultsMenu(_model);
		}			
		_model.add(_resource, LayoutStructure.hasMenuProperty, Menu.ResultsMenu);
	}
	
	void addSuperTypes() {
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
		it = _model.listStatements(_resource,hasErrorMessageProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasTitleProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasTextProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasMenuProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutStructure.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasErrorMessage = null;
		hasTitle = null;
		hasText = null;
		hasMenu = null;
	}

	public java.lang.String getHasErrorMessage() throws JastorException {
		if (hasErrorMessage != null)
			return hasErrorMessage;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasErrorMessageProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasErrorMessage getProperty() in ibspan.tss.layout.ontology.datamodel.LayoutStructure model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasErrorMessage = (java.lang.String)obj;
		return hasErrorMessage;
	}
	
	public void setHasErrorMessage(java.lang.String hasErrorMessage) throws JastorException {
		if (_model.contains(_resource,hasErrorMessageProperty)) {
			_model.removeAll(_resource,hasErrorMessageProperty,null);
		}
		this.hasErrorMessage = hasErrorMessage;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasErrorMessage != null) {
			_model.add(_model.createStatement(_resource,hasErrorMessageProperty, _model.createTypedLiteral(hasErrorMessage)));
		}	
	}

	public java.lang.String getHasTitle() throws JastorException {
		if (hasTitle != null)
			return hasTitle;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasTitleProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasTitle getProperty() in ibspan.tss.layout.ontology.datamodel.LayoutStructure model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasTitle = (java.lang.String)obj;
		return hasTitle;
	}
	
	public void setHasTitle(java.lang.String hasTitle) throws JastorException {
		if (_model.contains(_resource,hasTitleProperty)) {
			_model.removeAll(_resource,hasTitleProperty,null);
		}
		this.hasTitle = hasTitle;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasTitle != null) {
			_model.add(_model.createStatement(_resource,hasTitleProperty, _model.createTypedLiteral(hasTitle)));
		}	
	}

	public java.lang.String getHasText() throws JastorException {
		if (hasText != null)
			return hasText;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasTextProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasText getProperty() in ibspan.tss.layout.ontology.datamodel.LayoutStructure model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hasText = (java.lang.String)obj;
		return hasText;
	}
	
	public void setHasText(java.lang.String hasText) throws JastorException {
		if (_model.contains(_resource,hasTextProperty)) {
			_model.removeAll(_resource,hasTextProperty,null);
		}
		this.hasText = hasText;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hasText != null) {
			_model.add(_model.createStatement(_resource,hasTextProperty, _model.createTypedLiteral(hasText)));
		}	
	}


	public ibspan.tss.layout.ontology.datamodel.Menu getHasMenu() throws JastorException {
		if (hasMenu != null)
			return hasMenu;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hasMenuProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hasMenu getProperty() in ibspan.tss.layout.ontology.datamodel.LayoutStructure model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		hasMenu = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getMenu(resource,_model);
		return hasMenu;
	}

	public void setHasMenu(ibspan.tss.layout.ontology.datamodel.Menu hasMenu) throws JastorException {
		if (_model.contains(_resource,hasMenuProperty)) {
			_model.removeAll(_resource,hasMenuProperty,null);
		}
		this.hasMenu = hasMenu;
		if (hasMenu != null) {
			_model.add(_model.createStatement(_resource,hasMenuProperty, hasMenu.resource()));
		}			
	}
		
	public ibspan.tss.layout.ontology.datamodel.Menu setHasMenu() throws JastorException {
		if (_model.contains(_resource,hasMenuProperty)) {
			_model.removeAll(_resource,hasMenuProperty,null);
		}
		ibspan.tss.layout.ontology.datamodel.Menu hasMenu = ibspan.tss.layout.ontology.datamodel.DataModelFactory.createMenu(_model.createResource(),_model);
		this.hasMenu = hasMenu;
		_model.add(_model.createStatement(_resource,hasMenuProperty, hasMenu.resource()));
		return hasMenu;
	}
	
	public ibspan.tss.layout.ontology.datamodel.Menu setHasMenu(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.layout.ontology.datamodel.Menu.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.layout.ontology.datamodel.Menu.TYPE);
		if (_model.contains(_resource,hasMenuProperty)) {
			_model.removeAll(_resource,hasMenuProperty,null);
		}
		ibspan.tss.layout.ontology.datamodel.Menu hasMenu = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getMenu(resource,_model);
		this.hasMenu = hasMenu;
		_model.add(_model.createStatement(_resource,hasMenuProperty, hasMenu.resource()));
		return hasMenu;
	}
	 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof LayoutStructureListener))
			throw new IllegalArgumentException("ThingListener must be instance of LayoutStructureListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((LayoutStructureListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof LayoutStructureListener))
			throw new IllegalArgumentException("ThingListener must be instance of LayoutStructureListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasErrorMessageProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasErrorMessage = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasErrorMessageChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasTitleProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasTitle = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasTitleChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasTextProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hasText = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasTextChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasMenuProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				hasMenu = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						hasMenu = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getMenu(resource,_model);
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
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasMenuChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasErrorMessageProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasErrorMessage != null && hasErrorMessage.equals(obj))
					hasErrorMessage = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasErrorMessageChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasTitleProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasTitle != null && hasTitle.equals(obj))
					hasTitle = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasTitleChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasTextProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hasText != null && hasText.equals(obj))
					hasText = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasTextChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasMenuProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (hasMenu != null && hasMenu.resource().equals(resource))
						hasMenu = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LayoutStructureListener listener=(LayoutStructureListener)iter.next();
						listener.hasMenuChanged(ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}