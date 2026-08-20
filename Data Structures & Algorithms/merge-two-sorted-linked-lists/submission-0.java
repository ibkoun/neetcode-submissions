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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(); // Dummy node
        ListNode current = head;
        while (list1 != null && list2 != null) {
            // Attach to the current node the smallest value between list1 and list2
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes
        if (list1 == null) {
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }

        return head.next;
    }
}