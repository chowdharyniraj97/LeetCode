class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ch[]=new int[26];
        int temp[]=new int[26];
        boolean found=true;
        for(char c : s1.toCharArray()){
            ch[c-'a']++;
            temp[c-'a']++;
        }
        int i=0;
        int j=s1.length();
        int ii=0;
        int jj=s1.length();
        while(j<=s2.length()){
            for(int k=i;k<j;k++){
                char x=s2.charAt(k);
                temp[x-'a']--;
            }
            
            for(int ind : temp){
                if(ind<0||ind >0)
                {
                    found=false;
                    for(int o=0;o<26;o++){
                        temp[o]=ch[o];
                    }
                    i++;
                    j++;
                    break;
                }
            
            }
            if(found)
                return true;
            
            found=true;
    
        }
        return false;
        
        
    }
}
