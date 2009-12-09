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

import ibspan.tss.um.ontology.StatisticEntry;
import ibspan.tss.um.ontology.UserBehaviour;
import ibspan.tss.um.ontology.UserModellingFactory;
import jade.util.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Selector;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.JastorException;

/**
 * This class holds information about number of events in which particular user
 * (or all users) performed particular <code>UserBehaviour</code> object (or
 * all possible <code>UserBehaviour</code> objects) objected against
 * particular concept (or all possible concepts).
 * 
 * <p>
 * This class must be initialized:
 * <ol>
 * <li> by model of statistics used to store
 * statistics in database and passed as an argument of contructor and 
 * <li> by calling at least one time method {@link #updateStatistics(List)} to load
 * statistics about given events into the buffer.
 * </ol>
 * 
 * <p>
 * The aim and the way this class has been implemented results from requirement
 * for short-time access to statistics during learning process. Therefore, most
 * of necessary statistics are stored locally.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class StatisticsBuffer {

	private static Logger logger = Logger.getMyLogger( StatisticsBuffer.class.getName());
	
	// Local buffer stores only statistics about events procesed. 
	private Map<TempStatisticKey, Integer> buffer = new HashMap<TempStatisticKey, Integer>();
	// Database model with statistics.
	private OntModel mStatisticsDB;
	
	/**
	 * Constructs <code>StatisticsBuffer</code> with the given model of statistics underlying.
	 * @param mStatisticsDB model with statistics
	 */
	public StatisticsBuffer(OntModel mStatisticsDB) {
		this.mStatisticsDB = mStatisticsDB;
	}
	
	// Returns entry in statistics model matching the given key values. 
	private StatisticEntry getEntryFromDB(final Integer userID, final UserBehaviour ub, final String conceptURI) {
		StatisticEntry entry = null;

		final TempStatisticKey key1 = new TempStatisticKey(userID, ub, conceptURI);
		
		// Construct selector for choosing these statements which matches the given key fields.
		Selector sel = new SimpleSelector(null, RDF.type, StatisticEntry.TYPE) {
			public boolean selects(Statement s) {
				Resource subj = s.getSubject();
				try {
					StatisticEntry e = UserModellingFactory.getStatisticEntry(subj, mStatisticsDB);
					TempStatisticKey key2 = new TempStatisticKey(e.getHasUserID(), e.getHasUserBehaviour(), e.getHasConceptURI());
					return key1.equals(key2);
				} catch (JastorException e) {
					throw new RuntimeException(e);
				}
			}
		};
		StmtIterator it = mStatisticsDB.listStatements(sel);

		try {
			if (it.hasNext()) {
				// Ouh, there is entry in DB
				Resource rr = it.nextStatement().getSubject();
				entry = UserModellingFactory.getStatisticEntry(rr, mStatisticsDB);
			} else {		
				// There is no entry in DB, so let's create it
				entry = UserModellingFactory.createStatisticEntry(mStatisticsDB.createResource(), mStatisticsDB);				
				if (userID != null)
					entry.setHasUserID(userID);
				if (ub != null)
					entry.setHasUserBehaviour(ub);
				if (conceptURI != null)
					entry.setHasConceptURI(conceptURI);
				entry.setHasCount(0);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return entry;
	}
		
	
	// Returns number of event stored in database and matching the given key values.
	private int getStatisticFromDB(final Integer userID, final UserBehaviour ub, final String conceptURI) {
		// TODO Check neccessity of method. This usually during learning phase as
		// all necessary data are in buffer, but learnig algorithm is asking about
		// all possible comibinations of triples (userID,behaviour,concept), event
		// those which does not occured in last pack of events.
		try {
			StatisticEntry entry = getEntryFromDB(userID, ub, conceptURI);
			return  entry.getHasCount();
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Updates statistics in this buffer and underlying database model by
	 * processing the given events.
	 * 
	 * @param events
	 *            events from which statistics will be calculated.
	 */
	public void updateStatistics(List<ExtendedEvent> events) {
		// FIXME: SystemMonitor shows there is no logged event for user=null,
		// behaviour=null,concept=res:Restaurant, but there is for user=8,
		// behaviour=null,concep=res:Restaurant; maybe the reason was wrong hash
		// function for TmpStatisticKey -- it was corrected but not veryfied
		
		logger.fine("Updating statistics thanks to new pack of events...");
		
		// Update local buffer with the given events.
		for (Iterator<ExtendedEvent> it = events.iterator(); it.hasNext();) {
			ExtendedEvent e = it.next();
		
			updateLocalEntry(e.getUserID(), e.getBehaviour(), 	e.getConceptURI());
			updateLocalEntry(null, 			e.getBehaviour(), 	e.getConceptURI());
			updateLocalEntry(e.getUserID(), null, 				e.getConceptURI());
			updateLocalEntry(e.getUserID(), e.getBehaviour(), 	null);
			updateLocalEntry(null, 			null, 				e.getConceptURI());
			updateLocalEntry(null, 			e.getBehaviour(), 	null);
			updateLocalEntry(e.getUserID(), null, 				null);
			updateLocalEntry(null, 			null, 				null);	
		}
		
		logger.fine("Done.");
		
		// Sum up counts from local buffer and database and write them in both stores.
		logger.fine("Updating statistics in DB...");
		try {
			for (Iterator<TempStatisticKey> it = buffer.keySet().iterator(); it.hasNext();) {
				TempStatisticKey key = it.next(); 

				StatisticEntry entry = getEntryFromDB(key.getUserID(), key.getUserBehaviour(), key.getConceptURI());
				Integer count = entry.getHasCount() + buffer.get(key);;
				entry.setHasCount(count);
				buffer.put(key, count);
			}
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
		logger.fine("Done.");	
	}

	/**
	 * Returns the number of events matching the given key values.
	 * 
	 * @param userID
	 *            is id of a user acting in an event; if <code>null</code>
	 *            value then number of events for all users will be returned.
	 * @param userBehaviour
	 *            is user behaviour performed in an event; if <code>null</code>
	 *            then number of events for all possible user behaviours will be
	 *            returned.
	 * @param conceptURI
	 *            is URI reference of concept objected by an event; if
	 *            <code>null</code> then number of events for all possible
	 *            concepts will be returned.
	 * @return number of matching events
	 */
	public Integer getStatistic(Integer userID, UserBehaviour ub, String conceptURI) {
		Integer count = null;
		
		TempStatisticKey key = new TempStatisticKey(userID, ub, conceptURI);
		
		// Check whether we buffered value for this key.
		count = buffer.get(key);		
		if (count == null)
			// No, it could be in database...
			count = getStatisticFromDB(userID, ub, conceptURI);
		if (count == null)
			// Give up.
			count = 0;

		return count;
	}
	
	// Increment count of events of type described by the key fields.
	private void updateLocalEntry(Integer userID, UserBehaviour ub, String conceptURI) {
		TempStatisticKey key = new TempStatisticKey(userID, ub, conceptURI);
		Integer count = buffer.get(key);
		if (count != null) 
			buffer.put(key, ++count);
		
		else
			// There is no entry with the given key.
			buffer.put(key, 1);
	}

	
	// Internal class.
	// Describes key for statistics.
	private static class TempStatisticKey {

		private static Object NULL_KEY = new Object();
		private Integer userID;
		private UserBehaviour userBehaviour;
		private String conceptURI;		

		/**
		 * Constructs TmpStatisticKey.
		 * 
		 * @param userID
		 *            is id of a user acting in an event; <code>null</code>
		 *            value means this key is for statistics of all users.
		 * @param userBehaviour
		 *            is user behaviour performed in an event; <code>null</code>
		 *            value means this key is for statistics of all possible
		 *            user behaviours.
		 * @param conceptURI
		 *            is URI reference of concept objected by an event;
		 *            <code>null</code> value means this key is for statistics
		 *            of all possible concepts.
		 */
		public TempStatisticKey(Integer userID, UserBehaviour userBehaviour, String conceptURI) {
			this.userID = userID;
			this.userBehaviour = userBehaviour;
			this.conceptURI = conceptURI;
		}

		/**
		 * Returns URI reference of concept objected by an event.
		 * @return URI reference of concept
		 */
		public String getConceptURI() 				{ return conceptURI; }
		/**
		 * Returns user behaviour performed in an event.
		 * @return user behaviour
		 */
		public UserBehaviour getUserBehaviour() 	{ return userBehaviour; }
		/**
		 * Returns ID of a user acting in an event
		 * @return ID of a user
		 */
		public Integer getUserID() 					{ return userID; }

		public int hashCode() {
			// Two instance of UserBehaviour class can have different hashcode,
			// altough they represent the same resource, but they can be
			// contained in different models (see hashcodes generated for Things
			// in e.g. UserModellingFactory).
			Resource ub = userBehaviour != null ? userBehaviour.resource() : null; 
			return maskNull(userID).hashCode() + maskNull(ub).hashCode() * 17 + maskNull(conceptURI).hashCode() * 91;
		}
		
		public boolean equals(Object o) {
			if (o == null || !(o instanceof TempStatisticKey))
				return false;
			
			TempStatisticKey key = (TempStatisticKey) o;
			return ((maskNull(key.userID).equals(maskNull(this.userID)))
					&& (maskNull(key.userBehaviour)).equals(maskNull(this.userBehaviour))) 
						&& (maskNull(key.conceptURI).equals(maskNull(this.conceptURI)));
		}

		private static <T> Object maskNull(T key) {		
			return key == null ? (T) NULL_KEY : key;
		}
	}
}
