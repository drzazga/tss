package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: InternalSystemError
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class InternalSystemError implements Concept {

   /**
* Protege name: message
   */
   private String message;
   public void setMessage(String value) { 
    this.message=value;
   }
   public String getMessage() {
     return this.message;
   }

}
