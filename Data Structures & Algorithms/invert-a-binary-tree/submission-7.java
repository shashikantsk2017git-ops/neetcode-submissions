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
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    //Using BFS non recursively
    public TreeNode invertTree0(TreeNode root) {
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

    public TreeNode invertTreeNonRecursivly(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                return node;
            }
            if(curr.left != null && curr.right != null) {
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                queue.add(curr.left);
                queue.add(curr.right);
            } else if(curr.left == null && curr.right != null) {
                curr.left = curr.right;
                curr.right = null;
                queue.add(curr.left);
            } else if(curr.right == null && curr.left != null) {
                curr.right = curr.left;
                curr.left = null;
                queue.add(curr.right);
            } else {
                continue;
            }
        }
        return node;
    }
}
