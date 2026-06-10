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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        calSum(root);
        return max;          // ✅ return max, not calSum(root)
    }

    public int calSum(TreeNode temp) {
        if (temp == null) return 0;

        int left  = Math.max(0, calSum(temp.left));
        int right = Math.max(0, calSum(temp.right));

        max = Math.max(max, temp.val + left + right);  // ✅ max not maxSum

        return temp.val + Math.max(left, right);
    }
}
