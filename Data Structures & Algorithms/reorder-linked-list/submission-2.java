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
        //find mid
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

        //prev will be starting of reversed list
        ListNode node1 = head;
        ListNode node2 = prev;

        while(node2.next != null) {
            ListNode temp1 = node1.next;
            node1.next = node2;
            node1 = temp1;
            
            ListNode temp2 = node2.next;
            node2.next = temp1;
            node2 = temp2;
        }
    }
}
