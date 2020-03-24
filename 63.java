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

//space efficient soln

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid[0].length;
        int m=obstacleGrid.length;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
            return 0;
        int grid[]=new int[obstacleGrid[0].length];
        grid[0]=1;
        for(int i=1;i<obstacleGrid[0].length;i++){
            
            if(obstacleGrid[0][i]==0)
                grid[i]=grid[i-1];
        }
        for(int i=1;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1)
                grid[0]=0;
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    grid[j]=0;
                    continue;
                }
                grid[j]=grid[j]+grid[j-1];
            }
        }
        return grid[obstacleGrid[0].length-1];
    }
}