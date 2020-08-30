/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // MANAGING CORNER CASES
        if(headA == null || headB == null)
            return null;
        
        // CALCULATING THE SIZE OF LIST-A
        int sizeA = 1;
        ListNode ptr = headA;
        while(ptr != null)  {
            sizeA += 1;
            ptr = ptr.next;
        }
        
        // CALCULATING THE SIZE OF LIST-B
        int sizeB = 1;
        ptr = headB;
        while(ptr != null) {
            sizeB += 1;
            ptr = ptr.next;
        }
        
        // MAKING SURE C2 ALWAYS HOLD GREATER LENGTH LIST
        ListNode c1 = headA, c2 = headB;
        int diff = Math.abs(sizeA - sizeB);
        if(sizeA > sizeB) {
            ListNode tmp = c1;
            c1 = c2;
            c2 = tmp;
        }
        
        // PROCEEDING C2 FURTHER BY DIFF DISTANCE
        while(diff-- > 0)
            c2 = c2.next;
        
        // CHECKING FOR INTERSECTION
        while(c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return c1;
    }
}