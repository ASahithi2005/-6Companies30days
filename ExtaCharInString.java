
//Time Complexity: O(n^2) where n is the length of the string s
import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Set<String> mp = new HashSet<>(Arrays.asList(dictionary));
        Arrays.fill(dp, -1);
        int ans = solve(s, mp, dp, 0);
        return ans;
    }

    public int solve(String s, Set<String> mp, int[] dp, int idx) {
        if (idx >= s.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        StringBuilder curStr = new StringBuilder();
        int ans = s.length();
        for (int cutIdx = idx; cutIdx < s.length(); cutIdx++) {
            curStr.append(s.charAt(cutIdx));
            String currentWord = curStr.toString();
            int count = ((mp.contains(currentWord)) ? 0 : currentWord.length()) + solve(s, mp, dp, cutIdx + 1);
            ans = Math.min(ans, count);
        }
        return dp[idx] = ans;
    }
}