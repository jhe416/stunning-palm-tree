package stunning.palm.tree.a;

/*
 * first find the first non a in the palindrome loop and change to a to obtain the smallest lexi order
 * if all chars are 'a' for example aaaaaacaaaaaa, this is a special case all we need to do is change the last one to 'b'
 * to obtain the smallest lexi order as long as the palindrome length is greater than 1
 * 
 * Time O(n)
 * space constant
 */
public class BreakAPalindrome {
	public BreakAPalindrome() {}

	public String breakPalindrome(String palindrome) {
		char[] arr = palindrome.toCharArray();
		int l = 0, r = arr.length-1;
		while(l<r){
			if(arr[l] == 'a'){
				l++;
				r--;
				continue;
			}
			arr[l] = 'a';
			return new String(arr);
		}
		if(arr.length > 1){
			arr[arr.length-1] = 'b';
			return new String(arr);
		}   
		return "";
	}
}
