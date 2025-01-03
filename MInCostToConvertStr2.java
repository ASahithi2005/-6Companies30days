
//Time Complexity : O(n); n is the length of the string
import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int INF = Integer.MAX_VALUE;
        int[][] conversionMatrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(conversionMatrix[i], INF);
            conversionMatrix[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            conversionMatrix[from][to] = Math.min(conversionMatrix[from][to], cost[i]);
        }
        // floyd warshall algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (conversionMatrix[i][k] != INF && conversionMatrix[k][j] != INF) {
                        int d = conversionMatrix[i][k] + conversionMatrix[k][j];
                        conversionMatrix[i][j] = Math.min(conversionMatrix[i][j], d);
                    }
                }
            }
        }
        int n = source.length();
        long total_cost = 0;
        for (int i = 0; i < n; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (conversionMatrix[from][to] == INF)
                return -1;
            total_cost = total_cost + conversionMatrix[from][to];

        }
        return total_cost;

    }
}