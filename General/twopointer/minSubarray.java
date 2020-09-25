class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int j=1;
        if(nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while(j < nums.length) {
             if(sum >= s) {
                 min = Math.min(min,j-i);
                 sum-=nums[i++];
             }
            
            else {
                sum+=nums[j++];
            }
        }
        
        while(i < nums.length) {
            if(sum >= s) {
               min = Math.min(min,j-i);
               sum-=nums[i++]; 
            }
            else{
                break;
            }
            
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
