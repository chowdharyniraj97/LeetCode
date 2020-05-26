class Solution {
    int max=0;
    HashMap<String,Integer> map;
    public int maxUncrossedLines(int[] A, int[] B) {
        map=new HashMap<>();
        return findmax(A,B,0,A.length,0);
    }
    
    int findmax(int a[],int b[],int s,int e,int cur){
        if(cur==b.length)
            return 0;
        
        if(map.containsKey(s+"|"+e+"|"+cur))
            return map.get(s+"|"+e+"|"+cur);
        
        int with=0;
        int without=0;
        int ind=index(s,e,a,b,cur);
        if(ind!=-1)
            with=1+findmax(a,b,ind+1,e,cur+1);
        
        without=findmax(a,b,s,e,cur+1);
        
       
        int best=Math.max(with,without);
        //max=Math.max(max,best);
        map.put(s+"|"+e+"|"+cur,best);
        return best;
    }
    
    int index(int s,int e,int a[],int b[],int cur){
        for(int i=s;i<e;i++){
            if(a[i]==b[cur])
                return i;
            
                
        }
        return -1;
    }
}
