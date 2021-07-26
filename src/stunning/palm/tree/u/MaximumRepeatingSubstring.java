package stunning.palm.tree.u;

/*
 * just add word..and see if sequence contains word or no
 * Time O(n) n being the sequence length
 * space O(n)
 * test3
 */
public class MaximumRepeatingSubstring {
	public MaximumRepeatingSubstring() {}
	
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        int count = 1;
        String key = word;
        while(word.length() <= sequence.length()){
            if(sequence.contains(word)){
                res = Math.max(res,count);
            }
            word+=key;
            count++;
        }
        
        return res;
    }
}
