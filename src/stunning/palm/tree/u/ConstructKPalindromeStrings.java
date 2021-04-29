package stunning.palm.tree.u;

/*
 * the key to this problem is that even char counts can form any number of k ranging from 1 to s.length();
 * but for odd number counts on a char, 1 Palindrome has to be formed plus all others formed by the evens(odd = even +1);
 * so all have to do here is making sure that the extra palindrome formed by the odd count characters can be covered by k
 * meaning the k has to be >= the odd counts.
 * Time O(n)
 * Space constant 
 */
public class ConstructKPalindromeStrings {
	public ConstructKPalindromeStrings() {}
	
    public boolean canConstruct(String s, int k) {
        if(s.length() == k) return true;
        if(s.length() < k) return false;
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        
        //evens can form any number of k, as long as k is within the range of s.
        //eg: aaa k=3? a, a, a, k=2? aa, a, k =1 a
        //but odd has to be formed by itself or two Palindrome, even + 1;
        //if all char has even count all 1 to s.length can be formed. to put it another way, all even counts can formed to 1 .
        //if odd counts exists odd counts must be <= k, after the first odd count, each odd results an extra palindrome (even+1); therefore as long as the addtional extra palindromes results from odd counts is <= k . then a k can be fromed. the rest can be formed by the remain even counts, as mentioned even ones can form all numbers from 1 to its length, with the existing odd ones evens can be add on top on them too.
        //for example when 1 odd, all even you can form min 1 Palindrome, when 2 odd, all even. you can form min 2 Palindrome (turning 1 odd to even results 1 single and the other odd + all even), when 3 odd all even you can form min 3 Palindrome  (turn 2 odds into 2 evens results two single palindrom + the other odd + all even)
        //as this example as long as the number of odds is <=k we are able to construct k palindromes using all chars in s.
        int count = 0;
        
        for(int i=0;i<26;i++){
            if(arr[i] % 2 == 1)count++;
        }
        return count <=k;
    }
}
