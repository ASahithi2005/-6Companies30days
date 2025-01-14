import java.util.*;

class Solution {
    Map<String, Integer> mp = new HashMap<>();

    public int solve(int i, int jump, int canjumpback, int k) {
        if (i > k + 1)
            return 0;
        String key = i + "_" + jump + "_" + canjumpback;
        if (mp.containsKey(key)) {
            return mp.get(key);
        }
        int ways = 0;
        if (i == k)
            ways += 1;
        if (canjumpback == 1) {
            ways += solve(i - 1, jump, 0, k);
        }
        ways += solve(i + (int) Math.pow(2, jump), jump + 1, 1, k);
        mp.put(key, ways);
        return ways;
    }

    public int waysToReachStair(int k) {
        return solve(1, 0, 1, k);
    }
}
