/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode pointer;
        pointer = sum;
        pointer.val = 0;
        while(l1 != null || l2 != null ) {
            // fetching each bit and adding them together
            int bit1 = (l1 == null) ? 0 : l1.val;
            int bit2 = (l2 == null) ? 0 : l2.val;
            
            // inserting value in node
            int res = bit1 + bit2 + pointer.val;
            pointer.val = res % 10;
            
            // updating l1 and l2
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            
            // no need to create a new node in memory if next bits and carry is null
            if ( l1 == null && l2 == null && res/10 == 0)
                break;
            // creating new node in memory if next bits or carry available
            else {
                pointer.next = new ListNode();
                pointer = pointer.next;
                pointer.val = res / 10;   
            }
        }
        return sum;
    }
}