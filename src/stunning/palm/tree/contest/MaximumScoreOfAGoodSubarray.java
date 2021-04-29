package stunning.palm.tree.contest;

/*
 * divide into two array of 0...k and k...n
 * find each min on the two array 
 * now two pointer l and r
 * only increment l or r when the min of the 0...k and k...n increases 
 * TimeO(n)
 * Space O(n)
 */
public class MaximumScoreOfAGoodSubarray {
	public MaximumScoreOfAGoodSubarray() {}
	
    public int maximumScore(int[] nums, int k) {
        int n = nums.length; 
        int res = 0;
        int[] dp = new int[n];
        dp[k] = nums[k];
        for(int i=k-1;i>=0;i--){
            dp[i] = Math.min(dp[i+1],nums[i]);
        }
        
        for(int i=k+1;i<n;i++){
            dp[i] = Math.min(dp[i-1],nums[i]);
        }
        
        int l = 0, r = n - 1;
        int min = Math.min(dp[l],dp[r]);
        while(l<=k && r>=k){
            res = Math.max(res,min*(r-l+1));
            
            min = r-1>=k? Math.max(min,Math.min(dp[l],dp[r-1])) : min;
            min = l+1<=k? Math.max(min,Math.min(dp[l+1],dp[r])) : min;
            
            if(r-1 >= k && min == dp[r-1]) r--;
            else l++;          
        }
        
        return res;
    }
}
