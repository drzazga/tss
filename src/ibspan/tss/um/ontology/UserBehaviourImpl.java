

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
 * Implementation of {@link ibspan.tss.um.ontology.UserBehaviour}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#UserBehaviour)</p>
 * <br>
 */
public class UserBehaviourImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.UserBehaviour {
	


	UserBehaviourImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static UserBehaviourImpl getUserBehaviour(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,UserBehaviour.TYPE))
			return null;
		return new UserBehaviourImpl(resource, model);
	}
	    
	static UserBehaviourImpl createUserBehaviour(Resource resource, Model model) throws JastorException {
		UserBehaviourImpl impl = new UserBehaviourImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, UserBehaviour.TYPE)))
			impl._model.add(impl._resource, RDF.type, UserBehaviour.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsExitSearchingBehaviour() throws JastorException {
	}

	void initAsQueryForRestaurantBehaviour() throws JastorException {
	}

	void initAsClickForRestaurantDetailsBehaviour() throws JastorException {
	}

	void initAsRateRestaurantPositiveBehaviour() throws JastorException {
	}

	void initAsEntrySearchingBehaviour() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.UserBehaviour.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof UserBehaviourListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserBehaviourListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((UserBehaviourListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof UserBehaviourListener))
			throw new IllegalArgumentException("ThingListener must be instance of UserBehaviourListener"); 
		if (listeners == null)
			return;
		if (this.listeners.contains(listener)){
			listeners.remove(listener);
		}
	}



	
		public void addedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {

		}
		
		public void removedStatement(com.hp.hpl.jena.rdf.model.Statement stmt) {
//			if (!stmt.getSubject().equals(_resource))
//				return;
		}

	//}
	


}