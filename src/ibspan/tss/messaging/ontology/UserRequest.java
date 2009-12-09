package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: UserRequest
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class UserRequest implements Concept {

   /**
* Protege name: userContext
   */
   private UserContext userContext;
   public void setUserContext(UserContext value) { 
    this.userContext=value;
   }
   public UserContext getUserContext() {
     return this.userContext;
   }

   /**
* Protege name: actionName
   */
   private String actionName;
   public void setActionName(String value) { 
    this.actionName=value;
   }
   public String getActionName() {
     return this.actionName;
   }

   /**
* Protege name: actionParams
   */
   private Map actionParams;
   public void setActionParams(Map value) { 
    this.actionParams=value;
   }
   public Map getActionParams() {
     return this.actionParams;
   }

}
