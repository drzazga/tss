
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

/*****************************************************************************
 * Source code information
 * -----------------------
 * Package            ibspan.tss.um.vocabulary
 * Created            27 sie 2006 04:39
 *****************************************************************************/

// Package
///////////////////////////////////////
package ibspan.tss.um.vocabulary;


// Imports
///////////////////////////////////////
import com.hp.hpl.jena.rdf.model.*;



/**
 * Vocabulary definitions from file:db/profiles.owl
 * @author Auto-generated by jena.schemagen on 27 sie 2006 04:39
 */
public class ProfilesDBVocabulary {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.ibspan.waw.pl/tss/db/Profiles#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    

    // Vocabulary properties
    ///////////////////////////


    // Vocabulary classes
    ///////////////////////////


    // Vocabulary individuals
    ///////////////////////////

}

/*
    TODO: Fill in footer
*/

