package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: HaveNewEvents
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class HaveNewEvents implements Predicate {

   /**
* Protege name: events
   */
   private OWLData events;
   public void setEvents(OWLData value) { 
    this.events=value;
   }
   public OWLData getEvents() {
     return this.events;
   }

   /**
* Protege name: packSize
   */
   private int packSize;
   public void setPackSize(int value) { 
    this.packSize=value;
   }
   public int getPackSize() {
     return this.packSize;
   }

}
