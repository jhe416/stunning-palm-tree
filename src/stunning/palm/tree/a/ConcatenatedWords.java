package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * basically same as word break II, only difference is how you handle one special case:
 * when the whole word matches itself, you return true, but making sure the word is not added to the result
 * because a word itself is not a concatenate word.
 */
public class ConcatenatedWords {
    List<String> res = new ArrayList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words == null || words.length == 0) return new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        
        for(String word : words){
            if(dfs(word,dict,map)){
                res.add(word);
            }
        }
        
        return res;
    }
    
    private boolean dfs(String word, Set<String> dict, Map<String, Boolean> map){
        if(map.get(word) != null) return map.get(word);
        
        for(int i=1;i<word.length();i++){
            String subWord = word.substring(0,i);
            if(dict.contains(subWord) && (dict.contains(word.substring(i)) || dfs(word.substring(i),dict,map))){
                 map.put(word,true);
                 return true;
            }
        }
        
        map.put(word,false);
        return false;
    }
}
