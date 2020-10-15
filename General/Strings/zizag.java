class Node {
    int col;
    char val;
    
    Node(int a ,char c) {
        col = a;
        val = c;
    }
}
class Solution {
    TreeMap<Integer, PriorityQueue<Node> > map;
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
    map = new TreeMap<>();
        boolean flag = true;
        //true means row 
        //false diagonal
        //row we stop wehn r becomes numrow - 1 +1 0
        //d we stop wehn r become zero -1 +1
        
        int i =0;
        int r =0;
        int c =0;
        StringBuilder b[] = new StringBuilder[numRows];
        for( i =0; i < numRows;i++) {
            b[i] = new StringBuilder();
        }
        i=0;
        while(i < s.length()) {
           if(flag) {
             while(i < s.length()&& r  < numRows) {
                 char ch = s.charAt(i++);
                 b[r].append(ch);
                 r++;
             }
             r-=2;
              flag = !flag;
           } 
            
            
            else {
                c =c+1;
                while(i < s.length() && r!=0) {
                     char ch = s.charAt(i++);
                    b[r].append(ch);
                    r--;
                    c++;
                }
                flag= !flag;
                r = 0;
                
                
            }
        }
        StringBuilder res = new StringBuilder("");
        
        for( i = 0; i<numRows;i++) {
            res.append(b[i]);
        }
        
        
    return res.toString();
        
       
        
   
        
    }
}


/*
like a 2d array




*/
