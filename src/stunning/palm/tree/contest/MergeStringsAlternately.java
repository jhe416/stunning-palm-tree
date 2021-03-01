package stunning.palm.tree.contest;

public class MergeStringsAlternately {
	public MergeStringsAlternately() {}
	
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        
        int index1 = 0, index2 = 0;
        boolean first = true;
        while(index1 < word1.length() && index2 < word2.length()){
            if(first){
                sb.append(word1.charAt(index1++));
            }else{
                sb.append(word2.charAt(index2++));
            }
            
            first = !first;
        }
        
        if(index1 < word1.length()){
            sb.append(word1.substring(index1, word1.length()));
        }
        
        if(index2 < word2.length()){
            sb.append(word2.substring(index2, word2.length()));
        }
        
        return sb.toString();
    }
}
