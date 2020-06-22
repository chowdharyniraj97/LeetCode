class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int x : nums){
            if(map.containsKey(x))
            {
                int c=map.get(x);
                map.put(x,c+1);
            }
            else
                map.put(x,1);
        }
        int ans=-1;
        for(int keys : map.keySet()){
            if(map.get(keys)==1){
                ans=keys;
                break;
        }
        
        }
        return ans;
    }
}
