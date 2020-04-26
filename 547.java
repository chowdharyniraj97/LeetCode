class Solution {
    public boolean canJump(int[] nums) {
        
        int finalpos=nums.length-1;
        if(finalpos==0)
            return true;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=finalpos){
                finalpos=i;
            }
        }
        if(finalpos==0)
            return true;
        return false;
    }
}