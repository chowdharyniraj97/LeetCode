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
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        
        
        root.val=1;
        int size=1;
        int ans=0;
        q.add(root);
        while(!q.isEmpty()){
            int s=size;
            size=0;
            int min=Integer.MAX_VALUE;
            int max=-2;
            
           for(int i=0;i<s;i++){

                TreeNode cur=q.poll();
                min=Math.min(min,cur.val);
                max=Math.max(max,cur.val);
            
                if(cur.left!=null)
                {
                    cur.left.val=cur.val*2;
                    size++;
                    q.add(cur.left);
                }
               
               if(cur.right!=null){
                   cur.right.val=cur.val*2+1;
                   size++;
                   q.add(cur.right);
               }
               
           } 
           
            //System.out.println(max+" "+min);
            ans=Math.max(ans,max-min+1);
            
            
            
        }
        return ans;
    }
}
