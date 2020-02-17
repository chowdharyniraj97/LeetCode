//https://leetcode.com/problems/maximal-square/
class Solution {
    int max=0;
    public int maximalSquare(char[][] matrix) {
        
        int n=matrix.length;
        if(n==0)
            return 0;
        
        int m=matrix[0].length;
       // System.out.println(n +" "+ m);
        if(n==1 && m==1)
            return matrix[0][0]-'0';
        boolean flag=false;
        int vis[][];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    flag=true;
                    vis=new int[n][m];
                   findsquare(matrix,0,0,0,0,n,m,i,j,vis);
               }
                    
            }
        }
        if(flag)
        return max>0?max : 1;
        
        return 0;
        
    }
    
    void findsquare(char matrix[][],int l,int r,int b,int u,int n,int m,int row,int col,int vis[][]){
        
        if(row<0||col<0 || row==n||col==m || matrix[row][col]=='0')
            return;
        if(vis[row][col]==1){
            if(l==b && b==r && r==u){
                
                if(checkones(matrix,row,col,row+b,col+r,n,m)){
                    max=Math.max(max,(l+1)*(l+1));
                    
                    }
                if(checkones(matrix,row-b,col,row,col+r,n,m)){
                      max=Math.max(max,(l+1)*(l+1));
                   // break;
                      }
                 if(checkones(matrix,row-b,col-b,row,col,n,m)){
                         max=Math.max(max,(l+1)*(l+1));
                    // break;
                         }
                 if(checkones(matrix,row,col-b,row+b,col+r,n,m)){
                          max=Math.max(max,(l+1)*(l+1));
                }
                
                
            }
            return;
        }
        
        vis[row][col]=1;
        findsquare(matrix,l+1,r,b,u,n,m,row,col-1,vis);
        findsquare(matrix,l,r+1,b,u,n,m,row,col+1,vis);
        findsquare(matrix,l,r,b+1,u,n,m,row+1,col,vis);
        findsquare(matrix,l,r,b,u+1,n,m,row-1,col,vis);
        vis[row][col]=0;
        
    }
    
    boolean checkones(char matrix[][],int row,int col,int re,int ce,int n,int m){
        if(row<0 || col<0 || re<0 ||ce <0 || row>=n|| col>=m || re>=n || ce>=m)
            return false;
        
        for(int i=row;i<=re;i++){
            for(int j=col;j<=ce;j++){
                if(matrix[i][j]=='0')
                    return false;
            }
        }
        return true;
    }
    
    
    
    
}