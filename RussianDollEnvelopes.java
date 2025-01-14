
//Time Complexity: O(n^2), Space Complexity: O(n)
import java.util.*;

class Solution1 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int maxlen = 1;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }
}

// Time Complexity: O(nlogn), Space Complexity: O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int maxlen = 0;

        for (int i = 0; i < dp.length; i++) {
            int index = binarySerach(dp, 0, maxlen, envelopes[i][1]);
            dp[index] = envelopes[i][1];
            if (index == maxlen) {
                maxlen++;
            }
        }
        return maxlen;
    }

    int binarySerach(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
