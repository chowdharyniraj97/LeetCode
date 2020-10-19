class Solution {
 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findSum(candidates,target,0,new ArrayList<>());
       
        
    }// 1 2 2 2 5
    
    List<List<Integer>>  findSum(int arr[] , int target,int cur, List<Integer> list)  {
        if(target == 0) {
            List<List<Integer>> lst = new ArrayList<>();
            List<Integer> t = new ArrayList<>();
            lst.add(t);
            
            return lst;
            
        }
        
        if(cur == arr.length) {
            return null;
        }
        
        if(target < 0) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        // HashSet<Integer> set = new HashSet<>();
       for(int i = cur ; i < arr.length ; i++) {
           if(i>cur && arr[i-1] == arr[i])
               continue;
           // if(set.contains(arr[i]))
           //     continue;
           List<List<Integer>> temp = findSum(arr,target-arr[i],i+1,list);
           if(temp == null)
               continue;
           
          // set.add(arr[i]);
               
               for(List<Integer> x  : temp) {
               
              List<Integer> z = new ArrayList<>(x);
               z.add(arr[i]);
               res.add(z);
           
           }
           
       }
        
        return res;
    }
}

/*

integer we have a choice to make either select it or do not



*/
