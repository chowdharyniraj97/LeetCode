class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int low =0;
        int high = 0;
        int zero = 0;
        int max = 0;
        while(high < nums.length) {
            if(nums[high] == 0) {
                zero++;
            }
            while(zero  > 1) {
                if(nums[low] == 0) {
                    zero--;
                }
                low++;
            }
            
            max = Math.max(high - low + 1, max);
            high++;
        }
        return max;
    }
}
