/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//https://leetcode.com/problems/find-the-celebrity/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int i=0;
        int j=0;
        int currow=0;
        while(i<n && j <n){
            if(i==j)
            {
                j++;
                continue;
            }
            if(!knows(i,j))
                j++;
            else{
                i++;
                }
        }
       if(i==n)
           return -1;
        for(int k=0;k<n;k++){
           if(i!=k&&knows(i,k))
               return -1;
            
        }
        for(int k=0;k<n;k++){
            if(!knows(k,i))
                return -1;
        }
        return i;
        
        
    }
}