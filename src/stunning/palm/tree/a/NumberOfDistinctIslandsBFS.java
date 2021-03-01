package stunning.palm.tree.a;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslandsBFS {
	public NumberOfDistinctIslandsBFS() {}
	
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int n;
    int m;
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        this.n = grid[0].length;
        this.m = grid.length;
        int res = 0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    if(set.add(bfs(i,j,grid))) res++;
                }
            }
        }
        
        return res;
    }
    
    private String bfs(int x, int y, int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> v = new LinkedList<>();
        q.offer(new int[]{x,y});
        v.offer(new int[]{0,0});
        grid[x][y] = 0;
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                int[] pos = q.poll();
                int[] start = v.poll();
                for(int z=0;z<dirs.length;z++){
                    int i = pos[0] + dirs[z][0];
                    int j = pos[1] + dirs[z][1];
                    int starti = start[0]+dirs[z][0];
                    int startj = start[1]+dirs[z][1];
                    if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) continue;
                    grid[i][j] = 0;
                    q.offer(new int[]{i,j});
                    v.offer(new int[]{starti,startj});
                    sb.append(starti).append(startj);
                }
            }
        }
        return sb.toString();
    }
}
