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
package ibspan.tss.agents.pra;

import ibspan.tss.messaging.ontology.DataView;
import ibspan.tss.messaging.ontology.UserRequest;

/**
 * ProxyAgent is place where asynchronous work of the system meets with synchronous
 * work of HTTP protocol. This interface provides mechanizm of transparent (for
 * a client) synchronous delivery of response to the client.
 * 
 * @author Pawel Kaczmarek
 */
public interface SynchronousController {
    /**
	 * Proceses request from outside of the System.
	 * 
	 * @param request -
	 *            request of the client
	 * @return response of the System
	 * @throws SystemResponseException
	 */
    DataView process(UserRequest request) throws SystemResponseException;
}