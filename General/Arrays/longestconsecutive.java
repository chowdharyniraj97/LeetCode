class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int x : nums){
            set.add(x);
        }
        int longest = 0;
        HashSet<Integer> vis = new HashSet<>();
        for(int i=0;i<nums.length;i++ ){
            if(!vis.contains(nums[i])){
                longest = Math.max(longest,check(nums[i],vis,set));
            }
            
        }
        return longest;
    }
    
    
    int check(int x,HashSet<Integer> vis,HashSet<Integer> set){
        
        if(!vis.contains(x) && set.contains(x)){
            vis.add(x);
            int small =check(x-1,vis,set);
            int big = check(x+1,vis,set);
            return 1+small + big;
                
        }
        else{
            return 0;
        }
        
    }
}
