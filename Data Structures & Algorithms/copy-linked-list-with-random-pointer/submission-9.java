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

        //Create New Nodes and point next to each node
        while (curr != null) {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;

            curr = node.next;
        }

        //Point random points of new node to the next of random pointer of existing List
        curr = head;
        while (curr != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Remove each pointer point from next (which was copy) to previous next means new copy elements next
        curr = head;
        Node newHead = null;
        if (curr != null)
            newHead = curr.next;

        while (curr != null && curr.next != null) {
            Node temp = curr.next;
            curr.next = curr.next.next;

            curr = temp;
        }
        return newHead;

        /* This approach also works for last step
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
        */
    }

    public Node copyRandomList0(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);

            curr = curr.next;
        }
        return map.get(head);
    }
}
