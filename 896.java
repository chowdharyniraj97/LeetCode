//Copy this code to leetcode problem 896
//https://leetcode.com/problems/monotonic-array/

//Below is the divide and conquer solution but it does not pass test case for very large input as TLE occurs
class Solution {
    public boolean isMonotonic(int[] A) {
        
        if(A[0]<=A[A.length-1])
            return isIncreasingMonotone(A,0,A.length-1);
        else 
            return isDecreasingMonotone(A,0,A.length-1);
    }
    
    public boolean isIncreasingMonotone(int A[],int l,int h){
         boolean first=false,second=false;
        if(l==h)
            return true;
        if(l==h-1)
            return A[l]<=A[h];
        
        int mid=l+(h-l)/2;
         first=isIncreasingMonotone(A,0,mid);
        if(first)
         second=isIncreasingMonotone(A,mid+1,h);
        
        if(first&&second&&A[mid]<=A[mid+1])
            return true;
        return false;
    }
    
    public boolean isDecreasingMonotone(int A[],int l,int h){
         boolean first=false,second=false;
        if(l==h-1)
            return A[l]>=A[h];
        
        int mid=l+(h-l)/2;
        first=isDecreasingMonotone(A,0,mid);
        if(first)
         second=isDecreasingMonotone(A,mid+1,h);
        
        if(first&&second&&A[mid]>=A[mid+1])
            return true;
        return false;
    }
}



