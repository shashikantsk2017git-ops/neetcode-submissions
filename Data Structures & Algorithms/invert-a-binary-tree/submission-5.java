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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
           TreeNode node = queue.poll();
           TreeNode temp = null;
           if(node != null) {
                temp = node.left;
                node.left = node.right;
                node.right = temp;
                queue.add(node.left);
                queue.add(node.right);
           }
        }
        return root;
    }
}
