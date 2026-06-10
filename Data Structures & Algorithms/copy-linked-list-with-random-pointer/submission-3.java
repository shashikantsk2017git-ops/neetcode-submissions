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
        if(head == null) return null;
        Node temp = head;

        while(temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;

            temp = temp.next.next;
        }
        temp = head;

        while(temp != null) {
            if(temp.random == null)
                temp.next.random = null;
            else
                temp.next.random = temp.random.next;
            temp = temp.next.next;    
        }

        Node head2 = head.next;
        Node temp1 = head;
        Node temp2 = head2;

        while(temp1.next != null && temp2.next != null) {
            temp1.next = temp1.next.next;
            temp2.next = temp2.next.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = null;
        temp2.next = null;

        return head2;
    }

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node temp = head;

        while(temp != null) {
            Node node = new Node(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            Node node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}

