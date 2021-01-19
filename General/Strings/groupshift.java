public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String word : strings){
            StringBuilder key = new StringBuilder("");
            int offset = word.charAt(0) - 'a';
            for(int i = 1; i < word.length(); i++){
                key.append((word.charAt(i) - offset + 26) % 26);
            }
            
            if(!map.containsKey(key.toString())){
                map.put(key.toString(), new ArrayList<String>());
            }
            map.get(key.toString()).add(word);
        }
        
        for(List<String> list : map.values()){
            // Collections.sort(list);
            res.add(list);
        }
        
        return res;
        
    }
}
