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
    public ListNode swapPairs(ListNode head) {
        // TAKING CARE OF CORNER CASES
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode c1 = dummy;
        ListNode c2 = head;
        ListNode c3 = head.next;
        
        while(true) {
            c1.next = c3;
            c2.next = c3.next;
            c3.next = c2;
            
            // CHECKING FOR NULL BEFORE MOVING
            // POINTERS FORWARD
             if(c3.next.next == null || c3.next.next.next == null)
                 return dummy.next;
            c1 = c1.next.next;
            c2 = c2.next;
            c3 = c3.next.next.next;
        }
    }
}