package stunning.palm.tree.a;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslandsDFS {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int n;
    int m;
    
    public NumberOfDistinctIslandsDFS() {}
    
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        this.n = grid[0].length;
        this.m = grid.length;
        int res = 0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    if(set.add(dfs(0,0,i,j,grid))) res++;
                }
            }
        }
        
        return res;
    }
    
    private String dfs(int x, int y, int i, int j, int[][] grid){
        if(i<0 || i==m || j<0 || j==n || grid[i][j] == 0) return "";
        String res = String.valueOf(x) + String.valueOf(y);
        grid[i][j] = 0;
        for(int[] dir : dirs){
            res+=dfs(x+dir[0],y+dir[1],i+dir[0],j+dir[1],grid);
        }
        
        return res;
    }
}
