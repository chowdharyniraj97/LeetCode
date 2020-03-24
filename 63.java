//https://leetcode.com/problems/unique-paths-ii/
class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        return dfs(obstacleGrid,n,m,0,0,new Integer[n][m]);
    }
    
    
    
    int dfs(int[][]grid,int n,int m,int r,int c,Integer vis[][]){
        
        if(r==n||c==m||c<0||r<0||grid[r][c]==1)
            return 0;
        if(r==n-1 && c==m-1)
            return 1;
        if(vis[r][c]!=null)
            return vis[r][c];
        int a= dfs(grid,n,m,r+1,c,vis);
        int b=dfs(grid,n,m,r,c+1,vis);
        vis[r][c]=a+b;
        return a+b;
        
    }
}