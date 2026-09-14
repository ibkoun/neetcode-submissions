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
    private int inorderIdx = 0;
    private int preorderIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int limit) {
        if (preorderIdx >= preorder.length) {
            return null;
        }
        if (inorder[inorderIdx] == limit) {
            inorderIdx++;
            return null;
        }
        var root = new TreeNode(preorder[preorderIdx++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, limit);
        return root;
    }
}
