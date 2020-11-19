package stunning.palm.tree.a;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time O(n^2)
 * space O(n^2)
 */
public class NumberOfIslandsBFS {
	public NumberOfIslandsBFS() {}
	
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if('1' == grid[i][j]){
                    grid[i][j] = '0';
                    q.offer(new int[]{i,j});
                    res++;
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k=0; k<size; k++){
                            int[] pos = q.poll();
                            int posi = pos[0], posj = pos[1];
                            for(int[] dir : dirs){                                
                                int newPosi = posi+dir[0], newPosj = posj+dir[1];
                                if(newPosi<0 || newPosi >= m || newPosj<0 || newPosj>=n || grid[newPosi][newPosj] == '0') continue;
                                if(grid[newPosi][newPosj] == '1'){
                                   grid[newPosi][newPosj] = '0';
                                    q.offer(new int[]{newPosi, newPosj});
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
