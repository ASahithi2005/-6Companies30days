// delete n nodes after m nodes
// The input list will have at least one element
// Node is defined as
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node curr = head;
        int count;
        while (curr != null) {
            for (count = 1; count < m && curr != null; count++)
                curr = curr.next;
            if (curr == null)
                return;
            Node t = curr.next;
            for (count = 1; count <= n && t != null; count++) {
                Node temp = t;
                t = t.next;
                temp = null;

            }
            curr.next = t;

            curr = t;
        }
    }
}
