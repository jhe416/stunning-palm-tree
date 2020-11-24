package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * this is a classic nothing really to add..
 * 2 corner cases
 * handle when substring reaches the end
 * only add the word to empty combo if the recursion back from the end of the string
 */
public class WordBreakII {
	public WordBreakII() {}
	
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || wordDict.size() == 0) return new ArrayList<>();
        
        Map<String,List<String>> map = new HashMap<>(); //cache;
        map.put("",new ArrayList<>());
        return dfs(s,wordDict,map);
    }
    
    private List<String> dfs(String word, List<String> wordDict, Map<String,List<String>> map){
        if(map.containsKey(word)) return map.get(word);
        
        List<String> list = map.getOrDefault(word,new ArrayList<>());
        for(String dict : wordDict){
            if(word.startsWith(dict)){
                String key = word.substring(dict.length());
                List<String> combo = dfs(key,wordDict,map);
                
                if(combo == null || combo.isEmpty()){
                    if(key.isEmpty())list.add(dict);
                    continue;
                }
                for(String comboStr : combo){
                    list.add(dict + " " + comboStr);
                }
            }
        }
        map.putIfAbsent(word,list);
        return list;
    }
}
