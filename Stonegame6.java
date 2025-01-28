
// Time Complexity: O(nlogn) where n is the length of the aliceValues array
import java.util.*;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        List<int[]> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(new int[] { -(aliceValues[i] + bobValues[i]), i });
        }
        Collections.sort(v, (a, b) -> Integer.compare(a[0], b[0]));

        int f = 1, a = 0, b = 0;
        for (int[] x : v) {
            if (f == 1) {
                a += aliceValues[x[1]];
            } else {
                b += bobValues[x[1]];
            }
            f = -f;
        }
        if (a > b)
            return 1;
        if (a == b)
            return 0;
        return -1;
    }
}
