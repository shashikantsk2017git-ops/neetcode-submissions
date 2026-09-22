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
        // PriorityQueue<ListNode> queue = new PriorityQueue<>((a , b) -> a.val - b.val);
        PriorityQueue<ListNode> queue = new PriorityQueue(
            Comparator.<ListNode>comparingInt(obj -> obj.val));
        for(ListNode list: lists) if(list != null) queue.add(list);
        
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            prev.next = node;
            if(node.next != null) queue.offer(node.next);
            prev = node;
        }
        return prehead.next;
        
    }


    public ListNode mergeKLists0(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode list1 = lists[0];
        for(int i = 1; i < lists.length; i++) {
            list1 = mergeTwoLists(list1, lists[i]);
        }
        return list1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if (list1 == null)
            prev.next = list2;
        if (list2 == null)
            prev.next = list1;
        return dummy.next;
    }
}
