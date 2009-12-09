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

import java.util.List;
import java.util.Set;

import com.hp.hpl.jena.ontology.OntModel;

/**
 * This class carry data necessary for learning process, realized by
 * <code>LearningAlgorithm</code>.
 * 
 * @author <a href="maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see LearningAlgorithm
 */
public class LearningTask {

	// List of IDs of users who played in new events.
	private Set<Integer> playingUsers;
	// List of URIs of individuals (e.g. restaurants) which were mentioned in
	// procesed events.
	private Set<String> objectedConcepts;
	// List of new events to process.
	private List<ExtendedEvent> events;
	// Models with detaily described clicked individuals.
	private OntModel clickedIndividuals;

	/**
	 * Returns a list of events to be a base for learning process.
	 * 
	 * @return a list of events.
	 */
	public List<ExtendedEvent> getEvents() 							{ return events; }
	/**
	 * Returns individuals which were object of clicking or rating in the
	 * events.
	 * 
	 * @return a model with individuals (with detailed description).
	 */
	public OntModel getClickedIndividuals() 						{ return clickedIndividuals; }
	/**
	 * Returns a set of users acting in events.
	 * 
	 * @return a set of IDs of users.
	 */
	public Set<Integer> getPlayingUsers() 							{ return playingUsers; }	
	/**
	 * Returns set of concepts which were objected by user in events.
	 * 
	 * @return a set of URI references of concepts
	 */
	public Set<String> getObjectedConcepts() 						{ return objectedConcepts; }
	/**
	 * Sets set of concepts which were objected by user in events.
	 * 
	 * @param objectedConcepts
	 *            is a set of URI references of concepts
	 */
	public void setObjectedConcepts(Set<String> objectedConcepts) 	{ this.objectedConcepts = objectedConcepts; }
	/**
	 * Sets a set of users acting in events.
	 * 
	 * @param playingUsers
	 *            is a set of IDs of users.
	 */
	public void setPlayingUsers(Set<Integer> playingUsers) 			{ this.playingUsers = playingUsers; }
	/**
	 * Sets a list of events to be a base for learning process.
	 * 
	 * @param events
	 *            is a list of events.
	 */
	public void setEvents(List<ExtendedEvent> events) 				{ this.events = events; }
	/**
	 * Sets individuals which were object of clicking or rating in the events.
	 * 
	 * @param mObjectedIndividuals
	 *            is a model with individuals (with detailed description).
	 */
	public void setClickedIndividuals(OntModel mObjectedIndividuals){ this.clickedIndividuals = mObjectedIndividuals; }	
	
	
}
