

class Solution {
    int max;
     HashMap<String,int[]> map;
    public int findMaxForm(String[] strs, int m, int n) {
      map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            int arr[]=new int[2];
            for(char c: strs[i].toCharArray()){
                if(c=='1')
                    arr[0]++;
                else
                    arr[1]++;
            }
            map.put(strs[i],arr);
        }
        
        int a=findmax(strs,m,n,0);
        return a+1;
    }
    
    int findmax(String strs[],int m,int n,int index){
        int ans=0;
       if(m==0 && n==0)
           return 0;
        
        if(m<=0 && n<=0)
            return 0;
        if(index==strs.length)
            return 0;
            
        String cur=strs[index];
        for(int i=index;i<strs.length;i++){
            int arr[]=map.get(cur);
            if(m>=arr[0] && n>=arr[1])
            ans=Math.max(ans,1+findmax(strs,m-arr[0],n-arr[1],index+1));
        }
        
           // max=Math.max(ans,max);
            return ans;
        
    }
}