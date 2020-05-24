
class Node{
    int bc;
    int sc;
    char c;
    Node(char c){
        this.c=c;
        
    }
}
class Solution {
    public String frequencySort(String s) {
        Node ch[]=new Node[256];
        
        for(char c : s.toCharArray()){
        
                int index = (int)c;
                if(ch[index]==null){
                    Node x=new Node(c);
                    ch[index]=x;
                    x.sc++;
                }
                else{
                    ch[index].sc++;
                }
                
            
        }
        System.out.println(hol);
        Arrays.sort(ch,new mySort());
        String ans=;
        
        for(Node x : ch){
            if(x==null)
                continue;
            int small=x.sc;
            for(int i=0;i<small;i++){
                ans+=x.c;
            }
            
        }
        
        return ans;
        
    }
    

}

class mySort implements Comparator<Node>{
    public int compare(Node a,Node b){
        if(a!=null && b!=null){
            int ac=a.sc+a.bc;
        int kc=b.sc+b.bc;
        System.out.println(ac+ +kc);
        return kc-ac;
        }
       else if(a==null && b==null)
           return 0;
        
    else if(a!=null)
        return 1;
    
    else
        return -1;
        
        
    
    }
}
