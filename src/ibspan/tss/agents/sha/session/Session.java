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

import ibspan.tss.layout.ViewParams;
import jade.util.Logger;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * This class represent Session concept to setup multi-stepped interaction with
 * the user. Each session is assiociated with {@link SessionData}.
 * 
 * Each session is identified by <code>sessionID</code> generated on the base
 * of <code>peerID</code> (usually IP of the user machine), current time and
 * pseudo-random numberSince, since there can be many independent sessions
 * started from one machine.
 * 
 * @author Maciej Gawinecki <maciej.gawinecki@ibspan.waw.pl>
 */
public class Session {

	// Unique ID of this session.
    private String sessionID;
    // The time, when this session was started.
    private Date   startTime;
    // Identifies the machine, at which the user connects with the system, usually
	// IP number.
    private String peerID;
    // Identifies the user, if she logged in during this sesion.
    private int    userID;
    // Determines the last moment the systems accessed this object. 
    private Date    updateTime;
    // Determines whether playingUsers has authorized (logged in) in this session or
	// logged out.
    private boolean loggedIn;    
    // Data bound with that session.
    private SessionData data = new SessionData();

    //****************************************
    // Set of getters for this session.
    //****************************************
    
    /**
	 * Returns ID of the machine, at which the user connects with the system,
	 * usually IP number.
	 * 
	 * @return user's machine ID.
	 */
    public String getPeerID() 		{ return peerID;   }
    /**
	 * Returns ID of the logged user.
	 * 
	 * @return ID of the user, if logged in this session; otherwise -
	 *         {@link ViewParams.UNKNOWN_USER_ID}.
	 */
    public long getUserID() 			{ return userID; }
    /**
	 * Returns unique ID of this session.
	 * 
	 * @return session ID.
	 */
    public String getSessionID() 	{ return sessionID; }
    /**
	 * Returns the time, at which this session was started.
	 * 
	 * @return the start time.
	 */
    public Date getStartTime() 		{ return startTime; }
    /**
	 * Determines the last moment the systems accessed this object. Could be
	 * used to remove dead sessions or log out the user after certain time-out
	 * period.
	 * 
	 * @return the last update time.
	 */
    public Date getUpdateTime() 	{ return updateTime; }
    /**
	 * Checks whether logged in this session and is still logged.
	 * 
	 * @return true if user is logged in.
	 */
    public boolean isLoggedIn() 	{ return loggedIn; }
    /**
	 * Returns the data bound with this session.
	 * 
	 * @return session data.
	 */
    public SessionData getData()	{ return data; }

    /**
	 * Constructs the session object on the base of the given peerID
	 * 
	 * @param peerID
	 *            is unique ID of the machine, at which the user connects with
	 *            the system, usually IP number.
	 */
    public Session(String peerID) {
		sessionID = SessionUtil.generateSessionID( peerID );
		this.peerID = peerID;
		userID = ViewParams.UNKNOWN_USER_ID;
		loggedIn = false;
		updateTime = startTime = new Date();
		data = new SessionData();
		
    }

    /**
     * This function must be called after every change to this object.
     */
    private void update() { 
    	updateTime = new Date();
    }

    public void loginUser(int userID) {
        this.userID = userID;
        loggedIn = true;
        update();
    }    
    
    public void logoutUser() { 
    	userID = ViewParams.UNKNOWN_USER_ID;
        loggedIn = false;
        update();
    }
    
    /**
     * Inner class for generating unique session ID. It uses DES-encrypting algorithm.
     */
    private static class SessionUtil {

    	private static Logger logger = Logger.getMyLogger(SessionUtil.class.getName());
    	
    	private static DesEncrypter encrypter;    	
    	private static final String ENCRYPTING_ALGORITHM = "DES"; 
	
    	private static DesEncrypter getEncrypter() throws NoSuchAlgorithmException {
    		SecretKey key;
    		// Generate a temporary key.
			key = KeyGenerator.getInstance(ENCRYPTING_ALGORITHM).generateKey();

			// Create encrypter/decrypter class
			return new DesEncrypter(key);    	
    	}

    	// slightly based on PHP session_create_id() algorithm
    	// but using DES algorithm
    	
    	
    	/**
		 * Returns unique ID for new session. Since many independent sessions
		 * can be started from one machine it uses not only ID number of the
		 * user machine as a base, but also current time and pseudo-random
		 * number.
		 * 
		 * @param peerID
		 *            is unique ID of the machine, at which the user connects
		 *            with the system, usually IP number.
		 * @return unique session ID.
		 */
    	public static String generateSessionID(String peerID)  {
    		String sid = null;
    		
			try {
				if (encrypter == null)
					encrypter = getEncrypter();
				
				String origin = "";

				origin += peerID;
				origin += new Date();
				origin += Math.random();

				sid = encrypter.encrypt(origin);

				// remove non-word character (for URL compatybility
				sid = sid.replaceAll("\\W", "");
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Problem with encrypter ", e);
			} 

			return sid;
			
    	}
    }
    
    /**
	 * This class simply do notihngs, but extends map and can be used in the
	 * future for providing additional functionality for operating on session
	 * data.
	 */
    public class SessionData extends HashMap<Object,Object> {}
}