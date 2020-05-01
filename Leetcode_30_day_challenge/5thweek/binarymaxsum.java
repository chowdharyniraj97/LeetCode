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
    int globalmax=-1;
    public int maxPathSum(TreeNode root) {
        globalmax=root.val;
        findmax(root);
//        int left=findmax(root.left);
//         int right=findmax(root.right);
//         int sum=root.val+left+right;
        
//         int lsum=left+root.val;
//         int rsum=right+root.val;
        
//         int best=Math.max(lsum,rsum);
        
//         best=Math.max(best,sum);
        
//         int ans= Math.max(best,root.val);
//         globalmax=Math.max(globalmax,ans);
//         globalmax=Math.max(globalmax,Math.max(left,right));
        return globalmax;
        
    
    }
    
    
    int findmax(TreeNode root){
         if(root==null)
            return Integer.MIN_VALUE;
        int left=findmax(root.left);
        left=left==Integer.MIN_VALUE?0:left;
        int right=findmax(root.right);
        right=right==Integer.MIN_VALUE?0:right;
       
       int sum=root.val+left+right;
        
        int lsum=left+root.val;
        int rsum=right+root.val;
        
        int best=Math.max(lsum,rsum);
        
        best=Math.max(best,root.val);
        int ans=best;
        globalmax=Math.max(globalmax,Math.max(ans,sum));
        //globalmax=Math.max(globalmax,Math.max(left,right));
        return ans;
}
}