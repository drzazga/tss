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
package ibspan.tss.agents.sha.session;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides mapping from <code>sessionID</code> into the
 * <code>Session</code> object.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see Session
 */
public class SessionsMap  {

	// Maps sessionID to the session
	private Map<String, Session> sessions = new HashMap<String, Session>();
	
	/**
	 * Returnes session bounded with the given sessionID.
	 * 
	 * @param sessionID
	 *            is id of the session
	 * @return session session matching the given id or <code>null</code> if
	 *         not found.
	 */
	public Session getSession(String sessionID) {
		return sessions.get(sessionID);
	}
	
	/**
	 * Creates session on the base of given peerID.
	 * 
	 * @param peerID
	 *            is ID of machine from which user connects with the system
	 * @return new session
	 */
	public Session createSession(String peerID) {
		// FIXME: Do we need to check wether session from the peerID is already
		// established ? If we assume, there could more then one session from
		// the same machine at once, then answer is - no.
		Session s = new Session(peerID);
		sessions.put(s.getSessionID(), s);
		return s;
	}
}