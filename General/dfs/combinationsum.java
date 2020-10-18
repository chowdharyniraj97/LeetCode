class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        findSum(candidates,target,0,new ArrayList<>());
        return result;
        
    }
    
    void findSum(int arr[] , int target,int cur, List<Integer> list)  {
        if(cur == arr.length) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
            
        }
        
        if(target < 0) {
            return;
        }
        
       
            list.add(arr[cur]);
            findSum(arr,target-arr[cur],cur,list);
            list.remove(list.size() - 1);
            findSum(arr,target,cur+1,list);
        
    }
}

/*

integer we have a choice to make either select it or do not



*/
