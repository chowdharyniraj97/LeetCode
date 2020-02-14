//copy this to https://leetcode.com/problems/ones-and-zeroes/
class Solution {
    HashMap<String,int[]> map;
    public int findMaxForm(String[] strs, int m, int n) {
        map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            int arr[]=new int[2];
            for(char c: strs[i].toCharArray()){
                if(c=='0')
                    arr[0]++;
                else
                    arr[1]++;
            }
            map.put(strs[i],arr);
        }
        int x=-1;
        int i=0;
        while(i!=strs.length){
             x=Math.max(x,findmax(strs,m,n,i++));
        }
        return x+1;
        
        
        
    }
    
    int findmax(String strs[],int m,int n,int index){
       // System.out.print(strs[index]+" "+m+" "+n+" ");
        int x=0;
        if(index==strs.length)
            return 0;
        String cur=strs[index];
        int a[]=map.get(cur);
      //  System.out.println(a[0]+" "+a[1]);
        if(a[0]>m || a[1]>n)
            return -1;//not valid
        
       for(int i=index+1;i<strs.length;i++){
            x=Math.max(x,1+findmax(strs,m-a[0],n-a[1],i));
           //System.out.println(cur+" "+ x);
            
           
       }
         return x;
    }
}

//-------------------------------------------------------------------memoization---------------------------------------------------
class Solution {
    HashMap<String,int[]> map;
    HashMap<String,Integer> dict;
    public int findMaxForm(String[] strs, int m, int n) {
        map=new HashMap<>();
        dict=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int arr[]=new int[2];
            for(char c: strs[i].toCharArray()){
                if(c=='0')
                    arr[0]++;
                else
                    arr[1]++;
            }
            map.put(strs[i],arr);
        }
        int x=-1;
        int i=0;
        while(i!=strs.length){
             x=Math.max(x,findmax(strs,m,n,i++));
        }
        return x+1;
        
        
        
    }
    
    int findmax(String strs[],int m,int n,int index){
       // System.out.print(strs[index]+" "+m+" "+n+" ");
       
        int x=0;
        if(index==strs.length)
            return 0;
        
        String cur=strs[index];
         if(dict.containsKey(index+" "+m+" "+n))
            return dict.get(index+" "+m+" "+n);
        int a[]=map.get(cur);
      //  System.out.println(a[0]+" "+a[1]);
        if(a[0]>m || a[1]>n)
            return -1;//not valid
        
       for(int i=index+1;i<strs.length;i++){
            x=Math.max(x,1+findmax(strs,m-a[0],n-a[1],i));
           //System.out.println(cur+" "+ x);
            
           
       }
        dict.put(index+" "+m+" "+n,x);
                       return x;
    }
}

//--------------------------------------DP------==========================-----------=============-==========
class Solution {
public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0 || (m == 0 && n == 0)) return 0;
        int dp [][][] = new int[strs.length][m+1][n+1];
        int [][] pairs = new int[strs.length][2];
        for(int i = 0;i<strs.length;i++){
            for(int j = 0;j<strs[i].length();j++){
                char ch  = strs[i].charAt(j);
                if(ch == '0') pairs[i][0]++;
                else pairs[i][1]++;
            }
        }
        for(int zeros =  pairs[0][0];zeros<=m;zeros++){
               for(int ones = pairs[0][1];ones<=n;ones++){
                   dp[0][zeros][ones] = 1;
               }
        } 
        for(int i  = 1;i<strs.length;i++){
           for(int zeros =  0;zeros<=m;zeros++){
               for(int ones = 0;ones<=n;ones++){
                   dp[i][zeros][ones] = dp[i-1][zeros][ones];
               }
           }
           for(int zeros =  pairs[i][0];zeros<=m;zeros++){
               for(int ones = pairs[i][1];ones<=n;ones++){
                   dp[i][zeros][ones] = Math.max(dp[i-1][zeros][ones], 1+dp[i-1][zeros-pairs[i][0]][ones-pairs[i][1]]);
               }
           }
        }
        return dp[strs.length-1][m][n];
    }
}
   
S