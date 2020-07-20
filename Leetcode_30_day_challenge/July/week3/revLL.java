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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev=null;
        ListNode cur=head;
        if(cur==null)
            return null;
        
        while(cur!=null && cur.val==val){
            prev=cur;
            cur=cur.next;
        }
        head=cur;
        prev=cur;
        if(cur==null)
            return null;
        cur=cur.next;
    
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                cur.next=null;
                cur=prev.next;
           }
            else{
                prev=cur;
                cur=cur.next;
            }
        
    }
     return head;
}
       
}
