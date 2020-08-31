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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // HANDLING CORNER CASES
        if(head == null || m == n)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, ptr = head, c1 = null, c2 = null;
        ListNode rev = new ListNode(-1);
        int idx = 1;
        
        // MOVING FORWARD TO MAKE PTR STAND ON M
        while(idx++ < m) {
            prev = ptr;
            ptr = ptr.next;
        }
        // NOW PTR IS STANDING ON M
        c1 = prev;
        // NOW REVERSING THE LIST USING ADD-FIRST NODE APPROACH
        while(idx++ <= n+1) {
            prev = ptr;
            ptr = ptr.next;
            prev.next = rev.next;
            rev.next = prev;
        }
        // NOW PREV IS STANDING ON N
        c2 = ptr;
        c1.next.next = c2;
        c1.next = rev.next;
        
        return dummy.next;
    }
}