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
package ibspan.tss.agents.pra;

import ibspan.tss.agents.SystemAgent;
import ibspan.tss.agents.pra.initiators.ProcessUserRequestInitiator;
import ibspan.tss.agents.pra.server.MainServer;
import ibspan.tss.agents.sha.SessionHandlingAgent;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceFinderException;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ServiceWaiter;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.SHA_process_user_request;
import ibspan.tss.messaging.ontology.UserRequest;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.AID;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.util.Properties;
import java.util.logging.Level;

/**
 * ProxyAgent - this agent is intermediary between system and non-agent client
 * software like HTTP/HTML or HTTP/WML browsers. Each user request send over
 * HTTP protocol is translated into ACLMessage and forwarded to
 * <code>SesssionHandlingAgent</code>. Responses of the system are returned
 * back to the user on the same HTTP connection. See [1] for more details.
 * 
 * <p>
 * The agent must provided with ports of WML and HTML servers given in
 * properties file (with filename passed as an argument when creating this
 * agent). It also requires <code>SessionHandlingAgent</code> registered in
 * <i>Directory Facilitator</i> to start working.
 * 
 * <ol>
 * <li>Pawel Kaczmarek "Multimodal Communication Between Users and Software
 * Agents", 2005. Master Thesis, Adam Mickiewicz University, Poznan. Poland.
 * </ol>
 * 
 * @author Pawel Kaczmarek
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class ProxyAgent extends SystemAgent {
	// Responses are stored in local DataStore, pointed by jobID
	
	private static Logger logger = Logger.getMyLogger(ProxyAgent.class.getName());

	// Keys for configuration properties file.
	public final static String HTML_MAINSERVER_PORT_KEY = "HTMLmainServerPort";
	public final static String WML_MAINSERVER_PORT_KEY = "WMLmainServerPort";

	private MainServer HTMLMainServer;
	private MainServer WMLMainServer;

	// Listening port for HTML server
	private int conf_HTML_PORT;
	// Listening port for WML server
	private int conf_WML_PORT;

	// list of known SHA agents
	private ServiceFinder sessionHandlers;

	private DataStore ds = new DataStore();
	
	public ProxyAgent() {
		super();
	}

	protected void activateProperties(Properties conf) {
		conf_HTML_PORT = Integer.parseInt(conf.getProperty(HTML_MAINSERVER_PORT_KEY));
		conf_WML_PORT = Integer.parseInt(conf.getProperty(WML_MAINSERVER_PORT_KEY));
	}

	protected void setup() {
		super.setup();	
		
		getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);
		getContentManager().registerOntology(MessagingOntology.getInstance());

		try {
			sessionHandlers = new ServiceFinder( this, SessionHandlingAgent.getServiceDescription());
		} catch (ServiceFinderException e) {
			logger.log(Level.SEVERE,"Problem while creating service finder: ", e);
			doDelete();
			return;
		}
		
		addBehaviour(new SequentialBehaviour(this) {

			public void onStart() {				
				// Add behaviour waiting for registration of services the agent depends on
				addSubBehaviour(new ServiceWaiter(myAgent, sessionHandlers));
				
				// Start servers in pararell threads
				addSubBehaviour(new OneShotBehaviour(myAgent) {
					public void action() {
						HTMLMainServer = new MainServer(new CommandListener(), conf_HTML_PORT, MainServer.HTML_SERVER);
						WMLMainServer = new MainServer(new CommandListener(), conf_WML_PORT, MainServer.WML_SERVER);
						Thread htmlThread = new Thread(HTMLMainServer);
						Thread wmlThread = new Thread(WMLMainServer);
						htmlThread.start();
						wmlThread.start();	
					}
				});
			}
		});
	}

	/**
	 * Inner class of the PrA that is passed to the server threads. Class
	 * exposes means of passing ExternalRequest and retrieving ExternalResponse.
	 */
	private class CommandListener implements SynchronousController {

		public DataView process(UserRequest request) throws SystemResponseException {
			return getResponse(request);
		}
	}

	/**
	 * It uses data from ExternalRequest instance input parameter to create
	 * proper being of SystemOntology; send the request; retrieve response;
	 * return response;
	 * 
	 * @param request -
	 *            request from outside of the agent world.
	 * @return response of the system
	 * @throws SystemResponseException 
	 */
	protected DataView getResponse(UserRequest request) throws SystemResponseException {

		try {

			ACLMessage internalRequest = new ACLMessage(ACLMessage.REQUEST);
			internalRequest.setOntology(MessagingOntology.getInstance()
					.getName());
			internalRequest.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
			internalRequest
					.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

			AID sha = sessionHandlers.getOne();
			if (sha == null) 
				throw new ServiceNotFoundException("Cannot find SHA.");

			internalRequest.addReceiver(sha);

			SHA_process_user_request action = new SHA_process_user_request();
			action.setUserRequest(request);

			Action act = new Action();
			act.setActor(getAID());
			act.setAction(action);

			getContentManager().fillContent(internalRequest, act);
			
			String jobID = getUniqueJobID();
			addBehaviour(new ProcessUserRequestInitiator(this, internalRequest, ds, jobID));

			return receiveResponse(jobID);
		} catch (CodecException e) {
			logger.log(Level.SEVERE, "Cannot prepare internal request: ", e);
			throw new SystemResponseException("error", e);
		} catch (OntologyException e) {
			logger.log(Level.SEVERE, "Cannot prepare internal request: ", e);
			throw new SystemResponseException("error", e);
		} catch (ServiceNotFoundException e) {
			logger.log(Level.SEVERE, "No service", e);
			throw new SystemResponseException("error", e);
		}

		

	}

	/**
	 * Retrives PrASystemInit instance from responseMessageMap(member) based
	 * on PrASystemInit instance JobID as a key.
	 * 
	 * @param requestHandler
	 * @return
	 * @throws SystemResponseException
	 */
	protected DataView receiveResponse(String jobID) throws SystemResponseException {
		ACLMessage internalResponse;

		// wait as there appear response in DataStore
		logger.info("Waiting for response");
		synchronized (ds) {
			while (!ds.containsKey(jobID)) {
				try {
					ds.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			internalResponse = (ACLMessage) ds.remove(jobID);
			
			ds.notifyAll();
		}

		logger.info("Response received. ");
		
		DataView response = null;
		try {
			switch (internalResponse.getPerformative()) {
			case ACLMessage.INFORM: {
				Result result = (Result) getContentManager().extractContent(internalResponse);
				response = (DataView) result.getValue();
				break;
			}
			case ACLMessage.FAILURE: {
				Result result = (Result) getContentManager().extractContent(internalResponse);
				InternalSystemError error = (InternalSystemError) result.getValue();
				throw new SystemResponseException(error.getMessage());
			}
			}

			return response;

		} catch (UngroundedException e) {
			logger.log(Level.SEVERE, "Error while processing system response: ", e);
			throw new SystemResponseException("Error", e);
		} catch (CodecException e) {
			logger.log(Level.SEVERE, "Error while processing system response: ", e);
			throw new SystemResponseException("Error", e);
		} catch (OntologyException e) {
			logger.log(Level.SEVERE, "Error while processing system response: ", e);
			throw new SystemResponseException("Error", e);
		} 

	}

	private String getUniqueJobID() {
		return "__job" + new Object().hashCode();
	}


}