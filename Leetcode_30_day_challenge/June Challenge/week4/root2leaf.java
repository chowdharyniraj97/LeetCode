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
    public int sumNumbers(TreeNode root) {
        getSum(root,0+"");
        return sum;
    }
    
    int getSum(TreeNode root,String num){
        if(root==null)
            return 0;
        
        num=num+root.val;
        
        int left=getSum(root.left,num);
        int right=getSum(root.right,num);
        if(left==0 && right==0)
            sum+=Integer.parseInt(num);
        return 1;
    }
}
