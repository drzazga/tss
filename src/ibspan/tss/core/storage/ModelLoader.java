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
package ibspan.tss.core.storage;

import jade.util.Logger;

import java.io.IOException;
import java.util.Properties;

import com.hp.hpl.jena.assembler.ConnectionDescription;
import com.hp.hpl.jena.db.impl.DriverMap;
import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.ProfileRegistry;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.util.FileManager;

/**
 * This class provides transparent access to ontology models by knowing only
 * URIs of their base namespaces. By indirect utilizing of
 * {@link com.hp.hpl.jena.util.LocationMapper} it maps these URIs into local
 * files. The developer in obligated to edit these mappings in default file:
 * <code>"etc/location-mapping.n3"</code>.
 * 
 * <p>To access persistent models stored in database it uses single connection
 * described in file pointed by the {@link #DB_CONNECTION_FILE} constant.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class ModelLoader {
	
	private static Logger logger = Logger.getMyLogger(ModelLoader.class.getName());	

	/**
	 * URL of property file describing access to database for this machine.
	 */
	public static final String DB_CONNECTION_FILE = "file:etc/db-conn.properties";	

	// Keys used in property files.
	public final static String DB_URL_KEY = "dbURL";
	public final static String DB_USER_KEY = "dbUser";
	public final static String DB_PASSWORD_KEY = "dbPassword";
	public final static String DB_TYPE_KEY = "dbType";
	
	// Description of single connection used to connect with a database
	private static ConnectionDescription connDesc;
	
	// Loads properties from the pointed URL.
	private static Properties loadProperties(String confURL) throws IOException {
		java.net.URL url = new java.net.URL(confURL);
		Properties conf = new Properties();
		conf.load(url.openStream());
		return conf;
	}

	/**
	 * Initializes ModelLoader from property file.
	 * 
	 * @throws IOException
	 *             when there is a problem with connecting with database.
	 */
	private static ConnectionDescription getConnectionDescription() throws IOException {
		FileManager.get().setModelCaching(true);

		Properties props = loadProperties(DB_CONNECTION_FILE);
		return new ConnectionDescription(props.getProperty(DB_URL_KEY),
				props.getProperty(DB_USER_KEY), props
						.getProperty(DB_PASSWORD_KEY), props
						.getProperty(DB_TYPE_KEY));
	}

	/**
	 * Loads content of the owl file pointed by given <code>uri</code> into
	 * persistent model stored in the database. The uri plays also two-fold
	 * role: (a) it stands for name of the model in database and (b) identify
	 * model, so it could be cached by {@link OntDocumentManager}; then each
	 * application using the same instance of OntDocumentManager accesses the
	 * same cached model.
	 * 
	 * <p>
	 * Primary, models are stored in local file and ModelLoaders tries to read
	 * them into database. This is done only for the first time of access to the
	 * particular model and this operation could time-consuming.
	 * 
	 * @param uri
	 *            the address of OWL file (usually its base namespace)
	 * @return model representing the OWL file
	 * @throws ModelLoaderInitException 
	 */
	public static OntModel loadDBModel(String uri) throws ModelLoaderInitException {
		if (connDesc == null) {
			try {
				connDesc = getConnectionDescription();
			} catch (IOException e) {
				throw new ModelLoaderInitException("Problem while reading properties file.", e);
			}
		}
		
		OntModelSpec ontModelSpec = getDBOntModelSpec(connDesc);
		ModelMaker baseMaker = ontModelSpec.getBaseModelMaker();
		OntModel model;
		if (baseMaker.hasModel(uri)) {
			Model base = baseMaker.getModel(uri);
			model = ModelFactory.createOntologyModel(ontModelSpec, base);
			
		} else {
			Model base = baseMaker.createModel(uri);
			model = ModelFactory.createOntologyModel(ontModelSpec, base);

			logger.info("Loading model <" + uri + "> into DB...");
			model.read(uri);
			logger.info("Done. ");
		}

		return model;
	}

	/**
	 * Loads content of the owl file pointed by given <code>uri</code> into
	 * memory-based model. The uri plays also the role of name of the model, so
	 * it is read into memory and cached, and then each application using the
	 * same instance of {@link OntDocumentManager} accesses the same cached
	 * model.
	 * 
	 * @param uri
	 *            the address of OWL file (usually its base namespace)
	 * @return model representing the OWL file
	 */
	public static OntModel loadModel(String uri) {
		return OntDocumentManager.getInstance().getOntology(uri,
				OntModelSpec.OWL_MEM_RULE_INF);
	}

	/**
	 * Creates specification for OntModel, in which (1) base Model is stored in
	 * the database described by the given connection description, and (2)
	 * imported ontology are stored in memory-based models.
	 * 
	 * @param desc
	 *            description of the database connection
	 * @return <code>null</code> if problem with creating model specification
	 *         occurs
	 * @throws ModelLoaderInitException 
	 */
	public static OntModelSpec getDBOntModelSpec(ConnectionDescription desc) throws ModelLoaderInitException {
		try {
			Class.forName(DriverMap.get(desc.dbType));
		} catch (ClassNotFoundException e) {
			throw new ModelLoaderInitException("JDBC Driver class not found. ", e);
		}

		ModelMaker baseMaker = ModelFactory.createModelRDBMaker(desc
				.getConnection());
		ModelMaker importMaker = ModelFactory.createMemModelMaker();
		String langURI = ProfileRegistry.OWL_LITE_LANG;

		return new OntModelSpec(baseMaker, importMaker, null, null, langURI);
	}

}
