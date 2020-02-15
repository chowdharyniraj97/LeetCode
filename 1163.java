//https://leetcode.com/problems/last-substring-in-lexicographical-order/
class Solution {
    public String lastSubstring(String s) {
        
        int letters[]=new int[26];
        int pos[]=new int[26];
        Arrays.fill(pos,-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            letters[c-'a']++;
            if(pos[c-'a']==-1)
                pos[c-'a']=i;
            
        }
        char last;
        int firstpos=0;
        for(int i=25;i>=0;i--){
            if(letters[i]!=0){
                last=(char)(i+97);
                firstpos=pos[i];
                break;
            }
        }
        String ans=s.substring(firstpos);
       return findlast(ans,ans,ans.charAt(0),1);
    }
    
    String findlast(String s,String ans,char target,int i){
        if(i==s.length())
            return ans;
        
        if(s.charAt(i)==target)
        {
            String temp=s.substring(i);
            if(ans.compareTo(temp)<0)
               return findlast(temp,temp,temp.charAt(0),1);
        }
        return findlast(s,ans,target,i+1);
    }
}