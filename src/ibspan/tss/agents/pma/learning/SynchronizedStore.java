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

import ibspan.tss.agents.sha.history.HistorySubscriptionManager;
import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows competing behaviours of an the to exachange information
 * between them without blocking each other. The behaviour willing to informs
 * another one about new data just call <code>push()</code> method, which
 * wakes up whole Agent, including the behaviour which wait for this data in
 * <i>blocking</i> state.
 * 
 * <p>
 * The class has implemented as queue with FIFO policy. 
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ContinuousLearning
 * @see HistorySubscriptionManager
 */
public class SynchronizedStore {
	
	// Here are stored objects.
	private List<Object> queque = new ArrayList<Object>();
	// The agent is queque belongs to.
	private Agent myAgent;
	
	/**
	 * Constructs <code>Synchronized queque</code>
	 * @param a is the agent this queque belongs to.
	 */
	public SynchronizedStore(Agent a) {
		myAgent = a;
	}
		
	/**
	 * Adds given element to the end of the store queue (according to FIFO
	 * policy) and wakes up an agent this <code>SynchronizedStore</code>
	 * object belongs to.
	 * 
	 * @param element
	 *            is an element to be added.
	 */
	public void push(Object element) {
		queque.add(element);
		// This will wake up all blocked behaviours, even those
		// which do not expect to access this queque.
		myAgent.doWake();
	}
	
	/**
	 * Removes element from the top of the queque queue (according to FIFO
	 * policy).
	 * 
	 * @return the elements that was just removed.
	 */
	public Object pull() {
		if (! queque.isEmpty())
			return queque.remove(0);
		else 
			return null;
	}
}
