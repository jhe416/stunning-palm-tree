package stunning.palm.tree.f;

/*
 * dp, current index choose 1 or choose 2,  use previous dp values only the choice is a valid choice
 * 0x or 0 is not a valid choice
 * Time O(n)
 * space O(n)
 */
public class DecodeWays {
	public DecodeWays() {}
	
    public int numDecodingsSolOne(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
            int val1 = s.charAt(i) == '0'? 0 : dp[i-1];
            int two = s.charAt(i-1) == '0'? 0 : Integer.valueOf(s.substring(i-1,i+1));
            int val2 = two >=10 && two <=26 ? i-2>=0? dp[i-2] : 1 : 0;
            
            if(val1 == 0 && val1 == val2) return 0;
            dp[i] = val1 + val2;
        }
        
        return dp[s.length()-1];
    }
}
