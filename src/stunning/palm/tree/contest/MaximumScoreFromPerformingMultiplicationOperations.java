package stunning.palm.tree.contest;

/*
 * dfs dp, with a little twist to save memory
 * cannot initialize a full dp n^2 instand we need to intitialize a dp[m][m]
 * and calcualte the m index starting from both end, 0....n a b c d n ... 0
 * Time O(m^2)
 * Space O(m^2)
 */
public class MaximumScoreFromPerformingMultiplicationOperations {
	public MaximumScoreFromPerformingMultiplicationOperations() {}
	
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        this.dp = new Integer[m][m];
        return helper(0,n-1,0,multipliers,nums);
    }
    
    private int helper(int l, int r, int m, int[] multipliers, int[] nums){
        if(l>r || m>= multipliers.length) return 0;
        int i=l;
        int j=nums.length-r-1;
        if(dp[i][j] != null) return dp[i][j];

        int left = nums[l] * multipliers[m] + helper(l+1, r, m+1,multipliers,nums);
        int right = nums[r] * multipliers[m] + helper(l, r-1, m+1, multipliers,nums);
        
        dp[i][j] = Math.max(left,right);
        
        return dp[i][j];
    }
}
