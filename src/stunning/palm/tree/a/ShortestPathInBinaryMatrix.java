package stunning.palm.tree.a;

import java.util.LinkedList;
import java.util.Queue;

/*
 * bfs and let the bfs expand until the distance is found.
 * Time O(n)
 * Space O(n)
 */
public class ShortestPathInBinaryMatrix {
	public ShortestPathInBinaryMatrix() {}

	public int shortestPathBinaryMatrix(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0][0] == 1) return -1;
		int m = grid.length; 
		int n = grid[0].length;
		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,0});
		int res=0;

		while(!q.isEmpty()){
			res++;
			for(int k=q.size();k>0;k--){
				int[] pos = q.poll();
				int i = pos[0];
				int j = pos[1];
				if(i == m-1 && j == n-1) return res;
				for(int[] dir : dirs){
					int newi = i + dir[0];
					int newj = j + dir[1];
					if(newi < 0 || newi == m || newj < 0 || newj == n || grid[newi][newj] == 1) continue;
					grid[newi][newj] = 1;
					q.offer(new int[]{newi, newj});
				}
			}
		}

		return -1;
	}
}
