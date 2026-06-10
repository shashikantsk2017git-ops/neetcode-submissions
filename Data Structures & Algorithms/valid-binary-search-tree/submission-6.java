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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean checkBST(TreeNode node, int max, int min) {
        
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return checkBST(node.left, node.val, min) && checkBST(node.right, max, node.val);
    }
}
   


