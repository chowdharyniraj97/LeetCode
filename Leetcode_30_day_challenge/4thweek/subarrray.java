class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
           int diff=sum-k;
            if(map.containsKey(diff)){
                count+=map.get(diff);
            }
            if(map.containsKey(sum)){
                int c=map.get(sum);
                map.put(sum,c+1);
            }
            else{
                map.put(sum,1);
            }
            
        }
        return count;
    }
}