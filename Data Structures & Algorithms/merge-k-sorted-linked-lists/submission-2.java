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

        // Each list is already sorted. Therefore at the start of the iteration, the head of the
        // priority queue will always point to the head of the list with the smallest value.
        var priorityQueue = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        for (var list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        var dummy = new ListNode();
        var current = dummy;
        while (!priorityQueue.isEmpty()) {
            // The head of the priority queue will always contain the node with the smallest value
            var node = priorityQueue.remove();
            current.next = node;
            current = current.next;

            // Adding the next node into the queue will update the priority queue. This allows us to
            // iterate through each list while keeping track of the smallest values.
            node = node.next;
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        return dummy.next;
    }
}
