package stunning.palm.tree.a;

import java.util.Arrays;

/*
 * this question is a dp group question, the logic of dp is finding the previous day partition with 0 tp j
 * and finding the max after j since the order of the given array matters.
 * Time O(n^2d)
 * space O(n*d)
 * https://www.youtube.com/watch?v=6T6iK5nFKpg&ab_channel=HuifengGuan
 */
public class MinimumDifficultyOfAJobSchedule {
	public MinimumDifficultyOfAJobSchedule() {}
	
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty == null || jobDifficulty.length == 0 || d == 0) return 0;
        if(d > jobDifficulty.length) return -1;
        int[][] dp = new int[jobDifficulty.length+1][d+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }
        dp[0][0] = 0;
        
        for(int i=1;i<dp.length;i++){//number of tasks
            for(int j=1;j<=Math.min(d,i);j++){ //this is the day, day needs to be smaller than the tasks in order to partition.
                int max = jobDifficulty[i-1];
                for(int k=i; k>=j;k--){
                    max = Math.max(max,jobDifficulty[k-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[k-1][j-1] + max);
                }
            }
        }
        
        return dp[jobDifficulty.length][d];
    }
}
