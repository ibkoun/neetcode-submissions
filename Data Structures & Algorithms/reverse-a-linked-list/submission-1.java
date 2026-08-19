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
    /*
        ListNode = 0-1-2-3
        
        Start:
            current = 1-2-3
            head = 0

        First iteration:
            1. next = 2-3
            2. current = 1-0
            3. head = 1-0
            4. current = 2-3

        Second iteration:
            1. next = 3
            2. current = 2-1-0
            3. head = 2-1-0
            4. current = 3
        
        Last iteration:
            1. next = null
            2. current = 3-2-1-0
            3. head = 3-2-1-0
            4. current = null
    */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head.next;
        head.next = null;
        while (current != null) {
            ListNode next = current.next; // 1. Save the next node pointed by the current node
            current.next = head; // 2. Current node now points to the previous node
            head = current; // 3. Current node now becomes the head
            current = next; // 4. Move to the next node that was saved
        }

        return head;
    }
}
