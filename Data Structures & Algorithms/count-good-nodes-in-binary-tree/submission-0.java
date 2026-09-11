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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var left = DFS(root.left, root.val);
        var right = DFS(root.right, root.val);
        return left + right + 1; // The root is always good, hence the +1
    }

    private int DFS(TreeNode node, int previous) {
        var good = 0; // 1 if good or else 0

        if (node == null) {
            return good;
        }

        if (node.val >= previous) {
            previous = node.val;
            good = 1;
        }

        var left = DFS(node.left, previous);
        var right = DFS(node.right, previous);

        return left + right + good;
    }
}
