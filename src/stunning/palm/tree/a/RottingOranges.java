package stunning.palm.tree.a;

import java.util.LinkedList;
import java.util.Queue;

/*
 * bfs on the rotten ones, and only add the transformed fresh one into the q and continue the bfs
 * until the end
 * some corner cases need to handle:
 * 1. empty grid return 0;
 * 2. all rotten ones return 0;
 * 3. lastly after bfs there are still fresh ones left return -1;
 * Time O(n)
 * space O(n)
 */
public class RottingOranges {
	public RottingOranges() {}
	
	public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();//store rotting ones.
        boolean anyFresh = false; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1) anyFresh = true;
            }
        }
        if(!anyFresh && !q.isEmpty()) return 0;//all rotten ones.
        if(!anyFresh && q.isEmpty()) return 0;//empty grid
        
        int res = -1; //since is elapse time we start at -1
        while(!q.isEmpty()){
            res++;
            for(int k=q.size();k>0;k--){
                int[] pos = q.poll();
                int i = pos[0]; int j = pos[1];
                for(int[] dir : dirs){
                    int newi = i+dir[0]; int newj = j+dir[1];
                    if(newi<0||newi==m||newj<0||newj==n||grid[newi][newj]!=1) continue;
                    grid[newi][newj]=2;
                    q.offer(new int[]{newi, newj});
                }
            }
        }
        
        //lastly after bfs there are still fresh ones left return -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return res;
    }
}
