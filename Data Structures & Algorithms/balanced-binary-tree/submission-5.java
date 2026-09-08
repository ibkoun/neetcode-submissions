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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBalanced(root.left)) {
            return false;
        }

        if (!isBalanced(root.right)) {
            return false;
        }

        var left = DFS(root.left);
        var right = DFS(root.right);

        return Math.abs(left - right) <= 1;
    }

    private int DFS(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var left = DFS(node.left);
        var right = DFS(node.right);

        return Math.max(left, right) + 1;
    }
}
