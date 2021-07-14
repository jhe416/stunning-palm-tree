package stunning.palm.tree.contest;

import java.util.*;
/*
 * dp find the number that is smaller than the current i going back then add that longest subsequence +1 to i
 * Time O(n^2)
 * space O(n)
 */
public class LongestIncreasingSubsequence {
	public LongestIncreasingSubsequence() {}
	
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=1;
        int res = 1;
        for(int i=1;i<dp.length;i++){
            dp[i] = 1;
            for(int j=i;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
    
    public int lengthOfLISBST(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int res = 0;
        for(int val : nums){
            int index = Arrays.binarySearch(dp,0,dp.length,val);
            if(index < 0) index = (-index) - 1;
            dp[index] = val;
            if(index == res) res++;
        }
        return res;
    }
}
