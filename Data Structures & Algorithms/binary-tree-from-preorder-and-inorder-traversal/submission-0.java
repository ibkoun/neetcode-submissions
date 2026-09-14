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
    private int preorderIdx = 0;
    private Map<Integer, Integer> inorderIndices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (var i = 0; i < inorder.length; i++) {
            inorderIndices.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        var root = new TreeNode(preorder[preorderIdx++]);
        var mid = inorderIndices.get(root.val);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);
        return root;
    }
}
