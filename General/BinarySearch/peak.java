class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        /*
        [1,2,3,1]
                        
        */
       
        int low=0;
        int high=nums.length-1;
        
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(mid==0 || mid ==nums.length-1){
                if(mid==0 && nums[mid+1]>nums[mid]){
                    low=mid+1;
                    
                }
                
                else if(mid==nums.length-1 && nums[mid-1]>nums[mid]){
                    high=mid-1;
                
                }
                else
                    return mid;
                
                    
            }
            else
            {
                if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                    return mid;
                }
                
                else if(nums[mid+1]>nums[mid]){
                    low=mid+1;
                }
                
                else{
                    high=mid-1;
                }
            }
            
        }
        return low;
    }
}

/*

1.find the middle
2. compare middle with it left and right
if greater than both
    return peak;
else
    right is bigger go right
else
    left is bigger go left
*/


/*

intially peak=arr[0]

for 1 to n
    if arr[i-1]<arr[i]
        peak=arr[i];
    else
        return pea;


*/
