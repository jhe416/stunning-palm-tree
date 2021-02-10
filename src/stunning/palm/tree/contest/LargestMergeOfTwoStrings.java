package stunning.palm.tree.contest;

/*
 * merge list with some twist 
 * Time O(n)
 * Space O(n)
 */
public class LargestMergeOfTwoStrings {
	public LargestMergeOfTwoStrings() {}
	
    public String largestMerge(String word1, String word2) {
        int w1 = 0, w2=0;
        StringBuilder sb = new StringBuilder();

        while(w1 < word1.length() && w2 < word2.length()){
            if(word1.charAt(w1) < word2.charAt(w2)){
                sb.append(word2.charAt(w2));
                w2++;
            }else if(word1.charAt(w1) > word2.charAt(w2)){
                sb.append(word1.charAt(w1));
                w1++;
            }else{
                String str1 = word1.substring(w1, word1.length());
                String str2 = word2.substring(w2, word2.length());
                
                if(str1.compareTo(str2) < 0){
                    sb.append(word2.charAt(w2));
                    w2++; 
                }else{
                    sb.append(word1.charAt(w1));
                    w1++;                    
                }
            }
        }
        
        while(w1 < word1.length()){
            sb.append(word1.charAt(w1));
            w1++;
        }
        
        while(w2 < word2.length()){
            sb.append(word2.charAt(w2));
            w2++;
        }
        
        return sb.toString();
    }
}
