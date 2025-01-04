//brute force solution
//Time Complexity: O(n^3) , space complexity: O(1)
class Solution1 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isNiceSubarray(nums, i, j, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isNiceSubarray(int[] arr, int start, int end, int k) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] % 2 != 0)
                count++;
        }
        if (count == k)
            return true;

        return false;
    }
}

// optimal solution - sliding window two pointer approach
// Time Complexity: O(n) , space complexity: O(1)
class Solution2 {
    public int nos(int[] nums, int k) {
        int n = nums.length;
        if (k < 0)
            return 0;
        int l = 0, r = 0, count = 0, sum = 0;
        while (r < n) {
            sum += (nums[r] % 2);
            while (sum > k) {
                sum = sum - (nums[l] % 2);
                l++;
            }
            count = count + (r - l + 1);
            r++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int count = nos(nums, k) - nos(nums, k - 1);
        return count;
    }
}
