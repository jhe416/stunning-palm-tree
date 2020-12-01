package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.List;

/*
 * dfs on a trie. 
 * couple tricks can be used to spend up the look
 * instead of using string concanation during dfs. a word can be stored in the trie
 * instead of using a set to keep the uniquiness, once a isEnd found we store the word and mark
 * the isEnd=false;
 * a visited boolean matrix to keep track of visited points can be used. also increase the performance a bit.
 * Time O((n*m)^2) space O(m*n) 
 */
public class WordSearchII {
	public WordSearchII() {}
	
    private List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word : words){
            addWord(word,root,0);
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(i,j,board,root,m,n,visited);
            }
        }
        
        return new ArrayList<>(result);
    }
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    private void dfs(int i, int j, char[][] board, Trie root, int m, int n,boolean[][] visited){
        if(i < 0 || i == m || j < 0 || j == n ||  visited[i][j] || root.get(board[i][j]) == null) return;    
        char c = board[i][j];
        Trie node = root.get(c);
        if(node.isEnd){
            result.add(node.word);
            node.isEnd = false;
        }

        visited[i][j] = true;
        for(int[] dir : dirs){
            dfs(i+dir[0],j+dir[1],board,node,m,n,visited);
        }
        
        visited[i][j] = false;
    }
    
    
    private void addWord(String word, Trie root, int index){
        if(index == word.length()){
            root.isEnd = true;
            root.word = word;
            return;
        }
        Trie trie = root.get(word.charAt(index));
        if(trie == null) trie = root.add(word.charAt(index));
        addWord(word,trie,index+1);
    }
    
    class Trie{
        Trie[] arr = new Trie[26];
        boolean isEnd = false;
        String word;
        public Trie(){}
        
        public Trie add(char c){
            arr[c-'a'] = new Trie();
            return arr[c-'a'];
        }
        
        public Trie get(char c){
            return arr[c-'a']; 
        }
        
        public boolean isEnd(){
            return isEnd;
        }
    }
}
