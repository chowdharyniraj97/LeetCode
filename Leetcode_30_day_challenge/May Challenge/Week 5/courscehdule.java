
class Solution {
    int global[];
    public boolean canFinish(int num, int[][] prereq) {
        global=new int[num];
        int graph[][]=new int[num][num];
        for(int [] pre :prereq)
        {
            int x=pre[0];
            int y=pre[1];
            graph[x][y]=1;
        }
        boolean ans=true;
        int vis[];
        for(int i=0;i<num;i++){
            vis=new int[num];
            if(global[i]==0)
                 ans=ans && isposs(graph,num,i,vis);
        }
        return ans;
    }
    
    
    boolean isposs(int graph[][],int num,int cur,int vis[]){
        if(vis[cur]==1)
            return false;
        
        vis[cur]=1;
        for(int i=0;i<num;i++){
            
            if(graph[cur][i]==1){
                    return false;
                
            }
            
        }
        global[cur]=1;
        vis[cur]=0;
        return true;
        
    }
}

