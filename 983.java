//983. Minimum Cost For Tickets
//copy this code to the leetcode problem number 983


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