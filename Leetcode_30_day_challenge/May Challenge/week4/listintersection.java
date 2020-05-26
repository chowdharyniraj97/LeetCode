
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0, k = 0;
        List<int[]> result = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (B[j][0] > A[i][1]) {
                i ++; // Go to the next interval in A
            } else if (A[i][0] > B[j][1]) {
                j ++; // Go to the next interval in B
            } else {
                int a = Math.max(A[i][0], B[j][0]);
                int b = Math.min(A[i][1], B[j][1]);
                result.add(new int[]{a, b});
                if (A[i][1] < B[j][1]) i ++;
                else j++;
            }
        }
        int[][] ans = new int[result.size()][];
        for (int[] t : result) {
            ans[k++] = t;
        }
        return ans;
    }
} 

