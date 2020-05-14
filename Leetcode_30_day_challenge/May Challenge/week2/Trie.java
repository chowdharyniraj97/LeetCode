
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p=root;
        for(char c:word.toCharArray()){
            if(p.child[c-'a']==null){
                p.child[c-'a']=new TrieNode();
                
            }
            p=p.child[c-'a'];
            
        }
        p.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p=root;
        for(char c : word.toCharArray()){
            if(p.child[c-'a']==null)
                return false;
            p=p.child[c-'a'];
        }
        return p.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode p=root;
        for(char c : word.toCharArray()){
            if(p.child[c-'a']==null)
                return false;
            p=p.child[c-'a'];
        }
        return true;
    }
}

class TrieNode{
    TrieNode child[]=new TrieNode[26];
    boolean isEnd=false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
