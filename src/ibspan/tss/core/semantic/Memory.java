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

import ibspan.tss.messaging.ontology.OWLData;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.ibm.adtech.jastor.Thing;

/**
 * This class provides a set of methods for transparent operating on Jena
 * memory-based model.
 * 
 * <p>
 * Examples say more then thousand of words:
 * 
 * <UL>
 * <LI><code>Memory mem = new Memory();</code>
 * <LI><code>Memory mem = new Memory(rdfString);</code>
 * <LI><code>Memory mem = new Memory(someModel);</code>
 * <LI><code>Memory mem = new Memory(someThing);</code>
 * <LI><code>mem.addThing(otherThing);</code>
 * <LI><code>String otherString = mem.dump();</code>
 * <li><code>OWLData data = mem.buildOWLData()</code>
 * </UL>
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * @author <a href="mailto:michal.laclavik@savba.sk">Michal Laclavik</a>
 * 
 * @see OntModel
 * @see Thing
 * @see OWLData
 */
public class Memory {

	/**
	 * Default serialization language.
	 */
	public static final String DEFAULT_LANG = "RDF/XML-ABBREV";

	/**
	 * Default base namespace URI.
	 */
	public static final String DEFAULT_BASE_NS = null;

	private OntModel _model;

	/**
	 * List of resource which are considered as roots, e.g. results of search in
	 * model; This makes retrieving them in a model easier.
	 */
	private List<String> roots = new ArrayList<String>();

	/**
	 * Creates <code>Memory</code> with empy model.
	 */
	public Memory() {
		_model = createDefaultOntModel();
	}

	/**
	 * Creates <code>Memory</code> object with model with RDF statements
	 * represented in language <code>DEFAULT_LANG</code>.
	 * 
	 * @param rdf
	 *            the source input of the input serialization.
	 * 
	 * @see DEFAULT_LANG
	 */
	public Memory(String rdf) {
		_model = rdf2model(rdf);
	}

	/**
	 * Creates <code>Memory</code> object with model including RDF statements
	 * represented in language <code>DEFAULT_LANG</code>.
	 * 
	 * @param rdf
	 *            the source input of the input serialization.
	 * @param base
	 *            the base uri to be used when converting relative URI's to
	 *            absolute URI's. The base URI may be null if there are no
	 *            relative URIs to convert. A base URI of "" may permit relative
	 *            URIs to be used in the model.
	 */
	public Memory(String rdf, String base) {
		_model = rdf2model(rdf, base);
	}

	/**
	 * Creates <code>Memory</code> object with given model.
	 * 
	 * @param model
	 *            existing model.
	 */
	public Memory(OntModel model) {
		_model = model;
	}

	public Memory(final Thing thing) {
		_model = createDefaultOntModel();
		
		add(thing);
	}
	

	
	/**
	 * Creates <code>Memory</code> object with model including resource of
	 * given Thing.
	 * 
	 * @param model
	 *            existing model.
	 * @throws AnonymousResourceException 
	 */
	public Memory(final Thing thing, boolean asRoot) throws AnonymousResourceException {
		_model = createDefaultOntModel();
		if (asRoot)
			addRoot(thing);
		else
			add(thing);
	}
	
	public void registerRoot(Thing root) throws AnonymousResourceException {
		registerRoot(root.resource());
	}
	

	public void registerRoot(Resource root) throws AnonymousResourceException {
		if (root.isAnon())
			throw new AnonymousResourceException("Anonymous resource cannot be root.");
		roots.add(root.getURI());
	}
	
	private void registerRoot(String rootURI) {
		roots.add(rootURI);
	}
	
	private void registerRoots(List roots) {
		for(Iterator it = roots.iterator(); it.hasNext(); ) 
			registerRoot((String)it.next());
	}
	
	private void registerRoots(jade.util.leap.List roots) {
		for(Iterator it = roots.iterator(); it.hasNext(); ) 
			registerRoot((String)it.next());
	}
	
	private void deregisterRoot(Resource root) throws AnonymousResourceException {
		if (root.isAnon())
			throw new AnonymousResourceException("This is anonymous resource.");
		else
			// It is URI resource
			roots.remove(root.getURI());
	}
	
	/**
	 * 
	 * @param data
	 */
	public Memory(final OWLData data) {
		_model = rdf2model(data.getDataModel(), DEFAULT_BASE_NS, data.getSyntaxLanguage());
		registerRoots( data.getWithRootURI());
	}
	
	public void add(OWLData data) {
		_model.add(rdf2model(data.getDataModel(), DEFAULT_BASE_NS, data.getSyntaxLanguage()));
		registerRoots( data.getWithRootURI());
	}
	
	public void add(Memory mem) {		
		_model.add(mem._model);
		registerRoots(mem.roots);
	}	
	
	/**
	 * Returns internal model.
	 * 
	 * @return this model.
	 */
	public OntModel getModel() {
		return _model;
	}
	
	public void add(OntModel newModel) {
		_model.add(newModel);		
	}

	/**
	 * Returns a serialized represention of the internal model in a language
	 * <code>DEFAULT_LANG</code>. 
	 * 
	 * @return serialized representation
	 * 
	 * @see DEFAULT_LANG
	 */
	public String dump() {
		return model2rdf(_model);
	}



	/**
	 * Remembers <code>thing</code> in memory and registers it as one of the
	 * roots.
	 * 
	 * More precisely, copies resource of <code>thing</code> into internal
	 * model.
	 * 
	 * @param thing
	 *            given thing
	 * @throws AnonymousResourceException 
	 * 
	 */
	public void add(Thing thing) {
		add(thing.resource());
	}
	
	/**
	 * Remembers <code>thing</code> in memory and registers it as one of the
	 * roots.
	 * 
	 * More precisely, copies resource of <code>thing</code> into internal
	 * model.
	 * 
	 * @param thing
	 *            given thing
	 * @throws AnonymousResourceException 
	 * 
	 */
	public void addRoot(Thing thing) throws AnonymousResourceException {
		// register as root
		registerRoot(thing.resource());
		add(thing);
	}

	/**
	 * Creates OWLData containing internal model of this Memory object.
	 * 
	 * Syntax language will be set to the value of {@link DEFAULT_LANG} and all
	 * resources registered as roots will be added as values of
	 * <code>withRootURI</code> property of OWLData object.
	 * 
	 * @return OWLData representing content of this memory
	 */
	public OWLData buildOWLData() {
		OWLData owl = new OWLData();

		owl.setDataModel(dump());
		owl.setSyntaxLanguage(DEFAULT_LANG);
		
		for (Iterator<String> it = roots.iterator(); it.hasNext();)
			owl.addWithRootURI(it.next());

		return owl;
	}

	/**
	 * 
	 * Creates a copy of given resource if it is not there
	 * 
	 * @param r
	 */
	public Resource add(Resource r) {
		return addProperties(r);
	}

	/**
	 * Creates and returns anonymous resource in the memory.
	 * 
	 * @return creates resource
	 */
	public Resource createAnonResource() {
		return _model.createResource();
	}

	/**
	 * Answer a new ontology model which will process in-memory models of
	 * ontologies expressed the default ontology language (OWL).
	 * 
	 * @return a new ontology model.
	 */
	public static OntModel createDefaultOntModel() {
		return ModelFactory.createOntologyModel();
	}

	/**
	 * Returns a serialized represention of a model in a language
	 * <code>DEFAULT_LANG<code>. 
	 * 
	 * @param model the source model of the output serialization.
	 * @return serialized representation
	 * 
	 * @see DEFAULT_LANG
	 */
	protected static String model2rdf(OntModel model) {
		return model2rdf(model, DEFAULT_LANG);
	}

	/**
	 * Returns a serialized represention of a model in a language
	 * <code>lang<code>. 
	 * 
	 * @param model the source model of the output serialization.
	 * @param lang the language in which the RDF should be serialized
	 * @return serialized representation.
	 *
	 */
	protected static String model2rdf(OntModel model, String lang) {
		return model2rdf(model, lang, DEFAULT_BASE_NS);
	}

	/**
	 * Returns a serialized represention of a model in a language
	 * <code>DEFAULT_LANG<code>. 
	 * 
	 * @param model 
	 *           the source model of the output serialization.
	 * @param lang 
	 * the language in which the RDF should be serialized
	 * @param base the base uri for relative URI calculations; <code>null<code> means use only absolute URI's.
	 * @return serialized representation
	 *
	 */
	protected static String model2rdf(OntModel model, String lang, String base) {
		String rdf = "";

		StringWriter writer = new StringWriter();
		model.write(writer, DEFAULT_LANG, base);
		
		rdf = writer.getBuffer().toString();

		return rdf;
	}

	/**
	 * Add RDF statements represented in language <code>DEFAULT_LANG</code> to
	 * the model.
	 * 
	 * @param rdf
	 *            the source input of the input serialization.
	 * @return newly serialiazed model.
	 * 
	 * @see DEFAULT_LANG
	 */
	protected static OntModel rdf2model(String rdf) {
		return rdf2model(rdf, DEFAULT_BASE_NS);
	}

	/**
	 * Add RDF statements represented in language <code>DEFAULT_LANG</code> to
	 * the model.
	 * 
	 * @param rdf
	 *            the source input of the input serialization.
	 * @param base
	 *            the base uri to be used when converting relative URI's to
	 *            absolute URI's. The base URI may be <cod>null</code> if there
	 *            are no relative URIs to convert. A base URI of "" may permit
	 *            relative URIs to be used in the model.
	 * @return newly serialiazed model.
	 * 
	 * @see DEFAULT_LANG
	 */
	protected static OntModel rdf2model(String rdf, String base) {
		return rdf2model(rdf, base, DEFAULT_LANG);
	}

	/**
	 * Add RDF statements represented in language <code>lang</code> to the
	 * model.
	 * 
	 * @param rdf
	 *            the source input of the input serialization.
	 * @param base
	 *            the base uri to be used when converting relative URI's to
	 *            absolute URI's. The base URI may be <cod>null</code> if there
	 *            are no relative URIs to convert. A base URI of "" may permit
	 *            relative URIs to be used in the model.
	 * @param lang
	 *            the langauge of the serialization; <code>null</code> selects
	 *            the default.
	 * @return newly serialiazed model.
	 */
	protected static OntModel rdf2model(String rdf, String base, String lang) {
		OntModel model = createDefaultOntModel();
		model.read(new StringReader(rdf), base, lang);
		return model;

	}

	/**
	 * Recursive method which copy resource with all properties recursively into
	 * memory.
	 * 
	 * @param r
	 *            resource which properties should be added
	 * @return reference to copy of the resource in memory
	 * 
	 */
	public Resource addProperties(Resource root) {
		List<Resource> visitedRoots = new ArrayList<Resource>();
		Model base;
		if (root.canAs(OntResource.class)) {
			OntResource ontr = (OntResource)root.as(OntResource.class);
			base = ontr.getOntModel();
		} else {
			base = root.getModel();
		}
		addProperties(root, base, visitedRoots);
		return base.getResource(root.getURI());
	}

	private void addProperties(Resource root, Model base, List<Resource> visitedRoots) {
		_model.add(root.listProperties());
		visitedRoots.add(root);
		StmtIterator si = base.listStatements(root, (Property) null, (RDFNode) null);

		while (si.hasNext()) {
			Statement s = si.nextStatement();
			RDFNode nextRoot = s.getObject();
			if (nextRoot instanceof Resource
					&& !visitedRoots.contains(nextRoot))
				addProperties((Resource) nextRoot, base, visitedRoots);
		}
	}


	private void removeProperties(Resource root, List<Resource> visitedRoots) {
		visitedRoots.add(root);
		StmtIterator si = root.listProperties();
		while (si.hasNext()) {
			Statement s = si.nextStatement();
			RDFNode nextRoot = s.getObject();
			if (nextRoot instanceof Resource
					&& !visitedRoots.contains(nextRoot))
				removeProperties((Resource) nextRoot, visitedRoots);
			s.remove();
		}
	}

	/**
	 * Recursive method which remove resource with all properties recursively
	 * from the memory. Notice, that also nodes shared with other
	 * roots-subgraphs are remove.
	 * 
	 * @param root
	 *            resource which properties should be removed
	 * 
	 */
	public void removeProperties(Thing root) {
		List<Resource> visitedRoots = new ArrayList<Resource>();
		removeProperties(root.resource(), visitedRoots);
		root.resource().removeProperties();
	}

	/**
	 * Removes thing and related properties from memory. Unregisters it from
	 * list of root things, if it was registered. Notice, that also nodes shared
	 * with other roots-subgraphs are remove.
	 * 
	 * @param thing
	 *            thing to be removed
	 * @throws AnonymousResourceException
	 */
	public void removeThing(Thing thing) throws AnonymousResourceException {
		removeProperties(thing);
		if (roots.contains(thing.resource()))
			deregisterRoot(thing.resource());

	}

	
}
