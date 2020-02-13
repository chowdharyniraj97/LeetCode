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