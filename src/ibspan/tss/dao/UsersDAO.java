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
package ibspan.tss.dao;

import ibspan.tss.layout.ViewParams;
import ibspan.tss.um.ontology.User;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.vocabulary.UsersDBVocabulary;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Selector;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.ibm.adtech.jastor.JastorException;

/**
 * Data Access Object providing nice interface to model with users accounts.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class UsersDAO {
	// Model of users.
	private OntModel mUsersDB;

	// Points to the last user registered in model with users.
	private User lastUser;
	
	/**
	 * Creates <code>UserDAO</code> object providing interface to the given
	 * users model.
	 * 
	 * @param mUsersDB
	 *            is model with users.
	 * @throws DAOException
	 *             when there is a problem with initializing this object.
	 */
	public UsersDAO(OntModel mUsersDB) throws DAOException {
		this.mUsersDB = mUsersDB;
		
		try {
			// Find the user which registered recently.
			Resource r = mUsersDB.createResource(UsersDBVocabulary.NS + User.LastUser.getLocalName());
			if (mUsersDB.getBaseModel().contains(r, RDF.type, User.TYPE)) {
				// UsersDB contains LastUser
				lastUser = UserModellingFactory.getUser(r,mUsersDB);
			} else {
				// UsersDB contains no LastUser, so this first time we use this
				// model -- initialize it
				lastUser = UserModellingFactory.createUser(r,mUsersDB);
				lastUser.setHasUserID(0);
			}
		} catch (JastorException e) {
			throw new DAOException("Error while iniliazing UsersDAO. ", e);
		}
	}
	
	/**
	 * Creates (registers) an account for the user with given properties.
	 * 
	 * @param name
	 *            is a name for a new user.
	 * @param login
	 *            is a login name for a new user.
	 * @param password
	 *            is a password for a new user.
	 * @return ID of user registered.
	 * @throws UserAlreadyKnownException
	 *             when trying to register user which have the name or login
	 *             name exactly the same as the one already registered.
	 */
	public int registerUser(String name, String login, String password) throws UserAlreadyKnownException {
		if (isUserKnown(name, login))
			throw new UserAlreadyKnownException("");
		
		try {
			// Realize registering process in transaction
			mUsersDB.begin();
			User user = UserModellingFactory.createUser(mUsersDB.createResource(), mUsersDB);
			
			int lastUserID = lastUser.getHasUserID();	
			user.setHasUserID(++lastUserID);
			lastUser.setHasUserID(lastUserID);
			
			
			user.setHasName(name);
			user.setHasLogin(login);
			user.setHasPassword(password);
			
			mUsersDB.commit();
			
			return lastUserID;
		} catch (JastorException e) {
			mUsersDB.abort();
			throw new RuntimeException("Cannot access data about user.", e);
		}		
	}
	
	/**
	 * Checks whether given login name matches to the given password, i.e.
	 * authorizes user.
	 * 
	 * @param login
	 *            is a login name.
	 * @param password
	 *            is a password.
	 * @return <code>true</code> if authorization passed successfully.
	 */
	public boolean isLoginPasswordMatching(final String login, final String password) {
		// Since mUsersDB is database backed model, which has limitation of the
		// current database backend that the semantic mapping between plain and
		// typed (xsd:string) literals doesn't work. Therefore we need to check
		// against a typed literal.		
		Selector sel = new SimpleSelector(null, RDF.type, User.TYPE) {
			public boolean selects(Statement s) {
				Resource subj = s.getSubject();
				return subj.hasProperty(User.hasLoginProperty, 
						mUsersDB.createTypedLiteral(login, XSDDatatype.XSDstring)) &&
				subj.hasProperty(User.hasPasswordProperty, 
						mUsersDB.createTypedLiteral(password, XSDDatatype.XSDstring));
			}
		};
		return mUsersDB.listStatements(sel).hasNext();		
	}
	
	/**
	 * Returns ID of a user with the given login name.
	 * @param login is a login name.
	 * @return ID of a user.
	 */
	public int getUserID(final String login) {
		try {
			Selector sel = new SimpleSelector(null, RDF.type, User.TYPE) {
				public boolean selects(Statement s) {
					Resource subj = s.getSubject();
					return subj.hasProperty(User.hasLoginProperty, 
							mUsersDB.createTypedLiteral(login, XSDDatatype.XSDstring));
				}
			};
			StmtIterator it = mUsersDB.listStatements(sel); 
			if (it.hasNext()) {
				User u = UserModellingFactory.getUser(it.nextStatement().getSubject(), mUsersDB);
				return u.getHasUserID();
			} else
				return ViewParams.UNKNOWN_USER_ID;
		} catch (JastorException e) {
			throw new RuntimeException("Problem with accessing user data.", e);
		}
	}
	
	/**
	 * Returns a name for the user with the given ID.
	 * @param userID is ID of user
	 * @return a name of a user
	 */
	public String getUserName(final int userID) {
		try {
			Selector sel = new SimpleSelector(null, RDF.type, User.TYPE) {
				public boolean selects(Statement s) {
					Resource subj = s.getSubject();
					return subj.hasProperty(User.hasUserIDProperty, 
							mUsersDB.createTypedLiteral(userID, XSDDatatype.XSDint));
				}
			};
			StmtIterator it = mUsersDB.listStatements(sel); 
			if (it.hasNext()) {
				User u = UserModellingFactory.getUser(it.nextStatement().getSubject(), mUsersDB);
				return u.getHasName();
			} else
				return null;
		} catch (JastorException e) {
			throw new RuntimeException("Problem with accessing user data.", e);
		}
	}
	
	/**
	 * Checks whether given name or login name has been registered.
	 * 
	 * @param name
	 *            is name of a user
	 * @param login
	 *            is login name of a user
	 * @return <code>true</code> is such user exists.
	 */
	public boolean isUserKnown(final String name, final String login) {
		Selector sel = new SimpleSelector(null, RDF.type, User.TYPE) {
			public boolean selects(Statement s) {
				Resource subj = s.getSubject();
				return subj.hasProperty(User.hasLoginProperty, 
						mUsersDB.createTypedLiteral(login, XSDDatatype.XSDstring)) ||
					subj.hasProperty(User.hasNameProperty, 
						mUsersDB.createTypedLiteral(name, XSDDatatype.XSDstring));
			}
		};
		return mUsersDB.listStatements(sel).hasNext();		
	}
	
	/**
	 * Returns ID under which next user can be registered.
	 * 
	 * @return user ID
	 */
	public int getNextUserID() {
		try {
			return lastUser.getHasUserID() + 1;
		} catch (JastorException e) {
			throw new RuntimeException("Problem accessing user information", e);
		}
	}
}
