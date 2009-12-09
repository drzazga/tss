

package ibspan.tss.domain.ontology.money;

import com.ibm.adtech.jastor.*;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Factory for instantiating objects for ontology classes in the Money ontology.  The
 * get methods leave the model unchanged and return a Java view of the object in the model.  The create methods
 * may add certain baseline properties to the model such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Money)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Domain ontology of Money concept world in Travel Support System.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * Dublin Core Standard Properties <br>
 * 	creator : Maciej Gawinecki, e-mail: maciej.gawinecki@ibspan.waw.pl^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	title : Domain ontology of Money concept world in Travel Support System.^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	rights : (c) 2006 Maciej Gawinecki^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	identifier : http://www.ibspan.waw.pl/tss/Money^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	date : 2006-08-22^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 *	@version TODO: ^^http://www.w3.org/2001/XMLSchema#string
 */
public class MoneyFactory extends com.ibm.adtech.jastor.ThingFactory { 



	/**
	 * Create a new instance of MeanOfPayment.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the MeanOfPayment
	 * @param model the Jena Model.
	 */
	public static MeanOfPayment createMeanOfPayment(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.money.MeanOfPaymentImpl.createMeanOfPayment(resource,model);
	}
	
	/**
	 * Create a new instance of MeanOfPayment.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the MeanOfPayment
	 * @param model the Jena Model.
	 */
	public static MeanOfPayment createMeanOfPayment(String uri, Model model) throws JastorException {
		MeanOfPayment obj = ibspan.tss.domain.ontology.money.MeanOfPaymentImpl.createMeanOfPayment(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of MeanOfPayment.  Leaves the model unchanged.
	 * @param uri The uri of the MeanOfPayment
	 * @param model the Jena Model.
	 */
	public static MeanOfPayment getMeanOfPayment(String uri, Model model) throws JastorException {
		return getMeanOfPayment(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of MeanOfPayment.  Leaves the model unchanged.
	 * @param resource The resource of the MeanOfPayment
	 * @param model the Jena Model.
	 */
	public static MeanOfPayment getMeanOfPayment(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.money.MeanOfPayment.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.money.MeanOfPaymentImpl obj = (ibspan.tss.domain.ontology.money.MeanOfPaymentImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.money.MeanOfPaymentImpl.getMeanOfPayment(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an JCBCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getJCBCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.JCBCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsJCBCard();			
		}
		return obj;
	}
	/** 
	 * Get an DirectBill individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getDirectBill(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.DirectBill.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsDirectBill();			
		}
		return obj;
	}
	/** 
	 * Get an CarteBlancheCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getCarteBlancheCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.CarteBlancheCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsCarteBlancheCard();			
		}
		return obj;
	}
	/** 
	 * Get an ChargeCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getChargeCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.ChargeCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsChargeCard();			
		}
		return obj;
	}
	/** 
	 * Get an Barter individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getBarter(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.Barter.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsBarter();			
		}
		return obj;
	}
	/** 
	 * Get an Redemption individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getRedemption(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.Redemption.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsRedemption();			
		}
		return obj;
	}
	/** 
	 * Get an AmericanExpressCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getAmericanExpressCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.AmericanExpressCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsAmericanExpressCard();			
		}
		return obj;
	}
	/** 
	 * Get an MoneyOrder individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getMoneyOrder(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.MoneyOrder.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsMoneyOrder();			
		}
		return obj;
	}
	/** 
	 * Get an DiscoverCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getDiscoverCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.DiscoverCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsDiscoverCard();			
		}
		return obj;
	}
	/** 
	 * Get an BankCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getBankCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.BankCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsBankCard();			
		}
		return obj;
	}
	/** 
	 * Get an Deposit individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getDeposit(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.Deposit.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsDeposit();			
		}
		return obj;
	}
	/** 
	 * Get an VisaCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getVisaCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.VisaCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsVisaCard();			
		}
		return obj;
	}
	/** 
	 * Get an Voucher individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getVoucher(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.Voucher.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsVoucher();			
		}
		return obj;
	}
	/** 
	 * Get an CentralBill individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getCentralBill(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.CentralBill.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsCentralBill();			
		}
		return obj;
	}
	/** 
	 * Get an CreditCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getCreditCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.CreditCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsCreditCard();			
		}
		return obj;
	}
	/** 
	 * Get an PersonalCheck individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getPersonalCheck(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.PersonalCheck.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsPersonalCheck();			
		}
		return obj;
	}
	/** 
	 * Get an Coupon individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getCoupon(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.Coupon.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsCoupon();			
		}
		return obj;
	}
	/** 
	 * Get an DebitCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getDebitCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.DebitCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsDebitCard();			
		}
		return obj;
	}
	/** 
	 * Get an PrePay individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getPrePay(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.PrePay.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsPrePay();			
		}
		return obj;
	}
	/** 
	 * Get an Cash individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getCash(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.Cash.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsCash();			
		}
		return obj;
	}
	/** 
	 * Get an GiftCertificates individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getGiftCertificates(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.GiftCertificates.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsGiftCertificates();			
		}
		return obj;
	}
	/** 
	 * Get an BusinessCheck individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getBusinessCheck(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.BusinessCheck.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsBusinessCheck();			
		}
		return obj;
	}
	/** 
	 * Get an DinersClubCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getDinersClubCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.DinersClubCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsDinersClubCard();			
		}
		return obj;
	}
	/** 
	 * Get an BusinessAccount individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getBusinessAccount(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.BusinessAccount.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsBusinessAccount();			
		}
		return obj;
	}
	/** 
	 * Get an BankCheck individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getBankCheck(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.BankCheck.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsBankCheck();			
		}
		return obj;
	}
	/** 
	 * Get an MasterCardEuroCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getMasterCardEuroCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.MasterCardEuroCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsMasterCardEuroCard();			
		}
		return obj;
	}
	/** 
	 * Get an EnRouteCard individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of MeanOfPayment.
	 */
	public static MeanOfPayment getEnRouteCard(Model model) throws JastorException {
		Resource resource = model.createResource(MeanOfPayment.EnRouteCard.getURI());
		MeanOfPaymentImpl obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
		if (obj == null) {
			createMeanOfPayment(resource, model);
			obj = (MeanOfPaymentImpl)getMeanOfPayment(resource, model);
			obj.initAsEnRouteCard();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of MeanOfPayment for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Money#MeanOfPayment
	 * @param model the Jena Model
	 * @return a List of MeanOfPayment
	 */
	public static java.util.List getAllMeanOfPayment(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,MeanOfPayment.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getMeanOfPayment(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of FuzzyPriceCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the FuzzyPriceCode
	 * @param model the Jena Model.
	 */
	public static FuzzyPriceCode createFuzzyPriceCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.money.FuzzyPriceCodeImpl.createFuzzyPriceCode(resource,model);
	}
	
	/**
	 * Create a new instance of FuzzyPriceCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the FuzzyPriceCode
	 * @param model the Jena Model.
	 */
	public static FuzzyPriceCode createFuzzyPriceCode(String uri, Model model) throws JastorException {
		FuzzyPriceCode obj = ibspan.tss.domain.ontology.money.FuzzyPriceCodeImpl.createFuzzyPriceCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of FuzzyPriceCode.  Leaves the model unchanged.
	 * @param uri The uri of the FuzzyPriceCode
	 * @param model the Jena Model.
	 */
	public static FuzzyPriceCode getFuzzyPriceCode(String uri, Model model) throws JastorException {
		return getFuzzyPriceCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of FuzzyPriceCode.  Leaves the model unchanged.
	 * @param resource The resource of the FuzzyPriceCode
	 * @param model the Jena Model.
	 */
	public static FuzzyPriceCode getFuzzyPriceCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.money.FuzzyPriceCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.money.FuzzyPriceCodeImpl obj = (ibspan.tss.domain.ontology.money.FuzzyPriceCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.money.FuzzyPriceCodeImpl.getFuzzyPriceCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an Expensive individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FuzzyPriceCode.
	 */
	public static FuzzyPriceCode getExpensive(Model model) throws JastorException {
		Resource resource = model.createResource(FuzzyPriceCode.Expensive.getURI());
		FuzzyPriceCodeImpl obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
		if (obj == null) {
			createFuzzyPriceCode(resource, model);
			obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
			obj.initAsExpensive();			
		}
		return obj;
	}
	/** 
	 * Get an VeryExpensive individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FuzzyPriceCode.
	 */
	public static FuzzyPriceCode getVeryExpensive(Model model) throws JastorException {
		Resource resource = model.createResource(FuzzyPriceCode.VeryExpensive.getURI());
		FuzzyPriceCodeImpl obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
		if (obj == null) {
			createFuzzyPriceCode(resource, model);
			obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
			obj.initAsVeryExpensive();			
		}
		return obj;
	}
	/** 
	 * Get an Moderate individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FuzzyPriceCode.
	 */
	public static FuzzyPriceCode getModerate(Model model) throws JastorException {
		Resource resource = model.createResource(FuzzyPriceCode.Moderate.getURI());
		FuzzyPriceCodeImpl obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
		if (obj == null) {
			createFuzzyPriceCode(resource, model);
			obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
			obj.initAsModerate();			
		}
		return obj;
	}
	/** 
	 * Get an VeryCheap individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FuzzyPriceCode.
	 */
	public static FuzzyPriceCode getVeryCheap(Model model) throws JastorException {
		Resource resource = model.createResource(FuzzyPriceCode.VeryCheap.getURI());
		FuzzyPriceCodeImpl obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
		if (obj == null) {
			createFuzzyPriceCode(resource, model);
			obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
			obj.initAsVeryCheap();			
		}
		return obj;
	}
	/** 
	 * Get an Inexpensive individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FuzzyPriceCode.
	 */
	public static FuzzyPriceCode getInexpensive(Model model) throws JastorException {
		Resource resource = model.createResource(FuzzyPriceCode.Inexpensive.getURI());
		FuzzyPriceCodeImpl obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
		if (obj == null) {
			createFuzzyPriceCode(resource, model);
			obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
			obj.initAsInexpensive();			
		}
		return obj;
	}
	/** 
	 * Get an Price individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FuzzyPriceCode.
	 */
	public static FuzzyPriceCode getPrice(Model model) throws JastorException {
		Resource resource = model.createResource(FuzzyPriceCode.Price.getURI());
		FuzzyPriceCodeImpl obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
		if (obj == null) {
			createFuzzyPriceCode(resource, model);
			obj = (FuzzyPriceCodeImpl)getFuzzyPriceCode(resource, model);
			obj.initAsPrice();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of FuzzyPriceCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Money#FuzzyPriceCode
	 * @param model the Jena Model
	 * @return a List of FuzzyPriceCode
	 */
	public static java.util.List getAllFuzzyPriceCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,FuzzyPriceCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getFuzzyPriceCode(stmt.getSubject(),model));
		}
		return list;
	}
	
	
	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(com.hp.hpl.jena.rdf.model.Resource res, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Money#FuzzyPriceCode"))) {
			return getFuzzyPriceCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Money#MeanOfPayment"))) {
			return getMeanOfPayment(res,model);
		}
		return new ThingImpl(res,model);
	}
	
	/**
	 * Returns an instance of an interface for the given Resource URI.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 */
	public static Thing getThing(String uri, com.hp.hpl.jena.rdf.model.Model model) throws JastorException {
		return getThing(model.getResource(uri),model);
	}

	/**
	 * Return a list of compatible interfaces for the given type.  Searches through all ontology classes
	 * in the Money ontology.  The list is sorted according to the topological sort
	 * of the class hierarchy
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List listCompatibleInterfaces (com.hp.hpl.jena.rdf.model.Resource type) {
		java.util.List types = new java.util.ArrayList();
		if (type.equals(ibspan.tss.domain.ontology.money.FuzzyPriceCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.money.FuzzyPriceCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.money.MeanOfPayment.TYPE)) {
			types.add(ibspan.tss.domain.ontology.money.MeanOfPayment.class);
		}
		return types;
	}
}