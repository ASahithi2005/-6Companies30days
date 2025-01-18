
//Time Complexity: O(nlogn), space complexity: O(n)
import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> num = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (Arrays.binarySearch(nums, i + 1, n, nums[i] + k) > 0) {
                num.add(Math.min(nums[i], nums[i] + k));
            }
        }
        return num.size();
    }
}

// Time Complexity: O(n), space complexity: O(n)
class Solution1 {
    public int findPairs1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int x : map.keySet()) {
            if (k > 0 && map.containsKey(x + k) || k == 0 && map.get(x) > 1)
                result++;
        }
        return result;
    }
}