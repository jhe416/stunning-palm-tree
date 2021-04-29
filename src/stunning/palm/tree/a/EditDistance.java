package stunning.palm.tree.a;

public class EditDistance {
	public EditDistance() {}
	
    public int minDistance(String word1, String word2) { 
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=n;i++) dp[0][i] = i;
        for(int i=1;i<=m;i++) dp[i][0] = i;
        dp[0][0] = 0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int val1 = dp[i-1][j-1], val2 = dp[i-1][j], val3 = dp[i][j-1];
                
                dp[i][j] = Math.min(word1.charAt(i-1) == word2.charAt(j-1)? val1 : val1+1,Math.min(val2+1,val3+1));
            }
        }
        
        return dp[m][n];
    }
}
