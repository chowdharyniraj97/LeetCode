class Solution {
    public int singleNumber(int[] nums) {
        int sum=0;
        for(int a : nums){
            sum=sum^a;
        }
        return sum;
    }
}