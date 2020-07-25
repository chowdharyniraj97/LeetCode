class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        int n =g.length;
        int graph[][]=new int[n][n];
      
        //building the graph
        for(int i=0;i<n;i++){
            for(int node : g[i]){
                graph[i][node]=1;
            }
        }
        
        //we start the process
        
        int src=0;
        int dest=n-1;
        
        List<List<Integer>> ans =dfs(graph,src,dest);
      for(List<Integer> x : ans){
           x.add(0,0);
        
      
        
    }
         return ans;
    }
    
    List<List<Integer>> dfs(int graph[][],int src,int dest){
        
        if(src==dest){
            List<List<Integer>> lst =new LinkedList<>();
            LinkedList<Integer> l=new LinkedList<>();
            // l.add(src);
            lst.add(l);
            return lst;
        }
        
        List<List<Integer>> a=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(graph[src][i]==1)
            {
                List<List<Integer>> ans=dfs(graph,i,dest);
                for(List<Integer> x : ans){
                    x.add(0,i);
                    a.add(x);
                }
                
            }
        }
        
        return a;
        
        
        
        
    }
    
    
    
}
