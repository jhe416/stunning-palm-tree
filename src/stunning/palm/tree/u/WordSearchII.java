package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	public WordSearchII() {}

	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	List<String> res = new ArrayList<>();
	public List<String> findWords(char[][] board, String[] words) {
		int m=board.length,n=board[0].length;
		Trie root = new Trie();

		for(String word : words){
			add(root,word,0);
		}
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(root.get(board[i][j]) != null){
					dfs(board,m,n,i,j,visited,root); 
				}
			}
		}

		return res;
	}

	private void add(Trie root, String word, int index){
		if(index == word.length()){
			root.isEnd = true;
			root.str = word;
			return;
		}
		Trie node = root.add(word.charAt(index));
		add(node,word,index+1);
	}

	private void dfs(char[][] board, int m, int n, int i, int j, boolean[][] visited, Trie root){
		if(root.isEnd){
			res.add(root.str);
			root.isEnd = false;
		}
		if(i<0 || i==m || j<0 || j==n || visited[i][j] || root.get(board[i][j]) == null) return;
		visited[i][j] = true;

		Trie newTrie = root.get(board[i][j]);
		for(int[] dir : dirs){
			dfs(board,m,n,i+dir[0],j+dir[1],visited,newTrie);
		}

		visited[i][j] = false;
	}
	
	class Trie{
	    Trie[] trie = new Trie[26];
	    boolean isEnd;
	    String str = "";
	    public Trie(){}
	    
	    public Trie add(char c){
	        if(trie[c-'a'] != null) return trie[c-'a'];
	        trie[c-'a'] = new Trie();
	        return trie[c-'a'];
	    }
	    
	    public Trie get(char c){
	        return trie[c-'a'];
	    }
	}
}
