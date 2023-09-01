/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        for (Node current = head; current != null; current = current.next) {
            map.put(current, new Node(current.val));
        }

        for (Node current = head; current != null; current = current.next) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
        }
        return map.get(head);
    }
}