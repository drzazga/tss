

package ibspan.tss.domain.ontology.restaurant;

import com.ibm.adtech.jastor.*;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Factory for instantiating objects for ontology classes in the Restaurant ontology.  The
 * get methods leave the model unchanged and return a Java view of the object in the model.  The create methods
 * may add certain baseline properties to the model such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.ibspan.waw.pl/tss/Restaurant)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Domain ontology of Restaurant world in Travel Support System.^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 * Dublin Core Standard Properties <br>
 * 	creator : Maciej Gawinecki, e-mail: maciej.gawinecki@ibspan.waw.pl^^http://www.w3.org/2001/XMLSchema#string, Michal Szymczak^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	title : Domain ontology of Restaurant world in Travel Support System.^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	rights : Chef Moz License: 
http://chefmoz.org/license.html

No Warranty/Use At Your Risk. 

THE CHEF MOZ AND ANY NETSCAPE TRADEMARKS AND LOGOS CONTAINED WITH THE REQUIRED 
ATTRIBUTION STATEMENTS ARE MADE AVAILABLE UNDER THIS CHEF MOZ LICENSE AT 
NO CHARGE. ACCORDINGLY, THE CHEF MOZ AND THE NETSCAPE TRADEMARKS AND LOGOS 
ARE PROVIDED `AS IS,' WITHOUT WARRANTY OF ANY KIND, INCLUDING WITHOUT 
LIMITATION THE WARRANTIES THAT THEY ARE MERCHANTABLE, FIT FOR A PARTICULAR 
PURPOSE OR NON-INFRINGING. YOU ARE SOLELY RESPONSIBLE FOR YOUR USE, 
DISTRIBUTION, MODIFICATION, REPRODUCTION AND PUBLICATION OF CHEF MOZ AND 
ANY DERIVATIVE WORKS THEREOF BY YOU AND ANY OF YOUR SUBLICENSEES 
(COLLECTIVELY, `YOUR CHEF MOZ USE'). THE ENTIRE RISK AS TO YOUR CHEF MOZ 
USE IS BORNE BY YOU. YOU AGREE TO INDEMNIFY AND HOLD NETSCAPE, ITS 
SUBSIDIARIES AND AFFILIATES HARMLESS FROM ANY CLAIMS ARISING FROM OR 
RELATING TO YOUR CHEF MOZ USE. 

Limitation of Liability. 

IN NO EVENT SHALL NETSCAPE, ITS SUBSIDIARIES OR AFFILIATES, OR THE CHEF MOZ 
CONTRIBUTING EDITORS, BE LIABLE FOR ANY INDIRECT, SPECIAL, INCIDENTAL OR 
CONSEQUENTIAL DAMAGES, INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF 
GOODWILL OR ANY AND ALL OTHER COMMERCIAL DAMAGES OR LOSSES, EVEN IF 
ADVISED OF THE POSSIBILITY THEREOF, AND REGARDLESS OF WHETHER ANY CLAIM IS 
BASED UPON ANY CONTRACT, TORT OR OTHER LEGAL OR EQUITABLE THEORY, RELATING 
OR ARISING FROM CHEF MOZ, YOUR CHEF MOZ USE OR THIS CHEF MOZ LICENSE 
AGREEMENT.
^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	identifier : http://www.ibspan.waw.pl/tss/Restaurant^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	source : Mainly Chefmoz Dining Guide [http://chefmoz.org/]^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	date : 2006-08-22^^http://www.w3.org/2001/XMLSchema#string <br>
 * 	language : EN^^http://www.w3.org/2001/XMLSchema#string <br>
 * <br>
 *	@version TODO: Add rdfs:label and rdfs:comment properties to description of classes.^^http://www.w3.org/2001/XMLSchema#string
 */
public class RestaurantFactory extends com.ibm.adtech.jastor.ThingFactory { 



	/**
	 * Create a new instance of DressCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the DressCode
	 * @param model the Jena Model.
	 */
	public static DressCode createDressCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.DressCodeImpl.createDressCode(resource,model);
	}
	
	/**
	 * Create a new instance of DressCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the DressCode
	 * @param model the Jena Model.
	 */
	public static DressCode createDressCode(String uri, Model model) throws JastorException {
		DressCode obj = ibspan.tss.domain.ontology.restaurant.DressCodeImpl.createDressCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of DressCode.  Leaves the model unchanged.
	 * @param uri The uri of the DressCode
	 * @param model the Jena Model.
	 */
	public static DressCode getDressCode(String uri, Model model) throws JastorException {
		return getDressCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of DressCode.  Leaves the model unchanged.
	 * @param resource The resource of the DressCode
	 * @param model the Jena Model.
	 */
	public static DressCode getDressCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.DressCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.DressCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.DressCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.DressCodeImpl.getDressCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an FormalDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of DressCode.
	 */
	public static DressCode getFormalDress(Model model) throws JastorException {
		Resource resource = model.createResource(DressCode.FormalDress.getURI());
		DressCodeImpl obj = (DressCodeImpl)getDressCode(resource, model);
		if (obj == null) {
			createDressCode(resource, model);
			obj = (DressCodeImpl)getDressCode(resource, model);
			obj.initAsFormalDress();			
		}
		return obj;
	}
	/** 
	 * Get an DressyCasualDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of DressCode.
	 */
	public static DressCode getDressyCasualDress(Model model) throws JastorException {
		Resource resource = model.createResource(DressCode.DressyCasualDress.getURI());
		DressCodeImpl obj = (DressCodeImpl)getDressCode(resource, model);
		if (obj == null) {
			createDressCode(resource, model);
			obj = (DressCodeImpl)getDressCode(resource, model);
			obj.initAsDressyCasualDress();			
		}
		return obj;
	}
	/** 
	 * Get an CasualDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of DressCode.
	 */
	public static DressCode getCasualDress(Model model) throws JastorException {
		Resource resource = model.createResource(DressCode.CasualDress.getURI());
		DressCodeImpl obj = (DressCodeImpl)getDressCode(resource, model);
		if (obj == null) {
			createDressCode(resource, model);
			obj = (DressCodeImpl)getDressCode(resource, model);
			obj.initAsCasualDress();			
		}
		return obj;
	}
	/** 
	 * Get an FormalRequiredDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of DressCode.
	 */
	public static DressCode getFormalRequiredDress(Model model) throws JastorException {
		Resource resource = model.createResource(DressCode.FormalRequiredDress.getURI());
		DressCodeImpl obj = (DressCodeImpl)getDressCode(resource, model);
		if (obj == null) {
			createDressCode(resource, model);
			obj = (DressCodeImpl)getDressCode(resource, model);
			obj.initAsFormalRequiredDress();			
		}
		return obj;
	}
	/** 
	 * Get an UnknownDress individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of DressCode.
	 */
	public static DressCode getUnknownDress(Model model) throws JastorException {
		Resource resource = model.createResource(DressCode.UnknownDress.getURI());
		DressCodeImpl obj = (DressCodeImpl)getDressCode(resource, model);
		if (obj == null) {
			createDressCode(resource, model);
			obj = (DressCodeImpl)getDressCode(resource, model);
			obj.initAsUnknownDress();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of DressCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#DressCode
	 * @param model the Jena Model
	 * @return a List of DressCode
	 */
	public static java.util.List getAllDressCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,DressCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getDressCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of AccessibilityCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the AccessibilityCode
	 * @param model the Jena Model.
	 */
	public static AccessibilityCode createAccessibilityCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.AccessibilityCodeImpl.createAccessibilityCode(resource,model);
	}
	
	/**
	 * Create a new instance of AccessibilityCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the AccessibilityCode
	 * @param model the Jena Model.
	 */
	public static AccessibilityCode createAccessibilityCode(String uri, Model model) throws JastorException {
		AccessibilityCode obj = ibspan.tss.domain.ontology.restaurant.AccessibilityCodeImpl.createAccessibilityCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of AccessibilityCode.  Leaves the model unchanged.
	 * @param uri The uri of the AccessibilityCode
	 * @param model the Jena Model.
	 */
	public static AccessibilityCode getAccessibilityCode(String uri, Model model) throws JastorException {
		return getAccessibilityCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of AccessibilityCode.  Leaves the model unchanged.
	 * @param resource The resource of the AccessibilityCode
	 * @param model the Jena Model.
	 */
	public static AccessibilityCode getAccessibilityCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.AccessibilityCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.AccessibilityCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.AccessibilityCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.AccessibilityCodeImpl.getAccessibilityCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an PartiallyAccessible individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AccessibilityCode.
	 */
	public static AccessibilityCode getPartiallyAccessible(Model model) throws JastorException {
		Resource resource = model.createResource(AccessibilityCode.PartiallyAccessible.getURI());
		AccessibilityCodeImpl obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
		if (obj == null) {
			createAccessibilityCode(resource, model);
			obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
			obj.initAsPartiallyAccessible();			
		}
		return obj;
	}
	/** 
	 * Get an CompletelyAccesible individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AccessibilityCode.
	 */
	public static AccessibilityCode getCompletelyAccesible(Model model) throws JastorException {
		Resource resource = model.createResource(AccessibilityCode.CompletelyAccesible.getURI());
		AccessibilityCodeImpl obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
		if (obj == null) {
			createAccessibilityCode(resource, model);
			obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
			obj.initAsCompletelyAccesible();			
		}
		return obj;
	}
	/** 
	 * Get an UnknownAccessible individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AccessibilityCode.
	 */
	public static AccessibilityCode getUnknownAccessible(Model model) throws JastorException {
		Resource resource = model.createResource(AccessibilityCode.UnknownAccessible.getURI());
		AccessibilityCodeImpl obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
		if (obj == null) {
			createAccessibilityCode(resource, model);
			obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
			obj.initAsUnknownAccessible();			
		}
		return obj;
	}
	/** 
	 * Get an NotAccessible individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AccessibilityCode.
	 */
	public static AccessibilityCode getNotAccessible(Model model) throws JastorException {
		Resource resource = model.createResource(AccessibilityCode.NotAccessible.getURI());
		AccessibilityCodeImpl obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
		if (obj == null) {
			createAccessibilityCode(resource, model);
			obj = (AccessibilityCodeImpl)getAccessibilityCode(resource, model);
			obj.initAsNotAccessible();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of AccessibilityCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#AccessibilityCode
	 * @param model the Jena Model
	 * @return a List of AccessibilityCode
	 */
	public static java.util.List getAllAccessibilityCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,AccessibilityCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getAccessibilityCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of DinerReview.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the DinerReview
	 * @param model the Jena Model.
	 */
	public static DinerReview createDinerReview(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.DinerReviewImpl.createDinerReview(resource,model);
	}
	
	/**
	 * Create a new instance of DinerReview.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the DinerReview
	 * @param model the Jena Model.
	 */
	public static DinerReview createDinerReview(String uri, Model model) throws JastorException {
		DinerReview obj = ibspan.tss.domain.ontology.restaurant.DinerReviewImpl.createDinerReview(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of DinerReview.  Leaves the model unchanged.
	 * @param uri The uri of the DinerReview
	 * @param model the Jena Model.
	 */
	public static DinerReview getDinerReview(String uri, Model model) throws JastorException {
		return getDinerReview(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of DinerReview.  Leaves the model unchanged.
	 * @param resource The resource of the DinerReview
	 * @param model the Jena Model.
	 */
	public static DinerReview getDinerReview(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.DinerReview.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.DinerReviewImpl obj = (ibspan.tss.domain.ontology.restaurant.DinerReviewImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.DinerReviewImpl.getDinerReview(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of DinerReview for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#DinerReview
	 * @param model the Jena Model
	 * @return a List of DinerReview
	 */
	public static java.util.List getAllDinerReview(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,DinerReview.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getDinerReview(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of ReservationCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the ReservationCode
	 * @param model the Jena Model.
	 */
	public static ReservationCode createReservationCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.ReservationCodeImpl.createReservationCode(resource,model);
	}
	
	/**
	 * Create a new instance of ReservationCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the ReservationCode
	 * @param model the Jena Model.
	 */
	public static ReservationCode createReservationCode(String uri, Model model) throws JastorException {
		ReservationCode obj = ibspan.tss.domain.ontology.restaurant.ReservationCodeImpl.createReservationCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of ReservationCode.  Leaves the model unchanged.
	 * @param uri The uri of the ReservationCode
	 * @param model the Jena Model.
	 */
	public static ReservationCode getReservationCode(String uri, Model model) throws JastorException {
		return getReservationCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of ReservationCode.  Leaves the model unchanged.
	 * @param resource The resource of the ReservationCode
	 * @param model the Jena Model.
	 */
	public static ReservationCode getReservationCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.ReservationCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.ReservationCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.ReservationCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.ReservationCodeImpl.getReservationCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an RequiredReservations individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ReservationCode.
	 */
	public static ReservationCode getRequiredReservations(Model model) throws JastorException {
		Resource resource = model.createResource(ReservationCode.RequiredReservations.getURI());
		ReservationCodeImpl obj = (ReservationCodeImpl)getReservationCode(resource, model);
		if (obj == null) {
			createReservationCode(resource, model);
			obj = (ReservationCodeImpl)getReservationCode(resource, model);
			obj.initAsRequiredReservations();			
		}
		return obj;
	}
	/** 
	 * Get an LargeGroupsOnlyReservations individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ReservationCode.
	 */
	public static ReservationCode getLargeGroupsOnlyReservations(Model model) throws JastorException {
		Resource resource = model.createResource(ReservationCode.LargeGroupsOnlyReservations.getURI());
		ReservationCodeImpl obj = (ReservationCodeImpl)getReservationCode(resource, model);
		if (obj == null) {
			createReservationCode(resource, model);
			obj = (ReservationCodeImpl)getReservationCode(resource, model);
			obj.initAsLargeGroupsOnlyReservations();			
		}
		return obj;
	}
	/** 
	 * Get an RecommendedReservations individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ReservationCode.
	 */
	public static ReservationCode getRecommendedReservations(Model model) throws JastorException {
		Resource resource = model.createResource(ReservationCode.RecommendedReservations.getURI());
		ReservationCodeImpl obj = (ReservationCodeImpl)getReservationCode(resource, model);
		if (obj == null) {
			createReservationCode(resource, model);
			obj = (ReservationCodeImpl)getReservationCode(resource, model);
			obj.initAsRecommendedReservations();			
		}
		return obj;
	}
	/** 
	 * Get an AcceptedReservations individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ReservationCode.
	 */
	public static ReservationCode getAcceptedReservations(Model model) throws JastorException {
		Resource resource = model.createResource(ReservationCode.AcceptedReservations.getURI());
		ReservationCodeImpl obj = (ReservationCodeImpl)getReservationCode(resource, model);
		if (obj == null) {
			createReservationCode(resource, model);
			obj = (ReservationCodeImpl)getReservationCode(resource, model);
			obj.initAsAcceptedReservations();			
		}
		return obj;
	}
	/** 
	 * Get an UnknownReseravations individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ReservationCode.
	 */
	public static ReservationCode getUnknownReseravations(Model model) throws JastorException {
		Resource resource = model.createResource(ReservationCode.UnknownReseravations.getURI());
		ReservationCodeImpl obj = (ReservationCodeImpl)getReservationCode(resource, model);
		if (obj == null) {
			createReservationCode(resource, model);
			obj = (ReservationCodeImpl)getReservationCode(resource, model);
			obj.initAsUnknownReseravations();			
		}
		return obj;
	}
	/** 
	 * Get an NotAcceptedReservations individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ReservationCode.
	 */
	public static ReservationCode getNotAcceptedReservations(Model model) throws JastorException {
		Resource resource = model.createResource(ReservationCode.NotAcceptedReservations.getURI());
		ReservationCodeImpl obj = (ReservationCodeImpl)getReservationCode(resource, model);
		if (obj == null) {
			createReservationCode(resource, model);
			obj = (ReservationCodeImpl)getReservationCode(resource, model);
			obj.initAsNotAcceptedReservations();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of ReservationCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#ReservationCode
	 * @param model the Jena Model
	 * @return a List of ReservationCode
	 */
	public static java.util.List getAllReservationCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,ReservationCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getReservationCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of AlcoholCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the AlcoholCode
	 * @param model the Jena Model.
	 */
	public static AlcoholCode createAlcoholCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.AlcoholCodeImpl.createAlcoholCode(resource,model);
	}
	
	/**
	 * Create a new instance of AlcoholCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the AlcoholCode
	 * @param model the Jena Model.
	 */
	public static AlcoholCode createAlcoholCode(String uri, Model model) throws JastorException {
		AlcoholCode obj = ibspan.tss.domain.ontology.restaurant.AlcoholCodeImpl.createAlcoholCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of AlcoholCode.  Leaves the model unchanged.
	 * @param uri The uri of the AlcoholCode
	 * @param model the Jena Model.
	 */
	public static AlcoholCode getAlcoholCode(String uri, Model model) throws JastorException {
		return getAlcoholCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of AlcoholCode.  Leaves the model unchanged.
	 * @param resource The resource of the AlcoholCode
	 * @param model the Jena Model.
	 */
	public static AlcoholCode getAlcoholCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.AlcoholCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.AlcoholCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.AlcoholCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.AlcoholCodeImpl.getAlcoholCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an WineBeer individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AlcoholCode.
	 */
	public static AlcoholCode getWineBeer(Model model) throws JastorException {
		Resource resource = model.createResource(AlcoholCode.WineBeer.getURI());
		AlcoholCodeImpl obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
		if (obj == null) {
			createAlcoholCode(resource, model);
			obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
			obj.initAsWineBeer();			
		}
		return obj;
	}
	/** 
	 * Get an NoAlcoholServed individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AlcoholCode.
	 */
	public static AlcoholCode getNoAlcoholServed(Model model) throws JastorException {
		Resource resource = model.createResource(AlcoholCode.NoAlcoholServed.getURI());
		AlcoholCodeImpl obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
		if (obj == null) {
			createAlcoholCode(resource, model);
			obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
			obj.initAsNoAlcoholServed();			
		}
		return obj;
	}
	/** 
	 * Get an UnknownAlkohol individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AlcoholCode.
	 */
	public static AlcoholCode getUnknownAlkohol(Model model) throws JastorException {
		Resource resource = model.createResource(AlcoholCode.UnknownAlkohol.getURI());
		AlcoholCodeImpl obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
		if (obj == null) {
			createAlcoholCode(resource, model);
			obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
			obj.initAsUnknownAlkohol();			
		}
		return obj;
	}
	/** 
	 * Get an FullBar individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of AlcoholCode.
	 */
	public static AlcoholCode getFullBar(Model model) throws JastorException {
		Resource resource = model.createResource(AlcoholCode.FullBar.getURI());
		AlcoholCodeImpl obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
		if (obj == null) {
			createAlcoholCode(resource, model);
			obj = (AlcoholCodeImpl)getAlcoholCode(resource, model);
			obj.initAsFullBar();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of AlcoholCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#AlcoholCode
	 * @param model the Jena Model
	 * @return a List of AlcoholCode
	 */
	public static java.util.List getAllAlcoholCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,AlcoholCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getAlcoholCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of RestaurantCategoryCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the RestaurantCategoryCode
	 * @param model the Jena Model.
	 */
	public static RestaurantCategoryCode createRestaurantCategoryCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCodeImpl.createRestaurantCategoryCode(resource,model);
	}
	
	/**
	 * Create a new instance of RestaurantCategoryCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the RestaurantCategoryCode
	 * @param model the Jena Model.
	 */
	public static RestaurantCategoryCode createRestaurantCategoryCode(String uri, Model model) throws JastorException {
		RestaurantCategoryCode obj = ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCodeImpl.createRestaurantCategoryCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of RestaurantCategoryCode.  Leaves the model unchanged.
	 * @param uri The uri of the RestaurantCategoryCode
	 * @param model the Jena Model.
	 */
	public static RestaurantCategoryCode getRestaurantCategoryCode(String uri, Model model) throws JastorException {
		return getRestaurantCategoryCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of RestaurantCategoryCode.  Leaves the model unchanged.
	 * @param resource The resource of the RestaurantCategoryCode
	 * @param model the Jena Model.
	 */
	public static RestaurantCategoryCode getRestaurantCategoryCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCodeImpl.getRestaurantCategoryCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an UpscaleRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getUpscaleRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.UpscaleRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsUpscaleRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an AllPurposeRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getAllPurposeRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.AllPurposeRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsAllPurposeRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an TakeOutRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getTakeOutRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.TakeOutRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsTakeOutRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an CasualRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getCasualRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.CasualRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsCasualRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an BeverageRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getBeverageRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.BeverageRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsBeverageRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an CafeteriaRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getCafeteriaRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.CafeteriaRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsCafeteriaRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an FineDiningRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getFineDiningRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.FineDiningRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsFineDiningRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an KioskRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getKioskRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.KioskRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsKioskRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an FamilyRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getFamilyRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.FamilyRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsFamilyRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an CafeRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getCafeRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.CafeRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsCafeRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an FastFoodRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getFastFoodRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.FastFoodRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsFastFoodRestaurant();			
		}
		return obj;
	}
	/** 
	 * Get an BuffetRestaurant individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantCategoryCode.
	 */
	public static RestaurantCategoryCode getBuffetRestaurant(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantCategoryCode.BuffetRestaurant.getURI());
		RestaurantCategoryCodeImpl obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
		if (obj == null) {
			createRestaurantCategoryCode(resource, model);
			obj = (RestaurantCategoryCodeImpl)getRestaurantCategoryCode(resource, model);
			obj.initAsBuffetRestaurant();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of RestaurantCategoryCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#RestaurantCategoryCode
	 * @param model the Jena Model
	 * @return a List of RestaurantCategoryCode
	 */
	public static java.util.List getAllRestaurantCategoryCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,RestaurantCategoryCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getRestaurantCategoryCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of ParkingCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the ParkingCode
	 * @param model the Jena Model.
	 */
	public static ParkingCode createParkingCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.ParkingCodeImpl.createParkingCode(resource,model);
	}
	
	/**
	 * Create a new instance of ParkingCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the ParkingCode
	 * @param model the Jena Model.
	 */
	public static ParkingCode createParkingCode(String uri, Model model) throws JastorException {
		ParkingCode obj = ibspan.tss.domain.ontology.restaurant.ParkingCodeImpl.createParkingCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of ParkingCode.  Leaves the model unchanged.
	 * @param uri The uri of the ParkingCode
	 * @param model the Jena Model.
	 */
	public static ParkingCode getParkingCode(String uri, Model model) throws JastorException {
		return getParkingCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of ParkingCode.  Leaves the model unchanged.
	 * @param resource The resource of the ParkingCode
	 * @param model the Jena Model.
	 */
	public static ParkingCode getParkingCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.ParkingCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.ParkingCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.ParkingCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.ParkingCodeImpl.getParkingCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an OwnParkingLot individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ParkingCode.
	 */
	public static ParkingCode getOwnParkingLot(Model model) throws JastorException {
		Resource resource = model.createResource(ParkingCode.OwnParkingLot.getURI());
		ParkingCodeImpl obj = (ParkingCodeImpl)getParkingCode(resource, model);
		if (obj == null) {
			createParkingCode(resource, model);
			obj = (ParkingCodeImpl)getParkingCode(resource, model);
			obj.initAsOwnParkingLot();			
		}
		return obj;
	}
	/** 
	 * Get an StreetParking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ParkingCode.
	 */
	public static ParkingCode getStreetParking(Model model) throws JastorException {
		Resource resource = model.createResource(ParkingCode.StreetParking.getURI());
		ParkingCodeImpl obj = (ParkingCodeImpl)getParkingCode(resource, model);
		if (obj == null) {
			createParkingCode(resource, model);
			obj = (ParkingCodeImpl)getParkingCode(resource, model);
			obj.initAsStreetParking();			
		}
		return obj;
	}
	/** 
	 * Get an PublicTransitAccessible individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ParkingCode.
	 */
	public static ParkingCode getPublicTransitAccessible(Model model) throws JastorException {
		Resource resource = model.createResource(ParkingCode.PublicTransitAccessible.getURI());
		ParkingCodeImpl obj = (ParkingCodeImpl)getParkingCode(resource, model);
		if (obj == null) {
			createParkingCode(resource, model);
			obj = (ParkingCodeImpl)getParkingCode(resource, model);
			obj.initAsPublicTransitAccessible();			
		}
		return obj;
	}
	/** 
	 * Get an NoLocalParking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ParkingCode.
	 */
	public static ParkingCode getNoLocalParking(Model model) throws JastorException {
		Resource resource = model.createResource(ParkingCode.NoLocalParking.getURI());
		ParkingCodeImpl obj = (ParkingCodeImpl)getParkingCode(resource, model);
		if (obj == null) {
			createParkingCode(resource, model);
			obj = (ParkingCodeImpl)getParkingCode(resource, model);
			obj.initAsNoLocalParking();			
		}
		return obj;
	}
	/** 
	 * Get an ValetParking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ParkingCode.
	 */
	public static ParkingCode getValetParking(Model model) throws JastorException {
		Resource resource = model.createResource(ParkingCode.ValetParking.getURI());
		ParkingCodeImpl obj = (ParkingCodeImpl)getParkingCode(resource, model);
		if (obj == null) {
			createParkingCode(resource, model);
			obj = (ParkingCodeImpl)getParkingCode(resource, model);
			obj.initAsValetParking();			
		}
		return obj;
	}
	/** 
	 * Get an PayParking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of ParkingCode.
	 */
	public static ParkingCode getPayParking(Model model) throws JastorException {
		Resource resource = model.createResource(ParkingCode.PayParking.getURI());
		ParkingCodeImpl obj = (ParkingCodeImpl)getParkingCode(resource, model);
		if (obj == null) {
			createParkingCode(resource, model);
			obj = (ParkingCodeImpl)getParkingCode(resource, model);
			obj.initAsPayParking();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of ParkingCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#ParkingCode
	 * @param model the Jena Model
	 * @return a List of ParkingCode
	 */
	public static java.util.List getAllParkingCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,ParkingCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getParkingCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of Restaurant.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the Restaurant
	 * @param model the Jena Model.
	 */
	public static Restaurant createRestaurant(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.RestaurantImpl.createRestaurant(resource,model);
	}
	
	/**
	 * Create a new instance of Restaurant.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the Restaurant
	 * @param model the Jena Model.
	 */
	public static Restaurant createRestaurant(String uri, Model model) throws JastorException {
		Restaurant obj = ibspan.tss.domain.ontology.restaurant.RestaurantImpl.createRestaurant(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of Restaurant.  Leaves the model unchanged.
	 * @param uri The uri of the Restaurant
	 * @param model the Jena Model.
	 */
	public static Restaurant getRestaurant(String uri, Model model) throws JastorException {
		return getRestaurant(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of Restaurant.  Leaves the model unchanged.
	 * @param resource The resource of the Restaurant
	 * @param model the Jena Model.
	 */
	public static Restaurant getRestaurant(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.Restaurant.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.RestaurantImpl obj = (ibspan.tss.domain.ontology.restaurant.RestaurantImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.RestaurantImpl.getRestaurant(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
		
	
	/**
	 * Return an instance of Restaurant for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#Restaurant
	 * @param model the Jena Model
	 * @return a List of Restaurant
	 */
	public static java.util.List getAllRestaurant(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,Restaurant.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getRestaurant(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of SmokingCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the SmokingCode
	 * @param model the Jena Model.
	 */
	public static SmokingCode createSmokingCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.SmokingCodeImpl.createSmokingCode(resource,model);
	}
	
	/**
	 * Create a new instance of SmokingCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the SmokingCode
	 * @param model the Jena Model.
	 */
	public static SmokingCode createSmokingCode(String uri, Model model) throws JastorException {
		SmokingCode obj = ibspan.tss.domain.ontology.restaurant.SmokingCodeImpl.createSmokingCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of SmokingCode.  Leaves the model unchanged.
	 * @param uri The uri of the SmokingCode
	 * @param model the Jena Model.
	 */
	public static SmokingCode getSmokingCode(String uri, Model model) throws JastorException {
		return getSmokingCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of SmokingCode.  Leaves the model unchanged.
	 * @param resource The resource of the SmokingCode
	 * @param model the Jena Model.
	 */
	public static SmokingCode getSmokingCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.SmokingCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.SmokingCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.SmokingCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.SmokingCodeImpl.getSmokingCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an NotPermittedSmoking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of SmokingCode.
	 */
	public static SmokingCode getNotPermittedSmoking(Model model) throws JastorException {
		Resource resource = model.createResource(SmokingCode.NotPermittedSmoking.getURI());
		SmokingCodeImpl obj = (SmokingCodeImpl)getSmokingCode(resource, model);
		if (obj == null) {
			createSmokingCode(resource, model);
			obj = (SmokingCodeImpl)getSmokingCode(resource, model);
			obj.initAsNotPermittedSmoking();			
		}
		return obj;
	}
	/** 
	 * Get an SectionSmoking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of SmokingCode.
	 */
	public static SmokingCode getSectionSmoking(Model model) throws JastorException {
		Resource resource = model.createResource(SmokingCode.SectionSmoking.getURI());
		SmokingCodeImpl obj = (SmokingCodeImpl)getSmokingCode(resource, model);
		if (obj == null) {
			createSmokingCode(resource, model);
			obj = (SmokingCodeImpl)getSmokingCode(resource, model);
			obj.initAsSectionSmoking();			
		}
		return obj;
	}
	/** 
	 * Get an OnlyAtBarSmoking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of SmokingCode.
	 */
	public static SmokingCode getOnlyAtBarSmoking(Model model) throws JastorException {
		Resource resource = model.createResource(SmokingCode.OnlyAtBarSmoking.getURI());
		SmokingCodeImpl obj = (SmokingCodeImpl)getSmokingCode(resource, model);
		if (obj == null) {
			createSmokingCode(resource, model);
			obj = (SmokingCodeImpl)getSmokingCode(resource, model);
			obj.initAsOnlyAtBarSmoking();			
		}
		return obj;
	}
	/** 
	 * Get an UnknownSmoking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of SmokingCode.
	 */
	public static SmokingCode getUnknownSmoking(Model model) throws JastorException {
		Resource resource = model.createResource(SmokingCode.UnknownSmoking.getURI());
		SmokingCodeImpl obj = (SmokingCodeImpl)getSmokingCode(resource, model);
		if (obj == null) {
			createSmokingCode(resource, model);
			obj = (SmokingCodeImpl)getSmokingCode(resource, model);
			obj.initAsUnknownSmoking();			
		}
		return obj;
	}
	/** 
	 * Get an PermittedSmoking individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of SmokingCode.
	 */
	public static SmokingCode getPermittedSmoking(Model model) throws JastorException {
		Resource resource = model.createResource(SmokingCode.PermittedSmoking.getURI());
		SmokingCodeImpl obj = (SmokingCodeImpl)getSmokingCode(resource, model);
		if (obj == null) {
			createSmokingCode(resource, model);
			obj = (SmokingCodeImpl)getSmokingCode(resource, model);
			obj.initAsPermittedSmoking();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of SmokingCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#SmokingCode
	 * @param model the Jena Model
	 * @return a List of SmokingCode
	 */
	public static java.util.List getAllSmokingCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,SmokingCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getSmokingCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of FeatureCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the FeatureCode
	 * @param model the Jena Model.
	 */
	public static FeatureCode createFeatureCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.FeatureCodeImpl.createFeatureCode(resource,model);
	}
	
	/**
	 * Create a new instance of FeatureCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the FeatureCode
	 * @param model the Jena Model.
	 */
	public static FeatureCode createFeatureCode(String uri, Model model) throws JastorException {
		FeatureCode obj = ibspan.tss.domain.ontology.restaurant.FeatureCodeImpl.createFeatureCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of FeatureCode.  Leaves the model unchanged.
	 * @param uri The uri of the FeatureCode
	 * @param model the Jena Model.
	 */
	public static FeatureCode getFeatureCode(String uri, Model model) throws JastorException {
		return getFeatureCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of FeatureCode.  Leaves the model unchanged.
	 * @param resource The resource of the FeatureCode
	 * @param model the Jena Model.
	 */
	public static FeatureCode getFeatureCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.FeatureCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.FeatureCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.FeatureCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.FeatureCodeImpl.getFeatureCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an Takeout individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getTakeout(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Takeout.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsTakeout();			
		}
		return obj;
	}
	/** 
	 * Get an FineDining individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getFineDining(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.FineDining.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsFineDining();			
		}
		return obj;
	}
	/** 
	 * Get an BreakfastBuffet individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBreakfastBuffet(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.BreakfastBuffet.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBreakfastBuffet();			
		}
		return obj;
	}
	/** 
	 * Get an FixedPriceMealsAtLunc individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getFixedPriceMealsAtLunc(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.FixedPriceMealsAtLunc.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsFixedPriceMealsAtLunc();			
		}
		return obj;
	}
	/** 
	 * Get an PrivateParties individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getPrivateParties(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.PrivateParties.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsPrivateParties();			
		}
		return obj;
	}
	/** 
	 * Get an SundayBrunch individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getSundayBrunch(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.SundayBrunch.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsSundayBrunch();			
		}
		return obj;
	}
	/** 
	 * Get an Kids individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getKids(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Kids.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsKids();			
		}
		return obj;
	}
	/** 
	 * Get an LargePrintMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getLargePrintMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.LargePrintMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsLargePrintMenu();			
		}
		return obj;
	}
	/** 
	 * Get an PrivateRoomAvailable individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getPrivateRoomAvailable(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.PrivateRoomAvailable.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsPrivateRoomAvailable();			
		}
		return obj;
	}
	/** 
	 * Get an Kiosk individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getKiosk(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Kiosk.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsKiosk();			
		}
		return obj;
	}
	/** 
	 * Get an DinnerBuffet individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getDinnerBuffet(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.DinnerBuffet.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsDinnerBuffet();			
		}
		return obj;
	}
	/** 
	 * Get an FastFood individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getFastFood(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.FastFood.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsFastFood();			
		}
		return obj;
	}
	/** 
	 * Get an LargeGroupsOk individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getLargeGroupsOk(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.LargeGroupsOk.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsLargeGroupsOk();			
		}
		return obj;
	}
	/** 
	 * Get an VegetarianMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getVegetarianMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.VegetarianMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsVegetarianMenu();			
		}
		return obj;
	}
	/** 
	 * Get an NiceView individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getNiceView(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.NiceView.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsNiceView();			
		}
		return obj;
	}
	/** 
	 * Get an Brewery individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBrewery(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Brewery.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBrewery();			
		}
		return obj;
	}
	/** 
	 * Get an Halal individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getHalal(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Halal.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsHalal();			
		}
		return obj;
	}
	/** 
	 * Get an Upscale individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getUpscale(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Upscale.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsUpscale();			
		}
		return obj;
	}
	/** 
	 * Get an FixedPriceMealsAtDinn individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getFixedPriceMealsAtDinn(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.FixedPriceMealsAtDinn.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsFixedPriceMealsAtDinn();			
		}
		return obj;
	}
	/** 
	 * Get an BeingYourOwnWine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBeingYourOwnWine(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.BeingYourOwnWine.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBeingYourOwnWine();			
		}
		return obj;
	}
	/** 
	 * Get an Outdoor individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getOutdoor(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Outdoor.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsOutdoor();			
		}
		return obj;
	}
	/** 
	 * Get an ExtensiveWineList individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getExtensiveWineList(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.ExtensiveWineList.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsExtensiveWineList();			
		}
		return obj;
	}
	/** 
	 * Get an PhoneAheadSeating individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getPhoneAheadSeating(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.PhoneAheadSeating.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsPhoneAheadSeating();			
		}
		return obj;
	}
	/** 
	 * Get an Cafeteria individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getCafeteria(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Cafeteria.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsCafeteria();			
		}
		return obj;
	}
	/** 
	 * Get an WineTasting individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getWineTasting(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.WineTasting.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsWineTasting();			
		}
		return obj;
	}
	/** 
	 * Get an Beverage individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBeverage(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Beverage.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBeverage();			
		}
		return obj;
	}
	/** 
	 * Get an VeganDishes individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getVeganDishes(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.VeganDishes.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsVeganDishes();			
		}
		return obj;
	}
	/** 
	 * Get an Fireplace individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getFireplace(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Fireplace.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsFireplace();			
		}
		return obj;
	}
	/** 
	 * Get an WineList individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getWineList(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.WineList.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsWineList();			
		}
		return obj;
	}
	/** 
	 * Get an CertifiedKosher individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getCertifiedKosher(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.CertifiedKosher.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsCertifiedKosher();			
		}
		return obj;
	}
	/** 
	 * Get an SaladBar individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getSaladBar(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.SaladBar.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsSaladBar();			
		}
		return obj;
	}
	/** 
	 * Get an AdultEntertainment individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getAdultEntertainment(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.AdultEntertainment.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsAdultEntertainment();			
		}
		return obj;
	}
	/** 
	 * Get an DriveThrough individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getDriveThrough(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.DriveThrough.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsDriveThrough();			
		}
		return obj;
	}
	/** 
	 * Get an SenorMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getSenorMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.SenorMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsSenorMenu();			
		}
		return obj;
	}
	/** 
	 * Get an BeingYourOwnBeer individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBeingYourOwnBeer(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.BeingYourOwnBeer.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBeingYourOwnBeer();			
		}
		return obj;
	}
	/** 
	 * Get an BrailleMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBrailleMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.BrailleMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBrailleMenu();			
		}
		return obj;
	}
	/** 
	 * Get an MinorsNotAllowed individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getMinorsNotAllowed(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.MinorsNotAllowed.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsMinorsNotAllowed();			
		}
		return obj;
	}
	/** 
	 * Get an Entertainment individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getEntertainment(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Entertainment.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsEntertainment();			
		}
		return obj;
	}
	/** 
	 * Get an AllPurpose individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getAllPurpose(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.AllPurpose.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsAllPurpose();			
		}
		return obj;
	}
	/** 
	 * Get an Casual individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getCasual(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Casual.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsCasual();			
		}
		return obj;
	}
	/** 
	 * Get an OffsiteCatering individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getOffsiteCatering(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.OffsiteCatering.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsOffsiteCatering();			
		}
		return obj;
	}
	/** 
	 * Get an VegetarianDishes individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getVegetarianDishes(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.VegetarianDishes.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsVegetarianDishes();			
		}
		return obj;
	}
	/** 
	 * Get an Winery individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getWinery(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Winery.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsWinery();			
		}
		return obj;
	}
	/** 
	 * Get an InternetAccess individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getInternetAccess(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.InternetAccess.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsInternetAccess();			
		}
		return obj;
	}
	/** 
	 * Get an EnglishLanguageMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getEnglishLanguageMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.EnglishLanguageMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsEnglishLanguageMenu();			
		}
		return obj;
	}
	/** 
	 * Get an Cafe individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getCafe(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Cafe.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsCafe();			
		}
		return obj;
	}
	/** 
	 * Get an Buffet individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBuffet(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Buffet.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBuffet();			
		}
		return obj;
	}
	/** 
	 * Get an LunchBuffet individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getLunchBuffet(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.LunchBuffet.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsLunchBuffet();			
		}
		return obj;
	}
	/** 
	 * Get an Family individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getFamily(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Family.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsFamily();			
		}
		return obj;
	}
	/** 
	 * Get an KidFriendly individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getKidFriendly(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.KidFriendly.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsKidFriendly();			
		}
		return obj;
	}
	/** 
	 * Get an VeganMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getVeganMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.VeganMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsVeganMenu();			
		}
		return obj;
	}
	/** 
	 * Get an Delivery individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getDelivery(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Delivery.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsDelivery();			
		}
		return obj;
	}
	/** 
	 * Get an Conservatory individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getConservatory(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.Conservatory.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsConservatory();			
		}
		return obj;
	}
	/** 
	 * Get an TastingMenu individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getTastingMenu(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.TastingMenu.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsTastingMenu();			
		}
		return obj;
	}
	/** 
	 * Get an BeerTasting individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of FeatureCode.
	 */
	public static FeatureCode getBeerTasting(Model model) throws JastorException {
		Resource resource = model.createResource(FeatureCode.BeerTasting.getURI());
		FeatureCodeImpl obj = (FeatureCodeImpl)getFeatureCode(resource, model);
		if (obj == null) {
			createFeatureCode(resource, model);
			obj = (FeatureCodeImpl)getFeatureCode(resource, model);
			obj.initAsBeerTasting();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of FeatureCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#FeatureCode
	 * @param model the Jena Model
	 * @return a List of FeatureCode
	 */
	public static java.util.List getAllFeatureCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,FeatureCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getFeatureCode(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of RestaurantServiceInfo.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the RestaurantServiceInfo
	 * @param model the Jena Model.
	 */
	public static RestaurantServiceInfo createRestaurantServiceInfo(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfoImpl.createRestaurantServiceInfo(resource,model);
	}
	
	/**
	 * Create a new instance of RestaurantServiceInfo.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the RestaurantServiceInfo
	 * @param model the Jena Model.
	 */
	public static RestaurantServiceInfo createRestaurantServiceInfo(String uri, Model model) throws JastorException {
		RestaurantServiceInfo obj = ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfoImpl.createRestaurantServiceInfo(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of RestaurantServiceInfo.  Leaves the model unchanged.
	 * @param uri The uri of the RestaurantServiceInfo
	 * @param model the Jena Model.
	 */
	public static RestaurantServiceInfo getRestaurantServiceInfo(String uri, Model model) throws JastorException {
		return getRestaurantServiceInfo(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of RestaurantServiceInfo.  Leaves the model unchanged.
	 * @param resource The resource of the RestaurantServiceInfo
	 * @param model the Jena Model.
	 */
	public static RestaurantServiceInfo getRestaurantServiceInfo(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfoImpl obj = (ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfoImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfoImpl.getRestaurantServiceInfo(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an BuffetRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getBuffetRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.BuffetRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsBuffetRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an CasualDiningRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getCasualDiningRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.CasualDiningRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsCasualDiningRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an FineDiningRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getFineDiningRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.FineDiningRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsFineDiningRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an MealsToGoRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getMealsToGoRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.MealsToGoRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsMealsToGoRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an TakeOutRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getTakeOutRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.TakeOutRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsTakeOutRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an FullServiceRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getFullServiceRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.FullServiceRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsFullServiceRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an RoomServiceRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getRoomServiceRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.RoomServiceRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsRoomServiceRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an SelfServiceRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getSelfServiceRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.SelfServiceRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsSelfServiceRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an CateringRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getCateringRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.CateringRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsCateringRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an SpecialMealServicesRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getSpecialMealServicesRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.SpecialMealServicesRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsSpecialMealServicesRestaurantService();			
		}
		return obj;
	}
	/** 
	 * Get an CookedToOrderRestaurantService individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of RestaurantServiceInfo.
	 */
	public static RestaurantServiceInfo getCookedToOrderRestaurantService(Model model) throws JastorException {
		Resource resource = model.createResource(RestaurantServiceInfo.CookedToOrderRestaurantService.getURI());
		RestaurantServiceInfoImpl obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
		if (obj == null) {
			createRestaurantServiceInfo(resource, model);
			obj = (RestaurantServiceInfoImpl)getRestaurantServiceInfo(resource, model);
			obj.initAsCookedToOrderRestaurantService();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of RestaurantServiceInfo for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#RestaurantServiceInfo
	 * @param model the Jena Model
	 * @return a List of RestaurantServiceInfo
	 */
	public static java.util.List getAllRestaurantServiceInfo(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,RestaurantServiceInfo.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getRestaurantServiceInfo(stmt.getSubject(),model));
		}
		return list;
	}
	

	/**
	 * Create a new instance of CuisineCode.  Adds the rdf:type property for the given resource to the model.
	 * @param resource The resource of the CuisineCode
	 * @param model the Jena Model.
	 */
	public static CuisineCode createCuisineCode(Resource resource, Model model) throws JastorException {
		return ibspan.tss.domain.ontology.restaurant.CuisineCodeImpl.createCuisineCode(resource,model);
	}
	
	/**
	 * Create a new instance of CuisineCode.  Adds the rdf:type property for the given resource to the model.
	 * @param uri The uri of the CuisineCode
	 * @param model the Jena Model.
	 */
	public static CuisineCode createCuisineCode(String uri, Model model) throws JastorException {
		CuisineCode obj = ibspan.tss.domain.ontology.restaurant.CuisineCodeImpl.createCuisineCode(model.createResource(uri), model);
		return obj;
	}
	
	/**
	 * Create a new instance of CuisineCode.  Leaves the model unchanged.
	 * @param uri The uri of the CuisineCode
	 * @param model the Jena Model.
	 */
	public static CuisineCode getCuisineCode(String uri, Model model) throws JastorException {
		return getCuisineCode(model.createResource(uri),model);
	}
	
	/**
	 * Create a new instance of CuisineCode.  Leaves the model unchanged.
	 * @param resource The resource of the CuisineCode
	 * @param model the Jena Model.
	 */
	public static CuisineCode getCuisineCode(Resource resource, Model model) throws JastorException {
		String code = (model.hashCode()*17 + ibspan.tss.domain.ontology.restaurant.CuisineCode.class.hashCode()) + resource.toString();
		ibspan.tss.domain.ontology.restaurant.CuisineCodeImpl obj = (ibspan.tss.domain.ontology.restaurant.CuisineCodeImpl)objects.get(code);
		if (obj == null) {
			obj = ibspan.tss.domain.ontology.restaurant.CuisineCodeImpl.getCuisineCode(resource, model);
			if (obj == null)
				return null;
			objects.put(code, obj);
		}
		return obj;
	}
	
	/** 
	 * Get an SwissCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSwissCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SwissCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSwissCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SoulFoodCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSoulFoodCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SoulFoodCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSoulFoodCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an JapaneseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getJapaneseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.JapaneseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsJapaneseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SouthernCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSouthernCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SouthernCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSouthernCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CUICuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCUICuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CUICuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCUICuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ArgentineanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getArgentineanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ArgentineanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsArgentineanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ChileanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getChileanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ChileanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsChileanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BrasserieCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBrasserieCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BrasserieCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBrasserieCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an RussianUkrainianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getRussianUkrainianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.RussianUkrainianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsRussianUkrainianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ThaiCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getThaiCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ThaiCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsThaiCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SpanishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSpanishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SpanishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSpanishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SouthAmericanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSouthAmericanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SouthAmericanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSouthAmericanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an MediterraneanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getMediterraneanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.MediterraneanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsMediterraneanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ScandinavianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getScandinavianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ScandinavianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsScandinavianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DimSumCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDimSumCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DimSumCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDimSumCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an EclecticCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getEclecticCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.EclecticCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsEclecticCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IrishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIrishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IrishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIrishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CanadianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCanadianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CanadianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCanadianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an HotDogsCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getHotDogsCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.HotDogsCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsHotDogsCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SushiCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSushiCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SushiCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSushiCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an TexNexCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTexNexCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TexNexCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTexNexCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an KosherCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getKosherCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.KosherCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsKosherCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ArmenianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getArmenianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ArmenianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsArmenianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SandwichesCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSandwichesCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SandwichesCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSandwichesCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PeruvianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPeruvianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PeruvianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPeruvianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BagelsCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBagelsCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BagelsCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBagelsCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CambodianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCambodianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CambodianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCambodianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SardinianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSardinianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SardinianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSardinianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IndianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIndianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IndianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIndianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FusionCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFusionCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FusionCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFusionCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CaliforniaCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCaliforniaCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CaliforniaCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCaliforniaCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ScottishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getScottishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ScottishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsScottishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CatalanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCatalanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CatalanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCatalanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CreoleCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCreoleCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CreoleCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCreoleCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CafeteriaCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCafeteriaCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CafeteriaCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCafeteriaCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an LatinAmericanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getLatinAmericanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.LatinAmericanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsLatinAmericanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CafeCoffeeShopCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCafeCoffeeShopCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CafeCoffeeShopCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCafeCoffeeShopCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SaharanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSaharanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SaharanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSaharanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BurgersCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBurgersCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BurgersCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBurgersCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ContemporaryCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getContemporaryCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ContemporaryCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsContemporaryCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an MoroccanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getMoroccanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.MoroccanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsMoroccanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FastFoodCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFastFoodCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FastFoodCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFastFoodCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SwedishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSwedishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SwedishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSwedishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an TeaHouseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTeaHouseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TeaHouseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTeaHouseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an HungarianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getHungarianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.HungarianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsHungarianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BarPubBreweryCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBarPubBreweryCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BarPubBreweryCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBarPubBreweryCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BritishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBritishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BritishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBritishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an GameCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getGameCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.GameCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsGameCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CambodgianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCambodgianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CambodgianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCambodgianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an AsianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getAsianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.AsianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsAsianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an NorthAmericanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getNorthAmericanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.NorthAmericanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsNorthAmericanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an AmericanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getAmericanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.AmericanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsAmericanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an VegetarianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getVegetarianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.VegetarianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsVegetarianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DoughnutsCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDoughnutsCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DoughnutsCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDoughnutsCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an HawaiianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getHawaiianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.HawaiianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsHawaiianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BurmeseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBurmeseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BurmeseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBurmeseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FilipinoCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFilipinoCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FilipinoCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFilipinoCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BreakfastBrunchCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBreakfastBrunchCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BreakfastBrunchCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBreakfastBrunchCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ItalianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getItalianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ItalianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsItalianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IcecreamParlourCuis individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIcecreamParlourCuis(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IcecreamParlourCuis.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIcecreamParlourCuis();			
		}
		return obj;
	}
	/** 
	 * Get an OrganicHealthyCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getOrganicHealthyCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.OrganicHealthyCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsOrganicHealthyCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CajunCreoleCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCajunCreoleCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CajunCreoleCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCajunCreoleCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BrazilianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBrazilianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BrazilianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBrazilianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BasqueCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBasqueCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BasqueCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBasqueCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an VietnameseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getVietnameseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.VietnameseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsVietnameseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an GermanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getGermanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.GermanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsGermanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ModernEuropeanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getModernEuropeanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ModernEuropeanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsModernEuropeanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an RegionalCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getRegionalCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.RegionalCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsRegionalCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DessertIceCreamCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDessertIceCreamCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DessertIceCreamCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDessertIceCreamCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PortugueseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPortugueseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PortugueseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPortugueseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IndigenousCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIndigenousCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IndigenousCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIndigenousCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ChineseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getChineseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ChineseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsChineseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DutchBelgianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDutchBelgianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DutchBelgianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDutchBelgianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SoupCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSoupCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SoupCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSoupCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DanishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDanishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DanishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDanishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an KoreanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getKoreanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.KoreanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsKoreanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PizzaCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPizzaCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PizzaCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPizzaCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an MongolianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getMongolianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.MongolianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsMongolianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an EthiopianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getEthiopianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.EthiopianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsEthiopianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CaribbeanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCaribbeanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CaribbeanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCaribbeanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ContinentalEuropeanCusine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getContinentalEuropeanCusine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ContinentalEuropeanCusine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsContinentalEuropeanCusine();			
		}
		return obj;
	}
	/** 
	 * Get an SeafoodCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSeafoodCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SeafoodCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSeafoodCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BarbecueCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBarbecueCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BarbecueCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBarbecueCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an AustrianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getAustrianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.AustrianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsAustrianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an MalaysianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getMalaysianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.MalaysianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsMalaysianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IndianPakistaniCuis individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIndianPakistaniCuis(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IndianPakistaniCuis.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIndianPakistaniCuis();			
		}
		return obj;
	}
	/** 
	 * Get an SteakHousesCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSteakHousesCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SteakHousesCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSteakHousesCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an NepaleseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getNepaleseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.NepaleseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsNepaleseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an EnglishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getEnglishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.EnglishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsEnglishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PolynesianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPolynesianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PolynesianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPolynesianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an TurkishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTurkishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TurkishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTurkishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an JamaicanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getJamaicanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.JamaicanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsJamaicanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BakeryCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBakeryCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BakeryCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBakeryCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an MiddleEasternCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getMiddleEasternCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.MiddleEasternCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsMiddleEasternCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an OtherCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getOtherCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.OtherCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsOtherCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BiologicalCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBiologicalCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BiologicalCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBiologicalCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an MexicanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getMexicanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.MexicanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsMexicanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an EasternEuropeanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getEasternEuropeanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.EasternEuropeanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsEasternEuropeanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an RussianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getRussianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.RussianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsRussianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FamilyCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFamilyCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FamilyCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFamilyCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PolishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPolishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PolishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPolishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CubanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCubanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CubanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCubanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an CentralEuropeanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getCentralEuropeanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.CentralEuropeanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsCentralEuropeanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an TunisianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTunisianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TunisianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTunisianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an InternationalCuisin individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getInternationalCuisin(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.InternationalCuisin.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsInternationalCuisin();			
		}
		return obj;
	}
	/** 
	 * Get an TapasCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTapasCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TapasCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTapasCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an HamburgerCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getHamburgerCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.HamburgerCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsHamburgerCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IsraeliCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIsraeliCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IsraeliCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIsraeliCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SeychellesCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSeychellesCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SeychellesCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSeychellesCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PacificRimCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPacificRimCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PacificRimCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPacificRimCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FineDiningCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFineDiningCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FineDiningCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFineDiningCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an GreekCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getGreekCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.GreekCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsGreekCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ReunionCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getReunionCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ReunionCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsReunionCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an AfghanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getAfghanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.AfghanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsAfghanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an BelgianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getBelgianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.BelgianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsBelgianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SteaksCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSteaksCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SteaksCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSteaksCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DinerCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDinerCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DinerCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDinerCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an NorthAfricanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getNorthAfricanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.NorthAfricanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsNorthAfricanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an JuiceCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getJuiceCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.JuiceCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsJuiceCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an AfricanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getAfricanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.AfricanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsAfricanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PanPacificCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPanPacificCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PanPacificCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPanPacificCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SouthwesternCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSouthwesternCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SouthwesternCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSouthwesternCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an EuropeanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getEuropeanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.EuropeanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsEuropeanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an RomanianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getRomanianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.RomanianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsRomanianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an TrendyCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTrendyCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TrendyCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTrendyCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PacificNorthwestCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPacificNorthwestCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PacificNorthwestCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPacificNorthwestCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an JewishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getJewishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.JewishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsJewishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FinnishCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFinnishCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FinnishCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFinnishCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an DeliSandwichesCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getDeliSandwichesCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.DeliSandwichesCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsDeliSandwichesCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an IndonesianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getIndonesianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.IndonesianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsIndonesianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SoutheastAsianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSoutheastAsianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SoutheastAsianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSoutheastAsianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an AustralianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getAustralianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.AustralianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsAustralianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an LebaneseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getLebaneseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.LebaneseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsLebaneseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an PersianCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getPersianCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.PersianCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsPersianCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an FishAndChipsCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getFishAndChipsCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.FishAndChipsCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsFishAndChipsCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an ChopeHouseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getChopeHouseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.ChopeHouseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsChopeHouseCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an TibetanCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getTibetanCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.TibetanCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsTibetanCuisine();			
		}
		return obj;
	}
	/** 
	 * Get an SudaneseCuisine individual. If individual does not exist
	 * in the model it is created by adding rdf:type property and all other properties
	 * forming this individual.
	 * @param model The Jena Model.
	 * @return Instance of CuisineCode.
	 */
	public static CuisineCode getSudaneseCuisine(Model model) throws JastorException {
		Resource resource = model.createResource(CuisineCode.SudaneseCuisine.getURI());
		CuisineCodeImpl obj = (CuisineCodeImpl)getCuisineCode(resource, model);
		if (obj == null) {
			createCuisineCode(resource, model);
			obj = (CuisineCodeImpl)getCuisineCode(resource, model);
			obj.initAsSudaneseCuisine();			
		}
		return obj;
	}	
	
	/**
	 * Return an instance of CuisineCode for every resource in the model with rdf:Type http://www.ibspan.waw.pl/tss/Restaurant#CuisineCode
	 * @param model the Jena Model
	 * @return a List of CuisineCode
	 */
	public static java.util.List getAllCuisineCode(Model model) throws JastorException {
		StmtIterator it = model.listStatements(null,RDF.type,CuisineCode.TYPE);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			Statement stmt = it.nextStatement();
			list.add(getCuisineCode(stmt.getSubject(),model));
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
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#CuisineCode"))) {
			return getCuisineCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#RestaurantServiceInfo"))) {
			return getRestaurantServiceInfo(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#FeatureCode"))) {
			return getFeatureCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#SmokingCode"))) {
			return getSmokingCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#Restaurant"))) {
			return getRestaurant(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#ParkingCode"))) {
			return getParkingCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#RestaurantCategoryCode"))) {
			return getRestaurantCategoryCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#AlcoholCode"))) {
			return getAlcoholCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#ReservationCode"))) {
			return getReservationCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#DinerReview"))) {
			return getDinerReview(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#AccessibilityCode"))) {
			return getAccessibilityCode(res,model);
		}
		if (res.hasProperty(RDF.type,model.getResource("http://www.ibspan.waw.pl/tss/Restaurant#DressCode"))) {
			return getDressCode(res,model);
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
	 * in the Restaurant ontology.  The list is sorted according to the topological sort
	 * of the class hierarchy
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List listCompatibleInterfaces (com.hp.hpl.jena.rdf.model.Resource type) {
		java.util.List types = new java.util.ArrayList();
		if (type.equals(ibspan.tss.domain.ontology.restaurant.CuisineCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.CuisineCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.RestaurantServiceInfo.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.FeatureCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.FeatureCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.SmokingCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.SmokingCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.Restaurant.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.Restaurant.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.ParkingCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.ParkingCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.RestaurantCategoryCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.AlcoholCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.AlcoholCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.ReservationCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.ReservationCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.DinerReview.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.DinerReview.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.AccessibilityCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.AccessibilityCode.class);
		}
		if (type.equals(ibspan.tss.domain.ontology.restaurant.DressCode.TYPE)) {
			types.add(ibspan.tss.domain.ontology.restaurant.DressCode.class);
		}
		return types;
	}
}