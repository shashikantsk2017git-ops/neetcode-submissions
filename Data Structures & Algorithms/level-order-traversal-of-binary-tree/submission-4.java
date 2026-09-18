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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        if(root == null) return out;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int n = queue.size();
            for(int i = 1; i <= n; i++) {
                TreeNode node = queue.poll();
                if(node != null)
                    list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)    
                    queue.add(node.right);
            }
            out.add(list);
        }
        return out;
    }
}
