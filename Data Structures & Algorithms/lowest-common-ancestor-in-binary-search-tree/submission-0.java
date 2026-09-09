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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);

        // Check if the current node is p or q, or if the current node has both p and q as children
        if (Objects.equals(root, p) || Objects.equals(root, q)
            || (Objects.equals(left, p) && Objects.equals(right, q))
            || (Objects.equals(left, q) && Objects.equals(right, p))) {
            return root;
        }

        // Check if the left child is p or q, or a node that contains both as children
        if (left != null) {
            return left;
        }

        // Check if the right child is p or q, or a node that contains both as children
        if (right != null) {
            return right;
        }

        return null; // The current node is neither p nor q, and does not contain both as children
    }
}
