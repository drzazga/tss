package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: OWLData
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class OWLData implements Concept {

   /**
* Protege name: syntaxLanguage
   */
   private String syntaxLanguage;
   public void setSyntaxLanguage(String value) { 
    this.syntaxLanguage=value;
   }
   public String getSyntaxLanguage() {
     return this.syntaxLanguage;
   }

   /**
* Protege name: dataModel
   */
   private String dataModel;
   public void setDataModel(String value) { 
    this.dataModel=value;
   }
   public String getDataModel() {
     return this.dataModel;
   }

   /**
* Protege name: withRootURI
   */
   private List withRootURI = new ArrayList();
   public void addWithRootURI(String elem) { 
     List oldList = this.withRootURI;
     withRootURI.add(elem);
   }
   public boolean removeWithRootURI(String elem) {
     List oldList = this.withRootURI;
     boolean result = withRootURI.remove(elem);
     return result;
   }
   public void clearAllWithRootURI() {
     List oldList = this.withRootURI;
     withRootURI.clear();
   }
   public Iterator getAllWithRootURI() {return withRootURI.iterator(); }
   public List getWithRootURI() {return withRootURI; }
   public void setWithRootURI(List l) {withRootURI = l; }

}
