package stunning.palm.tree.contest;

public class MaximumLengthOfRepeatedSubarray {
	public MaximumLengthOfRepeatedSubarray() {}
	
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = nums2[i-1] == nums1[j-1]? dp[i-1][j-1] + 1 : 0;
                
                res = Math.max(res,dp[i][j]);
            }
        }
        
        return res;
    }
}
