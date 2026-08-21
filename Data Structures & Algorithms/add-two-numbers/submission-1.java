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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        ListNode node1 = l1;
        ListNode node2 = l2;

        // Traverse both l1 and l2
        int carry = compute(node1.val + node2.val, current);
        node1 = node1.next;
        node2 = node2.next;
        while (node1 != null && node2 != null) {
            current.next = new ListNode();
            current = current.next;
            carry = compute(node1.val + node2.val + carry, current);
            node1 = node1.next;
            node2 = node2.next;
        }

        // Traverse the remaining nodes of l1 or l2
        while (node1 != null) {
            current.next = new ListNode();
            current = current.next;
            carry = compute(node1.val + carry, current);
            node1 = node1.next;
        }
        while (node2 != null) {
            current.next = new ListNode();
            current = current.next;
            carry = compute(node2.val + carry, current);
            node2 = node2.next;
        }

        // Add an extra node for the carry if applicable
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return head;
    }

    private int compute(int input, ListNode result) {
        result.val = input % 10; // It is assumed that each node contain a single digit
        return input / 10;
    }
}
