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
            current = 0-1-2-3
            previous = null

        First iteration:
            1. next = 1-2-3
            2. current = 0
            3. previous = 0
            4. current = 1-2-3

        Second iteration:
            1. next = 2-3
            2. current = 1-0
            3. previous = 1-0
            4. current = 2-3
        
        Third iteration:
            1. next = 3
            2. current = 2-1-0
            3. previous = 2-1-0
            4. current = 3
        
        Last iteration:
            1. next = null
            2. current = 3-2-1-0
            3. previous = 3-2-1-0
            4. current = null
    */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next; // 1. Save the next node pointed by the current node
            current.next = previous; // 2. Current node now points to the previous node
            previous = current; // 3. Current node now becomes the previous node
            current = next; // 4. Move to the next node that was saved
        }

        return previous;
    }
}
