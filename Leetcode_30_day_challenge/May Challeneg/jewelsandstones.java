class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
    for(int i=0;i<S.length();i++)
    {
        int x = J.indexOf(S.charAt(i));
        
        if(x!=-1)
            ans++;
            
    }        
    return ans;
   
}
    }

