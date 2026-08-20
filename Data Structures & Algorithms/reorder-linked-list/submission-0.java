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
        ListNode fast = head; // Fast pointer
        ListNode left = head; // Node before the midpoint
        while (fast != null && fast.next != null) {
            left = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the right half
        ListNode right = null; // Start of the right half
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = right;
            right = slow;
            slow = next;
        }
        left.next = null; // Separate the left half from the right half
        left = head; // Start of the left half

        // Reorder
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode nextLeft = left;
        ListNode nextRight = right;
        while (left != null && right != null) {
            current.next = nextLeft;
            nextLeft = left.next;
            left = nextLeft;
            current = current.next;
            
            current.next = nextRight;
            nextRight = right.next;
            right = nextRight;
            current = current.next;
        }

        // If the length of the linked list is odd, we need to attach the last node from the right half
        if (right != null) {
            current.next = right;
        }

        head = dummy.next;
    }
}
