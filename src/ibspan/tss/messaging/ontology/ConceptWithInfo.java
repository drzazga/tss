package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: ConceptWithInfo
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class ConceptWithInfo implements Concept {

   /**
* Protege name: messageInfo
   */
   private UserContext messageInfo;
   public void setMessageInfo(UserContext value) { 
    this.messageInfo=value;
   }
   public UserContext getMessageInfo() {
     return this.messageInfo;
   }

}
