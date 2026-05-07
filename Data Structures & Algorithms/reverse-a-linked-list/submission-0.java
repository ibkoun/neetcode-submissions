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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head.next;
        head.next = null; // The head of the list becomes the tail
        while (current != null) {
            ListNode next = current.next;
            current.next = head; // The head becomes the child of the current node
            head = current; // The current node becomes the new head
            current = next; // Move to the next node
        }
        return head;
    }
}
