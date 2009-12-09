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
package ibspan.tss.agents.sha.history;

import ibspan.tss.agents.sha.SessionHandlingAgent;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.dao.HistoryDAO;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.um.ontology.Event;
import jade.content.ContentManager;
import jade.content.abs.AbsConcept;
import jade.content.abs.AbsIRE;
import jade.content.abs.AbsPredicate;
import jade.content.lang.sl.SLVocabulary;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.proto.SubscriptionResponder.Subscription;
import jade.proto.SubscriptionResponder.SubscriptionManager;
import jade.util.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * This class deals with the registration/deregistration of subscriptions for
 * packs of events, delegated to it by <code>SubscriptionManager</code> object
 * and creates notifications containing information about new events., when
 * required by <code>HistoryLogger</code>. This functionality result from the
 * interface this class implements.
 * 
 * <p>
 * The class uses internal not-persistent knowledge-base for storing constraints
 * of registered subscription and every time this contraints of particular
 * subscription are fulfilled (number of new events is equal for which the
 * subscriber subscribed), then sends notification message to the appriopriate
 * subscriber.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see SubscriptionManager
 * @see HistoryLogger
 */
public class HistorySubscriptionManager implements SubscriptionManager, NewEventHandler {

	private static Logger logger = Logger.getMyLogger(HistorySubscriptionManager.class.getName());
	
	// DAO to model with History
	private HistoryDAO daoHistory;
	// Knowledge base about registered subscribers
	private SubKB kb = new SubKB();
	// Content Manager
	private ContentManager cm;
	// The agent this manager belongs to
	private SessionHandlingAgent myAgent;
	// Factory for running event searching behaviour in a seperate thread
	private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
	
	/**
	 * Constructs <code>HistorySubscriptionManger belongs to</code>.
	 * 
	 * @param a
	 *            is the agent this
	 *            <code>HistorySubscriptionManger belongs to</code>.
	 * @param daoHistory
	 *            DAO object of <i>History</i> model, which will be used to
	 *            extract information about events, the subscriber is willing to
	 *            be informed about.
	 */
	public HistorySubscriptionManager(Agent a, HistoryDAO daoHistory) {
		this.daoHistory = daoHistory;
		myAgent = (SessionHandlingAgent) a;
	}
	
	/**
	 * Set the content manager for this component.
	 * 
	 * @param cm
	 *            is a content manager.
	 */
	public void setContentManager(ContentManager cm) {
		this.cm = cm;
	}

	/**
	 * Deregister a Subscription object from the knowledge-base..
	 * 
	 * @param s
	 *            The Subscription object to be registered
	 * 
	 * @return The boolean value returned by this method provides an indication
	 *         to the <code>SubscriptionResponder</code> about whether or not
	 *         an INFORM message should be sent back to the initiator. The
	 *         default implementation of the <code>handleCancel()</code>
	 *         method of the <code>SubscriptionResponder</code> ignores this
	 *         indication, but programmers can override it.
	 */
	public boolean deregister(Subscription sub) throws FailureException {
		SubscriptionConstraints sc = kb.unsubscribe(sub);
		if (sc != null) 
			return false;
		else
			throw new FailureException("no such subscription");
	}

	/**
	 * Register a new Subscription object in the knowledge-base.
	 * 
	 * @param s
	 *            The Subscription object to be registered
	 * @return The boolean value returned by this method provides an indication
	 *         to the <code>SubscriptionResponder</code> about whether or not
	 *         an AGREE message should be sent back to the initiator. The
	 *         default implementation of the <code>prepareResponse</code>
	 *         method of the <code>SubscriptionResponder</code> ignores this
	 *         indication, but programmers can override it.
	 */
	public boolean register(Subscription sub) throws RefuseException,
			NotUnderstoodException {
		
		SubscriptionConstraints sc = null;
			
		try {
			ACLMessage subMessage = sub.getMessage();			
			AbsIRE absIota = (AbsIRE) cm.extractAbsContent(subMessage);
			AbsPredicate absHaveNewEvents = absIota.getProposition();
			int packSize = (Integer) absHaveNewEvents.getInteger(MessagingOntology.HAVENEWEVENTS_PACKSIZE);
			sc = new SubscriptionConstraints(packSize);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Cannot understand subscription message " + sub.getMessage(), e);
			throw new NotUnderstoodException(e.getMessage());
		}

		kb.subscribe(sub, sc);
		
		logger.fine("I have subscribed agent: " + sub.getMessage().getSender().getLocalName() + " for " + sc.packSize + "-sized packs of events");
		return false;
	}

	/**
	 * Notifies subscriber every time number events, together with the passed as
	 * argument, is equal to the number contrained by the subscriber in
	 * registration message.
	 * 
	 * @param e
	 *            is the event to be handled.
	 */
	public void handleNewEvent(Event e) {
		try {
			final Iterator<Subscription> it = kb.getSubcriptions();
			while( it.hasNext() ) {
				final Subscription sub = it.next();
				final SubscriptionConstraints sc = kb.getSubscription(sub);
				if (sc.updateCounter()) {
					// This subscriber must be notified!
					
					// Register behaviour, handling with notifing subscriber, in
					// a seperate thread, because extraction of history
					// information could be time-consuming.
					myAgent.addBehaviour(tbf.wrap(new OneShotBehaviour(myAgent) {
						
						public void action() {
							// FIXME: We assume that no events arrived in a meantime, 
							// so we can find all events since the given date. This could 
							// provide subscriber with not complete data
							List<Event> events = daoHistory.getEvents(sc.resetCounter());
							Memory mem = new Memory();
							for(Iterator<Event> it2 = events.iterator(); it2.hasNext();) {
								Event e = it2.next();
								mem.add(e);
							}
							notify(sub, mem);
						}
						
						// Informs subscripber of the given subscription about given events.
						private void notify(Subscription sub, Memory events) {
							ACLMessage notification = null;
							try {
								Ontology onto = MessagingOntology.getInstance();
								AbsIRE absIota = (AbsIRE) cm.extractAbsContent(sub.getMessage());
								AbsPredicate absEquals = new AbsPredicate(SLVocabulary.EQUALS);
								
								AbsConcept absEvents = (AbsConcept) onto.fromObject(events.buildOWLData());
								absEquals.set(SLVocabulary.EQUALS_LEFT, absIota);
								absEquals.set(SLVocabulary.EQUALS_RIGHT, absEvents);
							
								notification = sub.getMessage().createReply();
								notification.setPerformative(ACLMessage.INFORM);
								cm.fillContent(notification, absEquals);
								
								sub.notify(notification);
							} catch (Exception ex) {
								throw new RuntimeException(ex);
							}
						}
					}));
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}


	// Describes countraints of subscription of the subscriber. Contains
	// internal counter for counting every new event.
	private class SubscriptionConstraints {
		// Counts number of new events.
		private int eventCounter;
		// Number of events the subscriber is willing to be informed about in a
		// single message.
		private int packSize;
		// The time since which counting events has been started.
		private Date since;
		
		private void reset() {
			since = new Date();
			eventCounter = 0;
		}
		
		/**
		 * Constructs <code>SubscriptionContraints</code>. All new events
		 * will be counted exactly from now.
		 * 
		 * @param packSize
		 *            number of new events in a single notifing message the
		 *            subscriber is willing to be notified about.
		 */
		public SubscriptionConstraints(int packSize) {
			this.packSize = packSize;
			reset();
		}
		
		/**
		 * Returns the number of events the subscriber registered for.
		 * @return number of events.
		 */
		public int getPackSize() 	{ return packSize; 	}
		
		/**
		 * Reset event counter of this <code>Subscriptionconstraints</code>
		 * object, so all new events handled from now will be counted from zero.
		 * 
		 * @return the moment in past, since which all event events were counted
		 *         before resetting.
		 */
		public Date resetCounter() { 
			Date oldSince = since;
			reset();
			return oldSince; 
		}
		
		/**
		 * Updates internal event counter, when new event comes.
		 * 
		 * @return <code>true</code> if subscription contrainsts are fulfilled
		 *         or not, i.e. if number of counted events if equal to the one,
		 *         for which subscriber subscribed for.
		 */
		public boolean updateCounter() {
			if (++eventCounter >= packSize) {
				return true;
			} else
				return false;
		}		
	}
	
	// Internal class.
	// Defines knowledge of the agent about registered subscribers.
	private class SubKB {
		// Maps registered subscription with its conditions extracted previously
		// from subscription message.
		private Map<Subscription,SubscriptionConstraints> kb = new HashMap<Subscription,SubscriptionConstraints>(); 
		
		/**
		 * Add information about given subcritpion with the given constraints.
		 * 
		 * @param sub is subscription object.
		 * @param subCond are constraints of given subscription.
		 */
		public void subscribe(Subscription sub, SubscriptionConstraints subCond) {
			kb.put(sub, subCond);
		}
		
		/**
		 * Removes information about given subcritpion.
		 * 
		 * @param sub is subscription.
		 * @return contraints of the given subscrption.
		 */
		public SubscriptionConstraints unsubscribe(Subscription sub) {
			return kb.remove(sub);
		}
		
		/**
		 * Returns contraints of the given subscription.
		 * 
		 * @param sub is subscription of particular subscriber.
		 * @return 
		 */
		public SubscriptionConstraints getSubscription(Subscription sub) {
			return kb.get(sub);
		}

		/**
		 * Returns list of subcriptions subscribed in this knowledge-base.
		 * 
		 * @return list of subcriptions.
		 */
		public Iterator<Subscription> getSubcriptions() {
			return kb.keySet().iterator();
		}
		
	}
}
