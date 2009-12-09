

package ibspan.tss.layout.ontology.datamodel;

import com.ibm.adtech.jastor.*;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Factory for instantiating objects for ontology classes in the DataModel ontology.  The
 * get methods leave the model unchanged and return a Java view of the object in the model.  The create methods
 * may add certain baseline properties to the model such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.ibspan.waw.pl/tss/DataModel)</p>
 * <br>
 * <br>
 * <br>
 */
public class DataModelFactory extends com.ibm.adtech.jastor.ThingFactory { 



	/**
	 * Create a new instance of InternalLink.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the InternalLink
	 * @param model the Jena Model.
	 */
	public static InternalLink createInternalLink(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.InternalLinkImpl.createInternalLink(resource,model);
	}
	
	/**
	 * Create a new instance of InternalLink.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the InternalLink
	 * @param model the Jena Model.
	 */
	public static InternalLink createInternalLink(String uri, Model model) throws JastorException {
		InternalLink obj = ibspan.tss.layout.ontology.datamodel.InternalLinkImpl.createInternalLink(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of InternalLink.  Leaves the model unchanged.
	 * @param uri The uri of the InternalLink
	 * @param model the Jena Model.
	 */
	public static InternalLink getInternalLink(String uri, Model model) throws JastorException {
		return getInternalLink(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of InternalLink.  Leaves the model unchanged.
	 * @param resource The resource of the InternalLink
	 * @param model the Jena Model.
	 */
	public static InternalLink getInternalLink(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.InternalLink.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.InternalLinkImpl obj = (ibspan.tss.layout.ontology.datamodel.InternalLinkImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.InternalLinkImpl.getInternalLink(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an LoginSuccess individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of InternalLink.
	 */
	public static InternalLink getLoginSuccess(Model model) throws JastorException {
		Resource resource = model.createResource(InternalLink.LoginSuccess.getURI());
		InternalLinkImpl obj = (InternalLinkImpl)getInternalLink(resource, model);
		if (obj == null) {
			createInternalLink(resource, model);
			obj = (InternalLinkImpl)getInternalLink(resource, model);
			obj.initAsLoginSuccess();			
		}
		return obj;
	}
	/** 
	 * Get an Register2 individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of InternalLink.
	 */
	public static InternalLink getRegister2(Model model) throws JastorException {
		Resource resource = model.createResource(InternalLink.Register2.getURI());
		InternalLinkImpl obj = (InternalLinkImpl)getInternalLink(resource, model);
		if (obj == null) {
			createInternalLink(resource, model);
			obj = (InternalLinkImpl)getInternalLink(resource, model);
			obj.initAsRegister2();			
		}
		return obj;
	}
	/** 
	 * Get an ShowFreshResults individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of InternalLink.
	 */
	public static InternalLink getShowFreshResults(Model model) throws JastorException {
		Resource resource = model.createResource(InternalLink.ShowFreshResults.getURI());
		InternalLinkImpl obj = (InternalLinkImpl)getInternalLink(resource, model);
		if (obj == null) {
			createInternalLink(resource, model);
			obj = (InternalLinkImpl)getInternalLink(resource, model);
			obj.initAsShowFreshResults();			
		}
		return obj;
	}
	/** 
	 * Get an RegisterSuccess individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of InternalLink.
	 */
	public static InternalLink getRegisterSuccess(Model model) throws JastorException {
		Resource resource = model.createResource(InternalLink.RegisterSuccess.getURI());
		InternalLinkImpl obj = (InternalLinkImpl)getInternalLink(resource, model);
		if (obj == null) {
			createInternalLink(resource, model);
			obj = (InternalLinkImpl)getInternalLink(resource, model);
			obj.initAsRegisterSuccess();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of InternalLink for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#InternalLink
	 * @param model the Jena Model
	 * @return a List of InternalLink
	 */
	public static java.util.List getAllInternalLink(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,InternalLink.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getInternalLink(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of MenuLink.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the MenuLink
	 * @param model the Jena Model.
	 */
	public static MenuLink createMenuLink(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.createMenuLink(resource,model);
	}
	
	/**
	 * Create a new instance of MenuLink.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the MenuLink
	 * @param model the Jena Model.
	 */
	public static MenuLink createMenuLink(String uri, Model model) throws JastorException {
		MenuLink obj = ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.createMenuLink(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of MenuLink.  Leaves the model unchanged.
	 * @param uri The uri of the MenuLink
	 * @param model the Jena Model.
	 */
	public static MenuLink getMenuLink(String uri, Model model) throws JastorException {
		return getMenuLink(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of MenuLink.  Leaves the model unchanged.
	 * @param resource The resource of the MenuLink
	 * @param model the Jena Model.
	 */
	public static MenuLink getMenuLink(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.MenuLink.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.MenuLinkImpl obj = (ibspan.tss.layout.ontology.datamodel.MenuLinkImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.MenuLinkImpl.getMenuLink(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an ShowBackedUpResults individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getShowBackedUpResults(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.ShowBackedUpResults.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsShowBackedUpResults();			
		}
		return obj;
	}
	/** 
	 * Get an Login1 individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getLogin1(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.Login1.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsLogin1();			
		}
		return obj;
	}
	/** 
	 * Get an DefineSearch individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getDefineSearch(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.DefineSearch.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsDefineSearch();			
		}
		return obj;
	}
	/** 
	 * Get an Welcome individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getWelcome(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.Welcome.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsWelcome();			
		}
		return obj;
	}
	/** 
	 * Get an Logout individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getLogout(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.Logout.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsLogout();			
		}
		return obj;
	}
	/** 
	 * Get an ShowDetails individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getShowDetails(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.ShowDetails.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsShowDetails();			
		}
		return obj;
	}
	/** 
	 * Get an Register1 individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MenuLink.
	 */
	public static MenuLink getRegister1(Model model) throws JastorException {
		Resource resource = model.createResource(MenuLink.Register1.getURI());
		MenuLinkImpl obj = (MenuLinkImpl)getMenuLink(resource, model);
		if (obj == null) {
			createMenuLink(resource, model);
			obj = (MenuLinkImpl)getMenuLink(resource, model);
			obj.initAsRegister1();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of MenuLink for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#MenuLink
	 * @param model the Jena Model
	 * @return a List of MenuLink
	 */
	public static java.util.List getAllMenuLink(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,MenuLink.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getMenuLink(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Menu.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Menu
	 * @param model the Jena Model.
	 */
	public static Menu createMenu(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.MenuImpl.createMenu(resource,model);
	}
	
	/**
	 * Create a new instance of Menu.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Menu
	 * @param model the Jena Model.
	 */
	public static Menu createMenu(String uri, Model model) throws JastorException {
		Menu obj = ibspan.tss.layout.ontology.datamodel.MenuImpl.createMenu(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Menu.  Leaves the model unchanged.
	 * @param uri The uri of the Menu
	 * @param model the Jena Model.
	 */
	public static Menu getMenu(String uri, Model model) throws JastorException {
		return getMenu(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Menu.  Leaves the model unchanged.
	 * @param resource The resource of the Menu
	 * @param model the Jena Model.
	 */
	public static Menu getMenu(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.Menu.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.MenuImpl obj = (ibspan.tss.layout.ontology.datamodel.MenuImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.MenuImpl.getMenu(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an DefineSearchMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getDefineSearchMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.DefineSearchMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsDefineSearchMenu();			
		}
		return obj;
	}
	/** 
	 * Get an ResultsMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getResultsMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.ResultsMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsResultsMenu();			
		}
		return obj;
	}
	/** 
	 * Get an WelcomeMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getWelcomeMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.WelcomeMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsWelcomeMenu();			
		}
		return obj;
	}
	/** 
	 * Get an LoginSuccessMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getLoginSuccessMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.LoginSuccessMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsLoginSuccessMenu();			
		}
		return obj;
	}
	/** 
	 * Get an CommonMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getCommonMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.CommonMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsCommonMenu();			
		}
		return obj;
	}
	/** 
	 * Get an LoginMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getLoginMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.LoginMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsLoginMenu();			
		}
		return obj;
	}
	/** 
	 * Get an DetailsMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of Menu.
	 */
	public static Menu getDetailsMenu(Model model) throws JastorException {
		Resource resource = model.createResource(Menu.DetailsMenu.getURI());
		MenuImpl obj = (MenuImpl)getMenu(resource, model);
		if (obj == null) {
			createMenu(resource, model);
			obj = (MenuImpl)getMenu(resource, model);
			obj.initAsDetailsMenu();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of Menu for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#Menu
	 * @param model the Jena Model
	 * @return a List of Menu
	 */
	public static java.util.List getAllMenu(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Menu.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getMenu(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Link.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Link
	 * @param model the Jena Model.
	 */
	public static Link createLink(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.LinkImpl.createLink(resource,model);
	}
	
	/**
	 * Create a new instance of Link.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Link
	 * @param model the Jena Model.
	 */
	public static Link createLink(String uri, Model model) throws JastorException {
		Link obj = ibspan.tss.layout.ontology.datamodel.LinkImpl.createLink(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Link.  Leaves the model unchanged.
	 * @param uri The uri of the Link
	 * @param model the Jena Model.
	 */
	public static Link getLink(String uri, Model model) throws JastorException {
		return getLink(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Link.  Leaves the model unchanged.
	 * @param resource The resource of the Link
	 * @param model the Jena Model.
	 */
	public static Link getLink(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.Link.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.LinkImpl obj = (ibspan.tss.layout.ontology.datamodel.LinkImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.LinkImpl.getLink(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Link for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#Link
	 * @param model the Jena Model
	 * @return a List of Link
	 */
	public static java.util.List getAllLink(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Link.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getLink(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of FormLink.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the FormLink
	 * @param model the Jena Model.
	 */
	public static FormLink createFormLink(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.FormLinkImpl.createFormLink(resource,model);
	}
	
	/**
	 * Create a new instance of FormLink.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the FormLink
	 * @param model the Jena Model.
	 */
	public static FormLink createFormLink(String uri, Model model) throws JastorException {
		FormLink obj = ibspan.tss.layout.ontology.datamodel.FormLinkImpl.createFormLink(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of FormLink.  Leaves the model unchanged.
	 * @param uri The uri of the FormLink
	 * @param model the Jena Model.
	 */
	public static FormLink getFormLink(String uri, Model model) throws JastorException {
		return getFormLink(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of FormLink.  Leaves the model unchanged.
	 * @param resource The resource of the FormLink
	 * @param model the Jena Model.
	 */
	public static FormLink getFormLink(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.FormLink.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.FormLinkImpl obj = (ibspan.tss.layout.ontology.datamodel.FormLinkImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.FormLinkImpl.getFormLink(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an CheckRegister1 individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FormLink.
	 */
	public static FormLink getCheckRegister1(Model model) throws JastorException {
		Resource resource = model.createResource(FormLink.CheckRegister1.getURI());
		FormLinkImpl obj = (FormLinkImpl)getFormLink(resource, model);
		if (obj == null) {
			createFormLink(resource, model);
			obj = (FormLinkImpl)getFormLink(resource, model);
			obj.initAsCheckRegister1();			
		}
		return obj;
	}
	/** 
	 * Get an CheckLogin1 individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FormLink.
	 */
	public static FormLink getCheckLogin1(Model model) throws JastorException {
		Resource resource = model.createResource(FormLink.CheckLogin1.getURI());
		FormLinkImpl obj = (FormLinkImpl)getFormLink(resource, model);
		if (obj == null) {
			createFormLink(resource, model);
			obj = (FormLinkImpl)getFormLink(resource, model);
			obj.initAsCheckLogin1();			
		}
		return obj;
	}
	/** 
	 * Get an CheckRegister2 individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FormLink.
	 */
	public static FormLink getCheckRegister2(Model model) throws JastorException {
		Resource resource = model.createResource(FormLink.CheckRegister2.getURI());
		FormLinkImpl obj = (FormLinkImpl)getFormLink(resource, model);
		if (obj == null) {
			createFormLink(resource, model);
			obj = (FormLinkImpl)getFormLink(resource, model);
			obj.initAsCheckRegister2();			
		}
		return obj;
	}
	/** 
	 * Get an Search individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FormLink.
	 */
	public static FormLink getSearch(Model model) throws JastorException {
		Resource resource = model.createResource(FormLink.Search.getURI());
		FormLinkImpl obj = (FormLinkImpl)getFormLink(resource, model);
		if (obj == null) {
			createFormLink(resource, model);
			obj = (FormLinkImpl)getFormLink(resource, model);
			obj.initAsSearch();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of FormLink for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#FormLink
	 * @param model the Jena Model
	 * @return a List of FormLink
	 */
	public static java.util.List getAllFormLink(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,FormLink.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getFormLink(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of LayoutElement.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the LayoutElement
	 * @param model the Jena Model.
	 */
	public static LayoutElement createLayoutElement(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.LayoutElementImpl.createLayoutElement(resource,model);
	}
	
	/**
	 * Create a new instance of LayoutElement.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the LayoutElement
	 * @param model the Jena Model.
	 */
	public static LayoutElement createLayoutElement(String uri, Model model) throws JastorException {
		LayoutElement obj = ibspan.tss.layout.ontology.datamodel.LayoutElementImpl.createLayoutElement(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of LayoutElement.  Leaves the model unchanged.
	 * @param uri The uri of the LayoutElement
	 * @param model the Jena Model.
	 */
	public static LayoutElement getLayoutElement(String uri, Model model) throws JastorException {
		return getLayoutElement(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of LayoutElement.  Leaves the model unchanged.
	 * @param resource The resource of the LayoutElement
	 * @param model the Jena Model.
	 */
	public static LayoutElement getLayoutElement(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.LayoutElement.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.LayoutElementImpl obj = (ibspan.tss.layout.ontology.datamodel.LayoutElementImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.LayoutElementImpl.getLayoutElement(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of LayoutElement for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#LayoutElement
	 * @param model the Jena Model
	 * @return a List of LayoutElement
	 */
	public static java.util.List getAllLayoutElement(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,LayoutElement.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getLayoutElement(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of LayoutStructure.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the LayoutStructure
	 * @param model the Jena Model.
	 */
	public static LayoutStructure createLayoutStructure(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.createLayoutStructure(resource,model);
	}
	
	/**
	 * Create a new instance of LayoutStructure.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the LayoutStructure
	 * @param model the Jena Model.
	 */
	public static LayoutStructure createLayoutStructure(String uri, Model model) throws JastorException {
		LayoutStructure obj = ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.createLayoutStructure(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of LayoutStructure.  Leaves the model unchanged.
	 * @param uri The uri of the LayoutStructure
	 * @param model the Jena Model.
	 */
	public static LayoutStructure getLayoutStructure(String uri, Model model) throws JastorException {
		return getLayoutStructure(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of LayoutStructure.  Leaves the model unchanged.
	 * @param resource The resource of the LayoutStructure
	 * @param model the Jena Model.
	 */
	public static LayoutStructure getLayoutStructure(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.LayoutStructure.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl obj = (ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.LayoutStructureImpl.getLayoutStructure(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an Register2Structure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getRegister2Structure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.Register2Structure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsRegister2Structure();			
		}
		return obj;
	}
	/** 
	 * Get an DetailsStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getDetailsStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.DetailsStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsDetailsStructure();			
		}
		return obj;
	}
	/** 
	 * Get an Login1Structure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getLogin1Structure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.Login1Structure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsLogin1Structure();			
		}
		return obj;
	}
	/** 
	 * Get an DefineSearchStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getDefineSearchStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.DefineSearchStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsDefineSearchStructure();			
		}
		return obj;
	}
	/** 
	 * Get an LoginSuccessStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getLoginSuccessStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.LoginSuccessStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsLoginSuccessStructure();			
		}
		return obj;
	}
	/** 
	 * Get an RegisterSuccessStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getRegisterSuccessStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.RegisterSuccessStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsRegisterSuccessStructure();			
		}
		return obj;
	}
	/** 
	 * Get an WelcomeStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getWelcomeStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.WelcomeStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsWelcomeStructure();			
		}
		return obj;
	}
	/** 
	 * Get an LogoutStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getLogoutStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.LogoutStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsLogoutStructure();			
		}
		return obj;
	}
	/** 
	 * Get an Register1Structure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getRegister1Structure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.Register1Structure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsRegister1Structure();			
		}
		return obj;
	}
	/** 
	 * Get an ResultsStructure individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of LayoutStructure.
	 */
	public static LayoutStructure getResultsStructure(Model model) throws JastorException {
		Resource resource = model.createResource(LayoutStructure.ResultsStructure.getURI());
		LayoutStructureImpl obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
		if (obj == null) {
			createLayoutStructure(resource, model);
			obj = (LayoutStructureImpl)getLayoutStructure(resource, model);
			obj.initAsResultsStructure();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of LayoutStructure for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#LayoutStructure
	 * @param model the Jena Model
	 * @return a List of LayoutStructure
	 */
	public static java.util.List getAllLayoutStructure(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,LayoutStructure.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getLayoutStructure(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of UserContext.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the UserContext
	 * @param model the Jena Model.
	 */
	public static UserContext createUserContext(Resource resource, Model model) throws JastorException {
		return ibspan.tss.layout.ontology.datamodel.UserContextImpl.createUserContext(resource,model);
	}
	
	/**
	 * Create a new instance of UserContext.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the UserContext
	 * @param model the Jena Model.
	 */
	public static UserContext createUserContext(String uri, Model model) throws JastorException {
		UserContext obj = ibspan.tss.layout.ontology.datamodel.UserContextImpl.createUserContext(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of UserContext.  Leaves the model unchanged.
	 * @param uri The uri of the UserContext
	 * @param model the Jena Model.
	 */
	public static UserContext getUserContext(String uri, Model model) throws JastorException {
		return getUserContext(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of UserContext.  Leaves the model unchanged.
	 * @param resource The resource of the UserContext
	 * @param model the Jena Model.
	 */
	public static UserContext getUserContext(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.layout.ontology.datamodel.UserContext.class.hashCode()) + resource.toString();
		ibspan.tss.layout.ontology.datamodel.UserContextImpl obj = (ibspan.tss.layout.ontology.datamodel.UserContextImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.layout.ontology.datamodel.UserContextImpl.getUserContext(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of UserContext for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/DataModel#UserContext
	 * @param model the Jena Model
	 * @return a List of UserContext
	 */
	public static java.util.List getAllUserContext(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,UserContext.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getUserContext(stmt.getSubject(),model));
		}
		return list;
	}
	
	
	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(com.hp.hpl.jena.rdf.model.Resource res, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#UserContext"))) {
			return getUserContext(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#LayoutStructure"))) {
			return getLayoutStructure(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#FormLink"))) {
			return getFormLink(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#Menu"))) {
			return getMenu(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#MenuLink"))) {
			return getMenuLink(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#InternalLink"))) {
			return getInternalLink(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#Link"))) {
			return getLink(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/DataModel#LayoutElement"))) {
			return getLayoutElement(res,model);
		}
		return new ThingImpl(res,model);
	}
	
	/**
	 * Returns an instance of an interface for the given Resource URI.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(String uri, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		return getThing(model.getResource(uri),model);
	}

	/**
	 * Return a list of compatible interfaces for the given type.  Searches through all ontology classes
	 * in the DataModel ontology.  The list is sorted according to the topological sort
	 * of the class hierarchy
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List listCompatibleInterfaces (com.hp.hpl.jena.rdf.model.Resource type) {
		java.util.List types = new java.util.ArrayList();
		if (type.equals(ibspan.tss.layout.ontology.datamodel.UserContext.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.UserContext.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.LayoutStructure.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.LayoutStructure.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.FormLink.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.FormLink.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.Menu.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.Menu.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.MenuLink.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.MenuLink.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.InternalLink.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.InternalLink.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.Link.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.Link.class);
		}
		if (type.equals(ibspan.tss.layout.ontology.datamodel.LayoutElement.TYPE)) {
			types.add(ibspan.tss.layout.ontology.datamodel.LayoutElement.class);
		}
		return types;
	}
}