class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        
        if(strs.length == 0)
            return prefix;
        
        prefix = strs[0];
        
        for(int i =1 ;i <strs.length && prefix.length()!=0;i++){
            int c = comp(prefix , strs[i]);
            prefix = strs[i].substring(0,c);
        }
        
        return prefix;
    }
    
    int comp(String prefix ,String s1){
        int i = 0;
        int len = Math.min(prefix.length(),s1.length());
        while(i<len&& s1.charAt(i)==prefix.charAt(i) )
            i++;
        
        return i;
    }
}
