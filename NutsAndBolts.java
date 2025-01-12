
//Time Complexity: O(n) 
import java.util.*;

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        char arr[] = { '!', '#', '$', '%', '&', '*', '?', '@', '^' };
        HashSet<Character> hs = new HashSet<>();
        for (char c : nuts) {
            hs.add(c);
        }
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i])) {
                nuts[k] = arr[i];
                bolts[k] = arr[i];
                k++;
            }
        }

    }
}
