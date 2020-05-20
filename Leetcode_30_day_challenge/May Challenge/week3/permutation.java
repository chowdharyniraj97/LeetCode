
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ch[]={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        
        int target=1;
        for(char c : s1.toCharArray())
            target*=ch[c-'a'];
        
        
        int i=0;
        int j=s1.length();
        int cur=1;
        for(int k=i;k<j;k++){
            cur*=ch[s2.charAt(k)-'a'];
        }
        if(cur==target)
            return true;
        int len=s1.length();
        cur=cur/(ch[s2.charAt(i)-'a']);
            i++;
            j++;
        while(j<s2.length()){
            
            cur*=ch[s2.charAt(j)-'a'];
            if(cur==target)
                return true;
            cur=cur/(ch[s2.charAt(i)-'a']);
            i++;
            j++;
        }
        cur=1;
        for(int k=i;k<j;k++){
            cur*=ch[s2.charAt(k)-'a'];
        }
        if(cur==target)
            return true;
        return false;
    }
}
