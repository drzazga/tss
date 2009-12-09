package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: DataModel
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class DataModel implements Concept {

   /**
* Protege name: owlModel
   */
   private OWLData owlModel;
   public void setOwlModel(OWLData value) { 
    this.owlModel=value;
   }
   public OWLData getOwlModel() {
     return this.owlModel;
   }

   /**
* Protege name: constructorActionName
   */
   private String constructorActionName;
   public void setConstructorActionName(String value) { 
    this.constructorActionName=value;
   }
   public String getConstructorActionName() {
     return this.constructorActionName;
   }

}
