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
    int ind;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return construct(0, preorder.length-1, preorder);
    }

    public TreeNode construct(int left, int right, int[] pre) {
        if(left > right) return null;
        int val = pre[ind];
        TreeNode node = new TreeNode(val);
        ind++;
        node.left = construct(left, map.get(val)-1, pre);
        node.right = construct(map.get(val)+1, right, pre);

        return node;
    }
}
