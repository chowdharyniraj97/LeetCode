
class Solution {
    public int countSquares(int[][] matrix) {
        int total=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    int len=1;
                    int refi=i;
                    int refj=j;
                    
                    
                 while(refi<matrix.length && refj<matrix[0].length&&matrix[refi][refj]==1){
                     int ui=refi;
                    int uj=refj;
                    int li=refi;
                    int lj=refj;
                    boolean sq=true;
                    for(int x=1;x<len;x++){
                        ui--;
                        if(matrix[ui][uj]!=1)
                            sq=false;
                    }
                    
                    for(int x=1;x<len;x++){
                        lj--;
                        if(matrix[li][lj]==0){
                            sq=false;
                        }
                    }
                    
                    if(sq){
                        total++;
                    
                    }
                    refi++;
                    refj++;
                    len++;
                     
                 }
            }
        }
    }
        return total;
}
}
