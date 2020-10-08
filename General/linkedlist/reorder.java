class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode fast = head, slow = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
        }
		ListNode curr = slow.next, next = null, prev = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
        }

        ListNode head2 = prev;
        ListNode head1 = head;
        ListNode cur1 = null;
        ListNode cur2 =null;
        while(head1!=null && head2!=null) {
           cur1= head1;
            cur2 = head2;
            head1=head1.next;
            head2 = head2.next;
            cur1.next = cur2;
            cur2.next=head1;
            
        }
        
       slow.next = null;
        
        
        
    
    }
}
 

