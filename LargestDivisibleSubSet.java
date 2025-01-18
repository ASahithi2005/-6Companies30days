
//Time Complexity: O(n^2)
import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> nums1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums1.add(nums[i]);
        }
        Collections.sort(nums1);
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            hash.set(i, i);
            for (int j = 0; j <= i - 1; j++) {
                if (nums1.get(i) % nums1.get(j) == 0 && 1 + dp.get(j) > dp.get(i)) {
                    dp.set(i, 1 + dp.get(j));
                    hash.set(i, j);
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp.get(i) > ans) {
                ans = dp.get(i);
                lastIndex = i;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums1.get(lastIndex));

        while (hash.get(lastIndex) != lastIndex) {
            lastIndex = hash.get(lastIndex);
            temp.add(nums1.get(lastIndex));
        }

        // Reverse the array
        Collections.reverse(temp);

        return temp;
    }
}