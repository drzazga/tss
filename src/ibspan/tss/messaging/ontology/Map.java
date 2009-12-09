package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Map
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class Map implements Concept {

   /**
* Protege name: hasEntry
   */
   private List hasEntry = new ArrayList();
   public void addHasEntry(MapEntry elem) { 
     List oldList = this.hasEntry;
     hasEntry.add(elem);
   }
   public boolean removeHasEntry(MapEntry elem) {
     List oldList = this.hasEntry;
     boolean result = hasEntry.remove(elem);
     return result;
   }
   public void clearAllHasEntry() {
     List oldList = this.hasEntry;
     hasEntry.clear();
   }
   public Iterator getAllHasEntry() {return hasEntry.iterator(); }
   public List getHasEntry() {return hasEntry; }
   public void setHasEntry(List l) {hasEntry = l; }

}
