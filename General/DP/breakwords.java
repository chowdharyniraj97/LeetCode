class Solution {
    List<String> ans;
    HashMap<Integer,ArrayList<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        map=new HashMap<>();
        List<String> list= breakwords(s,wordDict,0,s.length(),"");
        return list;
        
        
    }
    
    public ArrayList<String> breakwords(String s, List<String> words,int start,int end,String k){
        if(start == end){
             ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        
        
        
        if(map.containsKey(start))
            return map.get(start);
        
        
        
        ArrayList<String> res = new ArrayList<>();
        
        
        for(int i = start; i <=end ;i++){
           String word = s.substring(start,i); 
            if(words.contains(word))
            {
                if(start!=0){
                    word=" "+word;
                }
              ArrayList<String> sent = breakwords(s,words,i,end,"");
              for(String x : sent){
                  String temp = word + x;
                  res.add(temp);
              }
              
            }
             
        }
        if(map.containsKey(start)){
                 ArrayList<String> cur = map.get(start);
                  for(String x : res){
                      cur.add(x);
                  }
              }
            else{
                    map.put(start,res);
                }
        return res;
       
        
        
        
        
    }
}
