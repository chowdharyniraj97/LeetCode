//https://leetcode.com/problems/combination-sum-iv/
class Solution {
   public int combinationSum4(int[] nums, int target) 
    {
        if (target <= 0) return 0;
        
        Arrays.sort(nums);
        int[] count = new int[target+1];
        count[0] = 1;
        for (int i=1; i<=target; i++)
        {
            for (int num : nums)
            {
                if (num > i) break;
                count[i] += count[i-num];
            }
        }
        return count[target];
    }
}