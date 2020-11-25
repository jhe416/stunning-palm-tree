package stunning.palm.tree.a;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * this is a bfs bidirection approach, bfs starts on beginWord and endWord, 
 * the q set alternates when one set is greater than the other we pick the smaller. This way we shrink the time complexity
 * as we can quickly reaching the same word formation for both q set. rather than form all combination words from beginning word.
 * the time complexity is now n/2 as we do not have to try out all the combination of the words formed from beginword.
 * Time O(n/2 * 26 *l) n is the number of words l is the length of word
 * space O(n/2)
 */
public class WordLadderBiDirectionalBFS {
	public WordLadderBiDirectionalBFS() {}
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return 0;
        Set<String> q1 = new HashSet<String>(){{
            add(beginWord);
        }};
        Set<String> q2 = new HashSet<String>(){{
            add(endWord);
        }};
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        int count = 1;
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.size() > q2.size()){
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            count++;
            HashSet<String> q = new HashSet<>();
            for(String word : q1){
                char[] charArray = word.toCharArray();
                for(int i=0;i<word.length();i++){
                    char save = charArray[i];
                    for(char c='a'; c<='z';c++){
                        if(save == c) continue;
                        charArray[i] = c;
                        String newWord = new String(charArray);
                        if(q2.contains(newWord)) return count;
                        if(dict.contains(newWord)){
                            dict.remove(newWord);
                            q.add(newWord);
                        }
                    }
                    charArray[i] = save;
                }
            }
            q1 = q;
        }
        
        return 0;
    }
}
