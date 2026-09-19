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
    int ind = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length-1, map);

    }

    private TreeNode construct(int[] preorder, int left, int right, Map<Integer, Integer> map) {
        if(left > right) return null;
        int value = preorder[ind++];
        TreeNode node = new TreeNode(value);
        node.left = construct(preorder, left, map.get(value)-1, map);
        node.right = construct(preorder, map.get(value)+1, right, map);

        return node;
    }
}
