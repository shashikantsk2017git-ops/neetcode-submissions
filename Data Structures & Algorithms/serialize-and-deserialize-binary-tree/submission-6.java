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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + ","+ serialize(root.left) + "," +  serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        //taking index because at # case while returning null we won't be able to increase count
        //but in array it is possible
        int[] index = {0};
        return deserializeHelper(nodes, index);
    }

    private TreeNode deserializeHelper(String[] nodes, int[] ind) {
        if(nodes[ind[0]].equals("#")) {
            ind[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[ind[0]++]));

        node.left = deserializeHelper(nodes, ind);
        node.right = deserializeHelper(nodes, ind);

        return node;
    }
}
