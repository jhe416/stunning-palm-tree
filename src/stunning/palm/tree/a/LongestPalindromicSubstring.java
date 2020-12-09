package stunning.palm.tree.a;

/*
 * dp solution to build the longest palindrom
 * Time O(n*n)
 * Space O(N*N)
 */
public class LongestPalindromicSubstring {
	public LongestPalindromicSubstring() {}
	
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(i==j) dp[i][j] = true;
                else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i-j<2? true : dp[i-1][j+1];
                }else{
                    dp[i][j] = false;
                }
                
                if(dp[i][j] && i-j + 1 > res.length()){
                    res = s.substring(j,i+1);
                }
            }
        }
        
        return res;
    }
}
