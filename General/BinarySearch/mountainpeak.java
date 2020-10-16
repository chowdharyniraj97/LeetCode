class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                return mid;
            }
            
            else if(arr[mid] > arr[mid+1]) {
                high = mid - 1;
                
            }
            else{
                low = mid + 1;
            }
            
            
            
        }
        return low;
    }
}


/*

i i i d d d d

traverse from back and point where it drops is the mountain point
BS

*/
