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
    Map<Integer, Integer> map;
    int rootInd;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        rootInd = 0;
        for(int i = 0; i<inorder.length; i++)  map.put(inorder[i], i);
        return buildTheTree(preorder, 0, preorder.length-1);
    }

    public TreeNode buildTheTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        int rootValue = preorder[rootInd++];
        TreeNode root = new TreeNode(rootValue);
        int ind = map.get(rootValue);
        root.left = buildTheTree(preorder, left, ind - 1);
        root.right = buildTheTree(preorder, ind + 1, right);
        return root;
    }
}
