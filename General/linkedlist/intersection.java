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
        int len1 = 0;
        ListNode listA = headA;
        
        while(listA!=null){
            listA=listA.next;
            len1++;
        }
        int len2=0;
        ListNode listB=headB;
        while(listB!=null){
            listB=listB.next;
            len2++;
        }
       
        if(len1>len2){
            ListNode temp = headA;
            headA=headB;
            headB=temp;
            int t = len1;
            len1=len2;
            len2=t;
        }
        
         int diff= len2-len1;
        
        listB=headB;
        
        while(diff>0){
            listB=listB.next;
            diff--;
        }
        
        listA=headA;
        ListNode ans = null;
        while(listA!=null &&listB!=null&&listA!=listB){
            listA=listA.next;
            listB=listB.next;
        }
        
        return listA;
        
        
        
        
        
    }
}
