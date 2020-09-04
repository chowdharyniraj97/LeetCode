class Solution {
    List<List<Integer>> ans;
    HashSet<Integer> set;
    List<Integer> list;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        set=new HashSet<>();
        list=new ArrayList<>();
//         ArrayList<Integer> numbers = new ArrayList<>();
//         for(int num : nums){
//             numbers.add(num);
//         }
        
        permutation(nums,0,nums.length);
        return ans;
    }
    
    void permutation(int nums[],int curpos,int n){
       if(curpos == n){
           List<Integer> temp = new ArrayList<>();
           temp.addAll(list);
           ans.add(temp);
           return;
       }
        
        
        
        for(int i=0;i<n;i++){
            int x = nums[i];
            if(!set.contains(i)){
                set.add(i);
                list.add(x);
                permutation(nums,curpos+1,n);
                set.remove(i);
                list.remove(list.size()-1);
            }
        }
            
        
    }
}
/*
1. traverse all numbers in bag
2. put each at that pos and move ahead
3. 

*/
