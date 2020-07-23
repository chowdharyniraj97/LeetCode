
//https://leetcode.com/problems/tree-diameter/
class Solution {
    int globalmax=0;
    public int treeDiameter(int[][] edges) {
         HashMap<Integer, List<Integer>> graph=new HashMap<>();
        for(int i=0;i<edges.length;i++){
           // System.out.println(edges[i][0]+ " "+edges[i][1]);
            if(graph.containsKey(edges[i][0]))
               graph.get(edges[i][0]).add(edges[i][1]);
            
            
            else{
                List<Integer> list=new ArrayList<>();
                list.add(edges[i][1]);
                graph.put(edges[i][0],list);
            }
            
               
        
             if(graph.containsKey(edges[i][1]))
                  graph.get(edges[i][1]).add(edges[i][0]);
            
               else{
                List<Integer> list=new ArrayList<>();
                list.add(edges[i][0]);
                graph.put(edges[i][1],list);
            } 
            
            
          
        
    }
         finddiameter(graph,0,-1);
        return globalmax;
    }
    
    int finddiameter(HashMap<Integer, List<Integer>> graph,int node,int p){
        
        int max=0;
        int secondmax=0;
        for(int i : graph.get(node)){
            int localmax=0;
            if(i==p)
                continue;
            localmax=1+finddiameter(graph,i,node);
            if(localmax>max){
                secondmax=max;
                max=localmax;
                
            }
            else if(localmax>secondmax)
                secondmax=localmax;
        }
        if(max+secondmax>globalmax)
            globalmax=max+secondmax;
        return Math.max(max,secondmax);
    }
}