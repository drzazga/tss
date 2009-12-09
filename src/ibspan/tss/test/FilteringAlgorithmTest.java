package ibspan.tss.test;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.dao.ProfileDAO;
import ibspan.tss.dao.RestaurantDAO;
import ibspan.tss.domain.ontology.location.Location;
import ibspan.tss.domain.ontology.restaurant.CuisineCode;
import ibspan.tss.domain.ontology.restaurant.Restaurant;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.domain.vocabulary.RestaurantsDBVocabulary;
import ibspan.tss.messaging.ontology.Map;
import ibspan.tss.messaging.ontology.MapEntry;
import ibspan.tss.um.filtering.FilteringAlgorithm;
import ibspan.tss.um.ontology.RatedResult;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.vocabulary.ProfilesDBVocabulary;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hp.hpl.jena.ontology.OntModel;

public class FilteringAlgorithmTest {
	

	
	public FilteringAlgorithmTest() {
		try {

			if (0==0)
				return;
			 
			OntModel mDomain = ModelLoader.loadModel(RestaurantVocabulary.NS);
			OntModel mRestaurantsDB = ModelLoader.loadDBModel(RestaurantsDBVocabulary.NS);
			OntModel mProfilesDB = ModelLoader.loadDBModel(ProfilesDBVocabulary.NS);
			RestaurantDAO daoRestaurant = new RestaurantDAO(mDomain, mRestaurantsDB);
			
			ProfileDAO daoProfile = new ProfileDAO(mProfilesDB);
					
			
			
			Map params;
			MapEntry entry;
			
			// Prepare some results from Kielce, not necessary with Pizza served
			params = new Map();
			
			entry = new MapEntry();
			entry.setKey(Location.cityProperty.getURI());
			entry.setValue("Kielce");
			params.addHasEntry(entry);
						
			String varRestaurantName = "rest";
						
			Memory results = daoRestaurant.doQuery(params, 10);
	
			for(Iterator it = UserModellingFactory.getAllRatedResult(results.getModel()).iterator(); it.hasNext();) {
				RatedResult r = (RatedResult) it.next();
				System.out.println("Resource <" + r.getOfObject().resource().getLocalName() + ">");
			}
			System.out.println("------------------------------");
			
			
			
			// Add some results with Pizza cuisine in Poznan
			params = new Map();
			entry = new MapEntry();
			entry.setKey(Location.cityProperty.getURI());
			entry.setValue("Poznan");
			params.addHasEntry(entry);
			
			entry = new MapEntry();
			entry.setKey(Restaurant.cuisineProperty.getURI());
			entry.setValue(CuisineCode.PizzaCuisine.getURI());
			params.addHasEntry(entry);

			Memory resultsWithPizza = daoRestaurant.doQuery(params,100);
			
			results.add(resultsWithPizza);
			/////////////////////////////////////////
			
			for(Iterator it = UserModellingFactory.getAllRatedResult(results.getModel()).iterator(); it.hasNext();) {
				RatedResult r = (RatedResult) it.next();
				System.out.println("Resource <" + r.getOfObject().resource().getLocalName() + ">");
			}
			System.out.println("------------------------------");
			
			UserProfile profile = daoProfile.getUserProfileByID(9);
			
			
			// Simulate sending and receiving template
			Memory mem = new Memory(UserModellingFactory.getUserProfile(profile.uri(), mProfilesDB));			
			mem = new Memory(mem.dump());
			profile = UserModellingFactory.getUserProfile(profile.uri(), mem.getModel());
			// -------------------------
			
			FilteringAlgorithm alg = new FilteringAlgorithm(profile, mDomain);
			
			// Filter out
			results = alg.filter(results, params);
			
			
			// Show results
			for(Iterator it = UserModellingFactory.getAllRatedResult(results.getModel()).iterator(); it.hasNext();) {
				RatedResult r = (RatedResult) it.next();
				System.out.println("Resource <" + r.getOfObject().resource().getLocalName() + "> rated at: " + r.getHasTemperature());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FilteringAlgorithmTest();
	}
}
