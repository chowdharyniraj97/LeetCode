class block{
    char c;
    int count;
    block(char c,int count){
        this.c = c;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        if(k==1)
            return "";
        Stack<block> st = new Stack<>();
        st.push(new block('&',0));
        
        for(int i =0; i<s.length();i++){
            block top = st.peek();
            char cur = s.charAt(i);
            
            if(top.c == cur){
                top.count = top.count +1;
                
                if(top.count >= k) {
                    top.count = top.count - k;
                    
                }
                if(top.count == 0)
                    st.pop();
            }
            
            else{
                block b = new block(cur,1);
                st.push(b);
            }
            
            
        }
        StringBuilder ans =new StringBuilder("");
        for(block ele : st) {
            if(ele.count>0) {
                for(int i=0;i<ele.count;i++) {
                    ans.append(ele.c);
                }
            }
        }
        
        return ans.toString();
    }  
        
}

/*
keep adding and checking count after every add if it is zero means pop all those added characters 


*/
