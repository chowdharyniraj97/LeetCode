//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
class Solution {
    HashMap<String,Integer> map;
    int globalmax=Integer.MAX_VALUE;
    public int mctFromLeafValues(int[] arr) {
        map=new HashMap<>();
         return buildtree(arr,0,arr.length-1);
        
        // return globalmax;
    }
    
    
    int buildtree(int []arr, int index,int len ){
        if(index==len)
            return 0;
        if(len-index+1==2)
            return arr[index]*arr[index+1];
        if(map.containsKey(index+" "+len))
            return map.get(index+" "+len);
        int max=Integer.MAX_VALUE;
        
        for(int i=index;i<len;i++){
            int localmax=0;
            int lefthalf=buildtree(arr,index,i);
            int righthalf=buildtree(arr,i+1,len);
            int leftmax=findmax(arr,index,i);
            int rightmax=findmax(arr,i+1,len);
           localmax=lefthalf+righthalf;
            
            localmax+=leftmax*rightmax;
            max=Math.min(localmax,max);
                
        }
       // System.out.println(max + " "+index+" "+len);
        map.put(index+" "+len,max);
        return max;
        
 }
    
    int findmax(int arr[],int s,int end){
        int max=arr[s];
        
        for(int i=s;i<=end;i++)
            max=Math.max(max,arr[i]);
        return max;
    }
}