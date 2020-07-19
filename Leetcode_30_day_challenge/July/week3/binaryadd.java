class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s1 = new StringBuilder(a);
        StringBuilder s2 = new StringBuilder(b);
        
        if(s1.length()!=s2.length())
            equalize(s1,s2);
        System.out.println(s1+" "+s2);
        StringBuilder ans=new StringBuilder("");
        char carry='0';
        for(int i=s1.length()-1;i>=0;i--){
            char x=s1.charAt(i);
            char y =s2.charAt(i);
            
            if(x=='1' && y=='1' && carry=='1'){
                ans.insert(0,'1');
                carry='1';
            }
            else if(x=='1' && y=='1' && carry=='0'){
                ans.insert(0,'0');
                carry='1';
            }
            else if(x=='0' && y=='0'){
                if(carry=='1'){
                    ans.insert(0,'1');
                    carry='0';
                } else{
                    ans.insert(0,'0');
                }
                
            }
            else{
                if(carry=='1')
                    ans.insert(0,'0');
                else
                    ans.insert(0,'1');
            }
                
            
        }
        if(carry=='1')
            ans.insert(0,'1');
        
        return ans.toString();
    }
    
    
    void equalize(StringBuilder s1,StringBuilder s2){
        if(s1.length()>s2.length()){
            int diff=s1.length()-s2.length();
            
            for(int i=0;i<diff;i++){
                s2.insert(0,'0');
            }
        }
        else{
            int diff=s2.length()-s1.length();
            
            for(int i=0;i<diff;i++){
                s1.insert(0,'0');
            }
            
        }
    }
}
