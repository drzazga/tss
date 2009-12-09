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
package ibspan.tss.agents.vta;

import ibspan.tss.agents.SystemAgent;
import ibspan.tss.agents.vta.handlers.ViewTransformer;
import ibspan.tss.messaging.ontology.MessagingOntology;
import jade.content.lang.sl.SLCodec;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.MessageTemplate;
import jade.util.Logger;

import java.util.Properties;
import java.util.logging.Level;

/**
 * This is class of <code>ViewTransformingAgent</code> formatting pure data
 * into browser-readable form by use of <code>ViewTransformer</code>
 * behaviour. It requires passing reference to properties files describing
 * access to Raccoon server.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ViewTransformer
 * @see #RACCOON_DIR_KEY
 * @see #RACCOON_URL_KEY
 */
public final class ViewTransformingAgent extends SystemAgent {

	private static Logger logger = Logger.getMyLogger(ViewTransformingAgent.class.getName());
	
	/**
	 * Configuration key for Raccoon URL provided in properties file.
	 */
	//public final static String RACCOON_URL_KEY = "RaccoonURL";
	/**
	 * Configuration key for Raccoon storage directory provided in properties
	 * file.
	 */
	//public final static String RACCOON_DIR_KEY = "RaccoonDir";
	
	// Description of the service this agent provides
	public final static String SERVICE_NAME = "View Transforming";
	public final static String SERVICE_TYPE = "view-transforming";
	public final static String SERVICE_OWNERSHIP = "Travel Support System";
	
	// URL address at which Raccoon server provides its functionality.
	//private String conf_RACCOON_URL;
	// Directory, where Raccoon server stores processed models.
	//private String conf_RACCOON_DIR;
	
	/**
	 * Returns URL at which Raccoon server is accessible.
	 * 
	 * @return URL of Raccoon server.
	 */
	//public String getConf_RACCOON_URL()			{ return conf_RACCOON_URL; }
	/**
	 * Returns directory in which Raccoon server stores ontology models.
	 * 
	 * @return storage directory of Raccoon server.
	 */
	//public String getConf_RACCOON_DIR()			{ return conf_RACCOON_DIR; }

	/**
	 * Constructors View Transforming Agent.
	 */
	public ViewTransformingAgent() {
		super();		
	}

	@Override
	protected void activateProperties(Properties conf) {
		//conf_RACCOON_URL = conf.getProperty(RACCOON_URL_KEY);		
		//conf_RACCOON_DIR = conf.getProperty(RACCOON_DIR_KEY);
		
		//logger.info("VTA will request Raccoon at URL: " + conf_RACCOON_URL);
		//logger.info("VTA will communicate with Raccoon via DIR: " + conf_RACCOON_DIR);		
	}	

	protected void setup() {
		super.setup();
		
		getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
		getContentManager().registerOntology(MessagingOntology.getInstance());
	
		// Provide responding functionality
		MessageTemplate mt = MessageTemplate.and(MessageTemplate
				.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST), MessageTemplate
				.MatchOntology(MessagingOntology.ONTOLOGY_NAME));		
		addBehaviour(new VTAResponder(this, mt));

		// TODO: This agent should check availability of Raccoon service before it registers in DF
		
		// Register at DF
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
	 * Returns information about the service this agent provides.
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
