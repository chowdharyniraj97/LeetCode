//983. Minimum Cost For Tickets
//copy any of the code to the leetcode problem number 983
//https://leetcode.com/problems/minimum-cost-for-tickets/
//two version one is recursion other is dynamic programming

class Solution {
    int global=Integer.MAX_VALUE;
    Map<Integer,Integer>map;
    public int mincostTickets(int[] days, int[] costs) {
        map=new HashMap<>();
        return dfs(days,costs,days[0],days[days.length-1]);
   }
    
    
    int findnear(int [] days,int target){// fucntion to find the nearest day to our target in the days array        int val=-1;
        int val=-1;
        for(int i=0;i<days.length;i++){
            
            if(days[i]>=target)
                return i;
            
        }
        return val;
    }
    
    int dfs(int days[],int coins[],int start,int end){
        int index=findnear(days,start);
        if(index==-1)
            start=end+1;
        else
            start=days[index];
        
        if(map.containsKey(index)){
           return map.get(index);
        }
        
         if(start>end)
        {
            return 0;
        } 
        
        int a=coins[0]+dfs(days,coins,start+1,end);//adding day 1
        int b=coins[1]+dfs(days,coins,start+7,end);//adding day 7
        int c=coins[2]+ dfs(days,coins,start+30,end);// adding day 8
        int ans=Math.min(a,Math.min(b,c));
        map.put(index,ans);
        return ans;
            
    }
}


// DP VERSION Better than above recursion

//------------------------------------------------------------------------------

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int travelday[]=new int[366];
        
        
        for(int d: days)// to know which dates person travel
            travelday[d]=1;
        
        int dp[]=new int[days[days.length-1]+1];
        
        dp[days[days.length-1]]=costs[0];
        
        for(int i=dp.length-2;i>=1;i--){
            boolean day_7=false;
            boolean day_30=false;

            if(travelday[i]==1){
                
                    int a=costs[0]+dp[i+1];
                    int b=i+7<=dp.length-1?costs[1]+dp[i+7]:costs[1];
                    int c=i+30<=dp.length-1? costs[2]+dp[i+30]: costs[2];
                    dp[i]=Math.min(a,Math.min(b,c));
            }
                
            else{
                 for(int j=i;j<i+7;j++)
                   if(j<366 && travelday[j]==1)
                       day_7=true;
                
                  for(int j=i;j<i+30;j++)
                      if(j<366 && travelday[j]==1)
                          day_30=true;
                
                
                int a=dp[i+1];
                int b=Integer.MAX_VALUE;
                int c=b;
                
                   if(day_7)
                   b=i+7<dp.length?costs[1]+dp[i+7]: costs[1];
                   
                        
                 if(day_30)
                     c=i+30<dp.length? costs[2]+dp[i+30]:costs[2];
                   
                    dp[i]=Math.min(a,Math.min(b,c));
            }
            
        }
        return dp[1];
    }
}

//-------------------------------------------------------------------------------------------

//Variation of dp but much faster than the previous one

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
            int travelday[]=new int[366];
        
        for(int d: days)
            travelday[d]++;
        int last=days[days.length-1];
        int dp[]=new int[last+1];
        int bestcostsofar=0;
        
        for(int i=dp.length-1;i>=days[0];i--){
            if(travelday[i]==1){
                int a=i+1<dp.length?costs[0]+dp[i+1]: costs[0];
                int b= i+7<dp.length?costs[1]+dp[i+7] : costs[1];
                int c= i+30<dp.length? costs[2]+dp[i+30] : costs[2];
                dp[i]=Math.min(a,Math.min(b,c));
                bestcostsofar=dp[i];
            }
            
            else{
                dp[i]=bestcostsofar;
            }
        }
        return dp[days[0]];
        
        
    }
}
//----------------------------------------------------