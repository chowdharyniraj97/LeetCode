//https://leetcode.com/problems/palindromic-substrings/
class Solution {
    int count=0;
    HashSet<String> set;
    public int countSubstrings(String s) {
        set=new HashSet<>();
        
        countPals(s,0,s.length()-1);
        return count;
    }
    
    boolean countPals(String s, int i, int j){
        if(j-i+1==1){
            if(!set.contains(i+"")){
                count++;
                set.add(i+"");
            }
            return true;
        }
        if(j-i+1==2){
            if(!set.contains(i+""))
            {
                set.add(i+"");
                    count++;
            }
             if(!set.contains(j+""))
            {
                set.add(j+"");
                count++;
            }
            if(s.charAt(i)==s.charAt(j)){
                if(!set.contains(i+" "+ j)){
                    set.add(i+" "+j);
                     count++;
                }
                
                return true;
            }
            return false;
        }
        
        boolean twojumps=countPals(s,i+1,j-1);
        boolean leftpart=countPals(s,i,j-1);
        boolean rightpart=countPals(s,i+1,j);
        if(s.charAt(i)==s.charAt(j))
        {
            if(twojumps)
            {
                if(!set.contains(i+" "+ j)){
                    count++;
                    set.add(i+" "+j);
                }
                return true;
            }
               
        }
        return false;
    }
}

//----------------------------------------------MEMO---------------------------------------------------------------------
class Solution {
    int count=0;
    HashSet<String> set;
    HashMap<String,Boolean> map;
    public int countSubstrings(String s) {
        set=new HashSet<>();
        map=new HashMap<>();
        if(s.length()==0)
            return 0;
        countPals(s,0,s.length()-1);
        return count;
    }
    
    boolean countPals(String s, int i, int j){
        if(j-i+1==1){
            if(!set.contains(i+"")){
                count++;
                set.add(i+"");
            }
            return true;
        }
        if(j-i+1==2){
            if(!set.contains(i+""))
            {
                set.add(i+"");
                    count++;
            }
             if(!set.contains(j+""))
            {
                set.add(j+"");
                count++;
            }
            if(s.charAt(i)==s.charAt(j)){
                if(!set.contains(i+" "+ j)){
                    set.add(i+" "+j);
                     count++;
                }
                
                return true;
            }
            return false;
        }
        if(map.containsKey(i+" "+j))
            return map.get(i+" "+j);
        boolean twojumps=countPals(s,i+1,j-1);
        boolean leftpart=countPals(s,i,j-1);
        boolean rightpart=countPals(s,i+1,j);
        boolean ans=false;
        if(s.charAt(i)==s.charAt(j))
        {
            if(twojumps)
            {
                if(!set.contains(i+" "+ j)){
                    count++;
                    set.add(i+" "+j);
                }
                ans= true;
            }
               
        }
       map.put(i+" "+j,ans);
        return ans;
    }
}