

package ibspan.tss.domain.ontology.restaurant;

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
 * Implementation of {@link ibspan.tss.domain.ontology.restaurant.Restaurant}
 * Use the ibspan.tss.domain.ontology.restaurant.RestaurantFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant#Restaurant)</p>
 * <br>
 */
public class RestaurantImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.restaurant.Restaurant {
	

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
	private static com.hp.hpl.jena.rdf.model.Property clienteleProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#clientele");
	private java.lang.String clientele;
	private static com.hp.hpl.jena.rdf.model.Property accessibilityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#accessibility");
	private java.util.ArrayList accessibility;
	private static com.hp.hpl.jena.rdf.model.Property lunchPriceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#lunchPrice");
	private com.ibm.adtech.jastor.Thing lunchPrice;
	private static com.hp.hpl.jena.rdf.model.Property dinnerPriceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#dinnerPrice");
	private com.ibm.adtech.jastor.Thing dinnerPrice;
	private static com.hp.hpl.jena.rdf.model.Property restaurantServiceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#restaurantService");
	private java.util.ArrayList restaurantService;
	private static com.hp.hpl.jena.rdf.model.Property capacityProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#capacity");
	private com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType capacity;
	private static com.hp.hpl.jena.rdf.model.Property titleProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#title");
	private java.lang.String title;
	private static com.hp.hpl.jena.rdf.model.Property deliveryURLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#deliveryURL");
	private java.lang.String deliveryURL;
	private static com.hp.hpl.jena.rdf.model.Property recommendedDishesProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#recommendedDishes");
	private java.lang.String recommendedDishes;
	private static com.hp.hpl.jena.rdf.model.Property URLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#URL");
	private java.lang.String URL;
	private static com.hp.hpl.jena.rdf.model.Property cuisineProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#cuisine");
	private java.util.ArrayList cuisine;
	private static com.hp.hpl.jena.rdf.model.Property smokingProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#smoking");
	private ibspan.tss.domain.ontology.restaurant.SmokingCode smoking;
	private static com.hp.hpl.jena.rdf.model.Property featureProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#feature");
	private java.util.ArrayList feature;
	private static com.hp.hpl.jena.rdf.model.Property restaurantCategoryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#restaurantCategory");
	private ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode restaurantCategory;
	private static com.hp.hpl.jena.rdf.model.Property parsedHoursProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#parsedHours");
	private java.lang.String parsedHours;
	private static com.hp.hpl.jena.rdf.model.Property alcoholProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#alcohol");
	private java.util.ArrayList alcohol;
	private static com.hp.hpl.jena.rdf.model.Property dressProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#dress");
	private java.util.ArrayList dress;
	private static com.hp.hpl.jena.rdf.model.Property hasDinerReviewProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#hasDinerReview");
	private java.util.ArrayList hasDinerReview;
	private static com.hp.hpl.jena.rdf.model.Property menuURLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#menuURL");
	private java.lang.String menuURL;
	private static com.hp.hpl.jena.rdf.model.Property accessibilityNotesProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#accessibilityNotes");
	private java.lang.String accessibilityNotes;
	private static com.hp.hpl.jena.rdf.model.Property largestPartyProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#largestParty");
	private com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType largestParty;
	private static com.hp.hpl.jena.rdf.model.Property parkingProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#parking");
	private java.util.ArrayList parking;
	private static com.hp.hpl.jena.rdf.model.Property reservationsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#reservations");
	private java.util.ArrayList reservations;
	private static com.hp.hpl.jena.rdf.model.Property breakfastPriceProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#breakfastPrice");
	private com.ibm.adtech.jastor.Thing breakfastPrice;
	private static com.hp.hpl.jena.rdf.model.Property reservationURLProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#reservationURL");
	private java.lang.String reservationURL;
	private static com.hp.hpl.jena.rdf.model.Property hoursProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#hours");
	private java.lang.String hours;
	private static com.hp.hpl.jena.rdf.model.Property acceptsProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/Restaurant#accepts");
	private java.util.ArrayList accepts;

	RestaurantImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static RestaurantImpl getRestaurant(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Restaurant.TYPE))
			return null;
		return new RestaurantImpl(resource, model);
	}
	    
	static RestaurantImpl createRestaurant(Resource resource, Model model) throws JastorException {
		RestaurantImpl impl = new RestaurantImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Restaurant.TYPE)))
			impl._model.add(impl._resource, RDF.type, Restaurant.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.domain.ontology.location.Location.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.domain.ontology.location.Location.TYPE));     
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.domain.ontology.restaurant.RestaurantFactory.registerThing(this);
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
		it = _model.listStatements(_resource,clienteleProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,accessibilityProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,lunchPriceProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,dinnerPriceProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,restaurantServiceProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,capacityProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,titleProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,deliveryURLProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,recommendedDishesProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,URLProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,cuisineProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,smokingProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,featureProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,restaurantCategoryProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,parsedHoursProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,alcoholProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,dressProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hasDinerReviewProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,menuURLProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,accessibilityNotesProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,largestPartyProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,parkingProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,reservationsProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,breakfastPriceProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,reservationURLProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,hoursProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,acceptsProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.restaurant.Restaurant.TYPE);
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
		clientele = null;
		accessibility = null;
		lunchPrice = null;
		dinnerPrice = null;
		restaurantService = null;
		capacity = null;
		title = null;
		deliveryURL = null;
		recommendedDishes = null;
		URL = null;
		cuisine = null;
		smoking = null;
		feature = null;
		restaurantCategory = null;
		parsedHours = null;
		alcohol = null;
		dress = null;
		hasDinerReview = null;
		menuURL = null;
		accessibilityNotes = null;
		largestParty = null;
		parking = null;
		reservations = null;
		breakfastPrice = null;
		reservationURL = null;
		hours = null;
		accepts = null;
	}


	private void initIndexPoint() throws JastorException {
		this.indexPoint = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, indexPointProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#indexPoint properties in Restaurant model not a Resource", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": locationPath getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": city getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#crossStreet properties in Restaurant model not a Literal", stmt.getObject());
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
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#attractionCategory properties in Restaurant model not a Resource", stmt.getObject());
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
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#locationCategory properties in Restaurant model not a Resource", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": streetAddress getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": country getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": fax getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": state getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Location#phone properties in Restaurant model not a Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": neighborhood getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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
			throw new JastorInvalidRDFNodeException(uri() + ": zip getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
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

	public java.lang.String getClientele() throws JastorException {
		if (clientele != null)
			return clientele;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, clienteleProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": clientele getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		clientele = (java.lang.String)obj;
		return clientele;
	}
	
	public void setClientele(java.lang.String clientele) throws JastorException {
		if (_model.contains(_resource,clienteleProperty)) {
			_model.removeAll(_resource,clienteleProperty,null);
		}
		this.clientele = clientele;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (clientele != null) {
			_model.add(_model.createStatement(_resource,clienteleProperty, _model.createTypedLiteral(clientele)));
		}	
	}


	private void initAccessibility() throws JastorException {
		this.accessibility = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, accessibilityProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#accessibility properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAccessibilityCode(resource,_model);
				this.accessibility.add(accessibility);
			}
		}
	}

	public java.util.Iterator getAccessibility() throws JastorException {
		if (accessibility == null)
			initAccessibility();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(accessibility,_resource,accessibilityProperty,true);
	}

	public void addAccessibility(ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility) throws JastorException {
		if (this.accessibility == null)
			initAccessibility();
		if (this.accessibility.contains(accessibility)) {
			this.accessibility.remove(accessibility);
			this.accessibility.add(accessibility);
			return;
		}
		this.accessibility.add(accessibility);
		_model.add(_model.createStatement(_resource,accessibilityProperty,accessibility.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.AccessibilityCode addAccessibility() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createAccessibilityCode(_model.createResource(),_model);
		if (this.accessibility == null)
			initAccessibility();
		this.accessibility.add(accessibility);
		_model.add(_model.createStatement(_resource,accessibilityProperty,accessibility.resource()));
		return accessibility;
	}
	
	public ibspan.tss.domain.ontology.restaurant.AccessibilityCode addAccessibility(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.AccessibilityCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.AccessibilityCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAccessibilityCode(resource,_model);
		if (this.accessibility == null)
			initAccessibility();
		if (this.accessibility.contains(accessibility))
			return accessibility;
		this.accessibility.add(accessibility);
		_model.add(_model.createStatement(_resource,accessibilityProperty,accessibility.resource()));
		return accessibility;
	}
	
	public void removeAccessibility(ibspan.tss.domain.ontology.restaurant.AccessibilityCode accessibility) throws JastorException {
		if (this.accessibility == null)
			initAccessibility();
		if (!this.accessibility.contains(accessibility))
			return;
		if (!_model.contains(_resource, accessibilityProperty, accessibility.resource()))
			return;
		this.accessibility.remove(accessibility);
		_model.removeAll(_resource, accessibilityProperty, accessibility.resource());
	}
		 

	public com.ibm.adtech.jastor.Thing getLunchPrice() throws JastorException {
		if (lunchPrice != null)
			return lunchPrice;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, lunchPriceProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": lunchPrice getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		lunchPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		return lunchPrice;
	}

	public void setLunchPrice(com.ibm.adtech.jastor.Thing lunchPrice) throws JastorException {
		if (_model.contains(_resource,lunchPriceProperty)) {
			_model.removeAll(_resource,lunchPriceProperty,null);
		}
		this.lunchPrice = lunchPrice;
		if (lunchPrice != null) {
			_model.add(_model.createStatement(_resource,lunchPriceProperty, lunchPrice.resource()));
		}			
	}
		
	public com.ibm.adtech.jastor.Thing setLunchPrice() throws JastorException {
		if (_model.contains(_resource,lunchPriceProperty)) {
			_model.removeAll(_resource,lunchPriceProperty,null);
		}
		com.ibm.adtech.jastor.Thing lunchPrice = com.ibm.adtech.jastor.ThingFactory.createThing(_model.createResource(),_model);
		this.lunchPrice = lunchPrice;
		_model.add(_model.createStatement(_resource,lunchPriceProperty, lunchPrice.resource()));
		return lunchPrice;
	}
	
	public com.ibm.adtech.jastor.Thing setLunchPrice(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (_model.contains(_resource,lunchPriceProperty)) {
			_model.removeAll(_resource,lunchPriceProperty,null);
		}
		com.ibm.adtech.jastor.Thing lunchPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		this.lunchPrice = lunchPrice;
		_model.add(_model.createStatement(_resource,lunchPriceProperty, lunchPrice.resource()));
		return lunchPrice;
	}
	

	public com.ibm.adtech.jastor.Thing getDinnerPrice() throws JastorException {
		if (dinnerPrice != null)
			return dinnerPrice;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, dinnerPriceProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": dinnerPrice getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		dinnerPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		return dinnerPrice;
	}

	public void setDinnerPrice(com.ibm.adtech.jastor.Thing dinnerPrice) throws JastorException {
		if (_model.contains(_resource,dinnerPriceProperty)) {
			_model.removeAll(_resource,dinnerPriceProperty,null);
		}
		this.dinnerPrice = dinnerPrice;
		if (dinnerPrice != null) {
			_model.add(_model.createStatement(_resource,dinnerPriceProperty, dinnerPrice.resource()));
		}			
	}
		
	public com.ibm.adtech.jastor.Thing setDinnerPrice() throws JastorException {
		if (_model.contains(_resource,dinnerPriceProperty)) {
			_model.removeAll(_resource,dinnerPriceProperty,null);
		}
		com.ibm.adtech.jastor.Thing dinnerPrice = com.ibm.adtech.jastor.ThingFactory.createThing(_model.createResource(),_model);
		this.dinnerPrice = dinnerPrice;
		_model.add(_model.createStatement(_resource,dinnerPriceProperty, dinnerPrice.resource()));
		return dinnerPrice;
	}
	
	public com.ibm.adtech.jastor.Thing setDinnerPrice(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (_model.contains(_resource,dinnerPriceProperty)) {
			_model.removeAll(_resource,dinnerPriceProperty,null);
		}
		com.ibm.adtech.jastor.Thing dinnerPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		this.dinnerPrice = dinnerPrice;
		_model.add(_model.createStatement(_resource,dinnerPriceProperty, dinnerPrice.resource()));
		return dinnerPrice;
	}
	

	private void initRestaurantService() throws JastorException {
		this.restaurantService = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, restaurantServiceProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#restaurantService properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantServiceInfo(resource,_model);
				this.restaurantService.add(restaurantService);
			}
		}
	}

	public java.util.Iterator getRestaurantService() throws JastorException {
		if (restaurantService == null)
			initRestaurantService();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(restaurantService,_resource,restaurantServiceProperty,true);
	}

	public void addRestaurantService(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService) throws JastorException {
		if (this.restaurantService == null)
			initRestaurantService();
		if (this.restaurantService.contains(restaurantService)) {
			this.restaurantService.remove(restaurantService);
			this.restaurantService.add(restaurantService);
			return;
		}
		this.restaurantService.add(restaurantService);
		_model.add(_model.createStatement(_resource,restaurantServiceProperty,restaurantService.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo addRestaurantService() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createRestaurantServiceInfo(_model.createResource(),_model);
		if (this.restaurantService == null)
			initRestaurantService();
		this.restaurantService.add(restaurantService);
		_model.add(_model.createStatement(_resource,restaurantServiceProperty,restaurantService.resource()));
		return restaurantService;
	}
	
	public ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo addRestaurantService(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo.TYPE);
		ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantServiceInfo(resource,_model);
		if (this.restaurantService == null)
			initRestaurantService();
		if (this.restaurantService.contains(restaurantService))
			return restaurantService;
		this.restaurantService.add(restaurantService);
		_model.add(_model.createStatement(_resource,restaurantServiceProperty,restaurantService.resource()));
		return restaurantService;
	}
	
	public void removeRestaurantService(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo restaurantService) throws JastorException {
		if (this.restaurantService == null)
			initRestaurantService();
		if (!this.restaurantService.contains(restaurantService))
			return;
		if (!_model.contains(_resource, restaurantServiceProperty, restaurantService.resource()))
			return;
		this.restaurantService.remove(restaurantService);
		_model.removeAll(_resource, restaurantServiceProperty, restaurantService.resource());
	}
		 
	public com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType getCapacity() throws JastorException {
		if (capacity != null)
			return capacity;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, capacityProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": capacity getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType");
		capacity = (com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType)obj;
		return capacity;
	}
	
	public void setCapacity(com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType capacity) throws JastorException {
		if (_model.contains(_resource,capacityProperty)) {
			_model.removeAll(_resource,capacityProperty,null);
		}
		this.capacity = capacity;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (capacity != null) {
			_model.add(_model.createStatement(_resource,capacityProperty, _model.createTypedLiteral(capacity)));
		}	
	}

	public java.lang.String getTitle() throws JastorException {
		if (title != null)
			return title;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, titleProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": title getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		title = (java.lang.String)obj;
		return title;
	}
	
	public void setTitle(java.lang.String title) throws JastorException {
		if (_model.contains(_resource,titleProperty)) {
			_model.removeAll(_resource,titleProperty,null);
		}
		this.title = title;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (title != null) {
			_model.add(_model.createStatement(_resource,titleProperty, _model.createTypedLiteral(title)));
		}	
	}

	public java.lang.String getDeliveryURL() throws JastorException {
		if (deliveryURL != null)
			return deliveryURL;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, deliveryURLProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": deliveryURL getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		deliveryURL = (java.lang.String)obj;
		return deliveryURL;
	}
	
	public void setDeliveryURL(java.lang.String deliveryURL) throws JastorException {
		if (_model.contains(_resource,deliveryURLProperty)) {
			_model.removeAll(_resource,deliveryURLProperty,null);
		}
		this.deliveryURL = deliveryURL;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (deliveryURL != null) {
			_model.add(_model.createStatement(_resource,deliveryURLProperty, _model.createTypedLiteral(deliveryURL)));
		}	
	}

	public java.lang.String getRecommendedDishes() throws JastorException {
		if (recommendedDishes != null)
			return recommendedDishes;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, recommendedDishesProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": recommendedDishes getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		recommendedDishes = (java.lang.String)obj;
		return recommendedDishes;
	}
	
	public void setRecommendedDishes(java.lang.String recommendedDishes) throws JastorException {
		if (_model.contains(_resource,recommendedDishesProperty)) {
			_model.removeAll(_resource,recommendedDishesProperty,null);
		}
		this.recommendedDishes = recommendedDishes;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (recommendedDishes != null) {
			_model.add(_model.createStatement(_resource,recommendedDishesProperty, _model.createTypedLiteral(recommendedDishes)));
		}	
	}

	public java.lang.String getURL() throws JastorException {
		if (URL != null)
			return URL;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, URLProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": URL getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		URL = (java.lang.String)obj;
		return URL;
	}
	
	public void setURL(java.lang.String URL) throws JastorException {
		if (_model.contains(_resource,URLProperty)) {
			_model.removeAll(_resource,URLProperty,null);
		}
		this.URL = URL;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (URL != null) {
			_model.add(_model.createStatement(_resource,URLProperty, _model.createTypedLiteral(URL)));
		}	
	}


	private void initCuisine() throws JastorException {
		this.cuisine = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, cuisineProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#cuisine properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getCuisineCode(resource,_model);
				this.cuisine.add(cuisine);
			}
		}
	}

	public java.util.Iterator getCuisine() throws JastorException {
		if (cuisine == null)
			initCuisine();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(cuisine,_resource,cuisineProperty,true);
	}

	public void addCuisine(ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine) throws JastorException {
		if (this.cuisine == null)
			initCuisine();
		if (this.cuisine.contains(cuisine)) {
			this.cuisine.remove(cuisine);
			this.cuisine.add(cuisine);
			return;
		}
		this.cuisine.add(cuisine);
		_model.add(_model.createStatement(_resource,cuisineProperty,cuisine.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.CuisineCode addCuisine() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createCuisineCode(_model.createResource(),_model);
		if (this.cuisine == null)
			initCuisine();
		this.cuisine.add(cuisine);
		_model.add(_model.createStatement(_resource,cuisineProperty,cuisine.resource()));
		return cuisine;
	}
	
	public ibspan.tss.domain.ontology.restaurant.CuisineCode addCuisine(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.CuisineCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.CuisineCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getCuisineCode(resource,_model);
		if (this.cuisine == null)
			initCuisine();
		if (this.cuisine.contains(cuisine))
			return cuisine;
		this.cuisine.add(cuisine);
		_model.add(_model.createStatement(_resource,cuisineProperty,cuisine.resource()));
		return cuisine;
	}
	
	public void removeCuisine(ibspan.tss.domain.ontology.restaurant.CuisineCode cuisine) throws JastorException {
		if (this.cuisine == null)
			initCuisine();
		if (!this.cuisine.contains(cuisine))
			return;
		if (!_model.contains(_resource, cuisineProperty, cuisine.resource()))
			return;
		this.cuisine.remove(cuisine);
		_model.removeAll(_resource, cuisineProperty, cuisine.resource());
	}
		 

	public ibspan.tss.domain.ontology.restaurant.SmokingCode getSmoking() throws JastorException {
		if (smoking != null)
			return smoking;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, smokingProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": smoking getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		smoking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getSmokingCode(resource,_model);
		return smoking;
	}

	public void setSmoking(ibspan.tss.domain.ontology.restaurant.SmokingCode smoking) throws JastorException {
		if (_model.contains(_resource,smokingProperty)) {
			_model.removeAll(_resource,smokingProperty,null);
		}
		this.smoking = smoking;
		if (smoking != null) {
			_model.add(_model.createStatement(_resource,smokingProperty, smoking.resource()));
		}			
	}
		
	public ibspan.tss.domain.ontology.restaurant.SmokingCode setSmoking() throws JastorException {
		if (_model.contains(_resource,smokingProperty)) {
			_model.removeAll(_resource,smokingProperty,null);
		}
		ibspan.tss.domain.ontology.restaurant.SmokingCode smoking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createSmokingCode(_model.createResource(),_model);
		this.smoking = smoking;
		_model.add(_model.createStatement(_resource,smokingProperty, smoking.resource()));
		return smoking;
	}
	
	public ibspan.tss.domain.ontology.restaurant.SmokingCode setSmoking(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.SmokingCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.SmokingCode.TYPE);
		if (_model.contains(_resource,smokingProperty)) {
			_model.removeAll(_resource,smokingProperty,null);
		}
		ibspan.tss.domain.ontology.restaurant.SmokingCode smoking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getSmokingCode(resource,_model);
		this.smoking = smoking;
		_model.add(_model.createStatement(_resource,smokingProperty, smoking.resource()));
		return smoking;
	}
	

	private void initFeature() throws JastorException {
		this.feature = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, featureProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#feature properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.FeatureCode feature = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getFeatureCode(resource,_model);
				this.feature.add(feature);
			}
		}
	}

	public java.util.Iterator getFeature() throws JastorException {
		if (feature == null)
			initFeature();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(feature,_resource,featureProperty,true);
	}

	public void addFeature(ibspan.tss.domain.ontology.restaurant.FeatureCode feature) throws JastorException {
		if (this.feature == null)
			initFeature();
		if (this.feature.contains(feature)) {
			this.feature.remove(feature);
			this.feature.add(feature);
			return;
		}
		this.feature.add(feature);
		_model.add(_model.createStatement(_resource,featureProperty,feature.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.FeatureCode addFeature() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.FeatureCode feature = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createFeatureCode(_model.createResource(),_model);
		if (this.feature == null)
			initFeature();
		this.feature.add(feature);
		_model.add(_model.createStatement(_resource,featureProperty,feature.resource()));
		return feature;
	}
	
	public ibspan.tss.domain.ontology.restaurant.FeatureCode addFeature(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.FeatureCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.FeatureCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.FeatureCode feature = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getFeatureCode(resource,_model);
		if (this.feature == null)
			initFeature();
		if (this.feature.contains(feature))
			return feature;
		this.feature.add(feature);
		_model.add(_model.createStatement(_resource,featureProperty,feature.resource()));
		return feature;
	}
	
	public void removeFeature(ibspan.tss.domain.ontology.restaurant.FeatureCode feature) throws JastorException {
		if (this.feature == null)
			initFeature();
		if (!this.feature.contains(feature))
			return;
		if (!_model.contains(_resource, featureProperty, feature.resource()))
			return;
		this.feature.remove(feature);
		_model.removeAll(_resource, featureProperty, feature.resource());
	}
		 

	public ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode getRestaurantCategory() throws JastorException {
		if (restaurantCategory != null)
			return restaurantCategory;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, restaurantCategoryProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": restaurantCategory getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		restaurantCategory = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantCategoryCode(resource,_model);
		return restaurantCategory;
	}

	public void setRestaurantCategory(ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode restaurantCategory) throws JastorException {
		if (_model.contains(_resource,restaurantCategoryProperty)) {
			_model.removeAll(_resource,restaurantCategoryProperty,null);
		}
		this.restaurantCategory = restaurantCategory;
		if (restaurantCategory != null) {
			_model.add(_model.createStatement(_resource,restaurantCategoryProperty, restaurantCategory.resource()));
		}			
	}
		
	public ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode setRestaurantCategory() throws JastorException {
		if (_model.contains(_resource,restaurantCategoryProperty)) {
			_model.removeAll(_resource,restaurantCategoryProperty,null);
		}
		ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode restaurantCategory = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createRestaurantCategoryCode(_model.createResource(),_model);
		this.restaurantCategory = restaurantCategory;
		_model.add(_model.createStatement(_resource,restaurantCategoryProperty, restaurantCategory.resource()));
		return restaurantCategory;
	}
	
	public ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode setRestaurantCategory(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode.TYPE);
		if (_model.contains(_resource,restaurantCategoryProperty)) {
			_model.removeAll(_resource,restaurantCategoryProperty,null);
		}
		ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode restaurantCategory = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantCategoryCode(resource,_model);
		this.restaurantCategory = restaurantCategory;
		_model.add(_model.createStatement(_resource,restaurantCategoryProperty, restaurantCategory.resource()));
		return restaurantCategory;
	}
	
	public java.lang.String getParsedHours() throws JastorException {
		if (parsedHours != null)
			return parsedHours;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, parsedHoursProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": parsedHours getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		parsedHours = (java.lang.String)obj;
		return parsedHours;
	}
	
	public void setParsedHours(java.lang.String parsedHours) throws JastorException {
		if (_model.contains(_resource,parsedHoursProperty)) {
			_model.removeAll(_resource,parsedHoursProperty,null);
		}
		this.parsedHours = parsedHours;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (parsedHours != null) {
			_model.add(_model.createStatement(_resource,parsedHoursProperty, _model.createTypedLiteral(parsedHours)));
		}	
	}


	private void initAlcohol() throws JastorException {
		this.alcohol = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, alcoholProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#alcohol properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAlcoholCode(resource,_model);
				this.alcohol.add(alcohol);
			}
		}
	}

	public java.util.Iterator getAlcohol() throws JastorException {
		if (alcohol == null)
			initAlcohol();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(alcohol,_resource,alcoholProperty,true);
	}

	public void addAlcohol(ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol) throws JastorException {
		if (this.alcohol == null)
			initAlcohol();
		if (this.alcohol.contains(alcohol)) {
			this.alcohol.remove(alcohol);
			this.alcohol.add(alcohol);
			return;
		}
		this.alcohol.add(alcohol);
		_model.add(_model.createStatement(_resource,alcoholProperty,alcohol.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.AlcoholCode addAlcohol() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createAlcoholCode(_model.createResource(),_model);
		if (this.alcohol == null)
			initAlcohol();
		this.alcohol.add(alcohol);
		_model.add(_model.createStatement(_resource,alcoholProperty,alcohol.resource()));
		return alcohol;
	}
	
	public ibspan.tss.domain.ontology.restaurant.AlcoholCode addAlcohol(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.AlcoholCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.AlcoholCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAlcoholCode(resource,_model);
		if (this.alcohol == null)
			initAlcohol();
		if (this.alcohol.contains(alcohol))
			return alcohol;
		this.alcohol.add(alcohol);
		_model.add(_model.createStatement(_resource,alcoholProperty,alcohol.resource()));
		return alcohol;
	}
	
	public void removeAlcohol(ibspan.tss.domain.ontology.restaurant.AlcoholCode alcohol) throws JastorException {
		if (this.alcohol == null)
			initAlcohol();
		if (!this.alcohol.contains(alcohol))
			return;
		if (!_model.contains(_resource, alcoholProperty, alcohol.resource()))
			return;
		this.alcohol.remove(alcohol);
		_model.removeAll(_resource, alcoholProperty, alcohol.resource());
	}
		 

	private void initDress() throws JastorException {
		this.dress = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, dressProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#dress properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.DressCode dress = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDressCode(resource,_model);
				this.dress.add(dress);
			}
		}
	}

	public java.util.Iterator getDress() throws JastorException {
		if (dress == null)
			initDress();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(dress,_resource,dressProperty,true);
	}

	public void addDress(ibspan.tss.domain.ontology.restaurant.DressCode dress) throws JastorException {
		if (this.dress == null)
			initDress();
		if (this.dress.contains(dress)) {
			this.dress.remove(dress);
			this.dress.add(dress);
			return;
		}
		this.dress.add(dress);
		_model.add(_model.createStatement(_resource,dressProperty,dress.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.DressCode addDress() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.DressCode dress = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createDressCode(_model.createResource(),_model);
		if (this.dress == null)
			initDress();
		this.dress.add(dress);
		_model.add(_model.createStatement(_resource,dressProperty,dress.resource()));
		return dress;
	}
	
	public ibspan.tss.domain.ontology.restaurant.DressCode addDress(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.DressCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.DressCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.DressCode dress = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDressCode(resource,_model);
		if (this.dress == null)
			initDress();
		if (this.dress.contains(dress))
			return dress;
		this.dress.add(dress);
		_model.add(_model.createStatement(_resource,dressProperty,dress.resource()));
		return dress;
	}
	
	public void removeDress(ibspan.tss.domain.ontology.restaurant.DressCode dress) throws JastorException {
		if (this.dress == null)
			initDress();
		if (!this.dress.contains(dress))
			return;
		if (!_model.contains(_resource, dressProperty, dress.resource()))
			return;
		this.dress.remove(dress);
		_model.removeAll(_resource, dressProperty, dress.resource());
	}
		 

	private void initHasDinerReview() throws JastorException {
		this.hasDinerReview = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, hasDinerReviewProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#hasDinerReview properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDinerReview(resource,_model);
				this.hasDinerReview.add(hasDinerReview);
			}
		}
	}

	public java.util.Iterator getHasDinerReview() throws JastorException {
		if (hasDinerReview == null)
			initHasDinerReview();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(hasDinerReview,_resource,hasDinerReviewProperty,true);
	}

	public void addHasDinerReview(ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview) throws JastorException {
		if (this.hasDinerReview == null)
			initHasDinerReview();
		if (this.hasDinerReview.contains(hasDinerReview)) {
			this.hasDinerReview.remove(hasDinerReview);
			this.hasDinerReview.add(hasDinerReview);
			return;
		}
		this.hasDinerReview.add(hasDinerReview);
		_model.add(_model.createStatement(_resource,hasDinerReviewProperty,hasDinerReview.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.DinerReview addHasDinerReview() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createDinerReview(_model.createResource(),_model);
		if (this.hasDinerReview == null)
			initHasDinerReview();
		this.hasDinerReview.add(hasDinerReview);
		_model.add(_model.createStatement(_resource,hasDinerReviewProperty,hasDinerReview.resource()));
		return hasDinerReview;
	}
	
	public ibspan.tss.domain.ontology.restaurant.DinerReview addHasDinerReview(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.DinerReview.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.DinerReview.TYPE);
		ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDinerReview(resource,_model);
		if (this.hasDinerReview == null)
			initHasDinerReview();
		if (this.hasDinerReview.contains(hasDinerReview))
			return hasDinerReview;
		this.hasDinerReview.add(hasDinerReview);
		_model.add(_model.createStatement(_resource,hasDinerReviewProperty,hasDinerReview.resource()));
		return hasDinerReview;
	}
	
	public void removeHasDinerReview(ibspan.tss.domain.ontology.restaurant.DinerReview hasDinerReview) throws JastorException {
		if (this.hasDinerReview == null)
			initHasDinerReview();
		if (!this.hasDinerReview.contains(hasDinerReview))
			return;
		if (!_model.contains(_resource, hasDinerReviewProperty, hasDinerReview.resource()))
			return;
		this.hasDinerReview.remove(hasDinerReview);
		_model.removeAll(_resource, hasDinerReviewProperty, hasDinerReview.resource());
	}
		 
	public java.lang.String getMenuURL() throws JastorException {
		if (menuURL != null)
			return menuURL;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, menuURLProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": menuURL getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		menuURL = (java.lang.String)obj;
		return menuURL;
	}
	
	public void setMenuURL(java.lang.String menuURL) throws JastorException {
		if (_model.contains(_resource,menuURLProperty)) {
			_model.removeAll(_resource,menuURLProperty,null);
		}
		this.menuURL = menuURL;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (menuURL != null) {
			_model.add(_model.createStatement(_resource,menuURLProperty, _model.createTypedLiteral(menuURL)));
		}	
	}

	public java.lang.String getAccessibilityNotes() throws JastorException {
		if (accessibilityNotes != null)
			return accessibilityNotes;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, accessibilityNotesProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": accessibilityNotes getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		accessibilityNotes = (java.lang.String)obj;
		return accessibilityNotes;
	}
	
	public void setAccessibilityNotes(java.lang.String accessibilityNotes) throws JastorException {
		if (_model.contains(_resource,accessibilityNotesProperty)) {
			_model.removeAll(_resource,accessibilityNotesProperty,null);
		}
		this.accessibilityNotes = accessibilityNotes;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (accessibilityNotes != null) {
			_model.add(_model.createStatement(_resource,accessibilityNotesProperty, _model.createTypedLiteral(accessibilityNotes)));
		}	
	}

	public com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType getLargestParty() throws JastorException {
		if (largestParty != null)
			return largestParty;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, largestPartyProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": largestParty getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType");
		largestParty = (com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType)obj;
		return largestParty;
	}
	
	public void setLargestParty(com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType largestParty) throws JastorException {
		if (_model.contains(_resource,largestPartyProperty)) {
			_model.removeAll(_resource,largestPartyProperty,null);
		}
		this.largestParty = largestParty;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (largestParty != null) {
			_model.add(_model.createStatement(_resource,largestPartyProperty, _model.createTypedLiteral(largestParty)));
		}	
	}


	private void initParking() throws JastorException {
		this.parking = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, parkingProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#parking properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.ParkingCode parking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getParkingCode(resource,_model);
				this.parking.add(parking);
			}
		}
	}

	public java.util.Iterator getParking() throws JastorException {
		if (parking == null)
			initParking();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(parking,_resource,parkingProperty,true);
	}

	public void addParking(ibspan.tss.domain.ontology.restaurant.ParkingCode parking) throws JastorException {
		if (this.parking == null)
			initParking();
		if (this.parking.contains(parking)) {
			this.parking.remove(parking);
			this.parking.add(parking);
			return;
		}
		this.parking.add(parking);
		_model.add(_model.createStatement(_resource,parkingProperty,parking.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.ParkingCode addParking() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.ParkingCode parking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createParkingCode(_model.createResource(),_model);
		if (this.parking == null)
			initParking();
		this.parking.add(parking);
		_model.add(_model.createStatement(_resource,parkingProperty,parking.resource()));
		return parking;
	}
	
	public ibspan.tss.domain.ontology.restaurant.ParkingCode addParking(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.ParkingCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.ParkingCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.ParkingCode parking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getParkingCode(resource,_model);
		if (this.parking == null)
			initParking();
		if (this.parking.contains(parking))
			return parking;
		this.parking.add(parking);
		_model.add(_model.createStatement(_resource,parkingProperty,parking.resource()));
		return parking;
	}
	
	public void removeParking(ibspan.tss.domain.ontology.restaurant.ParkingCode parking) throws JastorException {
		if (this.parking == null)
			initParking();
		if (!this.parking.contains(parking))
			return;
		if (!_model.contains(_resource, parkingProperty, parking.resource()))
			return;
		this.parking.remove(parking);
		_model.removeAll(_resource, parkingProperty, parking.resource());
	}
		 

	private void initReservations() throws JastorException {
		this.reservations = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, reservationsProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#reservations properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				ibspan.tss.domain.ontology.restaurant.ReservationCode reservations = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getReservationCode(resource,_model);
				this.reservations.add(reservations);
			}
		}
	}

	public java.util.Iterator getReservations() throws JastorException {
		if (reservations == null)
			initReservations();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(reservations,_resource,reservationsProperty,true);
	}

	public void addReservations(ibspan.tss.domain.ontology.restaurant.ReservationCode reservations) throws JastorException {
		if (this.reservations == null)
			initReservations();
		if (this.reservations.contains(reservations)) {
			this.reservations.remove(reservations);
			this.reservations.add(reservations);
			return;
		}
		this.reservations.add(reservations);
		_model.add(_model.createStatement(_resource,reservationsProperty,reservations.resource()));
	}
	
	public ibspan.tss.domain.ontology.restaurant.ReservationCode addReservations() throws JastorException {
		ibspan.tss.domain.ontology.restaurant.ReservationCode reservations = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.createReservationCode(_model.createResource(),_model);
		if (this.reservations == null)
			initReservations();
		this.reservations.add(reservations);
		_model.add(_model.createStatement(_resource,reservationsProperty,reservations.resource()));
		return reservations;
	}
	
	public ibspan.tss.domain.ontology.restaurant.ReservationCode addReservations(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (!_model.contains(resource,RDF.type,ibspan.tss.domain.ontology.restaurant.ReservationCode.TYPE))
			throw new JastorException("Resource " + resource + " not of type " + ibspan.tss.domain.ontology.restaurant.ReservationCode.TYPE);
		ibspan.tss.domain.ontology.restaurant.ReservationCode reservations = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getReservationCode(resource,_model);
		if (this.reservations == null)
			initReservations();
		if (this.reservations.contains(reservations))
			return reservations;
		this.reservations.add(reservations);
		_model.add(_model.createStatement(_resource,reservationsProperty,reservations.resource()));
		return reservations;
	}
	
	public void removeReservations(ibspan.tss.domain.ontology.restaurant.ReservationCode reservations) throws JastorException {
		if (this.reservations == null)
			initReservations();
		if (!this.reservations.contains(reservations))
			return;
		if (!_model.contains(_resource, reservationsProperty, reservations.resource()))
			return;
		this.reservations.remove(reservations);
		_model.removeAll(_resource, reservationsProperty, reservations.resource());
	}
		 

	public com.ibm.adtech.jastor.Thing getBreakfastPrice() throws JastorException {
		if (breakfastPrice != null)
			return breakfastPrice;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, breakfastPriceProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
			throw new JastorInvalidRDFNodeException(uri() + ": breakfastPrice getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Resource", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
		breakfastPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		return breakfastPrice;
	}

	public void setBreakfastPrice(com.ibm.adtech.jastor.Thing breakfastPrice) throws JastorException {
		if (_model.contains(_resource,breakfastPriceProperty)) {
			_model.removeAll(_resource,breakfastPriceProperty,null);
		}
		this.breakfastPrice = breakfastPrice;
		if (breakfastPrice != null) {
			_model.add(_model.createStatement(_resource,breakfastPriceProperty, breakfastPrice.resource()));
		}			
	}
		
	public com.ibm.adtech.jastor.Thing setBreakfastPrice() throws JastorException {
		if (_model.contains(_resource,breakfastPriceProperty)) {
			_model.removeAll(_resource,breakfastPriceProperty,null);
		}
		com.ibm.adtech.jastor.Thing breakfastPrice = com.ibm.adtech.jastor.ThingFactory.createThing(_model.createResource(),_model);
		this.breakfastPrice = breakfastPrice;
		_model.add(_model.createStatement(_resource,breakfastPriceProperty, breakfastPrice.resource()));
		return breakfastPrice;
	}
	
	public com.ibm.adtech.jastor.Thing setBreakfastPrice(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		if (_model.contains(_resource,breakfastPriceProperty)) {
			_model.removeAll(_resource,breakfastPriceProperty,null);
		}
		com.ibm.adtech.jastor.Thing breakfastPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		this.breakfastPrice = breakfastPrice;
		_model.add(_model.createStatement(_resource,breakfastPriceProperty, breakfastPrice.resource()));
		return breakfastPrice;
	}
	
	public java.lang.String getReservationURL() throws JastorException {
		if (reservationURL != null)
			return reservationURL;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, reservationURLProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": reservationURL getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		reservationURL = (java.lang.String)obj;
		return reservationURL;
	}
	
	public void setReservationURL(java.lang.String reservationURL) throws JastorException {
		if (_model.contains(_resource,reservationURLProperty)) {
			_model.removeAll(_resource,reservationURLProperty,null);
		}
		this.reservationURL = reservationURL;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (reservationURL != null) {
			_model.add(_model.createStatement(_resource,reservationURLProperty, _model.createTypedLiteral(reservationURL)));
		}	
	}

	public java.lang.String getHours() throws JastorException {
		if (hours != null)
			return hours;
		com.hp.hpl.jena.rdf.model.Statement stmt = _model.getProperty(_resource, hoursProperty);
		if (stmt == null)
			return null;
		if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
			throw new JastorInvalidRDFNodeException(uri() + ": hours getProperty() in ibspan.tss.domain.ontology.restaurant.Restaurant model not Literal", stmt.getObject());
		com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
		Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
		hours = (java.lang.String)obj;
		return hours;
	}
	
	public void setHours(java.lang.String hours) throws JastorException {
		if (_model.contains(_resource,hoursProperty)) {
			_model.removeAll(_resource,hoursProperty,null);
		}
		this.hours = hours;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		if (hours != null) {
			_model.add(_model.createStatement(_resource,hoursProperty, _model.createTypedLiteral(hours)));
		}	
	}


	private void initAccepts() throws JastorException {
		this.accepts = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, acceptsProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/Restaurant#accepts properties in Restaurant model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				com.ibm.adtech.jastor.Thing accepts = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
				this.accepts.add(accepts);
			}
		}
	}

	public java.util.Iterator getAccepts() throws JastorException {
		if (accepts == null)
			initAccepts();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(accepts,_resource,acceptsProperty,true);
	}

	public void addAccepts(com.ibm.adtech.jastor.Thing accepts) throws JastorException {
		if (this.accepts == null)
			initAccepts();
		if (this.accepts.contains(accepts)) {
			this.accepts.remove(accepts);
			this.accepts.add(accepts);
			return;
		}
		this.accepts.add(accepts);
		_model.add(_model.createStatement(_resource,acceptsProperty,accepts.resource()));
	}
	
	public com.ibm.adtech.jastor.Thing addAccepts() throws JastorException {
		com.ibm.adtech.jastor.Thing accepts = com.ibm.adtech.jastor.ThingFactory.createThing(_model.createResource(),_model);
		if (this.accepts == null)
			initAccepts();
		this.accepts.add(accepts);
		_model.add(_model.createStatement(_resource,acceptsProperty,accepts.resource()));
		return accepts;
	}
	
	public com.ibm.adtech.jastor.Thing addAccepts(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		com.ibm.adtech.jastor.Thing accepts = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		if (this.accepts == null)
			initAccepts();
		if (this.accepts.contains(accepts))
			return accepts;
		this.accepts.add(accepts);
		_model.add(_model.createStatement(_resource,acceptsProperty,accepts.resource()));
		return accepts;
	}
	
	public void removeAccepts(com.ibm.adtech.jastor.Thing accepts) throws JastorException {
		if (this.accepts == null)
			initAccepts();
		if (!this.accepts.contains(accepts))
			return;
		if (!_model.contains(_resource, acceptsProperty, accepts.resource()))
			return;
		this.accepts.remove(accepts);
		_model.removeAll(_resource, acceptsProperty, accepts.resource());
	}
		  


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof RestaurantListener))
			throw new IllegalArgumentException("ThingListener must be instance of RestaurantListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((RestaurantListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof RestaurantListener))
			throw new IllegalArgumentException("ThingListener must be instance of RestaurantListener"); 
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
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.indexPointAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_indexPoint);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.locationPathChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.cityChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.crossStreetAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,(java.lang.String)obj);
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
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.attractionCategoryAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_attractionCategory);
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
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.locationCategoryAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_locationCategory);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.streetAddressChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.countryChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.faxChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.stateChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.phoneAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,(java.lang.String)obj);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.neighborhoodChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.zipChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(clienteleProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				clientele = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.clienteleChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(accessibilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.AccessibilityCode _accessibility = null;
					try {
						_accessibility = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAccessibilityCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (accessibility == null) {
						try {
							initAccessibility();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!accessibility.contains(_accessibility))
						accessibility.add(_accessibility);
					if (listeners != null) {
						java.util.ArrayList consumersForAccessibility;
						synchronized (listeners) {
							consumersForAccessibility = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAccessibility.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.accessibilityAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_accessibility);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(lunchPriceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				lunchPrice = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						lunchPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.lunchPriceChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(dinnerPriceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				dinnerPrice = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						dinnerPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.dinnerPriceChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(restaurantServiceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo _restaurantService = null;
					try {
						_restaurantService = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantServiceInfo(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (restaurantService == null) {
						try {
							initRestaurantService();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!restaurantService.contains(_restaurantService))
						restaurantService.add(_restaurantService);
					if (listeners != null) {
						java.util.ArrayList consumersForRestaurantService;
						synchronized (listeners) {
							consumersForRestaurantService = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForRestaurantService.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.restaurantServiceAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_restaurantService);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(capacityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				capacity = (com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType)Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.capacityChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(titleProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				title = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.titleChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(deliveryURLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				deliveryURL = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.deliveryURLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(recommendedDishesProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				recommendedDishes = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.recommendedDishesChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(URLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				URL = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.URLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(cuisineProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.CuisineCode _cuisine = null;
					try {
						_cuisine = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getCuisineCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (cuisine == null) {
						try {
							initCuisine();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!cuisine.contains(_cuisine))
						cuisine.add(_cuisine);
					if (listeners != null) {
						java.util.ArrayList consumersForCuisine;
						synchronized (listeners) {
							consumersForCuisine = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForCuisine.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.cuisineAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_cuisine);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(smokingProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				smoking = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						smoking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getSmokingCode(resource,_model);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.smokingChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(featureProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.FeatureCode _feature = null;
					try {
						_feature = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getFeatureCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (feature == null) {
						try {
							initFeature();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!feature.contains(_feature))
						feature.add(_feature);
					if (listeners != null) {
						java.util.ArrayList consumersForFeature;
						synchronized (listeners) {
							consumersForFeature = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForFeature.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.featureAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_feature);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(restaurantCategoryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				restaurantCategory = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						restaurantCategory = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantCategoryCode(resource,_model);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.restaurantCategoryChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(parsedHoursProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				parsedHours = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.parsedHoursChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(alcoholProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.AlcoholCode _alcohol = null;
					try {
						_alcohol = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAlcoholCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (alcohol == null) {
						try {
							initAlcohol();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!alcohol.contains(_alcohol))
						alcohol.add(_alcohol);
					if (listeners != null) {
						java.util.ArrayList consumersForAlcohol;
						synchronized (listeners) {
							consumersForAlcohol = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAlcohol.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.alcoholAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_alcohol);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(dressProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.DressCode _dress = null;
					try {
						_dress = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDressCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (dress == null) {
						try {
							initDress();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!dress.contains(_dress))
						dress.add(_dress);
					if (listeners != null) {
						java.util.ArrayList consumersForDress;
						synchronized (listeners) {
							consumersForDress = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForDress.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.dressAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_dress);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasDinerReviewProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.DinerReview _hasDinerReview = null;
					try {
						_hasDinerReview = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDinerReview(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (hasDinerReview == null) {
						try {
							initHasDinerReview();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!hasDinerReview.contains(_hasDinerReview))
						hasDinerReview.add(_hasDinerReview);
					if (listeners != null) {
						java.util.ArrayList consumersForHasDinerReview;
						synchronized (listeners) {
							consumersForHasDinerReview = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasDinerReview.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.hasDinerReviewAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_hasDinerReview);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(menuURLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				menuURL = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.menuURLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(accessibilityNotesProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				accessibilityNotes = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.accessibilityNotesChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(largestPartyProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				largestParty = (com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType)Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.largestPartyChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(parkingProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.ParkingCode _parking = null;
					try {
						_parking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getParkingCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (parking == null) {
						try {
							initParking();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!parking.contains(_parking))
						parking.add(_parking);
					if (listeners != null) {
						java.util.ArrayList consumersForParking;
						synchronized (listeners) {
							consumersForParking = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForParking.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.parkingAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_parking);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(reservationsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.ReservationCode _reservations = null;
					try {
						_reservations = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getReservationCode(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (reservations == null) {
						try {
							initReservations();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!reservations.contains(_reservations))
						reservations.add(_reservations);
					if (listeners != null) {
						java.util.ArrayList consumersForReservations;
						synchronized (listeners) {
							consumersForReservations = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForReservations.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.reservationsAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_reservations);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(breakfastPriceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				breakfastPrice = null;
				if (true) { // don't check resource type if the property range is Resource
					try {
						breakfastPrice = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.breakfastPriceChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(reservationURLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				reservationURL = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.reservationURLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hoursProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				hours = (java.lang.String)Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.hoursChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(acceptsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					com.ibm.adtech.jastor.Thing _accepts = null;
					try {
						_accepts = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (accepts == null) {
						try {
							initAccepts();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!accepts.contains(_accepts))
						accepts.add(_accepts);
					if (listeners != null) {
						java.util.ArrayList consumersForAccepts;
						synchronized (listeners) {
							consumersForAccepts = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAccepts.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.acceptsAdded(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_accepts);
						}
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
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.indexPointRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_indexPoint);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.locationPathChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.cityChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.crossStreetRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,(java.lang.String)obj);
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
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.attractionCategoryRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_attractionCategory);
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
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.locationCategoryRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_locationCategory);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.streetAddressChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.countryChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.faxChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.stateChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.phoneRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,(java.lang.String)obj);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.neighborhoodChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
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
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.zipChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(clienteleProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (clientele != null && clientele.equals(obj))
					clientele = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.clienteleChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(accessibilityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.AccessibilityCode _accessibility = null;
					if (accessibility != null) {
						boolean found = false;
						for (int i=0;i<accessibility.size();i++) {
							ibspan.tss.domain.ontology.restaurant.AccessibilityCode __item = (ibspan.tss.domain.ontology.restaurant.AccessibilityCode) accessibility.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_accessibility = __item;
								break;
							}
						}
						if (found)
							accessibility.remove(_accessibility);
						else {
							try {
								_accessibility = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAccessibilityCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_accessibility = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAccessibilityCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForAccessibility;
						synchronized (listeners) {
							consumersForAccessibility = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAccessibility.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.accessibilityRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_accessibility);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(lunchPriceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (lunchPrice != null && lunchPrice.resource().equals(resource))
						lunchPrice = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.lunchPriceChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(dinnerPriceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (dinnerPrice != null && dinnerPrice.resource().equals(resource))
						dinnerPrice = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.dinnerPriceChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(restaurantServiceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo _restaurantService = null;
					if (restaurantService != null) {
						boolean found = false;
						for (int i=0;i<restaurantService.size();i++) {
							ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo __item = (ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo) restaurantService.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_restaurantService = __item;
								break;
							}
						}
						if (found)
							restaurantService.remove(_restaurantService);
						else {
							try {
								_restaurantService = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantServiceInfo(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_restaurantService = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getRestaurantServiceInfo(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForRestaurantService;
						synchronized (listeners) {
							consumersForRestaurantService = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForRestaurantService.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.restaurantServiceRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_restaurantService);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(capacityProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType");
				if (capacity != null && capacity.equals(obj))
					capacity = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.capacityChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(titleProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (title != null && title.equals(obj))
					title = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.titleChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(deliveryURLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (deliveryURL != null && deliveryURL.equals(obj))
					deliveryURL = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.deliveryURLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(recommendedDishesProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (recommendedDishes != null && recommendedDishes.equals(obj))
					recommendedDishes = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.recommendedDishesChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(URLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (URL != null && URL.equals(obj))
					URL = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.URLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(cuisineProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.CuisineCode _cuisine = null;
					if (cuisine != null) {
						boolean found = false;
						for (int i=0;i<cuisine.size();i++) {
							ibspan.tss.domain.ontology.restaurant.CuisineCode __item = (ibspan.tss.domain.ontology.restaurant.CuisineCode) cuisine.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_cuisine = __item;
								break;
							}
						}
						if (found)
							cuisine.remove(_cuisine);
						else {
							try {
								_cuisine = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getCuisineCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_cuisine = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getCuisineCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForCuisine;
						synchronized (listeners) {
							consumersForCuisine = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForCuisine.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.cuisineRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_cuisine);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(smokingProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (smoking != null && smoking.resource().equals(resource))
						smoking = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.smokingChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(featureProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.FeatureCode _feature = null;
					if (feature != null) {
						boolean found = false;
						for (int i=0;i<feature.size();i++) {
							ibspan.tss.domain.ontology.restaurant.FeatureCode __item = (ibspan.tss.domain.ontology.restaurant.FeatureCode) feature.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_feature = __item;
								break;
							}
						}
						if (found)
							feature.remove(_feature);
						else {
							try {
								_feature = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getFeatureCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_feature = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getFeatureCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForFeature;
						synchronized (listeners) {
							consumersForFeature = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForFeature.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.featureRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_feature);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(restaurantCategoryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (restaurantCategory != null && restaurantCategory.resource().equals(resource))
						restaurantCategory = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.restaurantCategoryChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(parsedHoursProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (parsedHours != null && parsedHours.equals(obj))
					parsedHours = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.parsedHoursChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(alcoholProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.AlcoholCode _alcohol = null;
					if (alcohol != null) {
						boolean found = false;
						for (int i=0;i<alcohol.size();i++) {
							ibspan.tss.domain.ontology.restaurant.AlcoholCode __item = (ibspan.tss.domain.ontology.restaurant.AlcoholCode) alcohol.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_alcohol = __item;
								break;
							}
						}
						if (found)
							alcohol.remove(_alcohol);
						else {
							try {
								_alcohol = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAlcoholCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_alcohol = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getAlcoholCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForAlcohol;
						synchronized (listeners) {
							consumersForAlcohol = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAlcohol.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.alcoholRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_alcohol);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(dressProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.DressCode _dress = null;
					if (dress != null) {
						boolean found = false;
						for (int i=0;i<dress.size();i++) {
							ibspan.tss.domain.ontology.restaurant.DressCode __item = (ibspan.tss.domain.ontology.restaurant.DressCode) dress.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_dress = __item;
								break;
							}
						}
						if (found)
							dress.remove(_dress);
						else {
							try {
								_dress = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDressCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_dress = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDressCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForDress;
						synchronized (listeners) {
							consumersForDress = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForDress.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.dressRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_dress);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hasDinerReviewProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.DinerReview _hasDinerReview = null;
					if (hasDinerReview != null) {
						boolean found = false;
						for (int i=0;i<hasDinerReview.size();i++) {
							ibspan.tss.domain.ontology.restaurant.DinerReview __item = (ibspan.tss.domain.ontology.restaurant.DinerReview) hasDinerReview.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_hasDinerReview = __item;
								break;
							}
						}
						if (found)
							hasDinerReview.remove(_hasDinerReview);
						else {
							try {
								_hasDinerReview = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDinerReview(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_hasDinerReview = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getDinerReview(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForHasDinerReview;
						synchronized (listeners) {
							consumersForHasDinerReview = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasDinerReview.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.hasDinerReviewRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_hasDinerReview);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(menuURLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (menuURL != null && menuURL.equals(obj))
					menuURL = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.menuURLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(accessibilityNotesProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (accessibilityNotes != null && accessibilityNotes.equals(obj))
					accessibilityNotes = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.accessibilityNotesChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(largestPartyProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseNumericType");
				if (largestParty != null && largestParty.equals(obj))
					largestParty = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.largestPartyChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(parkingProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.ParkingCode _parking = null;
					if (parking != null) {
						boolean found = false;
						for (int i=0;i<parking.size();i++) {
							ibspan.tss.domain.ontology.restaurant.ParkingCode __item = (ibspan.tss.domain.ontology.restaurant.ParkingCode) parking.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_parking = __item;
								break;
							}
						}
						if (found)
							parking.remove(_parking);
						else {
							try {
								_parking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getParkingCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_parking = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getParkingCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForParking;
						synchronized (listeners) {
							consumersForParking = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForParking.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.parkingRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_parking);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(reservationsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					ibspan.tss.domain.ontology.restaurant.ReservationCode _reservations = null;
					if (reservations != null) {
						boolean found = false;
						for (int i=0;i<reservations.size();i++) {
							ibspan.tss.domain.ontology.restaurant.ReservationCode __item = (ibspan.tss.domain.ontology.restaurant.ReservationCode) reservations.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_reservations = __item;
								break;
							}
						}
						if (found)
							reservations.remove(_reservations);
						else {
							try {
								_reservations = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getReservationCode(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_reservations = ibspan.tss.domain.ontology.restaurant.RestaurantFactory.getReservationCode(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForReservations;
						synchronized (listeners) {
							consumersForReservations = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForReservations.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.reservationsRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_reservations);
						}
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(breakfastPriceProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
					if (breakfastPrice != null && breakfastPrice.resource().equals(resource))
						breakfastPrice = null;				
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.breakfastPriceChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(reservationURLProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (reservationURL != null && reservationURL.equals(obj))
					reservationURL = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.reservationURLChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(hoursProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Literal.class))
					return;
				com.hp.hpl.jena.rdf.model.Literal literal = (com.hp.hpl.jena.rdf.model.Literal) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Literal.class);
				//Object obj = literal.getValue();
				Object obj = Util.fixLiteral(literal.getValue(),"java.lang.String");
				if (hours != null && hours.equals(obj))
					hours = null;
				if (listeners != null) {
					java.util.ArrayList consumers;
					synchronized (listeners) {
						consumers = (java.util.ArrayList) listeners.clone();
					}
					for(java.util.Iterator iter=consumers.iterator();iter.hasNext();){
						RestaurantListener listener=(RestaurantListener)iter.next();
						listener.hoursChanged(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this);
					}
				}
				return;
			}
			if (stmt.getPredicate().equals(acceptsProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					com.ibm.adtech.jastor.Thing _accepts = null;
					if (accepts != null) {
						boolean found = false;
						for (int i=0;i<accepts.size();i++) {
							com.ibm.adtech.jastor.Thing __item = (com.ibm.adtech.jastor.Thing) accepts.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_accepts = __item;
								break;
							}
						}
						if (found)
							accepts.remove(_accepts);
						else {
							try {
								_accepts = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_accepts = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForAccepts;
						synchronized (listeners) {
							consumersForAccepts = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForAccepts.iterator();iter.hasNext();){
							RestaurantListener listener=(RestaurantListener)iter.next();
							listener.acceptsRemoved(ibspan.tss.domain.ontology.restaurant.RestaurantImpl.this,_accepts);
						}
					}
				}
				return;
			}
		}

	//}
	


}