
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
    public boolean isCousins(TreeNode root, int x, int y) {
        int ax[]=new int[2];
        int ay[]=new int[2];
        int px,py,ph,phy;
        findparent(root,ax,x,-1,ay);
            px=ay[1];
            ph=ay[0];
            ax[0]=0;
            ax[1]=0;
            ay[0]=0;
            ay[1]=0;
        findparent(root,ax,y,-1,ay);
        py=ay[1];
        phy=ay[0];
        if(phy==ph && py!=px)
            return true;
        return false;
    }
    
    void findparent(TreeNode root,int a[],int x,int prev,int ans[])
    {
        if(root==null){
            return;
        }
            
        if(root.val==x){
            a[1]=prev;
            ans[0]=a[0];
            ans[1]=prev;
            return;
        }
        a[0]++;
        findparent(root.left,a,x,root.val,ans);
        
        findparent(root.right,a,x,root.val,ans);
        a[0]--;
    }
}
