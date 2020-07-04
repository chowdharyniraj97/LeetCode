class Solution {
    String ans="";
    int max=-1;
    HashMap<String,Integer> map;
    public String longestDupSubstring(String S) {
        map=new HashMap<>();
        
        findLongest(S,S,0,0);
        return ans;
    }
    
    
    int findLongest(String s1,String s2,int i,int j){
        if(i==s1.length()||j==s2.length())
            return 0;
        if(map.containsKey(i+"|"+j))
            return map.get(i+"|"+j);
        
        
        if(i!=j && s1.charAt(i)==s2.charAt(j)){
            int x=1+findLongest(s1,s2,i+1,j+1);
            if(x>max){
                max=x;
                ans=s1.substring(i,i+x);
            }
            map.put(i+"|"+j,x);
            return x;
        }
        else{
            findLongest(s1,s2,i+1,j);
            findLongest(s1,s2,i,j+1);
            map.put(i+"|"+j,0);
            return 0;
        }
    }
}
