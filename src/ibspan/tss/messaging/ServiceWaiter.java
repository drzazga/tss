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

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

/**
 * This behaviours support an agent in pausing his acting until the specific
 * service, which the given <code>ServiceFinder</code> observes, registers in
 * <i>Directory Facilitator</i>.
 * 
 * <p>
 * Behaviours get into blocking state ("fall asleep") until
 * <code>ServiceFinder</code> object wakes it up.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ServiceFinder
 */
public class ServiceWaiter extends SimpleBehaviour {

	private ServiceFinder myFinder;

	/**
	 * Constructs <code>ServiceWaiter</code> behaviour waiting for the service
	 * observed by the given <code>ServiceFinder</code> object.
	 * 
	 * @param a
	 *            is the agent this behaviour belongs to
	 * @param requiredFinder
	 *            is finder for which looks for particular service.
	 */
	public ServiceWaiter(Agent a, ServiceFinder requiredFinder) {
		super(a);
		myFinder = requiredFinder;
	}

	private boolean finished = false;

	public void action() {
		if (myFinder.getOne() != null) {
			finished = true;
		} else {
			// Of course, any other waking event, like new message incoming,
			// will wake this behaviour up.
			block();
		}
	}

	public boolean done() {
		return finished;
	}
}
