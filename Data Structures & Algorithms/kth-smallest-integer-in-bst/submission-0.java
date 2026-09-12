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
    public int kthSmallest(TreeNode root, int k) {
        var tree = new ArrayList<TreeNode>();
        DFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE, tree);
        return tree.get(k - 1).val;
    }

    // Inorder traversal
    private void DFS(TreeNode node, int min, int max, List<TreeNode> tree) {
        if (node == null) {
            return;
        }

        DFS(node.left, min, node.val, tree);
        tree.add(node);
        DFS(node.right, node.val, max, tree);
    }
}
