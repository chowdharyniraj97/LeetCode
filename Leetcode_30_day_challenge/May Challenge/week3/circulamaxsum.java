
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int totalSum = 0, curSum1 = 0, curSum2 = 0;
        for (int a : A) {
            totalSum += a;
            curSum1 += a;
            maxSum = Math.max(curSum1, maxSum);
            if (curSum1 < 0) curSum1 = 0;
            curSum2 += a;
            minSum = Math.min(curSum2, minSum);
            if (curSum2 > 0) curSum2 = 0;
        }
        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}
