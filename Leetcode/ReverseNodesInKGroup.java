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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        int pos = 1;
        ListNode ptr = head;
        ListNode prev = dummy;
        while(ptr != null && ptr.next != null) {
            ptr = ptr.next;
            pos += 1;
            
            if(pos == k) {
                ListNode next = ptr.next;
                ptr.next = null;
                
                ListNode reversedNode = reverse(prev.next);
                
                ListNode tmp = prev.next;
                prev.next = reversedNode;
                prev = tmp;
                
                prev.next = next;
                ptr = next;
                pos = 1;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
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