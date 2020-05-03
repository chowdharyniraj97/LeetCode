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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
         height(root);
        return diameter;
    }
    
    int height(TreeNode root){
        if(root==null)
            return 0;
        int l=height(root.left);
        int r=height(root.right);
        diameter=Math.max(diameter,l+r);
        if(l>r)
            return l+1;
        else
            return r+1;
    }
}