package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: MapEntry
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class MapEntry implements Concept {

   /**
* Protege name: key
   */
   private String key;
   public void setKey(String value) { 
    this.key=value;
   }
   public String getKey() {
     return this.key;
   }

   /**
* Protege name: value
   */
   private String value;
   public void setValue(String value) { 
    this.value=value;
   }
   public String getValue() {
     return this.value;
   }

}
