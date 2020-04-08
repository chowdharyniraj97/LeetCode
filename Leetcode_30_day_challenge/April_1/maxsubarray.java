class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxsum=Integer.MIN_VALUE;
        int localsum=0;
        
        for(int i=0;i<nums.length;i++){
            
            localsum+=nums[i];
           maxsum=Math.max(maxsum,localsum);
            
            if(localsum<0 )
                localsum=0;
            //maxsum=Math.max(maxsum,localsum);
        }
    
        
        return maxsum; 
    }
}