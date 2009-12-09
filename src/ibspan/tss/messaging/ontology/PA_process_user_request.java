package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PA-process-user-request
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class PA_process_user_request extends PA_action{ 

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
