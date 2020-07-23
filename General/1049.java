//copy this to https://leetcode.com/problems/last-stone-weight-ii/
// as good as partition into two groups such that their difference in sum is minimum

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones)
            sum+=stone;
        return findmin(stones,0,sum,0);
    }
    
    
    
     int findmin(int arr[],int s1,int s2,int i){
        if(i==arr.length)
            return Math.abs(s1-s2);
            
       int sum1=findmin(arr,s1+arr[i],s2-arr[i],i+1);
       int sum2=findmin(arr,s1,s2,i+1);
       return Math.min(sum1,sum2);
    }
}

//-------------------------------------------dp------------------------------dp----------------------------------------------

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int S = 0, S2 = 0;
        for (int s : stones) S += s;
        int n = stones.length;
        boolean[][] dp = new boolean[S + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= S / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    dp[s][i] = true;
                    S2 = Math.max(S2, s);
                }
            }
        }
        return S - 2 * S2;
    }
}
