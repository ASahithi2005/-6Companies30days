
//Time Complexity: O(n) , Space Complexity: O(n)
import java.util.*;

class Solution1 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ls = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        if (s.length() <= 10) {
            return ls;
        }
        for (int i = 0; i <= (s.length() - 10); i++) {
            String h = s.substring(i, i + 10);
            hm.put(h, hm.getOrDefault(h, 0) + 1);

        }
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > 1) {
                ls.add(entry.getKey());
            }
        }
        return ls;

    }
}
