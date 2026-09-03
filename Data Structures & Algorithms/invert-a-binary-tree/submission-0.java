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
        BFS(root);
        return root;
    }

    // Recursive BFS
    private void BFS(TreeNode node) {
        if (node == null) {
            return;
        }

        // Swap left child with right child
        var left = node.left;
        var right = node.right;
        node.left = right;
        node.right = left;

        BFS(node.left);
        BFS(node.right);
    }
}
