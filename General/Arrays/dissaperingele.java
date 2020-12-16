class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i  : nums) {
            i = Math.abs(i);
            if(nums[i-1] > 0) {
                nums[i-1]*=-1;
            }
        }
        
        for(int i =0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
