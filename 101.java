//https://leetcode.com/problems/symmetric-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    
    public boolean check(TreeNode rootleft,TreeNode rootright){
        if(rootleft==null && rootright==null)
            return true;
        if(rootleft==null || rootright==null)
            return false;
        
        if(rootleft.val!=rootright.val)
            return false;
        
        return check(rootleft.left,rootright.right)&&check(rootleft.right,rootright.left);
    }
}