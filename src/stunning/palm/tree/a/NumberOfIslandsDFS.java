package stunning.palm.tree.a;

/*
 * Time O(n^2)
 * Space O(n^2)
 */
public class NumberOfIslandsDFS {
	public NumberOfIslandsDFS() {}
	
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid[0].length;
        int m = grid.length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(m,n,i,j,grid);
                }
            }
        }
        
        return res;
    }
    
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(int m, int n, int i, int j, char[][] grid){
        if(i<0||i==m||j<0||j==n||grid[i][j] != '1') return;
        grid[i][j] = '0';
        
        for(int[] val : dir){
            dfs(m,n,i+val[0],j+val[1],grid);
        }
    }
}
