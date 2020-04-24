//https://leetcode.com/problems/break-a-palindrome/
class Solution {
    public String breakPalindrome(String palindrome) {
        int len=palindrome.length();
        if(len==1)
            return "";
        char ans[]=palindrome.toCharArray();
        for(int i=0;i<len/2;i++){
            if(ans[i]!='a'){
                ans[i]='a';
                return new String(ans);
            }
                
        }
        ans[len-1]='b';
        return new String(ans);
    }
}