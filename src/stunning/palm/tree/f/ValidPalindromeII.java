package stunning.palm.tree.f;

/*
 * first normal check if wrong found check again
 * Time O(n)
 * Space constant
 */
public class ValidPalindromeII {
	public ValidPalindromeII() {}
	
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int l=0, r=s.length()-1;
        
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return helper(l+1,r,s) || helper(l,r-1,s);
            }
        }
        
        return true;
    }
    
    private boolean helper(int s, int e, String str){
        while(s<e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        
        return true;
    }
}
