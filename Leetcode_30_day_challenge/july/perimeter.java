class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    perimeter+=island(grid,i,j,n,m);
                }
            }
        }
        
        return perimeter;
    }
    
    int island(int grid[][],int i,int j,int n,int m){
        int sum=0;
        
        if((i-1>=0 &&grid[i-1][j]==0) || i-1<0)
            sum++;
        
        if((i+1<n &&grid[i+1][j]==0) || i+1==n)
            sum++;
        
        if((j-1>=0 &&grid[i][j-1]==0) || j-1<0)
            sum++;
        
        if((j+1<m &&grid[i][j+1]==0) || j+1==m)
            sum++;
        
        return sum;
        
        
    }
}
