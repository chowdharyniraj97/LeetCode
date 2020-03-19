class Solution {
    HashMap<String,Boolean> map;
    int parts=0;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans =new ArrayList<>();
        map=new HashMap<>();
        HashSet<String> dict=new HashSet<>();
        for(String str: words)
            dict.add(str);
        for(String str: words){
            parts=0;
            map=new HashMap<>();
            if(isCompose(str,dict,1) && parts>1)
                ans.add(str);
                
        }
        return ans;
 }
    
    
    boolean isCompose(String word,HashSet<String> dict,int start){
        // if(start==word.length())
        //     return true;
        
        if(map.containsKey(word))
            return map.get(word);
        
        String sb="";
        boolean ans=false;
        for(int i=start;i<word.length();i++){
            sb=word.substring(0,i);
            String suffix=word.substring(i);
            if(dict.contains(sb)){
                parts++;
                if(dict.contains(suffix)||isCompose(suffix,dict,1)){
                    parts++;
                    map.put(word,true);
                    return true;
                 }
                else
                parts--;
                
               
            }
        }
        map.put(word,false);
        return false;
    }
}