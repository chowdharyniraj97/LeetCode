//Copy the code to this link-> https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/submissions/
//Form a Doubly circular linked list from BST

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head=null;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
      Node head=formll(root);
        
        Node tail=head;
        while(tail.right!=null){
            tail=tail.right;
        }
        tail.right=head;
        head.left=tail;
        return head;

        
        
        
    }
    
    public Node formll(Node cur){
        if(cur==null)
            return null;
        
    Node lefthead=formll(cur.left);
    Node righthead=formll(cur.right);
    
    if(lefthead==null && righthead==null)
        return cur;
        
    if(lefthead==null){
        cur.left=lefthead;
        cur.right=righthead;
        righthead.left=cur;
        return cur;
    }
    if(righthead==null){
        Node tail=lefthead;
        while(tail.right!=null)
            tail=tail.right;
        tail.right=cur;
        cur.left=tail;
        cur.right=righthead;
        return lefthead;
        
        }
        
     Node tail=lefthead;
     while(tail.right!=null)
        tail=tail.right;
     cur.left=tail;
     tail.right=cur;
     cur.right=righthead;
     righthead.left=cur;
     return lefthead;
    
        
        
        
        
        
        
    }
    
}