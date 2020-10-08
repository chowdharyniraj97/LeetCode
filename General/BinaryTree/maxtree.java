class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums, 0, nums.length-1);   
    }
    
    public TreeNode createTree(int []nums,int start,int end) {
        if(start > end)
            return null;
        int max_ind = findmax(nums, start, end);
        TreeNode root = new TreeNode(nums[max_ind]);
        root.left = createTree(nums,start,max_ind-1);
        root.right  = createTree(nums,max_ind+1,end);
        return root;
    }

    
    public int findmax(int nums[], int start, int end) {
        int max = nums[start], maxIndex=start;
        for(int i=start; i<=end; i++) {
            if(max<nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            
            

                  }
        return maxIndex;

}
}
