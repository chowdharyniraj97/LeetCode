class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder source = new StringBuilder();
        for(int i=1;i<=n;i++){
            source.append(i);
        }
        k=k-1;
        if(n==1)
            return "1";
        int start=0;
        
        int fact=findfact(n-1);
        int end=fact;
        int sum=0;
        int i=0;
        for( i=1;i<=n;i++){
            start=sum;
            sum+=fact;
           if(k>=start&& k<sum){
               break;
            }
            
        }
        //ystem.out.println(start+" "+end);
      
        StringBuilder xd=new StringBuilder();
        i=i+48;
        
        formString((char)i,source,xd);
       
        List<StringBuilder> ans= kpermute(xd,k-1,0);
       // System.out.println(ans);
        
        StringBuilder y= ans.get(k-start);
        y.insert(0,(char)i);
        return y.toString();
    }
    
    List<StringBuilder> kpermute(StringBuilder sb,int k,int lvl){
        if(sb.length()==1){
            List<StringBuilder> list=new ArrayList<>();
            list.add(sb);
            return list;
        }
        List<StringBuilder> cur=new ArrayList<>();
        for(int i=0;i<sb.length();i++){
            char start=sb.charAt(i);
            StringBuilder newsb=new StringBuilder();
           formString(sb.charAt(i),sb,newsb);
            
            List<StringBuilder> list=kpermute(newsb,k,0);
            for(StringBuilder s : list){
                s.insert(0,start);
                cur.add(s);
            }
        }
        //System.out.println(cur);
        return cur;
    }
    
    
    void formString(char ban,StringBuilder sb,StringBuilder newsb){
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!=ban)
                newsb.append(sb.charAt(i));
        }
        
        
    }
    
    int findfact(int n){
        int f=1;
        for(int i=1;i<=n;i++)
            f*=i;
        return f;
    }
}
