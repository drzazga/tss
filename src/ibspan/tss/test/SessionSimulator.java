package ibspan.tss.test;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.dao.RestaurantDAO;
import ibspan.tss.domain.ontology.location.Location;
import ibspan.tss.domain.ontology.restaurant.Restaurant;
import ibspan.tss.domain.ontology.restaurant.RestaurantFactory;
import ibspan.tss.messaging.ontology.MapEntry;
import ibspan.tss.um.ontology.ContextParameter;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.EventSession;
import ibspan.tss.um.ontology.ExtendedUserBehaviour;
import ibspan.tss.um.ontology.RatedResult;
import ibspan.tss.um.ontology.UserBehaviour;
import ibspan.tss.um.ontology.UserBehaviourContext;
import ibspan.tss.um.ontology.UserModellingFactory;
import jade.util.leap.Iterator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.ibm.adtech.jastor.JastorException;

// TODO Simulator does not generate Rate Actions, to do together with agent questions
public class SessionSimulator {
	
	private OntModel mDomain;
	private OntModel mRestaurantsDB;
	private OntModel mHistoryDB;
	
	private List<Restaurant> restaurants;
	private RestaurantDAO daoRestaurant;
	private Map<ObjectProperty,List<OntResource>> rangeMap;
	private List<ObjectProperty> properties;
	private int lastEventID = 0;
	
	// Simulator configuration
	private int maxDetails;
	private int maxSearches;
	private int maxQuerySize;
	
	public void setMaxDetails(int maxDetails) 		{ this.maxDetails = maxDetails; }
	public void setMaxQuerySize(int maxQuerySize) 	{ this.maxQuerySize = maxQuerySize; }
	public void setMaxSearches(int maxSearches) 	{ this.maxSearches = maxSearches; }
	
	private Random generator = new Random(new Date().getTime());
	private Object getRandomObject(List l) { 
		int index = generator.nextInt(l.size());
		return l.get(index);
	}
	
	public SessionSimulator(OntModel mHistoryDB, OntModel mDomain, OntModel mRestaurantsDB) throws JastorException {
		this.mHistoryDB = mHistoryDB;
		this.mRestaurantsDB = mRestaurantsDB;
		this.mDomain = mDomain;
		daoRestaurant = new RestaurantDAO(mDomain, mRestaurantsDB);
		
		restaurants = RestaurantFactory.getAllRestaurant(mRestaurantsDB);
		rangeMap  = new HashMap<ObjectProperty,List<OntResource>>();
		properties = new ArrayList<ObjectProperty>();
		
		addRanges(rangeMap, Restaurant.TYPE);
		addRanges(rangeMap, Location.TYPE);
	}
	
	// Adds ranges for all properties in domain of given resource type together w possible values
	// belonging to these ranges
	private void addRanges(Map<ObjectProperty,List<OntResource>> rangeMap, Resource type) {
		Resource R = mDomain.getResource(type.getURI());
		for(StmtIterator it = mDomain.listStatements(null, RDFS.domain, R); it.hasNext(); ) {
			OntProperty property = (OntProperty) it.nextStatement().getSubject().as(OntProperty.class);
			
			if (property.isObjectProperty()) {
				ObjectProperty objProperty = property.asObjectProperty();
				List<OntResource> values = new ArrayList<OntResource>();
				OntResource range = property.getRange();
				for (ExtendedIterator it2 = mDomain.listIndividuals(range); it2.hasNext(); ) {
					Individual ind = (Individual) it2.next();
					values.add(ind);
				}
				if (! values.isEmpty()) {
					rangeMap.put(objProperty, values);
					properties.add(objProperty);
				}
			}
		}
	}
	
	public void simulateSession(int userID) throws JastorException {
		EventSession session = UserModellingFactory.createEventSession(mHistoryDB.createResource(), mHistoryDB);
		session.setStartedAt(new XSDDateTime(Calendar.getInstance()));
		session.setHasUserID(userID);
		session.setHasSessionID("fakedSession-" + new Date().hashCode());
		
		generateEntryEvent(session, userID);
		
		int searches = generator.nextInt(maxSearches-1)+1;
		while(searches-- >0) {
			simulateSearch(session, userID);
		}
		
		// mHistoryDB.write(System.out,"N3");
	}

	private void simulateSearch(EventSession session, int userID) throws JastorException {
		ibspan.tss.messaging.ontology.Map params = new ibspan.tss.messaging.ontology.Map();
		
		int querySize = generator.nextInt(maxQuerySize-1)+1;
		while(querySize-->0) {
			ObjectProperty objProperty = (ObjectProperty) getRandomObject(properties);
			Individual ind = (Individual) getRandomObject(rangeMap.get(objProperty));
			MapEntry entry = new MapEntry();
			entry.setKey(objProperty.getURI());
			entry.setValue(ind.getURI());
			params.addHasEntry(entry);
		}
		
		generateSearchEvent(session, userID, params);
		
		int details = generator.nextInt(maxDetails);
		while(details-- >0) {
			Restaurant res = (Restaurant) getRandomObject(restaurants);
			simulateDetail(session, userID, res);
		}
	}

	private void simulateDetail(EventSession session, int userID, Restaurant res) throws JastorException {
		generateClickEvent(session, userID, res.uri());
	}

	private void generateEntryEvent(EventSession session, int userID) throws JastorException {
		ExtendedUserBehaviour extBehaviour = generateEvent(session, userID);
		extBehaviour.setHasUserBehaviour(UserBehaviour.EntrySearchingBehaviour);
		extBehaviour.setHasContext();
	}
	
	private void generateRateEvent(EventSession session, int userID) throws JastorException {
		ExtendedUserBehaviour extBehaviour = generateEvent(session, userID);
		extBehaviour.setHasUserBehaviour(UserBehaviour.RateRestaurantPositiveBehaviour);
		extBehaviour.setHasContext();
	}
	
	private void generateSearchEvent(EventSession session, int userID, ibspan.tss.messaging.ontology.Map params) throws JastorException {
		ExtendedUserBehaviour extBehaviour = generateEvent(session, userID);
		extBehaviour.setHasUserBehaviour(UserBehaviour.QueryForRestaurantBehaviour);
		
		UserBehaviourContext context = extBehaviour.setHasContext();
		for(Iterator it = params.getAllHasEntry(); it.hasNext();) {
			MapEntry entry = (MapEntry) it.next();
			ContextParameter param = context.addHasParameter();
			param.setHasName(entry.getKey());
			param.setHasValue(entry.getValue());
		}
	}
	
	private void generateClickEvent(EventSession session, int userID, String targetURI) throws JastorException {
	
		ExtendedUserBehaviour extBehaviour = generateEvent(session, userID);
		extBehaviour.setHasUserBehaviour(UserBehaviour.ClickForRestaurantDetailsBehaviour);
		
		UserBehaviourContext context = extBehaviour.setHasContext();
		ContextParameter param = context.addHasParameter();
		param.setHasName(ContextParameter.TargetURI.getURI());
		param.setHasValue(targetURI);
	}
	
	private ExtendedUserBehaviour generateEvent(EventSession session, int userID) throws JastorException {
		Event event = session.addHasEvent();
		event.setHasEventID(++lastEventID);
		event.setHasUserID(userID);
		event.setHasSessionID(session.getHasSessionID());
		event.setWhen(new XSDDateTime(Calendar.getInstance()));
		return event.setHasExtendedUserBehaviour();
	}

	
}
