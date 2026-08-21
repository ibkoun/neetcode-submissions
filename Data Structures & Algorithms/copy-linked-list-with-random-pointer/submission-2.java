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

        // Insert a copy of the previous original node between the latter and the next
        var current = head;
        while (current != null) {
            var copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Since each original node points to a copy, it is guarantee that a random node points to a copy
        current = head;
        while (current != null && current.next != null) {
            if (current.random != null) {
                current.next.random = current.random.next; // Assign the random pointer for the copy of the current node
            }
            current = current.next.next; // Move to the next original node
        }

        // Restore the original list and extract the copied list
        var headCopy = head.next;
        current = head;
        while (current != null) {
            var copy = current.next;
            current.next = copy.next; // Attach the current original node the next original node
            if (copy.next != null) {
                copy.next = copy.next.next; // Attach the current node copy to the next node copy
            }
            current = current.next;
        }

        return headCopy;
    }
}
