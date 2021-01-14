package stunning.palm.tree.f;

/*
 * checking each pair of string making sure then follow the order same like checking a increase order array
 * Time O(n)
 * space constant
 */
public class VerifyingAnAlienDictionary {
	public VerifyingAnAlienDictionary() {}
	
    public boolean isAlienSorted(String[] words, String order) {
        outer:
        for(int i=1;i<words.length;i++){
            String word2 = words[i];
            String word1 = words[i-1];
            int min = Math.min(word1.length(),word2.length());
            for(int j=0;j<min;j++){
                if(order.indexOf(word1.charAt(j)) > order.indexOf(word2.charAt(j))) return false;
                if(order.indexOf(word1.charAt(j)) < order.indexOf(word2.charAt(j))) continue outer;
            }
            
            if(word2.length() < word1.length()) return false;
        }
        
        return true;
    }
}
