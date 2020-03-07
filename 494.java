
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