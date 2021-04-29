package stunning.palm.tree.u;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CheckIfThereIsAValidPathInAGridBFS {
	public CheckIfThereIsAValidPathInAGridBFS() {}
	
    Map<Integer,Set<Integer>> map = new HashMap<>(){{
        put(1,new HashSet<>(Arrays.asList(1,3,5)));
        put(2,new HashSet<>(Arrays.asList(1,4,6)));
        put(3,new HashSet<>(Arrays.asList(2,3,4)));
        put(4,new HashSet<>(Arrays.asList(2,5,6)));
    }};
    
    //R L U D
    int[][][] dirs = {{{0,-1,2},{0,1,1}},{{-1,0,3},{1,0,4}},{{0,-1,2},{1,0,4}},{{1,0,4},{0,1,1}},{{-1,0,3},{0,-1,2}},{{-1,0,3},{0,1,1}}};
    public boolean hasValidPath(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1) return true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while(!q.isEmpty()){
            for(int z=q.size();z>0;z--){
                int[] pos = q.poll();
                for(int[] val : dirs[grid[pos[0]][pos[1]] - 1]){
                    int i = pos[0] + val[0], j = pos[1] + val[1];
                    if(i<0 || i==grid.length || j<0 || j==grid[0].length || visited[i][j]) continue;
                    if(!map.get(val[2]).contains(grid[i][j])) continue;
                    if(i == grid.length-1 && j == grid[0].length-1) return true;
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        
        return false;
    }
}
