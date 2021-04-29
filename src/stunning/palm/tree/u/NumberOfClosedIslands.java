package stunning.palm.tree.u;

/*
 * starting from 0 see if 0 and all neighbours are around the water.
 * return true if is 1 or is visited
 * Time O(n)
 * Space constant
 */
public class NumberOfClosedIslands {
	public NumberOfClosedIslands(){}
	
    public int closedIsland(int[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    if(dfs(grid,i,j)) res++;
                }
            }
        }
        
        return res;
    }
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean dfs(int[][] grid, int i, int j){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length) return false;
        if(grid[i][j] == 1 || grid[i][j] == 2) return true;
        grid[i][j] = 2;
        
        boolean res = true;
        for(int[] dir : dirs){
            res = res & dfs(grid,i+dir[0],j+dir[1]);
        }
        
        return res;
    }
}
