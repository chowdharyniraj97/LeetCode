class Solution {
    boolean iscycle=false;
    public int[] findOrder(int n, int[][] preq) {
        
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        //build the graph
        for(int x [] : preq)
        {
            int c1=x[0];
            int c2= x[1];
            
            if(map.containsKey(c1))
                map.get(c1).add(c2);
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(c2);
                map.put(c1,list);
            }
        }
        
        for(int i=0;i<n;i++){
            if(!map.containsKey(i)){
                List<Integer> list=new ArrayList<>();
                map.put(i,list);
            }
        }
        
        //start topo
        HashSet<Integer> instack =new  HashSet<>();//O(1) look up 
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(!instack.contains(i)){
                findOrder(n,map,st,instack,new HashSet<>(),i);
            }
        }
        if(!iscycle){
            int ans[]=new int[n];
        int i=0;
        
        for(int x : st)
            ans[i++]=x;
        return ans;
        }
        return new int[]{};
        
    }
    
    void findOrder(int n,  HashMap<Integer, List<Integer>> map,Stack<Integer> st,HashSet<Integer> instack ,HashSet<Integer> vis,int cur){
        
        if(vis.contains(cur)){
            iscycle=true;
            return;
        }
        vis.add(cur);
        
        List<Integer> lst=map.get(cur);
        
        for(int c : lst){
            if(!instack.contains(c))
            findOrder(n,map,st,instack,vis,c);
        }
        
        instack.add(cur);
        st.add(cur);
       // System.out.println(st);
        
        
        
        
        
        
        
        
    }
}
