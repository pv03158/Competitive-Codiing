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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // CREATING DUMMY NODE IN ORDER TO 
        // SAVE THE EXTRA CHECK FOR BOTH NULL CONDITION
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ptr = dummy;
        
        while(c1 != null && c2 != null) {
            // MOVING PTR FORWARD TO THE SHORTEST NODE
            if(c1.val <= c2.val) {
                ptr.next = c1;
                c1 = c1.next;
            } else {
                ptr.next = c2;
                c2 = c2.next;
            }
            
            ptr = ptr.next;
        }
        
        // IF C1 IS SHORTER THAN C2 ADDS
        // THE EXTRA ELEMENT OF C2 AND VICE-VERSA
        if(c1 == null) ptr.next = c2;
        else ptr.next = c1;
        
        return dummy.next;
    }
}