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
package ibspan.tss.core.semantic;

import ibspan.tss.messaging.ontology.MapEntry;
import jade.util.leap.Iterator;

import java.util.HashMap;
import java.util.Map;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.Thing;

/**
 * Class helping in operation on ontological data. Provides implementation of
 * <i>reflection</i> function.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class Util {

	/**
	 * Returns the main rdf:type of the given Thing. 
	 * 
	 * @param t is thing object
	 * @return URI reference of value for rdf:type property
	 */
	public static String getClosestRDFType(Thing t) {
		try {
			Class clazz = t.getClass();
			Resource r = (Resource)clazz.getField("TYPE").get(t);
			return r.getURI();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns reflection of the given resource <code>r</code> into given domain <code>mDomain</code>. 
	 * 
	 * @param uri
	 *            uri of the resource to be reflected
	 * @param mDB
	 *            is model, which contains statements about resource
	 *            <code>uri</code>
	 * @param mDomain
	 *            domain model describing classes
	 * @return <
	 *         <UL>
	 *         <LI> <code>uri</code> if resource with this <code>uri</code> ,
	 *         i.e. this resource occurs as a subject of a any statement in
	 *         <code>mDomain</code>.
	 *         <LI> URI of <code>C</code>, if resource with this
	 *         <code>uri</code> does NOT belong do <code>mDomain</code> and
	 *         instance of resource (class) C, belonging do <code>mDomain</code>.
	 *         <LI> <code>null</code> -- otherwise.
	 *         </UL>
	 */
	public static Resource getReflection(Resource r, OntModel mDB, OntModel mDomain) {
		// TODO The idea of reflexion becomes illogical when the individual as
		// an instance of more then one type (class).
		
		if (mDomain.containsResource(r))
			// Associate resource with mDomain
			return (Resource) r.inModel(mDomain);

		// Check whether ontr is instance (individual) of some class...
		// Associate it for the test with mDB model
		r = (Resource) r.inModel(mDB);
		for (StmtIterator it = r.listProperties(RDF.type); it.hasNext();) {
			Resource clazz = it.nextStatement().getResource();
			// ...and this class belongs to domain ontology
			if (mDomain.containsResource(clazz)) {
				// Since clazz is object of rdf:type predicate, than it is
				// rdfs:Resource.
				// Associate it with mDomain.
				return (Resource) clazz.inModel(mDomain);
			}
		}

		// The value is undefined
		return null;

	}
	
	/**
	 * Translates <code>Map</code> object from <i>Messaging<i> ontology into
	 * Java <code>Map</code> form.
	 * 
	 * @param inMap
	 *            is Map object from the ontology
	 * @return Java Map form of <code>inMap</code>
	 */
	public static Map<String,String> getMap(ibspan.tss.messaging.ontology.Map inMap) {
		HashMap<String,String> outMap = new HashMap<String,String>();
		for(Iterator it = inMap.getAllHasEntry();it.hasNext();) {
			MapEntry entry = (MapEntry) it.next();
				outMap.put(entry.getKey(), entry.getValue());
		}
		return outMap;
	}
}
