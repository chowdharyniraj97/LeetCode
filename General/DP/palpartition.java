class Solution {
    public List<List<String>> partition(String s) {
        
        return findpals(s,0,s.length());
    }
    public List<List<String>> findpals(String s,int start,int len){
        if(start==len)
        {
            List<List<String>> empty = new ArrayList<>();
            List<String> st = new ArrayList<>();
            empty.add(st);
            return empty;
        }
         List<List<String>> level = new ArrayList<>();
        for(int i=start+1;i<=len;i++){
            String sub = s.substring(start,i);
            
            if(isPal(sub)){
                List<List<String>> ans = findpals(s,i,len);
                for(List<String> cur : ans){
                    cur.add(0,sub);
                    level.add(cur);
                }
                
                
            }
        }
        return level;
        
        
    }
    
    boolean isPal(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}

/*
found a pal recurse on remaining to find more
which will return a list of list to whcih we will add current pal
continue to find a more bigger pal

*/
