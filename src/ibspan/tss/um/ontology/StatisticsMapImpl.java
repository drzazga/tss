

package ibspan.tss.um.ontology;

/*
import com.hp.hpl.jena.datatypes.xsd.*;
import com.hp.hpl.jena.datatypes.xsd.impl.*;
*/
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.rdf.listeners.StatementListener;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.*;
import com.ibm.adtech.jastor.util.*;


/**
 * Implementation of {@link ibspan.tss.um.ontology.StatisticsMap}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#StatisticsMap)</p>
 * <br>
 */
public class StatisticsMapImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.StatisticsMap {
	

	private static com.hp.hpl.jena.rdf.model.Property hasStatisticsEntryProperty = ResourceFactory.createProperty("http://www.ibspan.waw.pl/tss/UserModelling#hasStatisticsEntry");
	private java.util.ArrayList hasStatisticsEntry;

	StatisticsMapImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static StatisticsMapImpl getStatisticsMap(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,StatisticsMap.TYPE))
			return null;
		return new StatisticsMapImpl(resource, model);
	}
	    
	static StatisticsMapImpl createStatisticsMap(Resource resource, Model model) throws JastorException {
		StatisticsMapImpl impl = new StatisticsMapImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, StatisticsMap.TYPE)))
			impl._model.add(impl._resource, RDF.type, StatisticsMap.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.um.ontology.UserModellingFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,hasStatisticsEntryProperty,(RDFNode)null);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.StatisticsMap.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
		hasStatisticsEntry = null;
	}


	private void initHasStatisticsEntry() throws JastorException {
		this.hasStatisticsEntry = new java.util.ArrayList();
		StmtIterator it = _model.listStatements(_resource, hasStatisticsEntryProperty, (RDFNode)null);
		while(it.hasNext()) {
			com.hp.hpl.jena.rdf.model.Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)it.next();
			if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
				throw new JastorInvalidRDFNodeException (uri() + ": One of the http://www.ibspan.waw.pl/tss/UserModelling#hasStatisticsEntry properties in StatisticsMap model not a Resource", stmt.getObject());
			com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
			if (true) { // don't check resource type if the property range is Resource
				com.ibm.adtech.jastor.Thing hasStatisticsEntry = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
				this.hasStatisticsEntry.add(hasStatisticsEntry);
			}
		}
	}

	public java.util.Iterator getHasStatisticsEntry() throws JastorException {
		if (hasStatisticsEntry == null)
			initHasStatisticsEntry();
		return new com.ibm.adtech.jastor.util.CachedPropertyIterator(hasStatisticsEntry,_resource,hasStatisticsEntryProperty,true);
	}

	public void addHasStatisticsEntry(com.ibm.adtech.jastor.Thing hasStatisticsEntry) throws JastorException {
		if (this.hasStatisticsEntry == null)
			initHasStatisticsEntry();
		if (this.hasStatisticsEntry.contains(hasStatisticsEntry)) {
			this.hasStatisticsEntry.remove(hasStatisticsEntry);
			this.hasStatisticsEntry.add(hasStatisticsEntry);
			return;
		}
		this.hasStatisticsEntry.add(hasStatisticsEntry);
		_model.add(_model.createStatement(_resource,hasStatisticsEntryProperty,hasStatisticsEntry.resource()));
	}
	
	public com.ibm.adtech.jastor.Thing addHasStatisticsEntry() throws JastorException {
		com.ibm.adtech.jastor.Thing hasStatisticsEntry = com.ibm.adtech.jastor.ThingFactory.createThing(_model.createResource(),_model);
		if (this.hasStatisticsEntry == null)
			initHasStatisticsEntry();
		this.hasStatisticsEntry.add(hasStatisticsEntry);
		_model.add(_model.createStatement(_resource,hasStatisticsEntryProperty,hasStatisticsEntry.resource()));
		return hasStatisticsEntry;
	}
	
	public com.ibm.adtech.jastor.Thing addHasStatisticsEntry(com.hp.hpl.jena.rdf.model.Resource resource) throws JastorException {
		com.ibm.adtech.jastor.Thing hasStatisticsEntry = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
		if (this.hasStatisticsEntry == null)
			initHasStatisticsEntry();
		if (this.hasStatisticsEntry.contains(hasStatisticsEntry))
			return hasStatisticsEntry;
		this.hasStatisticsEntry.add(hasStatisticsEntry);
		_model.add(_model.createStatement(_resource,hasStatisticsEntryProperty,hasStatisticsEntry.resource()));
		return hasStatisticsEntry;
	}
	
	public void removeHasStatisticsEntry(com.ibm.adtech.jastor.Thing hasStatisticsEntry) throws JastorException {
		if (this.hasStatisticsEntry == null)
			initHasStatisticsEntry();
		if (!this.hasStatisticsEntry.contains(hasStatisticsEntry))
			return;
		if (!_model.contains(_resource, hasStatisticsEntryProperty, hasStatisticsEntry.resource()))
			return;
		this.hasStatisticsEntry.remove(hasStatisticsEntry);
		_model.removeAll(_resource, hasStatisticsEntryProperty, hasStatisticsEntry.resource());
	}
		  


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof StatisticsMapListener))
			throw new IllegalArgumentException("ThingListener must be instance of StatisticsMapListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((StatisticsMapListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof StatisticsMapListener))
			throw new IllegalArgumentException("ThingListener must be instance of StatisticsMapListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

			if (stmt.getPredicate().equals(hasStatisticsEntryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					com.ibm.adtech.jastor.Thing _hasStatisticsEntry = null;
					try {
						_hasStatisticsEntry = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
					} catch (JastorException e) {
						//e.printStackTrace();
					}
					if (hasStatisticsEntry == null) {
						try {
							initHasStatisticsEntry();
						} catch (JastorException e) {
							e.printStackTrace();
							return;
						}
					}
					if (!hasStatisticsEntry.contains(_hasStatisticsEntry))
						hasStatisticsEntry.add(_hasStatisticsEntry);
					if (listeners != null) {
						java.util.ArrayList consumersForHasStatisticsEntry;
						synchronized (listeners) {
							consumersForHasStatisticsEntry = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasStatisticsEntry.iterator();iter.hasNext();){
							StatisticsMapListener listener=(StatisticsMapListener)iter.next();
							listener.hasStatisticsEntryAdded(ibspan.tss.um.ontology.StatisticsMapImpl.this,_hasStatisticsEntry);
						}
					}
				}
				return;
			}
		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
			if (stmt.getPredicate().equals(hasStatisticsEntryProperty)) {
				if (!stmt.getObject().canAs(com.hp.hpl.jena.rdf.model.Resource.class))
					return;
				com.hp.hpl.jena.rdf.model.Resource resource = (com.hp.hpl.jena.rdf.model.Resource) stmt.getObject().as(com.hp.hpl.jena.rdf.model.Resource.class);
				if (true) { // don't check resource type if the property range is Resource
					com.ibm.adtech.jastor.Thing _hasStatisticsEntry = null;
					if (hasStatisticsEntry != null) {
						boolean found = false;
						for (int i=0;i<hasStatisticsEntry.size();i++) {
							com.ibm.adtech.jastor.Thing __item = (com.ibm.adtech.jastor.Thing) hasStatisticsEntry.get(i);
							if (__item.resource().equals(resource)) {
								found = true;
								_hasStatisticsEntry = __item;
								break;
							}
						}
						if (found)
							hasStatisticsEntry.remove(_hasStatisticsEntry);
						else {
							try {
								_hasStatisticsEntry = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
							} catch (JastorException e) {
							}
						}
					} else {
						try {
							_hasStatisticsEntry = com.ibm.adtech.jastor.ThingFactory.getThing(resource,_model);
						} catch (JastorException e) {
						}
					}
					if (listeners != null) {
						java.util.ArrayList consumersForHasStatisticsEntry;
						synchronized (listeners) {
							consumersForHasStatisticsEntry = (java.util.ArrayList) listeners.clone();
						}
						for(java.util.Iterator iter=consumersForHasStatisticsEntry.iterator();iter.hasNext();){
							StatisticsMapListener listener=(StatisticsMapListener)iter.next();
							listener.hasStatisticsEntryRemoved(ibspan.tss.um.ontology.StatisticsMapImpl.this,_hasStatisticsEntry);
						}
					}
				}
				return;
			}
		}

	//}
	


}