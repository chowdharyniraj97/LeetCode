//https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
class Solution {
    final int mod=1000000007;
    HashMap<String,Integer> map=new HashMap<>();
    public int numWays(int steps, int arrLen) {
        return dfs(steps,arrLen,0);
    }
    
    int dfs(int steps,int len,int index){
        
        int left,right,stay;
        left=right=stay=0;
        
        if(index< 0 || index ==len)
            return 0;
        if(steps==0 && index==0){
            return 1;
        }
        if(steps==0)
            return 0;
        if(map.containsKey(index+ " "+steps))
            return map.get(index+" "+steps);
        
        left=dfs(steps-1,len,index-1);
        right=dfs(steps-1,len,index+1);
        int x= (left+right)%mod;
        stay=(dfs(steps-1,len,index)+x)%mod;
        map.put(index+ " "+steps,stay);
        return stay;
    }
}