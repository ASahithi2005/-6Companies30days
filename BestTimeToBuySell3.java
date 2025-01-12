
//Time Complexity: O(n*k) where k is 2
import java.util.*;

class Solution {
    int f(int ind, int tranno, int[] prices, int n, int k, int[][] dp) {
        if (ind == n || tranno == 2 * k)
            return 0;
        if (dp[ind][tranno] != -1)
            return dp[ind][tranno];
        if (tranno % 2 == 0) {
            return dp[ind][tranno] = Math.max(-prices[ind] + f(ind + 1, tranno + 1, prices, n, k, dp),
                    0 + f(ind + 1, tranno, prices, n, k, dp));
        }
        return dp[ind][tranno] = Math.max(prices[ind] + f(ind + 1, tranno + 1, prices, n, k, dp),
                0 + f(ind + 1, tranno, prices, n, k, dp));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][] dp = new int[n][2 * k];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, prices, n, k, dp);
    }
}