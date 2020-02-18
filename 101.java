//https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    
    public boolean check(TreeNode rootleft,TreeNode rootright){
        if(rootleft==null && rootright==null)
            return true;
        if(rootleft==null || rootright==null)
            return false;
        
        if(rootleft.val!=rootright.val)
            return false;
        
        return check(rootleft.left,rootright.right)&&check(rootleft.right,rootright.left);
    }
}

//------------------------------------Iterative-----------------------------------------------------------------------------------------------

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> q=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        //q.add(root);
        TreeNode dummy=new TreeNode(-1);
        s.push(dummy);
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;
        q.add(root.left);
        q.add(root.right);
        int size=2;
        int ss=2;
        while(!q.isEmpty()){
            size=ss;
            ss=0;
            for(int i=0;i<size/2;i++){
                TreeNode x=q.poll();
            if(x!=dummy){
                if(x.left!=null && x.right!=null){
                    q.add(x.left);
                    q.add(x.right);
                    ss+=2;
                    
                }
                else if(x.left!=null)
                {
                    q.add(x.left);
                    q.add(dummy);
                     ss+=2;
                   
                }
                else if(x.right!=null){
                     q.add(dummy);
                     q.add(x.right);
                     ss+=2;
                    
                   
                }
                else{
                     q.add(dummy);
                     q.add(dummy);
                    ss+=2;
                }
            }
                s.push(x);
                
                
            }
            for(int i=0;i<size/2;i++){
                int a=s.pop().val;
                TreeNode x=q.poll();
                int b=x.val;
                System.out.println(a+" "+ b);
                if(a!=b)
                    return false;
           if(x!=dummy){     
                 if(x.left!=null && x.right!=null){
                    q.add(x.left);
                    q.add(x.right);
                     ss+=2;
                }
                else if(x.left!=null)
                {
                    q.add(x.left);
                    q.add(dummy);
                    ss+=2;
                }
                else if(x.right!=null){
                    q.add(dummy);
                     q.add(x.right);
                    ss+=2;
                    
                }
                else{
                     q.add(dummy);
                     q.add(dummy);
                    ss+=2;
                }
               
                
            }
            }
            
            
        }
        return true;
    }
}