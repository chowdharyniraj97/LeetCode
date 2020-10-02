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
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        int l1  = 0;
        int l2 = 0;
        ListNode head = h1;
        while(head != null) {
            l1++;
           head= head.next;
        }
        head = h2;
       while(head != null) {
            l2++;
           head =head.next;
        }
        
        //l1 list1
        //l2 list2
        //we want  list1 to be bigger
        
        if(l2 > l1) {
            ListNode temp = h1;
            h1 = h2;
            h2 = temp;
            int t = l1;
            l1 =l2;
            l2 =t;
        }
        
        int diff =  l1 - l2;
        int c = 0;
        head = h1;

        while(diff > 0) {
            head = head.next;
            diff--;
        } 
        
        
//         while(head.next != null) {
//             head.val = head.val+h2.val;
//             head = head.next;
//             h2= h2.next;
//         }
        
//         return h1;
        addList(head , h2);
        if(head.val < 10)
             return h1;
        
        addsinglelist(h1,head);
        if(h1.val >= 10) {
            ListNode x = new ListNode();
            x.val = 1;
            h1.val = h1.val %10;
            x.next = h1;
            h1 = x;
            
        }
        return h1;
        
    }
    void addList(ListNode h1, ListNode h2) {
    //System.out.println(h1.next +" "+h2.next);
        if(h1.next == null && h2.next == null)
        {
            h1.val = h1.val + h2.val;
            return;
        }
        
        addList(h1.next,h2.next);
        int next = h1.next.val;
        int r = next/10;
        h1.next.val = next%10;
        h1.val = h1.val + r + h2.val;
        return;
        
        
        
        
    }
    
    void addsinglelist(ListNode h1, ListNode h2){
        if(h1 == h2)
            return;
        addsinglelist(h1.next,h2);
        int next = h1.next.val;
        int r = next/10;
        h1.next.val = next%10;
        h1.val = r + h1.val;
        return;
    }
}







