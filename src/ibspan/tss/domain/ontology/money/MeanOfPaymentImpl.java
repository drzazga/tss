

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
 * Implementation of {@link ibspan.tss.domain.ontology.money.MeanOfPayment}
 * Use the ibspan.tss.domain.ontology.money.MoneyFactory to create instances of this class.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Money#MeanOfPayment)</p>
 * <br>
 */
public class MeanOfPaymentImpl extends com.ibm.adtech.jastor.ThingImpl implements ibspan.tss.domain.ontology.money.MeanOfPayment {
	


	MeanOfPaymentImpl(Resource resource, Model model) throws JastorException {
		super(resource, model);
		setupModelListener();
	}     
    	
	static MeanOfPaymentImpl getMeanOfPayment(Resource resource, Model model) throws JastorException {
		if (!model.contains(resource,RDF.type,MeanOfPayment.TYPE))
			return null;
		return new MeanOfPaymentImpl(resource, model);
	}
	    
	static MeanOfPaymentImpl createMeanOfPayment(Resource resource, Model model) throws JastorException {
		MeanOfPaymentImpl impl = new MeanOfPaymentImpl(resource, model);
		
		if (!impl._model.contains(new com.hp.hpl.jena.rdf.model.impl.StatementImpl(impl._resource, RDF.type, MeanOfPayment.TYPE)))
			impl._model.add(impl._resource, RDF.type, MeanOfPayment.TYPE);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	

	void initAsJCBCard() throws JastorException {
	}

	void initAsDirectBill() throws JastorException {
	}

	void initAsCarteBlancheCard() throws JastorException {
	}

	void initAsChargeCard() throws JastorException {
	}

	void initAsBarter() throws JastorException {
	}

	void initAsRedemption() throws JastorException {
	}

	void initAsAmericanExpressCard() throws JastorException {
	}

	void initAsMoneyOrder() throws JastorException {
	}

	void initAsDiscoverCard() throws JastorException {
	}

	void initAsBankCard() throws JastorException {
	}

	void initAsDeposit() throws JastorException {
	}

	void initAsVisaCard() throws JastorException {
	}

	void initAsVoucher() throws JastorException {
	}

	void initAsCentralBill() throws JastorException {
	}

	void initAsCreditCard() throws JastorException {
	}

	void initAsPersonalCheck() throws JastorException {
	}

	void initAsCoupon() throws JastorException {
	}

	void initAsDebitCard() throws JastorException {
	}

	void initAsPrePay() throws JastorException {
	}

	void initAsCash() throws JastorException {
	}

	void initAsGiftCertificates() throws JastorException {
	}

	void initAsBusinessCheck() throws JastorException {
	}

	void initAsDinersClubCard() throws JastorException {
	}

	void initAsBusinessAccount() throws JastorException {
	}

	void initAsBankCheck() throws JastorException {
	}

	void initAsMasterCardEuroCard() throws JastorException {
	}

	void initAsEnRouteCard() throws JastorException {
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
		it = _model.listStatements(_resource,RDF.type, ibspan.tss.domain.ontology.money.MeanOfPayment.TYPE);
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public void clearCache() {
	}
 


	private java.util.ArrayList listeners;
	
	public void registerListener(ThingListener listener) {
		if (!(listener instanceof MeanOfPaymentListener))
			throw new IllegalArgumentException("ThingListener must be instance of MeanOfPaymentListener"); 
		if (listeners == null)
			setupModelListener();
		if(!this.listeners.contains(listener)){
			this.listeners.add((MeanOfPaymentListener)listener);
		}
	}
	
	public void unregisterListener(ThingListener listener) {
		if (!(listener instanceof MeanOfPaymentListener))
			throw new IllegalArgumentException("ThingListener must be instance of MeanOfPaymentListener"); 
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