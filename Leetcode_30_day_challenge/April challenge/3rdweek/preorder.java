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
    public TreeNode bstFromPreorder(int[] preorder) {
        return preorderT(preorder,0,preorder.length-1);
    }
    
    TreeNode preorderT(int[] arr,int s,int e){
        if(s>e)
            return null;
        if(s-e==0)
            return new TreeNode(arr[s]);
        
        TreeNode root=new TreeNode(arr[s]);
        
        int leftindex=findleft(arr,s+1,e,arr[s]);
        root.left=preorderT(arr,s+1,leftindex-1);
        root.right=preorderT(arr,leftindex,e);
        return root;
            
    }
    
    int findleft(int arr[],int s,int e,int val){
        for(int i=s;i<=e;i++){
            if(arr[i]>val){
                return i;
            }
        }
        return e+1;
    }
}