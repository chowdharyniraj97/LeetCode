class Solution {
    public int[] findBuildings(int[] heights) {
        // Stack<Integer> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int lastIndex = heights.length - 1;
        result.add(lastIndex);
        for(int i = lastIndex - 1; i>=0; i--) {
            
            if( heights[lastIndex] < heights[i] ) {
                // st.pop();
                result.add(i);
                lastIndex = i;
            }
        }
        
        int ans[] = new int[result.size()];
        int index = result.size() - 1;
        for(int x : result) {
            ans[index--] = x;
        }
        
        return ans;
    }
}
