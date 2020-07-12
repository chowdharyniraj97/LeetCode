class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; ++i){
            int left = i + 1, right = nums.length -1;
            int sum = 0 - nums[i];
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                
                while(left < right){
                    if(nums[left] + nums[right] == sum){
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while(left < right && (nums[left + 1] + nums[right] < sum || nums[left] == nums[left+1])){
                            ++left;
                        } 
                        while(left < right && nums[right - 1] + nums[left] > sum){
                            --right;
                        } 
                        ++left;
                        --right;
                        
                    } else if(nums[left] > sum) {
                        break;
                        
                    } else if(nums[left] + nums[right] < sum) {
                        ++left;
                        
                    } else {
                        --right;
                    }
                }
            }   
        }
        return result;
    }
}
