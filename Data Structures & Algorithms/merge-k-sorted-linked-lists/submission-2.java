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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>((a , b) -> a.val - b.val);

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        for(ListNode list: lists) que.add(list);

        while(!que.isEmpty()) {
            prev.next = que.poll();

            if(prev.next.next != null) {
                que.offer(prev.next.next);
            }
            prev = prev.next;
        }
        return prehead.next;
    }


    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode prev = null;

        if(lists.length < 1) return prev;
        if(lists.length == 1) return lists[0];

        prev = lists[0];
        for(int i = 1; i < lists.length; i++) {
            prev = mergeTwoLists(prev, lists[i]);
        }
        return prev;
    }

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
}
