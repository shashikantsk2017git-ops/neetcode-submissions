/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;

        while(curr != null) {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;

            curr = node.next;
        }

        curr = head;

        while(curr != null && curr.next != null) {
            if(curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = null;
        if(curr != null)
            newHead = curr.next;
        while(curr != null && curr.next != null) {
            Node temp = curr.next;
            curr.next = curr.next.next;

            curr = temp;
        }
        return newHead;
    }

    public Node copyRandomList0(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        } 

        curr = head;
        while(curr != null) {
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);

            curr = curr.next;
        }
        return map.get(head);
    }
}
