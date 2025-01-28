
//Time Complexity: O(nlogn) where n is the length of the nums array
import java.util.*;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1_000_000_007;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }
        while (k > 0) {
            int smallest = minHeap.poll();
            minHeap.add(smallest + 1);
            k--;
        }
        long prod = 1;
        while (!minHeap.isEmpty()) {
            prod = (prod * minHeap.poll()) % mod;
        }
        return (int) prod;
    }
}
