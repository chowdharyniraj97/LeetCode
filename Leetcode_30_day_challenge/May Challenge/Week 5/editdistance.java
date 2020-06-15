class Solution {
    HashMap<String,Integer> map;
    public int minDistance(String word1, String word2) {
        map=new HashMap<>();
        return findmin(new StringBuilder(word1),new StringBuilder(word2),word1.length(),word2.length(),0,0);
    }
    
    int findmin(StringBuilder s1,StringBuilder s2,int l1,int l2,int i,int j){
        //System.out.println(i+" "+l1+ " "+j+" "+l2);
        if(i==l1 && j==l2)
            return 0;
        
        if(j==l2)
            return l1-i;
        
       if(i==l1)
           return l2-j;
        
        if(map.containsKey(s1+"|"+i+"|"+j))
            return map.get(s1+"|"+i+"|"+j);
        
        if(s1.charAt(i)==s2.charAt(j)){
            //deleting
            String t=s1.toString();
            //StringBuilder s=new StringBuilder(t);
           
            //s.delete(i,i+1);
            int a=findmin(s1,s2,l1,l2,i+1,j);
            //StringBuilder tp=new StringBuilder(t);
            
            //StringBuilder sg=new StringBuilder(t);
           // sg.insert(i,s2.charAt(i));
            int f=findmin(s1,s2,l1,l2,i,j+1);
            
            
            
            int b=findmin(s1,s2,l1,l2,i+1,j+1);
            
           
            
            int ans= Math.min(a+1,Math.min(b,f+1));
            map.put(t+"|"+i+"|"+j,ans);
            return ans;
           
            
            
           
        }
        
        
        else{
            String t=s1.toString();
             //StringBuilder s=new StringBuilder(t);
           
        //   s.delete(i,i+1);
            int del=findmin(s1,s2,l1,l2,i+1,j);
            
            //StringBuilder sb=new StringBuilder(t);
           // sb.insert(i,s2.charAt(j));
            int insert=findmin(s1,s2,l1,l2,i,j+1);
            
           // StringBuilder sc=new StringBuilder(t);
            //sc.replace(i,i+1,s2.charAt(j)+"");
            int replace=findmin(s1,s2,l1,l2,i+1,j+1);
         
         
            
            
            int ans= Math.min(Math.min(del+1,insert+1),replace+1);
            map.put(t+"|"+i+"|"+j,ans);
            return ans;
            
            
            
            
            
            
            
        }
    }
}
