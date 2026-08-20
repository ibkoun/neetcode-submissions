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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find the midpoint
        ListNode slow = head; // Slow pointer
        ListNode fast = head.next; // Fast pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null; // Separate the left half from the right half
        slow = temp;

        // Reverse the right half
        ListNode right = null; // Start of the right half
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = right;
            right = slow;
            slow = next;
        }

        // Reorder
        ListNode left = head; // Start of the left half
        while (left != null && right != null) {
            ListNode nextLeft = left.next;
            ListNode nextRight = right.next;
            left.next = right;
            right.next = nextLeft;
            left = nextLeft;
            right = nextRight;
        }
    }
}
