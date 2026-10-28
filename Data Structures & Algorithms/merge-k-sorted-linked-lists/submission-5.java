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

        var pq = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        for (var l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }
        
        var head = new ListNode();
        var current = head;
        while (!pq.isEmpty()) {
            var node = pq.poll();
            current.next = node;
            current = current.next;

            node = node.next;
            if (node != null) {
                pq.add(node);
            }
        }

        return head.next;
    }
}
