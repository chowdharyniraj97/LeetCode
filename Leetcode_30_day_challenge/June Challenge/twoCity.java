class Solution {
    HashMap<String,Integer> map;
    public int twoCitySchedCost(int[][] costs) {
        map=new HashMap<>();
        return findcost(costs,costs.length,0,0,0);
    }
    
    
    int findcost(int costs[][],int n,int i,int countA,int countB){
        
        if(countA==n/2 && countB==n/2)
            return 0;
        
        if(map.containsKey(i+"|"+countA+"|"+countB))
            return map.get(i+"|"+countA+"|"+countB);
        
        int local=Integer.MAX_VALUE;
        if(countA<n/2)
            local=Math.min(local,costs[i][0]+findcost(costs,n,i+1,countA+1,countB));
        int local1=Integer.MAX_VALUE;
        if(countB<n/2)
            local1=Math.min(local1,costs[i][1]+findcost(costs,n,i+1,countA,countB+1));
        
        map.put(i+"|"+countA+"|"+countB,Math.min(local,local1));
        
        return Math.min(local,local1);
    }
}
