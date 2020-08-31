class Solution {
    Stack<Character> letters;
    int vis[];
    public String alienOrder(String[] words) {
        if(words.length==1 )
            return words[0];
        letters = new Stack<>();
        vis=new int[26];
        int i =0;
        int j=1;
        int grid[][]=new int[26][26];
       // boolean k = false;
        HashSet<Character> set = new HashSet<>();
        while(j<words.length){
            String first = words[i];
            String second = words[j];
            
            int p=0;
            int q=0;
            while(p<first.length() && q<second.length() && first.charAt(p)==second.charAt(q)){
                set.add(first.charAt(p));
                set.add(second.charAt(q));
                p++;
                q++;
            }
           
            if(p<first.length() && q==second.length())
                return "";
            
            if(p<first.length() && q<second.length()){
                 set.add(first.charAt(p));
                 set.add(second.charAt(q));
                grid[first.charAt(p)-'a'][second.charAt(q)-'a']=1;
            }
            
            while(p<first.length()){
                set.add(first.charAt(p++));
            }
             while(q<second.length()){
                set.add(second.charAt(q++));
            }
            
            i++;
            j++;
            
        }
        
        //traversing the graph
        int local[]=new int[26];
        for(i=0;i<26;i++){
            char c = (char)(97+i);
            local=new int[26];
            if(set.contains(c) && vis[i]!=1){
                
                traverse(grid,i,local);
            }
        }
        
        
        String ans="";
        while(!letters.isEmpty()){
            char c=letters.pop();
           //System.out.println(c);
            
            if(c == '&')
                return "";
            ans = ans+c;
        }
        
        return ans;
        
        
       
        
        
        
    }
    
    void traverse(int grid[][],int i,int local[]){
        if(local[i]==1){
            letters.push('&');
            return;
            
        }
        local[i]=1;
        for(int j=0;j<26;j++){
            if(grid[i][j]==1 && vis[j]!=1){
                traverse(grid,j,local);
                
            }
        }
        local[i]=0;
        char c =(char)(97+i);
        letters.push(c);
        vis[i]=1;
    }
    
}


/*
create a graph
do topological sort


*/
