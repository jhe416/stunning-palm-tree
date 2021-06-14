package stunning.palm.tree.u;

public class WordSearch {
	public WordSearch() {}
	
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.isEmpty()) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(m,n,i,j,board,visited,word,0)) return true;
            }
        }
        
        return false;
    }
    
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean dfs(int m, int n, int i, int j, char[][] board, boolean[][] visited, String word, int index){
        if(word.length() == index) return true;
        if(i<0||i==m||j<0||j==n||visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        for(int[] val : dir){
            if(dfs(m,n,i+val[0],j+val[1],board,visited,word,index+1)) return true;
        }        
        visited[i][j] = false;
        return false;
    }
}
