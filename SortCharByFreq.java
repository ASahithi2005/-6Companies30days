
//Time Complexity: O(nlogn) where n is the length of the string s
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        StringBuilder output = new StringBuilder();
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        List<Character> list = new ArrayList(hm.keySet());
        list.sort((ob1, ob2) -> hm.get(ob2) - hm.get(ob1));
        for (char ch : list) {
            for (int i = 0; i < hm.get(ch); i++) {
                output.append(ch);
            }
        }
        return output.toString();
    }
}
