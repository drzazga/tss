package ibspan.tss.test;

import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.um.ontology.Dress;
import ibspan.tss.um.ontology.Profession;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.ontology.UserProfileData;
import ibspan.tss.um.ontology.Wealth;
import ibspan.tss.um.stereotyping.StereotypingAlgorithm;
import ibspan.tss.um.vocabulary.ProfilesDBVocabulary;
import ibspan.tss.um.vocabulary.StereotypesDBVocabulary;
import ibspan.tss.um.vocabulary.UserModellingVocabulary;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * 
 * @author maciej
 *
 */
public class StereotypingAlgorithmTest {

	public StereotypingAlgorithmTest() {
		OntModel mProfilesDB = null;
		try {
			OntModel mUM = ModelLoader.loadModel(UserModellingVocabulary.NS);
			OntModel mStereotypesDB = ModelLoader.loadDBModel(StereotypesDBVocabulary.NS);
			mProfilesDB = ModelLoader.loadDBModel(ProfilesDBVocabulary.NS);
		
			// Realize this process in terms of transaction
			// Any changes will be rollbacked 
			// mProfilesDB.begin();
			
			StereotypingAlgorithm alg = new StereotypingAlgorithm(mUM,mStereotypesDB,mProfilesDB,null);
			
			UserProfile profile;
			UserProfileData data;
			
			// Initialize data of profile #100
			profile = UserModellingFactory.createUserProfile(mProfilesDB.createResource(), mProfilesDB);
			profile.setHasUserID(100);
			data = profile.setHasUserProfileData();
			data.setHasAge().setMapsLinearValue(60.0);
			data.setHasDress(Dress.ElegantDress);
			data.setHasProfession(Profession.PensionerAnnuitant);
			data.setHasWealth(Wealth.AverageRich);
			
			// Initialize opinions of profile #100
			alg.initializeUserProfile(profile);
			
			// Initialize data of profile #101
			profile = UserModellingFactory.createUserProfile(mProfilesDB.createResource(), mProfilesDB);
			profile.setHasUserID(101);
			data = profile.setHasUserProfileData();
			data.setHasAge().setMapsLinearValue(10.0);
			data.setHasDress(Dress.SportyDress);
			data.setHasProfession(Profession.StudentPupil);
			data.setHasWealth(Wealth.NotRich);
			
			// Initialize opinions of profile #101
			alg.initializeUserProfile(profile);
			
			// Initialize data of profile #102
			profile = UserModellingFactory.createUserProfile(mProfilesDB.createResource(), mProfilesDB);
			profile.setHasUserID(102);
			data = profile.setHasUserProfileData();
			data.setHasAge().setMapsLinearValue(33.0);
			data.setHasDress(Dress.NaturalDress);
			data.setHasProfession(Profession.ManagerDirector);
			data.setHasWealth(Wealth.VeryRich);
			
			// Initialize opinions of profile #102
			alg.initializeUserProfile(profile);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//if (mProfilesDB != null)
				//mProfilesDB.abort();
		}
		
	}
	
	public static void main(String[] args) {
		new StereotypingAlgorithmTest();
	}
}
