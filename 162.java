//Find peak of an array in logn

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        
        if(nums[1]<nums[0])
            return 0;
        
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        
        int i=1;
        int len=nums.length-2;
        while(i<=len){
            if(len==i)
                return i;
            int mid=i+ (len-i)/2;
            
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                return mid;
            if(nums[mid+1]>nums[mid])
                i=mid+1;
            else
                len=mid-1;
        }
        return -1;
    }
}