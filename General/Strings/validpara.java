class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
       
        Stack<Integer> st =new Stack<>();
        char ch[] = s.toCharArray();
        
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='}'){
                if(!st.isEmpty() && ch[st.peek()] == '{' )
                    st.pop();
                else
                    return false;
            }
            else if(ch[i]==')'){
                if(!st.isEmpty() && ch[st.peek()] == '(' )
                    st.pop();
                else
                    return false;
                
            }
            else if(ch[i]==']'){
                if(!st.isEmpty() &&ch[st.peek()] == '[' )
                    st.pop();
                else
                    return false;
                
            }
            else
                st.push(i);
        }
        return st.isEmpty;
        
        
        
    }
}
