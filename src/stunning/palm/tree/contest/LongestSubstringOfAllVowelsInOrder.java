package stunning.palm.tree.contest;

/*
 * two pointer, i resets when j is not following the arr order
 * Time O(n)
 */
public class LongestSubstringOfAllVowelsInOrder {
	public LongestSubstringOfAllVowelsInOrder() {}
	
    public int longestBeautifulSubstring(String word) {
        char[] arr = {'z','a', 'e', 'i', 'o', 'u'};
        int i=0, p=0, res=0;
        for(int j=0;j<word.length();j++){
            if(word.charAt(j) != arr[p] && (p+1 == arr.length || word.charAt(j) != arr[p+1])){ 
                i= word.charAt(j) == 'a'? j : j+1;
                p= word.charAt(j) == 'a'? 1 : 0;
            }else if(p+1<arr.length && word.charAt(j) == arr[p+1]){
                p++;
            }
            if(p == 5) res = Math.max(res,j-i+1);
        }
        
        return res;
    }
}
