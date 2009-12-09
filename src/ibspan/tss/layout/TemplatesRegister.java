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
package ibspan.tss.layout;

import ibspan.tss.agents.pa.handlers.PersonalModelConstructor;
import ibspan.tss.agents.sha.mvc.ModelConstructor;
import ibspan.tss.core.semantic.Memory;
import ibspan.tss.layout.ontology.datamodel.DataModelFactory;
import ibspan.tss.layout.ontology.datamodel.LayoutStructure;

import java.util.HashMap;
import java.util.Map;

import com.ibm.adtech.jastor.JastorException;

/**
 * This class stores templates used by <code>ModelConstructor</code> and
 * <code>PersonalModelConstructor</code> objects to prepare layout of system
 * response returned to the user.
 * 
 * <p>All templates are described in <i>db/templates.owl</i> file.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 * 
 * @see ModelConstructor
 * @see PersonalModelConstructor
 */
public class TemplatesRegister {
	// Store for registered templates.
	private Map<String, LayoutStructure> templates = new HashMap<String, LayoutStructure>();
	
	/**
	 * Registers template under the given name of action.
	 * @param actionName is the name of action
	 * @param template is the template to be registered.
	 */
	public void register(String actionName, LayoutStructure template) {
		templates.put(actionName, template);
	}
	
	/**
	 * Returns template for the given action.
	 * 
	 * @param actionName
	 *            is the name of action under which the required template has
	 *            been registered
	 * @return registered template; <code>null</code> if no template for the
	 *         given action
	 */
	public LayoutStructure get(String actionName) {
		return templates.get(actionName);
	}
	
	/**
	 * Creates copy of registered template.
	 * 
	 * @param actionName
	 *            is the name of action under which the required template has
	 *            been registered
	 * @return copy of required template
	 * @throws TemplateNotRegistered
	 *             when there is not template for the given action
	 */
	public LayoutStructure getCopy(String actionName) throws TemplateNotRegistered {
		// Creates copy of template using via Memory
		LayoutStructure template = (LayoutStructure) templates.get(actionName);
		if (template == null)
			throw new TemplateNotRegistered("Such template has not been registerd.");

		LayoutStructure layout = null;
		Memory memTmp = new Memory(template);
		try {
			layout = DataModelFactory.getLayoutStructure(template.resource().getURI(), memTmp.getModel());
		} catch (JastorException e) {
			throw new RuntimeException("Problem with accessing LayoutStructure object.", e);
		}
		return layout;
		
	}
}