/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        return countlastidx(root,1);
        
    }
    
    int countlastidx(TreeNode root,int cur){
        if(root.left==null&&root.right==null)
            return cur;
        
        int left=height(root.left);
        int right=height(root.right);
        
        if(left==right){
            return countlastidx(root.right,cur*2+1);
        
        }
        else
            return countlastidx(root.left,cur*2);
        
        
        
    }
    
    
    
    int height(TreeNode root){
        if(root==null)
            return 0;
        return 1+height(root.left);
    }
}
