package stunning.palm.tree.a;

public class ImplementTrie {
	public ImplementTrie() {}
	
	TrieNode root = new TrieNode();
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        add(root,0,word);
    }
    
    private void add(TrieNode root, int index, String word){
        if(index == word.length()){
            root.end();
            return;
        }
        
        TrieNode node = root.get(word.charAt(index));
        if(node == null){
            node = root.insert(word.charAt(index));
        }
        add(node,index+1,word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchTrie(word,root,0);
    }
    
    private boolean searchTrie(String word, TrieNode root, int index){
        if(index == word.length() && root!= null&&root.isEnd) return true;
        if(root == null || index == word.length()) return false;
        return searchTrie(word,root.get(word.charAt(index)),index+1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithTrie(prefix, root, 0);
    }
    
    private boolean startsWithTrie(String prefix, TrieNode root, int index){
        if(root == null) return false;
        if(index == prefix.length() && root != null){
            return helper(root);
        }
        return startsWithTrie(prefix,root.get(prefix.charAt(index)),index+1);
    }
    
    private boolean helper(TrieNode node){
        if(node == null) return false;
        if(node.isEnd) return true;
        for(TrieNode trie : node.root){
            if(helper(trie)) return true;
        }
        return false;
    }
}

class TrieNode{
    public TrieNode[] root = new TrieNode[26];
    public boolean isEnd = false;
    public char c;
    
    public TrieNode(){}
    
    public TrieNode(char c){
        this.c = c;
    }
    
    public TrieNode insert(char c){
        root[c-'a'] = new TrieNode(c);
        return root[c-'a'];
    }
    
    public TrieNode get(char c){
        return root[c-'a'];
    }
    
    public void end(){
        this.isEnd = true;
    } 
}
