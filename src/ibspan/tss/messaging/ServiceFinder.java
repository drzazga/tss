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
package ibspan.tss.messaging;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.proto.SubscriptionInitiator;
import jade.util.Logger;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

/**
 * This class provides the agent with finding service providers registered in
 * Directory Facilitator. It:
 * <ol>
 * <li> searches for already registered service providers and
 * <li> subscribes for the providers which will register in the future.
 * </ol>
 * Any time the service appears in the system the agent is woken up.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class ServiceFinder {

	private static Logger logger = Logger.getMyLogger(ServiceFinder.class.getName());
	
	// The aghent this ServiceFinder belongs to
    private Agent myAgent;
    // Contains keys generated from DFAgentDescriptions by #createKey() method.
	private Map<Object, DFAgentDescription> agents;
	// Description of service this finder is looking dfor
	private ServiceDescription myService;

	/**
	 * Constructs <code>ServiceFinder</code> to search and subscribe for the
	 * given service
	 * 
	 * @param a
	 *            is owning agent
	 * @param myService
	 *            is description of service this finder will look for.
	 * @throws ServiceFinderException
	 *             throw when the finder have problems with finding the service.
	 */
	public ServiceFinder(Agent a, ServiceDescription sd) throws ServiceFinderException {
		this.myAgent = a;
		this.myService = sd;

		agents = new Hashtable<Object,DFAgentDescription>();

		DFAgentDescription template = createServiceTemplate(sd);

		// search service
		try {

			SearchConstraints sc = null;
			DFAgentDescription[] dfds = DFService.search(myAgent, template, sc);
			processResults(dfds);
		} catch (FIPAException e) {
			throw new ServiceFinderException("Problem during searching service.: ", e);
		}

		// subscribe for it
		Behaviour b = new SubscriptionInitiator(myAgent, DFService.createSubscriptionMessage(
				myAgent, myAgent.getDefaultDF(), template, null)) {
			protected void handleInform(ACLMessage inform) {
				try {
					DFAgentDescription[] dfds = DFService.decodeNotification(inform.getContent());
					processResults(dfds);
				} catch (FIPAException e) {
					// We handle with this exception at this level, since it's one of  
					// agent's behaviours
					logger.log(Level.SEVERE,"Problem with receiving subscription ", e);
				}
			}
		};
		myAgent.addBehaviour(b);
	}

	/**
	 * Returns agent providing the service. In current implementation returns
	 * first agent from list.
	 * 
	 * @return agent providing the service or <code>null</code> if no service
	 *         has been found.
	 */
	public AID getOne() {
		// TODO: In the future some technique of load-balancing could be here.
		Iterator it = agents.values().iterator();
		if (it.hasNext())
			return ((DFAgentDescription)it.next()).getName();
		else
			return null;
	}

	/**
	 * Returns agent providing the service matching the given <code>key</code>.
	 * 
	 * The for service description is created by <code>createKey()</code> method.
	 * 
	 * @param key is key describing particular agent(s).
	 * @return agent identifier
	 * @see #createKey(DFAgentDescription)
	 */
	public AID getOne(Object key) {
		DFAgentDescription a = (DFAgentDescription) agents.get(key);
		return a == null ? null : a.getName();
	}

	// Handles with situation when new agent of subscribed service appears in the system
	private void handleNewService(Object key, DFAgentDescription dfd) {
		// Remember this service
		agents.put(key, dfd);
		// Notify blocked behaviours waiting for this service
		myAgent.doWake();
		logger.fine(myAgent.getLocalName() + " knows about " + agents.size() + " services of <" + myService.getType() + ">.");
	}
	
	/**
	 * Creates the key, which will be used for selecting particular agent(s)
	 * from list of agent providing the service, e.g. personal agent
	 * representing user with particular userID.
	 * 
	 * @param dfd
	 *            agent description
	 * @return the key for the given agent description
	 */
	protected Object createKey(DFAgentDescription dfd) {
		return dfd.getName();
	}

	private DFAgentDescription createServiceTemplate(ServiceDescription sd) {
		DFAgentDescription template = new DFAgentDescription();
		template.addServices(sd);
		return template;
	}

	private void processResults(DFAgentDescription[] dfds) {
		Object key;
		// TODO: handle with deregistration messages
		for (int i = 0; i < dfds.length; i++) {
			DFAgentDescription dfd = dfds[i];
			Iterator it = dfd.getAllServices();
			while (it.hasNext()) {
				ServiceDescription sd = (ServiceDescription) it.next();
				if (sd.getType().equals(myService.getType())) {
					if ((key = createKey(dfd)) != null)
						handleNewService(key, dfd);
				}
			}
		}
	}

}