package stunning.palm.tree.contest;

/*
 * this solution follows merge sort pattern, increases index when one string is smaller than the other
 * stringbuilder resets when a equal string is found
 * return true when both string reaches to the end
 * return false other wise
 * TIme O(n)
 * Space O(k) k as the longest string in the given arrays.
 * 
 */
public class CheckIfTwoStringArraysAreEquivalent {
	public CheckIfTwoStringArraysAreEquivalent() {}
	
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1 = 0, index2 = 0;
        StringBuilder w1 = new StringBuilder(word1[index1]);
        StringBuilder w2 = new StringBuilder(word2[index2]);
        while(index1 < word1.length && index2 < word2.length){
            if(w1.length() < w2.length()){
                if(index1+1 == word1.length) return false;
                w1.append(word1[++index1]);
            }else if(w1.length() > w2.length()){
                if(index2+1 == word2.length) return false;
                w2.append(word2[++index2]);
            }else if(w1.toString().equals(w2.toString())){
                if(index1 + 1 == word1.length && index2 + 1 == word2.length) return true;
                if(index1 + 1 == word1.length || index2 + 1 == word2.length) return false;
                w1.setLength(0); w2.setLength(0);
                w1 = w1.append(word1[++index1]);
                w2 = w2.append(word2[++index2]);
            }else{
                return false;
            }
        }
        
        return false;
    }
}
