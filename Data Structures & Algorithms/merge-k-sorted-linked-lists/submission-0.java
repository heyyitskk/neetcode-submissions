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
    private ListNode mergeKListsHelper(ListNode[] list, int start, int end){
        if(start == end){
            return list[start];
        }
        if(start + 1 == end){
            return merge2Lists(list[start], list[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(list, start, mid);
        ListNode right = mergeKListsHelper(list, mid + 1, end);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
}
