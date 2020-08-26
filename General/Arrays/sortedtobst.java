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
    public TreeNode sortedArrayToBST(int[] nums) {
       return  convert(nums,0,nums.length-1);
    }
    
    public TreeNode convert(int nums[],int i,int j){
        if(j<i)
            return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = convert(nums,i,mid-1);
        root.right = convert(nums,mid+1,j);
        return root;
    }
}

/*
go to center and that will be the root
left right and repeat


*/
