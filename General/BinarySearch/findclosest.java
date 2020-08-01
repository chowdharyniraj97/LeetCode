class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-k;
        
        while(low<high){
            int mid=low + (high-low)/2;
            
            if(Math.abs(x-arr[mid])>Math.abs(arr[mid+k]-x))
                low=mid+1;
            else if(Math.abs(x-arr[mid])<Math.abs(arr[mid+k]-x))
                high=mid;
            else{
                if(x > arr[mid]&& x > arr[mid+k])
                    low=mid+1;
                else
                    high=mid;
               
            }
        }
        
       List<Integer> ans=new ArrayList<>();
        
        for(int  i = 0; i < k ;i++){
            ans.add(arr[low++]);
        }
        
        return ans;
    }
}
