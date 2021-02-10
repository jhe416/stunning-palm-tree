package stunning.palm.tree.f;

/*
 * basically a trie question
 * Time O(n)
 * Space O(n)
 */
class DesignAddAndSearchWordsDataStructure {

    Trie root;
    /** Initialize your data structure here. */
    public DesignAddAndSearchWordsDataStructure() {
        this.root = new Trie();
    }
    
    public void addWord(String word) {
        addWordDfs(word,0,root);
    }
    
    private void addWordDfs(String word, int index, Trie root){
        if(index == word.length()){
            root.isEnd = true;
            return;
        }
        
        root = root.add(word.charAt(index));
        addWordDfs(word,index+1,root);
    }
    
    public boolean search(String word) {
        return searchDfs(word,0,root);
    }
    
    private boolean searchDfs(String word, int index, Trie root){
        if(root == null) return false;
        if(index == word.length() && root.isEnd()) return true;
        if(index == word.length()) return false;
        if(word.charAt(index) == '.'){
            for(int i=0;i<26;i++){
                if(searchDfs(word,index+1,root.get(i))) return true;
            }
            return false;
        }else{
            return searchDfs(word,index+1,root.get(word.charAt(index)));
        }
    }
}

class Trie{
    public Trie[] node;
    public boolean isEnd;
    
    public Trie(){
        this.node = new Trie[26];
        this.isEnd = false;
    }
    
    public Trie add(char c){
        Trie newNode = node[c-'a'];
        
        if(newNode == null){
            node[c-'a'] = new Trie();
            newNode = node[c - 'a'];
        }
        
        return newNode;
    }
    
    public Trie get(char c){
        return node[c-'a'];
    }
    
    public Trie get(int i){
        return node[i];
    }
    
    public boolean isEnd(){
        return this.isEnd;
    }
}
