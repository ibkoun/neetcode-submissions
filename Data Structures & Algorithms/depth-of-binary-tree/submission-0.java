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
    public int maxDepth(TreeNode root) {
        return DFS(0, root);
    }

    // Recursive DFS
    private int DFS(int depth, TreeNode node) {
        if (node == null) {
            return depth;
        }

        depth++;
        var left = DFS(depth, node.left);
        var right = DFS(depth, node.right);

        return Math.max(Math.max(depth, left), right);
    }
}
