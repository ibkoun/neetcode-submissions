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
    public int diameterOfBinaryTree(TreeNode root) {
        return DFS(0, root);
    }

    private int DFS(int diameter, TreeNode node) {
        if (node.left != null && node.right != null) {
            // If the current node has two children, we start the measurement of the diameter from here and compare it to the current measure
            var left = DFS(1, node.left);
            var right = DFS(1, node.right);
            return Math.max(diameter, left + right); // Number of edges between a parent and the deepest leaves from both side
        } else if (node.left != null) {
            var left = DFS(diameter + 1, node.left);
            return Math.max(diameter, left); // Number of edges between a parent and the deepest leaf from the left side
        } else if (node.right != null) {
            var right = DFS(diameter + 1, node.right);
            return Math.max(diameter, right); // Number of edges between a parent and the deepest leaf from the right side
        }
        return diameter;
    }
}
