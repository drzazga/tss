
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

import com.ibm.adtech.jastor.JastorException;

import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.UserBehaviour;

/**
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 *
 */
public class ExtendedEvent {
    private UserBehaviour behaviour;
    private Integer userID;
    private String sessionID;
    private String conceptURI;
    public UserBehaviour getBehaviour() {
        return behaviour;
    }
    public void setBehaviour(UserBehaviour behaviour) {
        this.behaviour = behaviour;
    }
    public String getConceptURI() {
        return conceptURI;
    }
    public void setConceptURI(String conceptURI) {
        this.conceptURI = conceptURI;
    }
    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    
    public ExtendedEvent(Event e) {
		try {
			behaviour = e.getHasExtendedUserBehaviour().getHasUserBehaviour();
			sessionID = e.getHasSessionID();
			userID = e.getHasUserID();
		} catch (JastorException e1) {
			throw new RuntimeException("Cannot access extended event properties.", e1);
		}
    }
}
