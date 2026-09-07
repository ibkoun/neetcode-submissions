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
        return DFS(root) >= 0;
    }

    private int DFS(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var left = DFS(node.left);
        var right = DFS(node.right);

        return left >= 0 && right >= 0 && Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : Integer.MIN_VALUE;
    }
}
