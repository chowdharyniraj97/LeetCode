class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int r=grid.length;
        int nos=0;
        int c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1')
                {
                    nos++;
                    dfs(grid,i,j,r,c);
            }
        }
        
    }
        return nos;
}
    void dfs(char[][]grid,int i,int j,int r,int c){
       if(i<0||i>=r||j<0||j>=c||grid[i][j]=='0')
           return;
        grid[i][j]='0';
        dfs(grid,i+1,j,r,c);
        dfs(grid,i-1,j,r,c);
        dfs(grid,i,j+1,r,c);
        dfs(grid,i,j-1,r,c);
    }
}