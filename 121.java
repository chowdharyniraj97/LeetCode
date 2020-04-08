//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int diff[]=new int[prices.length-1];
        
        for(int i=1;i<prices.length;i++){
            diff[i-1]=prices[i]-prices[i-1];
        }
        
        return findmax(diff,diff.length);
    }
    
    int findmax(int diff[],int n){
        int maxsum=0;
        int localsum=0;
        
        for(int i=0;i<diff.length;i++){
            localsum+=diff[i];
            maxsum=Math.max(maxsum,localsum);
            
            if(localsum<0)
                localsum=0;
        }
        return maxsum;
    }
}