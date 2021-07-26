package stunning.palm.tree.contest;

/*
 * refernece to the thread: https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344888/C%2B%2B-dp-from-O(m-*-n-*-n)-to-O(m-*-n)
 * Timr O(m*n)
 * space O(n)
 */
public class MaximumNumberOfPointsWithCost {
	public MaximumNumberOfPointsWithCost() {}
	
    public long maxPoints(int[][] points) {
        long res = 0;
        int n = points[0].length, m = points.length;
        long[] dp = new long[n];//previous row;
        for(int i=0;i<n;i++) dp[i] = points[0][i];
        
        for(int i=1;i<m;i++){
            long[] dpl = new long[n];
            long[] dpr = new long[n];
            dpl[0] = dp[0]; dpr[n-1]=dp[n-1];
            
            for(int j=1;j<n;j++){
                dpl[j] = Math.max(dpl[j-1]-1,dp[j]);
            }
            
            for(int j=n-2;j>=0;j--){
                dpr[j] = Math.max(dpr[j+1]-1,dp[j]);
            }
            
            for(int j=0;j<n;j++){
                dp[j] = points[i][j] + Math.max(dpr[j],dpl[j]);
            }
        }
        
        for(long val : dp){
            res = Math.max(val,res);
        }
        
        return res;
    }
}
