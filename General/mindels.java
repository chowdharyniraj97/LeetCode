class Solution {
    HashMap<String,Integer> map;
    public int minDistance(String word1, String word2) {
        map=new HashMap<>();
        return minimum(word1,word2,0,0);
    }
    
    int minimum(String w1,String w2,int i,int j){
        if(i==w1.length() &&j==w2.length()) // "" ""
            return 0;
        if(i==w1.length())
            return w2.length()-j;
        if(j==w2.length())
            return w1.length()-i;
        if(map.containsKey(i+"|"+j))
            return map.get(i+"|"+j);
        if(w1.charAt(i)!=w2.charAt(j))
        {
            int ans=1+Math.min(minimum(w1,w2,i+1,j),minimum(w1,w2,i,j+1));
            map.put(i+"|"+j,ans);
            return ans;
        }
        else
            return minimum(w1,w2,i+1,j+1);
    }
}
