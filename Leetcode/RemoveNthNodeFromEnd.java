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
        ListNode c1 = head;
        ListNode c2 = head;
        
        // CREATING A GAP OF N-NODES IN 
        // BETWEEN C1 & C2 POINTERS
        while(n-- > 0)
            c2 = c2.next;
        
        // EXECUTES WHEN WE HAVE TO REMOVE THE VERY FIRST
        // NODE OF LINKED LIST
        if(c2 == null) 
            return head.next;
        
        // MAKING C1 TO MOVE FORWARD TILL WE REACH
        // N + 1 NODE FROM END
        while(c2.next != null) {
            c1 = c1.next;
            c2 = c2.next;
        }
        
        // REMOVING THE NTH NODE
        c1.next = c1.next.next;
        return head;
    }
}