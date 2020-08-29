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
    public void reorderList(ListNode head) {
        // MANAGING CORNER CASES
        if(head == null || head.next == null 
           || head.next.next == null)
            return;
        ListNode slow, fast;
        slow = fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode h1 = head;
        ListNode h2 = slow.next;
        slow.next = null;
        
        // REVERSING LIST H2
        h2 = reverse(h2);
        // MERGING BOTH LISTS TOGETHER
        merge(h1, h2);
    }
    
    private ListNode merge(ListNode h1 , ListNode h2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode ptr = dummy;
        
        while(h1 != null && h2 != null) {
            ptr.next = h1;
            ptr = ptr.next;
            h1 = h1.next;
            
            ptr.next = h2;
            ptr = ptr.next;
            h2 = h2.next;
        }
        
        if(h1 == null)
            ptr.next = h2;
        else 
            ptr.next = h1;
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        
        while(head != null) {
            ListNode ptr = head;
            head = head.next;
            ptr.next = dummy.next;
            dummy.next = ptr;
        }
        
        return dummy.next;
    }
}