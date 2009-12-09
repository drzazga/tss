package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PMA-get-user-profile
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class PMA_get_user_profile extends PMA_action{ 

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

}
