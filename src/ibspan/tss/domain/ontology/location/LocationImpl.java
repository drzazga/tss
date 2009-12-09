

package ibspan.tss.domain.ontology.location;

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
 * Implementation of {@link ibspan.tss.domain.ontology.location.Location}
 * Use the ibspan.tss.domain.ontology.location.LocationFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Location#Location)</p>
 * <br>
 */
public class LocationImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.location.Location {
	

	private static com.hp.hpl.jena.rdf.model.Property indexPointProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#indexPoint");
	private java.util.ArrayList indexPoint;
	private static com.hp.hpl.jena.rdf.model.Property locationPathProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#locationPath");
	private java.lang.String locationPath;
	private static com.hp.hpl.jena.rdf.model.Property cityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#city");
	private java.lang.String city;
	private static com.hp.hpl.jena.rdf.model.Property crossStreetProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#crossStreet");
	private java.util.ArrayList crossStreet;
	private static com.hp.hpl.jena.rdf.model.Property attractionCategoryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#attractionCategory");
	private java.util.ArrayList attractionCategory;
	private static com.hp.hpl.jena.rdf.model.Property locationCategoryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#locationCategory");
	private java.util.ArrayList locationCategory;
	private static com.hp.hpl.jena.rdf.model.Property streetAddressProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#streetAddress");
	private java.lang.String streetAddress;
	private static com.hp.hpl.jena.rdf.model.Property countryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#country");
	private java.lang.String country;
	private static com.hp.hpl.jena.rdf.model.Property faxProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#fax");
	private java.lang.String fax;
	private static com.hp.hpl.jena.rdf.model.Property stateProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#state");
	private java.lang.String state;
	private static com.hp.hpl.jena.rdf.model.Property phoneProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#phone");
	private java.util.ArrayList phone;
	private static com.hp.hpl.jena.rdf.model.Property neighborhoodProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#neighborhood");
	private java.lang.String neighborhood;
	private static com.hp.hpl.jena.rdf.model.Property zipProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Location#zip");
	private java.lang.String zip;

	LocationImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static LocationImpl getLocation(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Location.TYPE))
			return null;
		return new LocationImpl(resource, model);
	}
	    
	static LocationImpl createLocation(Resource resource, Model model) throws JastorException {
		LocationImpl impl = new LocationImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Location.TYPE)))
			impl._model.add(impl._resource, RDF.type, Location.TYPE);
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
    	ibspan.tss.domain.ontology.location.LocationFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,indexPointProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,locationPathProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,cityProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,crossStreetProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,attractionCategoryProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,locationCategoryProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,streetAddressProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,countryProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,faxProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,stateProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,phoneProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,neighborhoodProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,zipProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.location.Location.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		indexPoint = null;
		locationPath = null;
		city = null;
		crossStreet = null;
		attractionCategory = null;
		locationCategory = null;
		streetAddress = null;
		country = null;
		fax = null;
		state = null;
		phone = null;
		neighborhood = null;
		zip = null;
	}


	private void initIndexPoint() throws JastorException {
		this.indexPoint = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, indexPointProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#indexPoint properties in Location model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.location.IndexPointCode indexPoint = ibspan.tss.domain.ontology.location.LocationFactory.getIndexPointCode(resource,_model);
				this.indexPoint.add(indexPoint);
			}
		}
	}

	public java.util.Iterator getIndexPoint() throws JastorException {
		if (indexPoint == null)
			initIndexPoint();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(indexPoint,_resource,indexPointProperty,true);
	}

	public void addIndexPoint(ibspan.tss.domain.ontology.location.IndexPointCode indexPoint) throws JastorException {
		if (this.indexPoint == null)
			initIndexPoint();
		if (this.indexPoint.contains(indexPoint)) {
			this.indexPoint.remove(indexPoint);
			this.indexPoint.add(indexPoint);
			return;
		}
		this.indexPoint.add(indexPoint);
		_model.add(_model.createStatement(_resource,indexPointProperty,indexPoint.resource()));
	}
	
	public ibspan.tss.domain.ontology.location.IndexPointCode addIndexPoint() throws JastorException {
		ibspan.tss.domain.ontology.location.IndexPointCode indexPoint = ibspan.tss.domain.ontology.location.LocationFactory.createIndexPointCode(_model.createResource(),_model);
		if (this.indexPoint == null)
			initIndexPoint();
		this.indexPoint.add(indexPoint);
		_model.add(_model.createStatement(_resource,indexPointProperty,indexPoint.resource()));
		return indexPoint;
	}
	
	public ibspan.tss.domain.ontology.location.IndexPointCode addIndexPoint(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.location.IndexPointCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.location.IndexPointCode.TYPE);
		ibspan.tss.domain.ontology.location.IndexPointCode indexPoint = ibspan.tss.domain.ontology.location.LocationFactory.getIndexPointCode(resource,_model);
		if (this.indexPoint == null)
			initIndexPoint();
		if (this.indexPoint.contains(indexPoint))
			return indexPoint;
		this.indexPoint.add(indexPoint);
		_model.add(_model.createStatement(_resource,indexPointProperty,indexPoint.resource()));
		return indexPoint;
	}
	
	public void removeIndexPoint(ibspan.tss.domain.ontology.location.IndexPointCode indexPoint) throws JastorException {
		if (this.indexPoint == null)
			initIndexPoint();
		if (!this.indexPoint.contains(indexPoint))
			return;
		if (!_model.contains(_resource, indexPointProperty, indexPoint.resource()))
			return;
		this.indexPoint.remove(indexPoint);
		_model.removeAll(_resource, indexPointProperty, indexPoint.resource());
	}
		 
	public java.lang.String getLocationPath() throws JastorException {
		if (locationPath != null)
			return locationPath;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, locationPathProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": locationPath getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		locationPath = (java.lang.String)obj;
		return locationPath;
	}
	
	public void setLocationPath(java.lang.String locationPath) throws JastorException {
		if (_model.contains(_resource,locationPathProperty)) {
			_model.removeAll(_resource,locationPathProperty,null);
		}
		this.locationPath = locationPath;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (locationPath != null) {
			_model.add(_model.createStatement(_resource,locationPathProperty, _model.createTypedLiteral(locationPath)));
		}	
	}

	public java.lang.String getCity() throws JastorException {
		if (city != null)
			return city;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, cityProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": city getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		city = (java.lang.String)obj;
		return city;
	}
	
	public void setCity(java.lang.String city) throws JastorException {
		if (_model.contains(_resource,cityProperty)) {
			_model.removeAll(_resource,cityProperty,null);
		}
		this.city = city;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (city != null) {
			_model.add(_model.createStatement(_resource,cityProperty, _model.createTypedLiteral(city)));
		}	
	}


	private void initCrossStreet() throws JastorException {
		crossStreet = new java.util.ArrayList();
		
		StmtIterator it = _model.listStatements(_resource, crossStreetProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#crossStreet properties in Location model not a Literal", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
			crossStreet.add(Util.fixLiteral(literal.getValue(),"java.lang.String"));
		}
	}

	public java.util.Iterator getCrossStreet() throws JastorException {
		if (crossStreet == null)
			initCrossStreet();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(crossStreet,_resource,crossStreetProperty,false);
	}

	public void addCrossStreet(java.lang.String crossStreet) throws JastorException {
		if (this.crossStreet == null)
			initCrossStreet();
		if (this.crossStreet.contains(crossStreet))
			return;
		if (_model.contains(_resource, crossStreetProperty, _model.createTypedLiteral(crossStreet)))
			return;
		this.crossStreet.add(crossStreet);
		_model.add(_resource, crossStreetProperty, _model.createTypedLiteral(crossStreet));
	}
	
	public void removeCrossStreet(java.lang.String crossStreet) throws JastorException {
		if (this.crossStreet == null)
			initCrossStreet();
		if (!this.crossStreet.contains(crossStreet))
			return;
		if (!_model.contains(_resource, crossStreetProperty, _model.createTypedLiteral(crossStreet)))
			return;
		this.crossStreet.remove(crossStreet);
		_model.removeAll(_resource, crossStreetProperty, _model.createTypedLiteral(crossStreet));
	}


	private void initAttractionCategory() throws JastorException {
		this.attractionCategory = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, attractionCategoryProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#attractionCategory properties in Location model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory = ibspan.tss.domain.ontology.location.LocationFactory.getAttractionCategoryCode(resource,_model);
				this.attractionCategory.add(attractionCategory);
			}
		}
	}

	public java.util.Iterator getAttractionCategory() throws JastorException {
		if (attractionCategory == null)
			initAttractionCategory();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(attractionCategory,_resource,attractionCategoryProperty,true);
	}

	public void addAttractionCategory(ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory) throws JastorException {
		if (this.attractionCategory == null)
			initAttractionCategory();
		if (this.attractionCategory.contains(attractionCategory)) {
			this.attractionCategory.remove(attractionCategory);
			this.attractionCategory.add(attractionCategory);
			return;
		}
		this.attractionCategory.add(attractionCategory);
		_model.add(_model.createStatement(_resource,attractionCategoryProperty,attractionCategory.resource()));
	}
	
	public ibspan.tss.domain.ontology.location.AttractionCategoryCode addAttractionCategory() throws JastorException {
		ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory = ibspan.tss.domain.ontology.location.LocationFactory.createAttractionCategoryCode(_model.createResource(),_model);
		if (this.attractionCategory == null)
			initAttractionCategory();
		this.attractionCategory.add(attractionCategory);
		_model.add(_model.createStatement(_resource,attractionCategoryProperty,attractionCategory.resource()));
		return attractionCategory;
	}
	
	public ibspan.tss.domain.ontology.location.AttractionCategoryCode addAttractionCategory(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.location.AttractionCategoryCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.location.AttractionCategoryCode.TYPE);
		ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory = ibspan.tss.domain.ontology.location.LocationFactory.getAttractionCategoryCode(resource,_model);
		if (this.attractionCategory == null)
			initAttractionCategory();
		if (this.attractionCategory.contains(attractionCategory))
			return attractionCategory;
		this.attractionCategory.add(attractionCategory);
		_model.add(_model.createStatement(_resource,attractionCategoryProperty,attractionCategory.resource()));
		return attractionCategory;
	}
	
	public void removeAttractionCategory(ibspan.tss.domain.ontology.location.AttractionCategoryCode attractionCategory) throws JastorException {
		if (this.attractionCategory == null)
			initAttractionCategory();
		if (!this.attractionCategory.contains(attractionCategory))
			return;
		if (!_model.contains(_resource, attractionCategoryProperty, attractionCategory.resource()))
			return;
		this.attractionCategory.remove(attractionCategory);
		_model.removeAll(_resource, attractionCategoryProperty, attractionCategory.resource());
	}
		 

	private void initLocationCategory() throws JastorException {
		this.locationCategory = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, locationCategoryProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#locationCategory properties in Location model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory = ibspan.tss.domain.ontology.location.LocationFactory.getLocationCategoryCode(resource,_model);
				this.locationCategory.add(locationCategory);
			}
		}
	}

	public java.util.Iterator getLocationCategory() throws JastorException {
		if (locationCategory == null)
			initLocationCategory();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(locationCategory,_resource,locationCategoryProperty,true);
	}

	public void addLocationCategory(ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory) throws JastorException {
		if (this.locationCategory == null)
			initLocationCategory();
		if (this.locationCategory.contains(locationCategory)) {
			this.locationCategory.remove(locationCategory);
			this.locationCategory.add(locationCategory);
			return;
		}
		this.locationCategory.add(locationCategory);
		_model.add(_model.createStatement(_resource,locationCategoryProperty,locationCategory.resource()));
	}
	
	public ibspan.tss.domain.ontology.location.LocationCategoryCode addLocationCategory() throws JastorException {
		ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory = ibspan.tss.domain.ontology.location.LocationFactory.createLocationCategoryCode(_model.createResource(),_model);
		if (this.locationCategory == null)
			initLocationCategory();
		this.locationCategory.add(locationCategory);
		_model.add(_model.createStatement(_resource,locationCategoryProperty,locationCategory.resource()));
		return locationCategory;
	}
	
	public ibspan.tss.domain.ontology.location.LocationCategoryCode addLocationCategory(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.location.LocationCategoryCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.location.LocationCategoryCode.TYPE);
		ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory = ibspan.tss.domain.ontology.location.LocationFactory.getLocationCategoryCode(resource,_model);
		if (this.locationCategory == null)
			initLocationCategory();
		if (this.locationCategory.contains(locationCategory))
			return locationCategory;
		this.locationCategory.add(locationCategory);
		_model.add(_model.createStatement(_resource,locationCategoryProperty,locationCategory.resource()));
		return locationCategory;
	}
	
	public void removeLocationCategory(ibspan.tss.domain.ontology.location.LocationCategoryCode locationCategory) throws JastorException {
		if (this.locationCategory == null)
			initLocationCategory();
		if (!this.locationCategory.contains(locationCategory))
			return;
		if (!_model.contains(_resource, locationCategoryProperty, locationCategory.resource()))
			return;
		this.locationCategory.remove(locationCategory);
		_model.removeAll(_resource, locationCategoryProperty, locationCategory.resource());
	}
		 
	public java.lang.String getStreetAddress() throws JastorException {
		if (streetAddress != null)
			return streetAddress;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, streetAddressProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": streetAddress getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		streetAddress = (java.lang.String)obj;
		return streetAddress;
	}
	
	public void setStreetAddress(java.lang.String streetAddress) throws JastorException {
		if (_model.contains(_resource,streetAddressProperty)) {
			_model.removeAll(_resource,streetAddressProperty,null);
		}
		this.streetAddress = streetAddress;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (streetAddress != null) {
			_model.add(_model.createStatement(_resource,streetAddressProperty, _model.createTypedLiteral(streetAddress)));
		}	
	}

	public java.lang.String getCountry() throws JastorException {
		if (country != null)
			return country;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, countryProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": country getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		country = (java.lang.String)obj;
		return country;
	}
	
	public void setCountry(java.lang.String country) throws JastorException {
		if (_model.contains(_resource,countryProperty)) {
			_model.removeAll(_resource,countryProperty,null);
		}
		this.country = country;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (country != null) {
			_model.add(_model.createStatement(_resource,countryProperty, _model.createTypedLiteral(country)));
		}	
	}

	public java.lang.String getFax() throws JastorException {
		if (fax != null)
			return fax;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, faxProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": fax getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		fax = (java.lang.String)obj;
		return fax;
	}
	
	public void setFax(java.lang.String fax) throws JastorException {
		if (_model.contains(_resource,faxProperty)) {
			_model.removeAll(_resource,faxProperty,null);
		}
		this.fax = fax;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (fax != null) {
			_model.add(_model.createStatement(_resource,faxProperty, _model.createTypedLiteral(fax)));
		}	
	}

	public java.lang.String getState() throws JastorException {
		if (state != null)
			return state;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, stateProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": state getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		state = (java.lang.String)obj;
		return state;
	}
	
	public void setState(java.lang.String state) throws JastorException {
		if (_model.contains(_resource,stateProperty)) {
			_model.removeAll(_resource,stateProperty,null);
		}
		this.state = state;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (state != null) {
			_model.add(_model.createStatement(_resource,stateProperty, _model.createTypedLiteral(state)));
		}	
	}


	private void initPhone() throws JastorException {
		phone = new java.util.ArrayList();
		
		StmtIterator it = _model.listStatements(_resource, phoneProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#phone properties in Location model not a Literal", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
			phone.add(Util.fixLiteral(literal.getValue(),"java.lang.String"));
		}
	}

	public java.util.Iterator getPhone() throws JastorException {
		if (phone == null)
			initPhone();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(phone,_resource,phoneProperty,false);
	}

	public void addPhone(java.lang.String phone) throws JastorException {
		if (this.phone == null)
			initPhone();
		if (this.phone.contains(phone))
			return;
		if (_model.contains(_resource, phoneProperty, _model.createTypedLiteral(phone)))
			return;
		this.phone.add(phone);
		_model.add(_resource, phoneProperty, _model.createTypedLiteral(phone));
	}
	
	public void removePhone(java.lang.String phone) throws JastorException {
		if (this.phone == null)
			initPhone();
		if (!this.phone.contains(phone))
			return;
		if (!_model.contains(_resource, phoneProperty, _model.createTypedLiteral(phone)))
			return;
		this.phone.remove(phone);
		_model.removeAll(_resource, phoneProperty, _model.createTypedLiteral(phone));
	}

	public java.lang.String getNeighborhood() throws JastorException {
		if (neighborhood != null)
			return neighborhood;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, neighborhoodProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": neighborhood getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		neighborhood = (java.lang.String)obj;
		return neighborhood;
	}
	
	public void setNeighborhood(java.lang.String neighborhood) throws JastorException {
		if (_model.contains(_resource,neighborhoodProperty)) {
			_model.removeAll(_resource,neighborhoodProperty,null);
		}
		this.neighborhood = neighborhood;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (neighborhood != null) {
			_model.add(_model.createStatement(_resource,neighborhoodProperty, _model.createTypedLiteral(neighborhood)));
		}	
	}

	public java.lang.String getZip() throws JastorException {
		if (zip != null)
			return zip;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, zipProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": zip getProperty() in ibspan.tss.domain.ontology.location.Location model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		zip = (java.lang.String)obj;
		return zip;
	}
	
	public void setZip(java.lang.String zip) throws JastorException {
		if (_model.contains(_resource,zipProperty)) {
			_model.removeAll(_resource,zipProperty,null);
		}
		this.zip = zip;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (zip != null) {
			_model.add(_model.createStatement(_resource,zipProperty, _model.createTypedLiteral(zip)));
		}	
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof LocationListener))
			throw new IllegalArgumentException("ThingListener must be instance of LocationListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((LocationListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof LocationListener))
			throw new IllegalArgumentException("ThingListener must be instance of LocationListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(indexPointProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.location.IndexPointCode _indexPoint = null;
					try {
						_indexPoint = ibspan.tss.domain.ontology.location.LocationFactory.getIndexPointCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (indexPoint == null) {
						try {
							initIndexPoint();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!indexPoint.contains(_indexPoint))
						indexPoint.add(_indexPoint);
					if (listeners != null) {
						java.util.ArrayList consumersForIndexPoint;
						synchronized (listeners) {
							consumersForIndexPoint = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForIndexPoint.iterator();iter.hasNext();){
							LocationListener listener=(LocationListener)iter.next();
							listener.indexPointAdded(ibspan.tss.domain.ontology.location.LocationImpl.this,_indexPoint);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(locationPathProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				locationPath = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.locationPathChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(cityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				city = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.cityChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(crossStreetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (crossStreet == null) {
					try {
						initCrossStreet();
					} catch (JastorException e) {
						e.printStackTrace();
						return;
					}
				}
				if (!crossStreet.contains(obj))
					crossStreet.add(obj);
				java.util.ArrayList consumersForCrossStreet;
				if (listeners != null) {
					synchronized (listeners) {
						consumersForCrossStreet = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumersForCrossStreet.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.crossStreetAdded(ibspan.tss.domain.ontology.location.LocationImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(attractionCategoryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.location.AttractionCategoryCode _attractionCategory = null;
					try {
						_attractionCategory = ibspan.tss.domain.ontology.location.LocationFactory.getAttractionCategoryCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (attractionCategory == null) {
						try {
							initAttractionCategory();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!attractionCategory.contains(_attractionCategory))
						attractionCategory.add(_attractionCategory);
					if (listeners != null) {
						java.util.ArrayList consumersForAttractionCategory;
						synchronized (listeners) {
							consumersForAttractionCategory = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAttractionCategory.iterator();iter.hasNext();){
							LocationListener listener=(LocationListener)iter.next();
							listener.attractionCategoryAdded(ibspan.tss.domain.ontology.location.LocationImpl.this,_attractionCategory);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(locationCategoryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.location.LocationCategoryCode _locationCategory = null;
					try {
						_locationCategory = ibspan.tss.domain.ontology.location.LocationFactory.getLocationCategoryCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (locationCategory == null) {
						try {
							initLocationCategory();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!locationCategory.contains(_locationCategory))
						locationCategory.add(_locationCategory);
					if (listeners != null) {
						java.util.ArrayList consumersForLocationCategory;
						synchronized (listeners) {
							consumersForLocationCategory = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForLocationCategory.iterator();iter.hasNext();){
							LocationListener listener=(LocationListener)iter.next();
							listener.locationCategoryAdded(ibspan.tss.domain.ontology.location.LocationImpl.this,_locationCategory);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(streetAddressProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				streetAddress = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.streetAddressChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(countryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				country = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.countryChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(faxProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				fax = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.faxChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(stateProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				state = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.stateChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(phoneProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (phone == null) {
					try {
						initPhone();
					} catch (JastorException e) {
						e.printStackTrace();
						return;
					}
				}
				if (!phone.contains(obj))
					phone.add(obj);
				java.util.ArrayList consumersForPhone;
				if (listeners != null) {
					synchronized (listeners) {
						consumersForPhone = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumersForPhone.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.phoneAdded(ibspan.tss.domain.ontology.location.LocationImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(neighborhoodProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				neighborhood = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.neighborhoodChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(zipProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				zip = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.zipChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(indexPointProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.location.IndexPointCode _indexPoint = null;
					if (indexPoint != null) {
						boolean found = false;
						for (int i=0;i<indexPoint.size();i++) {
							ibspan.tss.domain.ontology.location.IndexPointCode __item = (ibspan.tss.domain.ontology.location.IndexPointCode) indexPoint.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_indexPoint = __item;
								break;
							}
						}
						if (found)
							indexPoint.remove(_indexPoint);
						else {
							try {
								_indexPoint = ibspan.tss.domain.ontology.location.LocationFactory.getIndexPointCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_indexPoint = ibspan.tss.domain.ontology.location.LocationFactory.getIndexPointCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForIndexPoint;
						synchronized (listeners) {
							consumersForIndexPoint = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForIndexPoint.iterator();iter.hasNext();){
							LocationListener listener=(LocationListener)iter.next();
							listener.indexPointRemoved(ibspan.tss.domain.ontology.location.LocationImpl.this,_indexPoint);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(locationPathProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (locationPath != null && locationPath.equals(obj))
					locationPath = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.locationPathChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(cityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (city != null && city.equals(obj))
					city = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.cityChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(crossStreetProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (crossStreet != null) {
					if (crossStreet.contains(obj))
						crossStreet.remove(obj);
				}
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.crossStreetRemoved(ibspan.tss.domain.ontology.location.LocationImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(attractionCategoryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.location.AttractionCategoryCode _attractionCategory = null;
					if (attractionCategory != null) {
						boolean found = false;
						for (int i=0;i<attractionCategory.size();i++) {
							ibspan.tss.domain.ontology.location.AttractionCategoryCode __item = (ibspan.tss.domain.ontology.location.AttractionCategoryCode) attractionCategory.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_attractionCategory = __item;
								break;
							}
						}
						if (found)
							attractionCategory.remove(_attractionCategory);
						else {
							try {
								_attractionCategory = ibspan.tss.domain.ontology.location.LocationFactory.getAttractionCategoryCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_attractionCategory = ibspan.tss.domain.ontology.location.LocationFactory.getAttractionCategoryCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForAttractionCategory;
						synchronized (listeners) {
							consumersForAttractionCategory = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAttractionCategory.iterator();iter.hasNext();){
							LocationListener listener=(LocationListener)iter.next();
							listener.attractionCategoryRemoved(ibspan.tss.domain.ontology.location.LocationImpl.this,_attractionCategory);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(locationCategoryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.location.LocationCategoryCode _locationCategory = null;
					if (locationCategory != null) {
						boolean found = false;
						for (int i=0;i<locationCategory.size();i++) {
							ibspan.tss.domain.ontology.location.LocationCategoryCode __item = (ibspan.tss.domain.ontology.location.LocationCategoryCode) locationCategory.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_locationCategory = __item;
								break;
							}
						}
						if (found)
							locationCategory.remove(_locationCategory);
						else {
							try {
								_locationCategory = ibspan.tss.domain.ontology.location.LocationFactory.getLocationCategoryCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_locationCategory = ibspan.tss.domain.ontology.location.LocationFactory.getLocationCategoryCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForLocationCategory;
						synchronized (listeners) {
							consumersForLocationCategory = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForLocationCategory.iterator();iter.hasNext();){
							LocationListener listener=(LocationListener)iter.next();
							listener.locationCategoryRemoved(ibspan.tss.domain.ontology.location.LocationImpl.this,_locationCategory);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(streetAddressProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (streetAddress != null && streetAddress.equals(obj))
					streetAddress = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.streetAddressChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(countryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (country != null && country.equals(obj))
					country = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.countryChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(faxProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (fax != null && fax.equals(obj))
					fax = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.faxChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(stateProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (state != null && state.equals(obj))
					state = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.stateChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(phoneProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (phone != null) {
					if (phone.contains(obj))
						phone.remove(obj);
				}
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.phoneRemoved(ibspan.tss.domain.ontology.location.LocationImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(neighborhoodProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (neighborhood != null && neighborhood.equals(obj))
					neighborhood = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.neighborhoodChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(zipProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (zip != null && zip.equals(obj))
					zip = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						LocationListener listener=(LocationListener)iter.next();
						listener.zipChanged(ibspan.tss.domain.ontology.location.LocationImpl.this);
					}
				}
				return;
			}
		}

	//}
	


}