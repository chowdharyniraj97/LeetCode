//https://leetcode.com/problems/dungeon-game/
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
       return dfs(dungeon,0,0, dungeon.length,dungeon[0].length);
        
    }
    
    int dfs(int dungeon[][],int r,int c,int n,int m){
        if(r==n || c==m)
            return Integer.MAX_VALUE;
        if(r==n-1 && c==m-1){
            if(dungeon[r][c]>0)
                return 1;
            else
                return -1*dungeon[r][c]+1;
        }
        int a=dfs(dungeon,r+1,c,n,m);
        int b=dfs(dungeon,r,c+1,n,m);
        if(a!=Integer.MAX_VALUE && b!=Integer.MAX_VALUE){
            int cc=1;
         if(dungeon[r][c]>=a)
            cc=1;
         else
          cc=-1*dungeon[r][c]+a;
          int d=-1*dungeon[r][c]+b;
        
        if(dungeon[r][c]>=b)
            d=1;
        return Math.min(cc,d);
        }
        else if(a==Integer.MAX_VALUE)
        {
            int d=-1*dungeon[r][c]+b;
        
          if(dungeon[r][c]>=b)
            d=1;
            return d;
        }
        else{
               int cc=1;
         if(dungeon[r][c]>=a)
            cc=1;
         else
          cc=-1*dungeon[r][c]+a;
            return cc;
        }
       
        
    }
    
}

//-------------------------------------------------------------------MeMOization-------------------------------------
class Solution {
    HashMap<Integer,Integer>map;
    public int calculateMinimumHP(int[][] dungeon) {
        map=new HashMap<>();
       return dfs(dungeon,0,0, dungeon.length,dungeon[0].length);
        
    }
    
    int dfs(int dungeon[][],int r,int c,int n,int m){
        if(r==n || c==m)
            return Integer.MAX_VALUE;
        if(map.containsKey(r*m+c))
            return map.get(r*m+c);
        if(r==n-1 && c==m-1){
            if(dungeon[r][c]>0)
                return 1;
            else
                return -1*dungeon[r][c]+1;
        }
        int a=dfs(dungeon,r+1,c,n,m);
        int b=dfs(dungeon,r,c+1,n,m);
        if(a!=Integer.MAX_VALUE && b!=Integer.MAX_VALUE){
            int cc=1;
         if(dungeon[r][c]>=a)
            cc=1;
         else
          cc=-1*dungeon[r][c]+a;
          int d=-1*dungeon[r][c]+b;
        
        if(dungeon[r][c]>=b)
            d=1;
        int ans= Math.min(cc,d);
            map.put(r*m+c,ans);
            return ans;
        }
        else if(a==Integer.MAX_VALUE)
        {
            int d=-1*dungeon[r][c]+b;
        
          if(dungeon[r][c]>=b)
            d=1;
            map.put(r*m+c,d);
            return d;
        }
        else{
            int cc=1;
         if(dungeon[r][c]>=a)
            cc=1;
         else
          cc=-1*dungeon[r][c]+a;
            map.put(r*m+c,cc);
            return cc;
        }
       
        
    }
    
}

//-----------------------------------------------------------------------------------