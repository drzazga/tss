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
package ibspan.tss.agents.sha.session;

import jade.util.Logger;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/**
 * Simple class realizing DES-encrypting and decrypting procedures.
 * 
 * @author Patrick Chan
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class DesEncrypter {
	
	private static Logger logger = Logger.getMyLogger(DesEncrypter.class.getName());
	
    transient Cipher ecipher;
    transient Cipher dcipher;

    /**
	 * Constructs DesEncrypter.
	 * 
	 * @param key
	 *            is the A secret (symmetric) key which will be used to
	 *            initialize encrypting and decrypting procedures.
	 */
    public DesEncrypter(SecretKey key) {
        try {
            ecipher = Cipher.getInstance( "DES" );
            dcipher = Cipher.getInstance( "DES" );
            ecipher.init( Cipher.ENCRYPT_MODE, key );
            dcipher.init( Cipher.DECRYPT_MODE, key );
        } catch (Exception e) {
        	
        }
    }

    /**
	 * Returns the given string in a DES-encrypted form.
	 * 
	 * @param str
	 *            is a plain text to be encrypted
	 * @return encrypted form of a given string.
	 */
    public String encrypt(String str) {
        // Encrypt
		byte[] enc = null;
		try {
			// Encode the string into bytes using utf-8
			byte[] utf8 = str.getBytes( "UTF8" );

			enc = ecipher.doFinal( utf8 );
		} catch (Exception e) {
			logger.log(Level.SEVERE, "", e);
		}

        // Encode bytes to base64 to get a string
        return new sun.misc.BASE64Encoder().encode( enc );
        
    }

    /**
	 * Returns the given string, which was previously DES-encrypted with this
	 * DesEncrypter, in a plain text form.
	 * 
	 * @param str
	 *            is encrypted text to be descrypted.
	 * @return plain text
	 */
    public String decrypt(String str) {
    	String plain = null;
    	
    	try {
	        // Decode base64 to get bytes
	        byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer( str );
	
	        // Decrypt
	        byte[] utf8 = dcipher.doFinal( dec );
	
	        // Decode using utf-8
	        plain = new String( utf8, "UTF8" );
    	} catch(Exception e) {
    		logger.log(Level.SEVERE, "", e);
    	}
    	
    	return plain;
        
    }
}