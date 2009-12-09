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
package ibspan.tss.test;

import ibspan.tss.um.ontology.ContextParameter;
import ibspan.tss.um.ontology.Event;
import ibspan.tss.um.ontology.Opinion;
import ibspan.tss.um.ontology.OpinionSet;
import ibspan.tss.um.ontology.StatisticEntry;
import ibspan.tss.um.ontology.StatisticsMap;
import ibspan.tss.um.ontology.UserBehaviourContext;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.ontology.UserProfileData;

import java.io.PrintStream;
import java.util.Iterator;

import com.ibm.adtech.jastor.JastorException;

/**
 * 
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class PrettyPrinter {

	public static void print(Opinion o, PrintStream out) throws JastorException {
		out.println("OPINION about <" + o.getIsAbout() + ">");
		out.println("  Classified as:" + o.getHasClassification().resource().getLocalName());
		out.print("  p_ind = " + o.getAtIndividualProbability());
		out.print("   p_norm = " + o.getAtNormalizedProbability());
		out.print("   p_inf = " + o.getAtInferredProbability());
		out.println();
	}

	public static void print(UserProfile p, PrintStream out) throws JastorException {
		out.println("USER  identified by: " + p.getHasUserID());
		line(out);
		print(p.getHasUserProfileData(), out);
		line(out);
		print(p.getHasOpinions(), out);
		line(out);
	}

	public static void print(OpinionSet set, PrintStream out) throws JastorException {
		out.println("OPINION SET");
		for (Iterator<Opinion> it = set.getContainsOpinion(); it.hasNext(); print(it.next(), out))
			;
	}

	// TODO: rdf:label would be nice instead of local names for resources in
	// user-modelling ontology
	public static void print(UserProfileData d, PrintStream out) throws JastorException {
		out.println("USER DATA");
		out.println("  of AGE: " + d.getHasAge().getMapsLinearValue());
		out.println("  of DRESS: " + d.getHasDress().resource().getLocalName() + "(rank="
				+ d.getHasDress().getHasRank() + ")");
		out.println("  of PROFESSION: " + d.getHasProfession().resource().getLocalName());
		out.println("  of WEALTH: " + d.getHasWealth().resource().getLocalName() + "(rank="
				+ d.getHasWealth().getHasRank() + ")");
	}

	public static void print(StatisticsMap map, PrintStream out) throws JastorException {
		out.println("STATISTICS MAP");
		for (Iterator<StatisticEntry> it = map.getHasStatisticsEntry(); it.hasNext(); print(it
				.next(), out))
			line(out);
			;
	}

	public static void print(StatisticEntry e, PrintStream out) throws JastorException {
		out.println("STATISTIC");
		if (e.getHasConceptURI() != null)
			out.println("           about: <" + e.getHasConceptURI() + ">");
		else
			out.println("           about: ALL");			
		if (e.getHasUserID() != null)
			out.println("        for user: " + e.getHasUserID());
		else
			out.println("        for user: ALL");
		if (e.getHasUserBehaviour() != null)
			out.println("    of behaviour: " + e.getHasUserBehaviour().resource().getLocalName());
		else
			out.println("    of behaviour: ALL");		
		out.println("  == COUNTED ==== " + e.getHasCount() + " =============== ");
	}

	public static void print(Event e, PrintStream out) throws JastorException {
		out.println("EVENT  when: " + e.getWhen() + "  session: " + e.getHasSessionID()
				+ "  user: " + e.getHasUserID());
		out.println("       behaviour: "
				+ e.getHasExtendedUserBehaviour().getHasUserBehaviour().resource().getLocalName());
		UserBehaviourContext c = e.getHasExtendedUserBehaviour().getHasContext();
		out.println("       context: ");
		for (Iterator<ContextParameter> it = c.getHasParameter(); it.hasNext();) {
			ContextParameter p = it.next();
			out.println("         " + p.getHasName() + " = " + p.getHasValue());
		}
	}

	public static void line(PrintStream out) {
		out.println("-----------------------------------------------");
	}

}
