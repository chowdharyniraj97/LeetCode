class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        int max = 1;
        for(int i : nums){
            if(max < i)
            {
                max =i;
            }
            
            set.add(i);
        }
        
        for(int i=1;i<=max;i++){
            if(!set.contains(i))
                return i;
        }
        return max+1;
    }
}

