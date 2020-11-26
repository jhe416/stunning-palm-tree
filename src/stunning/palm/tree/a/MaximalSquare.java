package stunning.palm.tree.a;

/*
 * dynamic programming by finding the sub area and using the area we know the square edge length by apply sqrt
 * the min are will be used to form a new sqaure if i-1,j i-1,j-1 and i,j-1 all has a value then we have enough 1s to form square
 * 
 * same logic also applys to just store the minimal edge length instead of calculating the area.
 * Time O(n) space O(n)
 * 
 */
public class MaximalSquare {
	public MaximalSquare() {}
	
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        int res = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '0'){
                    dp[i][j] = 0;
                }else{
                    if(dp[i][j-1] !=0 && dp[i-1][j] !=0 && dp[i-1][j-1] !=0){
                        int val = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1],dp[i-1][j]));
                        val = (int)Math.sqrt(val)+1;
                        dp[i][j] = val*val;
                    }else{
                        dp[i][j] = 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        
        return res;
    }
}
