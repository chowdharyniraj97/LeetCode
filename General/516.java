//https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
    HashMap<String,Integer> map;
    public int longestPalindromeSubseq(String s) {
        map=new HashMap<>();
        return longestPal(s,0,s.length()-1);
        
        
    }
    
    int longestPal(String s,int i,int j){
        if(i>j)
            return 0;
        if(i==j)
            return 1;
        if(map.containsKey(i+" "+j))
            return map.get(i+ " "+ j);
        
        if(s.charAt(i)==s.charAt(j)){
            int x= 2 + longestPal(s,i+1,j-1);
            map.put(i+" "+j,x);
            return x;
        }
        else{
            int a=longestPal(s,i+1,j);
            int b=longestPal(s,i,j-1);
            int z=Math.max(a,b);
             map.put(i+" "+j,z);
            return z;
        }
    }
}