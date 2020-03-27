class Node{
    int i, j;
    int steps=0;
    Node(int a,int b,int s){
        i=a;
        j=b;
        steps=s;
    }
    
}
class Solution {
    final int inf=Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        HashSet<Integer> vis;
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
               
                if(rooms[i][j]==0){
                     vis=new HashSet<>();
                     bfs(rooms,i,j,vis);
                }
                   
            }
        }
        
        
    }
    
    void bfs(int rooms[][],int a,int b,HashSet<Integer> vis){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(a,b,0));
        vis.add(pos(a,b,rooms.length,rooms[0].length));
        while(!q.isEmpty()){
            Node cur=q.poll();
            int i=cur.i;
            int j=cur.j;
            
          
           if(i+1<rooms.length){
                int p=pos(i+1,j,rooms.length,rooms[0].length);
                if(!vis.contains(p)){
                    if(rooms[i+1][j]>0 &&cur.steps+1<rooms[i+1][j]){
                        rooms[i+1][j]=cur.steps+1;
                    Node x=new Node(i+1,j,cur.steps+1);
                    q.add(x);
                    vis.add(p);
                    }
                    
                }
            }
            
            if(i-1>=0){
                int p=pos(i-1,j,rooms.length,rooms[0].length);
                if(!vis.contains(p)){
                    if(rooms[i-1][j]>0 &&cur.steps+1<rooms[i-1][j]){
                         rooms[i-1][j]=cur.steps+1;
                    Node x=new Node(i-1,j,cur.steps+1);
                    q.add(x);
                    vis.add(p);
                    }
                    
                }
            }
            
            if(j+1<rooms[0].length){
                int p=pos(i,j+1,rooms.length,rooms[0].length);
                if(!vis.contains(p)){
                    if(rooms[i][j+1]>0 &&cur.steps+1<rooms[i][j+1]){
                         rooms[i][j+1]=cur.steps+1;
                    Node x=new Node(i,j+1,cur.steps+1);
                    q.add(x);
                    vis.add(p);
                    }
                    
                }
            }
            
           if(j-1>=0){
                int p=pos(i,j-1,rooms.length,rooms[0].length);
                if(!vis.contains(p)){
                    if(rooms[i][j-1]>0 &&cur.steps+1<rooms[i][j-1]){
                         rooms[i][j-1]=cur.steps+1;
                    Node x=new Node(i,j-1,cur.steps+1);
                    q.add(x);
                    vis.add(p);
                    }
                    
                }
            }
            
            
            
        
        }
    }
    
    
    int pos(int i,int j,int n,int m){
        return i*m+j;
    }
}