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