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
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        // flag = true;
        // checkB(root);
        // return flag;
        return checkB(root) != -1;
    }

    private int checkB0(TreeNode node) {
        if(node == null) return 0;

        int left = checkB(node.left);
        int right = checkB(node.right);

        if(Math.abs(left - right) > 1) flag = false; 

        return 1 + Math.max(left, right);
    }

    private int checkB(TreeNode node) {
        if(node == null) return 0;

        int left = checkB(node.left);
        if(left == -1) return left;
        int right = checkB(node.right);
        if(right == -1) return right;

        if(Math.abs(left - right) > 1) return -1; 

        return 1 + Math.max(left, right);
    }
}
