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
package ibspan.tss.agents.sha;

import ibspan.tss.agents.sha.handlers.CheckLogin1MC;
import ibspan.tss.agents.sha.handlers.CheckRegistration1MC;
import ibspan.tss.agents.sha.handlers.CheckRegistration2MC;
import ibspan.tss.agents.sha.handlers.LogoutMC;
import ibspan.tss.agents.sha.handlers.PersonalForwarderMC;
import ibspan.tss.agents.sha.history.HistoryLogger;
import ibspan.tss.agents.sha.mvc.Controller;
import ibspan.tss.agents.sha.mvc.DummyModelConstructor;
import ibspan.tss.agents.sha.mvc.ModelConstructor;
import ibspan.tss.agents.sha.mvc.SimpleViewConstructor;
import ibspan.tss.agents.sha.mvc.ViewConstructor;
import ibspan.tss.agents.sha.session.ActionDispatcherWithSessionTracking;
import ibspan.tss.layout.TemplatesRegister;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.FormLink;
import ibspan.tss.layout.ontology.datamodel.InternalLink;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.layout.ontology.datamodel.MenuLink;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import jade.util.Logger;

import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.ibm.adtech.jastor.JastorException;

/**
 * This is of Responder for <code>SessionHandlingAgent</code>. It realize
 * requests of the user (received from <code>ProxyAgent</code>) and requests
 * from other agents. It works in an iterative manner.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see SessionHandlingAgent
 */
public class SHAResponder extends AchieveREResponder {

	private static Logger logger = Logger.getMyLogger(SHAResponder.class.getName());
	
	public final String ACTION_NAME_KEY = "___action-name" + hashCode(); 
	public final String ACT_KEY = "___action" + hashCode(); 
	
	private SessionHandlingAgent myAgent;
	
	public SHAResponder(Agent a, MessageTemplate mt, HistoryLogger historyLogger) {
		super(a, mt);
		myAgent = (SessionHandlingAgent) a;
		   		
		Resource r;
		Link link;
		
		// Register templates
    	TemplatesRegister templates = myAgent.getTemplates();
    	OntModel mTemplatesDB = myAgent.getTemplatesDBModel();
    	
    	try {        	
    		r = LayoutStructure.WelcomeStructure;
    		link = DataModelFactory.getLink(MenuLink.Welcome, mTemplatesDB);   
    		templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
					   	
    		r = LayoutStructure.Login1Structure;
    		link = DataModelFactory.getLink(MenuLink.Login1, mTemplatesDB);   
    		templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.Register1Structure;
			link = DataModelFactory.getLink(MenuLink.Register1, mTemplatesDB); 
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.Register2Structure;
			link = DataModelFactory.getLink(InternalLink.Register2, mTemplatesDB); 
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.RegisterSuccessStructure;
			link = DataModelFactory.getLink(InternalLink.RegisterSuccess, mTemplatesDB);
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.LogoutStructure;
			link = DataModelFactory.getLink(MenuLink.Logout, mTemplatesDB);
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));			
    	} catch (JastorException e) {
    		logger.log(Level.SEVERE, "", e);
    	}
		
    	ActionDispatcherWithSessionTracking selector = 
    		new ActionDispatcherWithSessionTracking(myAgent, getDataStore(), 
    				historyLogger, REQUEST_KEY, ACTION_NAME_KEY, ACT_KEY);
    	registerPrepareResultNotification( selector );
    	
    	Controller c;
    	ModelConstructor mc;
    	ViewConstructor vc;	    
    	DataStore ds = getDataStore();
    	
    	// Register static handlers for user request requiring NO authorization
    	try {
	    	mc = new DummyModelConstructor(myAgent, ds);   
	    	vc = new SimpleViewConstructor(myAgent, ds); 
	    	c = new Controller(myAgent, getDataStore(), REQUEST_KEY, RESULT_NOTIFICATION_KEY,ACT_KEY, ACTION_NAME_KEY);
	    	c.registerModelConstructor(mc);
	    	c.registerViewConstructor(vc);
	 
	    	link = DataModelFactory.getLink(MenuLink.Welcome, mTemplatesDB); 
	    	selector.registerHandler( false, link.getHasActionName(), c );
	    	
	    	link = DataModelFactory.getLink(MenuLink.Register1, mTemplatesDB); 
	    	selector.registerHandler( false, link.getHasActionName(), c );
	    	
	    	link = DataModelFactory.getLink(MenuLink.Login1, mTemplatesDB); 
	    	selector.registerHandler( false, link.getHasActionName(), c );	    
	    	
	        mc = new CheckRegistration1MC(myAgent, ds);
	    	vc = new SimpleViewConstructor(myAgent, ds); 
	    	c = new Controller(myAgent, getDataStore(), REQUEST_KEY, RESULT_NOTIFICATION_KEY,ACT_KEY, ACTION_NAME_KEY);
	    	c.registerModelConstructor(mc);
	    	c.registerViewConstructor(vc);   
	
	    	link = DataModelFactory.getLink(FormLink.CheckRegister1, mTemplatesDB); 
	    	selector.registerHandler( false, link.getHasActionName(), c );
	    	
	    	mc = new CheckRegistration2MC(myAgent, ds);
	    	vc = new SimpleViewConstructor(myAgent, ds); 
	    	c = new Controller(myAgent, getDataStore(), REQUEST_KEY, RESULT_NOTIFICATION_KEY,ACT_KEY, ACTION_NAME_KEY);
	    	c.registerModelConstructor(mc);
	    	c.registerViewConstructor(vc);     
	    	
	    	link = DataModelFactory.getLink(FormLink.CheckRegister2, mTemplatesDB); 
	    	selector.registerHandler( false, link.getHasActionName(), c );
	    	
	        mc = new CheckLogin1MC(myAgent, ds);
	    	vc = new SimpleViewConstructor(myAgent, ds); 
	    	c = new Controller(myAgent, getDataStore(), REQUEST_KEY, RESULT_NOTIFICATION_KEY,ACT_KEY, ACTION_NAME_KEY);
	    	c.registerModelConstructor(mc);
	    	c.registerViewConstructor(vc);   
	
	    	link = DataModelFactory.getLink(FormLink.CheckLogin1, mTemplatesDB); 
	    	selector.registerHandler( false, link.getHasActionName(), c );	    	
	        
	    	// Register handlers forwarding user request to Personal Agent; requires authorization    	
	    	mc = new PersonalForwarderMC(myAgent, ds);
	    	vc = new SimpleViewConstructor(myAgent, ds); 
	    	c = new Controller(myAgent, getDataStore(), REQUEST_KEY, RESULT_NOTIFICATION_KEY,ACT_KEY, ACTION_NAME_KEY);
	    	c.registerModelConstructor(mc);
	    	c.registerViewConstructor(vc);   
	    	
	    	link = DataModelFactory.getLink(MenuLink.DefineSearch, mTemplatesDB); 
	    	selector.registerHandler( true, link.getHasActionName(), c );
	    	
	    	link = DataModelFactory.getLink(FormLink.Search, mTemplatesDB); 
	    	selector.registerHandler( true, link.getHasActionName(), c );
	    	
	    	link = DataModelFactory.getLink(MenuLink.ShowDetails, mTemplatesDB); 
	    	selector.registerHandler( true, link.getHasActionName(), c );
	    	
	    	link = DataModelFactory.getLink(MenuLink.ShowBackedUpResults, mTemplatesDB); 
	    	selector.registerHandler( true, link.getHasActionName(), c );
	        
	    	// Register handlers requiring authorization, but also intervention of SHA
	    	mc = new LogoutMC(myAgent, ds);
	    	vc = new SimpleViewConstructor(myAgent, ds); 
	    	c = new Controller(myAgent, getDataStore(), REQUEST_KEY, RESULT_NOTIFICATION_KEY,ACT_KEY, ACTION_NAME_KEY);
	    	c.registerModelConstructor(mc);
	    	c.registerViewConstructor(vc);   
	    	link = DataModelFactory.getLink(MenuLink.Logout, mTemplatesDB); 
	    	selector.registerHandler( true, link.getHasActionName(), c );
	    	
        
		} catch (JastorException e) {
			logger.log(Level.SEVERE, "", e);
		} 
    }
	
    protected ACLMessage prepareResponse(ACLMessage request) throws NotUnderstoodException, RefuseException {
    	// Don't say AGREE or REFUSE exlipictly; no response means AGREE
        return null;
    }
    
}
