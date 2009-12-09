package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: RSA-get-restaurants-details
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class RSA_get_restaurants_details extends RSA_action{ 

   /**
* Protege name: aboutRestaurant
   */
   private List aboutRestaurant = new ArrayList();
   public void addAboutRestaurant(String elem) { 
     List oldList = this.aboutRestaurant;
     aboutRestaurant.add(elem);
   }
   public boolean removeAboutRestaurant(String elem) {
     List oldList = this.aboutRestaurant;
     boolean result = aboutRestaurant.remove(elem);
     return result;
   }
   public void clearAllAboutRestaurant() {
     List oldList = this.aboutRestaurant;
     aboutRestaurant.clear();
   }
   public Iterator getAllAboutRestaurant() {return aboutRestaurant.iterator(); }
   public List getAboutRestaurant() {return aboutRestaurant; }
   public void setAboutRestaurant(List l) {aboutRestaurant = l; }

}
