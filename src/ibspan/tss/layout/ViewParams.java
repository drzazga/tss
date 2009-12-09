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

/**
 * This interface provides set of constants for fields values used in HTML/WML
 * forms and variable names passed in <i>query string</i> sended from user
 * interface to <code>ProxyAgent</code>.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public interface ViewParams {
	/**
	 * Points value of <i>session id</i> variable passed in <i>query string</i>.
	 */
	public static final String SESSION_ID_KEY = "session-id";

	/**
	 * Points value of <i>media type</i> variable passed in <i>query string</i>.
	 */
	public static final String MEDIA_TYPE_KEY = "media-type";

	/**
	 * Points value of <i>action name</i> variable passed in <i>query string</i>.
	 */
	public static final String ACTION_NAME_KEY = "action-name";

	/**
	 * Points value of <i>user id</i> variable passed in <i>query string</i>.
	 */
	public static final String USER_ID_KEY = "user-id";

	/**
	 * Points "user unkown" value of <i>user id</i> variable passed in <i>query
	 * string</i>.
	 */
	public static final int UNKNOWN_USER_ID = -1;

	/**
	 * Points the name of field for login name in registering/logging in forms.
	 */
	public static final String LOGIN_KEY = "login";

	/**
	 * Points the name of field for user in registering/logging in forms.
	 */
	public static final String USER_NAME_KEY = "user-name";

	/**
	 * Points name of field for password in registering/logging in forms.
	 */
	public static final String PASSWORD_KEY = "password";

	/**
	 * Points "no action chosen" value of <i>action name</i> variable passed in
	 * <i>query string</i>.
	 */
	public static final String EMPTY_ACTION_NAME = "";

	/**
	 * Points the "no value selected" text displayed in <i>SELECT</i> box in
	 * HTML form.
	 */
	public static final String NONE_SELECTED = "-select-";
}
