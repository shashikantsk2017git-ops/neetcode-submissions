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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second half
        ListNode prev = null;
        while(slow != null) {
            ListNode temp = slow.next;

            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode head2 = prev;
        ListNode head1 = head;
        while(head2.next != null) {
            ListNode temp1 = head1.next;
            head1.next = head2;
            
            ListNode temp2 = head2.next;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }

}
