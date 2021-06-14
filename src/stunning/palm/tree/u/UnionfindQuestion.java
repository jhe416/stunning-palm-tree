package stunning.palm.tree.u;

import java.util.Arrays;

public class UnionfindQuestion {
	public UnionfindQuestion() {}
	int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
	
	public int solution(int[][] grid, int x, int y) {
		int m = grid.length;
		int n = grid[0].length;
		int[] arr = new int[n*m];
		Arrays.fill(arr, -1);
		int count = 0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == 1) {
					int root = i*n + j;
					if(arr[root] != -1) continue;
					arr[root] = root;
					count++;
					for(int[] dir : dirs) {
						int newi = i + dir[0];
						int newj = j + dir[1];
						int newRoot = newi*n+newj;
						if(newi<0 || newi==m || newj<0 || newj == n || arr[newRoot] == -1) continue;
						newRoot = find(arr,newi*n+newj);
						if(newRoot != root) {
							arr[root] = newRoot;
							root = newRoot;
							count--;							
						}
					}
				}
			}
		}
		
		//now a given point of x and y can change 0 to 1
		if(grid[y][x] == 1) return count;
		count++;
		int i=y, j=x;
		arr[i*n+j] = i*n+j;
		int root = i*n+j;
		for(int[] dir : dirs) {
			int newi = i + dir[0];
			int newj = j + dir[1];
			if(newi<0 || newi==m || newj<0 || newj == n || arr[newi*n+newj] == -1) continue;
			int newRoot = find(arr,newi*n+newj);
			
			//union
			if(newRoot != root) {
				arr[i*n + j] = newRoot;
				root = newRoot;
				count--;					
			}	
		}
		
		return count;
	}
	
	private int find(int[] arr, int val) {
		if(arr[val] == val) return val;
		return find(arr,arr[val]);
	}
	
	public static void main(String[] args) {
		//0011
		//1100
		//0011
		int[][] graph = {{0,0,1,1},{1,1,0,0},{0,0,1,1}};
		UnionfindQuestion sol = new UnionfindQuestion();
		System.out.print(sol.solution(graph,0,0));
	}
}
