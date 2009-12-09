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
package ibspan.tss.agents;

import jade.core.Agent;
import jade.util.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.logging.Level;

/**
 * This is generic abstract class for all agents playining in the system. It
 * provides functionality of configurating an agent from properties file.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public abstract class SystemAgent extends Agent {

	private static Logger logger = Logger.getMyLogger(SystemAgent.class.getName());
	
	/**
	 * Constructs SystemAgent.
	 */
	public SystemAgent() {
		super();
	}

	/**
	 * Loads configuration from properties file for this agent and passes it to
	 * {@link #activateProperties(Properties)}. Property file is given as the first
	 * argument for the launched agent. The programmer is encouraged to call
	 * this method in her agent's <code>setup()</code> method.
	 */
	protected void setup() {
		Object[] args = getArguments();

			try {
				if (args != null && args.length == 1) {
					String confURL = (String) args[0];
					logger.info("Loading configuration from file: " + confURL);
					java.net.URL url = new java.net.URL(confURL);
					Properties conf = new Properties();
					conf.load(url.openStream());

					activateProperties(conf);

				} else {
					throw new IncorrectPropertiesException("Wrong number of configuration arguments");					
				}
			} catch (MalformedURLException e) {
				logger.log(Level.SEVERE,"Cannot read configuration", e);
				doDelete();
			} catch (IOException e) {
				logger.log(Level.SEVERE,"Cannot read configuration", e);
				doDelete();
			} catch (IncorrectPropertiesException e) {
				logger.log(Level.SEVERE,"Cannot read configuration", e);
				
			}
	}
	
	/**
	 * Activates configuration by processing given properties.
	 * 
	 * @param conf
	 *            are properties of the agent.
	 * @throws IncorrectPropertiesException
	 *             if properties are syntactically or semantically invalid.
	 * 
	 */
	protected abstract void activateProperties(Properties conf) throws IncorrectPropertiesException;
}
