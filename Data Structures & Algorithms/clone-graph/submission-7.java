/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Node[] vis = new Node[101];
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(vis[node.val] != null) return vis[node.val];

        Node newNode = new Node(node.val);
        vis[node.val] = newNode;

        for(Node child: node.neighbors) {
            newNode.neighbors.add(cloneGraph(child));
        }

        return newNode;
    }


    public Node cloneGraph0(Node node) {
        if(node ==  null) return null;
        Node[] vis = new Node[101];
        Queue<Node> queue = new LinkedList<>();
        Node par = new Node(node.val);
        queue.add(node);
        vis[node.val] = par;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            for(Node child: temp.neighbors) {
                if(vis[child.val] == null) {
                    Node newChild = new Node(child.val);
                    vis[child.val] = newChild;

                    queue.add(child);
                }
                vis[temp.val].neighbors.add(vis[child.val]);
            }
        }
        return par;
    }
}