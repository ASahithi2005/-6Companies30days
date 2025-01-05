import java.util.*;

class Solution {
    int[][] rects;
    Random randoms;
    TreeMap<Integer, Integer> map;
    int sum;

    public Solution(int[][] rects) {
        this.rects = rects;
        randoms = new Random();
        map = new TreeMap<>();
        sum = 0;

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }

    }

    public int[] pick() {
        int num = map.ceilingKey(randoms.nextInt(sum) + 1);
        int[] xy = rects[map.get(num)];
        return new int[] { xy[0] + randoms.nextInt(xy[2] - xy[0] + 1), xy[1] + randoms.nextInt(xy[3] - xy[1] + 1) };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
