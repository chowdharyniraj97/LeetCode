//https://leetcode.com/problems/count-vowels-permutation/
class Solution {
    HashMap<String,Integer> map;
    final int mod=1000000007;
    public int countVowelPermutation(int n) {
        int count=0;
        
        map=new HashMap<>();
            count=(count+permute(n-1,'a'))%mod;//a
            count=(count+permute(n-1,'e'))%mod;//e
            count=(count+permute(n-1,'i'))%mod;//i
            count=(count+permute(n-1,'o'))%mod;//o
            count=(count+permute(n-1,'u'))%mod;//u
        
        return count;
    }
    
    int permute(int n,char last){
        int count=0;
        if(n==0){
            return 1;
        }
        if(map.containsKey(n+"|"+last))
            return map.get(n+"|"+last);
        
        if(last=='a')
            count=(count+permute(n-1,'e'))%mod;
        
        else if(last=='e'){
           count=(count+permute(n-1,'a'))%mod;
            count=(count+permute(n-1,'i'))%mod;
        }
        
        else if(last=='i'){
            count=(count+permute(n-1,'a'))%mod;
            count=(count+permute(n-1,'e'))%mod;
            count=(count+permute(n-1,'o'))%mod;
           count=(count+permute(n-1,'u'))%mod;
        }
        else if(last=='o'){
           count=(count+permute(n-1,'i'))%mod;
           count=(count+permute(n-1,'u'))%mod;
        }
        else
            count=(count+permute(n-1,'a'))%mod;
        map.put(n+"|"+last,count);
        return count;
        
    }
}