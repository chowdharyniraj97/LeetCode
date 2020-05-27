
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,String> color=new HashMap<>();
        int graph[][]=new int[N+1][N+1];
        
        
        for(int x[]:dislikes){
            int i=x[0];
            int j=x[1];
            graph[i][j]=1;
            graph[j][i]=1;
        }
        
    for(int k=1;k<=N;k++){
        
           q.add(k);
        int size=0;
        int s=1;
        color.put(k,red);
            
            
            size=s;
            s=0;
            for(int i=1;i<=size;i++){
                
                int x=q.poll();
                String c=color.get(x);
                    String childcolor=;
                    if(c.equals(red))
                        childcolor=blue;
                    else
                        childcolor=red;
                
                for(int j=1;j<=N;j++){
                    //j not x
                    if(j!=x&&graph[x][j]==1){
                        
                           color.put(j,childcolor);
                            q.add(j);
                            s++;
                        }
                        
                        else{
                            String col=color.get(j);
                                return false;
                        }   
                    }
                    
                    
                    
                }
              
                
            }
             
        }
    }
     
    }
         return true;
        
    }
}
