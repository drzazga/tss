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
package ibspan.tss.agents.pra.initiators;

import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

/**
 * 
 * PrASystemInit extends AchieveREInitiator - it initiates the conversation with
 * the SHA
 * 
 * @author Pawe? Kaczmarek
 */
public class ProcessUserRequestInitiator extends AchieveREInitiator {

	private String jobID;

	public ProcessUserRequestInitiator(Agent a, ACLMessage request, DataStore ds, String jobID) {
		super(a, request, ds);
		this.jobID = jobID;
	}

	protected void handleInform(ACLMessage inform) {		
		DataStore ds = getDataStore();
		synchronized(ds) {
			ds.put(jobID, inform);
			ds.notify();
		}
	}


	protected void handleFailure(ACLMessage failure) {
		DataStore ds = getDataStore();
		synchronized(ds) {
			ds.put(jobID, failure);
			ds.notify();
		}
	}

}