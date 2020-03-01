class Trie{
    boolean end;
    Trie [] letter;
    Trie(){
        letter=new Trie[27];
        end=false;
    }
    
}
class WordDictionary {
Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Trie();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
       addit(word,0,word.length(),root);
       if(root.letter[26]==null){
           root.letter[26]=new Trie();
           addit(word,1,word.length(),root.letter[26]);
       }
        else{
             addit(word,1,word.length(),root.letter[26]);
        }
    }
    
    public void addit(String word,int index,int len,Trie cur){
        if(index==len){
            cur.end=true;
            return;
        }
        char c=word.charAt(index);
        if(cur.letter[c-'a']==null){
            cur.letter[c-'a']=new Trie();
            addit(word,index+1,len,cur.letter[c-'a']);
            
        }
        else{
             addit(word,index+1,len,cur.letter[c-'a']);
        }
       
        if(cur.letter[26]==null){
           cur.letter[26]=new Trie();
           addit(word,index+1,len,cur.letter[26]);
        }
        else{
             addit(word,index+1,len,cur.letter[26]);
        }
            
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie cur=root;
        for(int i=0;i<word.length()&&cur!=null;i++){
            char c=word.charAt(i);
            
            if(c!='.' && cur.letter[c-'a']!=null){
                cur=cur.letter[c-'a'];
            }
    
            else if(c=='.'&&cur.letter[26]!=null){
                cur=cur.letter[26];
            }
            else 
                return false;
        }
        return cur.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */