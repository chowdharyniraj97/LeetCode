//https://leetcode.com/problems/available-captures-for-rook/
class Solution {
    public int numRookCaptures(char[][] board) {
        int count=0;
        for(int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                if(board[r][c]=='R'){
                  if(moveright(board,r,c+1))
                      count++;
                    if(moveleft(board,r,c-1))
                      count++;
                    if(moveup(board,r-1,c))
                      count++;
                    if(movedown(board,r+1,c))
                      count++;
                    break;
                }
                if(count>0)
                    break;
            }
        }
        return count;
    }
    
    boolean moveright(char[][] board,int r,int c){
        if(board[r][c]=='B'||r==8||c==8)
            return false;
        for(int i=c;i<8;i++){
            if(board[r][i]=='p')
                return true;
            else if(board[r][i]=='.')
                continue;
            else
                return false;
        }
        return false;
        
    }
    
    boolean moveleft(char[][] board,int r,int c){
        if(board[r][c]=='B'||r==0||c==0)
            return false;
        for(int i=c;i>=0;i--){
            if(board[r][i]=='p')
                return true;
            else if(board[r][i]=='.')
                continue;
            else
                return false;
        }
        return false;
        
    }
    
    boolean movedown(char[][] board,int r,int c){
        if(board[r][c]=='B'||r==8||c==8)
            return false;
        for(int i=r;i<8;i++){
            if(board[i][c]=='p')
                return true;
            else if(board[i][c]=='.')
                continue;
            else
                return false;
        }
        return false;
        
    }
    
    boolean moveup(char[][] board,int r,int c){
        if(board[r][c]=='B'||r==0||c==0)
            return false;
        for(int i=r;i>=0;i--){
            if(board[i][c]=='p')
                return true;
            else if(board[i][c]=='.')
                continue;
            else
                return false;
        }
        return false;
        
    }
}