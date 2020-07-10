/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
            return null;
        Node Head=head;
        merge(head);
        return Head;
    }
    
    Node merge(Node head){
        
        Node last=findLast(head);
        
        Node cur=head;
        while(cur!=null){
         // System.out.println(cur.child);
          if(cur.child!=null){
              
            Node childNodeLast=merge(cur.child);
              System.out.println(childNodeLast.val);
            Node temp=cur.next;//null
              
            cur.next=cur.child;
            cur.child.prev=cur;
             cur.child=null;
            
            childNodeLast.next=temp;
              if(temp!=null){
              temp.prev=childNodeLast;
              
            
            }
           
                cur=childNodeLast;
          }
          cur=cur.next;
           
            
            
        }
        
        return last;
    }
    
   Node findLast(Node start){
        while(start.next!=null){
            start=start.next;
        }
        return start;
    }
    
    
}
