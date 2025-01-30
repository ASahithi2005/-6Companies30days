//Time Complexity : O(1)
class Solution {
    public int longestString(int x, int y, int z) {
        int minXY = Math.min(x, y);
        int maxLength = (minXY * 4) + (z * 2);

        if (x != y) {
            maxLength += 2;
        }
        return maxLength;
    }
}
