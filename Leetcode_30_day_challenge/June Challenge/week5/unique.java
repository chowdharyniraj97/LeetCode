class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[]=new int [n];
        int left=1;
        for(int i=0;i<m;i++){
            left=i==0?1:0;
            for(int j=0;j<n;j++){
                dp[j]=left+dp[j];
                left=dp[j];
                }
        }
        
        return dp[n-1];
    }
}
