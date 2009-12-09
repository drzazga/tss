package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
   * If successful -- returns Result concept with DataView as value field, otherwise (when failed) -- returns Result with ViewTransformingError
* Protege name: VTA-construct-view
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class VTA_construct_view extends VTA_action{ 

   /**
* Protege name: model
   */
   private DataModel model;
   public void setModel(DataModel value) { 
    this.model=value;
   }
   public DataModel getModel() {
     return this.model;
   }

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

}
