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
    //check everysteps if subRoot is subtree of tree if yes go more deep if you found no it is not
    //then check is same tree or not if same tree then return true;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == subRoot;
        return isSubtree(root.left, subRoot) 
        || isSubtree(root.right, subRoot) 
        || isSameTree(root, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) return root == subRoot;
        return root.val == subRoot.val 
            && isSameTree(root.left, subRoot.left)
            && isSameTree(root.right, subRoot.right);
    }
}
