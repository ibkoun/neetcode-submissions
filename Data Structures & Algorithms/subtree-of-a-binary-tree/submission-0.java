/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot == null) || (root != null && subRoot == null)) {
            return true;
        } else if (root == null) {
            return false;
        }

        var queue = new ArrayDeque<TreeNode>(); // FIFO queue for BFS
        queue.addLast(root);
        while (!queue.isEmpty()) {
            var node = queue.removeFirst();
            if (isSameTree(node, subRoot)) { // Verify if a subtree of root is the same as the subroot
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return false;
    }

    // BFS
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        var queue1 = new ArrayDeque<TreeNode>();
        var queue2 = new ArrayDeque<TreeNode>();
        queue1.add(p);
        queue2.add(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            var node1 = queue1.removeFirst();
            var node2 = queue2.removeFirst();
            if ((node1.val != node2.val) || (node1.left != null && node2.left == null)
                || (node1.left == null && node2.left != null)
                || (node1.right != null && node2.right == null)
                || (node1.right == null && node2.right != null)) {
                return false;
            }
            if (node1.left != null) {
                queue1.addLast(node1.left);
            }
            if (node1.right != null) {
                queue1.addLast(node1.right);
            }
            if (node2.left != null) {
                queue2.addLast(node2.left);
            }
            if (node2.right != null) {
                queue2.addLast(node2.right);
            }
        }

        return true;
    }
}
