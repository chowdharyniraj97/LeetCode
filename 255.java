//https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        return check(preorder,0,preorder.length-1);
        
    }
    
    boolean check(int preorder[],int s,int e){
       // System.out.println(s+ " "+ e);
        if(s>e)
            return true;
        if(e-s==1|| e-s==0)
            return true;
        int rootind=s;
        int rightsubtree=findfirstbig(preorder,s,e,preorder[rootind]);
       
        int leftsubtree=rightsubtree-1;
        
        boolean left=check(preorder,rootind+1,leftsubtree);
        boolean right=check(preorder,rightsubtree,e);
        
        for(int i=rootind+1;i<=leftsubtree;i++){
            if(preorder[i]>preorder[rootind])
                return false;
        }
        
        for(int i=rightsubtree;i<=e;i++){
            if(preorder[i]<preorder[rootind])
                return false;
        }
        return left && right;
        
        
        
        
    }
    
    int findfirstbig(int preorder[],int s,int e,int root){
        
        for(int i=s;i<=e;i++){
            if(preorder[i]>root)
                return i;
        }
        return e+1;
    }
}