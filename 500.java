class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> row1=new HashSet<>();
        HashSet<Character> row2=new HashSet<>();
        HashSet<Character> row3=new HashSet<>();
        row1.add('q');row1.add('w');row1.add('e');row1.add('r');row1.add('t');row1.add('y');
        row1.add('u');row1.add('i');row1.add('o');row1.add('p');
    
        row2.add('a');row2.add('s');row2.add('d');row2.add('f');row2.add('g');row2.add('h');row2.add('j');row2.add('k');row2.add('l');
        
        row3.add('z');
        row3.add('x');
        row3.add('c');
        row3.add('v');
        row3.add('b');row3.add('n');row3.add('m');
        HashSet<Character> arr[]=new HashSet[3];
        arr[0]=row1;
        arr[1]=row2;
        arr[2]=row3;
        ArrayList<String> ans=new ArrayList<>();
        for(String s : words){
            String ss=s;
            s=s.toLowerCase();
            int i=0;
            int row=0;
            char c=s.charAt(0);
            if(arr[0].contains(c)){
                row=0;
            }
            else if(arr[1].contains(c))
                row=1;
            else
                row=2;
            for( i=1;i<s.length();i++){
                char x=s.charAt(i);
                //System.out.println(s+" x);
                if(!arr[row].contains(x)){
                    System.out.println(s+" "+x);
                    break;}
            }
            if(i==s.length())
                ans.add(ss);
        }
        int i=0;
        System.out.println(ans);
        String res[]=new String[ans.size()];
        for(String x : ans){
            res[i++]=x;
        }
        return res;
    
    
    
    
    }
}