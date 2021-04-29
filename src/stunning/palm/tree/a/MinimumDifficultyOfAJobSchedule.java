package stunning.palm.tree.a;

import java.util.Arrays;

/*
 * this question is a dp group question, the logic of dp is finding the previous day partition with 0 to j
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
              //starting from the current task and going back to the last task that can be performed in the same day also all other remaining days can still perform at least 1 task
                for(int k=i; k>=j;k--){
                    max = Math.max(max,jobDifficulty[k-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[k-1][j-1] + max);
                }
            }
        }
        
        return dp[jobDifficulty.length][d];
    }
    
    public int minDifficultyMySol(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;
        int n = jobDifficulty.length;
        int[][] dp = new int[n][d];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=Math.min(i,d-1);j++){
                int max = jobDifficulty[i];
                for(int k=i;k>=j;k--){
                    max = Math.max(max,jobDifficulty[k]);
                    if(j==0){
                      dp[i][j] = Math.max(dp[i][j],max);  
                    }else{
                      dp[i][j] = dp[i][j] == 0? dp[k-1][j-1] + max : Math.min(dp[i][j], dp[k-1][j-1] + max);
                    }
                }
            }
        }
        
        return dp[n-1][d-1];
    }
    
    /*
     * if(d > jobDifficulty.length) return -1; since we already checked this
     * we just need to start j at i so that we starting at enough tasks to fill enough days save few loops
     * each day will always have enough to task to
     * Time O(d*n*d)
     * Space O(n*d)
     */
    public int minDifficultySolThree(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length) return -1;
        int[][] dp = new int[d][jobDifficulty.length];
        int m = dp.length;
        int n = dp[0].length;
        

        for(int i=0;i<m;i++){//days
            for(int j=i;j<n;j++){//tasks
                int max = jobDifficulty[j];
                for(int k=j;k>=i;k--){
                    max = Math.max(max,jobDifficulty[k]);
                    if(i == 0){
                        dp[i][j] = max;
                    }else{
                    	//look for the smallest previous day and previous tasks min + the current max
                        dp[i][j] = dp[i][j] == 0? dp[i-1][k-1] + max : Math.min(dp[i][j], dp[i-1][k-1] + max);
                    }
                }                   
            }
        }
        
        return dp[m-1][n-1];      
    }
}
