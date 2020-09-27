class Solution {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length-1;
        
        while(low<height.length-1 && height[low]<=height[low+1]) {
            low++;
        }
        
        while(high>=1 && height[high]<=height[high-1]) {
            high--;
        }
        
        int sum = 0;
        
        while(low<high) {
            if(height[low]<height[high]) {
               int cur = low+1;
                while(cur<high && height[cur]<height[low]) {
                   
                    sum+=height[low]-height[cur];
                    cur++;
                }
                low = cur;
            }
            
            
            else {
                int cur = high-1;
                
                while(cur>low && height[cur]<height[high]) {
                   
                    sum+=height[high] - height[cur];
                     cur--;
                }
                high = cur;
            }
        }
        
        return sum;
    }
}
