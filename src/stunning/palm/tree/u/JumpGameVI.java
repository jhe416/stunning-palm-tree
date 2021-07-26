package stunning.palm.tree.u;

import java.util.Arrays;
import java.util.PriorityQueue;
//JumpGameVI

//test2
public class JumpGameVI {
	public JumpGameVI() {}
	
	//first understand this part. this dp solution will result a TLE
    public int maxResultTLE(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<=i+k && j<nums.length; j++){
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
            }
        }
        
        return dp[0];
    }
    
    /*
     * what happen to this is that we use a heap to store the max dp to jump to
     * before jump i to the max in the heap we make sure that the max in the heap in within the range of k
     * Time o(nlogn)
     * Space constant
     */
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        q.offer(new int[]{nums.length-1,dp[nums.length-1]});
        
        for(int i=nums.length-2;i>=0;i--){
            while(q.peek()[0]-i > k){
                q.poll();
            }
            
            dp[i] = nums[i] + q.peek()[1];
            q.offer(new int[]{i,dp[i]});
        }
        
        return dp[0];
    }
}
