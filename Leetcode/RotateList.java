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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode c1 = head;
        ListNode c2 = head;
        
        // CALCULATING EFFECTIVE K
        int size = 0;
        for(ListNode ptr = head ; ptr != null ; ptr = ptr.next) 
            size += 1;
        // HANDLING CORNER CASES
        if(head == null || head.next == null || k == 0 || k%size == 0)
            return head;
        k = k % size ;
        
        // ADVANCING C2 POINTER BY K DISTANCE FROM C1
        for(int iter = 0; iter < k ; iter++)
            c2 = c2.next;
        
        while(c2.next != null) {
            c1 = c1.next;
            c2 = c2.next;
        }
        
        ListNode newHead = c1.next;
        c2.next = head;
        c1.next = null;
        return newHead;
    }
}