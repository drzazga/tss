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
package ibspan.tss.um.statistics;

/**
 * Calculator for simple statistic operations.
 * 
 * @author <a href="mailto:maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class StatisticCalculator {

    /**
	 * Compute Z statistic for normal distribution.
	 * 
	 * @param prob
	 * @return
	 */
    public static double normalQuantile(double prob) {
        // 22.2.23 from Abramowitz & Stegun (1965), p. 933.
        double p = prob;
        double t, z;
        double c0 = 2.515517;
        double c1 = 0.802853;
        double c2 = 0.010328;
        double d1 = 1.432788;
        double d2 = 0.189269;
        double d3 = 0.001308;

        if (prob > .5)
            p = 1 - p; // approx only valid for 0 < p <= .5
        t = Math.sqrt( -2 * Math.log( p ) );
        z = t - (c0 + c1 * t + c2 * t * t) / (1 + d1 * t + d2 * t * t + d3 * t * t * t);
        if (prob < .5)
            return -z;
        else
            return z;

    }

    /**
	 * Computes mean value for binomial distribution.
	 * 
	 * @param p
	 *            probability of success
	 * @param n
	 *            number of success
	 * @return mean value
	 */
    public static double binomialMean(double p, double n) {
        return p * n;
    }

    /**
	 * Computes standard deviation for binomial distribution.
	 * 
	 * @param p
	 *            probability of success
	 * @param n
	 *            number of probes
	 * @return standandar deviation
	 */

    public static double binomialStdDev(double p, double n) {
        return Math.sqrt( p * (1 - p) * n );
    }

    /**
	 * Computes sigmoid function for the given argument
	 * 
	 * @param x
	 *            argument
	 * @param a
	 *            'a' parameter
	 * @return value of the function
	 */
    public static double sigmoid(double x, double a) {
        return 1.0 / (1.0 + Math.exp( a * x ));
    }
    

    
    /**
	 * Estimating of k-th q-quantile based on empirical distribution function
	 * with averaging.
	 * 
	 * Detailed equations can be found <a
	 * href="http://en.wikipedia.org/wiki/Quantile#Estimating_the_quantiles">here</a>.
	 * 
	 * @param q
	 *            is order of quantile
	 * @param k
	 *            is number of quantile
	 * @param population
	 *            sample population sorted ascendingly
	 * @return value of k-th q-quantile from the given population
	 */
    public static double quantile(int q, int k, double[] population) {
    	// TODO Check terminalogy (order, number of quantile)
    	
    	int N, j;
    	double p, g, d;
    	
    	N = population.length;
    	    	
    	p = k / q;
    	d = p * N;
    	j = (int) Math.floor(d); 
    	g = p* N - j;
    	if (g > 0)
    		return population[j];
    	else
    		return 0.5 * (population[j-1] + population[j]);
    	
    }
    
    /**
	 * Calculates expected value for distribution with given sample population.
	 * In fact this is average, since each individual in population has the same
	 * probability.
	 * 
	 * @param population
	 *            is sample population
	 * @return exptected value
	 */
	public static double expectedValue(double[] population) {
		double sum = 0;
		for (int i = 0; i < population.length; i++)
			sum += population[i];
		return sum / population.length;

	}
    
    

}