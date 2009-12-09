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
package ibspan.tss.agents.sha.handlers;

import ibspan.tss.agents.sha.mvc.ModelConstructor;
import ibspan.tss.agents.sha.session.Session.SessionData;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.core.semantic.Util;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.InternalLink;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.layout.ontology.datamodel.MenuLink;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.UserRequest;
import ibspan.tss.um.ontology.UserProfileData;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.util.Logger;

import java.util.Map;
import java.util.logging.Level;

/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class CheckRegistration1MC extends ModelConstructor {
	
	private static Logger logger = Logger.getMyLogger(CheckRegistration1MC.class.getName());

	// FSM states
	private static final String DUMMY_CONSTUCTING = "dummy";


	
	public CheckRegistration1MC(Agent a, DataStore ds) {
		super(a, ds); 

		Behaviour b = new OneShotBehaviour(myAgent) {
			public void action() {
				// Construct template and choose action name		
				try {
					LayoutStructure template = null;
					DataModel model = new DataModel();
					UserRequest request = getUserRequest();	
					Map<String, String> params = Util.getMap(request
							.getActionParams());
					if (checkData(params)) {
						// Store entered data within current session
						SessionData sdata  = getCurrentSession().getData();						
						Object key;						
						
						key = UserProfileData.hasAgeProperty.getURI();
						sdata.put(key,params.get(key));
						key = UserProfileData.hasDressProperty.getURI();
						sdata.put(key,params.get(key));
						key = UserProfileData.hasProfessionProperty.getURI();
						sdata.put(key,params.get(key));
						key = UserProfileData.hasWealthProperty.getURI();
						sdata.put(key,params.get(key));
						
						// Prepare system response screen
						Link link = DataModelFactory.getLink(InternalLink.Register2, getTemplatesDB());   
						model.setConstructorActionName(link.getHasActionName());
						template = templates.getCopy(link.getHasActionName());
	
					} else {
						// Prepare system response screen
						Link link = DataModelFactory.getLink(MenuLink.Register1, getTemplatesDB());   
						model.setConstructorActionName(link.getHasActionName());
						template = templates.getCopy(link.getHasActionName());
						template.setHasErrorMessage("Incorrect data !");
						template.setHasText("Correct your data.");						
					}

					// Build template describing screen into data model
					Memory mem = new Memory(template);
					model.setOwlModel(mem.buildOWLData());

					// Leave results of building model in datastore
					putModel(model);
				
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare model. ", e);
					putError(new InternalSystemError());
				} 
			}
		};
		registerFirstState(b, DUMMY_CONSTUCTING);
		registerLastState(b, DUMMY_CONSTUCTING);

	}
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	private boolean checkData(Map<String, String> params) {
		String age = params.get(UserProfileData.hasAgeProperty.getURI());
		try {
			Integer.parseInt(age);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
