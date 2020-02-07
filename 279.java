//Finding the minimum number of perfect square that sums to 'n'
//copy this code to https://leetcode.com/problems/perfect-squares/

/* A Naive dfs soltion to the given problem*/
class Solution {
    HashMap<Integer,Integer> m;
    public int numSquares(int n) {
        m=new HashMap<>();
        int nearestroot=(int)Math.sqrt(n);
        
        int child[]=new int[nearestroot+1];
        for(int i=1;i<=nearestroot;i++)
            child[i]=i;
        // for(int i=1;i<=nearestroot;i++)
        //     System.out.print(child[i]+" ");
        
        
        return findnearest(n,child);
    
        
    }
    int findnearest(int n,int child[]){
        int steps=Integer.MAX_VALUE;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(m.containsKey(n))
            return m.get(n);
        for(int i=child.length-1;i>=1;i--){
            if(i*i>n)
                continue;
            int x= findnearest(n-i*i,child);
                if(x!=Integer.MAX_VALUE)
                    steps=Math.min(steps,1+x);
           
        
        }
        m.put(n,steps);
        return steps;
        
    }
}

//----------------------------DP solution-------------------------------
class Solution {

  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    // bottom case
    dp[0] = 0;

    // pre-calculate the square numbers.
    int max_square_index = (int) Math.sqrt(n) + 1;
    int square_nums[] = new int[max_square_index];
    for (int i = 1; i < max_square_index; ++i) {
      square_nums[i] = i * i;
    }

    for (int i = 1; i <= n; ++i) {
      for (int s = 1; s < max_square_index; ++s) {
        if (i < square_nums[s])
          break;
        dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
      }
    }
    return dp[n];
  }
}
//----------------------------------------------------------