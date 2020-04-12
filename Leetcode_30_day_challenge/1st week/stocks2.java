//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {
    public int maxProfit(int[] prices) {
        int maxsum=0;
        int localsum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0)
                maxsum+=prices[i]-prices[i-1];
        }
        return maxsum;
    }
}