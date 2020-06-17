class Solution {
    HashMap<String,Integer> map;
    public int change(int amount, int[] coins) {
        map=new HashMap<>();
        return ways(amount,coins,0);
    }
    
    int ways(int amt,int [] coins,int index){
        if(amt==0)
            return 1;
        if(amt<0)
            return 0;
        
        if(map.containsKey(index+"|"+amt))
            return map.get(index+"|"+amt);
        
        int sum=0;
        
        for(int i=index;i<coins.length;i++){
            sum+=ways(amt-coins[i],coins,i);
        }
        map.put(index+"|"+amt,sum);
        return sum;
    }
}
