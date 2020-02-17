//https://leetcode.com/problems/shortest-distance-from-all-buildings/
class Point{
    int x,y;
    int dist;
    Point(int x,int y,int d){
        this.x=x;
        this.y=y;
        dist=d;
    }
}
class Solution {
    public int shortestDistance(int[][] grid) {
        int b=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    b++;
            }
        }
        return placethehouse(grid,b);
        
        
    }
    
    int placethehouse(int grid[][],int b){
        int vis[][];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    vis=new int[grid.length][grid[0].length];
                    int ans=bfs(b,grid,i,j,grid.length,grid[0].length,vis);
               //     System.out.println(ans);
                    min=Math.min(min,ans);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1 : min;
    }
    
    int bfs(int b,int grid[][],int r,int c,int n,int m,int vis[][]){
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(r,c,0));
        int dist=0;
        vis[r][c]=1;
        while(!q.isEmpty()){
             if(b==0)
                return dist;
            
            Point cur=q.poll();
           // System.out.println(cur.x+" "+ cur.y+" "+cur.dist+ " "+grid[cur.x][cur.y]);
            int x=cur.x;
            int y=cur.y;
            if(grid[x][y]==1){
                dist+=cur.dist;
                b--;
                vis[x][y]=1;
                continue;
            }
             if(x+1<n && grid[x+1][y]!=2 && vis[x+1][y]!=1)
            {
                Point p=new Point(x+1,y,cur.dist+1);
                vis[x+1][y]=1;
                q.add(p);
            }
              if(x-1>=0 && grid[x-1][y]!=2 && vis[x-1][y]!=1)
            {
                Point p=new Point(x-1,y,cur.dist+1);
               // p.dist=cur.dist+1;
                vis[x-1][y]=1;
                q.add(p);
            }
            
              if(y-1>=0 && grid[x][y-1]!=2 && vis[x][y-1]!=1)
            {
                Point p=new Point(x,y-1,cur.dist+1);
                //p.dist=cur.dist+1;
                 vis[x][y-1]=1;
                q.add(p);
            }
             if(y+1<m && grid[x][y+1]!=2 && vis[x][y+1]!=1){
                 Point p=new Point(x,y+1,cur.dist+1);
                //p.dist=cur.dist+1;
                 vis[x][y+1]=1;
                q.add(p);
            }
        }
        if(b==0)
        return dist;
        else
            return Integer.MAX_VALUE;
        
    }
}