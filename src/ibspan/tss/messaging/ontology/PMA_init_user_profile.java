package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PMA-init-user-profile
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class PMA_init_user_profile extends PMA_action{ 

   /**
* Protege name: wealth
   */
   private String wealth;
   public void setWealth(String value) { 
    this.wealth=value;
   }
   public String getWealth() {
     return this.wealth;
   }

   /**
* Protege name: userID
   */
   private int userID;
   public void setUserID(int value) { 
    this.userID=value;
   }
   public int getUserID() {
     return this.userID;
   }

   /**
* Protege name: age
   */
   private int age;
   public void setAge(int value) { 
    this.age=value;
   }
   public int getAge() {
     return this.age;
   }

   /**
* Protege name: profession
   */
   private String profession;
   public void setProfession(String value) { 
    this.profession=value;
   }
   public String getProfession() {
     return this.profession;
   }

   /**
* Protege name: dress
   */
   private String dress;
   public void setDress(String value) { 
    this.dress=value;
   }
   public String getDress() {
     return this.dress;
   }

}
