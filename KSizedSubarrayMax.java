
//Time Complexity: O(n*k)
import java.util.*;

class Solution {
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            output.add(max);
        }
        return output;
    }
}
