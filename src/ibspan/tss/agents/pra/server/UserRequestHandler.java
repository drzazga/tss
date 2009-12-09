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
import ibspan.tss.agents.pra.SystemResponseException;
import ibspan.tss.agents.pra.server.http.HttpHeaderParseException;
import ibspan.tss.agents.pra.server.http.HttpReplyHdr;
import ibspan.tss.agents.pra.server.http.HttpRequestHdr;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.MapEntry;
import ibspan.tss.messaging.ontology.UserContext;
import ibspan.tss.messaging.ontology.UserRequest;
import jade.util.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

/**
 * It is a thread that handles the user request. It parses querystring, creates
 * ExternalRequest, passes it to the PrA (uses SynchronousController), receives
 * ExternalResponse, sends the response to the client
 * 
 * @author Pawel Kaczmarek
 */
public class UserRequestHandler implements Runnable {

	private static Logger logger = Logger.getMyLogger(UserRequestHandler.class.getName());
	
	public static final String UNPROCESSABLE_BY_SYSTEM_URI = "unimportant";

	private String _mediaType;

	private Socket clientSocket;

	/**
	 * This is passed to the Action instance so it could invoke ProxyAgent
	 * method when needed.
	 */
	private SynchronousController listener;

	// private String RaccoonServerURL = VTASettings.RACCOON_SERVER_URL;

	public UserRequestHandler(SynchronousController listener, Socket socket, String mediaType) {
		this.listener = listener;
		this.clientSocket = socket;
		this._mediaType = mediaType;
	}

	private String createHttpResponse(String view) {
		HttpReplyHdr reply = new HttpReplyHdr();

		String ContentType = "text/"
				+ this._mediaType.replaceFirst(MainServer.MEDIA_TYPE_SUFFIX, "");

		String userResponse = reply.formOk(ContentType, view.length());
		userResponse += view;

		return userResponse;
	}

	/**
	 * prepares ExteranalRequest based on HTTP request
	 * 
	 * @param requestHeader
	 * @return instance of ExteranalRequest
	 * @throws InvalidRequestException
	 */
	private UserRequest createUserRequest(final HttpRequestHdr requestHeader)
			throws InvalidRequestException {

		// gathering all data from request header
		Map<String, String> parameters = requestHeader.getParameters();

		int userID;
		try {
			String s = (String) parameters.remove(ViewParams.USER_ID_KEY);
			userID = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			userID = ViewParams.UNKNOWN_USER_ID;
		}

		String mediaType = (String) parameters.remove(ViewParams.MEDIA_TYPE_KEY);
		String actionName = (String) parameters.remove(ViewParams.ACTION_NAME_KEY);

		String sessionID = (String) parameters.remove(ViewParams.SESSION_ID_KEY);
		if (sessionID == null || sessionID.equals("")) {
			// this first time when user connects during this session
			
			if (mediaType == null || mediaType.equals(""))
				mediaType = this._mediaType;

			if (actionName == null)
				actionName = ViewParams.EMPTY_ACTION_NAME;
		} else if (mediaType == null)
			throw new InvalidRequestException("invalid proxy request");

		String peerID = clientSocket.getInetAddress().getHostName();
		String interfaceHost = "http://" + clientSocket.getLocalAddress().getCanonicalHostName();
		int interfacePort = clientSocket.getLocalPort();

		// Prepare context of user request which will be used then 
		UserContext context = new UserContext();
		context.setMediaType(mediaType);
		context.setSessionID(sessionID);
		context.setUserID(userID);
		context.setPeerID(peerID);
		context.setInterfaceHost(interfaceHost);
		context.setInterfacePort(interfacePort);

		ibspan.tss.messaging.ontology.Map actionParams = new ibspan.tss.messaging.ontology.Map();
		for (Iterator<String> it = parameters.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String value = parameters.get(key);
			MapEntry entry = new MapEntry();
			entry.setKey(key);
			entry.setValue(value);
			actionParams.addHasEntry(entry);
		}

		UserRequest request = new UserRequest();
		request.setActionName(actionName);
		request.setUserContext(context);
		request.setActionParams(actionParams);

		return request;
	}

	private String createUserResponse(DataView response) {
		return createHttpResponse(response.getContent());

	}

	/**
	 * This is ad-hoc solution for displaying distributed Exception/Error info
	 * to the User
	 * 
	 * @param e -
	 *            the Exception that occured
	 */
	private void handleError(Exception e) {
		String start = "";
		String end = "";
		if (isHtmlMedia()) {
			start = "<HTML><BODY>";
			end = "</BODY></HTML>";
		} else if (isWmlMedia()) {
			start = "<WML><CARD>";
			end = "</CARD></WML>";
		}
		try {
			String errorMsgBody = start + "<B>Internal system error occurred:</B><BR/>"
					+ e.getMessage() + end;
			sendResponseBack(createHttpResponse(errorMsgBody));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isHtmlMedia() {
		return MainServer.HTML_MEDIA_TYPE.equals(this._mediaType);
	}

	private boolean isWmlMedia() {
		return MainServer.WML_MEDIA_TYPE.equals(this._mediaType);
	}

	/**
	 * Transfers data from in stream to out stream.
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	private void pipe(InputStream in, OutputStream out) throws IOException {
		if (in == null || out == null)
			return;
		byte[] buf = new byte[256 * 1024];
		int len = 0;
		while ((len = in.read(buf, 0, buf.length)) != -1) {
			out.write(buf, 0, len);
		}
	}

	/**
	 * Parse request, create ExternalRequest, receive ExnternalResponse, send it
	 * to the client.
	 */
	public void run() {
		try {
			HttpRequestHdr requestHeader = new HttpRequestHdr();
			requestHeader.parse(clientSocket.getInputStream());

			String peerID = clientSocket.getLocalAddress().toString();
			logger.info("Processing user request from IP: " + peerID);

			UserRequest userRequest = createUserRequest(requestHeader);
			// Dispatch request to the listener and wait
			// for the system response
			DataView response = listener.process(userRequest);
			if (response == null)
				throw new SystemResponseException("System response is null");
			// System response came, so prepare response to the user
			// and send it back
			String userResponse = createUserResponse(response);
			sendResponseBack(userResponse);

		} catch (HttpHeaderParseException e) {
			logger.log(Level.SEVERE,"Problem with parsing HTTP header: ", e);
			handleError(e);

		} catch (IOException e) {
			logger.log(Level.SEVERE,"I/O problem: ", e);
			handleError(e);
		} catch (InvalidRequestException e) {
			logger.log(Level.SEVERE,"User request invalid: ", e);
			handleError(e);
		} catch (SystemResponseException e) {
			logger.log(Level.SEVERE,"System cannot prepared response: ", e);
			handleError(e);
		} finally {
			try {
				this.clientSocket.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Cannot close client socket: ", e);
			}
		}
		
	}

	private void sendResponseBack(String response) throws IOException {
		InputStream in = new ByteArrayInputStream(response.getBytes());
		OutputStream out = clientSocket.getOutputStream();
		pipe(in, out);
	}

}
