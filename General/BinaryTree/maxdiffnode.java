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
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
       int r[]= findMaxValue(root,-1);
         res = Math.max(res, Math.abs(r[0] - root.val));
        res = Math.max(res, Math.abs(r[1] - root.val));
        return res;
        
    }
    
    
    private int[] findMaxValue(TreeNode root, int val) {
        if(root == null) {
            return new int[]{val,val};
        }
        
        int left[] = findMaxValue(root.left,root.val);
        int right [] = findMaxValue(root.right,root.val);
        
        int range[] = new int[2];
        
        
        res = Math.max(res, Math.abs(left[0] - root.val));
        res = Math.max(res, Math.abs(left[1] - root.val));
        res = Math.max(res, Math.abs(right[0] - root.val));
        res = Math.max(res, Math.abs(right[1] - root.val));
        
        range[0] = Math.min(left[0],right[0]);
        range[1] = Math.max(left[1],right[1]);
        
        range[0] = Math.min(range[0],root.val);
         range[1] = Math.max(range[1],root.val);
        return range;
        
        
    }
}
