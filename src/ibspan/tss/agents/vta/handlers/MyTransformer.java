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
package ibspan.tss.agents.vta.handlers;

import ibspan.tss.core.semantic.Memory;
import ibspan.tss.layout.ViewParams;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.messaging.ontology.DataModel;
import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.UserContext;
import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.util.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.adtech.jastor.JastorException;

/**
 * This implementation utilizes <i>Raccoon server</i> for formatting view.
 * Raccoon server must be correctly configurated and provide access both via.
 * Internet interface and local directory. Whole process of transforming is
 * realized by <code>transform()</code> method in the following manner:
 * <ol>
 * <li>Received <code>DataModel</code> object is written in the directory
 * Raccoon server provides for storing temporary models.
 * <li>Raccoon server is called via URL address to transform file with model
 * according to the action name (suggested by <code>ModelConstructor</code> or
 * <code>PersonalModelConstructor</code>) and type of media, users have to
 * access the system.
 * <li>Eventually temporary file with model is removed and response returned from
 * Raccoon server is put into <code>DataView</code> object and returned.
 * </ol>
 * 
 * @author Pawel Kaczmarek
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see <a href="http://www.liminalzone.org/Raccoon">Raccoon</a>
 */
public class MyTransformer extends ViewTransformer {
	
	private static Logger logger = Logger.getMyLogger(MyTransformer.class.getName());
	
	
	//private String RaccoonURL;
	//private String RaccoonDir;
	private URLEncoder encoder = new URLEncoder();
	
	// ID of job the Raccoon server is currently obligated to do. Used for
	// generation of unique names for files with OWL models to be transformed
	private int jobID = 0;
	

	public MyTransformer(Agent a, DataStore ds, Object requestKey,
			Object actKey, Object notificationKey) {
		super(a, ds, requestKey, actKey, notificationKey);

		//RaccoonURL = myAgent.getConf_RACCOON_URL();
		//RaccoonDir = myAgent.getConf_RACCOON_DIR();		
	}


	protected DataView transform(DataModel model, UserContext context) {
		// Prepare data model coming from model constructor
		Memory modelMem = new Memory(model.getOwlModel());
		
		// Add context of the user to the internal model of modelMem
		try {
			ibspan.tss.layout.ontology.datamodel.UserContext dmContext = 
				DataModelFactory.createUserContext(modelMem.getModel().createResource(), modelMem.getModel());
			dmContext.setHasInterfaceHost(context.getInterfaceHost());
			dmContext.setHasInterfacePort(context.getInterfacePort());
			dmContext.setHasMediaType(context.getMediaType());
			dmContext.setHasSessionID(context.getSessionID());
			dmContext.setHasUserID(context.getUserID());
		} catch (JastorException e) {
			throw new RuntimeException(e);
		}
		
		String modelFile = getTempModelFile();
		// TODO: this is not efficient serialization: model -> string -> file, better model -> file
		//String modelLocalPath = RaccoonDir + modelFile;
		
		/*try {
			writeFile(modelMem.dump(), modelLocalPath);
		} catch (IOException e) {
			throw new RuntimeException("Problem with writing model to local file", e);
		}*/
		
		// Prepare query string for URI of Raccoon server
		String service;
		{
			String query = "";
			query += ViewParams.ACTION_NAME_KEY + "=" + model.getConstructorActionName() + "&";
			query += ViewParams.MEDIA_TYPE_KEY + "=" + context.getMediaType() + "&";
			
			if (context.getSessionID() != null) {
			query += ViewParams.SESSION_ID_KEY + "=" + context.getSessionID() + "&";
				if (context.getUserID() != ViewParams.UNKNOWN_USER_ID )
					query += ViewParams.USER_ID_KEY + "=" + context.getUserID() + "&";
			}
			query += "dummy=nothing";	
			service = modelFile + "?"+ query;
			//service = RaccoonURL + modelFile + "?" + query;
		}
		logger.log(Level.INFO,"MEM:"+modelMem.dump());
		String result = modelMem.dump();
		logger.log(Level.INFO,"QUERY:"+modelFile + "?"+service);
		/*result = JunksCleaner.clean(result);
		
		// Save URL references
		try {
			result = encoder.encode(result);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		File file = new File(modelLocalPath);
		file.delete();

		DataView view = null;
		if (result != null) {
			view = new DataView();
			view.setContent(result);				
		} 
		return view;*/
	    DataView view = new DataView();
	    view.setContent(result);
	    return view;
	}

    /**
     * Writes content to the pointed file
     * 
     * @param content
     *            Data to write into the file
     * @param fpath
     *            The path of file
     * 
     */
    private void writeFile(String content, String fpath) throws IOException {
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( fpath ) ) );
        out.write( content );
        out.close();
    }
    
    private String getTempModelFile() {
		jobID++;
    	return this.hashCode() + jobID + ".owl";
    	
    }
    
    /**
     * Fetch content of the remote file pointed with URL
	 * 
	 * @param urlName
	 *            URL pointing the file
	 * @return Content of the file
	 */
	private static String readURL(String urlString)
			throws MalformedURLException, IOException {

		InputStream is = null;
		BufferedReader in = null;
		String res = "";
		try {
			URL url = new URL(urlString);
			is = url.openStream();
			in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null)
				res += line + "\n";
		} finally {
			if (is != null)
				is.close();
			if (in != null)
				in.close();
		}
		//TODO
		return "<html>Hello Mon</html>";
		//return res;
	}
	
	private static class JunksCleaner {
		private static List<String> junks = new ArrayList<String>();
		static {
			junks.add("xmlns=\"http://www.w3.org/1999/xhtml\"");
			junks.add("xmlns=\"http://www.agentlab.net/schemas/location#\"");
			junks.add("amp;");
		}

		public static String clean(String junkyText) {
			// Cuts String elements of junk List from source
			Iterator i = junks.iterator();
			while (i.hasNext()) {
				String junkPiece = (String) i.next();
				junkyText = junkyText.replaceAll(junkPiece, "");
			}
			return junkyText;
		}
	}
	
	
	// This class allows query string of hyperlinks (inside of HTML/WML file) to
	// contain special signs, such as '#' etc. It is responsility of ProxyAgent
	// to decode it back when the user click such a encoded hyperlink.
	private class URLEncoder {
		
		private Pattern pattern;
	
		public URLEncoder() {
			String regEx = "([^\"']*)(\"|')(http://[^?]*\\?)([^\"]*)(\\2)";
			pattern = Pattern.compile(regEx);	
		}
		
		public String encode(String in) throws UnsupportedEncodingException {
			Matcher matcher = pattern.matcher(in);
			StringBuffer buffer = new StringBuffer();
			String s;
			while (matcher.find()) {				
				s = matcher.group(1) + matcher.group(2) +matcher.group(3);
				s += java.net.URLEncoder.encode(matcher.group(4),"UTF-8");
				s += matcher.group(5);
		
				matcher.appendReplacement(buffer, s);
			
	        }
			matcher.appendTail(buffer);
			return buffer.toString();
		}
	}
	

}
