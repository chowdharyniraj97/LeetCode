//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int dp[][]=new int[arr.length][arr.length];
        int len=0;
        for(len=1;len<=arr.length;len++){
           // System.out.println(len);
            for(int i=arr.length-1;i>=0 ;i--){
                int j=i+len;
                if(j>=arr.length)
                    continue;
               // System.out.println(i+" "+j);
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int ans=findmax(arr,i,k)*findmax(arr,k+1,j)+dp[i][k]+dp[k+1][j];

                    dp[i][j]=Math.min(dp[i][j],ans);
                    
                }
                
            }
        }
        
        return dp[0][arr.length-1];
    
    
    }
    
     int findmax(int arr[],int s,int end){
        int max=arr[s];
        
        for(int i=s;i<=end;i++)
            max=Math.max(max,arr[i]);
        return max;
    }
}