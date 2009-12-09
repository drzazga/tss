/*****************************************************************
 Agent-based Travel Support System
 Copyright (C) 2006 Maciej Gawinecki & Pawel Kaczmarek 

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor,  Boston, MA  
 02110-1301, USA.
 *****************************************************************/
package ibspan.tss.um.stereotyping;

import ibspan.tss.um.ontology.Age;
import ibspan.tss.um.ontology.Dress;
import ibspan.tss.um.ontology.Measure;
import ibspan.tss.um.ontology.MeasureSet;
import ibspan.tss.um.ontology.Opinion;
import ibspan.tss.um.ontology.OpinionSet;
import ibspan.tss.um.ontology.Profession;
import ibspan.tss.um.ontology.StereotypeProfile;
import ibspan.tss.um.ontology.StereotypeProfileData;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.ontology.UserProfileData;
import ibspan.tss.um.ontology.Wealth;
import jade.util.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.ibm.adtech.jastor.JastorException;

/**
 * The realizes Stereotyping Algorithm, matching a user to one of known
 * stereotypes. More precisely, a It measures a distance between user-specified
 * characteristics and these appearing in stereotypes to find the best matching
 * stereotype. Then opinions states in the selected stereotype are copied to the
 * user profile. More details about the algorithm can be found in [1,2,3].
 * 
 * <p>
 * Defaults importance weights for each measure in demographic data are given.
 * 
 * <ol>
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/PIPS_2005_MMP.pdf">"Ontology-based
 * Stereotyping in a Travel Support System."</a> Maciej Gawinecki, Mateusz
 * Kruszyk, and Marcin Paprzycki. In Proceedings of the XXI Fall Meeting of
 * Polish Information Processing Society. 2005.
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/Gawinecki_MS_2005.pdf">"Modelling
 * User on the Basis of Interactions with a WWW Based System"</a>, Maciej
 * Gawinecki, Adam Mickiewicz University, Poznan. 2005.
 * <li><a
 * href="http://agentlab.swps.edu.pl/agent_papers/IDEA_2006.pdf">"Utilizing
 * Semantic Web and Software Agents in a Travel Support System"</a>. In
 * "Semantic Web Technologies and eBusiness: Virtual Organization and Business
 * Process Automation." Maria Ganzha, Maciej Gawinecki, Marcin Paprzycki, Rafa?
 * G?siorowski, Szymon Pisarek, and Wawrzyniec Hyska. Editted by A. F. Salam and
 * Jason Stevens. Idea Publishing Group. 2006.
 * </ol>
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class StereotypingAlgorithm {

	private static Logger logger = Logger.getMyLogger(StereotypingAlgorithm.class.getName());
	
	/**
	 * Importance weight of age measure.
	 * 
	 * @see Age
	 */
	public static final double AGE_IMPORTANCE_WEIGHT = 2.0;
	/**
	 * Importance weight of wealth measure.
	 * 
	 * @see Wealth
	 */
	public static final double WEALTH_IMPORTANCE_WEIGHT = 4.0;
	/**
	 * Importance weight of dress measure.
	 * 
	 * @see Dress
	 */
	public static final double DRESS_IMPORTANCE_WEIGHT = 1.0;
	/**
	 * Importance weight of profession measure.
	 * 
	 * @see Profession
	 */
	public static final double PROFESSION_IMPORTANCE_WEIGHT = 2.0;
	
	// Stands for value of probability for any variable, the has not been computed yet.
    public static final double UNKNOWN_PROBABILITY = 2.0;

    // Modle with stereotypes.
    private OntModel           mStereotypesDB;
    // Model with profiles.
    private OntModel           mProfilesDB;
    // Maps URI of Measure to the weight describing its importants in learning
	// process.
    private Map<String,Double> weights;
    // Calculator to compute distance between different measures.
    private MeasureCalculator  calc;

    /**
     * Returns defaults weights for user data attributes.
     * 
     * @return these weights
     */
    private Map getDefaultWeights() {
        Map weights = new HashMap();
        weights.put( Age.TYPE.getURI(), AGE_IMPORTANCE_WEIGHT );
        weights.put( Wealth.TYPE.getURI(), WEALTH_IMPORTANCE_WEIGHT );
        weights.put( Dress.TYPE.getURI(), DRESS_IMPORTANCE_WEIGHT );
        weights.put( Profession.TYPE.getURI(), PROFESSION_IMPORTANCE_WEIGHT );
        return weights;
    }

    /**
     * @param mStereotypesDB
     * @param mProfilesDB
     * @param weights
     */
    public StereotypingAlgorithm(OntModel mUM, OntModel mStereotypesDB, OntModel mProfilesDB, Map weights) {
        this.mStereotypesDB = mStereotypesDB;
        this.mProfilesDB = mProfilesDB;

        this.weights = weights;
        if (this.weights == null)
            this.weights = getDefaultWeights();

        calc = new MeasureCalculator( mUM );
    }

    /**
	 * Initialize the given user profile by use of this stereotyping algorithm.
	 * 
	 * @param u
	 *            to be profile which is to be initialized; must contain
	 *            pre-defined UserProfileData, which will be use as a base for
	 *            the choice of the closest stereotype.
	 */
    public void initializeUserProfile(UserProfile u) {

    	long start = System.currentTimeMillis();
    	
    	List<StereotypeProfile> stereotypes = null;
    	try {
			stereotypes = UserModellingFactory.getAllStereotypeProfile( mStereotypesDB );
			
			// find the most similar stereotype
            double maxSimilarity = 0;
            StereotypeProfile best = null;
            for (Iterator it = stereotypes.iterator(); it.hasNext();) {
                StereotypeProfile s = (StereotypeProfile) it.next();
                double similarity = getSimilarity( s.getHasStereotypeData(), u.getHasUserProfileData() );
                if (best == null || similarity > maxSimilarity) {
                    best = s;
                    maxSimilarity = similarity;
                }
            }

            // Clone opinions.
            // Opinions must be cloned to avoid updating steretype's opinion
            // during profile learning.
            logger.info("Assigned stereotype number : " + best.getHasStereotypeID());
            u.setHasOpinions( cloneOpinions( best.getHasOpinions(), mProfilesDB ) );
            
    		long duration = System.currentTimeMillis() - start; 
    		logger.finer("Profile initialized in " + duration + " milliseconds.");
            
		} catch (JastorException e) {
			new RuntimeException(e);
		}
    }

    // Clone opinions, since we cannot use the same resources of stereotype
    private OpinionSet cloneOpinions(OpinionSet oldSet, OntModel targetModel) {
    	// TODO Change second argument to OpinionSet
    	
    	OpinionSet newSet = null;
        try {
			newSet = UserModellingFactory.createOpinionSet( mProfilesDB.createResource(), targetModel );
			for (Iterator it = oldSet.getContainsOpinion(); it.hasNext();) {
			    Opinion oldOpinion = (Opinion) it.next();
			    Opinion newOpinion = newSet.addContainsOpinion();
			    newOpinion.setHasClassification(oldOpinion.getHasClassification());
			    newOpinion.setAtIndividualProbability( oldOpinion.getAtIndividualProbability() );
			    newOpinion.setAtInferredProbability( new Double( UNKNOWN_PROBABILITY ) );
			    newOpinion.setAtNormalizedProbability( new Double( 0.0 ) );
			    newOpinion.setIsAbout( oldOpinion.getIsAbout() );
			}
		} catch (JastorException e) {
			logger.log(Level.SEVERE,"Cannot access user profile data.", e);
		}
		return newSet;
    }

    // Returns measure of similarity between data of user profile and stereotype
    private double getSimilarity(StereotypeProfileData sdata, UserProfileData udata) {
        return 1.0 - getDistance( sdata, udata );
    }

    // Returns distance between data of stereotype and user profile
    private double getDistance(StereotypeProfileData sdata, UserProfileData udata) {
    	double dist = 0;
        try {
			double sum1 = 0, sum2 = 0;

			sum1 += getWeightedDistance( sdata.getHasAgeSet(), udata.getHasAge() );
			sum2 += getMeasureWeight( udata.getHasAge() );
			sum1 += getWeightedDistance( sdata.getHasDressSet(), udata.getHasDress() );
			sum2 += getMeasureWeight( udata.getHasDress() );
			sum1 += getWeightedDistance( sdata.getHasProfessionSet(), udata.getHasProfession() );
			sum2 += getMeasureWeight( udata.getHasProfession() );
			sum1 += getWeightedDistance( sdata.getHasWealthSet(), udata.getHasWealth() );
			sum2 += getMeasureWeight( udata.getHasWealth() );

			dist = (sum2 == 0 ? 0 : (sum1 / sum2));
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access stereotype of profile data ", e);
		} catch (UnknownMeasureTypeException e) {
			throw new RuntimeException(e);
		}
		return dist;
    }

    // Returns the weight of importance of the given measure assinged by this algortithm.
    private double getMeasureWeight(Measure m) {        
        return ((Double) weights.get( ibspan.tss.core.semantic.Util.getClosestRDFType( m ) )).doubleValue();
    }

    // Returns distance between given measure and set of measure, including weight of importance.
    // Measure and set of measure must be of the same measure type
    private double getWeightedDistance(MeasureSet mset, Measure m) throws UnknownMeasureTypeException {
    	double dist = 0;
		if (getDelta(mset, m))
			dist = calc.getDistance(m, mset) * getMeasureWeight(m);
		
		return dist;
	}

    // Returns false if distance for the given arguments does not have to be measured. 
    private boolean getDelta(MeasureSet mset, Measure m) throws UnknownMeasureTypeException {
		return (mset != null && m != null && !calc.isSetEmpty(mset));
	}

}
