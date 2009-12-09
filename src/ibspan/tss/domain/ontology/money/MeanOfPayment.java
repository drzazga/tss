

package ibspan.tss.domain.ontology.money;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for MeanOfPayment ontology class<br>
 * Use the ibspan.tss.domain.ontology.money.MoneyFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Money#MeanOfPayment)</p>
 * <br>
 * <br>
 * <br>
 */
public interface MeanOfPayment extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#MeanOfPayment");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#JCBCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource JCBCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#JCBCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#DirectBill
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DirectBill = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#DirectBill");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#CarteBlancheCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CarteBlancheCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#CarteBlancheCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#ChargeCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ChargeCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#ChargeCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Barter
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Barter = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Barter");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Redemption
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Redemption = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Redemption");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#AmericanExpressCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AmericanExpressCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#AmericanExpressCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#MoneyOrder
	 */
	public static com.hp.hpl.jena.rdf.model.Resource MoneyOrder = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#MoneyOrder");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#DiscoverCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DiscoverCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#DiscoverCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#BankCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource BankCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#BankCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Deposit
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Deposit = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Deposit");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#VisaCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource VisaCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#VisaCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Voucher
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Voucher = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Voucher");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#CentralBill
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CentralBill = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#CentralBill");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#CreditCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource CreditCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#CreditCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#PersonalCheck
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PersonalCheck = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#PersonalCheck");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Coupon
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Coupon = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Coupon");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#DebitCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DebitCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#DebitCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#PrePay
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PrePay = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#PrePay");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#Cash
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Cash = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#Cash");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#GiftCertificates
	 */
	public static com.hp.hpl.jena.rdf.model.Resource GiftCertificates = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#GiftCertificates");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#BusinessCheck
	 */
	public static com.hp.hpl.jena.rdf.model.Resource BusinessCheck = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#BusinessCheck");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#DinersClubCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource DinersClubCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#DinersClubCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#BusinessAccount
	 */
	public static com.hp.hpl.jena.rdf.model.Resource BusinessAccount = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#BusinessAccount");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#BankCheck
	 */
	public static com.hp.hpl.jena.rdf.model.Resource BankCheck = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#BankCheck");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#MasterCardEuroCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource MasterCardEuroCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#MasterCardEuroCard");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/Money#EnRouteCard
	 */
	public static com.hp.hpl.jena.rdf.model.Resource EnRouteCard = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/Money#EnRouteCard");





}