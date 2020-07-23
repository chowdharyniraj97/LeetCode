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
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
       // LinkedHashMap<Integer,ArrayList<Integer>> map=new LinkedHashMap<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
       int h=height(root);
         ArrayList<Integer> xx=new ArrayList<>();
        xx.add(root.val);
        ans.add(xx);
        for(int i=1;i<h;i++){
             ArrayList<Integer> current=new ArrayList<>();
            if(i%2==0){
               
                traverse(root.left,1,i,current,true);
                traverse(root.right,1,i,current,true);
            }
            else
            {
                 
                traverse(root.right,1,i,current,false);
                traverse(root.left,1,i,current,false);
            }
            ans.add(current);
        }
        return ans;
       
                                                                
        
    }
    
    void traverse(TreeNode root,int start,int dest,ArrayList<Integer> cur,boolean LR){
        if(root==null)
            return;
        if(start==dest){
            cur.add(root.val);
            return;
        }
        if(LR){
            traverse(root.left,start+1,dest,cur,LR);
             traverse(root.right,start+1,dest,cur,LR);
        }
        else{
            traverse(root.right,start+1,dest,cur,LR);
             traverse(root.left,start+1,dest,cur,LR);
        }
            
       
    }
    
    int height(TreeNode root){
        if(root==null)
            return 0;
       int left=height(root.left);
       int right=height(root.right);
       if(left>right)
           return left+1;
        else
            return right+1;
    }
}
