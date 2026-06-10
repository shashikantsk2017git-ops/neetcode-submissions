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
        ind = 0;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return consTree(0, preorder.length-1, preorder);      
    }

    public TreeNode consTree(int left, int right, int[] preorder) {
        if(left > right) return null;

        int rootVal = preorder[ind];
        TreeNode root = new TreeNode(preorder[ind++]);
        root.left = consTree(left, map.get(rootVal)-1, preorder);
        root.right = consTree(map.get(rootVal)+1, right, preorder);
        return root;
    }
}
