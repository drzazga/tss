/*****************************************************************
 Agent-based Travel Support System
 Copyright (C) 2006 Maciej Gawinecki & Pawel Kaczmarek 

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor,  Boston, MA  
 02110-1301, USA.
 *****************************************************************/
package ibspan.tss.agents.pra.server;

import ibspan.tss.agents.pra.SynchronousController;
import jade.util.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

/**
 * It is HTTP server. When HTTP request comes, it creates Server thread.
 * 
 * @author Pawel Kaczmarek
 */
public class MainServer implements Runnable {
	
	private static Logger logger = Logger.getMyLogger(MainServer.class.getName());
	
	public static final String 	  MEDIA_TYPE_SUFFIX = "-media";
	public static final String    HTML_MEDIA_TYPE = "html" + MEDIA_TYPE_SUFFIX;
	public static final String    WML_MEDIA_TYPE = "wml" + MEDIA_TYPE_SUFFIX;
    public static final String    HTML_SERVER = HTML_MEDIA_TYPE;
    public static final String    WML_SERVER  = WML_MEDIA_TYPE;

    /**
     * Interface that exposes API of Agent-owner.
     */
    private SynchronousController listener;

    private int                   listenPort;

    /**
     * Type of media of this server (HTML, WML, etc.)
     */
    private String                mediaType;

    public MainServer(SynchronousController listener, int port, String mediaType) {
        this.listener = listener;
        this.listenPort = port;
        this.mediaType = mediaType;
    	
        logger.info( "HTTP Server for " + mediaType + " listening on port " + port + " ..." );
    }

    public void run() {
        ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(listenPort);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				UserRequestHandler handler = new UserRequestHandler(listener,
						clientSocket, mediaType);
				Thread clientThread = new Thread(handler);
				clientThread.start();
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IOException in Main Server: ", e);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Can't close server socket: ", e);

			}
		}
    }
}