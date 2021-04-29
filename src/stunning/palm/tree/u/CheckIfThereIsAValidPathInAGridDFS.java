package stunning.palm.tree.u;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfThereIsAValidPathInAGridDFS {
	public CheckIfThereIsAValidPathInAGridDFS() {}
	
    public boolean hasValidPath(int[][] grid) {
        return dfs(grid,0,0,null);
    }	
    private boolean dfs(int[][] grid, int i, int j, String key){
        if(i<0 || i == grid.length || j<0 || grid[0].length == j || grid[i][j] == 7) return false;
        if(map.containsKey(key) && !map.get(key).contains(grid[i][j])) return false;
        if(i==grid.length-1 && j==grid[0].length-1) return true;
        int val = grid[i][j];
        grid[i][j] = 7;
        
        if(val == 1){
            return dfs(grid,i,j+1,"R") || dfs(grid,i,j-1,"L");
        }else if(val == 2){
            return dfs(grid,i-1,j,"U") || dfs(grid,i+1,j,"D");
        }else if(val == 3){
            return dfs(grid,i,j-1,"L") || dfs(grid,i+1,j,"D");
        }else if(val == 4){
            return dfs(grid,i,j+1,"R") || dfs(grid,i+1,j,"D");
        }else if(val == 5){
            return dfs(grid,i,j-1,"L") || dfs(grid,i-1,j,"U");
        }else{
            return dfs(grid,i,j+1,"R") || dfs(grid,i-1,j,"U");
        }
    }
    
    Map<String,Set<Integer>> map = new HashMap<>(){{
        put("R",new HashSet<>(Arrays.asList(1,3,5)));
        put("L",new HashSet<>(Arrays.asList(1,4,6)));
        put("U",new HashSet<>(Arrays.asList(2,3,4)));
        put("D",new HashSet<>(Arrays.asList(2,5,6)));
    }};
}
