class Solution {
    public int heightChecker(int[] heights) {
        int sorted[] = new int[heights.length];
        
        for(int i =0; i< sorted.length;i++) {
            sorted[i] = heights[i];
        }
        
        Arrays.sort(sorted);
        int c =0;
        
        for(int i =0; i< sorted.length; i++) {
            if(heights[i] != sorted[i]) {
                c++;
            }
        }
        
        return c;
    }
}
