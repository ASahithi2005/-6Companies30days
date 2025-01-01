import java.util.*;

// Time Complexity : O(nlogn)
class Solution1 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, sum = 0;
        int mid = nums[(n / 2)];

        while (i < n) {
            sum += Math.abs(nums[i] - mid);
            i++;
        }
        return sum;
    }
}

// Time Complexity : O(nlogn)
class Solution2 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = n - 1, sum = 0;
        while (i < j) {
            sum = sum + Math.abs(nums[i] - nums[j]);
            i++;
            j--;
        }
        return sum;

    }
}