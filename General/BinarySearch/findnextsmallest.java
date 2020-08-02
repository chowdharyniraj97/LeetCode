class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high  = letters.length-1;
        
        while(low <high){
            int mid = low + (high-low)/2;
            
            if(letters[mid]==target && letters[(mid+1)%(letters.length)]!=letters[mid]){
                low= mid;
                break;
            }
            else if(letters[mid]>target)
                high=mid-1;
            else
                low = mid+1;
                
        }
        int ans=0;
        if ( letters[low]==target || target > letters[low] ){
             ans = (low+1) % letters.length;
            return letters[ans];
        }
           return letters[low];
    }
}


/*
find the element
and return index+1 % size

*/
