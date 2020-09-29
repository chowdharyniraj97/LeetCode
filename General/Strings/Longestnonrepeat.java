class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lastindx[]  = new int[256]; 
        Arrays.fill(lastindx,-1);
        if(s.length() == 0)
            return 0;
        int ans = 1;
        lastindx[(int)s.charAt(0)] = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int i=0;
        int j=1;
        while(j < s.length()) {
            char c = s.charAt(j);
            int ind = (int)c;
            if(lastindx[ind]!= -1) {
                if(lastindx[ind]>=i){
                    i = lastindx[ind] + 1;
                    lastindx[ind] = j;
                }
                else{
                    lastindx[ind] = j;
                }
            }
            else{
                lastindx[ind] = j;
                
            }
            
            ans = Math.max(ans,j-i+1);
            j++;
        }
        
        return ans;
    }
}
