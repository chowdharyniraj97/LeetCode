class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;
        for(int i = 0;i < heights.length; i++) {
            while(st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                int curheight = heights[st.pop()];
                int left = st.peek();
                int right = i;
                maxArea = Math.max(maxArea, (i - left - 1)*curheight);
              
            } 
              st.push(i);
        }
        
        
        while(st.peek() != -1) {
            int curheight = heights[st.pop()];
            int left = st.peek();
            int right = heights.length;
              maxArea = Math.max(maxArea, (right - left - 1)*curheight);
        }
        return maxArea;
        
    }
}
