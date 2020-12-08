package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * sort the word as the key and then add to the map.
 * O(nlog(m))
 * space O(n)
 */
public class GroupAnagrams {
	public GroupAnagrams() {}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String word : strs){
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.putIfAbsent(key, list);
        }
        
        return new ArrayList<>(map.values());
    }
}
