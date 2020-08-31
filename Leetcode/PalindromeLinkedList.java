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
    public boolean isPalindrome(ListNode head) {
        // MANAGING CORNER CASES
        if(head == null || head.next == null)
            return true;
        
        // FINDING MID OF LINKED-LIST
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // REVERSING THE LINKED-LIST
        ListNode mid = slow.next;
        slow.next = null;
        mid = reverse(mid);
        // CHECKING ONE-BY-ONE EACH ELEMENT
        while( head != null && mid != null) {
            if(mid.val != head.val) 
                return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
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