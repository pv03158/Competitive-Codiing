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
        // MANAGING CORNER CASES
        if(lists.length == 0)
            return null;
        
        // TAKING ONE OF THE LINKED LIST FROM ARRAY
        // AND STORING THATT INTO HEAD POINTER
        int size = lists.length - 1;
        ListNode head = lists[size--];
        
        while(size >= 0)
            head = merge(head, lists[size--]);
        
        return head;
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        
        ListNode ptr = dummy;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                ptr.next = h1;
                h1 = h1.next;
            }
            else {
                ptr.next = h2;
                h2 = h2.next;
            }
            ptr = ptr.next;
        }
        
        if(h1 == null) ptr.next = h2;
        else ptr.next = h1;
        
        return dummy.next;
    }
}