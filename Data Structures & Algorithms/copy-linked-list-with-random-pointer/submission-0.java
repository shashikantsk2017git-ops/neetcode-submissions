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
        if(head == null) return head;
        Node curr = head;

        while(curr != null) {
            Node newNode = new Node(curr.val);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = curr.next.next;
        }

        curr = head;
        while(curr != null) {
            if(curr.random != null)
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

       curr = head;
        Node copyHead = new Node(-1);
        Node temp = copyHead;          

        while (curr != null) {
            temp.next = curr.next;    
            temp = temp.next;          

            curr.next = curr.next.next; 
            curr = curr.next;          
        }

        return copyHead.next;
    }
}
