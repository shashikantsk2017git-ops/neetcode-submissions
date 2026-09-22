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
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        //To find kth - inorder give you kth

        inorder(root);
        return list.get(k-1);
    }

    private void inorder(TreeNode node) {
        if(node == null) return;
        //Left
        inorder(node.left);
        //add to list
        list.add(node.val);
        //right
        inorder(node.right);
    }
}
