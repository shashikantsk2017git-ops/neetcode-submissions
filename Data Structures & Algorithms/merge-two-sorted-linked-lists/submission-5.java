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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode prehead = prev;

        while(list1!=null && list2!=null) {
            if(list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        if(list1!=null) {
            prev.next =list1;
        } else {
            prev.next = list2;
        }
        return prehead.next;
    }
    
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode prehead = prev;

        while(list1 != null && list2 != null) {
            ListNode temp = null;
            if(list1.val < list2.val) {
                prev.next = list1;
                temp = list1.next;
                list1.next = list2;
                list1 = temp;
            } else {
                prev.next = list2;
                temp = list2.next;
                list2.next = list1;
                list2 = temp;
            }
            prev = prev.next;
        }
        if(list1 == null) prev.next = list2;
        else prev.next = list1;
        
        return prehead.next;
    }
}