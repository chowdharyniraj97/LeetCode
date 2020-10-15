class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       int count[] = new int[101];
        
        for(int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        
        
        int accsum[] = new int[101];
        int presum = 0;
        for(int i=0;i<=100;i++) {
            accsum[i] = presum;
            presum =presum + count[i];
        }
        
        
        int result[] = new int[nums.length];
        
        for(int i =0; i <nums.length;i++) {
            int total = accsum[nums[i]];
            result[i] = total;
        }
        
        return result;
    }
}
