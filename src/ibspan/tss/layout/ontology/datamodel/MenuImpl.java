

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
 * Implementation of {@link ibspan.tss.layout.ontology.datamodel.Menu}
 * Use the ibspan.tss.layout.ontology.datamodel.DataModelFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel#Menu)</p>
 * <br>
 */
public class MenuImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.layout.ontology.datamodel.Menu {
	

	private static com.hp.hpl.jena.rdf.model.Property hasLinkProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/DataModel#hasLink");
	private java.util.ArrayList hasLink;

	MenuImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static MenuImpl getMenu(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Menu.TYPE))
			return null;
		return new MenuImpl(resource, model);
	}
	    
	static MenuImpl createMenu(Resource resource, Model model) throws JastorException {
		MenuImpl impl = new MenuImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Menu.TYPE)))
			impl._model.add(impl._resource, RDF.type, Menu.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsDefineSearchMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Logout, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getLogout(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Logout);
	}

	void initAsResultsMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Logout, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getLogout(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Logout);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.DefineSearch, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getDefineSearch(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.DefineSearch);
	}

	void initAsWelcomeMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Register1, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getRegister1(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Register1);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Login1, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getLogin1(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Login1);
	}

	void initAsLoginSuccessMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Logout, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getLogout(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Logout);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.DefineSearch, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getDefineSearch(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.DefineSearch);
	}

	void initAsCommonMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Login1, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getLogin1(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Login1);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Welcome, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getWelcome(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Welcome);
	}

	void initAsLoginMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Register1, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getRegister1(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Register1);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Welcome, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getWelcome(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Welcome);
	}

	void initAsDetailsMenu() throws JastorException {
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.ShowBackedUpResults, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getShowBackedUpResults(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.ShowBackedUpResults);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.DefineSearch, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getDefineSearch(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.DefineSearch);
		if (!_model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(MenuLink.Logout, RDF.type, MenuLink.TYPE))) {
			DataModelFactory.getLogout(_model);
		}			
		_model.add(_resource, Menu.hasLinkProperty, MenuLink.Logout);
	}
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE));     
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
		it = _model.listStatements(_resource,hasLinkProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.Menu.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasLink = null;
	}


	private void initHasLink() throws JastorException {
		this.hasLink = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, hasLinkProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/DataModel#hasLink properties in Menu model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.layout.ontology.datamodel.Link hasLink = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getLink(resource,_model);
				this.hasLink.add(hasLink);
			}
		}
	}

	public java.util.Iterator getHasLink() throws JastorException {
		if (hasLink == null)
			initHasLink();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(hasLink,_resource,hasLinkProperty,true);
	}

	public void addHasLink(ibspan.tss.layout.ontology.datamodel.Link hasLink) throws JastorException {
		if (this.hasLink == null)
			initHasLink();
		if (this.hasLink.contains(hasLink)) {
			this.hasLink.remove(hasLink);
			this.hasLink.add(hasLink);
			return;
		}
		this.hasLink.add(hasLink);
		_model.add(_model.createStatement(_resource,hasLinkProperty,hasLink.resource()));
	}
	
	public ibspan.tss.layout.ontology.datamodel.Link addHasLink() throws JastorException {
		ibspan.tss.layout.ontology.datamodel.Link hasLink = ibspan.tss.layout.ontology.datamodel.DataModelFactory.createLink(_model.createResource(),_model);
		if (this.hasLink == null)
			initHasLink();
		this.hasLink.add(hasLink);
		_model.add(_model.createStatement(_resource,hasLinkProperty,hasLink.resource()));
		return hasLink;
	}
	
	public ibspan.tss.layout.ontology.datamodel.Link addHasLink(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.layout.ontology.datamodel.Link.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.layout.ontology.datamodel.Link.TYPE);
		ibspan.tss.layout.ontology.datamodel.Link hasLink = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getLink(resource,_model);
		if (this.hasLink == null)
			initHasLink();
		if (this.hasLink.contains(hasLink))
			return hasLink;
		this.hasLink.add(hasLink);
		_model.add(_model.createStatement(_resource,hasLinkProperty,hasLink.resource()));
		return hasLink;
	}
	
	public void removeHasLink(ibspan.tss.layout.ontology.datamodel.Link hasLink) throws JastorException {
		if (this.hasLink == null)
			initHasLink();
		if (!this.hasLink.contains(hasLink))
			return;
		if (!_model.contains(_resource, hasLinkProperty, hasLink.resource()))
			return;
		this.hasLink.remove(hasLink);
		_model.removeAll(_resource, hasLinkProperty, hasLink.resource());
	}
		  


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof MenuListener))
			throw new IllegalArgumentException("ThingListener must be instance of MenuListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((MenuListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof MenuListener))
			throw new IllegalArgumentException("ThingListener must be instance of MenuListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasLinkProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.layout.ontology.datamodel.Link _hasLink = null;
					try {
						_hasLink = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getLink(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (hasLink == null) {
						try {
							initHasLink();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!hasLink.contains(_hasLink))
						hasLink.add(_hasLink);
					if (listeners != null) {
						java.util.ArrayList consumersForHasLink;
						synchronized (listeners) {
							consumersForHasLink = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasLink.iterator();iter.hasNext();){
							MenuListener listener=(MenuListener)iter.next();
							listener.hasLinkAdded(ibspan.tss.layout.ontology.datamodel.MenuImpl.this,_hasLink);
						}
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasLinkProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.layout.ontology.datamodel.Link _hasLink = null;
					if (hasLink != null) {
						boolean found = false;
						for (int i=0;i<hasLink.size();i++) {
							ibspan.tss.layout.ontology.datamodel.Link __item = (ibspan.tss.layout.ontology.datamodel.Link) hasLink.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_hasLink = __item;
								break;
							}
						}
						if (found)
							hasLink.remove(_hasLink);
						else {
							try {
								_hasLink = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getLink(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_hasLink = ibspan.tss.layout.ontology.datamodel.DataModelFactory.getLink(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForHasLink;
						synchronized (listeners) {
							consumersForHasLink = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasLink.iterator();iter.hasNext();){
							MenuListener listener=(MenuListener)iter.next();
							listener.hasLinkRemoved(ibspan.tss.layout.ontology.datamodel.MenuImpl.this,_hasLink);
						}
					}
				}
				return;
			}
		}

	//}
	


}