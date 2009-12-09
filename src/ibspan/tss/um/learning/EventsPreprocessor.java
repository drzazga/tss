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
package ibspan.tss.um.learning;

import ibspan.tss.agents.pma.learning.ContinuousLearning;
import ibspan.tss.core.semantic.Util;
import ibspan.tss.um.UnknownIndividualsException;
import ibspan.tss.um.ontology.ContextParameter;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.ExtendedUserBehaviour;
import ibspan.tss.um.ontology.UserBehaviour;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.ibm.adtech.jastor.JastorException;

/**
 * This class is used to process a pack of new events, prepare necessary
 * information for learning and put them into <code>LearningTask</code>.
 * 
 * <p>
 * The difference between clicked concepts and clicked individuals, mentioned in
 * methods below is that clicked concepts are only URI references of objects,
 * which were clicked (or rated), and individuals are fully described resourcers
 * of these concepts. Descriptions of these individuals can be obtained only by
 * asking <code>RestaurantServiceAgent</code>. This information serves as
 * base for extending context of the given events. Therefore we obtain knowledge
 * about properties of concept a user is interested in, which could draw as to
 * find the reasons for which the user clicked such concepts.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see LearningTask
 * @see ContinuousLearning
 * @see LearningAlgorithm
 */
public class EventsPreprocessor {
	
	private static Logger logger = Logger.getMyLogger(EventsPreprocessor.class.getName());
	
	// Model with domain ontology
	private OntModel mDomain;
	// Model with individuals objected in new events (by targetURI parameter
	// in context of particular events).
	private OntModel mClickedIndividuals;
	
	/**
	 * Constructs <code>EventsPreprocessor</code>.
	 * @param mDomain is model of domain ontology.
	 */
	public EventsPreprocessor(OntModel mDomain) {
		this.mDomain = mDomain;
	}

	/**
	 * Informs this processor about individuals which were clicked by user user.
	 * Necessary for extending context of events.
	 * 
	 * @param individuals
	 *            is model of individuals (e.g. restaurants).
	 * 
	 * @see #extendContext(List)
	 */
	public void setClickedIndividualsModel(OntModel individuals) {
		mClickedIndividuals = individuals;
	}

	/**
	 * Returns set of concepts which were cliked or rated by a user in the given
	 * events.
	 * 
	 * @param events
	 *            are events to be retrieved
	 * @return URI references of concept
	 */
	public Set<String> getClickedConcepts(List<Event> events) {

		Set<String> concepts = new HashSet<String>();
		try {
			for (Iterator<Event> it = events.iterator(); it.hasNext();) {
				Event e = it.next();
				
				Resource behaviour = e.getHasExtendedUserBehaviour().getHasUserBehaviour().resource();
				if (behaviour.equals(UserBehaviour.ClickForRestaurantDetailsBehaviour) ||
					behaviour.equals(UserBehaviour.RateRestaurantPositiveBehaviour)) {
					// TODO: We assumes the only parameter of behaviour's context is targetURI
					Iterator it2 = e.getHasExtendedUserBehaviour().getHasContext().getHasParameter();
					String conceptURI = ((ContextParameter) it2.next()).getHasValue();
								
					concepts.add(conceptURI);
				}
			
			}
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
		return concepts;
	}
	
	/**
	 * Returns list of concept URI references, which were objected in the given
	 * events.
	 * 
	 * @param events
	 *            are events to retrieve
	 * @return list of URI references of found objected concepts
	 */
	public Set<String> getObjectedConcepts(List<ExtendedEvent> events) {

		Set<String> concepts = new HashSet<String>();
		for (Iterator<ExtendedEvent> it = events.iterator(); it.hasNext();) {
			ExtendedEvent e = it.next();
			concepts.add(e.getConceptURI());
		}
		return concepts;
	}

	/**
	 * Returns set of users which acted in the given events.
	 * 
	 * @param events
	 *            is list of events
	 * @return set of users IDs
	 */
	public Set<Integer> getPlayingUsers(List<Event> events) {
		Set<Integer> users = null;
		try {
			users = new HashSet<Integer>();

			for (Iterator<Event> it = events.iterator(); it.hasNext();) {
				Event e = it.next();
				UserBehaviour b = e.getHasExtendedUserBehaviour().getHasUserBehaviour();
				if (UserBehaviour.QueryForRestaurantBehaviour.equals(b.resource())
						|| UserBehaviour.RateRestaurantPositiveBehaviour.equals(b.resource())
						|| UserBehaviour.ClickForRestaurantDetailsBehaviour.equals(b.resource())) 
					users.add(e.getHasUserID());
			}

		} catch (JastorException e) {
			throw new RuntimeException("Cannot access extended user behaviour or user id.", e);
		}
		
		return users;
	}
	
	/**
	 * Extends the context of the given events on the base of description of
	 * those individuals (e.g. a restaurant), which were clicked or rated by the
	 * user and on the base of expected properties of an individual (e.g. a
	 * restaurant), user defined in search query
	 * 
	 * @param events
	 *            to be extends
	 * @return events with extended context
	 * @throws UnknownIndividualsException
	 *             when <code>EventProcessor</code> was not informed about
	 *             model of individuals.
	 */
	public List<ExtendedEvent> extendContext(List<Event> events) throws UnknownIndividualsException {
		if (mClickedIndividuals == null)
			throw new UnknownIndividualsException();
		
		try {
			List<ExtendedEvent> resultEvents = new ArrayList<ExtendedEvent>();
			
			for (Iterator<Event> it = events.iterator(); it.hasNext();) {
				Event fromEvents = it.next();

				ExtendedUserBehaviour extb = fromEvents.getHasExtendedUserBehaviour();
				UserBehaviour b = extb.getHasUserBehaviour();
				if (UserBehaviour.QueryForRestaurantBehaviour.equals(b.resource())) {
					extendContextOfQuery(fromEvents, resultEvents);
				} else if (UserBehaviour.RateRestaurantPositiveBehaviour.equals(b
						.resource())
						|| UserBehaviour.ClickForRestaurantDetailsBehaviour
								.equals(b.resource())) {
					extendContextOfRateOrClick(fromEvents, resultEvents);
				}
			}

			return resultEvents;
		
		} catch (JastorException e) {
			throw new RuntimeException("Cannot access properties of extended user behaviour.", e);
		}
		
	}
	
	// For every event with query adds and for every parameter in this query
	// creates extended event with concept being reflected form of property name
	// and value given this query.
	private List<ExtendedEvent> extendContextOfQuery(Event e,List<ExtendedEvent> extEvents) {

		try {
			ExtendedEvent exte;
			Resource r;
			for (Iterator<ContextParameter> it = e.getHasExtendedUserBehaviour()
					.getHasContext().getHasParameter(); it.hasNext();) {

				ContextParameter p = it.next();

				// create event pointing reflexion of name of parameter
				r = ResourceFactory.createResource(p.getHasName());
				r = Util.getReflection(r, mClickedIndividuals,mDomain);
				// TODO mClickedIndividuals model may contain no information
				// about property ginve in a query. Check it!
				if (r != null) {
					exte = new ExtendedEvent(e);
					exte.setConceptURI(r.getURI());
					extEvents.add(exte);
				}

				// ...and another one with reflexion of value of parameter
				r = ResourceFactory.createResource(p.getHasValue());
				r = Util.getReflection(r, mClickedIndividuals,mDomain);
				if (r != null) {
					exte = new ExtendedEvent(e);
					exte.setConceptURI(r.getURI());
					extEvents.add(exte);
				}
			}
			return extEvents;
		} catch (JastorException e1) {
			throw new RuntimeException("Cannot access properties of extended event. ", e1);
		}
	}

	// For every click or rate event creates extended events describing clicked or rated individual
	private List<ExtendedEvent> extendContextOfRateOrClick(Event fromEvent, List<ExtendedEvent> resultEvents) {
		try {
			// we assume Rate/Click behaviour has only one parameter:
			// targetURI
			for(Iterator<ContextParameter> it = fromEvent.getHasExtendedUserBehaviour().getHasContext().getHasParameter(); it.hasNext(); ) {
				ContextParameter cp = it.next();
			}
			
			ContextParameter p = (ContextParameter) fromEvent.getHasExtendedUserBehaviour()
					.getHasContext().getHasParameter().next();

			if (ContextParameter.TargetURI.getURI().equals(p.getHasName())) {
				String targetURI = p.getHasValue();				
				extendContextByResource(ResourceFactory.createResource(targetURI), fromEvent, resultEvents);
			}

			return resultEvents;
		} catch (JastorException e1) {
			throw new RuntimeException("Cannot access context parameter.", e1);
		}
	}
	
	/**
	 * Recursively adds extended events to the given list, moving along of
	 * properties, starting from the <code>root</code> resource. Newly added
	 * events points concept found in graph of the given resource, reflecteded
	 * to the domain. Extended events are created with concepts referencing to
	 * each property name and its value of the given resource.
	 * 
	 * @param resultEvents
	 *            list of events
	 * @param fromEvent
	 *            event to extend
	 * @param root
	 *            the resource from where we start searching of concepts
	 */
	private void extendContextByResource(Resource root, Event fromEvent, List<ExtendedEvent> resultEvents) {
		List<Resource> visitedRoots = new ArrayList<Resource>();
		extendContextByResource(root, fromEvent, visitedRoots, resultEvents);
	}

	private void extendContextByResource(Resource root, Event fromEvent, List<Resource> visitedRoots, List<ExtendedEvent> resultEvents) {
		visitedRoots.add(root);
		Resource reflected = Util.getReflection(root, mClickedIndividuals, mDomain);

		if (reflected != null) {
			ExtendedEvent exte = new ExtendedEvent(fromEvent);
			exte.setConceptURI(reflected.getURI());
			resultEvents.add(exte);

			// Associate root with model it belongs to.
			if	(mClickedIndividuals.containsResource(root))
				root = (Resource) root.inModel(mClickedIndividuals);
			else
				root = (Resource) root.inModel(mDomain);
			
			// Find next roots.
			StmtIterator si = root.listProperties();
			while (si.hasNext()) {
				RDFNode nextRoot = si.nextStatement().getObject();
				// Object of property statement cannot be Literal to move further in searching.
				if (nextRoot instanceof Resource && !visitedRoots.contains(nextRoot))
					extendContextByResource((Resource)nextRoot, fromEvent, visitedRoots, resultEvents);
			}
		}
	}

}
