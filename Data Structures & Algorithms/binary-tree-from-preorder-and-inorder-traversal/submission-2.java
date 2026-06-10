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
    int rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTheTree(preorder, 0, inorder.length-1, map);
    }

    public TreeNode buildTheTree(int[] pre, int left, int right, Map<Integer, Integer> map) {
        if(left > right) return null;
        int rootVal = pre[rootIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTheTree(pre, left, map.get(rootVal)-1, map);
        root.right = buildTheTree(pre, map.get(rootVal)+1, right, map);
        return root;  
    }
}
