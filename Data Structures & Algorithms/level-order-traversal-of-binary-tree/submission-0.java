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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        var result = new ArrayList<List<Integer>>();
        var queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            var current = new ArrayList<Integer>();
            var next = new ArrayDeque<TreeNode>();
            while (!queue.isEmpty()) {
                var node = queue.removeFirst();
                current.add(node.val);
                if (node.left != null) {
                    next.addLast(node.left);
                }
                if (node.right != null) {
                    next.addLast(node.right);
                }
            }
            result.add(current);
            queue.addAll(next);
        }

        return result;
    }
}
