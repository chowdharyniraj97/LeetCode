
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ch[]=new int[26];
        
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            ch[c-'a']++;
            
        }
        
        for(char c : magazine.toCharArray()){
            ch[c-'a']--;
        }
        
        for(int x : ch){
            if(x >0)
                return false;
        }
        return true;
    }
}
