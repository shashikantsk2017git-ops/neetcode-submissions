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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateMaxSum(root);
        return maxSum;
    }

    private int calculateMaxSum(TreeNode node) {
        if(node == null) return 0;

        int val = node.val;
        int left = Math.max(calculateMaxSum(node.left), 0);
        int right = Math.max(calculateMaxSum(node.right), 0);

        maxSum = Math.max(maxSum, val + left + right);
        return val + Math.max(left, right);
    }
}
