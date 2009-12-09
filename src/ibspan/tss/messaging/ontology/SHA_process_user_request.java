package ibspan.tss.messaging.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: SHA-process-user-request
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class SHA_process_user_request extends SHA_action{ 

   /**
* Protege name: userRequest
   */
   private UserRequest userRequest;
   public void setUserRequest(UserRequest value) { 
    this.userRequest=value;
   }
   public UserRequest getUserRequest() {
     return this.userRequest;
   }

}
