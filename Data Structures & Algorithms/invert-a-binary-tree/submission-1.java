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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        var queue = new ArrayDeque<TreeNode>(); // FIFO queue
        queue.add(root);

        // Iterative BFS
        while (!queue.isEmpty()) {
            var node = queue.removeFirst();
            if (node == null) {
                continue;
            }

            // Swap left child with right child
            var left = node.left;
            var right = node.right;
            node.left = right;
            node.right = left;

            // Add the left child to the queue
            if (node.left != null) {
                queue.addLast(node.left);
            }
            
            // Add the right child to the queue
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return root;
    }
}
