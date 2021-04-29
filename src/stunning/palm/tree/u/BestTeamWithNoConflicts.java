package stunning.palm.tree.u;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
	public BestTeamWithNoConflicts() {}

	public int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++){
			arr[i] = new int[]{ages[i],scores[i]};
		}

		Arrays.sort(arr,(a,b) -> (a[0] == b[0]? a[1]-b[1] : a[0] - b[0]));
		int[] dp = new int[n]; //max score for player at until i;
				dp[0] = arr[0][1];
				int res = dp[0];
				for(int i=1;i<n;i++){
					dp[i] = arr[i][1];
					for(int j=i-1;j>=0;j--){
						if(arr[j][1] <= arr[i][1]){
							dp[i] = Math.max(dp[i],dp[j] + arr[i][1]);
						}
					}
					res = Math.max(res,dp[i]);
				}

				return res;
	}
}
