

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
 * Implementation of {@link ibspan.tss.um.ontology.Profession}
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Profession)</p>
 * <br>
 */
public class ProfessionImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.um.ontology.Profession {
	


	ProfessionImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static ProfessionImpl getProfession(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,Profession.TYPE))
			return null;
		return new ProfessionImpl(resource, model);
	}
	    
	static ProfessionImpl createProfession(Resource resource, Model model) throws JastorException {
		ProfessionImpl impl = new ProfessionImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, Profession.TYPE)))
			impl._model.add(impl._resource, RDF.type, Profession.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsPensionerAnnuitant() throws JastorException {
	}

	void initAsStudentPupil() throws JastorException {
	}

	void initAsHandworker() throws JastorException {
	}

	void initAsAdvertisingMarketingWorker() throws JastorException {
	}

	void initAsUnemployedJobSeeker() throws JastorException {
	}

	void initAsManagerDirector() throws JastorException {
	}

	void initAsOtherProfession() throws JastorException {
	}

	void initAsScientistTeacher() throws JastorException {
	}

	void initAsServicesTradeWorker() throws JastorException {
	}

	void initAsSpecialistFreeLancer() throws JastorException {
	}
	
	void addSuperTypes() {
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Measure.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Measure.TYPE));     
		if (!_model.contains(_resource, RDF.type, ibspan.tss.um.ontology.Nominal.TYPE))
			_model.add(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(_resource, RDF.type, ibspan.tss.um.ontology.Nominal.TYPE));     
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Profession.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Measure.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.um.ontology.Nominal.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof ProfessionListener))
			throw new IllegalArgumentException("ThingListener must be instance of ProfessionListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((ProfessionListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof ProfessionListener))
			throw new IllegalArgumentException("ThingListener must be instance of ProfessionListener"); 
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