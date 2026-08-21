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
        if (head == null) {
            return head;
        }

        // Map each node to its copy and build the new linked list without assigning the random pointers
        var map = new HashMap<Node, Node>();
        var current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Build the new linked list and assign the random pointers
        var headCopy = map.get(head);
        var currentCopy = headCopy;
        current = head;
        while (current != null && currentCopy != null) {
            currentCopy.next = map.getOrDefault(current.next, null);
            currentCopy.random = map.getOrDefault(current.random, null);
            currentCopy = currentCopy.next;
            current = current.next;
        }

        return headCopy;
    }
}
