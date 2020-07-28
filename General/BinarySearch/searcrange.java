class Solution {
    public int[] searchRange(int[] nums, int target) {
        int right=-1;
        int left = binarySearch(nums, target,0 , nums.length-1);
        
        if(left!=-1)
            right=rbinarySearch(nums,target,left,nums.length-1);
        
        return new int[]{left,right};
            
    }
    
    
    int binarySearch(int nums[],int target,int low,int high){
        if(low>high){
            return -1;
        }
        
        int mid = low + (high - low)/2;
        
        if(nums[mid]==target){
            if(mid==0){
                return mid;
            
            }
            
             if(nums[mid-1]==target)
                return binarySearch(nums,target, low, mid-1);
            else {
                return mid;
            }
        }
        
        else if(nums[mid]>target)
            return binarySearch(nums,target,low,mid-1);
        else
            return binarySearch(nums,target,mid+1,high);
    }
    
    int rbinarySearch(int nums[],int target,int low,int high){
        
        int mid = low + (high - low)/2;
        
        if(nums[mid]==target){
            if(mid==high){
                return mid;
            
            }
            
             if(nums[mid+1]==target){
                return rbinarySearch(nums,target, mid+1, high);
            }
            else return mid;
        }
        
        else if(nums[mid]>target)
            return rbinarySearch(nums,target,low,mid-1);
        else
            return rbinarySearch(nums,target,mid+1,high);
    }
}





/*
0 find the element using bs

1. case 1 we land int the middle of series perform bs on both sides
2. left is smaller that means we found start thus go right
3 right is biggher that mean we found our end and thus go left

*/
