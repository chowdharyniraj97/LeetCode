class Solution {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(l1!=l2)
            return false;
        
        int let[] = new int[26];
        
        for(int i = 0;i<l1;i++){
            char c = s.charAt(i);
            char ck = t.charAt(i);
            let[c-'a']++;
            let[ck-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(let[i]!=0)
                return false;
        }
        return true;
    }
}
