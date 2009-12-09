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
package ibspan.tss.agents.pa;

import ibspan.tss.agents.pa.handlers.DefineSearchPMC;
import ibspan.tss.agents.pa.handlers.DummyPersonalModelConstructor;
import ibspan.tss.agents.pa.handlers.LogoutHandler;
import ibspan.tss.agents.pa.handlers.PersonalModelConstructor;
import ibspan.tss.agents.pa.handlers.SearchPMC;
import ibspan.tss.agents.pa.handlers.ShowBackedUpResultsPMC;
import ibspan.tss.agents.pa.handlers.ShowDetailsPMC;
import ibspan.tss.layout.TemplatesRegister;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.FormLink;
import ibspan.tss.layout.ontology.datamodel.InternalLink;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;
import ibspan.tss.layout.ontology.datamodel.Link;
import ibspan.tss.layout.ontology.datamodel.MenuLink;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import jade.proto.states.HandlerSelector;
import jade.util.Logger;

import java.util.logging.Level;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.ibm.adtech.jastor.JastorException;

/**
 * This is of Responder for <code>PersonalAgent</code>. It works in an
 * iterative manner.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see PersonalAgent
 */
public class PAResponder extends AchieveREResponder {
	
	private static Logger logger = Logger.getMyLogger(PAResponder.class.getName());

	public final String ACTION_NAME_KEY = "___action-name" + hashCode(); 
	public final String ACT_KEY = "___action" + hashCode(); 
	
	private PersonalAgent myAgent;
	
	public PAResponder(Agent a, MessageTemplate mt) {
		super(a, mt);
		myAgent = (PersonalAgent) a;
	
    	OntModel mTemplatesDB = myAgent.getTemplatesDBModel();
    	TemplatesRegister templates = myAgent.getTemplates();		
		
		Resource r;
		Link link;
		
		// Register templates
		try {			
			r = LayoutStructure.LoginSuccessStructure;
			link = DataModelFactory.getLink(InternalLink.LoginSuccess, mTemplatesDB);   
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
	    	r = LayoutStructure.DefineSearchStructure;
			link = DataModelFactory.getLink(MenuLink.DefineSearch, mTemplatesDB);   
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.ResultsStructure;
			link = DataModelFactory.getLink(FormLink.Search, mTemplatesDB);   
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.DetailsStructure;
			link = DataModelFactory.getLink(MenuLink.ShowDetails, mTemplatesDB);   
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
			r = LayoutStructure.ResultsStructure;
			link = DataModelFactory.getLink(MenuLink.ShowBackedUpResults, mTemplatesDB);   
			templates.register(link.getHasActionName(), DataModelFactory.getLayoutStructure(r.getURI(), mTemplatesDB));
			
		} catch (JastorException e) {
			logger.log(Level.SEVERE, "", e);
		} 
	    
		// Prepare behaviour dispatching request to handlers
		HandlerSelector selector = new PersonalActionDispatcher( myAgent, getDataStore(), REQUEST_KEY, ACTION_NAME_KEY, ACT_KEY);
    	registerPrepareResultNotification( selector );
		
    	PersonalModelConstructor c;
    	DataStore ds = getDataStore();
	  
    	// Register handlers
	    try {
	    	c = new DummyPersonalModelConstructor(myAgent, ds, REQUEST_KEY, ACT_KEY, ACTION_NAME_KEY, RESULT_NOTIFICATION_KEY);
	    	link = DataModelFactory.getLink(InternalLink.LoginSuccess, mTemplatesDB); 
	    	selector.registerHandler( link.getHasActionName(), c );
	    	
	    	c = new DefineSearchPMC(myAgent, ds, REQUEST_KEY, ACT_KEY, ACTION_NAME_KEY, RESULT_NOTIFICATION_KEY);
	    	link = DataModelFactory.getLink(MenuLink.DefineSearch, mTemplatesDB); 
	    	selector.registerHandler( link.getHasActionName(), c );	
	    	
	    	c = new SearchPMC(myAgent, ds, REQUEST_KEY, ACT_KEY, ACTION_NAME_KEY, RESULT_NOTIFICATION_KEY);
	    	link = DataModelFactory.getLink(FormLink.Search, mTemplatesDB); 
	    	selector.registerHandler( link.getHasActionName(), c );	
	    	
	    	Behaviour h = new LogoutHandler(myAgent, ds, REQUEST_KEY, ACT_KEY, RESULT_NOTIFICATION_KEY);
	    	link = DataModelFactory.getLink(MenuLink.Logout, mTemplatesDB); 
	    	selector.registerHandler( link.getHasActionName(), h );	
	    	
	    	c = new ShowDetailsPMC(myAgent, ds, REQUEST_KEY, ACT_KEY, ACTION_NAME_KEY, RESULT_NOTIFICATION_KEY);
	    	link = DataModelFactory.getLink(MenuLink.ShowDetails, mTemplatesDB); 
	    	selector.registerHandler( link.getHasActionName(), c );	
	    	
	    	c = new ShowBackedUpResultsPMC(myAgent, ds, REQUEST_KEY, ACT_KEY, ACTION_NAME_KEY, RESULT_NOTIFICATION_KEY);
	    	link = DataModelFactory.getLink(MenuLink.ShowBackedUpResults, mTemplatesDB); 
	    	selector.registerHandler( link.getHasActionName(), c );	
	    	
	        
	        
		} catch (JastorException e) {
			logger.log(Level.SEVERE, "", e);
		} 
    }
	
    protected ACLMessage prepareResponse(ACLMessage request) throws NotUnderstoodException, RefuseException {
    	// Don't say AGREE or REFUSE exlipictly; no response means AGREE
        return null;
    }
}
