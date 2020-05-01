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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return checkbool(root,arr,0);
    }
    
    boolean checkbool(TreeNode root,int []arr,int i){
        if(root==null)
            return false;
        
        if(root.val==arr[i]){
            if(i==arr.length-1)
            {
                if(root.left==null && root.right==null)
                    return true;
                return false;
            }
            boolean left=checkbool(root.left,arr,i+1);
            boolean right=checkbool(root.right,arr,i+1);
           
                return left||right;
        }
        return false;
        
    }
}