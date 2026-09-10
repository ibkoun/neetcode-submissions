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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        var result = new ArrayList<Integer>();
        var queue = new ArrayDeque<TreeNode>();
        var next = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.removeFirst();
            if (node.left != null) {
                next.addLast(node.left);
            }
            if (node.right != null) {
                next.addLast(node.right);
            }
            if (queue.isEmpty()) { // Last node of each level is the visible node from the right side of the tree
                result.add(node.val);
                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }
}
