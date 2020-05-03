class Solution {
    public int minPathSum(int[][] grid) {
        return dfs(grid,grid.length,grid[0].length,0,0,new Integer[grid.length][grid[0].length]);
    }
    
    int dfs(int grid[][],int n,int m,int i,int j,Integer bid[][]){
       
        if(i==n-1&&j==m-1){
            return grid[i][j];
        }
         if(bid[i][j]!=null)
             return bid[i][j];
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
    
        if(i+1<n &&j+1<m){
            a=grid[i][j]+dfs(grid,n,m,i+1,j,bid);
            b=grid[i][j]+dfs(grid,n,m,i,j+1,bid);
            bid[i][j]= Math.min(a,b);
            return Math.min(a,b);
        }
        else if(i+1<n){
            
            a= grid[i][j]+dfs(grid,n,m,i+1,j,bid);
            bid[i][j]= a;
            return a;
        }
        else{
             b=grid[i][j]+dfs(grid,n,m,i,j+1,bid);
            bid[i][j]= b;
            return b;
        }
    
    }
}