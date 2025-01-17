//Time Complexity: O(n) , space complexity: O(1)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(), i = 0, j = 0, ans = 0, currcost = 0;
        while (j < n) {
            currcost += Math.abs(t.charAt(j) - s.charAt(j));
            while (i < n && currcost > maxCost) {
                currcost -= Math.abs(t.charAt(i) - s.charAt(i));
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}