package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: SHA-subscribe-for-new-events
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class SHA_subscribe_for_new_events extends SHA_internal_action_name{ 

   /**
* Protege name: condition
   */
   private HaveNewEvents condition;
   public void setCondition(HaveNewEvents value) { 
    this.condition=value;
   }
   public HaveNewEvents getCondition() {
     return this.condition;
   }

}
