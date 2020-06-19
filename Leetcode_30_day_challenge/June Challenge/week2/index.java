class Solution {
    public int searchInsert(int[] nums, int target) {
        return binSearch(nums,target,0,nums.length-1);
    }
    
    int binSearch(int arr[],int t,int low,int high){
        while(low<=high){
            if(low==high){
                if(arr[low]==t)
                    return low;
                
                break;
                
            }
            
            int mid =low+(high-low)/2;
           
            if(arr[mid]==t)
                return mid;
            
            else if(t<arr[mid])
                high=mid-1;
            else 
                low=mid+1;
        }
        return arr[low]<t? low+1 :low;
    }
}
