
//Time Complexity: O(nlogk)
import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ls = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        Queue<String> que = new PriorityQueue<>(
                (w1, w2) -> hm.get(w1).equals(hm.get(w2)) ? w2.compareTo(w1) : hm.get(w1) - hm.get(w2));

        for (String word : hm.keySet()) {
            que.add(word);
            if (que.size() > k)
                que.poll();
        }
        while (!que.isEmpty()) {
            ls.add(que.poll());
        }
        Collections.reverse(ls);
        return ls;
    }
}
