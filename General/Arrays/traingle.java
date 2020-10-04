class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int i = 0 ;
        int limit = nums.length - 3;
        int count = 0;
        for(int cur = i; cur <=limit; cur++) {
            int first = nums[cur];
            int  k = nums.length-1;
            while(k != cur) {
                int second = nums[k];
                int sum = first+second;
                for(int z = k+1 ; z<nums.length;z++) {
                   if(nums[z] < sum) {
                       count++;
                   } 
                    else{
                        break;
                    }
                }
                k--;
            }
        }
        return count;
    }
}



/*
cubic soln 3 loops and check all of them
awesine 
sort the array

*/
