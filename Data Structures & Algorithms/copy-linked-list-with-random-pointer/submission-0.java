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
        var headCopy = new Node(head.val);
        map.put(head, headCopy);
        var currentCopy = headCopy;
        var current = head.next;
        while (current != null) {
            currentCopy.next = new Node(current.val);
            currentCopy = currentCopy.next;
            map.put(current, currentCopy);
            current = current.next;
        }

        // Assign the random pointers
        currentCopy = headCopy;
        current = head;
        while (current != null && currentCopy != null) {
            currentCopy.random = map.getOrDefault(current.random, null);
            currentCopy = currentCopy.next;
            current = current.next;
        }

        return headCopy;
    }
}
