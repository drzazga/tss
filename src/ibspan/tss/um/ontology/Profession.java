

package ibspan.tss.um.ontology;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Profession ontology class<br>
 * Use the ibspan.tss.um.ontology.UserModellingFactory to create instances of this interface.
 * <p>(URI: http://www.ibspan.waw.pl/tss/UserModelling#Profession)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Express profession of a person.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * <br>
 */
public interface Profession extends ibspan.tss.um.ontology.Nominal, com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Profession");
	


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#PensionerAnnuitant
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PensionerAnnuitant = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#PensionerAnnuitant");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#StudentPupil
	 */
	public static com.hp.hpl.jena.rdf.model.Resource StudentPupil = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#StudentPupil");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#Handworker
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Handworker = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#Handworker");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#AdvertisingMarketingWorker
	 */
	public static com.hp.hpl.jena.rdf.model.Resource AdvertisingMarketingWorker = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#AdvertisingMarketingWorker");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#UnemployedJobSeeker
	 */
	public static com.hp.hpl.jena.rdf.model.Resource UnemployedJobSeeker = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#UnemployedJobSeeker");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#ManagerDirector
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ManagerDirector = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ManagerDirector");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#OtherProfession
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OtherProfession = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#OtherProfession");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#ScientistTeacher
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ScientistTeacher = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ScientistTeacher");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#ServicesTradeWorker
	 */
	public static com.hp.hpl.jena.rdf.model.Resource ServicesTradeWorker = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#ServicesTradeWorker");


	/**
	 * Individual for URI: http://www.ibspan.waw.pl/tss/UserModelling#SpecialistFreeLancer
	 */
	public static com.hp.hpl.jena.rdf.model.Resource SpecialistFreeLancer = ResourceFactory.createResource("http://www.ibspan.waw.pl/tss/UserModelling#SpecialistFreeLancer");





}