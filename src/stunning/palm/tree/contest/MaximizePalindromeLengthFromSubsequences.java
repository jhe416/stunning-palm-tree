package stunning.palm.tree.contest;

/*
 * dp finding the max subsequence palindrome then validate the dp.
 * Time O(n2)
 * Space O(n)
 */
public class MaximizePalindromeLengthFromSubsequences {
	public MaximizePalindromeLengthFromSubsequences() {}
	
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int  n = s.length();
        
        int[][] dp = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(i-j < 2){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = i==j? 1 : 2;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i-1][j+1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
                    }
                }
            }
        }
        
        int res = 0; 
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(i) == s.charAt(j) && valid(j,i,word1,word2)){
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        
        return res;
    }
    
    private boolean valid(int s, int e, String word1, String word2){
        return s < word1.length() && e >= word1.length();
    }
}
