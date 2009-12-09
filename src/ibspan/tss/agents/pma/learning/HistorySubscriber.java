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
package ibspan.tss.agents.pma.learning;

import ibspan.tss.agents.pma.ProfileManagingAgent;
import ibspan.tss.agents.sha.SessionHandlingAgent;
import ibspan.tss.messaging.ServiceFinder;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.OWLData;
import jade.content.abs.AbsConcept;
import jade.content.abs.AbsContentElement;
import jade.content.abs.AbsIRE;
import jade.content.abs.AbsPredicate;
import jade.content.abs.AbsVariable;
import jade.content.lang.sl.SLVocabulary;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.SubscriptionInitiator;
import jade.util.Logger;

import java.util.Vector;
import java.util.logging.Level;

/**
 * This is simple behaviour resonsible subscribing for new events at
 * <code>SessionHandlingAgent</code> and receiving notification about them.
 * All notifications are put into <code>SynchronizedStore</code> object passed
 * as an argument in constructor.
 * 
 * <p>
 * Size of a single pack of events this behaviour subscribes for is defined in
 * {@link ProfileManagingAgent#conf_NUMBER_OF_EVENTS_IN_PACK} constant.
 * 
 * <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see SessionHandlingAgent
 * @see SynchronizedStore
 */
public class HistorySubscriber extends SubscriptionInitiator {

	private static Logger logger = Logger.getMyLogger(HistorySubscriber.class.getName());
	
	// The agent this behaviour belongs to.
	private ProfileManagingAgent myAgent;
	// Session handling service.
	private ServiceFinder sessionHandlers;
	// Store for passing received packs of events to ContinousLearning behaviour.
	private SynchronizedStore store;
	
	/**
	 * Constructs <code>HistorySubscriber</code> objects.
	 * 
	 * @param a
	 *            is the agent this behaviour belongs to.
	 * @param store
	 *            is store for passing received packs of events to any waiting
	 *            for them, e.g. to <code>ContinousLearning</code> behaviour.
	 * 
	 * @see ContinuousLearning
	 */
	public HistorySubscriber(Agent a, SynchronizedStore store) {
		super(a, null);
		myAgent = (ProfileManagingAgent) a;
		this.store = store;
		sessionHandlers = myAgent.getSessionHandlers();
	}

	
	@Override
	protected void handleInform(ACLMessage inform) {
		Ontology onto = MessagingOntology.getInstance();
		try {
			AbsContentElement ce = myAgent.getContentManager().extractAbsContent(inform);
			if (ce.getTypeName().equals(SLVocabulary.EQUALS)) {
				// This is answer to our subscription with Iota term
				AbsConcept absP = (AbsConcept) ce.getAbsObject(SLVocabulary.EQUALS_RIGHT);
				OWLData owldata = (OWLData) onto.toObject(absP);
				store.push(owldata);
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	@Override
	protected void handleRefuse(ACLMessage refuse) {
		logger.log(Level.SEVERE, "Responder refused to prepare subscriptions.");
		myAgent.doDelete();
	}
	
	// TODO: Failure does not not necessarily means, that PMA agent have to day. It can still works on.
	protected void handleFailure(ACLMessage failure) {
		logger.log(Level.SEVERE, "Responder failed to prepare subscriptions.");
		myAgent.doDelete();
	}

	@Override
	protected Vector prepareSubscriptions(ACLMessage subscription) {
		Vector subscriptions = null;
		try {
			AID sha = sessionHandlers.getOne(); 

			if (sha != null) {
				AbsVariable events = new AbsVariable("events", MessagingOntology.OWLDATA);
				AbsPredicate absHaveNewEvents = new AbsPredicate(MessagingOntology.HAVENEWEVENTS);
				absHaveNewEvents.set(MessagingOntology.HAVENEWEVENTS_PACKSIZE, ProfileManagingAgent.conf_NUMBER_OF_EVENTS_IN_PACK);
				absHaveNewEvents.set(MessagingOntology.HAVENEWEVENTS_EVENTS, events);
				AbsIRE absIota = new AbsIRE(SLVocabulary.IOTA);
				absIota.setVariable(events);
				absIota.setProposition(absHaveNewEvents);
				
				subscription = new ACLMessage(ACLMessage.SUBSCRIBE);
				subscription.addReceiver(sha);
				subscription.setOntology(MessagingOntology.ONTOLOGY_NAME);
				subscription.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
				subscription.setProtocol(FIPANames.InteractionProtocol.FIPA_SUBSCRIBE);
				myAgent.getContentManager().fillContent(subscription, absIota);

				
				subscriptions = new Vector();
				subscriptions.addElement(subscription);
			} else {
				throw new ServiceNotFoundException("Service Handler not found in DF.");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Cannot prepare request to : ", e);
		} 				
		return subscriptions;
	}

	
	
}
