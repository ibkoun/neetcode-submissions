/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Retrieve the size of the linked list
        int remaining = 0;
        var current = head;
        while (current != null) {
            current = current.next;
            remaining++;
        }

        if (remaining < k) {
             return head;   
        }

        var size = 0; // Current size of the group being processed
        var dummy = new ListNode(); // Holds the head of the new linked list
        ListNode tail = null; // Tail of each group of k nodes
        ListNode previous = null;
        current = head;

        // Reverse each group
        while (current != null && remaining >= k) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            size++;
            if (size == k) {
                if (dummy.next == null) {
                    dummy.next = previous;
                } else {
                    tail.next = previous; // Connect the tail of the previous group to the next group
                }
                remaining -= k;
                size = 0;
                tail = head;
                head = current;
                previous = null;
            }
        }

        // Attach the remaining nodes
        if (current != null) {
            tail.next = current;
        }

        return dummy.next;
    }
}
