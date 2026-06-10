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
        while(n-1 > 0 && first != null) {
            first = first.next;
            n--;
        }
        ListNode prev = null;
        while(first.next != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }
        if(prev == null) return head.next;
        prev.next = second.next;
        return head;
    }
}