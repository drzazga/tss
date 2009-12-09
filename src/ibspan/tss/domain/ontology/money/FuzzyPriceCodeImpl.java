

package ibspan.tss.domain.ontology.money;

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
 * Implementation of {@link ibspan.tss.domain.ontology.money.FuzzyPriceCode}
 * Use the ibspan.tss.domain.ontology.money.MoneyFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Money#FuzzyPriceCode)</p>
 * <br>
 */
public class FuzzyPriceCodeImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.money.FuzzyPriceCode {
	


	FuzzyPriceCodeImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static FuzzyPriceCodeImpl getFuzzyPriceCode(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,FuzzyPriceCode.TYPE))
			return null;
		return new FuzzyPriceCodeImpl(resource, model);
	}
	    
	static FuzzyPriceCodeImpl createFuzzyPriceCode(Resource resource, Model model) throws JastorException {
		FuzzyPriceCodeImpl impl = new FuzzyPriceCodeImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, FuzzyPriceCode.TYPE)))
			impl._model.add(impl._resource, RDF.type, FuzzyPriceCode.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsExpensive() throws JastorException {
	}

	void initAsVeryExpensive() throws JastorException {
	}

	void initAsModerate() throws JastorException {
	}

	void initAsVeryCheap() throws JastorException {
	}

	void initAsInexpensive() throws JastorException {
	}

	void initAsPrice() throws JastorException {
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
    
    private void setupModelListener() {
    	listeners = new java.util.ArrayList();
    	ibspan.tss.domain.ontology.money.MoneyFactory.registerThing(this);
    }

	public java.util.List listStatements() {
		java.util.List list = new java.util.ArrayList();
		StmtIterator it = null;
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.money.FuzzyPriceCode.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof FuzzyPriceCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of FuzzyPriceCodeListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((FuzzyPriceCodeListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof FuzzyPriceCodeListener))
			throw new IllegalArgumentException("ThingListener must be instance of FuzzyPriceCodeListener"); 
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