package stunning.palm.tree.contest;

/*
 * this is a really hard one, refer to below explanation:
 * https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/discuss/1032014/Well-Here's-the-catch
 * Time O(n)
 * Space constant
 */
public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
	public ChangeMinimumCharactersToSatisfyOneOfThreeConditions() {}
	
    public int minCharacters(String a, String b) {
        int res = Integer.MAX_VALUE;
        res = Math.min(res, Math.min(helper(a,b),helper(b,a)));
        
        int[] carr = new int[26];
        int max=0;
        for(int i=0; i<a.length() || i<b.length(); i++){
            if(i<a.length())carr[a.charAt(i) - 'a']++;
            if(i<b.length())carr[b.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++){
            max = Math.max(max,carr[i]);
        }
        
        res = Math.min(res, a.length()+b.length() - max);
        return res;
    }
    
    private int helper(String a, String b){
        int res = Integer.MAX_VALUE;
        for(char c = 'b';c<='z';c++){
            int count = 0;
            for(int i=0;i<a.length() || i<b.length();i++){
                char ca = i>=a.length()? 'a' : a.charAt(i);
                char cb = i>=b.length()? 'z' : b.charAt(i);
                if(ca >= c) count++;
                if(cb < c) count++;
            }
            res = Math.min(count,res);
        }
        return res;
    }
}
