class Solution {
    int letter[] = new int[256];
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i =0;
        int j =1;
        letter[s.charAt(i)]++;
        int K = unique();
        int len = 0;
        while( j < s.length()) {
            
            // if(K == k) {
                
                 int x = letter[s.charAt(i)];
                //run a loop to revive K mean i moves forward
                while(K > k) {
                    char c = s.charAt(i);
                    letter[c]--;
                    if(letter[c] ==0) {
                        K--;
                    }
                    // K = unique();
                    i++;
                }
            // }
            len = Math.max(len, j - i);
          
                char ch = s.charAt(j++);
                letter[ch]++;
                if(letter[ch] == 1) {
                    K++;
                }
            
        }
        K = unique();
        if(K <=k) {
            len = Math.max(len,j-i);
        }
        return len;
    }
    
    
    int unique() {
        int count = 0;
        for(int i =0; i<256; i++) {
            if(letter[i] > 0) {
                count++;
            }
        }
        
        return count;
    }
}
