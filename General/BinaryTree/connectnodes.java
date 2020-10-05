/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Node prev = null;
        Node leftmost = null;
        Node head = root;
        root.next= null;
    
        while(head != null) {
            if(head.left !=null) {
                if(prev == null){
                    leftmost=prev=head.left;
                }
                else{
                    prev.next = head.left;
                    prev = head.left;
                }
            }
            
            if(head.right !=null) {
                 if(prev == null){
                    leftmost=prev=head.right;
                }
                else{
                    prev.next = head.right;
                    prev = head.right;
                }
            }
            head = head.next;
            if(head == null) {
                head = leftmost;
                prev = leftmost=null;
            }
        }
        return root;
    }
}
