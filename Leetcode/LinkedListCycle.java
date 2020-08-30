/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // SETTING SLOW & FAST POINTER ON HEAD
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            // MOVING SLOW POINTER WITH SPEED OF 1
            // && MOVING FAST POINTER WITH SPEED OF 2
            slow = slow.next;
            fast = fast.next.next;
            
            // IF THERE'S A CYCLE AFTER SOME TIME SLOW 
            // & FAST BOTH COINCIDE
            if( slow == fast) 
                return true;
        }
        return false;
    }
}       