    import java.util.*;
    class Solution{
    HashMap<String,int[]> map;



    public static void main(String args[]){
        String str[]={"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
        int m=90;
        int n=66;
        Solution obj=new Solution ();
        System.out.println(obj.findMaxForm(str,m,n));
    }
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
