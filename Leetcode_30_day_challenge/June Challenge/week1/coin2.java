class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int [coins.length+1][amount+1];
        dp[0][0]=1;
        
        for(int i=1;i<=coins.length;i++){
            dp[i][0]=1;
        }
        
         for(int i=1;i<=amount;i++){
            dp[0][i]=0;
        }
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j]=j-coins[i-1]>=0?dp[i-1][j]+dp[i][j-coins[i-1]] : dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }
}
