class Solution {
    public boolean checkValidString(String s) {
        return check(s,0,s.length(),0);
    }
    
    public boolean check(String s,int cur,int len,int count){
        
        if(cur==len){
            if(count==0)
                return true;
            return false;
        }
        if(s.charAt(cur)=='('){
           count++;
            
          return check(s,cur+1,len,count);
            
        }
        else if(s.charAt(cur)==')')
        {
            if(count>0){
                count--;
            return check(s,cur+1,len,count);
        }
            else
                return false;
         
        }
        else{
            return check(s,cur+1,len,count+1) || check(s,cur+1,len,count-1)|| check(s,cur+1,len,count);
            
        }
    }
}