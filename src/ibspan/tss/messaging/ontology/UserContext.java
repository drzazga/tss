package ibspan.tss.messaging.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: UserContext
* @author ontology bean generator
* @version 2006/08/23, 10:35:10
*/
public class UserContext implements Concept {

   /**
* Protege name: peerID
   */
   private String peerID;
   public void setPeerID(String value) { 
    this.peerID=value;
   }
   public String getPeerID() {
     return this.peerID;
   }

   /**
* Protege name: interfaceHost
   */
   private String interfaceHost;
   public void setInterfaceHost(String value) { 
    this.interfaceHost=value;
   }
   public String getInterfaceHost() {
     return this.interfaceHost;
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
* Protege name: interfacePort
   */
   private int interfacePort;
   public void setInterfacePort(int value) { 
    this.interfacePort=value;
   }
   public int getInterfacePort() {
     return this.interfacePort;
   }

   /**
* Protege name: mediaType
   */
   private String mediaType;
   public void setMediaType(String value) { 
    this.mediaType=value;
   }
   public String getMediaType() {
     return this.mediaType;
   }

   /**
* Protege name: sessionID
   */
   private String sessionID;
   public void setSessionID(String value) { 
    this.sessionID=value;
   }
   public String getSessionID() {
     return this.sessionID;
   }

}
