package stunning.palm.tree.contest;

public class FindingZeroOnGridAndChangRowAndColToZero {
	public FindingZeroOnGridAndChangRowAndColToZero() {}
	
	public void solution(int[][] grid) {
		if(grid == null || grid.length == 0) return;
		boolean[] rows = new boolean[grid.length];
		boolean[] cols = new boolean[grid[0].length];
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(rows[i] || cols[j]) {
					grid[i][j] = 0;
				}
			}
		}
	}
}
