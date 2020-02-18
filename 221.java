//https://leetcode.com/problems/maximal-square/
// Naive solution gives TLE
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
//////////////////////////////////Recursive soln/////////////////////////////////////////////////////////////
class Solution {
    int max=-1;
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
      int memo[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,maximum(matrix,i,j));
            }
        }
        return max*max;
    }
    
    int maximum(char[][]matrix,int i,int j){
        if(i<0 || j<0)
            return 0;
       
        
        if(matrix[i][j]=='0')
            return 0;
        
        
        int ans=Math.min(maximum(matrix,i,j-1),Math.min(maximum(matrix,i-1,j),maximum(matrix,i-1,j-1)))+1;
      //  System.out.println(ans);
        
       //max=Math.max(ans,max);
        return ans;
        
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}

//-------------------------------------MEMO----------------------------------------------------------
class Solution {
    int max=-1;
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
      int memo[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,maximum(matrix,i,j,memo));
            }
        }
        return max*max;
    }
    
    int maximum(char[][]matrix,int i,int j,int memo[][]){
        if(i<0 || j<0)
            return 0;
       
        
        if(matrix[i][j]=='0')
            return 0;
        if(memo[i][j]!=0)
            return memo[i][j];
        
        
        int ans=Math.min(maximum(matrix,i,j-1,memo),Math.min(maximum(matrix,i-1,j,memo),maximum(matrix,i-1,j-1,memo)))+1;
      //  System.out.println(ans);
        memo[i][j]=ans;
       //max=Math.max(ans,max);
        return ans;
        
    }
}

//-----------------------------------------------------------dp------------------------------------------------