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