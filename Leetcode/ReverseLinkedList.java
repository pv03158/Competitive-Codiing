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
    public ListNode reverseList(ListNode head) {
        // MANAGING CORNER CASES
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode ptr = head;
            head = head.next;
            ptr.next = dummy.next;
            dummy.next = ptr;
        }
        
        return dummy.next;
    }
}