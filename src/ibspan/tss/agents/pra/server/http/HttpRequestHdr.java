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
package ibspan.tss.agents.pra.server.http;



import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Parses and stores a http server request.
 * 
 * @author Pawel Kaczmarek
 * @author Sherman Janes
 */
public class HttpRequestHdr {

    /**
     * Http Request method. Such as get or post.
     */
    public String  method           = new String();

    /**
     * The requested url. The universal resource locator that hopefully uniquely
     * describes the object or service the client is requesting.
     */
    public String  url              = new String();

    public String  uri              = new String();

    public String  queryString      = new String();

    /**
     * Version of http being used. Such as HTTP/1.0
     */
    public String  version          = new String();

    /**
     * The client's browser's name.
     */
    public String  userAgent        = new String();

    /**
     * The requesting documents that contained the url link.
     */
    public String  referer          = new String();

    /**
     * A internet address date of the remote copy.
     */
    public String  ifModifiedSince  = new String();

    /**
     * A list of mime types the client can accept.
     */
    public String  accept           = new String();

    /**
     * The clients authorization. Don't belive it.
     */

    public String  authorization    = new String();

    /**
     * The type of content following the request header. Normally there is no
     * content and this is blank, however the post method usually does have a
     * content and a content length.
     */
    public String  contentType      = new String();

    /**
     * The length of the content following the header. Usually blank.
     */
    public int     contentLength    = -1;

    /**
     * The content length of a remote copy of the requested object.
     */
    public int     oldContentLength = -1;

    /**
     * Anything in the header that was unrecognized by this class.
     */
    public String  unrecognized     = new String();

    /**
     * Indicates that no cached versions of the requested object are to be sent.
     * Usually used to tell proxy not to send a cached copy. This may also
     * effect servers that are front end for data bases.
     */
    public boolean pragmaNoCache    = false;

    static String  CR               = "\r\n";

    /**
     * Parses a http header from a stream.
     * 
     * @param In
     *            The stream to parse.
     * @return true if parsing sucsessfull.
     */
    public void parse(InputStream In) throws HttpHeaderParseException {
        String CR = "\r\n";

        /*
         * Read by lines
         */
        DataInputStream lines;
        StringTokenizer tz;
        try {
            lines = new DataInputStream( In );
            tz = new StringTokenizer( lines.readLine() );
        } catch (Exception e) {
            throw new HttpHeaderParseException( e.getMessage() );
        }

        /*
         * HTTP COMMAND LINE < <METHOD==get> <URL> <HTTP_VERSION> >
         */
        method = getToken( tz ).toUpperCase();
        url = getToken( tz );
        version = getToken( tz );
        //pawel
        int i = 1;
        int j = 0;
        i = 1;
        j = url.indexOf( "?" );
        if (j > 0) {
            uri = url.substring( i, j );
            queryString = url.substring( j + 1, url.length() );
        } else {
            uri = url.substring( 1, url.length() );
        }
        //pawel

        while (true) {
            try {
                tz = new StringTokenizer( lines.readLine() );
            } catch (Exception e) {
                throw new HttpHeaderParseException( e.getMessage() );
            }
            String Token = getToken( tz );

            // look for termination of HTTP command
            if (0 == Token.length())
                break;

            if (Token.equalsIgnoreCase( "USER-AGENT:" )) {
                // line =<User-Agent: <Agent Description>>
                userAgent = getRemainder( tz );
            } else if (Token.equalsIgnoreCase( "ACCEPT:" )) {
                // line=<Accept: <Type>/<Form>
                // examp: Accept image/jpeg
                accept += " " + getRemainder( tz );

            } else if (Token.equalsIgnoreCase( "REFERER:" )) {
                // line =<Referer: <URL>>
                referer = getRemainder( tz );

            } else if (Token.equalsIgnoreCase( "PRAGMA:" )) {
                // Pragma: <no-cache>
                Token = getToken( tz );

                if (Token.equalsIgnoreCase( "NO-CACHE" ))
                    pragmaNoCache = true;
                else
                    unrecognized += "Pragma:" + Token + " " + getRemainder( tz ) + "\n";
            } else if (Token.equalsIgnoreCase( "AUTHORIZATION:" )) {
                // Authenticate: Basic UUENCODED
                authorization = getRemainder( tz );

            } else if (Token.equalsIgnoreCase( "IF-MODIFIED-SINCE:" )) {
                // line =<If-Modified-Since: <http date>
                // *** Conditional GET replaces HEAD method ***
                String str = getRemainder( tz );
                int index = str.indexOf( ";" );
                if (index == -1) {
                    ifModifiedSince = str;
                } else {
                    ifModifiedSince = str.substring( 0, index );

                    index = str.indexOf( "=" );
                    if (index != -1) {
                        str = str.substring( index + 1 );
                        oldContentLength = Integer.parseInt( str );
                    }
                }
            } else if (Token.equalsIgnoreCase( "CONTENT-LENGTH:" )) {
                Token = getToken( tz );
                contentLength = Integer.parseInt( Token );
            } else if (Token.equalsIgnoreCase( "CONTENT-TYPE:" )) {
                contentType = getRemainder( tz );
            } else {
                unrecognized += Token + " " + getRemainder( tz ) + CR;
            }
        }
    }

    /*
     * Rebuilds the header in a string @returns The header in a string.
     */
    public String toString(boolean sendUnknowen) {
        String Request;

        if (0 == method.length())
            method = "GET";

        Request = method + " " + url + " HTTP/1.0" + CR;

        if (0 < userAgent.length())
            Request += "User-Agent:" + userAgent + CR;

        if (0 < referer.length())
            Request += "Referer:" + referer + CR;

        if (pragmaNoCache)
            Request += "Pragma: no-cache" + CR;

        if (0 < ifModifiedSince.length())
            Request += "If-Modified-Since: " + ifModifiedSince + CR;

        // ACCEPT TYPES //
        if (0 < accept.length())
            Request += "Accept: " + accept + CR;
        else
            Request += "Accept: */" + "* \r\n";

        if (0 < contentType.length())
            Request += "Content-Type: " + contentType + CR;

        if (0 < contentLength)
            Request += "Content-Length: " + contentLength + CR;

        if (0 != authorization.length())
            Request += "Authorization: " + authorization + CR;

        if (sendUnknowen) {
            if (0 != unrecognized.length())
                Request += unrecognized;
        }

        Request += CR;

        return Request;
    }

    /**
     * (Re)builds the header in a string.
     * 
     * @return The header in a string.
     */
    public String toString() {
        return toString( true );
    }

    /**
     * Return the next token in a string
     * 
     * @param tk
     *            String that is partially tokenized.
     * @return The remainder
     */
    String getToken(StringTokenizer tk) {
        String str = "";
        if (tk.hasMoreTokens())
            str = tk.nextToken();
        return str;
    }

    /**
     * Returns the remainder of a tokenized string
     * 
     * @param tk
     *            String that is partially tokenized.
     * @return The remainder
     */
    String getRemainder(StringTokenizer tk) {
        String str = "";
        if (tk.hasMoreTokens())
            str = tk.nextToken();
        while (tk.hasMoreTokens()) {
            str += " " + tk.nextToken();
        }
        return str;
    }

    /**
     * @return Returns the queryString.
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * @param queryString
     *            The queryString to set.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     * @return Returns the uri.
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri
     *            The uri to set.
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String,String> getParameters() {
        Map<String,String> map = new HashMap<String,String>();
        
        try {
			this.queryString = java.net.URLDecoder.decode(this.queryString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
        
        StringTokenizer tokenizer = new StringTokenizer( this.queryString );
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken( "&" );
      
            StringTokenizer tokenizer2 = new StringTokenizer( token );
            if (tokenizer2.hasMoreTokens()) {
                String name = tokenizer2.nextToken( "=" );
                if (tokenizer2.hasMoreTokens()) {
                    String value = tokenizer2.nextToken( "=" );
                    map.put( name, value );
                } else {
                    map.put( name, "" );
                }
            }
        }
        return map;
    }
}