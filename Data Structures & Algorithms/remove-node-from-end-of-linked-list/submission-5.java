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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /* 
            Let N be the size of the linked list.
            Let the following indices be start = N - n and end = N. Thus we have end - start = n.
            Though we want start to be the node before the one we need to remove, so we'll have start = N - n - 1 and end - start = n + 1.
        */

        if ((head == null || head.next == null) && n == 1) {
            return null;
        }

        // Move end n + 1 steps from the head
        ListNode dummy = new ListNode();
        ListNode start = dummy;
        start.next = head;
        ListNode end = dummy;
        int i = 0;
        while (end != null && i <= n) {
            end = end.next;
            i++;
        }
        
        // Traverse the linked list until end = null
        while (end != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next; // Remove the nth node
        
        return dummy.next;
    }
}
