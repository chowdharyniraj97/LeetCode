class Solution {
    List<Integer> ans=new ArrayList<>();
    int vis[];
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return ans;
        vis=new int[matrix.length*matrix[0].length];
        int rowstart=0;
        int rowend=matrix.length;
        int colstart=0;
        int colend=matrix[0].length;
        
        int layer=(int)Math.ceil(matrix.length/2);
        for(int i=0;i<=layer;i++){
            right(matrix,rowstart,colstart,colend-1);
            down(matrix,rowstart,colend-1,rowend-1);
            left(matrix,rowend-1,colend-1,rowstart);
            up(matrix,rowend-1,colstart,rowstart);
            rowstart++;
            colstart++;
            rowend--;
            colend--;
        }
        return ans;
        
    }
    
    void left(int mat[][],int row,int col,int end){
        for(int i=col;i>=end;i--){
            if(vis[row*mat[0].length+i]==0){
                ans.add(mat[row][i]);
                vis[row*mat[0].length+i]=1;
            }
             
        }
           
    }
      void right(int mat[][],int row,int col,int end){
        for(int i=col;i<=end;i++)
        {
            if(vis[row*mat[0].length+i]==0){
                ans.add(mat[row][i]);
                vis[row*mat[0].length+i]=1;
            }
        }
           
    }
    
    void down(int mat[][],int row,int col,int end){
        for(int i=row;i<=end;i++){
             if(vis[i*mat[0].length+col]==0){
                 ans.add(mat[i][col]); 
                 vis[i*mat[0].length+col]=1;
             }
                 
             }
        }
     
    void up(int mat[][],int row,int col,int end){
        for(int i=row;i>=end;i--){
             if(vis[i*mat[0].length+col]==0){
                 ans.add(mat[i][col]); 
                 vis[i*mat[0].length+col]=1;
             }
                 
         }
        }
    
    }

