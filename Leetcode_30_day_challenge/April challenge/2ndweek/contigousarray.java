class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        
        int globalmax=0;
        int count=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else
                count--;
            if(map.containsKey(count)){
                globalmax=Math.max(i-map.get(count),globalmax);
            }
            else
                map.put(count,i);
        }
        
        return globalmax;
    }
}