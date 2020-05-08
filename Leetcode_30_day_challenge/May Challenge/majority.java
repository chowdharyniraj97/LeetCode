
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length/2;
        
        return nums[size];
    }
}
