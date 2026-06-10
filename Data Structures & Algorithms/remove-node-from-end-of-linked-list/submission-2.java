/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for(int i = 1; i<=n ; i++) {
            second = second.next;
        }

        if(second == null) {
            if(first.next != null)
                head = head.next;
            else 
                head = null;    
            return head;
        }

        while(second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return head;
    }
}
