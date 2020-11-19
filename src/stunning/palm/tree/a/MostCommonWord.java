package stunning.palm.tree.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * filter the paragraph  remove all special chars. and then yup define a sort rule on the priority queue and go nuts
 * O(nlog(n)) space O(n)
 */
public class MostCommonWord {
	public MostCommonWord() {}
	
    public String mostCommonWord(String paragraph, String[] banned) {
        char[] carr = paragraph.toCharArray();
        for(int i=0;i<carr.length;i++) if(!Character.isLetter(carr[i])) carr[i] = ' ';
        paragraph = new String(carr);
        String[] words = paragraph.trim().split(" ");
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> (b.count-a.count));
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            String w = word.toLowerCase();
            if(w == null || w.length() == 0 || bannedWords.contains(w)) continue;
            map.put(w,map.getOrDefault(w,0)+1);
        }
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            q.offer(new Data(entry.getKey(),entry.getValue()));
        }
        
        return q.poll().word;
    }
    
    class Data{
        public String word;
        public Integer count;
        
        public Data(String word, Integer count){
            this.word = word;
            this.count = count;
        }
    }
}
