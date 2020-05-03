///https://leetcode.com/problems/range-sum-of-bst/
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
    int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        findsum(root,L,R);
        return sum;
    }
    
    
    void findsum(TreeNode root,int l,int r){
        if(root==null)
            return;
        if(root.val>=l && root.val<=r){
            sum+=root.val;
            if(root.val==l){
                findsum(root.right,l,r);
            }
            else if(root.val==r){
                findsum(root.left,l,r);
            }
            else{
                findsum(root.right,l,r);
                findsum(root.left,l,r);
            }
            
        }
        else{
            if(root.val>r){
                findsum(root.left,l,r);
            }
            else if(root.val<l){
                findsum(root.right,l,r);
            }
        }
    }
}