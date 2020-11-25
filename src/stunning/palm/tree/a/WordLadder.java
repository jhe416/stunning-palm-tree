package stunning.palm.tree.a;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * a BFS solution where time is O(26*l*n) l is the length of the word n is the number of the word
 * space O(N)
 */
public class WordLadder {
	public WordLadder() {}
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {   
        if(wordList == null || wordList.size() == 0) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        q.offer(beginWord);
        int count = 0;
        
        while(!q.isEmpty()){
            count++;
            for(int i=q.size();i>0;i--){
                String word = q.poll();
                if(word.equals(endWord)) return count;
                char[] charArray = word.toCharArray();
                for(int j=0;j<charArray.length;j++){
                    char save = charArray[j];
                    for(char c='a';c<='z';c++){
                        if(c == save) continue;
                        charArray[j] = c;
                        String newWord = new String(charArray);
                        if(dict.contains(newWord)){
                            q.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                    charArray[j]=save;
                }        
            }
        }
        
        return 0;
    }
}
