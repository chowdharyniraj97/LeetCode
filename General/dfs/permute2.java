class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //maintain a count
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int ele : nums) {
            map.put(ele,map.getOrDefault(ele,0) + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        permute(map,result, new ArrayList<>(),nums.length);
        return result;
    }
    
    
    void permute(HashMap<Integer,Integer> map, List<List<Integer>> result,List<Integer> temp, int n) {
        if(temp.size() == n) {
            result.add(new ArrayList<>(temp));
        }
        
        
        for(int ele : map.keySet()) {
            int count = map.get(ele);
            
            if(count > 0) {
                temp.add(ele);
                map.put(ele,count - 1);
                permute(map,result,temp,n);
                map.put(ele,count);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
