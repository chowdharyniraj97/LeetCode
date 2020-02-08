// problem no 173
// https://leetcode.com/problems/binary-search-tree-iterator/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
        TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root=root;
    }
    
    /** @return the next smallest number */
    public int next() {//has yo be leaf
        TreeNode prev=null;
        TreeNode cur=root;
        while(cur.left!=null){
            prev=cur;
            cur=cur.left;
        }
        if(cur==root){
            root=cur.right;
            return cur.val;
        }
        
        if(cur.left==null && cur.right==null){
            prev.left=null;
        return cur.val;
        }
        else{
            prev.left=cur.right;
            return cur.val;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         TreeNode prev=null;
        TreeNode cur=root;
     if(cur==null)
         return false;
        return true;
    }
}
