//https://leetcode.com/problems/triangle/

//------------------------recursive-------------------------------------------------------
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int rows=triangle.size();
        if(rows<=1)
            return rows==1?triangle.get(0).get(0):0;
        int a=triangle.get(0).get(0) + findoptimal(triangle,triangle.get(1),1,rows-1,0);
        int b=triangle.get(0).get(0) + findoptimal(triangle,triangle.get(1),1,rows-1,1);
        return Math.min(a,b);
        
        
        
    }
    
    int findoptimal(List<List<Integer>> triangle,List<Integer> list,int level,int maxlevel,int ind){
        if (level==maxlevel)
        {
            
            return list.get(ind);
        }
        
        int a=list.get(ind)+findoptimal(triangle,triangle.get(level+1),level+1,maxlevel,ind);
        if(ind+1<triangle.get(level+1).size())
           return Math.min(a,list.get(ind)+findoptimal(triangle,triangle.get(level+1),level+1,maxlevel,ind+1));
        return a;
            
    }
}


//-=======================================================Memoization==============================================================
class Solution {
    HashMap<String,Integer> map;
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int rows=triangle.size();
        if(rows<=1)
            return rows==1?triangle.get(0).get(0):0;
        map=new HashMap<>();
        int a=triangle.get(0).get(0) + findoptimal(triangle,triangle.get(1),1,rows-1,0);
        int b=triangle.get(0).get(0) + findoptimal(triangle,triangle.get(1),1,rows-1,1);
        return Math.min(a,b);
        
        
        
    }
    
    int findoptimal(List<List<Integer>> triangle,List<Integer> list,int level,int maxlevel,int ind){
        
        if (level==maxlevel)
        {
            
            return list.get(ind);
        }
        if(map.containsKey(level+"|"+ind))
            return map.get(level+"|"+ind);
        
        int a=list.get(ind)+findoptimal(triangle,triangle.get(level+1),level+1,maxlevel,ind);
        if(ind+1<triangle.get(level+1).size())
        {
             int x= Math.min(a,list.get(ind)+findoptimal(triangle,triangle.get(level+1),level+1,maxlevel,ind+1));
            map.put(level+"|"+ind,x);
            return x;
        }
        map.put(level+"|"+ind,a);
        return a;
            
    }
}

//===========================================================DP===========================================================
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1;i<triangle.size();i++) { 
            List<Integer> current=triangle.get(i);
            List<Integer> prev=triangle.get(i-1);
            int j=0;
           for(int ele : current){
              
              if(j==0)
                  current.set(j,ele+prev.get(j));
              else if(j==current.size()-1)
                  current.set(j,ele+prev.get(j-1));
               else{
                   int x=Math.min(prev.get(j-1),prev.get(j));
                   current.set(j,ele+x);
                   
            }
               j++;
          }
        }
        
        List<Integer>last=triangle.get(triangle.size()-1);
        int min=Integer.MAX_VALUE;
        for(int i: last){
            min=Math.min(min,i);
        }
        return min;
        
    }
}
