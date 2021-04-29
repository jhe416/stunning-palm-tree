package stunning.palm.tree.u;

/*
 * 这个视频讲的太优秀
 * https://www.youtube.com/watch?v=X3WrZG08ns8
 * Time O(n), Space O(n)
 */
public class BombEnemy {
	public BombEnemy() {}

	public int maxKilledEnemies(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int m = grid.length, n=grid[0].length;

		int res = 0;
		int[] col = new int[n];

		//用dp 记录左边和上面的炸弹数量
		for(int i=0;i<m;i++){
			int row=0;
			for(int j=0;j<n;j++){
				if(grid[i][j] == '0'){

					int total = row+col[j];

					//向右走
					for(int k=j+1;k<n && grid[i][k] != 'W';k++){
						if(grid[i][k] == 'E') total++;
					}

					//向下走
					for(int k=i+1;k<m && grid[k][j] != 'W';k++){
						if(grid[k][j] == 'E') total++;
					}
					res = Math.max(res,total);
				}
				else if(grid[i][j] == 'E'){
					row++;
					col[j]++;
				}else{
					row = 0;
					col[j]=0;
				}
			}
		}

		return res;
	}
}
