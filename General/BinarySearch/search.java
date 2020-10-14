class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length-1;
        int end = matrix[0].length-1;
        boolean ans = false;
        
        for(int i =0 ; i  <=high ; i++) {
            if(matrix[i].length == 0)
                continue;
            int l = matrix[i][0];
            int h = matrix[i][end];
            if(target >=l && target <= h) {
                if(binarySearch(matrix[i],0,end,target)){
                    return true;
                }
            }
            
        }
       return false;
    }
    
    
    
    
    
    boolean binarySearch(int arr[], int low, int high,int target) {
        while(low  <= high) {
            int mid = low + (high - low) /2;
            
            if(arr[mid] == target)
                return true;
            
            else if(arr[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid  + 1;
            }
        }
        
        return false;
    }
}


/*

perfomr BS on 1sr col
thr row we get over we perform another BS

if the first ele is greater than target ignore  go up half

if the ele is lesser than or equal to target check its end and see if i contains if yes then perfom BSand if found true  other wise perform BS more


*/
