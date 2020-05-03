class Solution {
    public int search(int[] nums, int target) {
        return findtarget(nums,0,nums.length-1,target);
    }
    
    int findtarget(int nums[],int start,int end,int target){
        
        int mid=(start+end)/2;
       if(start>end)
           return -1;
        else if(nums[mid]==target)
            return mid;
        else if(nums[start]>nums[mid])//in sorted part
        {
            if(target>nums[mid]&&target<=nums[end])
                return binSearch(nums,mid+1,end,target);//BS
            else
                return findtarget(nums,start,mid-1,target);
        }
        else{
            if(target>=nums[start]&&target<nums[mid])
                return binSearch(nums,start,mid-1,target);//BS
            else
                return findtarget(nums,mid+1,end,target);
        }
        
    }
     int binSearch(int nums[],int l,int h,int target){
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]==target)
                    return mid;
            else if(nums[mid]<target)
            {
                l=mid+1;
            }
            else
                h=mid-1;
        }
    
        return -1;
    }
}