
//https://leetcode.com/problems/minesweeper/
class Node{
    int i, j;
    Node(int a,int b){
        i=a;
        j=b;
    }
}
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int x=click[0];
        int y=click[1];
        
        char clck=board[x][y];
        
        if(clck=='M'){
            board[x][y]='X';
            return board;
        }
        
        if(clck=='E')
            bfs(board,x,y,board.length,board[0].length);
            
        return board;
    }
    
    void bfs(char[][]board,int x,int y,int n,int m){
        boolean vis[][]=new boolean[n][m];
         Queue<Node> q=new LinkedList<>();
        q.add(new Node(x,y));
        vis[x][y]=true;
        while(!q.isEmpty()){
            Node cur=q.poll();
            int i=cur.i;
            int j=cur.j;
           if(board[i][j]=='E'){
                
                int count=shouldRecur(board,i,j,n,m);
                if(count==0){
                    
                    board[i][j]='B';

                    if(i+1<n&&!vis[i+1][j]){
                        q.add(new Node(i+1,j));
                        vis[i+1][j]=true;
                    }
                    
                    if(i-1>=0&&!vis[i-1][j]){
                        q.add(new Node(i-1,j));
                        vis[i-1][j]=true;
                    }
                       
                        if(j+1<m&&!vis[i][j+1]){
                        q.add(new Node(i,j+1));
                        vis[i][j+1]=true;
                    }
                           
                  if(j-1>=0&&!vis[i][j-1]){
                        q.add(new Node(i,j-1));
                        vis[i][j-1]=true;
                    }
                     
                      if(i+1<n&&j+1<m&&!vis[i+1][j+1]){
                        q.add(new Node(i+1,j+1));
                        vis[i+1][j+1]=true;
                    }
                         
                    if(i+1<n&&j-1>=0&&!vis[i+1][j-1]){
                        q.add(new Node(i+1,j-1));
                        vis[i+1][j-1]=true;
                    }
                       
                    if(i-1>=0&&j+1<m&&!vis[i-1][j+1]){
                        q.add(new Node(i-1,j+1));
                        vis[i-1][j+1]=true;
                    }
                       
                    if(i-1>=0&&j-1>=0&&!vis[i-1][j-1]){
                        q.add(new Node(i-1,j-1));
                        vis[i-1][j-1]=true;
                    }
                    
                 }
                else{
                    board[i][j]=getDigit(count);
                }
           }
            
        }
        
        
       
    }
    
    char getDigit(int count){
        char ans='0';
        switch(count){
            case 1:
                ans='1';
                break;
            case 2:
                ans='2';
                break;
            case 3:
                ans='3';
                break;
                
            case 4:
                ans='4';
                break;
                
            case 5:
                ans='5';
                break;
                
            case 6:
                ans='6';
                break;
                
            case 7:
                ans='7';
                break;
                
            case 8:
                ans='8';
                break;
        
        }
        return ans;
    }
    
   
    
    
    
    
    
    
    int shouldRecur(char[][]board,int i,int j,int n,int m){
        int count=0;
        
        if(i+1<n&&(board[i+1][j]=='M'||board[i+1][j]=='X'))
            count++;
       
        if(i-1>=0&&(board[i-1][j]=='M'||board[i-1][j]=='X'))
            count++;
        
        if(j+1<m&&(board[i][j+1]=='M'||board[i][j+1]=='X'))
            count++;
        
        if(j-1>=0&&(board[i][j-1]=='M'||board[i][j-1]=='X'))
            count++;
        
        if(i+1<n&&j+1<m&&(board[i+1][j+1]=='M'||board[i+1][j+1]=='X'))
            count++;
        
        if(i+1<n&&j-1>=0&&(board[i+1][j-1]=='M'||board[i+1][j-1]=='X'))
            count++;
        
         if(i-1>=0&&j-1>=0&&(board[i-1][j-1]=='M'||board[i-1][j-1]=='X'))
            count++;
        
         if(i-1>=0&&j+1<m&&(board[i-1][j+1]=='M'||board[i-1][j+1]=='X'))
            count++;
        
        return count;
    }
}