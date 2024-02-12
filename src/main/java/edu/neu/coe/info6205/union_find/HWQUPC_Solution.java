package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {

    public static int count(int n) {

        UF_HWQUPC uf = new UF_HWQUPC(n);
        int connections = 0;  // Counter
        Random random = new Random();

        while (uf.components() > 1) { //until all sites are interconnected
            int p = random.nextInt(n);
            int q = random.nextInt(n);

            if (!uf.connected(p, q)) {// if the two are not connected, then connect.
                uf.union(p, q);
                connections++;
            }
        }

        return connections;//Return the total number of connections
    }
    public static void main(String[] args) {
        int[] testValues = {1000, 2000, 4000, 8000, 16000};
        for (int n : testValues) {
            int totalConnections = 0;
            int runs = 10;  // run 10 times
            for (int i = 0; i < runs; i++) {
                totalConnections += count(n);
            }
            double averageConnections = (double) totalConnections / runs;
            System.out.println("For n = " + n + ", the number of average connections m is = " + averageConnections);
        }
    }
}
/*    The output from the console:
For n = 1000, the number of average connections m is = 999.0
For n = 2000, the number of average connections m is = 1999.0
For n = 4000, the number of average connections m is = 3999.0
For n = 8000, the number of average connections m is = 7999.0
For n = 16000, the number of average connections m is = 15999.0

So, based on the observation, the m and n relationship is m = n-1
 */