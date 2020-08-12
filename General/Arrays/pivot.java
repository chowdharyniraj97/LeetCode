class Solution {
    public int pivotIndex(int[] nums) {
        int sum [] = new int[nums.length+1];
        sum[0]= 0;
        
        for(int i = 1; i<=nums.length;i++){
            sum[i]= nums[i-1]+sum[i-1];
        }
        int pivot = -1;
        for(int i =1 ; i <= nums.length;i++){
            if(sum[i-1] == sum[nums.length]- sum[i])
                return i-1;
        }
        
        return pivot;
    }
}
