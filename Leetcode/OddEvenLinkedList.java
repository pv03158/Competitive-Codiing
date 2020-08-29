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
    public ListNode oddEvenList(ListNode head) {
        // MANAGING CORNER CASE VALUES
        if(head == null || head.next == null)
            return head;
        ListNode eHead = head;
        ListNode oHead = head.next;
        ListNode oPtr = oHead;
        ListNode ePtr = eHead;
        
        while(ePtr.next != null && oPtr.next != null) {
            ePtr.next = oPtr.next;
            ePtr = ePtr.next;
            oPtr.next = ePtr.next;
            oPtr = oPtr.next;
        }
        
        // LINKING EVEN TAIL WITH THE ODD HEAD
        ePtr.next = oHead;
        return eHead;
    }
}