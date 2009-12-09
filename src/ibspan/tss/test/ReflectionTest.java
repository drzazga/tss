package ibspan.tss.test;

import ibspan.tss.core.semantic.Util;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.core.storage.ModelLoaderInitException;
import ibspan.tss.domain.ontology.restaurant.CuisineCode;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.domain.vocabulary.RestaurantsDBVocabulary;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.ibm.adtech.jastor.JastorException;

public class ReflectionTest {



	public static void main(String[] args) throws JastorException, ModelLoaderInitException {

		OntModel mRestaurantsDB = ModelLoader.loadDBModel(RestaurantsDBVocabulary.NS);
		OntModel mDomain = ModelLoader.loadModel(RestaurantVocabulary.NS);
		
		Resource uri, reflectedURI;
		
		// uri belongs to domain
		uri = CuisineCode.AustrianCuisine;
		reflectedURI = Util.getReflection(uri, mRestaurantsDB, mDomain);
		System.out.println(uri + " -->" + reflectedURI);
		
		// uri does not belongs to domain, but its class belongs
		uri = mRestaurantsDB.getResource("http://www.ibspan.waw.pl/tss/db/PolishRestaurants#Poland_KP_Strzyzawa_Jermir__Restauracja_i_Hotel1023339060");
		reflectedURI = Util.getReflection(uri, mRestaurantsDB, mDomain);
		System.out.println(uri + " -->" + reflectedURI);

		// otherwise
		uri = mRestaurantsDB.getResource("http://www.agentlink.com/SomeOntology#X");
		reflectedURI = Util.getReflection(uri, mRestaurantsDB, mDomain);
		System.out.println(uri + " -->" + reflectedURI);

	}


}
