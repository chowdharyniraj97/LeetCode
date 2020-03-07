
//https://leetcode.com/problems/target-sum/
//-----------------Naive======--------------------------------
class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
    
        return ways(nums,0,S);
    }
    
    int ways(int nums[],int ind,int S){
        if(ind==nums.length){
            if(S==0)
                return 1;
            return 0;
        }
        int plus=0;
        int neg=0;
        plus+=ways(nums,ind+1,S+nums[ind]);
        neg+=ways(nums,ind+1,S-nums[ind]);
        
        return plus+neg;
    }
}

//--------------------------------Top-Down-------------------------------------------
class Solution {
    HashMap<String,Integer> map;
    public int findTargetSumWays(int[] nums, int S) {
        map=new HashMap<>();
        return ways(nums,0,S);
    }
    
    int ways(int nums[],int ind,int S){
        if(ind==nums.length){
            if(S==0)
                return 1;
            return 0;
        }
        if(map.containsKey(ind+" "+S))
            return map.get(ind+" "+S);
       
        
        int plus=0;
        int neg=0;
        plus+=ways(nums,ind+1,S+nums[ind]);
        neg+=ways(nums,ind+1,S-nums[ind]);
        map.put(ind+" "+S,plus+neg); 
        return plus+neg;
    }
}

//-------------------Bottom up---------------------------------

public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0; 
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}