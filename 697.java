//https://leetcode.com/problems/degree-of-an-array/
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i:nums){
            if(map.containsKey(i)){
                int c=map.get(i)+1;
                map.put(i,c);
            }
            else
                map.put(i,1);
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        int max=-1;
        for(int keys : map.keySet()){
            int freq=map.get(keys);
            if(freq>max)
                max=freq;
        }
        
        for(int keys:map.keySet()){
            int freq=map.get(keys);
            if(freq==max)
                list.add(keys);
        }
        
        int first;
        int last;
        int ans=nums.length+2;
        for(int ele: list){
            first=findfirst(nums,ele);
             last=findlast(nums,ele);
            ans=Math.min(ans,last-first+1);
          }
        return ans;
    
        
    }
    
    int findfirst(int nums[],int ele){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele)
                return i;
        }
        return -1;
    }
    int findlast(int nums[],int ele){
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==ele)
                return i;
        }
        return -1;
    }
}
