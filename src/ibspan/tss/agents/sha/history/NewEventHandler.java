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

import ibspan.tss.um.ontology.Event;

/**
 * This simple interface suppose to handle with new <code>Event</code> coming.
 * <code>HistoryLogger</code> uses this component to handle with every new
 * <code>Event</code> coming as user request and <code>HistorySubscriptionManager</code> is
 * the one, which realize this handling by implementing
 * <code>handleNewEvent()</code> method.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see HistoryLogger
 * @see HistorySubscriptionManager
 */
public interface NewEventHandler {
	
	/**
	 * Handles with the given event.
	 * 
	 * @param e is the event which have to be handled with.
	 */
	public void handleNewEvent(Event e);
}
