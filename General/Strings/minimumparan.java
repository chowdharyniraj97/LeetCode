class Solution {
    public int minAddToMakeValid(String S) {
        int count = 0;
        int ans = 0;
        for(int i = 0; i< S.length(); i++) {
            char c = S.charAt(i);
            if(c == '(')
                count++;
            else{
                count--;
            }
            
            if(count < 0) {
                ans++;
                count = 0;
            }
        }
        
        
        return count + ans;
    }
}
