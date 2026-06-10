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

    // Encodes a tree to a single string using preorder traversal
    // Format: "val,val,#,#,val,#,#" where '#' = null node
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        
        String left = serialize(root.left);
        String right = serialize(root.right);
        
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);   // left subtree consumed first
        node.right = deserializeHelper(queue);  // right subtree consumed next

        return node;
    }
}