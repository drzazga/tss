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
import ibspan.tss.dao.UsersDAO;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.InternalLink;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.messaging.ServiceNotFoundException;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.InternalSystemError;
import ibspan.tss.messaging.ontology.MessagingOntology;
import ibspan.tss.messaging.ontology.PMA_init_user_profile;
import ibspan.tss.messaging.ontology.UserRequest;
import ibspan.tss.um.ontology.UserProfileData;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.util.Logger;

import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;


/**
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class CheckRegistration2MC extends ModelConstructor {
	// TODO: registration of new user should be perfomed as transaction in distributed environment
	
	private static Logger logger = Logger.getMyLogger(CheckRegistration2MC.class.getName());

	// FSM states
	private static final String CHECK_DATA = "check-data";
	private static final String CREATE_USER = "create-user";
	private static final String DUMMY = "dummy";

	// Results of data checking
	private static final int DATA_OK = 1;
	private static final int DATA_WRONG = 2;
	
	private UsersDAO users;
	
	// Information user entered during registration
	private String login;
	private String name;
	private String password;
	
	public CheckRegistration2MC(Agent a, DataStore ds) {
		super(a, ds); 
		users = myAgent.getUsersDBInterface();
		
		registerTransition(CHECK_DATA, CREATE_USER, DATA_OK);
		registerTransition(CHECK_DATA, DUMMY, DATA_WRONG);
		registerDefaultTransition(CREATE_USER, DUMMY);

		Behaviour b = new OneShotBehaviour(myAgent) {
			
			private int ret;
			
			public void action() {
				try {
					DataModel model = new DataModel();				
					UserRequest request = getUserRequest();				
					
					// Construct template and choose action name
					LayoutStructure template = null;
					Map<String, String> params = Util.getMap(request
							.getActionParams());
					if (checkData(params)) {
						// User data are correct
						login = params.get(ViewParams.LOGIN_KEY);
						name = params.get(ViewParams.USER_NAME_KEY);
						password = params.get(ViewParams.PASSWORD_KEY);
						
						if (! users.isUserKnown(name, login)) {
							// There is no such user
							ret = DATA_OK;
						} else {
							// Such user is already registered
							// Prepare system response screen
							Link link = DataModelFactory.getLink(InternalLink.Register2, getTemplatesDB());   
							model.setConstructorActionName(link.getHasActionName());
							template = templates.getCopy(link.getHasActionName());
							template.setHasErrorMessage("The user is already known !");
							template.setHasText("Correct your login and/or user name.");
							Memory mem = new Memory(template);
							model.setOwlModel(mem.buildOWLData());
							putModel(model);
							ret = DATA_WRONG;
						}						
					} else {
						// User data are incorrect
						// Prepare system response screen
						Link link = DataModelFactory.getLink(InternalLink.Register2, getTemplatesDB());   
						model.setConstructorActionName(link.getHasActionName());
						template = templates.getCopy(link.getHasActionName());
						template.setHasErrorMessage("Incorrect data !");
						template.setHasText("Correct your data.");
						Memory mem = new Memory(template);
						model.setOwlModel(mem.buildOWLData());
						putModel(model);
						
						ret = DATA_WRONG;
					}
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare model. ", e);
					putError(new InternalSystemError());
				}
			}
			
			public int onEnd() {
				return ret;
			}
		};
		registerFirstState(b, CHECK_DATA);
		
		b = new AchieveREInitiator(myAgent, null) {
			@Override
			protected Vector prepareRequests(ACLMessage request) {
				Vector requests = null;
				try {
					AID pma = CheckRegistration2MC.this.myAgent.getProfilingService().getOne(); 

					if (pma != null) {
						request = new ACLMessage(ACLMessage.REQUEST);
						request.addReceiver(pma);
						request.setOntology(MessagingOntology.getInstance().getName());
						request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
						request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

						SessionData sdata = getCurrentSession().getData();
						
						PMA_init_user_profile action = new PMA_init_user_profile();
						String ages = (String)sdata.get(UserProfileData.hasAgeProperty.getURI());
						action.setAge(Integer.parseInt(ages));
						action.setDress((String) sdata.get(UserProfileData.hasDressProperty.getURI()));
						action.setWealth((String) sdata.get(UserProfileData.hasWealthProperty.getURI()));
						action.setProfession((String) sdata.get(UserProfileData.hasProfessionProperty.getURI()));
						
						action.setUserID(users.getNextUserID());

						Action act = new Action();
						act.setAction(action);
						act.setActor(pma);

						myAgent.getContentManager().fillContent(request, act);

						requests = new Vector();
						requests.addElement(request);
					} else {
						throw new ServiceNotFoundException("Profiling service not found in DF.");
					}
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot prepare request to Restaurant service: ", e);
				}
				return requests;
			}

			@Override
			protected void handleInform(ACLMessage inform) {			
				try {
					users.registerUser(name, login, password);
					
					// Prepare system response screen
					DataModel model = new DataModel();				
		    		Link link = DataModelFactory.getLink(InternalLink.RegisterSuccess, getTemplatesDB());   
					model.setConstructorActionName(link.getHasActionName());
					LayoutStructure template = templates.getCopy(link.getHasActionName());
					
					Memory mem = new Memory(template);
					model.setOwlModel(mem.buildOWLData());
					putModel(model);
				
				} catch (Exception e) {
					logger.log(Level.SEVERE,"Cannot finilize user registration", e);
					putError(new InternalSystemError());
				} 
			}

			@Override
			protected void handleFailure(ACLMessage failure) {
				logger.log(Level.INFO, "Responder failed to realize request.");
				putError(new InternalSystemError());	
			}
		};
		registerState(b, CREATE_USER);
		
		b = new OneShotBehaviour(myAgent) {
			public void action() {
				// Do nothing
			}
		};
		registerLastState(b, DUMMY);

	}
	
	private boolean checkData(Map<String, String> params) {
		return !"".equals(params.get(ViewParams.LOGIN_KEY))
				&& !"".equals(params.get(ViewParams.USER_NAME_KEY))
				&& !"".equals(params.get(ViewParams.PASSWORD_KEY));
	}
	
}
