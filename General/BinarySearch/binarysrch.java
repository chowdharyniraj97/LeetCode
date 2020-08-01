/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
       if(reader.get(0)==target)
           return 0;
        //[-1,0,3,5,9,12], // 9
        int low=0;
        int high=1;
        
        while(true){
            int val=reader.get(high);
            if(val != 2147483647){
                if(val==target){
                    return high;
                }
                
                else if(val>target){
                    break;
                }
                
                low=high;
                high= high*2;
            }
            else 
                break;
        }
        
        
            while(low<=high){
                int mid=low + (high-low)/2;
                
                if(reader.get(mid)==target)
                    return mid;
                else if(reader.get(mid)>target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            return -1;
        
        
        
    }
}


/*
We begin with index 0 -- > 1
1. always check if it is our target -- >return
2 . simply compare if it is greater than we multiply index by 2
else
we found out the range and we Bs
*/
