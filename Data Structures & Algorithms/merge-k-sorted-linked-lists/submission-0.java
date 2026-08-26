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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        var list = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            list = mergeTwoLists(list, lists[i]);
        }

        return list;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode();
        var current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 == null) {
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }

        return dummy.next;
    }
}
