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
package ibspan.tss.agents.rsa;

import ibspan.tss.agents.SystemAgent;
import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.core.storage.ModelLoaderInitException;
import ibspan.tss.domain.vocabulary.RestaurantVocabulary;
import ibspan.tss.domain.vocabulary.RestaurantsDBVocabulary;
import ibspan.tss.messaging.ontology.MessagingOntology;
import jade.content.lang.sl.SLCodec;
import jade.core.behaviours.DataStore;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.Properties;
import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * 
 * @author maciej
 */
public final class RestaurantServiceAgent extends SystemAgent {

	private static Logger logger = Logger.getMyLogger(RestaurantServiceAgent.class.getName());
	
	public final static String SERVICE_NAME = "Restaurant Service";
	public final static String SERVICE_TYPE = "restaurant-service";
	public final static String SERVICE_OWNERSHIP = "Travel Support System";

	private OntModel mDomain;
    private OntModel mRestaurantDB;

	//*****************************************
	// Provides models for behaviours
	//*****************************************    
	/**
	 * Returns ontology model describing domain of restaurant world.
	 * @return
	 */
	public OntModel getDomainModel()				{ return mDomain; }
	/**
	 * Returns database with instances of restaurants.
	 * @return
	 */
	public OntModel getRestaurantsDB()				{ return mRestaurantDB; }

	/**
	 * Constructs RestaurantServiceAgent.
	 */
	public RestaurantServiceAgent() {
		super();	
		
		//**************************************
		// Read necessary ontology models.
		//**************************************
		try{
			logger.info("Loading restaurant ontology ... ");
			mDomain = ModelLoader.loadModel(RestaurantVocabulary.NS);
			logger.info("Done.");
			
			logger.info("Loading restaurants db from DB ...");
			mRestaurantDB = ModelLoader.loadDBModel(RestaurantsDBVocabulary.NS);
			logger.info("Done.");
		} catch (ModelLoaderInitException e) {
			logger.log(Level.SEVERE,"Problem while initializing ModelLoader.", e);
			doDelete();			
		}
	}
	
	protected void activateProperties(Properties conf) {		
	}	

	protected void setup() {
		getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
		getContentManager().registerOntology(MessagingOntology.getInstance());

		// Initialize responding functionality.
		MessageTemplate mt = MessageTemplate.and(MessageTemplate
				.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST), MessageTemplate
				.MatchOntology(MessagingOntology.ONTOLOGY_NAME));
		addBehaviour(new RSAResponder(this, mt));

		// Register in DF>
		try {
			ServiceDescription sd = getServiceDescription();			
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());
			dfd.addServices(sd);
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			logger.log(Level.SEVERE, "Cannot register agent at DF: ", e);
			doDelete();
		}
	}

	/**
	 * Returns information about the service this agent provides
	 * 
	 * @return service description
	 */
	public static ServiceDescription getServiceDescription() {
		ServiceDescription sd = new ServiceDescription();
		sd.setType(SERVICE_TYPE);
		sd.setName(SERVICE_NAME);
		sd.setOwnership(SERVICE_OWNERSHIP);
		return sd;
	}


}
