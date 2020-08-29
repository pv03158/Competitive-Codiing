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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode midNode = findMid(head);
        ListNode left = head;
        ListNode right = midNode.next;
        midNode.next = null;
        
        left = sortList(left);
        right = sortList(right);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        
        ListNode ptr = dummy;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                ptr.next = h1;
                h1 = h1.next;
            }
            else {
                ptr.next = h2;
                h2 = h2.next;
            }
            ptr = ptr.next;
        }
        if(h1 == null)
            ptr.next = h2;
        else
            ptr.next = h1;
        
        return dummy.next;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}