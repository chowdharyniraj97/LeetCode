//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
class Solution {
    HashMap<Integer,Integer> s;
    HashMap<Integer,Integer> ns;
    public int minSwap(int[] A, int[] B) {
        s=new HashMap<>();
        ns=new HashMap<>();
        swap(A,B,0);
        int swapped=dfs(A,B,1,true)+1;
        swap(A,B,0);
        int noswap=dfs(A,B,1,false);
        return Math.min(swapped,noswap);
    }
    
    int dfs(int a[],int b[],int index,boolean sp){
        if(index==a.length)
            return 0;
        int swap=Integer.MAX_VALUE;
        int noswap=Integer.MAX_VALUE;
        if(sp)
        {
            if(s.containsKey(index))
                return s.get(index);
        }
        else{
             if(ns.containsKey(index))
                return ns.get(index);
         }
        if(a[index-1]<b[index]&&b[index-1]<a[index]){
            swap(a,b,index);
            swap=1+dfs(a,b,index+1,true);
            swap(a,b,index);
        }
    if(a[index-1]<a[index] && b[index-1]<b[index])
            noswap=dfs(a,b,index+1,false);
        int ans=Math.min(swap,noswap);
        if(sp){
            s.put(index,ans);
        }
        else
            ns.put(index,ans);
            

        
       
    return ans;
    }
    
    
    
    void swap(int a[],int b[],int i){
        int temp=a[i];
        a[i]=b[i];
        b[i]=temp;
    }
}