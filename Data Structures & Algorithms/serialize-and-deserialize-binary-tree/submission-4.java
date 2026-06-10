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

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] index = {0}; 
        return deserializeHelper(arr, index);
    }

    private TreeNode deserializeHelper(String[] arr, int[] index) {
        if (arr[index[0]].equals("#")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[index[0]++]));
        node.left  = deserializeHelper(arr, index);
        node.right = deserializeHelper(arr, index);
        return node;
    }
}