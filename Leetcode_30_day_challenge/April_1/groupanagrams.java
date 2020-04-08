class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        
        for(String st: strs){
            char ch[]=st.toCharArray();
            Arrays.sort(ch);
            String x=new String(ch);
            map.computeIfAbsent(x,k->new ArrayList<String>()).add(st);
        }
        
        for(String key: map.keySet()){
            ans.add(map.get(key));
        }
        
        return ans;
    }
}