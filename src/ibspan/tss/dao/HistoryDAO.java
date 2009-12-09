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
package ibspan.tss.dao;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.EventSession;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.vocabulary.HistoryDBVocabulary;
import ibspan.tss.um.vocabulary.UserModellingVocabulary;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.core.ElementFilter;
import com.hp.hpl.jena.query.core.ElementGroup;
import com.hp.hpl.jena.query.core.ElementTriplePattern;
import com.hp.hpl.jena.query.expr.E_LessThanOrEqual;
import com.hp.hpl.jena.query.expr.Expr;
import com.hp.hpl.jena.query.expr.NodeVar;
import com.hp.hpl.jena.query.expr.nodevalue.NodeValueDate;
import com.hp.hpl.jena.query.util.IndentedWriter;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.JastorException;

/**
 * Data Access Object providing nice interface to model with history.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class HistoryDAO {
	private static Logger logger = Logger.getMyLogger(HistoryDAO.class.getName());

	private static final String EVENT_VAR_NAME = "event";
	
	// Reference to last event logged in model with history.
	private Event lastEvent = null;	
	// Model with history.
	private OntModel mHistoryDB;
	
	/**
	 * Construct <code>HistoryDAO</code> object providing interface to the given model with history.
	 * @param mHistoryDB is a model with history
	 * @throws DAOException
	 */
	public HistoryDAO(OntModel mHistoryDB) throws DAOException {
		this.mHistoryDB = mHistoryDB;		
		
		try {
			Resource r = mHistoryDB.createResource(HistoryDBVocabulary.NS + Event.LastEvent.getLocalName());
			if (mHistoryDB.getBaseModel().contains(r, RDF.type, Event.TYPE)) {
				// History contains LastEvent
				lastEvent = UserModellingFactory.getEvent(r,mHistoryDB);
			} else {
				// History contains no LastEvent, so this first time we use this
				// model -- initialize it
				lastEvent = UserModellingFactory.createEvent(r,mHistoryDB);
				lastEvent.setHasEventID(0);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Creates new event and adds it to History model.
	 * 
	 * @return newly created event with ID field set up.
	 */
	public Event addEvent() {
		Event e = null;
		try {
			e = UserModellingFactory.createEvent(mHistoryDB.createResource(), mHistoryDB);
			e.setHasEventID(getNextEventID());
		} catch (JastorException ex) {
			throw new RuntimeException(ex);
		}
		return e;
	}
	
	/**
	 * Creates new session with date of starting defined as "now".
	 * 
	 * @param sessionID
	 *            is ID of session to be created.
	 * @param userID
	 *            is ID of user for which the given session is to be created.
	 * @return newly created session.
	 */
	public EventSession addSession(String sessionID, int userID) {
		EventSession session = null;
		try {
			session = UserModellingFactory.createEventSession(mHistoryDB.createResource(), mHistoryDB);
			session.setHasSessionID(sessionID);
			session.setHasUserID(userID);
			session.setStartedAt(new XSDDateTime(Calendar.getInstance()));
		} catch (JastorException ex) {
			throw new RuntimeException(ex);
		}
		return session;
	}
	
	/**
	 * Returns events logged in <i>History</i> model since the given date.
	 * 
	 * @param since
	 *            is a date from which all logged events will be returned
	 * @return a list of events.
	 */
	public List<Event> getEvents(Date since) {
		List<Event> events = new ArrayList<Event>();
		
		Query query = buildQuerySearchEvents(EVENT_VAR_NAME, since);
		QueryExecution qexec = QueryExecutionFactory.create(query, mHistoryDB);

		Memory memResults = null;
		try {
			ResultSet results = qexec.execSelect();

			// For test purposes
			// ResultSetFormatter.out(System.out, results, query);

			memResults = new Memory();
			while (results.hasNext()) {

				// logger.info("Retrieving solutions !");

				QuerySolution soln = results.nextSolution();
				Resource event = soln.getResource(EVENT_VAR_NAME);
				events.add(UserModellingFactory.getEvent(event, mHistoryDB));
				// create resource of restaurant in memory
				
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			qexec.close();
		}
		
		return events;
	}
	
	/**
	 * Returns ID under which next event will be logged in <i>History</i>
	 * model.
	 * 
	 * @return ID of an event.
	 */
	private int getNextEventID() {
		int lastEventID = 0;
		try {
			lastEventID = lastEvent.getHasEventID();
			lastEvent.setHasEventID(++lastEventID);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lastEventID;
	}
	
	// Constructs SPARQL query for searching querying logged since the given
	// date.
	private Query buildQuerySearchEvents(String varEventName, Date since) {
		// Let's build this query programatically
		Query query = QueryFactory.make();

		query.setQueryType(Query.QueryTypeSelect);

		// Build pattern
		ElementGroup elg = new ElementGroup();

		Node varEvent = Node.createVariable(varEventName);

		Triple t1 = new Triple(varEvent, RDF.type.asNode(),
				UserModellingVocabulary.Event.asNode());
		ElementTriplePattern tp1 = new ElementTriplePattern(t1);
		elg.addElement(tp1);

		Node varWhen = Node.createVariable("when");
		
		t1 = new Triple(varEvent, Event.whenProperty.asNode(),
				varWhen);
		tp1 = new ElementTriplePattern(t1);
		elg.addElement(tp1);

		Calendar calendarSince = Calendar.getInstance();
		calendarSince.setTime(since);
		NodeValueDate nvdSince = new NodeValueDate(calendarSince);		
		Expr expr = new E_LessThanOrEqual(nvdSince,new NodeVar(varWhen));
        ElementFilter filter = new  ElementFilter(expr) ;
		elg.addElement(filter);
		
		// Attach the group to query.
		query.setQueryElement(elg);

		// Choose what we want
		query.addResultVar(varEventName);

		// Prefix mapping just helps serialization
		query.getPrefixMapping().setNsPrefix("rdf", RDF.getURI());
		query.getPrefixMapping()
				.setNsPrefix("um", UserModellingVocabulary.NS);
		
		// For test purposes...
		//query.serialize(new IndentedWriter(System.out, true));
		//System.out.println();

		return query;
	}	
}
