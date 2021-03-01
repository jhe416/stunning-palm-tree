package stunning.palm.tree.f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * map all existing islands to a id that is greater than 1
 * then connect islands on each '0' if is able to
 * Time O(n^2) or O(n) n being the total size of the 2d matrix
 * Space O(n^2) or O(N) ''
 */
public class MakingALargeIsland {
	public MakingALargeIsland() {}
	
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int res = 0;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer,Integer> map = new HashMap<>();
        int id = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 || grid[i][j]>1) continue;
                map.put(id,dfs(n,i,j,grid,id));
                id++;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    Set<Integer> visited = new HashSet<>();
                    int sum = 0;
                    for(int[] dir : dirs){
                        int x = i+dir[0], y = j+dir[1];
                        if(x==n || x< 0 || y==n || y<0)continue;
                        int key = grid[x][y];
                        if(key >1 && visited.add(key)){
                            sum+=map.get(key);
                        }
                    }
                    res = Math.max(res, sum+1);
                }
            }
        }
        
        return res==0? n*n : res;
    }
    
    private int dfs(int n, int i, int j, int[][] grid, int id){
        if(i==n || i< 0 || j==n || j<0 || grid[i][j] == 0 || grid[i][j] == id) return 0;
        int count = 1;
        grid[i][j] = id;
        for(int[] dir : dirs){
            count +=dfs(n,i+dir[0],j+dir[1],grid,id);
        }

        return count;
    }
}
