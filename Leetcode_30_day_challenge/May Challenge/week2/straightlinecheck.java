
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==1)
            return false;
        int size=coordinates.length-1;
        int x=(coordinates[size][0]-coordinates[0][0]);
        int y=(coordinates[size][1]-coordinates[0][1]);
        double m=0;
        if(x!=0)
         m=y/x;
        else
            m=Integer.MAX_VALUE;
            
            double tempm=0;
            for(int i=0;i<size;i++){
                 x=(coordinates[i+1][0]-coordinates[i][0]);
                 y=(coordinates[i+1][1]-coordinates[i][1]);
                
                if(x==0)
                    tempm=Integer.MAX_VALUE;
                else
                    tempm=y/x;
                if(tempm!=m)
                    return false;
                
                    
            }
        return true;
    }
    

}
