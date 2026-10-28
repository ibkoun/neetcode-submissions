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
        var dummy = new ListNode();
        var pointer = dummy;
        var start = head; // First node of a group
        var end = head; // Last node of a group
        while (end != null) {
            // Check if a group has at least k nodes
            for (var i = 0; i < k - 1; i++) {
                if (end == null) {
                    break;
                }
                end = end.next;
            }
            if (end != null) {
                var next = end.next; // Save the first node of the next group
                pointer.next = reverseKNodes(start, k); // Reverse the current group and connect its first node to the last node the previous group
                pointer = start; // Move the pointer to the end of the current group
                start = next; // Start with the first node of the next group
                end = start;
            } else {
                pointer.next = start;
            }
        }
        return dummy.next;
    }

    private ListNode reverseKNodes(ListNode head, int k) {
        ListNode previous = null;
        while (head != null && k-- > 0) {
            var next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}
