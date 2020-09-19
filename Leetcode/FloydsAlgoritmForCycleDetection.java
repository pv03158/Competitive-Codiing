
// CYCLE DETECTION IN A LINKED LIST
public boolean hasCycle(ListNode head) {
	// USING FLOYDS ALGORITHM
  if(head == null || head.next == null)
  	return false;
    
  ListNode slow = head;
  ListNode fast = head;
  while(fast.next != null && fast.next.next != null) {
  	slow = slow.next;
    fast = fast.next.next;
    if(slow == fast)
    	return true;
  }
  
  return false;
}