// file: MessagingOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package ibspan.tss.messaging.ontology;

import jade.content.onto.*;
import jade.content.schema.*;
import jade.util.leap.HashMap;
import jade.content.lang.Codec;
import jade.core.CaseInsensitiveString;

/** file: MessagingOntology.java
 * @author ontology bean generator
 * @version 2006/08/23, 10:35:10
 */
public class MessagingOntology extends jade.content.onto.Ontology  {
  //NAME
  public static final String ONTOLOGY_NAME = "Messaging";
  // The singleton instance of this ontology
  private static ReflectiveIntrospector introspect = new ReflectiveIntrospector();
  private static Ontology theInstance = new MessagingOntology();
  public static Ontology getInstance() {
     return theInstance;
  }


   // VOCABULARY
    public static final String HAVENEWEVENTS_PACKSIZE="packSize";
    public static final String HAVENEWEVENTS_EVENTS="events";
    public static final String HAVENEWEVENTS="HaveNewEvents";
    public static final String PMA_ACTION="PMA_action";
    public static final String SHA_INTERNAL_ACTION_NAME="SHA_internal_action_name";
    public static final String PA_PROCESS_USER_REQUEST_ACTIONPARAMS="actionParams";
    public static final String PA_PROCESS_USER_REQUEST_ACTIONNAME="actionName";
    public static final String PA_PROCESS_USER_REQUEST="PA_process_user_request";
    public static final String SHA_SUBSCRIBE_FOR_NEW_EVENTS_CONDITION="condition";
    public static final String SHA_SUBSCRIBE_FOR_NEW_EVENTS="SHA_subscribe_for_new_events";
    public static final String RSA_GET_RESTAURANTS_DETAILS_ABOUTRESTAURANT="aboutRestaurant";
    public static final String RSA_GET_RESTAURANTS_DETAILS="RSA_get_restaurants_details";
    public static final String VTA_ACTION="VTA_action";
    public static final String SHA_WELCOME_USER="SHA_welcome_user";
    public static final String PMA_GET_USER_PROFILE_USERID="userID";
    public static final String PMA_GET_USER_PROFILE="PMA_get_user_profile";
    public static final String RSA_GET_DOMAIN_ONTOLOGY="RSA_get_domain_ontology";
    public static final String SHA_ACTION="SHA_action";
    public static final String RSA_FIND_RESTAURANT_HASQUERY="hasQuery";
    public static final String RSA_FIND_RESTAURANT="RSA_find_restaurant";
    public static final String PMA_INIT_USER_PROFILE_DRESS="dress";
    public static final String PMA_INIT_USER_PROFILE_PROFESSION="profession";
    public static final String PMA_INIT_USER_PROFILE_AGE="age";
    public static final String PMA_INIT_USER_PROFILE_USERID="userID";
    public static final String PMA_INIT_USER_PROFILE_WEALTH="wealth";
    public static final String PMA_INIT_USER_PROFILE="PMA_init_user_profile";
    public static final String VTA_CONSTRUCT_VIEW_ACTIONNAME="actionName";
    public static final String VTA_CONSTRUCT_VIEW_USERCONTEXT="userContext";
    public static final String VTA_CONSTRUCT_VIEW_MODEL="model";
    public static final String VTA_CONSTRUCT_VIEW="VTA_construct_view";
    public static final String SHA_GET_LOGIN_SCREEN="SHA_get_login_screen";
    public static final String SHA_PROCESS_USER_REQUEST_USERREQUEST="userRequest";
    public static final String SHA_PROCESS_USER_REQUEST="SHA_process_user_request";
    public static final String PA_ACTION="PA_action";
    public static final String RSA_ACTION="RSA_action";
    public static final String USERCONTEXT_SESSIONID="sessionID";
    public static final String USERCONTEXT_MEDIATYPE="mediaType";
    public static final String USERCONTEXT_INTERFACEPORT="interfacePort";
    public static final String USERCONTEXT_USERID="userID";
    public static final String USERCONTEXT_INTERFACEHOST="interfaceHost";
    public static final String USERCONTEXT_PEERID="peerID";
    public static final String USERCONTEXT="UserContext";
    public static final String DATAMODEL_CONSTRUCTORACTIONNAME="constructorActionName";
    public static final String DATAMODEL_OWLMODEL="owlModel";
    public static final String DATAMODEL="DataModel";
    public static final String DATAVIEW_CONTENT="content";
    public static final String DATAVIEW="DataView";
    public static final String CONCEPTWITHINFO_MESSAGEINFO="messageInfo";
    public static final String CONCEPTWITHINFO="ConceptWithInfo";
    public static final String USERREQUEST_ACTIONPARAMS="actionParams";
    public static final String USERREQUEST_ACTIONNAME="actionName";
    public static final String USERREQUEST_USERCONTEXT="userContext";
    public static final String USERREQUEST="UserRequest";
    public static final String MAPENTRY_VALUE="value";
    public static final String MAPENTRY_KEY="key";
    public static final String MAPENTRY="MapEntry";
    public static final String OWLDATA_WITHROOTURI="withRootURI";
    public static final String OWLDATA_DATAMODEL="dataModel";
    public static final String OWLDATA_SYNTAXLANGUAGE="syntaxLanguage";
    public static final String OWLDATA="OWLData";
    public static final String MAP_HASENTRY="hasEntry";
    public static final String MAP="Map";
    public static final String INTERNALSYSTEMERROR_MESSAGE="message";
    public static final String INTERNALSYSTEMERROR="InternalSystemError";

  /**
   * Constructor
  */
  private MessagingOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try { 

    // adding Concept(s)
    ConceptSchema internalSystemErrorSchema = new ConceptSchema(INTERNALSYSTEMERROR);
    add(internalSystemErrorSchema, ibspan.tss.messaging.ontology.InternalSystemError.class);
    ConceptSchema mapSchema = new ConceptSchema(MAP);
    add(mapSchema, ibspan.tss.messaging.ontology.Map.class);
    ConceptSchema owlDataSchema = new ConceptSchema(OWLDATA);
    add(owlDataSchema, ibspan.tss.messaging.ontology.OWLData.class);
    ConceptSchema mapEntrySchema = new ConceptSchema(MAPENTRY);
    add(mapEntrySchema, ibspan.tss.messaging.ontology.MapEntry.class);
    ConceptSchema userRequestSchema = new ConceptSchema(USERREQUEST);
    add(userRequestSchema, ibspan.tss.messaging.ontology.UserRequest.class);
    ConceptSchema conceptWithInfoSchema = new ConceptSchema(CONCEPTWITHINFO);
    add(conceptWithInfoSchema, ibspan.tss.messaging.ontology.ConceptWithInfo.class);
    ConceptSchema dataViewSchema = new ConceptSchema(DATAVIEW);
    add(dataViewSchema, ibspan.tss.messaging.ontology.DataView.class);
    ConceptSchema dataModelSchema = new ConceptSchema(DATAMODEL);
    add(dataModelSchema, ibspan.tss.messaging.ontology.DataModel.class);
    ConceptSchema userContextSchema = new ConceptSchema(USERCONTEXT);
    add(userContextSchema, ibspan.tss.messaging.ontology.UserContext.class);

    // adding AgentAction(s)
    AgentActionSchema rsA_actionSchema = new AgentActionSchema(RSA_ACTION);
    add(rsA_actionSchema, ibspan.tss.messaging.ontology.RSA_action.class);
    AgentActionSchema pA_actionSchema = new AgentActionSchema(PA_ACTION);
    add(pA_actionSchema, ibspan.tss.messaging.ontology.PA_action.class);
    AgentActionSchema shA_process_user_requestSchema = new AgentActionSchema(SHA_PROCESS_USER_REQUEST);
    add(shA_process_user_requestSchema, ibspan.tss.messaging.ontology.SHA_process_user_request.class);
    AgentActionSchema shA_get_login_screenSchema = new AgentActionSchema(SHA_GET_LOGIN_SCREEN);
    add(shA_get_login_screenSchema, ibspan.tss.messaging.ontology.SHA_get_login_screen.class);
    AgentActionSchema vtA_construct_viewSchema = new AgentActionSchema(VTA_CONSTRUCT_VIEW);
    add(vtA_construct_viewSchema, ibspan.tss.messaging.ontology.VTA_construct_view.class);
    AgentActionSchema pmA_init_user_profileSchema = new AgentActionSchema(PMA_INIT_USER_PROFILE);
    add(pmA_init_user_profileSchema, ibspan.tss.messaging.ontology.PMA_init_user_profile.class);
    AgentActionSchema rsA_find_restaurantSchema = new AgentActionSchema(RSA_FIND_RESTAURANT);
    add(rsA_find_restaurantSchema, ibspan.tss.messaging.ontology.RSA_find_restaurant.class);
    AgentActionSchema shA_actionSchema = new AgentActionSchema(SHA_ACTION);
    add(shA_actionSchema, ibspan.tss.messaging.ontology.SHA_action.class);
    AgentActionSchema rsA_get_domain_ontologySchema = new AgentActionSchema(RSA_GET_DOMAIN_ONTOLOGY);
    add(rsA_get_domain_ontologySchema, ibspan.tss.messaging.ontology.RSA_get_domain_ontology.class);
    AgentActionSchema pmA_get_user_profileSchema = new AgentActionSchema(PMA_GET_USER_PROFILE);
    add(pmA_get_user_profileSchema, ibspan.tss.messaging.ontology.PMA_get_user_profile.class);
    AgentActionSchema shA_welcome_userSchema = new AgentActionSchema(SHA_WELCOME_USER);
    add(shA_welcome_userSchema, ibspan.tss.messaging.ontology.SHA_welcome_user.class);
    AgentActionSchema vtA_actionSchema = new AgentActionSchema(VTA_ACTION);
    add(vtA_actionSchema, ibspan.tss.messaging.ontology.VTA_action.class);
    AgentActionSchema rsA_get_restaurants_detailsSchema = new AgentActionSchema(RSA_GET_RESTAURANTS_DETAILS);
    add(rsA_get_restaurants_detailsSchema, ibspan.tss.messaging.ontology.RSA_get_restaurants_details.class);
    AgentActionSchema shA_subscribe_for_new_eventsSchema = new AgentActionSchema(SHA_SUBSCRIBE_FOR_NEW_EVENTS);
    add(shA_subscribe_for_new_eventsSchema, ibspan.tss.messaging.ontology.SHA_subscribe_for_new_events.class);
    AgentActionSchema pA_process_user_requestSchema = new AgentActionSchema(PA_PROCESS_USER_REQUEST);
    add(pA_process_user_requestSchema, ibspan.tss.messaging.ontology.PA_process_user_request.class);
    AgentActionSchema shA_internal_action_nameSchema = new AgentActionSchema(SHA_INTERNAL_ACTION_NAME);
    add(shA_internal_action_nameSchema, ibspan.tss.messaging.ontology.SHA_internal_action_name.class);
    AgentActionSchema pmA_actionSchema = new AgentActionSchema(PMA_ACTION);
    add(pmA_actionSchema, ibspan.tss.messaging.ontology.PMA_action.class);

    // adding AID(s)

    // adding Predicate(s)
    PredicateSchema haveNewEventsSchema = new PredicateSchema(HAVENEWEVENTS);
    add(haveNewEventsSchema, ibspan.tss.messaging.ontology.HaveNewEvents.class);


    // adding fields
    internalSystemErrorSchema.add(INTERNALSYSTEMERROR_MESSAGE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    mapSchema.add(MAP_HASENTRY, mapEntrySchema, 0, ObjectSchema.UNLIMITED);
    owlDataSchema.add(OWLDATA_SYNTAXLANGUAGE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    owlDataSchema.add(OWLDATA_DATAMODEL, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    owlDataSchema.add(OWLDATA_WITHROOTURI, (TermSchema)getSchema(BasicOntology.STRING), 0, ObjectSchema.UNLIMITED);
    mapEntrySchema.add(MAPENTRY_KEY, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    mapEntrySchema.add(MAPENTRY_VALUE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    userRequestSchema.add(USERREQUEST_USERCONTEXT, userContextSchema, ObjectSchema.OPTIONAL);
    userRequestSchema.add(USERREQUEST_ACTIONNAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    userRequestSchema.add(USERREQUEST_ACTIONPARAMS, mapSchema, ObjectSchema.OPTIONAL);
    conceptWithInfoSchema.add(CONCEPTWITHINFO_MESSAGEINFO, userContextSchema, ObjectSchema.OPTIONAL);
    dataViewSchema.add(DATAVIEW_CONTENT, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    dataModelSchema.add(DATAMODEL_OWLMODEL, owlDataSchema, ObjectSchema.OPTIONAL);
    dataModelSchema.add(DATAMODEL_CONSTRUCTORACTIONNAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    userContextSchema.add(USERCONTEXT_PEERID, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    userContextSchema.add(USERCONTEXT_INTERFACEHOST, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    userContextSchema.add(USERCONTEXT_USERID, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    userContextSchema.add(USERCONTEXT_INTERFACEPORT, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    userContextSchema.add(USERCONTEXT_MEDIATYPE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    userContextSchema.add(USERCONTEXT_SESSIONID, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    shA_process_user_requestSchema.add(SHA_PROCESS_USER_REQUEST_USERREQUEST, userRequestSchema, ObjectSchema.OPTIONAL);
    vtA_construct_viewSchema.add(VTA_CONSTRUCT_VIEW_MODEL, dataModelSchema, ObjectSchema.OPTIONAL);
    vtA_construct_viewSchema.add(VTA_CONSTRUCT_VIEW_USERCONTEXT, userContextSchema, ObjectSchema.OPTIONAL);
    vtA_construct_viewSchema.add(VTA_CONSTRUCT_VIEW_ACTIONNAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    pmA_init_user_profileSchema.add(PMA_INIT_USER_PROFILE_WEALTH, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    pmA_init_user_profileSchema.add(PMA_INIT_USER_PROFILE_USERID, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    pmA_init_user_profileSchema.add(PMA_INIT_USER_PROFILE_AGE, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    pmA_init_user_profileSchema.add(PMA_INIT_USER_PROFILE_PROFESSION, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    pmA_init_user_profileSchema.add(PMA_INIT_USER_PROFILE_DRESS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    rsA_find_restaurantSchema.add(RSA_FIND_RESTAURANT_HASQUERY, mapSchema, ObjectSchema.OPTIONAL);
    pmA_get_user_profileSchema.add(PMA_GET_USER_PROFILE_USERID, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    rsA_get_restaurants_detailsSchema.add(RSA_GET_RESTAURANTS_DETAILS_ABOUTRESTAURANT, (TermSchema)getSchema(BasicOntology.STRING), 0, ObjectSchema.UNLIMITED);
    shA_subscribe_for_new_eventsSchema.add(SHA_SUBSCRIBE_FOR_NEW_EVENTS_CONDITION, haveNewEventsSchema, ObjectSchema.OPTIONAL);
    pA_process_user_requestSchema.add(PA_PROCESS_USER_REQUEST_ACTIONNAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    pA_process_user_requestSchema.add(PA_PROCESS_USER_REQUEST_ACTIONPARAMS, mapSchema, ObjectSchema.OPTIONAL);
    haveNewEventsSchema.add(HAVENEWEVENTS_EVENTS, owlDataSchema, ObjectSchema.OPTIONAL);
    haveNewEventsSchema.add(HAVENEWEVENTS_PACKSIZE, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);

    // adding name mappings

    // adding inheritance
    shA_process_user_requestSchema.addSuperSchema(shA_actionSchema);
    shA_get_login_screenSchema.addSuperSchema(shA_internal_action_nameSchema);
    vtA_construct_viewSchema.addSuperSchema(vtA_actionSchema);
    pmA_init_user_profileSchema.addSuperSchema(pmA_actionSchema);
    rsA_find_restaurantSchema.addSuperSchema(rsA_actionSchema);
    rsA_get_domain_ontologySchema.addSuperSchema(rsA_actionSchema);
    pmA_get_user_profileSchema.addSuperSchema(pmA_actionSchema);
    shA_welcome_userSchema.addSuperSchema(shA_internal_action_nameSchema);
    rsA_get_restaurants_detailsSchema.addSuperSchema(rsA_actionSchema);
    shA_subscribe_for_new_eventsSchema.addSuperSchema(shA_internal_action_nameSchema);
    pA_process_user_requestSchema.addSuperSchema(pA_actionSchema);
    shA_internal_action_nameSchema.addSuperSchema(shA_actionSchema);

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
  }
