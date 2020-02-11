//https://leetcode.com/problems/triangle/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int rows=triangle.size();
        if(rows<=1)
            return rows==1?triangle.get(0).get(0):0;
        return triangle.get(0).get(0) + findoptimal(triangle,triangle.get(1),1,rows-1);
        
        
        
    }
    
    int findoptimal(List<List<Integer>> triangle,List<Integer> list,int level,int maxlevel){
        if (level==maxlevel)
        {
            int min=Integer.MAX_VALUE;
            for(int i : list)
                min=Math.min(min,i);
            return min;
        }
        
        int m=Integer.MAX_VALUE;
        for(int i : list){
            m=Math.min(m,i+findoptimal(triangle,triangle.get(level+1),level+1,maxlevel));
            System.out.println(m);
        }
        return m;
            
    }
}