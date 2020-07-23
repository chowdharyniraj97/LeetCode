//Reverse kgroups of linkedlist
//https://leetcode.com/problems/reverse-nodes-in-k-group/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Recursive
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        ListNode head1=null;
        if(cur==null||k<2)
            return head;
        int kk=k;
       
            while(k-->1){
                cur=cur.next;
                if(cur==null)
                    break;
                
            }
        
            if(k==0){
            head1=cur.next;
            cur.next=null;
            ListNode head3=reverseKGroup(head1,kk);
            ListNode head2=reverse(head);
            cur=head2;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=head3;

            return head2;
            }
        return head;
        
    }
    
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        ListNode nextnode=head.next;
        while(nextnode!=null){
            cur.next=prev;
            prev=cur;
            cur=nextnode;
            nextnode=nextnode.next;
        }
        cur.next=prev;
        return cur;
    }
}

//--------------------------------------------NON Recursive---------------------------------------------------------------

public ListNode reverseKGroup(ListNode head, int k) {
    ListNode begin;
    if (head==null || head.next ==null || k==1)
    	return head;
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    begin = dummyhead;
    int i=0;
    while (head != null){
    	i++;
    	if (i%k == 0){
    		begin = reverse(begin, head.next);
    		head = begin.next;
    	} else {
    		head = head.next;
    	}
    }
    return dummyhead.next;
    
}

public ListNode reverse(ListNode begin, ListNode end){
	ListNode curr = begin.next;
	ListNode next, first;
	ListNode prev = begin;
	first = curr;
	while (curr!=end){
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
	}
	begin.next = prev;
	first.next = curr;
	return first;
}