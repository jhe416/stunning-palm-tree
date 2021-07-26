package stunning.palm.tree.contest;

public class MaximumNumberOfWordsYouCanType {
	public MaximumNumberOfWordsYouCanType() {}
	
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int res = 0;
        outer: for(String word : arr){
            for(char c : brokenLetters.toCharArray()){
                if(word.contains(String.valueOf(c))) continue outer;
            }
            res++;
        }
        
        return res;
    }
}
