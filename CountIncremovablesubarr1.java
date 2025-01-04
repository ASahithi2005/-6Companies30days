//Time Complexity: O(n^3) , space complexity: O(1)
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncreasingSubarray(nums, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isIncreasingSubarray(int[] arr, int start, int end) {
        int n = arr.length;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (i <= end && i >= start) {
                continue;
            }
            if (arr[i] <= prev) {
                return false;
            }
            prev = arr[i];

        }
        return true;
    }
}