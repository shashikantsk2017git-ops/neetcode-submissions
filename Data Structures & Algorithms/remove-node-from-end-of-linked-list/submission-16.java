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
        ListNode left = head;
        ListNode right = head;

        while(n > 0 && right != null) {
            n--;
            right = right.next;
        }

        if(right == null) return head.next;
        ListNode prev = null;
        while(right != null) {
            prev = left;
            left = left.next;
            right = right.next;
        }
        prev.next = left.next;
        return head;
    }
}