package stunning.palm.tree.contest;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * using a priority queue to track the max dp[i] where dp[i] is the max score to get from index i to end
 * the two pointer j is to make sure that the max value in priority q val is still in the range
 * if q val is out of the range we poll the val out of the q until we find the next q max val that is in the range.
 * the q is sorted in a descending order.
 * Time O(nlog(n))
 * Space O(n)
 * 
 */
public class JumpGameVI {
	public JumpGameVI() {}
	
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[n-1] = nums[n-1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        q.offer(new int[]{n-1,dp[n-1]});
        int j = n-1;
        for(int i=n-2;i>=0;i--){
        	//first check if the top q val is valid, if is out of the range we will need to poll the value
        	//out of the q until the right val is found.
            while(j-i > k){
                q.poll();
                j = q.peek()[0];
            }
            dp[i] = nums[i] + q.peek()[1];
            q.offer(new int[]{i,dp[i]});
            
            j = q.peek()[0];
        }

        
        return dp[0];
    }
    
    public static void main(String[] args) {
    	JumpGameVI sol = new JumpGameVI();
    	sol.maxResult(new int[]{1,-1,-2,4,-7,3}, 2);
    }
}
