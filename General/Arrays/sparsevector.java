
class SparseVector {
    int nums[];
    int len = 0;
    SparseVector(int[] nums) {
       this.nums = nums;
        len = nums.length;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int i = 0,j=0 ; i < vec.len; i++,j++ ) {
            sum+= this.nums[i] * vec.nums[j];
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

/*

    
    5.



*/
