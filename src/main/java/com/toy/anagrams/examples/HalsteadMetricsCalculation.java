package com.toy.anagrams.examples;

/**
 * The Halstead base metrics calculation example from
 * https://www.geeksforgeeks.org/software-engineering-halsteads-software-metrics/
 * to check the Metrics Reload plugin results.
 * The example results stated:
 * n1=14    N1=53    n2=10    N2=38  N=N1+N2=91 n=24 V=417
 */
public class HalsteadMetricsCalculation {

    int sort(int x[], int n) {
        int i, j, save, im1;
        /*This function sorts array x in ascending order */
        if (n < 2) return 1;
        for (i = 2; i <= n; i++) {
            im1 = i - 1;
            for (j = 1; j <= im1; j++)
                if (x[i] < x[j]) {
                    save = x[i];
                    x[i] = x[j];
                    x[j] = save;
                }
        }
        return 0;
    }

    /**
     * THe function from my course.
     * @param g0
     * @param g1
     * @return
     */
    int getGCD(int g0, int g1){
        while (g1 != 0) {
            int g2 = g0 % g1;
            g0 = g1;
            g1 = g2;
        }
        return g0;
    }


}
