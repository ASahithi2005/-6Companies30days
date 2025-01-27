
//Time complexity: O(nlogn)
import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;

        for (int e : asteroids) {
            if (m - e < 0) {
                return false;
            }
            m += e;
        }
        return true;
    }
}
