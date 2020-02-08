//1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Naive solution goes into TLE

class Solution {
    StringBuilder ans;
    int min=Integer.MAX_VALUE;
    public String minRemoveToMakeValid(String s) {
        ans=new StringBuilder("");
        if(!isValid(s.toCharArray())){
            StringBuilder sb=new StringBuilder(s);
             findsmallestdrop(sb,0,0);
            System.out.println(min);
            return ans.toString();
        }
        return s;
    }
             
    
    public void findsmallestdrop(StringBuilder s,int sg,int steps){
        
        //System.out.println(s);
        for(int i=0;i<s.length();i++){
            
            char c=s.charAt(i);
            if(c=='(' || c==')')
            {
                if(!isValid(s.toString().toCharArray())){
                    StringBuilder temp=new StringBuilder(s);
                    if(steps+1<min)
                            findsmallestdrop(temp.delete(i,i+1),i,steps+1);
                }
                else{
                    if(steps<min)
                    {
                        //System.out.println(min);
                        ans=new StringBuilder(s);
                        min=steps;
                        return;
                    }
                }
            }
           
       }
    }
    
    
    
    public boolean isValid(char ch[]){
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int i=0;
        for(char c : ch){
            if(c=='(')
                st.push(i);
            else if(c==')')
            {
                if(st.peek()==-1)
                    return false;
                else
                    st.pop();
            }
            i++;
        }
        if(st.peek()==-1)
        return true;
        return false;
        
        
    }
}