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

        // Move end n steps from the head
        ListNode end = head;
        int i = 0;
        while (end != null && i < n) {
            end = end.next;
            i++;
        }
        
        // Traverse the linked list until end = null
        ListNode start = new ListNode();
        start.next = head;
        while (end != null) {
            start = start.next;
            end = end.next;
        }

        // Remove the nth node
        ListNode target = start.next; // The nth node
        ListNode temp = target.next; // The (n + 1)th node
        start.next = temp;
        if (head == target) {
            head = start.next;
        }

        return head;
    }
}
