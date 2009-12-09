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
package ibspan.tss.agents.pa.handlers;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.util.Logger;

import java.util.logging.Level;

/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class ShowBackedUpResultsPMC extends PersonalModelConstructor {

	private static Logger logger = Logger.getMyLogger(ShowBackedUpResultsPMC.class.getName());
	
	// FSM states
	private static final String GETTING_BACKED_UP_RESULTS = "getting-backed-up-results";

	public ShowBackedUpResultsPMC(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object actionNameKey, Object resultNotificationKey) {
		super(a, ds, requestKey, actKey, actionNameKey, resultNotificationKey);
	
		Behaviour b = new OneShotBehaviour(myAgent) {
			public void action() {
				try {
					DataModel model = new DataModel();
					String actionName = getActionName();
					model.setConstructorActionName(actionName);
									
					Memory mem = new Memory();
					
					// Build template describing screen into data model
					LayoutStructure template = templates.getCopy(actionName);					
					mem.add(template);
					
					// Recover backed up results into memory
					mem.add( getBackedUpResult() );
				
					model.setOwlModel(mem.buildOWLData());
					
					// Leave results of building model in datastore
					putModel(model);
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare model. ", e);
					putError(new InternalSystemError());
				}
			}
		};
		registerFirstState(b, GETTING_BACKED_UP_RESULTS);
		registerLastState(b, GETTING_BACKED_UP_RESULTS);

	}
	
}
